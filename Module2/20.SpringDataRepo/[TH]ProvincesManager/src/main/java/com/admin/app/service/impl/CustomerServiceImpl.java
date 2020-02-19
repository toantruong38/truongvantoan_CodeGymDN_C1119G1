package com.admin.app.service.impl;

import com.admin.app.model.Customer;
import com.admin.app.model.Province;
import com.admin.app.repository.CustomerRepository;
import com.admin.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Iterable<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id)
    {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer)
    {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id)
    {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province)
    {
        return customerRepository.findAllByProvince(province);
    }
}
