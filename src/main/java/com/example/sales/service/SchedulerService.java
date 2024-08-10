package com.example.sales.service;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.entity.TotalSalesPerMonth;
import com.example.sales.global.repository.TotalSalesPerMonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final TotalSalesPerMonthRepository totalSalesPerMonthRepository;
    private final TotalSalesPerDayService totalSalesPerDayService;
    // 마지막달 11:59 에 측정
//    @Scheduled(cron = "0 59 23 L * ?")
    // 매달 1일 전의 달 측정
//    @Scheduled(cron = "0 0 0 1 * *")
    @Scheduled(cron = "0 * * * * *")
    public void run() {
        LocalDate localDate = LocalDate.now().minusMonths(2);
        YearMonth month = YearMonth.from(localDate);
        LocalDate firstDate = month.atDay(1); // month의 첫째날

        System.out.println(localDate);
        List<Long> totalStoreId = totalSalesPerDayService.getTotalStoreId();
        for(Long storeId: totalStoreId) {
            int totalSalesByMonth = totalSalesPerDayService.getTotalSalesByMonth(storeId, firstDate);
            System.out.println(totalSalesByMonth);
            totalSalesPerMonthRepository.save(new TotalSalesPerMonth(storeId,localDate,totalSalesByMonth));
        }
    }
}
