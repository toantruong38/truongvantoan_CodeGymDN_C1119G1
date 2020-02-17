package dao;

import entities.Product;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListProducts
{
    private static Map<Integer, Product> products;

    static {
        products=new HashMap<>();

        products.put(1,new Product(1,"Nokia 1080",80,"Good.Strength.Cheap.Basic uses"
        ,"Nokia"));
        products.put(2,new Product(2,"Iphone XS",800,"Expensive.Fast.Vulnerable"
                ,"Tim Cook"));
        products.put(3,new Product(3,"Xiaomi Mi 8",100,"Cheap.Long battery.High ram,storage"
                ,"China"));
        products.put(4,new Product(4,"Google Oneplus",120,"Good camera.Stable",
                "Google"));
        products.put(5,new Product(5,"Htc one m8",70,"Good.Cheap","HTC"));
    }

    public static ArrayList<Product> listProducts(){
        return new ArrayList<>(products.values());
    }
}
