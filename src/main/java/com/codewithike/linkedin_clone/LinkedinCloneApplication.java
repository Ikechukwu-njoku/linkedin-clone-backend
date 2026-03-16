package com.codewithike.linkedin_clone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LinkedinCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkedinCloneApplication.class, args);
	}

}
