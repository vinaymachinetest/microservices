package com.study.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.study" })
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}

}
