package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories;

import java.util.List;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudyRepository //extends CrudRepository<StudyGroup, Integer>
{
    @Query("SELECT group FROM StudyGroup group WHERE group.id=:studyId")
    public StudyGroup findGroupById(@Param("studyId") Integer studyId);

    @Query("SELECT group FROM StudyGroup group")
    public List<StudyGroup> findAllGroup();

    @Query("SELECT group FROM StudyGroup group WHERE group.courseName=:courseName")
    public List<StudyGroup> findGroupsByCourse(@Param("courseName") String courseName);
}