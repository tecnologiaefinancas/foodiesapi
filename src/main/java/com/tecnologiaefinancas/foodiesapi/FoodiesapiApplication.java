package com.tecnologiaefinancas.foodiesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.tecnologiaefinancas.foodiesapi.repository")
public class FoodiesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodiesapiApplication.class, args);
	}

}
