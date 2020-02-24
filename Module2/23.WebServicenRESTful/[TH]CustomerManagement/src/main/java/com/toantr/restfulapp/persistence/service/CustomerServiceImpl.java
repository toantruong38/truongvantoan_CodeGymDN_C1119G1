package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Customer;
import com.toantr.restfulapp.persistence.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Customer> findAll()
    {
        return customerRepo.findAll();
    }

    @Override
    public Customer findById(Long id)
    {
        return customerRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer)
    {
        customerRepo.save(customer);
    }

    @Override
    public void delete(Long id)
    {
        customerRepo.deleteById(id);
    }
}
