package com.toantr.restfulapp.persistence.service;

import com.toantr.restfulapp.persistence.model.Blog;
import com.toantr.restfulapp.persistence.model.Category;

import java.util.List;

public interface BlogService
{
    List<Blog> findAll();
    void save(Blog blog);
    void remove(Long id);
    Blog findById(Long id);
    List<Blog> findByCategory(Category category);
}
