package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service,Long>
{
    //TODO findUnusedService
    @Query("select s from Service s where s.serviceType.name like %?1%")
    Page<Service> findAllWhereNameBeLike(String name, Pageable pageable);
    Page<Service> findAllByStatus(String serviceStatus,Pageable pageable);
}
