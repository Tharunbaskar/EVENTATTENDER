package com.example.eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventhandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventhandlerApplication.class, args);
	}

}
