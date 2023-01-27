package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String description;

	private String image;

	private String title;

	//bi-directional many-to-one association to Content
	@OneToMany(mappedBy="course")
	private List<Content> contents;

	//bi-directional many-to-one association to Lookup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	private Lookup categoryId;

	//bi-directional many-to-one association to Instructor
	@ManyToOne(fetch=FetchType.LAZY)
	private Instructor instructor;

	//bi-directional many-to-one association to Enrollment
	@OneToMany(mappedBy="course")
	private List<Enrollment> enrollments;

	//bi-directional many-to-one association to Review
	@OneToMany(mappedBy="course")
	private List<Review> reviews;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Content> getContents() {
		return this.contents;
	}

	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	public Content addContent(Content content) {
		getContents().add(content);
		content.setCourse(this);

		return content;
	}

	public Content removeContent(Content content) {
		getContents().remove(content);
		content.setCourse(null);

		return content;
	}

	public Lookup getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Lookup lookup) {
		this.categoryId = lookup;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Enrollment> getEnrollments() {
		return this.enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

	public Enrollment addEnrollment(Enrollment enrollment) {
		getEnrollments().add(enrollment);
		enrollment.setCourse(this);

		return enrollment;
	}

	public Enrollment removeEnrollment(Enrollment enrollment) {
		getEnrollments().remove(enrollment);
		enrollment.setCourse(null);

		return enrollment;
	}

	public List<Review> getReviews() {
		return this.reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Review addReview(Review review) {
		getReviews().add(review);
		review.setCourse(this);

		return review;
	}

	public Review removeReview(Review review) {
		getReviews().remove(review);
		review.setCourse(null);

		return review;
	}

}