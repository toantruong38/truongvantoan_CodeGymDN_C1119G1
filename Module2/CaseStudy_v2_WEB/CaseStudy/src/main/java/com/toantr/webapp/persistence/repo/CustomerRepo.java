package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>
{
    @Query("select c from Customer c where c.fullName like %?1%")
    Page<Customer> findAllWhereNameBeLike(String name, Pageable pageable);

    @Query("select c from Customer c inner join Contract con on c.id=con.customer.id")
    Page<Customer> findCustomersUsingService(Pageable pageable);

}
