package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
//import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
//import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository repository;
    StudyGroupService studyService;
    // @Autowired
    // UserRepository repository;
    /*
     * public User createUser(User user) { return repository.save(user); }
     * 
     * public User findUserById(Integer id) { return repository.findUserById(id); }
     * 
     * public User findUserByCredentials(String username, String password) { return
     * repository.findUserByCredentials(username, password); }
     * 
     * public User findUserByUsername(String username) { return
     * repository.findUserByUsername(username); }
     */

    public User findUserByCredentials(String username, String password) {
        return repository.findUserByCredentials(username, password);
    }

    public User findUserByUsername(String username) {
        return repository.findUserByUsername(username);
    }

    public List<User> findUsersForStudyGroup(Integer studyId) {
        List<User> result = new ArrayList<User>();
        for (User u : this.findAllUsers()) {
            for (StudyGroup s : u.getStudyGroups())
                if (s.getId().equals(studyId)) {
                    result.add(u);
                }
        }
        return result;
    }

    public User findUserById(Integer userId) {
        return repository.findUserById(userId);

    }

    public List<User> findAllUsers() {
        return (List<User>) repository.findAll();
    }

    public void deleteUser(Integer userId) {
        repository.deleteById(userId);
    }

    public User createUser(User newUser) {
        return repository.save(newUser);
    }

    public User updateUser(Integer userId, User updatedUser) {
        User user = repository.findUserById(userId);
        user.set(updatedUser);
        return repository.save(user);
    }
}