package com.example.cs455020su1sophiacrennansophiaw789bureauratserver.services;

import com.example.cs455020su1sophiacrennansophiaw789bureauratserver.models.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    List<Comment> comments = new ArrayList<Comment>();
    {
    }

    public List<Comment> findCommentsForPost(Integer pid) {
        List<Comment> result = new ArrayList<Comment>();

        for (Comment w : comments) {
            if (w.getPostId().equals(pid)) {
                result.add(w);
            }
        }

        return result;
    }

    public Comment findCommentById(Integer comId) {
        for (Comment w : comments) {
            if (w.getId().equals(comId)) {
                return w;
            }
        }
        return null;
    }

    public List<Comment> findAllComments() {
        return comments;
    }

    public List<Comment> deleteComment(Integer comId) {
        List<Comment> result = new ArrayList<Comment>();
        for (Comment c : comments) {
            if (!c.getId().equals(comId)) {
                result.add(c);
            }
        }
        this.comments = result;
        return result;
    }

    public Comment createComment(Comment newComment) {
        newComment.setId(newComment.hashCode());
        this.comments.add(newComment);
        return newComment;
    }

    public Comment updateComment(Integer commentId, Comment updatedComment) {
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId().equals(commentId)) {
                updatedComment.setId(commentId);
                comments.set(i, updatedComment);
                return updatedComment;
            }
        }
        return null;
    }
}