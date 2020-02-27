package com.toantr.app.controller;

import com.toantr.app.model.Customer;
import com.toantr.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public ModelAndView home(Pageable pageable){
        //Page<Customer> customers;
        return new ModelAndView("home","customers",customerService.findAll(pageable));
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam String name, Pageable pageable){
        pageable=PageRequest.of(0,2);
        return new ModelAndView("home","customers"
                ,customerService.findCustomersNameLike(pageable, name));
    }
}
