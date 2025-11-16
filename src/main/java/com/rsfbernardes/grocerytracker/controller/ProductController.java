package com.rsfbernardes.grocerytracker.controller;

import com.rsfbernardes.grocerytracker.model.Product;
import com.rsfbernardes.grocerytracker.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{name}")
    public Product getByName(@PathVariable String name) {
        return productService.findByName(name);
    }

}
