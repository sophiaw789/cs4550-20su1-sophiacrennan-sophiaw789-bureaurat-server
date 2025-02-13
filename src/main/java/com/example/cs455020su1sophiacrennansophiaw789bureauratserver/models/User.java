package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
//@Table(name = "users")
public class User {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String bio;
    private String location;
    private List<Integer> studyGroups;

    //@ManyToMany
    //@JsonIgnore
    //private List<StudyGroup> groups;

    public User(int id, String username, String password, String email, String firstName, String lastName, String role,
            String bio, String location, List<Integer> studyGroups) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.bio = bio;
        this.location = location;
        this.id = id;
        this.studyGroups = studyGroups;
    }

    public void set(User newUser) {
        this.username = newUser.username;
        this.password = newUser.password;
        this.firstName = newUser.firstName;
        this.lastName = newUser.lastName;
        this.email = newUser.email;
        this.role = newUser.role;
        this.bio = newUser.bio;
        this.location = newUser.location;
        this.studyGroups = newUser.studyGroups;
    }

    // many to many in SQL
    // users = {u1, u2, u3}
    // enrollments = {(u1, s1, 'A', 5), (u2, s1, 'A-', 4), (u2, s3), (u3, s3)}
    // sections = {s1, s2, s3}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Integer> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<Integer> studyGroups) {
        this.studyGroups = studyGroups;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    /*
     * public int hashCode() { return id + username.hashCode() + password.hashCode()
     * + email.hashCode(); }
     * 
     * public boolean equals(Object object) { if (object instanceof User) { User
     * otherId = (User) object; return (otherId.id == this.id) && (otherId.username
     * == this.username) && (otherId.password == this.password) && (otherId.email ==
     * this.email); } return false; }
     */
}