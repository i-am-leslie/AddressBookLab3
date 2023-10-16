package com.AddressBook.AddressBook.Repository;

import com.AddressBook.AddressBook.model.BuddyInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Integer> {

    Optional<BuddyInfo> findById(Integer id);
    List<BuddyInfo> findByName(String Name);
}
