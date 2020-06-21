package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Comment;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    List<Post> posts = new ArrayList<Post>();
    {}

    @Autowired
    CommentService commentService;

    public List<Post> findPostsForStudyGroup(Integer studyId) {
        List<Post> result = new ArrayList<Post>();

        for (Post p : posts) {
            if (p.getStudyGroupId().equals(studyId)) {
                result.add(p);
            }
        }
        return result;
    }

    public Post findPostById(Integer pid) {
        for (Post p : posts) {
            if (p.getId().equals(pid)) {
                return p;
            }
        }
        return null;
    }

    public List<Post> findAllPosts() {
        return posts;
    }

    public List<Post> deletePost(Integer pid) {
        List<Post> result = new ArrayList<Post>();
        for (Post p : posts) {
            if (p.getId().equals(pid)) {
                for (Comment c : commentService.findCommentsForPost(pid)) {
                    commentService.deleteComment(c.getId());
                }
            }
            else {
                result.add(p);
            }
        }
        this.posts = result;
        return result;
    }


    public Post createPost(Post newPost) {
        newPost.setId(newPost.hashCode());
        this.posts.add(newPost);
        return newPost;
    } 

    public Post updatePost(Integer pid, Post updatedPost) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(pid)) {
                updatedPost.setId(pid);
                posts.set(i, updatedPost);
                return updatedPost;
            }
        }
        return null;
    }

    public List<Post> deleteCommentsFromUser(Integer userId) {
        for (Post p : posts) {
            List<Comment> cResult = new ArrayList<Comment>();
            for (Comment c : commentService.findCommentsForPost(p.getId())) {
                if (c.getCommenterId() != userId) {
                    cResult.add(c);
                }
            }
            p.setComments(cResult);
        }
        return posts;
    }
}