package com.spring.lms.service;

import com.spring.lms.model.UserReviews;
import com.spring.lms.repository.UserReviewsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserReviewsService{

    private Logger logger = LoggerFactory.getLogger(UserReviewsService.class);

    @Autowired
    private UserReviewsRepo userReviewsRepo;

    public void saveUserReview(UserReviews userReview) {
        userReview.setReviewDate(new Date());
        logger.info(">>> Saving User Review in database");
        userReviewsRepo.save(userReview);
        //Integer[] sumAnd = (Integer[]) userReviewsRepo.countTotalByCourseId(userReview.getCourseId());
    }
}
