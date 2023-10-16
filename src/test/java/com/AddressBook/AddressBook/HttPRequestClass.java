package com.AddressBook.AddressBook;

import com.AddressBook.AddressBook.Repository.AddressBookRepository;
import com.AddressBook.AddressBook.model.AddressBook;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HttPRequestClass {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AddressBookRepository repo;

    @BeforeEach()
    public void setUp() {
        AddressBook addBook = new AddressBook();
        addBook.addBuddy(new BuddyInfo(647,"James","1125 cplonel"));

        repo.save(addBook);
    }


    @Test
    public void httpGet() throws Exception {
        this.mockMvc.perform(get("http://localhost:8080/Address/getAll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"buds\":[{\"id\":1,\"phoneNumber\":647,\"name\":\"James\",\"address\":\"1125 cplonel\"}]}]"));

    }

    public void httpPost() throws Exception {// TODO


    }




}