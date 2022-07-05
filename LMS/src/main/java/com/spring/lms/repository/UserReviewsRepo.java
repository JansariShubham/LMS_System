package com.spring.lms.repository;

import com.spring.lms.model.UserReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReviewsRepo extends JpaRepository<UserReviews, Integer> {

    @Query("SUM(u.courseRating), COUNT(*) FROM UserReviews AS u WHERE u.courseId = ?1")
    Object[] countTotalByCourseId(Integer courseId);
}
