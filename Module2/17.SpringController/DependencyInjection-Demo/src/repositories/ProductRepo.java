package repositories;

import entities.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepo
{
    ArrayList<Product> getAllProducts();
    void removeProduct(int id);
}
