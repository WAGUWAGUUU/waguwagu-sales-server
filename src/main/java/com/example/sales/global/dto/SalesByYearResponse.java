package com.example.sales.global.dto;

import com.example.sales.global.entity.TotalSalesPerMonth;
import org.springframework.data.repository.query.Param;

// 연도에 따른 모든 달에 따른 sales 가져오기
public record SalesByYearResponse(int month, Long sales) implements Comparable<SalesByYearResponse> {
    public static SalesByYearResponse from(TotalSalesPerMonth totalSalesPerMonth) {
        return new SalesByYearResponse(totalSalesPerMonth.getMonth().getMonthValue(), totalSalesPerMonth.getMonthlySales());
    }

    @Override
    public int compareTo(SalesByYearResponse s) {
        return Integer.compare(this.month,s.month);
    }
}
