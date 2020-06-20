package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.*;
import java.util.List;

/*
@Entity
@Table(name="studygroup")
*/
public class StudyGroup {
  /*
   * @Id
   * 
   * @GeneratedValue(strategy = GenerationType.IDENTITY)
   */
  private Integer id;
  private Integer courseId;
  private String courseName;
  /* 
   * @ManyToMany
   * 
   * @JsonIgnore public List<User> students;
   * 
   * @OneToMany(mappedBy="section") private List<Posts> posts;
   */
  private List<Integer> studentsInGroupIds;
  private List<Integer> postsIds;
  
  public StudyGroup(Integer id, Integer courseId, Integer currentUserId, String courseName,
  List<Integer> studentsInGroupIds, List<Integer> postsIds) { this.id = id;
  this.courseId = courseId; this.currentUserId = currentUserId; this.courseName = courseName;
  this.studentsInGroupIds = studentsInGroupIds; this.postsIds = postsIds; }
  

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

  public Integer getCurrentUserId() {
    return currentUserId;
  }

  public void setCurrentUserId(Integer currentUserId) {
    this.currentUserId = currentUserId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public List<Integer> getStudentsInGroupIds() {
    return studentsInGroupIds;
  }

  public void setStudentsInGroupIds(List<Integer> studentsInGroupIds) {
    this.studentsInGroupIds = studentsInGroupIds;
  }

  public List<Integer> getPostsIds() {
    return postsIds;
  }

  public void setPostsIds(List<Integer> postsIds) {
    this.postsIds = postsIds;
  }
/*
  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }

  public List<User> getStudents() {
    return students;
  }

  public void setStudents(List<User> students) {
    this.students = students;
  }
  */
}