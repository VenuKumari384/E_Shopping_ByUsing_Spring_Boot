package com.eshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @SpringBootApplication is the combination of 
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponenetScan
 * it is used to run spring boot application or spring boot projects
 * it is used to scan all the component classes
 * it is used to enable the auto configuration
 */
public class EShoppingByUsingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EShoppingByUsingSpringBootApplication.class, args);
	}

}
