package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;
/*
import javax.persistence.*;

@Entity
@Table(name = "posts")
*/
public class Post {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    private Integer id;
    private Integer courseId;
    private User poster;
    private String title;
    private String text;
    private String date;
    private List<Comment> comments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}