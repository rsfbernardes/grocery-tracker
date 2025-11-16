package com.rsfbernardes.grocerytracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private String size;

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "product_price_history", joinColumns = @JoinColumn(name = "product_id"))
//    private List<PricePoint> priceHistory = new ArrayList<>();
//
//    @Data
//    @Embeddable
//    public static class PricePoint {
//        @Column(name = "date", nullable = false)
//        private LocalDate date;
//
//        @Column(name = "price", nullable = false)
//        private Double price;
//    }

}
