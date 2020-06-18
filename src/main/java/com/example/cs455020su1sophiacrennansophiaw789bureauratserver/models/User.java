package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

//import javax.persistence.*;
/*
@Entity
@Table(name = "users")
*/
public class User {
    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    */
    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private List<Integer> studyGroups;

    /*
     * @OneToMany(mappedBy="user") private List<Post> posts;
     * 
     * @ManyToMany
     * 
     * @JoinTable( name="enrollments", joinColumns=@JoinColumn(name="USER_ID",
     * referencedColumnName="ID"), inverseJoinColumns=@JoinColumn(name="STUDYGROUP_ID",
     * referencedColumnName="ID")) private List<StudyGroup> studyGroups;
     */

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
}