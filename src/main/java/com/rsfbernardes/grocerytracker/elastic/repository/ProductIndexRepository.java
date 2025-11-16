package com.rsfbernardes.grocerytracker.elastic.repository;

import com.rsfbernardes.grocerytracker.elastic.index.ProductIndex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIndexRepository extends CrudRepository<ProductIndex, String> {
}
