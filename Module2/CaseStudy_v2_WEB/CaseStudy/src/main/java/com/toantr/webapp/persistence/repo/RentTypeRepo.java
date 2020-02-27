package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.renttype.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentTypeRepo extends JpaRepository<RentType,Long>
{
    @Query("select rt from RentType rt")
    List<RentType> findAll();
}
