package com.webproject.newsblog.domains;

import com.webproject.newsblog.security.User;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Data
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User rater;

    @Max(value = 5, message = "A Maximum rating is 5.")
    private int ratingValue;

    @ManyToOne
    private Post post;


}
