package service;

import model.Product;

import java.util.ArrayList;

public interface ProductService
{
    void addProduct(int id, Product newProduct);
    void deleteProduct(int id);
    Product searchProduct(String name);
    ArrayList<Product> getAllProducts();
}
