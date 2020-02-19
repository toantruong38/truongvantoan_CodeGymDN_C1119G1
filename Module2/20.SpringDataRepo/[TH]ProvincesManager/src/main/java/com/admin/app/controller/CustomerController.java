package com.admin.app.controller;

import com.admin.app.model.Customer;
import com.admin.app.service.CustomerService;
import com.admin.app.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/customers")
    public String customers(Model model){
        model.addAttribute("customers",
                customerService.findAll());
        return "customer/customers";
    }

    @GetMapping("/customer-edit/{id}")
    public String save(@PathVariable long id,Model model)
    {
        model.addAttribute("customer",
                customerService.findById(id));
        model.addAttribute("provinces",provinceService.findAll());
        return "customer/edit";
    }
    @PostMapping("/customer-edit")
    public String save(Customer customer,
                       RedirectAttributes redirectAttributes)
    {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("status",
                "Edit oke");
        return "redirect:/customers";
    }
    @GetMapping("/customer-remove/{id}")
    public String remove(@PathVariable long id,RedirectAttributes
                         redirectAttributes)
    {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("status"
        ,"delete oke");
        return "redirect:/customers";
    }
    @GetMapping("/customer-add") //test case
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView=new ModelAndView("/customer/add");
        modelAndView.addObject("customer",new Customer());
        modelAndView.addObject("provinces",provinceService.findAll());
        return  modelAndView;
    }
    @PostMapping("/customer-add")
    public String add(Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("status","add oke");
        return "redirect:/customers";
    }
}
