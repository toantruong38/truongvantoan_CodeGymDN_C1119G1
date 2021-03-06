package com.toantr.webapp.persistence.model.degree;

import com.toantr.webapp.persistence.model.employee.Employee;

import javax.persistence.*;
import java.util.List;

@Entity
public class Degree
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id")
    private Long id;

    private String name;

    @OneToMany(targetEntity = Employee.class)
    private List<Employee> employees;

    public Degree(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Employee> getEmployees()
    {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }
}
