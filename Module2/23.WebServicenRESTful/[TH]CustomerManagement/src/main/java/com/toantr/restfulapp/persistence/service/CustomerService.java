package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void delete(Long id);
}
