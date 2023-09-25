package com.AddressBook.AddressBook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {

    Optional<BuddyInfo> findById(Long id);
    List<BuddyInfo> findByName(String Name);
}
