package com.example.sales.service;

import com.example.sales.global.dto.SalesByDayResponse;
import com.example.sales.global.dto.TotalSalesPerDayRequest;
import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.kafka.KafkaSalesDTO;
import com.example.sales.global.kafka.KafkaStatus;
import com.example.sales.global.repository.TotalSalesPerDayRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TotalSalesPerDayServiceImpl implements TotalSalesPerDayService {
    private final TotalSalesPerDayRepository totalSalesPerDayRepository;

    @KafkaListener(topics = "store-income-topic")
    @Override
    public void createTotalSalesPerDay(KafkaStatus<KafkaSalesDTO> kafkaStatus) {
        if(kafkaStatus.status().equals("insert")) {
            Long storeId = kafkaStatus.data().storeId();
            LocalDate localDate = kafkaStatus.data().time().toLocalDateTime().toLocalDate();
            // (총 판매금액 - 배달비) * 0.8 의 수익 가져감
            int sales = (int) (kafkaStatus.data().sales()*0.8);
            Optional<TotalSalesPerDay> byTotalSalesPerDayDate = totalSalesPerDayRepository.findByStoreIdAndDate(storeId,localDate);
            if(byTotalSalesPerDayDate.isEmpty()){
                totalSalesPerDayRepository.save(new TotalSalesPerDay(storeId,localDate,sales));
            } else {
                byTotalSalesPerDayDate.get().plusSales(sales);
            }
        }
    }

    // 매출에 있는 모든 가게 id 측정
    @Override
    public List<Long> getTotalStoreId() {
        List<Long> allStoreId = new ArrayList<>();
        List<TotalSalesPerDay> all = totalSalesPerDayRepository.findAll();

        for(TotalSalesPerDay day:all) {
            if(!allStoreId.contains(day.getStoreId())){
                allStoreId.add(day.getStoreId());
            }
        }
        return allStoreId;
    }

    // 가게 별, month 별 totalSales 측정
    @Override
    public int getTotalSalesByMonth(Long storeId, LocalDate localDate) {
        int totalSalesByMonth = 0;
        YearMonth month = YearMonth.from(localDate);
        LocalDate firstDate = month.atDay(1);
        LocalDate lastDate = month.atEndOfMonth();
        List<TotalSalesPerDay> allByStoreIdAndDateBetween = totalSalesPerDayRepository.findAllByStoreIdAndDateBetween(storeId, firstDate, lastDate);
        for (TotalSalesPerDay totalSalesPerDay : allByStoreIdAndDateBetween) {
            totalSalesByMonth += totalSalesPerDay.getDailySales();
        }
        return totalSalesByMonth;
    }

    // 원하는 연월에 맞는 daily sales 가져오기
    @Override
    public List<SalesByDayResponse> getSalesByMonth(Long storeId, int year, int month) {
        List<SalesByDayResponse> result = new ArrayList<>();
        List<TotalSalesPerDay> allByStoreId = totalSalesPerDayRepository.findAllByStoreId(storeId);
        // 원하는 연도와 월 설정
        LocalDate localDate = LocalDate.of(year, month, 1);
        YearMonth yearMonth = YearMonth.from(localDate);
        // 원하는 연도와 월에 맞는 데이터 가져오기
        for(TotalSalesPerDay day : allByStoreId) {
            YearMonth from = YearMonth.from(day.getDate());
            if(from.equals(yearMonth))
                result.add(SalesByDayResponse.from(day));
        }
        Collections.sort(result);
        return result;
    }
}
