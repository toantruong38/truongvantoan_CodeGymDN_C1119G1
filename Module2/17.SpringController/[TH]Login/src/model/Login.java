package model;

public class Login
{
    private String user;
    private String pass;

    public Login()
    {
    }

    public Login(String user, String pass)
    {
        this.user = user;
        this.pass = pass;
    }

    public String getUser()
    {
        return this.user;
    }

    public void setUser(String user)
    {
        this.user = user;
    }

    public String getPass()
    {
        return this.pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }
}
