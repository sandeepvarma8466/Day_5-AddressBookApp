package com.blz.addressbook.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class AddressBookNotFoundException extends RuntimeException{
    private int statusCode;
    private String message;

    public AddressBookNotFoundException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }
}
