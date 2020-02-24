package com.toantr.restfulapp.persistence.repo;

import com.toantr.restfulapp.persistence.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long>
{
}
