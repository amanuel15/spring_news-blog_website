package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.security.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface CommentService {


    void addComment(UserDetails userDetails, String body, Long id) ;
    void deleteComment(Comment comment);
    Comment commentById(long id);
    List<Comment> findPostCommentByDate(Post post);
    int countByPost(Post post);
}
