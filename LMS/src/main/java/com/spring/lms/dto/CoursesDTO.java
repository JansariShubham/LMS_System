package com.spring.lms.dto;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Lob;

public class CoursesDTO {
	// c.course_id, c.course_name, c.course_duration, c.course_rating,
	// c.course_status, c.course_price, c.course_image, u.first_name,
	// u.profile_image

	private int courseId;

	private String courseName;

	private String courseDescription;

	private int coursePrice;

	private int courseDuration;

	private Date courseDate;

	private byte[] courseImage;

	private int courseRating;

	private String courseStatus;

	private String tutorName;

	private byte[] tutorImage;

	public CoursesDTO() {

	}

	public CoursesDTO(int courseId, String courseName, String courseDescription, int coursePrice, int courseDuration,
			Date courseDate, byte[] courseImage, int courseRating, String courseStatus, String fName, String lName,
			byte[] tutorImage) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
		this.courseDate = courseDate;
		this.courseImage = courseImage;
		this.courseRating = courseRating;
		this.courseStatus = courseStatus;
		this.tutorName = fName + ' ' + lName;
		this.tutorImage = tutorImage;
	}

	@Override
	public String toString() {
		return "CoursesDTO [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", coursePrice=" + coursePrice + ", courseDuration=" + courseDuration
				+ ", courseDate=" + courseDate + ", courseImage=" + Arrays.toString(courseImage) + ", courseRating="
				+ courseRating + ", courseStatus=" + courseStatus + ", tutorName=" + tutorName + ", tutorImage="
				+ Arrays.toString(tutorImage) + "]";
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public byte[] getCourseImage() {
		return courseImage;
	}

	public void setCourseImage(byte[] courseImage) {
		this.courseImage = courseImage;
	}

	public int getCourseRating() {
		return courseRating;
	}

	public void setCourseRating(int courseRating) {
		this.courseRating = courseRating;
	}

	public String getCourseStatus() {
		return courseStatus;
	}

	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}

	public String getTutorName() {
		return tutorName;
	}

	public void setTutorName(String tutorName) {
		this.tutorName = tutorName;
	}

	public byte[] getTutorImage() {
		return tutorImage;
	}

	public void setTutorImage(byte[] tutorImage) {
		this.tutorImage = tutorImage;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

}
