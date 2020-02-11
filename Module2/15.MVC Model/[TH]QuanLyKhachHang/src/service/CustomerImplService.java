package service;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerImplService implements CustomerService
{
    private static Map<Integer,Customer> customers;

    static {
        customers=new HashMap<>();
        customers.put(1,new Customer(1,"John Wick","wick_action@mail.com","New York City"));
        customers.put(2,new Customer(2,"Constantine","gotoHell@mail.com","Texas"));
        customers.put(3,new Customer(3,"Neo","neo@mail.com","California"));
        customers.put(4,new Customer(4,"Keanu Reeves","kn_revs@mail.com","Florida"));
        customers.put(5,new Customer(5,"Genji","genOvw@mail.com","Japan"));
        customers.put(6,new Customer(6,"Mei","meiCN@mail.com","China"));
    }
    @Override
    public ArrayList<Customer> getAllCustomers()
    {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(int id)
    {
        return customers.get(id);
    }

    @Override
    public boolean addCustomer(int id,Customer newCustomer)
    {
        boolean doesExist=customers.get(id)!=null?true:false;

        customers.put(id,newCustomer);

        return true;
    }

    @Override
    public boolean deleteCustomer(int id)
    {
        customers.remove(id);
        return true;
    }
}
