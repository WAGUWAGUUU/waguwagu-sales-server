package com.example.sales.global.repository;

import com.example.sales.global.entity.TotalSalesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalSalesPerDayRepository extends JpaRepository<TotalSalesPerDay, Long> {
}
