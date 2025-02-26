package com.aspro.aspro.model.services;

import com.aspro.aspro.model.dao.AddressDAO;
import com.aspro.aspro.model.dao.CustomerDAO;
import com.aspro.aspro.model.entities.Address;
import com.aspro.aspro.model.entities.Customer;
import javafx.fxml.FXML;

import java.util.Collections;

public class CustomerService {
    private CustomerDAO customerDAO;
    private AddressDAO addressDAO;

    public CustomerService(CustomerDAO customerDAO, AddressDAO addressDAO){
        this.customerDAO = customerDAO;
        this.addressDAO = addressDAO;
    }

    @FXML
    public void saveCustomer(String customerName, String cpfCnpj, Long phone, String email, Long zipCode, String street, Short addrNumber, String district, String city, String complement){

        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCpfCnpj(cpfCnpj);
        customer.setPhone(phone);
        customer.setEmail(email);

        Address address = new Address();
        address.setZipCode(zipCode);
        address.setStreet(street);
        address.setAddrNumber(addrNumber);
        address.setDistrict(district);
        address.setCity(city);
        address.setComplement(complement);

        customer.setAddress(Collections.singletonList(address));

        customerDAO.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerDAO.update(customer);
    }

    public void deleteCustomer(Long customerId){
        customerDAO.delete(customerId);
    }
}
