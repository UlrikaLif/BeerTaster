package com.project.beertaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BeertasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeertasterApplication.class, args);
	}

}
