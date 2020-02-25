package com.toantr.webapp.persistence.model.room;

import com.toantr.webapp.persistence.model.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Room extends Service
{
/*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
*/
    private Long id;

    private String roomStandard;
    private String otherConvenienceDescription;
    private int floorAmount;

    public Room(){}

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

    public int getFloorAmount()
    {
        return this.floorAmount;
    }

    public void setFloorAmount(int floorAmount)
    {
        this.floorAmount = floorAmount;
    }
}
