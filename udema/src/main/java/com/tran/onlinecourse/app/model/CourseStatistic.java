package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course_statistics database table.
 * 
 */
@Entity
@Table(name="course_statistics")
@NamedQuery(name="CourseStatistic.findAll", query="SELECT c FROM CourseStatistic c")
public class CourseStatistic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "ID")
	private Course course;
	
	@Column(name="CONTENT_COUNT")
	private int contentCount;

	@Column(name="CONTENT_TOTAL_TIME")
	private int contentTotalTime;

	@Column(name="ENROLLMENT_COUNT")
	private int enrollmentCount;

	private int id;

	@Column(name="REVIEW_COUNT")
	private int reviewCount;

	@Column(name="REVIEW_RATE")
	private int reviewRate;

	public CourseStatistic() {
	}

	public int getContentCount() {
		return this.contentCount;
	}

	public void setContentCount(int contentCount) {
		this.contentCount = contentCount;
	}

	public int getContentTotalTime() {
		return this.contentTotalTime;
	}

	public void setContentTotalTime(int contentTotalTime) {
		this.contentTotalTime = contentTotalTime;
	}

	public int getEnrollmentCount() {
		return this.enrollmentCount;
	}

	public void setEnrollmentCount(int enrollmentCount) {
		this.enrollmentCount = enrollmentCount;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReviewCount() {
		return this.reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getReviewRate() {
		return this.reviewRate;
	}

	public void setReviewRate(int reviewRate) {
		this.reviewRate = reviewRate;
	}

}