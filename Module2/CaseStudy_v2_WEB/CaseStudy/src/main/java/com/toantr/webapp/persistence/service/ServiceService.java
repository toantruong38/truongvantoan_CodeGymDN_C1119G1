package com.toantr.webapp.persistence.service;

import com.toantr.webapp.persistence.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceService
{
    Page<Service> findAll(Pageable pageable);
    Page<Service> findAllWhereNameBeLike(String name,Pageable pageable);
    Service findById(Long id);

    void save(Service service);
    void remove(Long id);
}
