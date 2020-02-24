package com.toantr.restfulapp.persistence.repo;

import com.toantr.restfulapp.persistence.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>
{
}
