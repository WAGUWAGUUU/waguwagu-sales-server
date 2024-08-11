package com.example.sales.service;

import java.util.List;

public interface TotalSalesPerMonthService {
    List<Integer> getYearsByStoreId(Long storeId);
}
