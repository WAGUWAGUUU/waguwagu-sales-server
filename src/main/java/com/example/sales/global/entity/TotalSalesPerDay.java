package com.example.sales.global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="TOTAL_SALES_PER_DAY")
@Builder
public class TotalSalesPerDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalSalesPerDayId;


    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "DATE")
    private LocalDate date;


    @Column(name = "DAILY_SALES")
    private int dailySales;

    public TotalSalesPerDay(Long storeId, LocalDate date, int dailySales) {
        this.storeId = storeId;
        this.date = date;
        this.dailySales = dailySales;
    }

    public void plusSales(int sales) {
        this.dailySales += sales;
    }

}
