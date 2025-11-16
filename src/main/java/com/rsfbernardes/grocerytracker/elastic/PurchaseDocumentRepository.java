package com.rsfbernardes.grocerytracker.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PurchaseDocumentRepository extends ElasticsearchRepository<PurchaseDocument, String> {
}
