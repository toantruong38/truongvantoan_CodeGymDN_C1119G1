package com.admin.app.service;

import com.admin.app.model.Province;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService
{
    Iterable<Province> findAll();
    void save(Province province);
    void remove(Long id);
    Province findById(Long id);
}
