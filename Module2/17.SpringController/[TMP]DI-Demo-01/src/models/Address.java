package models;

import org.springframework.stereotype.Component;

@Component
public class Address
{
    public String city;
    public String state;
    public String country;

    public Address(String city,String state,String country)
    {
        //super();
        this.city=city;
        this.country=country;
        this.state=state;
    }

    public String toString(){
        return "City "+city+" State "+ state+" country "+country;
    }
}
