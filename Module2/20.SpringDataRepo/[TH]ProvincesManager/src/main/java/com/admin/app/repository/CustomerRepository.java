package com.admin.app.repository;

import com.admin.app.model.Customer;
import com.admin.app.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends
        PagingAndSortingRepository<Customer,Long>
{
    Iterable<Customer> findAllByProvince(Province province);
}
