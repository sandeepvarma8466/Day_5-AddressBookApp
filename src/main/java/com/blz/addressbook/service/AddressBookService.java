package com.blz.addressbook.service;

import com.blz.addressbook.dto.AddressDTO;
import com.blz.addressbook.exception.AddressBookNotFoundException;
import com.blz.addressbook.model.AddressModel;
import com.blz.addressbook.repository.AddressRepository;
import com.blz.addressbook.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService implements IAddressBookService{
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Override
    public AddressModel addAddressBook(AddressDTO addressDTO) {
        AddressModel addressModel = new AddressModel(addressDTO);
        addressRepository.save(addressModel);
        return addressModel;
    }

    @Override
    public AddressModel updateAddressBook(AddressDTO addressDTO, Long id) {
        Optional<AddressModel> isAddressBookPresent = addressRepository.findById(id);
        if (isAddressBookPresent.isPresent()) {
            isAddressBookPresent.get().setFirstName(addressDTO.getFirstName());
            isAddressBookPresent.get().setLastName(addressDTO.getLastName());
            isAddressBookPresent.get().setMobileNum(addressDTO.getMobileNum());
            isAddressBookPresent.get().setCity(addressDTO.getCity());
            isAddressBookPresent.get().setState(addressDTO.getState());
            isAddressBookPresent.get().setPincode(addressDTO.getPincode());
            isAddressBookPresent.get().setEmail(addressDTO.getEmail());
            isAddressBookPresent.get().setPassword(addressDTO.getPassword());
            addressRepository.save(isAddressBookPresent.get());
            return isAddressBookPresent.get();
        }
        throw  new AddressBookNotFoundException(400,"Address Book Not Present");
    }

    @Override
    public List<AddressModel> getAddressBookData(Long id) {
        Optional<AddressModel> isAddressBookPresent = addressRepository.findById(id);
        if (isAddressBookPresent.isPresent()) {
            List<AddressModel> getAddressBookData = addressRepository.findAll();
            if (getAddressBookData.size()>0) {
                return getAddressBookData;
            }
            else {
                throw new AddressBookNotFoundException(400,"No Data Present");
            }
        }
        throw  new AddressBookNotFoundException(400,"AddressBook Not Found");
    }

    @Override
    public List<AddressModel> getAddressBookData1() {
        List<AddressModel> getAddressBookData = addressRepository.findAll();
        if (getAddressBookData.size()>0) {
            return getAddressBookData;
        }
        else {
            throw new AddressBookNotFoundException(400,"No Data Present");
        }
    }

    @Override
    public List<AddressModel> getAddressBook(String token) {
        Long addressBook = tokenUtil.decodeToken(token);
        Optional<AddressModel> isAddressBookPresent = addressRepository.findById(addressBook);
        if (isAddressBookPresent.isPresent()) {
            List<AddressModel> getAddressBookData = addressRepository.findAll();
            if (getAddressBookData.size()>0) {
                return getAddressBookData;
            }
            else {
                throw new AddressBookNotFoundException(400,"No Data Present");
            }
        }
        throw  new AddressBookNotFoundException(400,"AddressBook Not Found");
    }

    @Override
    public AddressModel deleteAddressBook(Long id) {
        Optional<AddressModel> isAddressBookPresent = addressRepository.findById(id);
        if (isAddressBookPresent.isPresent()) {
            addressRepository.delete(isAddressBookPresent.get());
            return isAddressBookPresent.get();
        }
        throw  new AddressBookNotFoundException(400,"AddressBook Not Found");
    }
}
