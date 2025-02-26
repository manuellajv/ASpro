package com.aspro.aspro.model.services;

import com.aspro.aspro.model.dao.AddressDAO;
import com.aspro.aspro.model.entities.Address;
import com.aspro.aspro.model.entities.Customer;

public class AddressService {
    private AddressDAO dao;

    public AddressService(AddressDAO dao){
        this.dao = dao;
    }

    public void saveAddress(Long zipCode, String street, Short addrNumber, String district, String city, String complement){
        Address address = new Address();
        address.setZipCode(zipCode);
        address.setStreet(street);
        address.setAddrNumber(addrNumber);
        address.setDistrict(district);
        address.setCity(city);
        address.setComplement(complement);
        dao.save(address);
    }

    public void updateAddress(Address address){
        dao.update(address);
    }

}
