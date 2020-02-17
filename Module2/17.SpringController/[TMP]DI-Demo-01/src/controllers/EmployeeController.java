package controllers;

import models.Employee;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class EmployeeController
{
    @GetMapping("/show")
    public String getEmployee(Model model)
    {
        //Employee employee=(Employee)new  FileSystemXmlApplicationContext("applicationContext").getBean("employee");
        //BeanFactory factory=new XmlBeanFactory(r);

        //Employee employee=(Employee)factory.getBean("employee");

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee=(Employee)context.getBean("employee");
        model.addAttribute("employee",employee);

        return "displayEmployee";
    }
}
