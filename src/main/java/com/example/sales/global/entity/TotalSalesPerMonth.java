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
@Table(name ="TOTAL_SALES_PER_MONTH")
@Builder
public class TotalSalesPerMonth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalSalesPerMonthId;

    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "MONTH")
    private LocalDate month;


    @Column(name = "MONTH_SALES")
    private Long monthlySales;

    public TotalSalesPerMonth(Long storeId, LocalDate month, Long monthlySales) {
        this.storeId = storeId;
        this.month = month;
        this.monthlySales = monthlySales;
    }
}
