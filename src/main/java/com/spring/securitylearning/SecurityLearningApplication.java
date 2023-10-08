package com.spring.securitylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.spring.securitylearning.config")
public class SecurityLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLearningApplication.class, args);
	}

}
