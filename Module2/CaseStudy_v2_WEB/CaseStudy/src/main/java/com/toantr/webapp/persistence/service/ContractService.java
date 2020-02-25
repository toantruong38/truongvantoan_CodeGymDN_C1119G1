package com.toantr.webapp.persistence.service;

import com.toantr.webapp.persistence.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService
{
    Page<Contract> findAll(Pageable pageable);
    Contract findById(Long id);

    void save(Contract contract);
    void remove(Long id);
}
