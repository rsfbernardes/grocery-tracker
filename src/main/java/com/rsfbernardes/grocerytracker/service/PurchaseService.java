package com.rsfbernardes.grocerytracker.service;

import com.rsfbernardes.grocerytracker.elastic.PurchaseIndexerService;
import com.rsfbernardes.grocerytracker.model.Product;
import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.repository.ProductRepository;
import com.rsfbernardes.grocerytracker.repository.PurchaseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final ProductRepository productRepository;
    private final PurchaseIndexerService purchaseIndexerService;

    @Transactional
    public Purchase save(Purchase purchase) {
        Product product = productRepository.findById(purchase.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        purchase.setProduct(product);
        Purchase savedPurchase = purchaseRepository.save(purchase);
        log.info("Saved purchase {}", savedPurchase);
        purchaseIndexerService.index(savedPurchase, product);
        log.info("Indexed purchase {}", savedPurchase);
        return savedPurchase;
    }

    public List<Purchase> findByProduct(Long productId) {
        return purchaseRepository.findByProductId(productId);
    }

    public void delete(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
        purchaseIndexerService.deleteIndexed(purchaseId);
    }

}
