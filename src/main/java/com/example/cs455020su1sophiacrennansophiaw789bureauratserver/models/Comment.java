package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;
/*
import javax.persistence.*;

@Entity
@Table(name = "comments")
*/
public class Comment {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    private Integer id;
    private Integer postId;
    private User commenter;
    private String text;
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}