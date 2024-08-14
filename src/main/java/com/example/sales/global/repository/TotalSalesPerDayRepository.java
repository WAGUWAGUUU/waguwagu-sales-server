package com.example.sales.global.repository;

import com.example.sales.global.dto.GetSalesByMonthResponse;
import com.example.sales.global.entity.TotalSalesPerDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TotalSalesPerDayRepository extends JpaRepository<TotalSalesPerDay, Long> {
    Optional<TotalSalesPerDay> findByStoreIdAndDate(Long storeId, LocalDate localDate);

    List<TotalSalesPerDay> findAllByStoreIdAndDateBetween(Long storeId, LocalDate start, LocalDate end);

    List<TotalSalesPerDay> findAllByStoreId(Long storeId);
    @Query("SELECT s.storeId storeId, " +
            "s.storeName storeName, " +
            "o.ownerEmail ownerEmail, " +
            "FUNCTION('DATE_FORMAT', t.date, '%Y-%m-01') date, " +
            "SUM(t.dailySales) monthlySales " +
            "FROM Store s " +
            "JOIN Owner o ON s.owner.ownerId = o.ownerId " +
            "JOIN TotalSalesPerDay t ON t.storeId = s.storeId " +
            "WHERE FUNCTION('DATE_FORMAT', t.date, '%Y-%m-01') = :yearMonth " +
            "GROUP BY s.storeId, FUNCTION('DATE_FORMAT', t.date, '%Y-%m-01') " +
            "ORDER BY s.storeId")
    List<GetSalesByMonthResponse> monthForSales(@Param(value = "yearMonth") LocalDate yearMonth);


}
