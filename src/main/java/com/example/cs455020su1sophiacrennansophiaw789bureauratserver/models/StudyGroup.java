package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

// abstract or interface?
public class StudyGroup {
  private Integer id;
  private Integer courseId;
  private Integer currentUserId;
  private List<Integer> studentsInGroupIds;
  private List<Integer> postsIds;

  public StudyGroup(Integer id, Integer courseId, Integer currentUserId, List<Integer> studentsInGroupIds, List<Integer> postsIds) {
    this.id = id;
    this.courseId = courseId;
    this.currentUserId = currentUserId;
    this.studentsInGroupIds = studentsInGroupIds;
    this.postsIds = postsIds;
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


  public Integer getCurrentUserId() {
    return currentUserId;
  }

  public void setCurrentUserId(Integer currentUserId) {
    this.currentUserId = currentUserId;
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
}