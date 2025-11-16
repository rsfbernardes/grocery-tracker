package com.rsfbernardes.grocerytracker.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceIndexRepository extends ElasticsearchRepository<PriceIndex, String> {
}
