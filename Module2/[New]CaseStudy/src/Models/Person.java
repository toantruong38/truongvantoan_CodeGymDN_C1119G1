package Models;

public abstract class Person
{
    public final static String PERSON_URL = "C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\" +
            "truongvantoan_CodeGymDN_C1119G1\\Module2\\[New]CaseStudy\\src\\Data\\";

    public final static String PERSON_LABEL = "fullName,birth,cmnd,phoneNumber,email";

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
