package com.admin.app.service.impl;

import com.admin.app.model.Province;
import com.admin.app.repository.ProvinceRepository;
import com.admin.app.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProvinceServiceImpl implements ProvinceService
{
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public Iterable<Province> findAll()
    {
        return provinceRepository.findAll();
    }

    @Override
    public void save(Province province)
    {
        provinceRepository.save(province);
    }

    @Override
    public void remove(Long id)
    {
        provinceRepository.deleteById(id);
    }

    @Override
    public Province findById(Long id)
    {
        return provinceRepository.findById(id).orElse(null);
    }
}
