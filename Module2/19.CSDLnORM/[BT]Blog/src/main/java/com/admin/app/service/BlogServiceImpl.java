package com.admin.app.service;

import com.admin.app.model.Blog;
import com.admin.app.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class BlogServiceImpl implements BlogService<Blog>
{
    @Autowired
    private Repository repository;
    @Override
    public List<Blog> findAll()
    {
        return (List<Blog>) repository.findAll();
    }

    @Override
    public void update(Blog blog)
    {
        repository.save(blog);
    }

    @Override
    public void delete(int id)
    {
        repository.deleteById(id);
    }

    @Override
    public Blog findById(int id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void createBlog(Blog blog)
    {
        repository.save(blog);
    }
}
