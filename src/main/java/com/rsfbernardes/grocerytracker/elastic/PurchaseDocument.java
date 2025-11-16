package com.rsfbernardes.grocerytracker.elastic;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "purchases-index")
public class PurchaseDocument {

    @Id
    private String id;

    @Field(type = FieldType.Long)
    private String purchaseId;

    @Field(type = FieldType.Long)
    private String productId;

    @Field(type = FieldType.Text)
    private String productName;

    @Field(type = FieldType.Keyword)
    private String productBrand;

    @Field(type = FieldType.Keyword)
    private String productWeight;

    @Field(type = FieldType.Double)
    private Double value;

    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate date;

    @Field(type = FieldType.Keyword)
    private String supermarket;

}
