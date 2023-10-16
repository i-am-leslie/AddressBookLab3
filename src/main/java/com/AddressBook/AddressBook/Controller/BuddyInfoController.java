package com.AddressBook.AddressBook.Controller;

import com.AddressBook.AddressBook.Repository.BuddyInfoRepository;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Buddy")
public class BuddyInfoController {

    @Autowired
    private BuddyInfoRepository BuddyInfoRepo;



    @GetMapping("/get/{id}")
    public Optional<BuddyInfo> getAllBuddy(@PathVariable("id") Integer id  ){
        return BuddyInfoRepo.findById(id);
    }
    @PostMapping("/create")
    public String  createBuddy(@RequestBody BuddyInfo buds) {
        BuddyInfo _tutorial = BuddyInfoRepo.save(new BuddyInfo(buds.getPhoneNumber(), buds.getName(), buds.getAddress()));
        System.out.println(BuddyInfoRepo.existsById(_tutorial.getId()) );
        return _tutorial + " "+"created ";
    }


}
