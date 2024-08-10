package com.example.sales.global.repository;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.entity.TotalSalesPerMonth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalSalesPerMonthRepository extends JpaRepository<TotalSalesPerMonth, Long> {
}
