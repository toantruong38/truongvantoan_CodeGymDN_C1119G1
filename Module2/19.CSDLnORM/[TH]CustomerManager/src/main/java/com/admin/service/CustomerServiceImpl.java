package com.admin.service;

import com.admin.model.Customer;
import com.admin.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id)
    {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer)
    {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id)
    {
        customerRepository.remove(id);
    }
}
