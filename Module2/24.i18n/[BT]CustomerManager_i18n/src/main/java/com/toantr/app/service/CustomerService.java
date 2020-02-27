package com.toantr.app.service;

import com.toantr.app.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerService
{
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    void remove(Long id);
    Customer findById(Long id);
    Page<Customer> findByName(Pageable pageable,String name);
    Page<Customer> findByNameLike(Pageable pageable,String name);
    Page<Customer> findCustomersNameLike(Pageable pageable, String name);
}
