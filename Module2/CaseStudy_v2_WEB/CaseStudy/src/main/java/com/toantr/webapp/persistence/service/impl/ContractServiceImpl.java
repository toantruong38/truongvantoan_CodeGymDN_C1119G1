package com.toantr.webapp.persistence.service.impl;

import com.toantr.webapp.persistence.model.contract.Contract;
import com.toantr.webapp.persistence.repo.ContractRepo;
import com.toantr.webapp.persistence.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContractServiceImpl implements ContractService
{
    @Autowired
    private ContractRepo contractRepo;
    @Override
    public Page<Contract> findAll(Pageable pageable)
    {
        return contractRepo.findAll(pageable);
    }

    @Override
    public Contract findById(Long id)
    {
        return contractRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract)
    {
        contractRepo.save(contract);
    }

    @Override
    public void remove(Long id)
    {
        contractRepo.deleteById(id);
    }
}
