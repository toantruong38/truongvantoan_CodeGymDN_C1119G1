package com.toantr.webapp.persistence.model.customertype;

import com.toantr.webapp.persistence.model.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private Long id;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    private String name;

    public CustomerType(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
