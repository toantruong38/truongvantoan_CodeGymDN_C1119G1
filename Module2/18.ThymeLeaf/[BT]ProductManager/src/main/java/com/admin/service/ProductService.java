package com.admin.service;

import com.admin.model.Product;

import java.util.List;

//Hiển thị danh sách sản phẩm
//Tạo sản phẩm mới
//Cập nhật thông tin sản phẩm
//Xoá một sản phẩm
//Xem chi tiết một sản phẩm
//Tìm kiếm sản phẩm theo tên
public interface ProductService
{
    List<Product> findAll();
    Product findById(int id);
    void create(Product product);
    void delete(int id);
    void update(int id,Product product);
    Product findByName(String name);
}
