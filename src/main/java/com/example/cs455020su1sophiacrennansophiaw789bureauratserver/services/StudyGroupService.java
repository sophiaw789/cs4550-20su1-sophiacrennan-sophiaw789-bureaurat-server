package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories.StudyRepository;

import org.springframework.beans.factory.annotation.Autowired;
//import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudyGroupService {
    @Autowired
    StudyRepository repository;
    PostService postService;

    List<StudyGroup> studyGroups = new ArrayList<StudyGroup>();
    {}

    /*
     * public List<StudyGroup> findStudentStudysForCourse(Integer cid) {
     * List<StudyGroup> result = new ArrayList<StudyGroup>();
     * 
     * for (StudyGroup w : studentStudys) { if (w.getCourseId().equals(cid)) {
     * result.add(w); } }
     * 
     * return result; }
     */

    public StudyGroup findStudyGroupById(Integer studyGroupId) {
        for (StudyGroup w : studyGroups) {
            if (w.getId().equals(studyGroupId)) {
                return w;
            }
        }
        return null;
    }

    public List<StudyGroup> findAllStudyGroups() {
        return studyGroups;
    }

    public List<StudyGroup> deleteStudyGroup(Integer studyGroupId) {
        List<StudyGroup> result = new ArrayList<StudyGroup>();
        for (StudyGroup w : studyGroups) {
            if (!w.getId().equals(studyGroupId)) {
                result.add(w);
            }
        }
        this.studyGroups = result;
        return result;
    }

    public List<StudyGroup> deleteUserFromStudyGroup(Integer userId) {
        List<StudyGroup> result = new ArrayList<StudyGroup>();
        for (StudyGroup w : this.deletePostsFromUser(userId)) {
            for (User u : w.getStudentsInGroupIds()) {
                if (!u.getId().equals(userId)) {
                    result.add(w);
                }
            }
        }
        this.studyGroups = result;
        return result;
    }

    public List<StudyGroup> deletePostsFromUser(Integer userId) {
        for (StudyGroup s : studyGroups) {
            List<Post> pResult = new ArrayList<Post>();
            for (Post p : postService.deleteCommentsFromUser(userId)) {
                if (p.getPosterId() != userId) {
                    pResult.add(p);
                }
            }
            s.setPostsIds(pResult);
        }
        return this.studyGroups;
    }

    public StudyGroup createStudyGroup(StudyGroup newStudyGroup) {
        newStudyGroup.setId(newStudyGroup.hashCode());
        this.studyGroups.add(newStudyGroup);
        return newStudyGroup;
    }

    public StudyGroup updateStudyGroup(Integer studyGroupId, StudyGroup updatedStudyGroup) {
        for (int i = 0; i < studyGroups.size(); i++) {
            if (studyGroups.get(i).getId().equals(studyGroupId)) {
                updatedStudyGroup.setId(studyGroupId);
                studyGroups.set(i, updatedStudyGroup);
                return updatedStudyGroup;
            }
        }
        return null;
    }
}