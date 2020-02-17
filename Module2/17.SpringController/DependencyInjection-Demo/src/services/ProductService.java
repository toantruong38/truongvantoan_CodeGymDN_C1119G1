package services;

import entities.Product;
import repositories.ProductRepo;


/**
 * Hiển thị danh sách sản phẩm
 * Tạo sản phẩm mới
 * Cập nhật thông tin sản phẩm
 * Xoá một sản phẩm
 * Xem chi tiết một sản phẩm
 * Tìm kiếm sản phẩm theo tên
 */
public interface ProductService extends ProductRepo
{
    void addProduct(Product product);
    Product search(String productName);
}
