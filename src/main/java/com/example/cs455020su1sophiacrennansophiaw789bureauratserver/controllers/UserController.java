package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;
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
    StudyGroupService stuService;

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
    public void deleteUser(@PathVariable("userId") Integer id) {
        service.deleteUser(id);
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId, @RequestBody User updatedUser, HttpSession session) {
        session.setAttribute("currentUser", updatedUser);
        return service.updateUser(userId, updatedUser);
    }

    @GetMapping("/api/users/{userId}/studygroups")
    public List<StudyGroup> findUserEnrolledStudy(@PathVariable("userId") int userId) {
        User user = service.findUserById(userId);
        return user.getStudyGroups();
    }

    @PostMapping("/api/users/{userId}/section/{studyId}")
    public void enrollUserInSection(@PathVariable("studyId") int studyId, @PathVariable("userId") int userId, HttpSession session) {
        StudyGroup study = stuService.findStudyGroupById(studyId);
        User user = service.findUserById(userId);
        user.enrollStudyGroup(study);
        service.createUser(user);
        session.setAttribute("currentUser", user);
    }
}