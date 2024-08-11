package com.example.sales.controller;

import com.example.sales.global.dto.SalesByYearResponse;
import com.example.sales.service.TotalSalesPerMonthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales-month")
@RequiredArgsConstructor
public class TotalSalesPerMonthController {
    private final TotalSalesPerMonthService totalSalesPerMonthService;
    @GetMapping("store/{storeId}/years")
    public List<Integer> getYearsByStoreId(@PathVariable(name = "storeId") Long storeId){
        return totalSalesPerMonthService.getYearsByStoreId(storeId);
    }

    @GetMapping("store/{storeId}/year/{year}")
    public List<SalesByYearResponse> getSalesByYear(@PathVariable(name = "storeId") Long storeId, @PathVariable(name = "year") int year){
        return totalSalesPerMonthService.getSalesByYear(storeId, year);
    }
}
