package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.servicetype.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceTypeRepo extends JpaRepository<ServiceType,Long>
{
    @Query("select st from ServiceType st")
    List<ServiceType> findAll();
}
