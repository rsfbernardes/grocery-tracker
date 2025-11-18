package com.rsfbernardes.grocerytracker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.lang.NonNull;

//@Configuration
@EnableElasticsearchRepositories(basePackages = "com.rsfbernardes.grocerytracker.elastic.repository")
public class ElasticsearchConfig extends ElasticsearchConfiguration {


    @Override
    @NonNull
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo("http://localhost:9200")
                .build();
    }
}
