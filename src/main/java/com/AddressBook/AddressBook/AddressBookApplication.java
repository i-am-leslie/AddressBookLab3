package com.AddressBook.AddressBook;

import com.AddressBook.AddressBook.Repository.AddressBookRepository;
import com.AddressBook.AddressBook.Repository.BuddyInfoRepository;
import com.AddressBook.AddressBook.model.AddressBook;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AddressBookApplication {


	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

}




