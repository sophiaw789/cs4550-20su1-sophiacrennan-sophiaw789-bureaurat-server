package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.AdminStudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.AdminStudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminStudyGroupController {
    @Autowired
    AdminStudyGroupService adminStudyService;

    @PutMapping("/api/studygroups/{adminId}")
    public AdminStudyGroup updateAdminStudy(@PathVariable("adminId") Integer adminStudyId,
            @RequestBody AdminStudyGroup updatedAdminStudy) {
        return adminStudyService.updateAdminStudy(adminStudyId, updatedAdminStudy);
    }

    @PostMapping("/api/courses/{cid}/studygroups")
    public AdminStudyGroup createAdminStudy(@PathVariable("cid") Integer cid,
            @RequestBody AdminStudyGroup newAdminStudy) {
        newAdminStudy.setCourseId(cid);
        return adminStudyService.createAdminStudy(newAdminStudy);
    }

    @GetMapping("/api/studygroups")
    public List<AdminStudyGroup> findAllAdminStudys() {
        return adminStudyService.findAllAdminStudys();
    }

    @GetMapping("/api/studygroups/{adminId}")
    public AdminStudyGroup findAdminStudyById(@PathVariable("adminId") Integer adminId) {
        return adminStudyService.findAdminStudyById(adminId);
    }

    @DeleteMapping("/api/studygroups/{adminId}")
    public List<AdminStudyGroup> deleteAdminStudy(@PathVariable("adminId") Integer adminId) {
        return adminStudyService.deleteAdminStudy(adminId);
    }

    @GetMapping("/api/courses/{cid}/studygroups")
    public List<AdminStudyGroup> findAdminStudysForCourse(@PathVariable("cid") Integer cid) {
        return adminStudyService.findAdminStudysForCourse(cid);
    }
}