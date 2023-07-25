package com.saumya.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaAuditing
//@ComponentScan(basePackages = "com.saumya.*")
public class SubscriptionModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionModuleApplication.class, args);
		System.out.println("Hiii saumya");
	}

}
