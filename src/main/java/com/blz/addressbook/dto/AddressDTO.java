package com.blz.addressbook.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private long adhharNumber;
    private String firstName;
    private String lastName;
    private long mobileNum;
    private String city;
    private String state;
    private long pincode;
    private String email;
    private String password;
}
