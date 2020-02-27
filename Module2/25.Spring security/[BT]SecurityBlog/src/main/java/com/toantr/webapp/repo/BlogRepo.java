package com.toantr.webapp.repo;

import com.toantr.webapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Long>
{
    @Query("select b from Blog b")
    List<Blog> getAll();
}
