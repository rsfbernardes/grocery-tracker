package com.rsfbernardes.grocerytracker.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private List<PricePoint> priceHistory;

    @Data
    @Embeddable
    public static class PricePoint {
        private LocalDate date;
        private Double price;
    }

}
