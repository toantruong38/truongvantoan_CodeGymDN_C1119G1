package Models;

public class AccompanyService
{
    private String serviceName;

    private String currency;

    private long cost;

    public String getServiceName()
    {
        return this.serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getCurrency()
    {
        return this.currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public long getCost()
    {
        return this.cost;
    }

    public void setCost(long cost)
    {
        this.cost = cost;
    }
}
