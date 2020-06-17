package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

// abstract or interface?
public abstract class StudyGroup {
    private Integer id;
    private Integer courseId;
    private String name;
    private List<User> studentsInGroup;
    private List<Post> posts;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getStudentsInGroup() {
        return studentsInGroup;
    }

    public void setStudentsInGroup(List<User> studentsInGroup) {
        this.studentsInGroup = studentsInGroup;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}