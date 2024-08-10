package com.example.sales.service;

import com.example.sales.global.entity.TotalSalesPerDay;
import com.example.sales.global.kafka.KafkaSalesDTO;
import com.example.sales.global.kafka.KafkaStatus;
import com.example.sales.global.repository.TotalSalesPerDayRepository;
import com.example.sales.global.repository.TotalSalesPerMonthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TotalSalesPerMonthServiceImpl{
    private final TotalSalesPerMonthRepository totalSalesPerMonthRepository;





}
