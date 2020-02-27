package com.toantr.webapp.controller;

import com.toantr.webapp.model.Blog;
import com.toantr.webapp.repo.BlogRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BlogController
{
    private static final Logger log= LogManager.getLogger(BlogController.class);
    @Autowired
    private BlogRepo blogRepo;
    @GetMapping("/blog")
    public ModelAndView handleBlogView(){
        return new ModelAndView("blog","blogs",blogRepo.findAll());
    }
    @PostMapping("/blog/new")
    public String handleNewBlog(Model model){
        model.addAttribute("blog",new Blog());
        return "blog-new";
    }
}
