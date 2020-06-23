
package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Comment;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PutMapping("/api/comments/{comId}")
    public Comment updateComment(@PathVariable("comId") Integer commentId, @RequestBody Comment updatedComment) {
        return commentService.updateComment(commentId, updatedComment);
    }

    @PostMapping("/api/posts/{pid}/comments")
    public Comment createComment(@PathVariable("pid") Integer PostIdentity, @RequestBody Comment newComment) {
        newComment.setPostIdentity(PostIdentity);
        return commentService.createComment(newComment);
    }

    @GetMapping("/api/comments")
    public List<Comment> findAllComments() {
        return commentService.findAllComments();
    }

    @GetMapping("/api/comments/{comId}")
    public Comment findCommentById(@PathVariable("comId") Integer comId) {
        return commentService.findCommentById(comId);
    }

    @DeleteMapping("/api/comments/{comId}")
    public List<Comment> deleteComment(@PathVariable("comId") Integer comId) {
        return commentService.deleteComment(comId);
    }

    @GetMapping("/api/posts/{pid}/comments")
    public List<Comment> findCommentsForPost(@PathVariable("pid") Integer pid) {
        return commentService.findCommentsForPost(pid);
    }
}