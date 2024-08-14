package com.example.sales.global.dto;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.entity.TotalSalesPerMonth;

import java.time.LocalDate;

public record SalesByDayResponse(LocalDate date, int sales) implements Comparable<SalesByDayResponse> {
    public static SalesByDayResponse from(TotalSalesPerDay totalSalesPerDay) {
        return new SalesByDayResponse(totalSalesPerDay.getDate(), totalSalesPerDay.getDailySales());
    }

    @Override
    public int compareTo(SalesByDayResponse s) {
        if(this.date.isAfter(s.date)) {
            return 1;
        } else if(this.date.isBefore(s.date)) {
            return -1;
        } else {
            return 0;
        }
    }
}
