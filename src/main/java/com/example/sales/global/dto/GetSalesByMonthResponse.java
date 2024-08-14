package com.example.sales.global.dto;

import java.time.LocalDate;

public interface GetSalesByMonthResponse {
    Long getStoreId();
    String getStoreName();
    String getOwnerEmail();
    LocalDate getDate();
    Long getMonthlySales();

}