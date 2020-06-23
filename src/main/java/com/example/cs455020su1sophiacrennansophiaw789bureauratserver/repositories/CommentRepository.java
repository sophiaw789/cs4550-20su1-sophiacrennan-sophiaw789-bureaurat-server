package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories;

import java.util.List;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Comment;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository //extends CrudRepository<Comment, Integer> 
{
    @Query("SELECT comment FROM Comment comment WHERE comment.id=:comId")
    public Comment findCommentById(@Param("comId") Integer comId);

    @Query("SELECT comment FROM Comment comment")
    public List<Comment> findAllComments();

    @Query("SELECT comment FROM Comment comment WHERE comment.commenterId=:comId")
    public List<Comment> findCommentsByUser(@Param("comId") Integer comId);
}