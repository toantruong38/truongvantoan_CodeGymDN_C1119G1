package com.admin.controller;

import com.admin.model.Customer;
import com.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @GetMapping("/create-customer")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView=new ModelAndView("/customer/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @GetMapping("/")
    public String listCustomer(Model model){
        System.out.println("C,listCustomer");
        model.addAttribute("customerList",customerService.findAll());
        System.out.println("Customer : "+customerService.findAll().get(0).toString());
        return "/customer/list";
    }
//    @PostMapping("/create-customer") //suspected
//    public ModelAndView saveCustomer(@ModelAttribute Customer customer){
//        customerService.save(customer);
//        ModelAndView modelAndView=new ModelAndView("/customer/create");
//        modelAndView.addObject("customer",new Customer());
//        modelAndView.addObject("message","Create Oke");
//        return modelAndView;
//    }
    @PostMapping("/create-customer")
    public String saveCustomer(Customer customer, RedirectAttributes redirectAttributes)
    {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Create oke");
        return "redirect:/";
    }
    @GetMapping("/edit-customer/{id}")
    public ModelAndView editCustomer(@PathVariable long id)
    {
        ModelAndView mav=new ModelAndView("/customer/edit");
        mav.addObject("customer",customerService.findById(id));
        return mav;
    }
    @PostMapping("/edit-customer")
    public String editCustomer(Customer customer,RedirectAttributes redirectAttributes)
    {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Edit oke");
        return "redirect:/";
    }
    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable long id,RedirectAttributes redirectAttributes)
    {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","Delete Oke");
        return "redirect:/";
    }
}
