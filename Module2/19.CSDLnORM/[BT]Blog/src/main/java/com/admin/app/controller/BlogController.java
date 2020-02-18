package com.admin.app.controller;


import com.admin.app.model.Blog;
import com.admin.app.service.BlogService;
import com.admin.app.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class BlogController
{
    @Autowired
    private BlogService<Blog> blogService;
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mav=new ModelAndView("/home");
        mav.addObject("blogs",blogService.findAll());
        return mav;
    }
    @GetMapping("/blog-create")
    public String create(Model model)
    {
        model.addAttribute("blog",new Blog());
        return "create";
    }
    @PostMapping("/blog-create")
    public String create(Blog blog){
        blogService.createBlog(blog);
        return "redirect:/";
    }
    @GetMapping("/blog-details/{id}")
    public String detail(@PathVariable int id,Model model)
    {
        model.addAttribute("blog",blogService.findById(id));
        return "detail";
    }
    @GetMapping("/blog-edit/{id}")
    public String edit(@PathVariable int id, Model model)
    {
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @PostMapping("/blog-edit")
    public String edit(Blog blog)
    {
        blogService.update(blog);
        return "redirect:/";
    }
}
