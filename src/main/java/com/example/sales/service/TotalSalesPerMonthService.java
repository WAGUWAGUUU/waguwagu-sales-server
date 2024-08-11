package com.example.sales.service;

import com.example.sales.global.dto.SalesByYearResponse;

import java.util.List;

public interface TotalSalesPerMonthService {
    List<Integer> getYearsByStoreId(Long storeId);

    List<SalesByYearResponse> getSalesByYear(Long storeId, int year);
}
