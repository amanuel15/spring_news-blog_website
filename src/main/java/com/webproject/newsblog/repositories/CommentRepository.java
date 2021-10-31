package com.webproject.newsblog.repositories;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Post;
import com.webproject.newsblog.security.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {

    List<Comment> findByPost(Post post);
    Comment findByCreator(User creator);
    int countByPost(Post post);
    Comment findById(long id);
    List<Comment> findByPostOrderByDateCreated(Post post);
    List<Comment> findTop5ByPostOrderByDateCreatedDesc(Post post);

}
