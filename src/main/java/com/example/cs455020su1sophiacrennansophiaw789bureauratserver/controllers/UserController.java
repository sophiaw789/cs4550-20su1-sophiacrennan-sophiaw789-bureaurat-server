package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(
        // origins was originally http://localhost:3000
        origins = "*", allowCredentials = "true")
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/api/users/{userId}")
    public User findUserById(@PathVariable("userId") Integer id) {
        return service.findUserById(id);
    }

    @PostMapping("/api/register")
    public User register(@RequestBody User user, HttpSession session) {
        User existingUser = service.findUserByUsername(user.getUsername());
        if (existingUser == null) {
            User currentUser = service.createUser(user);
            session.setAttribute("currentUser", currentUser);
            return currentUser;
        }
        return null;
    }

    @PostMapping("/api/login")
    public User login(@RequestBody User user, HttpSession session) {
        User currentUser = service.findUserByCredentials(user.getUsername(), user.getPassword());
        session.setAttribute("currentUser", currentUser);
        return currentUser;
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }

    @DeleteMapping("/api/users/{userId}")
    public List<User> deleteUser(@PathVariable("userId") Integer id) {
        return service.deleteUser(id);
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User updatedUser, HttpSession session) {
        User currentUser = service.findUserById(userId);
        session.setAttribute("currentUser", currentUser);
        return service.updateUser(userId, updatedUser);
    }
}