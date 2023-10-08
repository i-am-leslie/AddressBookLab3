package com.AddressBook.AddressBook.Controller;

import org.springframework.ui.Model;
import com.AddressBook.AddressBook.Repository.AddressBookRepository;
import com.AddressBook.AddressBook.model.AddressBook;
import com.AddressBook.AddressBook.model.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/Address2")
public class AddressBookController2 {

    @Autowired
    private AddressBookRepository addressBook;

    public AddressBookController2(){


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
    public Iterable<AddressBook> getAll(Model model ){
        System.out.println(addressBook.count());
        model.addAttribute("addressBooks", addressBook.findAll());



        return  addressBook.findAll();
    }

}
