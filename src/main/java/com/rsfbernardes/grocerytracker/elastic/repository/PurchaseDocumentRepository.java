package com.rsfbernardes.grocerytracker.elastic.repository;

import com.rsfbernardes.grocerytracker.elastic.PurchaseDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDocumentRepository extends ElasticsearchRepository<PurchaseDocument, String> {
}
