package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudyGroupController {
    @Autowired
    StudyGroupService service;

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
}