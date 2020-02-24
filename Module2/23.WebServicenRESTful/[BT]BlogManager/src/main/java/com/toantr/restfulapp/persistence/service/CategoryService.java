package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Category;

import java.util.List;

public interface CategoryService
{
    void save(Category category);
    void remove(Long id);
    Category findById(Long id);
    List<Category> findAll();
}
