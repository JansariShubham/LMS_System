package com.spring.lms.controller;

import com.spring.lms.model.UserReviews;
import com.spring.lms.service.UserReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user-reviews")
public class UserReviewsController {

    @Autowired
    private UserReviewsService userReviewsService;

    @PostMapping("/post-review")
    public UserReviews postUserReview(@RequestBody UserReviews userReview){
        userReviewsService.saveUserReview(userReview);
        return null;
    }
}
