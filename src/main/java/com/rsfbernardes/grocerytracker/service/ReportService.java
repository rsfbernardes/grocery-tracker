package com.rsfbernardes.grocerytracker.service;

import co.elastic.clients.elasticsearch._types.SortOrder;
import com.rsfbernardes.grocerytracker.elastic.PurchaseDocument;
import com.rsfbernardes.grocerytracker.model.Purchase;
import com.rsfbernardes.grocerytracker.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.OptionalDouble;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ElasticsearchOperations elasticsearchOperations;
    private final ReportRepository reportRepository;

    /**
     * Find minimum price for a product using Elasticsearch by sorting ascending and taking first result.
     * Returns null if no document found.
     */
    public Double findMinPriceEs(Long productId) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .term(t -> t
                                .field("productId")
                                .value(productId)
                        )
                )
                // sort by "value" ASC
                .withSort(s -> s
                        .field(f -> f
                                .field("value")
                                .order(SortOrder.Asc)
                        )
                )
                // limit to 1 result
                .withPageable(PageRequest.of(0, 1))
                .build();
        SearchHits<PurchaseDocument> hits = elasticsearchOperations.search(query, PurchaseDocument.class);

        if (hits.getSearchHits().isEmpty()) {
            return null;
        }
        SearchHit<PurchaseDocument> first = hits.getSearchHits().getFirst();
        return first.getContent().getValue(); // change to getPrice() if needed
    }

    /**
     * Find maximum price for a product using Elasticsearch by sorting descending and taking first result.
     * Returns null if no document found.
     */
    public Double findMaxPriceEs(Long productId) {
        NativeQuery query = NativeQuery.builder()
                .withQuery(q -> q
                        .term(t -> t
                                .field("productId")
                                .value(productId)
                        )
                )
                // sort by "value" DESC
                .withSort(s -> s
                        .field(f -> f
                                .field("value")
                                .order(SortOrder.Desc)
                        )
                )
                .withPageable(PageRequest.of(0, 1))
                .build();

        SearchHits<PurchaseDocument> hits = elasticsearchOperations.search(query, PurchaseDocument.class);
        if (hits.getSearchHits().isEmpty()) {
            return null;
        }
        SearchHit<PurchaseDocument> first = hits.getSearchHits().getFirst();
        return first.getContent().getValue();
    }

    // simple inflation calculation using SQL averages
    public OptionalDouble calculateInflationSql(Long productId, LocalDate startInclusive, LocalDate endInclusive) {
        Double startAvg = reportRepository.findAvgBetween(productId, startInclusive.minusDays(3), startInclusive.plusDays(3));
        Double endAvg = reportRepository.findAvgBetween(productId, endInclusive.minusDays(3), endInclusive.plusDays(3));
        if (startAvg == null || endAvg == null || startAvg == 0) return OptionalDouble.empty();
        double inflation = ((endAvg - startAvg) / startAvg) * 100.0;
        return OptionalDouble.of(inflation);
    }

    public Purchase lowestPrice(Long productId) {
        return reportRepository.findTopByProductIdOrderByValueAsc(productId);
    }

    public Purchase highestPrice(Long productId) {
        return reportRepository.findTopByProductIdOrderByValueDesc(productId);
    }

}
