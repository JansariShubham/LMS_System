package com.spring.lms.service;

import com.spring.lms.model.Course;
import com.spring.lms.model.UserReviews;
import com.spring.lms.repository.UserReviewsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserReviewsService{

    private Logger logger = LoggerFactory.getLogger(UserReviewsService.class);

    @Autowired
    private UserReviewsRepo userReviewsRepo;

    @Autowired
    private CourseService courseService;

    public UserReviews saveUserReview(UserReviews userReview) {
        userReview.setReviewDate(new Date());
        logger.info(">>> Saving User Review in database");
        userReviewsRepo.save(userReview);
        Optional<Course> upCourse = Optional.ofNullable(updateCourseRating(userReview.getCourseId()));
        return  upCourse.isPresent() ? userReview : null;
    }

    public Course updateCourseRating(int courseId){
        Integer[] sumAndCount = (Integer[]) userReviewsRepo.countTotalByCourseId(courseId);
        int courseRating = Math.round(sumAndCount[0] / sumAndCount[1]);
        logger.info(">>> Total Rating , User {} , {}", sumAndCount[0], sumAndCount[1]);
        logger.info(">>> Course Rating: {}", courseRating);
        Course getCourse = courseService.getCourse(courseId);
        getCourse.setCourseRating(courseRating);
        getCourse = courseService.updateCourse(getCourse);
        return getCourse;
    }

    public List<UserReviews> loadAllUserReviewForCourse(Integer courseId) {
        logger.info(">>> Fetching all user review from database");
        return userReviewsRepo.findByCourseId(courseId);
    }

    public boolean removeUserReviewFromCourse(Integer reviewId) {
        logger.info(">>> REmoving review from database");
        Optional<UserReviews> userReview = userReviewsRepo.findById(reviewId);
        userReviewsRepo.deleteById(reviewId);
        Optional<Course> upCourse = Optional.ofNullable(updateCourseRating(userReview.get().getCourseId()));
        return  upCourse.isPresent();
    }
}
