package com.blz.addressbook.exception.exceptionhandler;

import com.blz.addressbook.exception.AddressBookNotFoundException;
import com.blz.addressbook.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(AddressBookNotFoundException.class)
    public ResponseEntity<Response> handlerHiringException(AddressBookNotFoundException he) {
        Response response = new Response();
        response.setErrorCode(400);
        response.setMessage(he.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
