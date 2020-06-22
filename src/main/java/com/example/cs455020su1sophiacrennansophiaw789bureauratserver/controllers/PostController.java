package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.controllers;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.StudyGroup;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.PostService;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services.StudyGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
    @Autowired
    PostService postService;
    StudyGroupService studyService;

    @PutMapping("/api/posts/{pid}")
    public Post updatePost(@PathVariable("pid") Integer postId, @RequestBody Post updatedPost) {
        return postService.updatePost(postId, updatedPost);
    }

    @PostMapping("/api/studygroups/{studyId}/posts")
    public Post createPost(@PathVariable("studyId") Integer studyId, @RequestBody Post newPost) {
        StudyGroup study = studyService.findStudyGroupById(studyId);
        newPost.setStudyGroupId(study);
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
    public void deletePost(@PathVariable("pid") Integer pid) {
        postService.deletePost(pid);
    }

    
    @GetMapping("/api/studygroups/{studyId}/posts")
    public List<Post> findPostsForStudyGroup(@PathVariable("studyId") Integer studyId) {
        return postService.findPostsForStudyGroup(studyId);
    }
}
