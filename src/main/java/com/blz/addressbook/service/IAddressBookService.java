package com.blz.addressbook.service;

import com.blz.addressbook.dto.AddressDTO;
import com.blz.addressbook.model.AddressModel;

import java.util.List;

public interface IAddressBookService {
    AddressModel addAddressBook(AddressDTO addressDTO);

    AddressModel updateAddressBook(AddressDTO addressDTO, Long id);

    List<AddressModel> getAddressBookData(Long id);

    AddressModel deleteAddressBook(Long id);

    List<AddressModel> getAddressBookData1();

    List<AddressModel> getAddressBook(String token);
}
