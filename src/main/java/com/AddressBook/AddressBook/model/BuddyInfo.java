package com.AddressBook.AddressBook.model;
import jakarta.persistence.*;
import com.AddressBook.AddressBook.model.AddressBook;

@Entity

public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int phoneNumber;
    private String name;



    @ManyToOne
    private AddressBook AddressBook;

    public BuddyInfo() {

    }
    public BuddyInfo(int phoneNumber,String name,AddressBook address) {
        this.phoneNumber=phoneNumber;
        this.name=name;
        this.AddressBook=address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
    public  String getName() {
        return name;
    }
    public AddressBook getAddress() {
        return AddressBook;
    }
    public int  getId() {
        return id;
    }
    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAddress(AddressBook address){
        this.AddressBook=address;
    }

    @Override
    public String toString(){
        return phoneNumber + " " + getName()+" "+ getAddress();
    }

    public void setAddressBook(AddressBook addressBook) {
        this.AddressBook = addressBook;
    }


}


