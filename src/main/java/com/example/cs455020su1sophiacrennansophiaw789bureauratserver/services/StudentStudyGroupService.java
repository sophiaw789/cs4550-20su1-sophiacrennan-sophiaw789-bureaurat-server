package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudentStudyGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentStudyGroupService {
    List<StudentStudyGroup> studentStudys = new ArrayList<StudentStudyGroup>();
    {
    }

    public List<StudentStudyGroup> findStudentStudysForCourse(Integer cid) {
        List<StudentStudyGroup> result = new ArrayList<StudentStudyGroup>();

        for (StudentStudyGroup w : studentStudys) {
            if (w.getCourseId().equals(cid)) {
                result.add(w);
            }
        }

        return result;
    }

    public StudentStudyGroup findStudentStudyById(Integer studentStudyId) {
        for (StudentStudyGroup w : studentStudys) {
            if (w.getId().equals(studentStudyId)) {
                return w;
            }
        }
        return null;
    }

    public List<StudentStudyGroup> findAllStudentStudys() {
        return studentStudys;
    }

    public List<StudentStudyGroup> deleteStudentStudy(Integer studentStudyId) {
        List<StudentStudyGroup> result = new ArrayList<StudentStudyGroup>();
        for (StudentStudyGroup w : studentStudys) {
            if (!w.getId().equals(studentStudyId)) {
                result.add(w);
            }
        }
        this.studentStudys = result;
        return result;
    }

    public StudentStudyGroup createStudentStudy(StudentStudyGroup newStudentStudy) {
        newStudentStudy.setId(studentStudys.size() * 20 + 21);
        this.studentStudys.add(newStudentStudy);
        return newStudentStudy;
    }

    public StudentStudyGroup updateStudentStudy(Integer studentStudyId, StudentStudyGroup updatedStudentStudy) {
        for (int i = 0; i < studentStudys.size(); i++) {
            if (studentStudys.get(i).getId().equals(studentStudyId)) {
                updatedStudentStudy.setId(studentStudyId);
                studentStudys.set(i, updatedStudentStudy);
                return updatedStudentStudy;
            }
        }
        return null;
    }
}