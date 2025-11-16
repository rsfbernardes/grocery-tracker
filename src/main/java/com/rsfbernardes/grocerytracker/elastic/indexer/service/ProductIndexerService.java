package com.rsfbernardes.grocerytracker.elastic.indexer.service;

import com.rsfbernardes.grocerytracker.elastic.index.ProductIndex;
import com.rsfbernardes.grocerytracker.elastic.repository.ProductIndexRepository;
import com.rsfbernardes.grocerytracker.model.Product;
import com.rsfbernardes.grocerytracker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductIndexerService {

    private final ProductRepository productRepository;
    private final ProductIndexRepository productIndexRepository;

    public ProductIndex indexProduct(Long productId) {
        Product entity = productRepository.findById(productId)
                .orElseThrow();

        ProductIndex index = new ProductIndex(
                entity.getId().toString(),
                entity.getName(),
                entity.getCategory(),
                entity.getCurrentPrice(),
                entity.getSupermarket(),
                entity.getPriceHistory().stream()
                        .map(pricePoint -> new ProductIndex.PricePoint(
                                pricePoint.getDate(), pricePoint.getPrice()))
                        .toList()

        );

        return productIndexRepository.save(index);
    }

}
