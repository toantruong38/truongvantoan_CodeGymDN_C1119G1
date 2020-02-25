package com.toantr.webapp.persistence.model;

import com.toantr.webapp.persistence.model.contract.Contract;
import com.toantr.webapp.persistence.model.renttype.RentType;
import com.toantr.webapp.persistence.model.servicetype.ServiceType;

import javax.persistence.*;
import java.util.List;

//TODO Transactional
// TODO Formatter
// TODO Relational
// TODO rentType suspected
@Entity
public class Service
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="service_id")
    private Long id;

    @ManyToOne(targetEntity = ServiceType.class)
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    private double area;
    @Column(name = "floor_amount")
    private int floorAmount;
    @Column(name = "maximum_people")
    private int maximumPeople;
    @Column(name = "rent_fee")
    private long rentFee;
    @Column(name = "room_standard")
    private String roomStandard;
    @Column(name = "other_convenience_description")
    private String otherConvenienceDescription;
    @Column(name = "free_accompany_service")
    private String freeAccompanyService;

    @ManyToOne(targetEntity = RentType.class)
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contracts;

    private String status;

    public Service(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public ServiceType getServiceType()
    {
        return this.serviceType;
    }

    public void setServiceType(ServiceType serviceType)
    {
        this.serviceType = serviceType;
    }

    public double getArea()
    {
        return this.area;
    }

    public void setArea(double area)
    {
        this.area = area;
    }

    public int getFloorAmount()
    {
        return this.floorAmount;
    }

    public void setFloorAmount(int floorAmount)
    {
        this.floorAmount = floorAmount;
    }

    public int getMaximumPeople()
    {
        return this.maximumPeople;
    }

    public void setMaximumPeople(int maximumPeople)
    {
        this.maximumPeople = maximumPeople;
    }

    public long getRentFee()
    {
        return this.rentFee;
    }

    public void setRentFee(long rentFee)
    {
        this.rentFee = rentFee;
    }

    public RentType getRentType()
    {
        return this.rentType;
    }

    public void setRentType(RentType rentType)
    {
        this.rentType = rentType;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public String getFreeAccompanyService()
    {
        return this.freeAccompanyService;
    }

    public void setFreeAccompanyService(String freeAccompanyService)
    {
        this.freeAccompanyService = freeAccompanyService;
    }

    public List<Contract> getContracts()
    {
        return this.contracts;
    }

    public void setContracts(List<Contract> contracts)
    {
        this.contracts = contracts;
    }
}
