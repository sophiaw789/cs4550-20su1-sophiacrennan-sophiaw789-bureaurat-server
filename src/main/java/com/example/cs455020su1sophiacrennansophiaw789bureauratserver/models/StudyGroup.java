package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="studygroups")
public class StudyGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer courseId;
  private String courseName;

  @OneToMany(mappedBy = "studyGroupId")
  private List<Post> postsIds;

  @ManyToMany()
  @JsonIgnore
  public List<User> studentsInGroupIds;
  // private List<Integer> studentsInGroupIds;
  // private List<Integer> postsIds;

  public StudyGroup() {}

  public StudyGroup(Integer id, Integer courseId, Integer currentUserId, String courseName,
      List<User> studentsInGroupIds, List<Post> postsIds) {
    this.id = id;
    this.courseId = courseId;
    this.courseName = courseName;
    this.studentsInGroupIds = studentsInGroupIds;
    this.postsIds = postsIds;
  }

  public void set(StudyGroup newGroup) {
    this.courseId = newGroup.courseId;
    this.courseName = newGroup.courseName;
    this.studentsInGroupIds = newGroup.studentsInGroupIds;
    this.postsIds = newGroup.postsIds;
}

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

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public List<User> getStudentsInGroupIds() {
    return studentsInGroupIds;
  }

  public void setStudentsInGroupIds(List<User> studentsInGroupIds) {
    this.studentsInGroupIds = studentsInGroupIds;
  }

  public List<Post> getPostsIds() {
    return postsIds;
  }

  public void setPostsIds(List<Post> postsIds) {
    this.postsIds = postsIds;
  }

  public void enrollStudent(User student) {
    this.studentsInGroupIds.add(student);
    if (!student.getStudyGroups().contains(this)) {
      student.getStudyGroups().add(this);
    }
  }

  /*
   * public List<Post> getPosts() { return posts; }
   * 
   * public void setPosts(List<Post> posts) { this.posts = posts; }
   * 
   * public List<User> getStudents() { return students; }
   * 
   * public void setStudents(List<User> students) { this.students = students; }
   */
}