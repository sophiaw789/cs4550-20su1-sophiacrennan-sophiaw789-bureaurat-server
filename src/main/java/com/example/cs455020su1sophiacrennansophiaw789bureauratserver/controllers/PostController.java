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

    @PutMapping("/api/posts/{pid}")
    public Post updatePost(@PathVariable("pid") Integer postId, @RequestBody Post updatedPost) {
        return postService.updatePost(postId, updatedPost);
    }

    @PostMapping("/api/studygroup/{studyId}/posts")
    public Post createPost(@PathVariable("studyId") Integer studyId, @RequestBody Post newPost) {
        newPost.setStudyGroupId(studyId);
        return postService.createPost(newPost);
    }

    @GetMapping("/api/posts")
    public List<Post> findAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/api/posts/{pid}")
    public Post findPostById(@PathVariable("pid") Integer pid) {
        return postService.findPostById(pid);
    }

    @DeleteMapping("/api/posts/{pid}")
    public List<Post> deletePost(@PathVariable("pid") Integer pid) {
        return postService.deletePost(pid);
    }

    
    @GetMapping("/api/studygroups/{studyId}/posts")
    public List<Post> findPostsForStudyGroup(@PathVariable("studyId") Integer studyId) {
        return postService.findPostsForStudyGroup(studyId);
    }
}