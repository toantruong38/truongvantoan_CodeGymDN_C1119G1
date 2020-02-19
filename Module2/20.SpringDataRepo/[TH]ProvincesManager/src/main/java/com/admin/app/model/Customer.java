package com.admin.app.model;

import javax.persistence.*;

@Entity
@Table(name="customers")
public class Customer
{
    public Customer(){}
    public Customer(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name="province_id")
    private Province province;

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Province getProvince()
    {
        return this.province;
    }

    public void setProvince(Province province)
    {
        this.province = province;
    }

    @Override
    public String toString(){
        return String.format(
                "Customer: [id=%d,firstName=%s,lastName=%s]",
                id,firstName,lastName
        );
    }
}
