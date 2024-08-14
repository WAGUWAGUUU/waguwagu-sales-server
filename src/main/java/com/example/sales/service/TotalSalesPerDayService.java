package com.example.sales.service;

import com.example.sales.global.dto.SalesByDayResponse;
import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.kafka.KafkaSalesDTO;
import com.example.sales.global.kafka.KafkaStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TotalSalesPerDayService {
    void createTotalSalesPerDay(KafkaStatus<KafkaSalesDTO> kafkaStatus);

    int getTotalSalesByMonth(Long storeId, LocalDate localDate);

    List<Long> getTotalStoreId();

    List<SalesByDayResponse> getSalesByMonth(Long storeId, int year, int month);

}
