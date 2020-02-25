package com.toantr.webapp.persistence.service;

import com.toantr.webapp.persistence.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService
{
    void save(Customer customer);
    void remove(Long id);
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllWhereNameBeLike(String name,Pageable pageable);
    Page<Customer> findCustomersUsingService(Pageable pageable);
    Customer findById(Long id);
}
