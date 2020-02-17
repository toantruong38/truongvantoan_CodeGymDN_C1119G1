package com.admin.service;

import com.admin.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService
{
    private static Map<Integer,Product> productMap;
    static {
        productMap=new HashMap<>();

        productMap.put(1,new Product(1,"Nokia 1080",80,"Good.Strength.Cheap.Basic uses"
                ,"Nokia"));
        productMap.put(2,new Product(2,"Iphone XS",800,"Expensive.Fast.Vulnerable"
                ,"Tim Cook"));
        productMap.put(3,new Product(3,"Xiaomi Mi 8",100,"Cheap.Long battery.High ram,storage"
                ,"China"));
        productMap.put(4,new Product(4,"Google Oneplus",120,"Good camera.Stable",
                "Google"));
        productMap.put(5,new Product(5,"Htc one m8",70,"Good.Cheap","HTC"));
    }
    @Override
    public List<Product> findAll()
    {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id)
    {
        return productMap.get(id);
    }

    @Override
    public void create(Product product)
    {
        productMap.put(product.getId(),product);
    }

    @Override
    public void delete(int id)
    {
        productMap.remove(id);
    }

    @Override
    public void update(int id, Product product)
    {
        productMap.put(id,product);
    }

    @Override
    public Product findByName(String name)
    {
        ArrayList<Product> products=new ArrayList<>(productMap.values());
        for(Product p:products)
        {
            if(p.getName().equals(name))
            {
                return p;
            }
        }
        return null;
    }
}
