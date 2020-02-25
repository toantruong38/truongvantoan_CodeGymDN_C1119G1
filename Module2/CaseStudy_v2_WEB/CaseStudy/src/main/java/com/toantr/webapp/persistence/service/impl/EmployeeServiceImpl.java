package com.toantr.webapp.persistence.service.impl;

import com.toantr.webapp.persistence.model.employee.Employee;
import com.toantr.webapp.persistence.repo.EmployeeRepo;
import com.toantr.webapp.persistence.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable)
    {
        return employeeRepo.findAllWhereNameBeLike(name, pageable);
    }

    @Override
    public Page<Employee> findEmployeesHaveContract(Pageable pageable)
    {
        return employeeRepo.findEmployeesHaveContract(pageable);
    }

    @Override
    public void save(Employee employee)
    {
        employeeRepo.save(employee);
    }

    @Override
    public void remove(Long id)
    {
        employeeRepo.deleteById(id);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable)
    {
        return employeeRepo.findAll(pageable);
    }

    @Override
    public Employee findById(Long id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}
