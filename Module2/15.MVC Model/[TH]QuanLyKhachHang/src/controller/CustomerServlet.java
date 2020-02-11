package controller;

import model.Customer;
import service.CustomerImplService;
import service.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet
{
    private CustomerService customerService=new CustomerImplService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action =request.getParameter("action");
        if(action==null) action="";

        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                editCustomer(request,response);
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        String action =request.getParameter("action");
        if(action==null) action="";

        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showCreateForm(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "view":
                break;
            default:
                listCustomers(request,response);
                break;
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int id=Integer.parseInt(request.getParameter("id"));
        Customer newCustomer=new Customer(id,name,email,address);
        customerService.addCustomer(id,newCustomer);

        response.sendRedirect("/customer");
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        RequestDispatcher dp=request.getRequestDispatcher("customer/create.jsp");
        dp.forward(request,response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Customer> customers=customerService.getAllCustomers();
        request.setAttribute("customers",customers);

        RequestDispatcher dp=request.getRequestDispatcher("customer/list.jsp");
        dp.forward(request,response);

    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        int id=Integer.parseInt(request.getParameter("id"));

        customerService.deleteCustomer(id);

        response.sendRedirect("/customer");
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        int id=customerService.getAllCustomers().size()+1;
        Customer newCustomer=new Customer(id,name,email,address);
        customerService.addCustomer(id,newCustomer);

        response.sendRedirect("/customer");
    }
}
