package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudyGroupController {
    @Autowired
    StudyGroupService service;
    UserService userService;

    @PutMapping("/api/studygroups/{studyGroupId}")
    public StudyGroup updateStudyGroup(@PathVariable("studyGroupId") Integer studyGroupId,
            @RequestBody StudyGroup updatedStudyGroup) {
        return service.updateStudyGroup(studyGroupId, updatedStudyGroup);
    }

    @PostMapping("/api/studygroups")
    public StudyGroup createStudyGroup(@RequestBody StudyGroup newStudyGroup) {
        return service.createStudyGroup(newStudyGroup);
    }

    @GetMapping("/api/studygroups")
    public List<StudyGroup> findAllStudyGroups() {
        return service.findAllStudyGroups();
    }

    @GetMapping("/api/studygroups/{studyGroupId}")
    public StudyGroup findStudyGroupById(@PathVariable("studyGroupId") Integer studyGroupId) {
        return service.findStudyGroupById(studyGroupId);
    }

    @DeleteMapping("/api/studygroups/{studyGroupId}")
    public List<StudyGroup> deleteStudyGroup(@PathVariable("studyGroupId") Integer studyGroupId) {
        return service.deleteStudyGroup(studyGroupId);
    }

    @PostMapping("/api/studygroups/{studyId}/users/{userId}")
    public void enrollStudentInStudy(@PathVariable("studyId") Integer studyId,
            @PathVariable("userId") Integer userId) {
        StudyGroup study = service.findStudyGroupById(studyId);
        User user = userService.findUserById(userId);
        study.enrollStudent(user);
        service.createStudyGroup(study);
    }
}