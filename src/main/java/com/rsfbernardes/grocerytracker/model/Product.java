package com.rsfbernardes.grocerytracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String category;

    private Double currentPrice;

    private String supermarket;

    @ElementCollection
    @CollectionTable(name = "product_price_history", joinColumns = @JoinColumn(name = "product_id"))
    private List<PricePoint> priceHistory = new ArrayList<>();

    @Data
    @Embeddable
    public static class PricePoint {
        @Column(name = "date", nullable = false)
        private LocalDate date;

        @Column(name = "price", nullable = false)
        private Double price;
    }

}
