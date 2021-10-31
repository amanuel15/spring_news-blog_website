package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Reply;
import com.webproject.newsblog.security.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {

    Reply findReplyById(long id);
    List<Reply> findReplyByComment(Comment comment);
    List<Reply> findAllReply();
    void deleteReply(Reply reply);
    void addReply(Reply reply);

}
