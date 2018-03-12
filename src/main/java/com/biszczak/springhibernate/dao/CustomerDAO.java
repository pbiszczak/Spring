package com.biszczak.springhibernate.dao;

import com.biszczak.springhibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
}
