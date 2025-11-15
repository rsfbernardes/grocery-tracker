package com.rsfbernardes.grocerytracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GroceryTrackerApplicationTests {

	@Test
	void contextLoads() {
	}

}
