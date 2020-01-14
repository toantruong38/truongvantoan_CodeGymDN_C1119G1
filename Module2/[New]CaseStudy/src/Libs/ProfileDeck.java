package Libs;

import Models.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class ProfileDeck
{
    private static Stack<Employee> employeeStack = new Stack<>();

    public static void add(ArrayList<Employee> employees)
    {
        employeeStack.addAll(employees);
    }

    public static Employee search(String employeeName)
    {
        Employee emp = new Employee();
        emp.setEmployeeData();

        Map<String, Employee> employeeMap = Employee.employeeMap;

        Iterator emp_iter = employeeMap.values().iterator();

        while (emp_iter.hasNext())
        {
            employeeStack.add((Employee) emp_iter.next());
        }

        for (int i = 0; i < employeeStack.size(); i++)
        {

            if (employeeStack.get(i).getFullName().equals(employeeName))
            {

                return employeeStack.get(i);
            }
        }
        return null;
    }
}
