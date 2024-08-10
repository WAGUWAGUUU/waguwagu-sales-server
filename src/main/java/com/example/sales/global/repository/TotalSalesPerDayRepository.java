package com.example.sales.global.repository;

import com.example.sales.global.entity.TotalSalesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TotalSalesPerDayRepository extends JpaRepository<TotalSalesPerDay, Long> {
    Optional<TotalSalesPerDay> findByStoreIdAndDate(Long storeId, LocalDate localDate);

    List<TotalSalesPerDay> findAllByStoreIdAndDateBetween(Long storeId, LocalDate start, LocalDate end);




}
