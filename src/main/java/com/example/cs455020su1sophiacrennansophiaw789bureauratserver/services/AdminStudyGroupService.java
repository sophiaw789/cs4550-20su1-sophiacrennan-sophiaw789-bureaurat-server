/*
package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.AdminStudyGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminStudyGroupService {
    List<AdminStudyGroup> adminStudys = new ArrayList<AdminStudyGroup>();
    {
    }

    public List<AdminStudyGroup> findAdminStudysForCourse(Integer cid) {
        List<AdminStudyGroup> result = new ArrayList<AdminStudyGroup>();

        for (AdminStudyGroup w : adminStudys) {
            if (w.getCourseId().equals(cid)) {
                result.add(w);
            }
        }

        return result;
    }

    public AdminStudyGroup findAdminStudyById(Integer adminStudyId) {
        for (AdminStudyGroup w : adminStudys) {
            if (w.getId().equals(adminStudyId)) {
                return w;
            }
        }
        return null;
    }

    public List<AdminStudyGroup> findAllAdminStudys() {
        return adminStudys;
    }

    public List<AdminStudyGroup> deleteAdminStudy(Integer adminStudyId) {
        List<AdminStudyGroup> result = new ArrayList<AdminStudyGroup>();
        for (AdminStudyGroup w : adminStudys) {
            if (!w.getId().equals(adminStudyId)) {
                result.add(w);
            }
        }
        this.adminStudys = result;
        return result;
    }

    public AdminStudyGroup createAdminStudy(AdminStudyGroup newAdminStudy) {
        newAdminStudy.setId(adminStudys.size() * 20 + 21);
        this.adminStudys.add(newAdminStudy);
        return newAdminStudy;
    }

    public AdminStudyGroup updateAdminStudy(Integer adminStudyId, AdminStudyGroup updatedAdminStudy) {
        for (int i = 0; i < adminStudys.size(); i++) {
            if (adminStudys.get(i).getId().equals(adminStudyId)) {
                updatedAdminStudy.setId(adminStudyId);
                adminStudys.set(i, updatedAdminStudy);
                return updatedAdminStudy;
            }
        }
        return null;
    }
}
*/
