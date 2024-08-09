package com.example.sales.global.repository;

import com.example.sales.global.entity.TotalSalesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalSalesPerMonthRepository extends JpaRepository<TotalSalesPerDay, Long> {
}
