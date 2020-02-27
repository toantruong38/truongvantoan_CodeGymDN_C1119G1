package com.toantr.app.service;

import com.toantr.app.model.Customer;
import com.toantr.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable)
    {
        return customerRepository.findAll(pageable);
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
    public Customer findById(Long id)
    {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findByName(Pageable pageable, String name)
    {
        return customerRepository.findCustomersByName(pageable, name);
    }
    @Override
    public Page<Customer> findByNameLike(Pageable pageable,String name){
        return customerRepository.findCustomersByNameLike(pageable,name);
    }

    @Override
    public Page<Customer> findCustomersNameLike(Pageable pageable,String name){
        return customerRepository.findCustomersNameLike(pageable,name);
    }
}
