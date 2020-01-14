package Models;

public class Customer
{
    private String fullName;
    private String birth;
    private String gender;
    private String id;
    private String phoneNum;
    private String email;
    private String customerType;
    private String addr;
    private String cmnd;

    public String getCmnd()
    {
        return cmnd;
    }

    public void setCmnd(String cmnd)
    {
        this.cmnd = cmnd;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getAddr()
    {
        return addr;
    }

    public void setAddr(String addr)
    {
        this.addr = addr;
    }

    public String getBirth()
    {
        return birth;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(String customerType)
    {
        this.customerType = customerType;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPhoneNum()
    {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
    }
}
