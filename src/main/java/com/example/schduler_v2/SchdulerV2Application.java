package com.example.schduler_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchdulerV2Application {

	public static void main(String[] args) {
		SpringApplication.run(SchdulerV2Application.class, args);
	}

}
