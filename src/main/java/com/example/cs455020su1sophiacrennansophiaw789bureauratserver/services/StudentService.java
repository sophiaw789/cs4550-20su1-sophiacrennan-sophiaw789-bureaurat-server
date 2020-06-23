package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import java.util.ArrayList;
import java.util.List;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Student;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    //@Autowired
    StudentRepository repository;
    @Autowired
    StudyGroupService studyService;

    public Student findStudentById(Integer id) {
        return repository.findStudentById(id);
    }

    public Student findStudentByCredentials(String username, String password) {
        return repository.findStudentByCredentials(username, password);
    }

    public Student findStudentByUsername(String username) {
        return repository.findStudentByUsername(username);
    }

    public List<Student> findAllStudents() {
        return repository.findAllStudent();
    }

    public void deleteStudent(Integer studentId) {
    }

    public Student createStudent(Student newStudent) {
        newStudent.setId(newStudent.hashCode());
        return newStudent;
    }

    public Student updateStudent(Integer studentId, Student updatedStudent) {
        Student student = repository.findStudentById(studentId);
        student.set(updatedStudent);
        return student;
    }
}