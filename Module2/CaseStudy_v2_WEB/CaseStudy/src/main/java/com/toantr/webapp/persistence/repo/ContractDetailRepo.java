package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.contractdetail.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailRepo extends JpaRepository<ContractDetail,Long>
{
    @Query("select cd from ContractDetail cd")
    List<ContractDetail> findAll();
}
