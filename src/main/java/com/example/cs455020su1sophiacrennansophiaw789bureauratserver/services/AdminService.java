package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Admin;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
    //@Autowired
    AdminRepository repository;

    @Autowired
    StudyGroupService studyService;

    static List<Admin> admins = new ArrayList<Admin>();

    public Admin findAdminByCredentials(String username, String password) {
        return repository.findAdminByCredentials(username, password);
    }

    public Admin findAdminByUsername(String username) {
        return repository.findAdminByUsername(username);
    }

    public Admin findAdminById(Integer adminId) {
        return repository.findAdminById(adminId);
    }

    public List<Admin> findAllAdmins() {
        return repository.findAllAdmin();
    }

    public void deleteAdmin(Integer adminId) {
    }

    public Admin createAdmin(Admin newAdmin) {
        newAdmin.setId(newAdmin.hashCode());
        return newAdmin;
    }

    public Admin updateAdmin(Integer adminId, Admin updatedAdmin) {
        Admin admin = repository.findAdminById(adminId); 
        admin.set(updatedAdmin);
        return admin;
    }
}