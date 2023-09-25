package com.AddressBook.AddressBook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class AddressBookApplication {
	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BuddyInfoRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new BuddyInfo(647, "Jack", "1125 Colo dr"));
			repository.save(new BuddyInfo(637, "Chloe", "350 montgomery"));
			repository.save(new BuddyInfo(627, "Kim", "260 montchain"));
			repository.save(new BuddyInfo(617, "David", "12 palmstreet"));
			repository.save(new BuddyInfo(607, "Michelle", "16 inch "));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo b : repository.findAll()) {
				log.info(b.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<BuddyInfo> buds = repository.findById(1L);
			log.info("BuddyInfo found with findById(1L):");
			log.info("--------------------------------");
			log.info(buds.toString());
			log.info("");

			// fetch customers by  name
			log.info("BuddyInfo found with findByName('jack'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(jack -> {
				log.info(jack.toString());
			});

			log.info("");
		};

	}

	@Bean
	public CommandLineRunner demo1(AddressBookRepository repo) {
		return (args) -> {

			AddressBook a = new AddressBook();
			BuddyInfo b = new BuddyInfo(647, "Jack", "1125 Colo dr");
			BuddyInfo c = new BuddyInfo(637, "Chloe", "350 montgomery");
			a.addBuddy(b);
			a.addBuddy(c);
			repo.save(a);


			// save a few customers


			// fetch all customers
			log.info("BuddyInfo found with findAll():");
			log.info("-------------------------------");
			for (AddressBook book : repo.findAll()) {
				log.info(book.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			AddressBook buds = repo.findById(1L);
			log.info("BuddyInfo found with findById(1L):");
			log.info("--------------------------------");
			log.info(buds.toString());
			log.info("");

			log.info("");
		};

	}


}




