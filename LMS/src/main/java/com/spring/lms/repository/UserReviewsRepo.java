package com.spring.lms.repository;

import com.spring.lms.model.UserReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewsRepo extends JpaRepository<UserReviews, Integer> {

    @Query("SUM(u.courseRating), COUNT(*) FROM UserReviews AS u WHERE u.courseId = ?1")
    Object[] countTotalByCourseId(Integer courseId);

    List<UserReviews> findByCourseId(int courseId);

    UserReviews findByReviewId(Integer reviewId);
}
