package com.blz.addressbook.model;


import com.blz.addressbook.dto.AddressDTO;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "addressbook")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adhharNumber;
    private String firstName;
    private String lastName;
    private long mobileNum;
    private String city;
    private String state;
    private long pincode;
    private String email;
    private String password;

    public AddressModel() {
    }

    public AddressModel(AddressDTO addressDTO) {
        this.adhharNumber = addressDTO.getAdhharNumber();
        this.firstName = addressDTO.getFirstName();
        this.lastName = addressDTO.getLastName();
        this.mobileNum = addressDTO.getMobileNum();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.pincode = addressDTO.getPincode();
        this.email = addressDTO.getEmail();
        this.password =addressDTO.getPassword();
    }
}
