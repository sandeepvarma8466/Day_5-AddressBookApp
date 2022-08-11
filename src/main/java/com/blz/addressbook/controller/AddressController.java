package com.blz.addressbook.controller;

import com.blz.addressbook.dto.AddressDTO;
import com.blz.addressbook.model.AddressModel;
import com.blz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressController {
    @Autowired
    IAddressBookService addressBookService;

    @PostMapping("/addaddressBook")
    public AddressModel addAddressBook(@RequestBody AddressDTO addressDTO) {
        return addressBookService.addAddressBook(addressDTO);
    }

    @PutMapping("/updateaddressbook/{id}")
    public AddressModel updateAddressBook(@RequestBody AddressDTO addressDTO,@PathVariable Long id) {
        return addressBookService.updateAddressBook(addressDTO, id);
    }

    @GetMapping("/getAdressBookdata/{id}")
    public List<AddressModel> getAllAddressBooks(@PathVariable Long id) {
        return addressBookService.getAddressBookData(id);
    }

    @GetMapping("/getAdressBookdata1")
    public List<AddressModel> getAllAddressBooks1() {
        return addressBookService.getAddressBookData1();
    }

    @GetMapping("getaddressboodata")
    public List<AddressModel> getAddressBook(@RequestHeader String token) {
        return addressBookService.getAddressBook(token);
    }
    @DeleteMapping("/deleteaddressbook/{id}")
    public AddressModel deleteAddressBook(@PathVariable Long id) {
        return addressBookService.deleteAddressBook(id);
    }
}
