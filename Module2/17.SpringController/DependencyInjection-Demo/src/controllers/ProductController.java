package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import services.ProductService;

@Controller
@ComponentScan("entities")
public class ProductController
{
    @Autowired
    private ProductService productService
}
