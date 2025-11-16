package com.rsfbernardes.grocerytracker.repository;

import com.rsfbernardes.grocerytracker.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByProductId(Long productId);

    @Query("SELECT p FROM Purchase p WHERE p.product.id = :productId ORDER BY p.value ASC LIMIT 1")
    Purchase findLowestPrice(Long productId);

    @Query("SELECT p FROM Purchase p WHERE p.product.id = :productId ORDER BY p.value DESC LIMIT 1")
    Purchase findHighestPrice(Long productId);

    @Query(value = "SELECT AVG(value) FROM purchases WHERE product_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
    Double findAvgBetween(Long productId, LocalDate start, LocalDate end);

    Purchase findTopByProductIdOrderByValueAsc(Long productId);

    Purchase findTopByProductIdOrderByValueDesc(Long productId);

}
