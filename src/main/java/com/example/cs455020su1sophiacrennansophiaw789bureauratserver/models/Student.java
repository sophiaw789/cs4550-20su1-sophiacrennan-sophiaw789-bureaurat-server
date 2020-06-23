package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

import javax.persistence.Entity;

//@Entity
public class Student extends User {

    public Student(int id, String username, String password, String email, String firstName, String lastName,
            String role, String bio, String location, List<Integer> studyGroups) {
        super(id, username, password, email, firstName, lastName, role, bio, location, studyGroups);
    }
    
}