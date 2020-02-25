package com.toantr.webapp.persistence.model.renttype;

import com.toantr.webapp.persistence.model.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_type_id")
    private Long id;

    private String name;
    private long price;

    @OneToMany(targetEntity = Service.class)
    @JoinColumn(name="service_id")
    private List<Service> services;

    public RentType(){}

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

    public long getPrice()
    {
        return this.price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    public List<Service> getServices()
    {
        return this.services;
    }

    public void setServices(List<Service> services)
    {
        this.services = services;
    }
}
