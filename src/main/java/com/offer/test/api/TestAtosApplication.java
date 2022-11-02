package com.offer.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = TestAtosApplication.class)
public class TestAtosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAtosApplication.class, args);
	}

}
