package com.AddressBook.AddressBook.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity


public class AddressBook  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "AddressBook", fetch =FetchType.EAGER )
    private List<BuddyInfo> buds=new ArrayList<BuddyInfo>();;


    public void addBuddy(BuddyInfo friend){
        if(friend!=null){
            friend.setAddressBook(this);
            buds.add(friend);
        }
    }

}

