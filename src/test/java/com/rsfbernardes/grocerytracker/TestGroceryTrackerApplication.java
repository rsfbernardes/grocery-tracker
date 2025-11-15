package com.rsfbernardes.grocerytracker;

import org.springframework.boot.SpringApplication;

public class TestGroceryTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.from(GroceryTrackerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
