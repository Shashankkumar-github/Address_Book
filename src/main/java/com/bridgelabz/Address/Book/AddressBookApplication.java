package com.bridgelabz.Address.Book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
@Slf4j
@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		log.info("AdressBook App Started in {} Environment", context.getEnvironment().getProperty("environment"));
	}
}
