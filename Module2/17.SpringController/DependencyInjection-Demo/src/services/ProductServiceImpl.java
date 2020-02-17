package services;

import dao.ListProducts;
import entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{

    private ArrayList<Product> listProducts= ListProducts.listProducts();
    @Override
    public void addProduct(Product product)
    {
        listProducts.add(product);
    }

    @Override
    public Product search(String productName)
    {
        for(Product product:listProducts)
        {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts()
    {
        return listProducts;
    }

    @Override
    public void removeProduct(int id)
    {
        for(Product product:listProducts)
        {
            if(product.getId()==id){
                listProducts.remove(product);
            }
        }
    }

}
