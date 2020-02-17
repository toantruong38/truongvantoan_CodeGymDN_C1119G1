package com.admin.controller;

import com.admin.model.Product;
import com.admin.service.ProductService;
import com.admin.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class ProductController
{
    ProductService productService=new ProductServiceImpl();
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("products",productService.findAll());
        System.out.println("c,h,p,"+productService.findAll().get(1).getName());
        return "home";
    }
    @PostMapping("/products/search")
    public String search(@RequestParam String name, RedirectAttributes redirectAttributes)
    {
        Product product=productService.findByName(name);
        if(product!=null){
            redirectAttributes.addFlashAttribute("product",product);
            return "redirect:/products/"+product.getId()+"/detail";
        }
        redirectAttributes.addFlashAttribute("status","Product Not Found!");
        return "redirect:/";
    }
    @GetMapping("/products/{id}/detail")
    public String detail(@PathVariable int id,Model model)
    {
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }
    @GetMapping("/products/{id}/edit")
    public String edit(@PathVariable int id,Model model)
    {
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/products/edit")
    public String edit(Product product,RedirectAttributes redirectAttributes)
    {
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("status","Update oke");
        return "redirect:/";
    }
    @GetMapping("/products/{id}/delete")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes)
    {
        productService.delete(id);
        redirectAttributes.addFlashAttribute("status","delete oke");
        return "redirect:/";
    }
    @GetMapping("/products/create")
    public String create(Model model)
    {
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/products/create")
    public String create(Product product,RedirectAttributes redirectAttributes)
    {
        product.setId(productService.findAll().size()+1);
        productService.create(product);
        redirectAttributes.addFlashAttribute("status","create oke");
        return "redirect:/";
    }
}
