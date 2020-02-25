package com.toantr.webapp.persistence.model.house;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class House
{
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
    private Long id;

    private String freeAccompanyService;

    public House(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFreeAccompanyService()
    {
        return this.freeAccompanyService;
    }

    public void setFreeAccompanyService(String freeAccompanyService)
    {
        this.freeAccompanyService = freeAccompanyService;
    }
}
