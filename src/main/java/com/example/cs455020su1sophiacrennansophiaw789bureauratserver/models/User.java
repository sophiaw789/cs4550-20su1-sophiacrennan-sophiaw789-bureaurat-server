package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "users")
// @IdClass(ReviewId.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String bio;
    private String location;

    @ManyToMany
    @JoinTable(name = "enrollments", 
        joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"), 
        inverseJoinColumns = @JoinColumn(name = "STUDY_GROUP_ID", referencedColumnName = "ID"))
    private List<StudyGroup> studyGroups;

    public User() {
    }

    public User(int id, String username, String password, String email, String firstName, String lastName, String role,
            String bio, String location, List<StudyGroup> studyGroups) {
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

/*     @ManyToMany
     * @JoinTable( name="enrollments", joinColumns=@JoinColumn(name="USER_ID",
     * referencedColumnName="ID"),
     * inverseJoinColumns=@JoinColumn(name="STUDYGROUP_ID",
     * referencedColumnName="ID")) private List<StudyGroup> studyGroups;
     */

    // many to many in SQL
    // users = {u1, u2, u3}
    // enrollments = {(u1, s1, 'A', 5), (u2, s1, 'A-', 4), (u2, s3), (u3, s3)}
    // sections = {s1, s2, s3}
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

    public void enrollStudyGroup(StudyGroup group) {
        this.getStudyGroups().add(group);
        if (!group.getStudentsInGroupIds().contains(this)) {
            group.getStudentsInGroupIds().add(this);
        }
    }

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

    public List<StudyGroup> getStudyGroups() {
        return studyGroups;
    }

    public void setStudyGroups(List<StudyGroup> studyGroups) {
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