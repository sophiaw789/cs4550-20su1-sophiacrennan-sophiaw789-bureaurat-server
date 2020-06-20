package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    PostService postService;

    @PutMapping("/api/posts/{postId}")
    public Post updatePost(@PathVariable("postId") Integer postId, @RequestBody Post updatedPost) {
        return postService.updatePost(postId, updatedPost);
    }

    @PostMapping("/api/studygroups/{studyId}/posts")
    public Post createPost(@PathVariable("studyId") Integer studyId, @RequestBody Post newPost) {
        newPost.setStudyGroupId(studyId);
        return postService.createPost(newPost);
    }

    @GetMapping("/api/posts")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/api/posts/{postId}")
    public Post findPostById(@PathVariable("postId") Integer pid) {
        return postService.findPostById(pid);
    }

    @DeleteMapping("/api/posts/{postId}")
    public List<Post> deletePost(@PathVariable("postId") Integer pid) {
        return postService.deletePost(pid);
    }

    
    @GetMapping("/api/studygroups/{studyId}/posts")
    public List<Post> findPostsForStudyGroup(@PathVariable("studyId") Integer studyId) {
        return postService.findPostsForStudyGroup(studyId);
    }
}