package Models;

public class Employee
{
    public final static String EMPLOYEE_LABEL = ",degree,position,salary";

    public final static String EMPLOYEE_URL = "Employee.csv";

    private String degree;

    private String position;

    private long salary;
    // ---^ Employee only


    public String getDegree()
    {
        return this.degree;
    }

    public void setDegree(String degree)
    {
        this.degree = degree;
    }

    public String getPosition()
    {
        return this.position;
    }

    public void setPosition(String position)
    {
        this.position = position;
    }

    public long getSalary()
    {
        return this.salary;
    }

    public void setSalary(long salary)
    {
        this.salary = salary;
    }
    // ---^ Employee only

}
