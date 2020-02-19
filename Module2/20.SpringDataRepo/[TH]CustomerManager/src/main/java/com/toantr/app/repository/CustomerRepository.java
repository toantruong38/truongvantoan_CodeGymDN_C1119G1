package com.toantr.app.repository;

import com.toantr.app.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long>
{
    Page<Customer> findCustomersByName(Pageable pageable,String name);
    Page<Customer> findCustomersByNameLike(Pageable pageable,String name);
    @Query("select c from Customer c where c.name like %?1%")
    Page<Customer> findCustomersNameLike(Pageable pageable, String name);
}
