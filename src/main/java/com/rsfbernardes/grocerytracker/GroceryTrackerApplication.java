package com.rsfbernardes.grocerytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.rsfbernardes.grocerytracker.elastic")
public class GroceryTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroceryTrackerApplication.class, args);
    }

}
