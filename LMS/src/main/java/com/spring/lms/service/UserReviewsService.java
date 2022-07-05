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
        Integer[] sumAndCount = (Integer[]) userReviewsRepo.countTotalByCourseId(userReview.getCourseId());
        logger.info(">>> Sum And Count of Review is: {} {} ", sumAndCount[0], sumAndCount[1]);
        Optional<Course> upCourse= updateCourseRating(userReview.getCourseId(), sumAndCount[0], sumAndCount[1]);
        return upCourse.isPresent() ? userReview : null;
    }

    private Optional<Course> updateCourseRating(int courseId, Integer totalSum, Integer totalUser) {
        Course course = courseService.getCourse(courseId);
        int get_rating = Math.round(totalSum / totalUser);
        course.setCourseRating(get_rating);
        logger.info(">>> Course Rating updated by {}: ", course.getCourseRating());
        Optional<Course> updatedCourseObject = Optional.ofNullable(courseService.updateCourse(course));
        return updatedCourseObject;
    }

    public List<UserReviews> loadAllUserReviewForCourse(int courseId) {

        logger.info(">>> Fetching All User Review For CourseId {} ", courseId);
        return userReviewsRepo.findByCourseId(courseId);
    }

    public boolean removeUserReviewFromCourse(Integer reviewId) {
        Optional<UserReviews> userReviewObject = userReviewsRepo.findById(reviewId);
        userReviewsRepo.deleteById(reviewId);
        logger.info(">>> Review Deleted {} ", reviewId);
        Integer[] sumAndCount = (Integer[]) userReviewsRepo.countTotalByCourseId(userReviewObject.get().getCourseId());
        logger.info(">>> Sum And Count of Review is: {} {} ", sumAndCount[0], sumAndCount[1]);
        Optional<Course> upCourse= updateCourseRating(userReviewObject.get().getCourseId(), sumAndCount[0], sumAndCount[1]);
        return upCourse.isPresent();
    }
}
