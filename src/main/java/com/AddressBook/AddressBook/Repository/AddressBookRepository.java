package com.AddressBook.AddressBook.Repository;

import com.AddressBook.AddressBook.model.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Integer> {


}
