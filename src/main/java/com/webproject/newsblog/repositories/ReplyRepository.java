package com.webproject.newsblog.repositories;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Reply;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends CrudRepository<Reply, Long> {
    Reply findById(long id);
    List<Reply> findByComment(Comment comment);
    List<Reply> findAll();
}
