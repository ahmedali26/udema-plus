package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the review database table.
 * 
 */
@Entity
@NamedQuery(name="Review.findAll", query="SELECT r FROM Review r")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="`COMMENT`")
	private String comment;

	private short rate;

	//bi-directional many-to-one association to Course
	@ManyToOne(fetch=FetchType.LAZY)
	private Course course;

	//bi-directional many-to-one association to Student
	@ManyToOne(fetch=FetchType.LAZY)
	private Student student;

	public Review() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public short getRate() {
		return this.rate;
	}

	public void setRate(short rate) {
		this.rate = rate;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}