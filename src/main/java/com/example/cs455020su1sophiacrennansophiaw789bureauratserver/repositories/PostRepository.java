package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.repositories;

import java.util.List;
import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostRepository //extends CrudRepository<Post, Integer>
{
    @Query("SELECT post FROM Post post WHERE post.id=:postIdentity")
    public Post findPostById(@Param("postIdentity") Integer postIdentity);

    @Query("SELECT post FROM Post post")
    public List<Post> findAllPosts();

    @Query("SELECT post FROM Post post WHERE post.posterId=:posterId")
    public List<Post> findPostsByUser(@Param("posterId") Integer posterId);
}