package com.admin.app.service;

import com.admin.app.model.Blog;

import java.util.List;

public interface BlogService<T>
{
    List<T> findAll();
    void update(T blog);
    void delete(int id);
    T findById(int id);
    void createBlog(T blog);
}
