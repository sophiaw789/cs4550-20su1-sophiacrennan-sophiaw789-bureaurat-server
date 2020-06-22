package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Student;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository <Student, Integer>{
    @Query("SELECT student FROM Student student WHERE student.id=:uid")
    public Student findStudentById(@Param("uid") Integer studentId);

    @Query("SELECT student FROM Student student WHERE student.username=:u")
    public Student findStudentByUsername(@Param("u") String username);

    @Query("SELECT student FROM Student student WHERE student.username=:username AND student.password=:password")
    public Student findStudentByCredentials(@Param("username") String username, @Param("password") String password);
}