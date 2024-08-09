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
@Table(name ="TOTAL_SALES_PER_DAY")
@Builder
public class TotalSalesPerDay {
    @Id
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "TOTAL_SALES_PER_DAY_DATE")
    private Timestamp totalSalesPerDayDate;

    @Column(name = "TOTAL_SALES_PER_DAY_TOTAL_COST")
    private int totalSalesPerDayTotalCost;
}
