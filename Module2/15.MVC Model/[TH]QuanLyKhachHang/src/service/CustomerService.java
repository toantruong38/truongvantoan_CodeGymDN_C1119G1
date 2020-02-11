package service;

import model.Customer;

import java.util.ArrayList;

public interface CustomerService
{
    ArrayList<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    boolean addCustomer(int id,Customer newCustomer);
    boolean deleteCustomer(int id);
}
