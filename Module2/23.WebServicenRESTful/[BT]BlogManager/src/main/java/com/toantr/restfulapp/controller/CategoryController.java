package com.toantr.restfulapp.controller;

import com.toantr.restfulapp.persistence.model.Category;
import com.toantr.restfulapp.persistence.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController
{
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "/categories",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> handleGetAll()
    {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
    @RequestMapping(path = "/categories/{id}",method = RequestMethod.GET)
    public ResponseEntity<Category> handleGetById(@PathVariable Long id)
    {
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    @RequestMapping(path = "/categories",method = RequestMethod.POST)
    public ResponseEntity<Category> handlePostOne(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
    @RequestMapping(path = "/categories/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Category> handlePutOne(@PathVariable Long id,@RequestBody Category category)
    {
        category.setId(id);
        return new ResponseEntity<>(category,HttpStatus.OK);
    }
}
