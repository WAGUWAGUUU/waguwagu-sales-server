package com.example.sales.global.dto;

import com.example.sales.global.entity.TotalSalesPerDay;

import java.time.LocalDate;

public record TotalSalesPerDayRequest(Long storeId, LocalDate date, int dailySales) {
    public TotalSalesPerDay toEntity() {
        return TotalSalesPerDay.builder()
                .storeId(storeId)
                .date(date)
                .dailySales(dailySales)
                .build();
    }
}
