package com.webproject.newsblog.services;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Reply;
import com.webproject.newsblog.repositories.ReplyRepository;
import com.webproject.newsblog.security.Role;
import com.webproject.newsblog.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReplyServiceImpl implements ReplyService {

    private ReplyRepository replyRepository;

    @Autowired
    public ReplyServiceImpl(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    @Override
    public Reply findReplyById(long id) {
        return replyRepository.findById(id);
    }

    @Override
    public List<Reply> findReplyByComment(Comment comment) {
        return replyRepository.findByComment(comment);
    }

    @Override
    public List<Reply> findAllReply() {
        return replyRepository.findAll();
    }

    @Override
    public void deleteReply(Reply reply) {
        replyRepository.delete(reply);
    }

    @Override
    public void addReply(Reply reply) {
        replyRepository.save(reply);
    }


}
