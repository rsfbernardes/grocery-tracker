package com.rsfbernardes.grocerytracker.elastic.repository;

import com.rsfbernardes.grocerytracker.elastic.index.PriceIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceIndexRepository extends ElasticsearchRepository<PriceIndex, String> {
}
