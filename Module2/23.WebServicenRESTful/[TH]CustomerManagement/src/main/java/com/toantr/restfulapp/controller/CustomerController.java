package com.toantr.restfulapp.controller;

import com.toantr.restfulapp.persistence.model.Customer;
import com.toantr.restfulapp.persistence.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerService customerService;
    private RestTemplate restTemplate=new RestTemplate();
//    @Autowired
//    private RestTemplate restTemplate;

    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> handleGetAll(){
//        List<Customer> customers=new ArrayList<>();
//        Iterable<Customer> iterable=customerService.findAll();
//        iterable.forEach(customers::add);
//        return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
        List<Customer> customers=customerService.findAll();
        if (customers.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers,HttpStatus.OK);
    }
    @RequestMapping(value = "/customers/{id}",method = RequestMethod.GET)
    public ResponseEntity<Customer> handleGetOne(@PathVariable Long id){
        Customer customer=customerService.findById(id);
        if(customer!=null){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/customers",method = RequestMethod.POST)
    public ResponseEntity<Customer> handlePostOne(@RequestBody Customer customer){
        customerService.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @RequestMapping(value = "/customers/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Customer> handleUpdateOne(@RequestBody Customer customer,@PathVariable Long id){
        customer.setId(id);
        customerService.save(customer);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
    @RequestMapping(value = "/customers/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Customer> handleDeleteOne(@PathVariable Long id)
    {
        Customer customer=customerService.findById(id);
        customerService.delete(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }
}
