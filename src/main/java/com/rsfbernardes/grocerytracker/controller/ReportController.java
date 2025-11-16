package com.rsfbernardes.grocerytracker.controller;

import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportController {

    private final ReportService reportsService;

    @GetMapping("/lowest/{productId}")
    public Purchase lowest(@PathVariable String productId) {
        return reportsService.lowestPrice(productId);
    }

    @GetMapping("/highest/{productId}")
    public Purchase highest(@PathVariable String productId) {
        return reportsService.highestPrice(productId);
    }

}
