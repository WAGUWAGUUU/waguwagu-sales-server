package com.example.sales.global.dto;

import com.example.sales.global.entity.TotalSalesPerMonth;
import org.springframework.data.repository.query.Param;

public record SalesByYearResponse(int month, int sales) implements Comparable<SalesByYearResponse> {
    public static SalesByYearResponse from(TotalSalesPerMonth totalSalesPerMonth) {
        return new SalesByYearResponse(totalSalesPerMonth.getMonth().getMonthValue(), totalSalesPerMonth.getMonthSales());
    }

    @Override
    public int compareTo(SalesByYearResponse s) {
        return Integer.compare(this.month, s.month);
    }
}
