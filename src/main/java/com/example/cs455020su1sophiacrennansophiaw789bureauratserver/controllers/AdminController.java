package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Admin;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        // origins was originally http://localhost:3000
        origins = "*", allowCredentials = "true")
public class AdminController {
    @Autowired
    AdminService service;

    @GetMapping("/api/admins")
    public List<Admin> findAllAdmins() {
        return service.findAllAdmins();
    }

    @GetMapping("/api/admins/{adminId}")
    public Admin findAdminById(@PathVariable("adminId") Integer id) {
        return service.findAdminById(id);
    }
/*
    @PostMapping("/api/register")
    public Admin register(@RequestBody Admin admin, HttpSession session) {
        Admin existingAdmin = service.findAdminByUsername(admin.getUsername());
        if (existingAdmin == null) {
            Admin currentAdmin = service.createAdmin(admin);
            session.setAttribute("currentAdmin", currentAdmin);
            return currentAdmin;
        }
        return null;
    }

    @DeleteMapping("/api/admins/{adminId}")
    public void deleteAdmin(@PathVariable("adminId") Integer id, HttpSession session) {
        Admin currentAdmin = (Admin) session.getAttribute("currentAdmin");
        if (id == currentAdmin.getId()) {
            session.invalidate();
        }
        service.deleteAdmin(id);
    }

    @PutMapping("/api/admins/{adminId}")
    public Admin updateAdmin(@PathVariable("adminId") Integer adminId, @RequestBody Admin updatedAdmin, HttpSession session) {
        session.setAttribute("currentAdmin", updatedAdmin);
        return service.updateAdmin(adminId, updatedAdmin);
    }
    */
}
