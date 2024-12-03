package com.example.saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaasApplication.class, args);
		System.out.println("SaaS Application is up and running!");
	}

}
