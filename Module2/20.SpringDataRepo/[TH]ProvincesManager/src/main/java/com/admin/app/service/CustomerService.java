package com.admin.app.service;

import com.admin.app.model.Customer;
import com.admin.app.model.Province;
import org.springframework.stereotype.Service;

public interface CustomerService
{
    Iterable<Customer> findAll();
    Customer findById(Long id);
    void save(Customer customer);
    void remove(Long id);
    Iterable<Customer> findAllByProvince(Province province);
}
