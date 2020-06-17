package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    List<Post> posts = new ArrayList<Post>();
    {}

    public List<Post> findPostsForCourse(Integer cid) {
        List<Post> result = new ArrayList<Post>();

        for (Post p : posts) {
            if (p.getCourseId().equals(cid)) {
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
            if (!p.getId().equals(pid)) {
                result.add(p);
            }
        }
        this.posts = result;
        return result;
    }

    public Post createPost(Post newPost) {
        newPost.setId(posts.size() * 20 + 21);
        this.posts.add(newPost);
        return newPost;
    } 

    public Post updatePost(Integer postId, Post updatedPost) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(postId)) {
                updatedPost.setId(postId);
                posts.set(i, updatedPost);
                return updatedPost;
            }
        }
        return null;
    }
}