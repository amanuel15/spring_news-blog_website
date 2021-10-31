package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.repositories.CommentRepository;
import com.webproject.newsblog.repositories.PostRepository;
import com.webproject.newsblog.repositories.UserRepository;
import com.webproject.newsblog.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    @Override
    public void addComment(UserDetails userDetails, String body,Long id) {
        Date dateCreated = new Date();
        User creator = userRepository.findByUsername(userDetails.getUsername());
        Comment comment = new Comment();
        Post post = postRepository.findById(id).get();
        comment.setDateCreated(dateCreated);
        comment.setBody(body);
        comment.setCreator(creator);
        comment.setPost(post);

        commentRepository.save(comment);


    }

    @Override
    public void deleteComment(Comment comment) {
           commentRepository.delete(comment);
    }

    @Override
    public Comment commentById(long id) {
      return commentRepository.findById(id);
    }

    @Override
    public List<Comment> findPostCommentByDate(Post post) { return commentRepository.findTop5ByPostOrderByDateCreatedDesc(post);}

    @Override
    public int countByPost(Post post) {
        return commentRepository.countByPost(post);
    }
}
