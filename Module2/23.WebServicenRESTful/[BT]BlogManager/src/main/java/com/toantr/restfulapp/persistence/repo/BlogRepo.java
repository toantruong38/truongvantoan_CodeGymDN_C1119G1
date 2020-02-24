package com.toantr.restfulapp.persistence.repo;

import com.toantr.restfulapp.persistence.model.Blog;
import com.toantr.restfulapp.persistence.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long>
{
    List<Blog> findAllByCategory(Category category);
}
