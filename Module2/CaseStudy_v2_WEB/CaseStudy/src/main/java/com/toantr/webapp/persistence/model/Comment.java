package com.toantr.webapp.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String commentUsername;
    private String commentTitle;
    private String commentContent;

    public Comment(){}

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCommentUsername()
    {
        return this.commentUsername;
    }

    public void setCommentUsername(String commentUsername)
    {
        this.commentUsername = commentUsername;
    }

    public String getCommentTitle()
    {
        return this.commentTitle;
    }

    public void setCommentTitle(String commentTitle)
    {
        this.commentTitle = commentTitle;
    }

    public String getCommentContent()
    {
        return this.commentContent;
    }

    public void setCommentContent(String commentContent)
    {
        this.commentContent = commentContent;
    }
}
