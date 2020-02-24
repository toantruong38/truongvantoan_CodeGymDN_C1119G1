package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Category;
import com.toantr.restfulapp.persistence.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public void save(Category category)
    {
        categoryRepo.save(category);
    }

    @Override
    public void remove(Long id)
    {
        categoryRepo.deleteById(id);
    }

    @Override
    public Category findById(Long id)
    {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll()
    {
        return categoryRepo.findAll();
    }
}
