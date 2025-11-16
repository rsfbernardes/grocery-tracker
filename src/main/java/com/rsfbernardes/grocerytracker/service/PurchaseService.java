package com.rsfbernardes.grocerytracker.service;

import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public List<Purchase> getByProduct(Long productId) {
        return purchaseRepository.findByProductId(productId);
    }

    public Purchase getLowestPrice(Long productId) {
        return purchaseRepository.findLowestPrice(productId);
    }

    public Purchase getHighestPrice(Long productId) {
        return purchaseRepository.findHighestPrice(productId);
    }

}
