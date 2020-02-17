package models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee
{
    public int id;
    public String name;
    @Autowired
    public Address address;

    public Employee(){
        System.out.println("Employee created");
    }

    public Employee(int id,String name,Address address)
    {
        this.id=id;
        this.name=name;
        this.address=address;
    }

    public void show(){
        System.out.println("id "+id+" name "+name);
        System.out.println(address.toString());
    }
}
