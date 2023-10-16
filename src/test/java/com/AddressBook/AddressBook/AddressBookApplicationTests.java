package com.AddressBook.AddressBook;

import com.AddressBook.AddressBook.Controller.AddressBookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AddressBookApplicationTests {

	@Autowired
	private AddressBookController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}


}
