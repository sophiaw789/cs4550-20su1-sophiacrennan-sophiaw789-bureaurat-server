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
    private Integer commenterId;
    private String text;

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