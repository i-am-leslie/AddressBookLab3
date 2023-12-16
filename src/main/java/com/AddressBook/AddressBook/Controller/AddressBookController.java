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


    private final AddressBook  book;


    public AddressBookController(){
         this.book=new AddressBook();

    }

    @PostMapping("/add")

    public String addBuddy(@RequestBody BuddyInfo buds){

        book.addBuddy(buds);
        addressBook.save(book);
        System.out.println(addressBook.existsById(buds.getId()) );

        return "Buddy " + " "+ buds + " " + "was added";
    }
    @GetMapping("/getById/{id}")
    public String  getById(@PathVariable("id") Integer id){
        System.out.println(addressBook.count());


       return  addressBook.findById(id).toString();
    }
    @GetMapping("/getAll")
    public Iterable<AddressBook> getAll(){
        System.out.println(addressBook.count());


        return  addressBook.findAll();
    }




}
