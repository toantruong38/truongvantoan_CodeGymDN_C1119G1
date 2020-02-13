package model;

public class User
{
    private String user;
    private String pass;
    private String name;
    private String email;
    private int age;

    public User()
    {
    }

    public User(String user, String pass, String name, String email, int age)
    {
        this.user = user;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
