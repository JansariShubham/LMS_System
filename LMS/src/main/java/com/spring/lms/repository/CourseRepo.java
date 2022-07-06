package com.spring.lms.repository;

import java.util.List;

import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.lms.dto.CoursesDTO;
import com.spring.lms.model.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer>{

	Course findBycourseName(String courseName);

	//@Query("SELECT new com.spring.lms.dto.CoursesDTO(c.courseId, c.courseName, c.courseDuration, c.courseRating, c.courseStatus, c.coursePrice, c.courseImage, u.firstName, u.profileImage)  FROM Course c INNER JOIN Tutor t ON (c.tutor_fk = t.tutor_id) INNER JOIN User u ON (t.user_fk = u.user_id) ")
	@Query(value = "SELECT c.course_id, c.course_name, c.course_duration,c.course_date,c.course_description, c.course_rating, c.course_status, c.course_price, c.course_image, u.first_name,u.last_name, u.profile_image FROM Course as c INNER JOIN Tutor as t ON (c.tutor_fk = t.tutor_id) INNER JOIN User as u ON (t.user_fk = u.user_id)",nativeQuery = true)
	List<CoursesDTO> getCourses();
	
	
	
	@Query(value = "SELECT c.course_id, c.course_name,c.course_description,c.course_date, c.course_duration, c.course_rating, c.course_status, c.course_price, c.course_image, u.first_name,u.last_name, u.profile_image FROM Course as c INNER JOIN Tutor as t ON (c.tutor_fk = t.tutor_id) INNER JOIN User as u ON (t.user_fk = u.user_id) WHERE c.course_id = courseId",nativeQuery = true)
	Course getCourse(int courseId);
	
}
//	
//	@NamedNativeQuery(name = "getCourses", query = "SELECT new com.spring.lms.dto.CoursesDTO(c.course_id, c.course_name, c.course_duration,c.course_date,c.course_description, c.course_rating, c.course_status, c.course_price, c.course_image, u.first_name,u.last_name, u.profile_image)  FROM Course as c INNER JOIN Tutor as t ON (c.tutor_fk = t.tutor_id) INNER JOIN User as u ON (t.user_fk = u.user_id)")
//	List<CoursesDTO> getCourses();
//}

//@NamedNativeQuery(
//	    name = "find_stock_akhir_dto",
//	    query =
//	        "SELECT " + 
//	        "  stock_akhir.product_id AS productId, " + 
//	        "  stock_akhir.product_code AS productCode, " + 
//	        "  SUM(stock_akhir.qty) as stockAkhir " + 
//	        "FROM book_stock stock_akhir " + 
//	        "where warehouse_code = :warehouseCode " + 
//	        "  AND product_code IN :productCodes " + 
//	        "GROUP BY product_id, product_code, warehouse_id, warehouse_code",
//	    resultSetMapping = "stock_akhir_dto"
//	)
//	@SqlResultSetMapping(
//	    name = "stock_akhir_dto",
//	    classes = @ConstructorResult(
//	        targetClass = StockAkhirDto.class,
//	        columns = {
//	            @ColumnResult(name = "productId", type = Long.class),
//	            @ColumnResult(name = "productCode", type = String.class),
//	            @ColumnResult(name = "stockAkhir", type = Integer.class)
//	        }
//	    )
