package com.honeycomb.ecommerce.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories(basePackages={"com.honeycomb.ecommerce.repository"})
@EntityScan(basePackages = "com.honeycomb.ecommerce.entity") 
@ComponentScan(basePackages = "com.honeycomb.ecommerce;")

public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
		System.out.println("Hello saumya");
	}

}
