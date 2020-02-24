package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Blog;
import com.toantr.restfulapp.persistence.model.Category;
import com.toantr.restfulapp.persistence.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BlogServiceImpl implements BlogService
{
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll()
    {
        return blogRepo.findAll();
    }

    @Override
    public void save(Blog blog)
    {
        blogRepo.save(blog);
    }

    @Override
    public void remove(Long id)
    {
        blogRepo.deleteById(id);
    }

    @Override
    public Blog findById(Long id)
    {
        return blogRepo.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findByCategory(Category category)
    {
        return blogRepo.findAllByCategory(category);
    }
}
