package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

//import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;

//import org.springframework.beans.factory.annotation.Autowired;
//import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

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
    static List<User> users = new ArrayList<User>();

    public User findUserByCredentials(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public User findUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public List<User> findUsersForStudyGroup(Integer studyId) {
        List<User> result = new ArrayList<User>();

        for (User u : users) {
            for (Integer s : u.getStudyGroups())
                if (s.equals(studyId)) {
                    result.add(u);
                }
        }
        return result;
    }

    public User findUserById(Integer userId) {
        for (User u : users) {
            if (u.getId().equals(userId)) {
                return u;
            }
        }
        return null;
    }

    public List<User> findAllUsers() {
        return users;
    }

    public List<User> deleteUser(Integer userId) {
        List<User> result = new ArrayList<User>();
        //studyService.deleteUserFromStudyGroup(userId);
        for (User u : users) {
            if (!u.getId().equals(userId)) {
                result.add(u);
            }
        }
        users = result;
        return result;
    }

    public User createUser(User newUser) {
        newUser.setId(newUser.hashCode());
        users.add(newUser);
        return newUser;
    }

    public User updateUser(Integer userId, User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(userId)) {
                updatedUser.setId(userId);
                users.set(i, updatedUser);
                return updatedUser;
            }
        }
        return null;
    }
}