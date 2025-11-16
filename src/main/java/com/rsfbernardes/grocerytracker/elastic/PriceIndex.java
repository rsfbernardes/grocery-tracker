package com.rsfbernardes.grocerytracker.elastic;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Data
@Document(indexName = "price_history")
public class PriceIndex {

    @Id
    private String id;
    private String productId;
    private String productName;
    private Double price;
    private String store;
    private LocalDate date;

}
