package com.AddressBook.AddressBook.Controller;


import com.AddressBook.AddressBook.Repository.AddressBookRepository;
import com.AddressBook.AddressBook.model.AddressBook;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    @GetMapping("/getById/{id}")
    public AddressBook getById(@PathVariable Integer id){
        System.out.println(addressBook.count());


       return  addressBook.findById(id).get();
    }
    @GetMapping("/getAll")
    public Iterable<AddressBook> getAll(){
        System.out.println(addressBook.count());


        return  addressBook.findAll();
    }




}
