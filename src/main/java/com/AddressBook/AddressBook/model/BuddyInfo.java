package com.AddressBook.AddressBook.model;
import jakarta.persistence.*;
import com.AddressBook.AddressBook.model.AddressBook;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

public class BuddyInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int phoneNumber;
    private String name;



    @ManyToOne
    private AddressBook AddressBook;
    
    @Override
    public String toString(){
        return phoneNumber + " " + getName()+" "+ getPhoneNumber();
    }




}


