package com.rsfbernardes.grocerytracker.service;

import com.rsfbernardes.grocerytracker.model.Product;
import com.rsfbernardes.grocerytracker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        log.info("Creating product {}", product.getName());
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findByName(String name) {
        return productRepository.findByNameIgnoreCase(name)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with name: " + name));
    }

}
