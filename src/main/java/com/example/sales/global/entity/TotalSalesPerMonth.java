package com.example.sales.global.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="TOTAL_SALES_PER_MONTH")
@Builder
public class TotalSalesPerMonth {
    @Id
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "TOTAL_SALES_PER_Month_DATE")
    private Timestamp totalSalesPerMonthDate;

    @Column(name = "TOTAL_SALES_PER_Month_TOTAL_COST")
    private int totalSalesPerMonthTotalCost;
}
