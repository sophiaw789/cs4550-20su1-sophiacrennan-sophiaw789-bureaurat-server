package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudyGroupController {
    @Autowired
    StudyGroupService studentStudyService;

    @PutMapping("/api/studygroups/{studentId}")
    public StudyGroup updateStudentStudy(@PathVariable("studentId") Integer studentStudyId,
            @RequestBody StudyGroup updatedStudentStudy) {
        return studentStudyService.updateStudentStudy(studentStudyId, updatedStudentStudy);
    }

    @PostMapping("/api/studygroups")
    public StudyGroup createStudentStudy(@RequestBody StudyGroup newStudentStudy) {
        return studentStudyService.createStudentStudy(newStudentStudy);
    }

    @GetMapping("/api/studygroups")
    public List<StudyGroup> findAllStudentStudys() {
        return studentStudyService.findAllStudentStudys();
    }

    @GetMapping("/api/studygroups/{groupId}")
    public StudyGroup findStudentStudyById(@PathVariable("groupId") Integer studentId) {
        return studentStudyService.findStudentStudyById(studentId);
    }

    @DeleteMapping("/api/studygroups/{studentId}")
    public List<StudyGroup> deleteStudentStudy(@PathVariable("studentId") Integer studentId) {
        return studentStudyService.deleteStudentStudy(studentId);
    }
}