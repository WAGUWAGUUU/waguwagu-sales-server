package com.example.sales.service;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.entity.TotalSalesPerMonth;
import com.example.sales.global.kafka.KafkaSalesDTO;
import com.example.sales.global.kafka.KafkaStatus;
import com.example.sales.global.repository.TotalSalesPerDayRepository;
import com.example.sales.global.repository.TotalSalesPerMonthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TotalSalesPerMonthServiceImpl implements TotalSalesPerMonthService{
    private final TotalSalesPerMonthRepository totalSalesPerMonthRepository;


    @Override
    public List<Integer> getYearsByStoreId(Long storeId) {
        List<Integer> years = new ArrayList<>();
        List<TotalSalesPerMonth> allByStoreId = totalSalesPerMonthRepository.findAllByStoreId(storeId);
        for(TotalSalesPerMonth sales : allByStoreId) {
            Integer year = sales.getMonth().getYear();
            if(!years.contains(year)) {
                years.add(year);
            }
        }
        return years;
    }
}
