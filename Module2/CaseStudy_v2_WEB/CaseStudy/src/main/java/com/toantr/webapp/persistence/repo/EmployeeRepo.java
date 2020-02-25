package com.toantr.webapp.persistence.repo;

import com.toantr.webapp.persistence.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long>
{
    @Query("select e from Employee e where e.fullName like %?1%")
    Page<Employee> findAllWhereNameBeLike(String name, Pageable pageable);

    @Query("select e from Employee e inner join Contract c on c.employee.id=e.id")
    Page<Employee> findEmployeesHaveContract(Pageable pageable);
}
