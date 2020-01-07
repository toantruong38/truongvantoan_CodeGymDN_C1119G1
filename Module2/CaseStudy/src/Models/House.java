package Models;

public class House extends Services
{
    private String roomStandard;
    private String convenientDescr;
    private short floorAmount;

    public short getFloorAmount()
    {
        return this.floorAmount;
    }

    public void setFloorAmount(short floorAmount)
    {
        this.floorAmount = floorAmount;
    }

    public String getRoomStandard()
    {
        return this.roomStandard;
    }

    public void setRoomStandard(String roomStandard)
    {
        this.roomStandard = roomStandard;
    }

    public String getConvenientDescr()
    {
        return this.convenientDescr;
    }

    public void setConvenientDescr(String convenientDescr)
    {
        this.convenientDescr = convenientDescr;
    }

    @Override
    public String getServiceName()
    {
        return this.serviceName;
    }

    @Override
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    @Override
    public double getArea()
    {
        return this.area;
    }

    @Override
    public void setArea(double area)
    {
        this.area = area;
    }

    @Override
    public long getRentFee()
    {
        return this.rentFee;
    }

    @Override
    public void setRentFee(long rentFee)
    {
        this.rentFee = rentFee;
    }

    @Override
    public int getMaxPerson()
    {
        return this.maxPerson;
    }

    @Override
    public void setMaxPerson(int maxPerson)
    {
        this.maxPerson = maxPerson;
    }

    @Override
    public String getRentType()
    {
        return this.rentType;
    }

    @Override
    public void setRentType(String rentType)
    {
        this.rentType = rentType;
    }

    @Override
    public String showInfor()
    {
        return "House";
    }

    @Override
    public String getId()
    {
        return this.id;
    }

    @Override
    public void setId(String id)
    {
        this.id = id;
    }

    @Override
    public String getAccompanyService()
    {
        return this.accompanyService;
    }

    @Override
    public void setAccompanyService(String accompanyService)
    {
        this.accompanyService = accompanyService;
    }
}