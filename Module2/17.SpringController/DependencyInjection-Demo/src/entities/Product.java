package entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import services.ProductService;
import services.ProductServiceImpl;

/**
 * Các thuộc tính của sản phẩm bao gồm:
 * id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
 */
@Component
@ComponentScan("controllers")
public class Product
{
    private int id;
    private String productName;
    private double price;
    private String description;
    private String producer;

    public Product(int id, String productName, double price, String description, String producer)
    {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.producer = producer;
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProductName()
    {
        return this.productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public double getPrice()
    {
        return this.price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getProducer()
    {
        return this.producer;
    }

    public void setProducer(String producer)
    {
        this.producer = producer;
    }

    public Product()
    {
    }

    @Bean
    public static ProductService productService(){
        return new ProductServiceImpl();
    }
}
