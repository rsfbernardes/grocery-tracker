package com.rsfbernardes.grocerytracker.repository;

import com.rsfbernardes.grocerytracker.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByProductId(Long productId);

}
