package com.toantr.restfulapp.controller;

import com.toantr.restfulapp.persistence.model.Blog;
import com.toantr.restfulapp.persistence.model.Category;
import com.toantr.restfulapp.persistence.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController
{
    @Autowired
    private BlogService blogService;

    @RequestMapping(path = "/blogs",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> handleGetAll(){
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

/*
    @RequestMapping(path = "/blogs",method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> handleGetByCategory(@RequestBody Category category)
    {
        return new ResponseEntity<>(blogService.findByCategory(category),HttpStatus.OK);
    }
*/
    @RequestMapping(path = "/blogs",method = {RequestMethod.POST})
    public ResponseEntity<Blog> handlePostOne(@RequestBody Blog blog){
        blogService.save(blog); //TODO Formatter
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @RequestMapping(path = "/blogs/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Blog> handlePutOne(@RequestBody Blog blog, @PathVariable Long id){
        blog.setId(id);
        blogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }
    @RequestMapping(path = "/blogs/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Blog> handleDeleteById(@PathVariable Long id){
        Blog blog=blogService.findById(id);
        blogService.remove(id);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    } //TODO Category
}
