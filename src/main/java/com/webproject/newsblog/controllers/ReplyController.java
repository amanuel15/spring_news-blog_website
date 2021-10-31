package com.webproject.newsblog.controllers;

import com.webproject.newsblog.domains.Comment;
import com.webproject.newsblog.domains.Reply;
import com.webproject.newsblog.security.User;
import com.webproject.newsblog.services.CommentService;
import com.webproject.newsblog.services.ReplyService;
import com.webproject.newsblog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ReplyController {

    private ReplyService replyService;
    private CommentService commentService;
    private UserService userService;

    @Autowired
    public ReplyController(ReplyService replyService, CommentService commentService, UserService userService) {
        this.replyService = replyService;
        this.commentService = commentService;
        this.userService = userService;
    }


    @GetMapping("/reply/{id}")
    public String getAllReply(Model model, Reply reply, @PathVariable Long id){
        Comment comment = commentService.commentById(id);
        List<Reply> replies = replyService.findReplyByComment(comment);
        model.addAttribute("replies", replies);
        model.addAttribute("comment", comment);
        return "user/reply";
    }


    @PostMapping("/addReply/{id}")
    public String addReply(@ModelAttribute(name = "reply")  @Valid Reply reply,@PathVariable long id, @AuthenticationPrincipal UserDetails userDetails, Errors errors, Model model){

        if (errors.hasErrors()){
            System.out.println(model.asMap());
            return "reply";
        }
        User creator = userService.findUserByUsername(userDetails.getUsername());
        reply.setCreator(creator);
        reply.setDateCreated(new Date());
        reply.setComment(commentService.commentById(id));
        replyService.addReply(reply);

        return "redirect:/reply/"+ id;
    }
}
