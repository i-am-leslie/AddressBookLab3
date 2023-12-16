package com.AddressBook.AddressBook.Controller;


import com.AddressBook.AddressBook.Repository.AddressBookRepository;
import com.AddressBook.AddressBook.Repository.BuddyInfoRepository;
import com.AddressBook.AddressBook.model.AddressBook;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Address")
public class AddressBookController {
    @Autowired
    private AddressBookRepository addressBook;





    public AddressBookController(){


    }

    @PostMapping("/add")

    public String addBuddy(@RequestBody BuddyInfo buds){
        AddressBook book=new AddressBook();
        book.addBuddy(buds);
        addressBook.save(book);
        System.out.println(addressBook.existsById(buds.getId()) );

        return "Buddy " + " "+ buds + " " + "was added";
    }

    @PostMapping("/add/{id}")

    public String addBuddy( @PathVariable Integer id, @RequestBody BuddyInfo buds){
        System.out.println(true);
        Optional<AddressBook> bookRepo = addressBook.findById(id);

        if (bookRepo.isPresent()) {
            System.out.println(true);
            AddressBook a = bookRepo.get();
            a.addBuddy(buds);
            addressBook.save(a);
            return "Buddy " + buds + " was added";
        } else {
            return "AddressBook with ID " + id + " not found.";
        }
    }
    @GetMapping("/getById/{id}")
    public String  getById(@PathVariable("id") Integer id ){
        System.out.println(addressBook.count());

        AddressBook a=addressBook.findById(id).get();
        a.getBuddy(id).getName().toString();

       return  a.getBuddy(id).getName();
    }
    @GetMapping("/getAll")
    public List<AddressBook> getAll(){
        System.out.println(addressBook.count());


        return  (List<AddressBook>)addressBook.findAll();
    }




}
