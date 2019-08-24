package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringDataRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestDemoApplication.class, args);
	}
}