package com.toantr.webapp.persistence.service.impl;

import com.toantr.webapp.persistence.model.customer.Customer;
import com.toantr.webapp.persistence.repo.CustomerRepo;
import com.toantr.webapp.persistence.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public void save(Customer customer)
    {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id)
    {
        customerRepo.deleteById(id);
    }

    @Override
    public List<Customer> findAll()
    {
        return customerRepo.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable)
    {
        return customerRepo.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllWhereNameBeLike(String name, Pageable pageable)
    {
        return customerRepo.findAllWhereNameBeLike(name,pageable);
    }

    @Override
    public Page<Customer> findCustomersUsingService(Pageable pageable)
    {
        return customerRepo.findCustomersUsingService(pageable);
    }

    @Override
    public Customer findById(Long id)
    {
        return customerRepo.findById(id).orElse(null);
    }
}
