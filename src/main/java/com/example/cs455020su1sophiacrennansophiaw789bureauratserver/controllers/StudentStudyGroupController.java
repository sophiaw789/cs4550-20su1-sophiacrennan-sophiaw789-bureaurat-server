package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudentStudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudentStudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentStudyGroupController {
    @Autowired
    StudentStudyGroupService studentStudyService;

    @PutMapping("/api/studygroups/{studentId}")
    public StudentStudyGroup updateStudentStudy(@PathVariable("studentId") Integer studentStudyId,
            @RequestBody StudentStudyGroup updatedStudentStudy) {
        return studentStudyService.updateStudentStudy(studentStudyId, updatedStudentStudy);
    }

    @PostMapping("/api/courses/{cid}/studygroups")
    public StudentStudyGroup createStudentStudy(@PathVariable("cid") Integer cid,
            @RequestBody StudentStudyGroup newStudentStudy) {
        newStudentStudy.setCourseId(cid);
        return studentStudyService.createStudentStudy(newStudentStudy);
    }

    @GetMapping("/api/studygroups")
    public List<StudentStudyGroup> findAllStudentStudys() {
        return studentStudyService.findAllStudentStudys();
    }

    @GetMapping("/api/studygroups/{studentId}")
    public StudentStudyGroup findStudentStudyById(@PathVariable("studentId") Integer studentId) {
        return studentStudyService.findStudentStudyById(studentId);
    }

    @DeleteMapping("/api/studygroups/{studentId}")
    public List<StudentStudyGroup> deleteStudentStudy(@PathVariable("studentId") Integer studentId) {
        return studentStudyService.deleteStudentStudy(studentId);
    }

    @GetMapping("/api/courses/{cid}/studygroups")
    public List<StudentStudyGroup> findStudentStudysForCourse(@PathVariable("cid") Integer cid) {
        return studentStudyService.findStudentStudysForCourse(cid);
    }
}