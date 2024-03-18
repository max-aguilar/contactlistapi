package com.douglas.contactlistapi;

import com.douglas.contactlistapi.entity.Contact;
import com.douglas.contactlistapi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository) {
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Max", "max@gmail.com", LocalDateTime.now()),
					new Contact("Tobito", "tobito@gmail.com", LocalDateTime.now()),
					new Contact("Isoceles", "isoceles@gmail.com", LocalDateTime.now()),
					new Contact("Goku", "goku@gmail.com", LocalDateTime.now()),
					new Contact("Vegeta", "vegeta@gmail.com", LocalDateTime.now())

			);

			contactRepository.saveAll(contacts);
		};
	}
}
