package com.toantr.webapp.persistence.model.customer;

import com.toantr.webapp.persistence.model.contract.Contract;
import com.toantr.webapp.persistence.model.customertype.CustomerType;
import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "full_name")
    private String fullName;
    private Date birth;
    private String gender;
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String email;
    private String address;

    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;


    public Customer(){}

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return this.fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getBirth()
    {
        return new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").format(this.birth);
    }

  /*  public void setBirth(Date birth)
    {
        this.birth = birth;
    }*/

    public void setBirth(String birth)throws ParseException
    {
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date date=(Date)dateFormat.parse(birth);
        this.birth=date;
    }

    public String getGender()
    {
        return this.gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getIdNumber()
    {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public CustomerType getCustomerType()
    {
        return this.customerType;
    }

    public void setCustomerType(CustomerType customerType)
    {
        this.customerType = customerType;
    }

    public List<Contract> getContractList()
    {
        return this.contractList;
    }

    public void setContractList(List<Contract> contractList)
    {
        this.contractList = contractList;
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
