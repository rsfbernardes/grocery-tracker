package com.rsfbernardes.grocerytracker.elastic.index;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Document(indexName = "products")
public class ProductIndex {

    @Id
    private String id;
    private String name;
    private String category;
    private Double currentPrice;
    private String supermarket;

    private List<PricePoint> priceHistory;

    public record PricePoint(LocalDate date, Double price) {}

}
