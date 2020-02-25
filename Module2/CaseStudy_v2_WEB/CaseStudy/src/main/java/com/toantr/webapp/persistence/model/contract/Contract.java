package com.toantr.webapp.persistence.model.contract;

import com.toantr.webapp.persistence.model.Service;
import com.toantr.webapp.persistence.model.contractdetail.ContractDetail;
import com.toantr.webapp.persistence.model.customer.Customer;
import com.toantr.webapp.persistence.model.employee.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contract
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Long id;

    @Column(name = "contract_number")
    private String contractNumber;
    @Column(name = "begin_date")
    private Date beginDate;
    @Column(name = "end_date")
    private Date endDate;
    private long deposit;
    @Column(name = "total_pay")
    private long totalPay;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToMany(targetEntity = ContractDetail.class)
    private List<ContractDetail> contractDetails;

    public Contract(){}

    public Long getId()
    {
        return this.id;
    }

    public Service getService()
    {
        return this.service;
    }

    public void setService(Service service)
    {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails()
    {
        return this.contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails)
    {
        this.contractDetails = contractDetails;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getContractNumber()
    {
        return this.contractNumber;
    }

    public void setContractNumber(String contractNumber)
    {
        this.contractNumber = contractNumber;
    }

    public Date getBeginDate()
    {
        return this.beginDate;
    }

    public void setBeginDate(Date beginDate)
    {
        this.beginDate = beginDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public long getDeposit()
    {
        return this.deposit;
    }

    public void setDeposit(long deposit)
    {
        this.deposit = deposit;
    }

    public long getTotalPay()
    {
        return this.totalPay;
    }

    public void setTotalPay(long totalPay)
    {
        this.totalPay = totalPay;
    }

    public Customer getCustomer()
    {
        return this.customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }

    public Employee getEmployee()
    {
        return this.employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
