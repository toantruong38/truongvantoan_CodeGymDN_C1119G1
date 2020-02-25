package com.toantr.webapp.persistence.model.villa;

import com.toantr.webapp.persistence.model.Service;

import javax.persistence.*;

//@Entity
public class Villa extends Service
{
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
    private Long id;

    private String roomStandard;
    private String otherConvenienceDescription;
    private double poolArea;
    private int floorAmount;

    public Villa(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getRoomStandard()
    {
        return this.roomStandard;
    }

    public void setRoomStandard(String roomStandard)
    {
        this.roomStandard = roomStandard;
    }

    public String getOtherConvenienceDescription()
    {
        return this.otherConvenienceDescription;
    }

    public void setOtherConvenienceDescription(String otherConvenienceDescription)
    {
        this.otherConvenienceDescription = otherConvenienceDescription;
    }

    public double getPoolArea()
    {
        return this.poolArea;
    }

    public void setPoolArea(double poolArea)
    {
        this.poolArea = poolArea;
    }

    public int getFloorAmount()
    {
        return this.floorAmount;
    }

    public void setFloorAmount(int floorAmount)
    {
        this.floorAmount = floorAmount;
    }
}
