package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudentStudyGroup;
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
                                         @RequestBody StudentStudyGroup updatedStudentStudy) {
        return studentStudyService.updateStudentStudy(studentStudyId, updatedStudentStudy);
    }

    @PostMapping("/api/courses/{cid}/studygroups/")
    public StudyGroup createStudentStudy(@PathVariable("cid") Integer cid,
            @RequestBody StudentStudyGroup newStudentStudy) {
        newStudentStudy.setCourseId(cid);
        return studentStudyService.createStudentStudy(newStudentStudy);
    }

    @GetMapping("/api/studygroups/")
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

    @GetMapping("/api/courses/{cid}/studygroups")
    public List<StudyGroup> findStudentStudysForCourse(@PathVariable("cid") Integer cid) {
        return studentStudyService.findStudentStudysForCourse(cid);
    }
}