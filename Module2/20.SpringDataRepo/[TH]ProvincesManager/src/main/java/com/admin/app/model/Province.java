package com.admin.app.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="provinces")
public class Province
{
    public Province(){}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="province_id")
    private long id;

    private String name;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customers;

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
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

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }
}
