package Models;

public abstract class Person
{
    protected String fullName;

    protected String birth;

    protected String cmnd;

    protected String phoneNumber;

    protected String email;

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
        return this.birth;
    }

    public void setBirth(String birth)
    {
        this.birth = birth;
    }

    public String getCmnd()
    {
        return this.cmnd;
    }

    public void setCmnd(String cmnd)
    {
        this.cmnd = cmnd;
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

}
