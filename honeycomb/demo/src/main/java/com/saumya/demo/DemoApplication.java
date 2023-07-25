package com.saumya.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello SAUMYA ** welcome to spring boot");

		Alien alien1 = context.getBean(Alien.class);
		alien1.show();

		/*
		 * by default spring frame work has singletone design pattern,wheather we call
		 * getBean() or not it will give object
		 */
		Alien alien2 = context.getBean(Alien.class);
		alien2.show();
	}

}
