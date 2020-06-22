package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "posts")
//@IdClass(PostId.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer posterId;
    private String title;
    private String text;

    @ManyToOne()
    private StudyGroup studyGroupId;

    @OneToMany(mappedBy="postId")
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

    public void set(Post newPost) {
        this.posterId = newPost.posterId;
        this.title = newPost.title;
        this.text = newPost.text;
        this.studyGroupId = newPost.studyGroupId;
        this.comments = newPost.comments;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudyGroup getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(StudyGroup studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public Integer getPosterId() {
        return posterId;
    }

    public void setPosterId(Integer posterId) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}