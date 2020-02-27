package com.toantr.webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Authority
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority(){}

    public Authority(AuthorityType name ){
        this.name=name;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public AuthorityType getName()
    {
        return this.name;
    }

    public void setName(AuthorityType name)
    {
        this.name = name;
    }
}
