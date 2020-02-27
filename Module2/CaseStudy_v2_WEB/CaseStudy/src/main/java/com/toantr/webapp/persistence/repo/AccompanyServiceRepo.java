package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.accompanyservice.AccompanyService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccompanyServiceRepo extends JpaRepository<AccompanyService,Long>
{
    @Query("select aser from AccompanyService aser")
    List<AccompanyService> myFindAll();
}
