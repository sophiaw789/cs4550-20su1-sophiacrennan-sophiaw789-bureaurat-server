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

    @PutMapping("/api/studentstudys/{asgId}")
    public StudentStudyGroup updateStudentStudy(@PathVariable("asgId") Integer studentStudyId,
            @RequestBody StudentStudyGroup updatedStudentStudy) {
        return studentStudyService.updateStudentStudy(studentStudyId, updatedStudentStudy);
    }

    @PostMapping("/api/courses/{cid}/studentstudys")
    public StudentStudyGroup createStudentStudy(@PathVariable("cid") Integer cid,
            @RequestBody StudentStudyGroup newStudentStudy) {
        newStudentStudy.setCourseId(cid);
        return studentStudyService.createStudentStudy(newStudentStudy);
    }

    @GetMapping("/api/studentstudys")
    public List<StudentStudyGroup> findAllStudentStudys() {
        return studentStudyService.findAllStudentStudys();
    }

    @GetMapping("/api/studentstudys/{asgId}")
    public StudentStudyGroup findStudentStudyById(@PathVariable("asgId") Integer asgId) {
        return studentStudyService.findStudentStudyById(asgId);
    }

    @DeleteMapping("/api/studentstudys/{asgId}")
    public List<StudentStudyGroup> deleteStudentStudy(@PathVariable("asgId") Integer asgId) {
        return studentStudyService.deleteStudentStudy(asgId);
    }

    @GetMapping("/api/courses/{cid}/studentstudys")
    public List<StudentStudyGroup> findStudentStudysForCourse(@PathVariable("cid") Integer cid) {
        return studentStudyService.findStudentStudysForCourse(cid);
    }
}