package com.AddressBook.AddressBook;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity

public class AddressBook  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "AddressBook")
    private List<BuddyInfo> buds;

    public AddressBook() {
        buds=new ArrayList<BuddyInfo>();

    }


    public void addBuddy(BuddyInfo friend){
        if(friend!=null){
            friend.setAddressBook(this);
            buds.add(friend);
        }
    }



    public void  getBuds() {

        for(BuddyInfo b : buds){
            System.out.println(b.toString());
        };
    }










}

