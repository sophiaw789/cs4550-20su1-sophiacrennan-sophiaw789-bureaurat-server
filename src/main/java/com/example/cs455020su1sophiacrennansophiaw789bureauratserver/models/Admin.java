package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models;

import java.util.List;

public class Admin extends User {

    public Admin(int id, String firstName, String lastName, String username, String password, String email, String role,
            List<Integer> studyGroups) {
        super(id, firstName, lastName, username, password, email, role, studyGroups);
    }
    
}