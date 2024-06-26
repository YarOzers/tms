package com.yaroslav.tms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TmsApplication {
	private static final Logger logger = LoggerFactory.getLogger(TmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String url = "http://localhost:8080/realms/tms";
			try {
				ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
				System.out.println("Response:");
				System.out.println(response.getBody());
			} catch (Exception e) {
				System.err.println("Error accessing Keycloak: " + e.getMessage());
			}
		};
	}
}
