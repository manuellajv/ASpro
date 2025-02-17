package com.aspro.aspro.model.services;

import com.aspro.aspro.model.dao.CustomerDAO;
import com.aspro.aspro.model.entities.Customer;

public class CustomerService {
    private CustomerDAO dao;

    public CustomerService(CustomerDAO dao){
        this.dao = dao;
    }

    public void saveCustomer(String customerName, String cpfCnpj, Long phone, String email){
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCpfCnpj(cpfCnpj);
        customer.setPhone(phone);
        customer.setEmail(email);
        dao.save(customer);
    }

    public void updateCustomer(Customer customer){
        dao.update(customer);
    }

    public void deleteCustomer(Long customerId){
        dao.delete(customerId);
    }
}
