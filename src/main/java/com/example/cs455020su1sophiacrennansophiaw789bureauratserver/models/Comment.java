package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name = "comments")
public class Comment {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer postIdentity; 
    private Integer commenterId;
    private String text;

    //@ManyToOne
    //@JsonIgnore
    //private Post post; 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostIdentity() {
        return postIdentity;
    }

    public void setPostIdentity(Integer postIdentity) {
        this.postIdentity = postIdentity;
    }

    public Integer getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(Integer commenterId) {
        this.commenterId = commenterId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}