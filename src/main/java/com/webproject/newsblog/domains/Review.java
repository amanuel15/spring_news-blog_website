package com.webproject.newsblog.domains;

import com.webproject.newsblog.security.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Review body can't be blank")
    private String reviewBody;

    @ManyToOne
    private User reviewer;

    @ManyToOne
    private Post reviewedPost;


}
