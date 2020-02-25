package com.toantr.webapp.persistence.service.impl;

import com.toantr.webapp.persistence.model.Service;
import com.toantr.webapp.persistence.repo.ServiceRepo;
import com.toantr.webapp.persistence.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class ServiceServiceImpl implements ServiceService
{
    @Autowired
    private ServiceRepo serviceRepo;
    @Override
    public Page<Service> findAll(Pageable pageable)
    {
        return serviceRepo.findAll(pageable);
    }

    @Override
    public Page<Service> findAllWhereNameBeLike(String name, Pageable pageable)
    {
        return serviceRepo.findAllWhereNameBeLike(name, pageable);
    }

    @Override
    public Service findById(Long id)
    {
        return serviceRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Service service)
    {
        serviceRepo.save(service);
    }

    @Override
    public void remove(Long id)
    {
        serviceRepo.deleteById(id);
    }
}
