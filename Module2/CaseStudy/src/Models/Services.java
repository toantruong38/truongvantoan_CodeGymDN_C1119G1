package Models;

public abstract class Services
{
    protected String serviceName;
    protected double area;
    protected long rentFee;
    protected int maxPerson;
    protected String rentType;
    protected String id;

    public abstract String getServiceName();

    public abstract void setServiceName(String serviceName);

    public abstract double getArea();

    public abstract void setArea(double area);

    public abstract long getRentFee();

    public abstract void setRentFee(long rentFee);

    public abstract int getMaxPerson();

    public abstract void setMaxPerson(int maxPerson);

    public abstract String getRentType();

    public abstract void setRentType(String rentType);

    public abstract String showInfor();

    public abstract String getId();

    public abstract void setId(String id);
}





