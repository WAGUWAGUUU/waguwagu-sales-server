package com.example.sales.service;


import com.example.sales.global.dto.GetSalesByMonthResponse;
import com.example.sales.global.entity.SalesEmailSender;
import com.example.sales.global.entity.TotalSalesPerMonth;
import com.example.sales.global.repository.TotalSalesPerDayRepository;
import com.example.sales.global.repository.TotalSalesPerMonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final TotalSalesPerMonthRepository totalSalesPerMonthRepository;
    private final TotalSalesPerDayRepository totalSalesPerDayRepository;
    private final TotalSalesPerDayService totalSalesPerDayService;
    private final SalesEmailSender salesEmailSender;


    // 마지막달 11:59 에 측정
//    @Scheduled(cron = "0 59 23 L * ?")
    // 매달 1일 전의 달 측정
//    @Scheduled(cron = "0 0 0 1 * *")
    @Scheduled(cron = "* * * * * *")
    public void run() {
        LocalDate temp = LocalDate.now().minusMonths(1);
        YearMonth month = YearMonth.from(temp);
        LocalDate firstDate = month.atDay(1); // month의 첫째날

//        List<Long> totalStoreId = totalSalesPerDayService.getTotalStoreId();
//        for(Long storeId: totalStoreId) {
//            int totalSalesByMonth = totalSalesPerDayService.getTotalSalesByMonth(storeId, firstDate);
//            System.out.println(totalSalesByMonth);
//            totalSalesPerMonthRepository.save(new TotalSalesPerMonth(storeId,firstDate,totalSalesByMonth));
//            try {
//                salesEmailSender.emailSender(localDate.getMonthValue(),STORE_EMAIL,totalSalesByMonth);
//                System.out.println("월별 통계 이메일 보냄");
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
        List<GetSalesByMonthResponse> objects = totalSalesPerDayRepository.monthForSales(firstDate);
        for (GetSalesByMonthResponse row : objects) {
            totalSalesPerMonthRepository.save(new TotalSalesPerMonth(row.getStoreId(), row.getDate(), row.getMonthlySales()));
            try {
                salesEmailSender.emailSender(row.getStoreName(),temp.getMonthValue(), row.getOwnerEmail(), row.getMonthlySales());
                System.out.println("월별 통계 이메일 보냄");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
