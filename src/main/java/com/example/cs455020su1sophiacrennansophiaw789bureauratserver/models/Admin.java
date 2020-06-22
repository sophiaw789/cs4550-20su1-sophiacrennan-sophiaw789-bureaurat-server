package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Admin extends User {

    private String facultyStatus;

    public Admin(){}

    public Admin(int id, String username, String password, String email, String firstName, String lastName, String role,
            String bio, String location, List<StudyGroup> studyGroups, String facultyStatus) {
        super(id, username, password, email, firstName, lastName, role, bio, location, studyGroups);
        this.facultyStatus = facultyStatus;
    }

    public String getFacultyStatus() {
        return facultyStatus;
    }

    public void setFacultyStatus(String facultyStatus) {
        this.facultyStatus = facultyStatus;
    }
    
}
