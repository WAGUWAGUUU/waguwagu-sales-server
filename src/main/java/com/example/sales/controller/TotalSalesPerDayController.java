package com.example.sales.controller;

import com.example.sales.global.dto.SalesByDayResponse;
import com.example.sales.service.TotalSalesPerDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales/sales-day")
@RequiredArgsConstructor
public class TotalSalesPerDayController {
    private final TotalSalesPerDayService totalSalesPerDayService;

    @GetMapping("/store/{storeId}/{year}/{month}")
    List<SalesByDayResponse> getSalesByMonth(@PathVariable(name = "storeId") Long storeId, @PathVariable(name = "year")int year, @PathVariable(name = "month")int month){
        return totalSalesPerDayService.getSalesByMonth(storeId, year, month);
    }
}
