package com.spring.lms.repository;

import com.spring.lms.model.UserReviews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewsRepo extends JpaRepository<UserReviews, Integer> {

    @Query(value = "SELECT SUM(course_rating), COUNT(*) FROM user_reviews AS u WHERE course_id = ?1", nativeQuery = true)
    Integer[] countTotalByCourseId(Integer courseId);

    List<UserReviews> findByCourseId(Integer courseId);
}
