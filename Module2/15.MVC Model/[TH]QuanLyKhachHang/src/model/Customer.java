package model;

public class Customer
{
    private int id;
    private String name;
    private String email;
    private String address;

    public Customer(){

    }
    public Customer(int id,String name,String email,String address){
        this.email=email;
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
