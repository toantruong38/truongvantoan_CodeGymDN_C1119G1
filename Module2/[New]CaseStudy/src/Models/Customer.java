package Models;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer extends Person implements ShowInformation
{
    private ArrayList<Services> services;

    private String gender;

    private String customerType;

    private String address;

    private ArrayList<Contract> contracts;
    //---^ Customer only

    //----^ From Person abstract class

    public ArrayList<Services> getServices()
    {
        return this.services;
    }

    public void setService(Services service)
    {
        if (service instanceof Villa)
        {
            this.services.add(service);
            System.out.println("----------Villa Contract---------");
            this.contracts.add(Contract.setContractInformation());
        } else if (service instanceof House)
        {
            this.services.add(service);
            System.out.println("----------House Contract---------");
            this.contracts.add(Contract.setContractInformation());
        } else if (service instanceof Room)
        {
            this.services.add(service);
        } else System.out.println("Failed to add Customer service!");
    }

    public ArrayList<Contract> getContracts()
    {
        return this.contracts;
    }

    public void setContract(Contract contract)
    {
        this.contracts.add(contract);
    }


    public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCustomerType()
    {
        return this.customerType;
    }

    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    //---^ Customer only


    //----^ From Person abstract class

    public String showInformation()
    {
        String output_information = "";

        //basic customer information
        output_information += "Full name: " + this.getFullName()
                + "\n" + "Birth: " + this.getBirth()
                + "\n" + "Gender: " + this.getGender()
                + "\n" + "Cmnd id: " + this.getCmnd()
                + "\n" + "Phone number: " + this.getPhoneNumber()
                + "\n" + "Email: " + this.getEmail()
                + "\n" + "Customer type: " + this.getCustomerType()
                + "\n" + "Address: " + this.getAddress();
        Iterator services = this.getServices().iterator();

        //Service
    }
}
