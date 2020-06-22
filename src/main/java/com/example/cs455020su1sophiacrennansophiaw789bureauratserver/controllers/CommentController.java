package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Comment;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.CommentService;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    CommentService commentService;
    PostService postService;

    @PutMapping("/api/comments/{comId}")
    public Comment updateComment(@PathVariable("comId") Integer commentId, @RequestBody Comment updatedComment) {
        return commentService.updateComment(commentId, updatedComment);
    }

    @PostMapping("/api/posts/{pid}/comments")
    public Comment createComment(@PathVariable("pid") Integer postId, @RequestBody Comment newComment) {
        Post post = postService.findPostById(postId);
        newComment.setPostId(post);
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
    public void deleteComment(@PathVariable("comId") Integer comId) {
        commentService.deleteComment(comId);
    }

    @GetMapping("/api/posts/{pid}/comments")
    public List<Comment> findCommentsForPost(@PathVariable("pid") Integer pid) {
        return commentService.findCommentsForPost(pid);
    }
}