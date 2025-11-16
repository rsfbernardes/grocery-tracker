package com.rsfbernardes.grocerytracker.service;

import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final PurchaseRepository purchaseRepository;

    public Purchase lowestPrice(Long productId) {
        return purchaseRepository.findLowestPrice(productId);
    }

    public Purchase highestPrice(Long productId) {
        return purchaseRepository.findHighestPrice(productId);
    }

    public String bestSupermarket(Long productId) {
        List<Purchase> purchases = purchaseRepository.findByProductId(productId);
        return purchases.stream()
                .min(Comparator.comparing(Purchase::getValue))
                .map(Purchase::getSupermarket)
                .orElse(null);
    }

    public String worstSupermarket(Long productId) {
        List<Purchase> purchases = purchaseRepository.findByProductId(productId);
        return purchases.stream()
                .max(Comparator.comparing(Purchase::getValue))
                .map(Purchase::getSupermarket)
                .orElse(null);
    }

}
