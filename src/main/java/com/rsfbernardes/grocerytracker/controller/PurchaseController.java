package com.rsfbernardes.grocerytracker.controller;

import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping
    public Purchase create(@RequestBody Purchase purchase) {
        return purchaseService.save(purchase);
    }

    @GetMapping("/product/{id}")
    public List<Purchase> getByProduct(@PathVariable Long id) {
        return purchaseService.getByProduct(id);
    }

}
