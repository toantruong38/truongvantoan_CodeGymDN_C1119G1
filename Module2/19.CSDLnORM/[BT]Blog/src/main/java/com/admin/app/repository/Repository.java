package com.admin.app.repository;

import com.admin.app.model.Blog;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Blog,Integer>
{
}
