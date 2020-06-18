package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyGroupService {
    List<StudyGroup> studentStudys = new ArrayList<StudyGroup>();
    {
        studentStudys.add(new StudyGroup(123, 1, 1, new ArrayList<Integer>(), new ArrayList<Integer>()));
        studentStudys.get(0).getStudentsInGroupIds().add(1);
        studentStudys.get(0).getPostsIds().add(1);

    }


    public List<StudyGroup> findStudentStudysForCourse(Integer cid) {
        List<StudyGroup> result = new ArrayList<StudyGroup>();

        for (StudyGroup w : studentStudys) {
            if (w.getCourseId().equals(cid)) {
                result.add(w);
            }
        }

        return result;
    }

    public StudyGroup findStudentStudyById(Integer studentStudyId) {
        for (StudyGroup w : studentStudys) {
            if (w.getId().equals(studentStudyId)) {
                return w;
            }
        }
        return null;
    }

    public List<StudyGroup> findAllStudentStudys() {
        return studentStudys;
    }

    public List<StudyGroup> deleteStudentStudy(Integer studentStudyId) {
        List<StudyGroup> result = new ArrayList<StudyGroup>();
        for (StudyGroup w : studentStudys) {
            if (!w.getId().equals(studentStudyId)) {
                result.add(w);
            }
        }
        this.studentStudys = result;
        return result;
    }

    public StudyGroup createStudentStudy(StudyGroup newStudentStudy) {
        newStudentStudy.setId(studentStudys.size() * 20 + 21);
        this.studentStudys.add(newStudentStudy);
        return newStudentStudy;
    }

    public StudyGroup updateStudentStudy(Integer studentStudyId, StudyGroup updatedStudentStudy) {
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