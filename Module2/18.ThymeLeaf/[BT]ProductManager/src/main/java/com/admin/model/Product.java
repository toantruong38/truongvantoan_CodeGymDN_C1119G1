package com.admin.model;

//id, tên sản phẩm, giá sản phẩm, mô tả của sản phẩm, nhà sản xuất.
public class Product
{
    private int id;
    private String name;
    private double price;
    private String description;
    private String producer;

    public Product(){};

    public Product(int id, String name, double price, String description, String producer)
    {
        this.id = id;
        this.name = name;
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
}
