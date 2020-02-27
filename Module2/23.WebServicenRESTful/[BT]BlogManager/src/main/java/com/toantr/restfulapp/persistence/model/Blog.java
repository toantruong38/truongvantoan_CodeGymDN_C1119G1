package com.toantr.restfulapp.persistence.model;

import com.toantr.restfulapp.formatter.CategoryFormatter;
import com.toantr.restfulapp.persistence.service.CategoryService;
import com.toantr.restfulapp.persistence.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "blog_v3")
public class Blog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Category getCategory()
    {
        return this.category;
    }

    public void setCategory(String id)
    {
        CategoryServiceImpl categoryService=new CategoryServiceImpl();
        this.category =categoryService.findById(Long.parseLong(id));
    }

    public Blog()
    {
    }
}
