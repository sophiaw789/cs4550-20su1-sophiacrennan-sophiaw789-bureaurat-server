package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;
import java.util.List;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Student;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudentService;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @Autowired
    StudyGroupService stuService;

    @GetMapping("/api/students")
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }

    @GetMapping("/api/students/{studentId}")
    public Student findStudentById(@PathVariable("studentId") Integer id) {
        return service.findStudentById(id);
    }
/*
    @DeleteMapping("/api/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer id, HttpSession session) {
        Student currentStudent = (Student) session.getAttribute("currentStudent");
        if (id == currentStudent.getId()) {
            session.invalidate();
        }
        service.deleteStudent(id);
    }

    @PutMapping("/api/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student updatedStudent,
            HttpSession session) {
        session.setAttribute("currentStudent", updatedStudent);
        return service.updateStudent(studentId, updatedStudent);
    }
    */
}