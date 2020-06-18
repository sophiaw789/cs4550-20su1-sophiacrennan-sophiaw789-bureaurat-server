package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

/*
import javax.persistence.*;

@Entity
@Table(name = "posts")
@IdClass(PostId.class)
*/
public class Post {
    /*
     * @Id
     */
    private long id;
    // @Id
    private Integer studyGroupId;
    private long posterId;
    private String title;
    private String text;
    private String date;
    private List<Comment> comments;

    /*
     * @ManyToOne
     * 
     * @PrimaryKeyJoinColumn(name="user", referencedColumnName="ID") private User
     * poster;
     * 
     * @ManyToOne
     * 
     * @PrimaryKeyJoinColumn(name="studyGroup", referencedColumnName="ID") private
     * StudyGroup studyGroup;
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(Integer studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public long getPosterId() {
        return posterId;
    }

    public void setPosterId(long posterId) {
        this.posterId = posterId;
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