package com.example.sales.global.repository;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.entity.TotalSalesPerMonth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalSalesPerMonthRepository extends JpaRepository<TotalSalesPerMonth, Long> {
    List<TotalSalesPerMonth> findAllByStoreId(Long StoreId);
}
