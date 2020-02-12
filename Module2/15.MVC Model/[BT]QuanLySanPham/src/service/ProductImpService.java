package service;

import model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductImpService implements ProductService
{
    private static Map<Integer,Product> products;

    static{
        products=new HashMap<>();

        products.put(1,new Product(1,"Iphone 10",13000000,"Đừng mua","Steve Jobs"));
        products.put(2,new Product(2,"Iphone 4",3000000,"Đừng mua","Steve Jobs"));
        products.put(3,new Product(3,"Iphone SE",6000000,"Đừng mua","Steve Jobs"));
        products.put(4,new Product(4,"Iphone 7s",9000000,"Đừng mua","Steve Jobs"));
        products.put(5,new Product(5,"Iphone XS",30000000,"Đừng mua","Steve Jobs"));
        products.put(6,new Product(6,"Iphone 3",130000000,"Đừng mua","Steve Jobs"));
    }

    @Override
    public void addProduct(int id, Product newProduct)
    {
        products.put(id,newProduct);
    }

    @Override
    public void deleteProduct(int id)
    {
        products.remove(id);
    }

    @Override
    public Product searchProduct(String name)
    {
        ArrayList<Product> prds= new ArrayList<>(products.values());

        for(Product p: prds){
            if(p.getName().equals(name)) return p;
        }

        return null;
    }

    @Override
    public ArrayList<Product> getAllProducts()
    {
        return new ArrayList<Product>(products.values());
    }
}
