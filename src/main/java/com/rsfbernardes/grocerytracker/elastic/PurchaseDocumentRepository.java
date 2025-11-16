package com.rsfbernardes.grocerytracker.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface PurchaseDocumentRepository extends ElasticsearchRepository<PurchaseDocument, String> {
}
