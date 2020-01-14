package Models;

import java.util.HashMap;
import java.util.Map;

public class Employee extends Person implements ShowInformation
{
    public final static String EMPLOYEE_LABEL = ",degree,position,salary";

    public final static String EMPLOYEE_URL = "Employee.csv";

    private String degree;

    private String position;

    private long salary;
    // ---^ Employee only

    public static Map<String, Employee> employeeMap = new HashMap<>();

    public Employee()
    {
        //setEmployeeData();
    }

    public void setEmployeeData()
    {
        Employee nasus = new Employee();
        nasus.setFullName("Nasus");
        nasus.setPosition("League");
        nasus.setEmail("susan_321@gmail.com");
        Employee.employeeMap.put("001", nasus);

        Employee karma = new Employee();
        karma.setFullName("Karma");
        karma.setPosition("League");
        karma.setEmail("chokechoke_99@mmail.com");
        Employee.employeeMap.put("002", karma);

        Employee javascript = new Employee();
        javascript.setFullName("JS, Nodejs,React,TypeScript");
        javascript.setPosition("Programming");
        javascript.setEmail("sun_micro_system@contact.com");
        Employee.employeeMap.put("003", javascript);

        Employee genji = new Employee();
        genji.setFullName("Genji Shimada");
        genji.setPosition("Shimada, Overwatch");
        genji.setEmail("ninja_dude@shimada.js");
        Employee.employeeMap.put("004", genji);

        Employee mei = new Employee();
        mei.setFullName("MeiChina");
        mei.setPosition("China,Overwatch");
        mei.setEmail("mei_theDevil@hihi.es");
        Employee.employeeMap.put("005", mei);

        Employee constantine = new Employee();
        constantine.setFullName("Constantine aka JohnWick");
        constantine.setPosition("HollyWood Films");
        constantine.setEmail("I_love_Dogs@woof.com");
        Employee.employeeMap.put("006", constantine);

        Employee melodyMarks = new Employee();
        melodyMarks.setFullName("Melody Marks");
        melodyMarks.setPosition("Film actor");
        melodyMarks.setEmail("marks_melody@pornhub.com");
        Employee.employeeMap.put("007", melodyMarks);

        Employee mosh = new Employee();
        mosh.setFullName("Blah blah Mosh");
        mosh.setPosition("Youtube");
        mosh.setEmail("moshCoding@xx.com");
        Employee.employeeMap.put("008", mosh);

        Employee draven = new Employee();
        draven.setFullName("Draven");
        draven.setPosition("League");
        draven.setEmail("draven_league@gmail.com");
        Employee.employeeMap.put("009", draven);

        Employee orisa = new Employee();
        orisa.setFullName("Orisa the shield");
        orisa.setPosition("Overwatch");
        orisa.setEmail("orisa@aa.com");
        Employee.employeeMap.put("010", orisa);
    }


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

    @Override
    public String showInformation()
    {
        return "--------------Employee---------------"
                + "\n" + "Full name: " + this.getFullName()
                + "\n" + "Chung minh: " + this.getCmnd()
                + "\n" + "Email: " + this.getEmail()
                + "\n" + "Birth: " + this.getBirth()
                + "\n" + "Phone number: " + this.getPhoneNumber()
                + "\n" + "Degree: " + this.getDegree()
                + "\n" + "Position: " + this.getPosition()
                + "\n" + "Salary: " + this.getSalary();
    }
    // ---^ Employee only

}
