package com.rsfbernardes.grocerytracker.elastic;

import com.rsfbernardes.grocerytracker.model.Product;
import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseIndexerService {

    private final PurchaseDocumentRepository purchaseDocumentRepository;

    public void index(Purchase purchase, Product product) {
        PurchaseDocument document = new PurchaseDocument();
        document.setPurchaseId(purchase.getId());
        document.setProductId(product.getId());
        document.setProductName(product.getName());
        document.setProductBrand(product.getBrand());
        document.setProductWeight(product.getSize());
        document.setValue(purchase.getValue());
        document.setDate(purchase.getDate());
        document.setSupermarket(purchase.getSupermarket());
        purchaseDocumentRepository.save(document);
    }

    public void deleteIndexed(String purchaseId) {
        purchaseDocumentRepository.deleteById(
                String.valueOf(purchaseId));
    }

}
