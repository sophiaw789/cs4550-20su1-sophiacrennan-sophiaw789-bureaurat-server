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

    @PutMapping("/api/adminstudys/{asgId}")
    public AdminStudyGroup updateAdminStudy(@PathVariable("asgId") Integer adminStudyId,
            @RequestBody AdminStudyGroup updatedAdminStudy) {
        return adminStudyService.updateAdminStudy(adminStudyId, updatedAdminStudy);
    }

    @PostMapping("/api/courses/{cid}/adminstudys")
    public AdminStudyGroup createAdminStudy(@PathVariable("cid") Integer cid,
            @RequestBody AdminStudyGroup newAdminStudy) {
        newAdminStudy.setCourseId(cid);
        return adminStudyService.createAdminStudy(newAdminStudy);
    }

    @GetMapping("/api/adminstudys")
    public List<AdminStudyGroup> findAllAdminStudys() {
        return adminStudyService.findAllAdminStudys();
    }

    @GetMapping("/api/adminstudys/{asgId}")
    public AdminStudyGroup findAdminStudyById(@PathVariable("asgId") Integer asgId) {
        return adminStudyService.findAdminStudyById(asgId);
    }

    @DeleteMapping("/api/adminstudys/{asgId}")
    public List<AdminStudyGroup> deleteAdminStudy(@PathVariable("asgId") Integer asgId) {
        return adminStudyService.deleteAdminStudy(asgId);
    }

    @GetMapping("/api/courses/{cid}/adminstudys")
    public List<AdminStudyGroup> findAdminStudysForCourse(@PathVariable("cid") Integer cid) {
        return adminStudyService.findAdminStudysForCourse(cid);
    }
}