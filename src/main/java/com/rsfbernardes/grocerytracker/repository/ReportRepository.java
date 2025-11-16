package com.rsfbernardes.grocerytracker.repository;

import com.rsfbernardes.grocerytracker.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Purchase, Long> {

//    @Query(value = "SELECT AVG(value) FROM purchases WHERE product_id = ?1 AND date BETWEEN ?2 AND ?3", nativeQuery = true)
//    Double findAvgBetween(Long productId, LocalDate start, LocalDate end);

    Purchase findTopByProductIdOrderByValueAsc(String productId);

    Purchase findTopByProductIdOrderByValueDesc(String productId);

}
