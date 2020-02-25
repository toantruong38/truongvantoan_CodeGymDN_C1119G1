package com.toantr.webapp.controller;

import com.toantr.webapp.persistence.model.customer.Customer;
import com.toantr.webapp.persistence.model.customertype.CustomerType;
import com.toantr.webapp.persistence.repo.CustomerTypeRepo;
import com.toantr.webapp.persistence.service.CustomerService;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController
{
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeRepo customerTypeRepo;
    @ModelAttribute("customerTypes")
    private List<CustomerType> customerTypes()
    {
        return customerTypeRepo.getAll();
    }
    @ModelAttribute("customers")
    private List<Customer> customers(){
        return customerService.findAll();
    }
    @GetMapping("/")
    public String handleHomePage(){
        return "home";
    }
    @GetMapping("/customer")
    public String handleCustomerPage(
            @RequestParam(name = "page",required = false,defaultValue = "0")int page,
            @RequestParam(name="size",required = false,defaultValue = "5")int size,
            @RequestParam(name = "sort",required = false,defaultValue = "ASC")String sort,
            @RequestParam(name = "sortValue",required = false,defaultValue = "fullName") String sortValue,
            Model model, Pageable pageable, Sort sortable
            )
    {
        if(sort.equals("ASC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).descending();
            }
            else{
                sortable=Sort.by(sortValue).ascending();
            }
        }
        if(sort.equals("DESC"))
        {
            if(sortable.isSorted()){
                sortable= Sort.by(sortValue).ascending();
            }
            else{
                sortable=Sort.by(sortValue).descending();
            }
        }
        pageable=PageRequest.of(page, size,sortable);
        model.addAttribute("customers",customerService.findAll(pageable));
        return "customer/display";
    }
    @GetMapping("/customer/new") //TODO valid customer
    public ModelAndView handleNewCustomer(){
        return new ModelAndView("customer/new","customer",new Customer());
    }
    @PostMapping("/customer/new")
    public String handleSaveCustomer(Customer customer, RedirectAttributes redirectAttributes)
    {
        customerService.save(customer);//TODO catch ParseException
        redirectAttributes.addFlashAttribute("status","Added successfully!");
        return "redirect:/customer/new";
    }
    @GetMapping("/customer/edit/{id}")
    public String handleUpdateCustomer(@PathVariable Long id,Model model)
    {
        model.addAttribute("customer",customerService.findById(id));
        return "customer/edit";
    }
    @PostMapping("/customer/edit")
    public String handleUpdateCustomer(Customer customer,RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("status","Updated successfully!");
        return "redirect:/customer";
    }
}
