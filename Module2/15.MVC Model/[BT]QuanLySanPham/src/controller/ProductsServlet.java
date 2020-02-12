package controller;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import model.Product;
import service.ProductImpService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductsServlet",urlPatterns = "/products")
public class ProductsServlet extends HttpServlet
{
    ProductService productService=new ProductImpService();
    ArrayList<Product> products=productService.getAllProducts();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action=request.getParameter("action");
        if(action==null)action="";

        switch (action){
            case "add":
                addProduct(request,response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action=request.getParameter("action");
        if(action==null)action="";

        switch (action){
            case "add":
                showAddForm(request,response);
                break;
            case "save":
                addProduct(request, response);
                break;
            default:
                showProducts(request,response);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response)
    {
        int id=Integer.parseInt(request.getParameter("id"));
        System.out.println("id "+request.getParameter("id"));
        String name=request.getParameter("name");
        double price=Double.parseDouble(request.getParameter("price"));
        String description=request.getParameter("description");
        String producer=request.getParameter("producer");

        System.out.println("addProduct");

        productService.addProduct(id,new Product(id,name,price,description,producer));

        try
        {
            response.sendRedirect("/products");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("products",products);
        RequestDispatcher dp=request.getRequestDispatcher("product/addProduct.jsp");

        try
        {
            dp.forward(request, response);
        }catch(ServletException|IOException e){
            e.printStackTrace();
        }
    }

    private void showProducts(HttpServletRequest request, HttpServletResponse response)
    {
        RequestDispatcher dp=request.getRequestDispatcher("product/listProduct.jsp");
        try
        {
            request.setAttribute("products",products);
            dp.forward(request, response);
        }catch (ServletException|IOException e){
            e.printStackTrace();
        }
    }
}
