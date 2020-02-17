package controllers;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.CustomerService;
import service.CustomerServiceImpl;

@Controller
public class CustomerController
{
    private CustomerService customerService=new CustomerServiceImpl();

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("customers",customerService.findAll());
        return "index";
    }

    @GetMapping("/customers/create")
    public String create(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
}
