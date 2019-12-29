package Models;

public class Room extends Services
{
    private String accompanyService;

    public String getAccompanyService()
    {
        return this.accompanyService;
    }

    public void setAccompanyService(String accompanyService)
    {
        this.accompanyService = accompanyService;
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
        return "Room";
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
}
