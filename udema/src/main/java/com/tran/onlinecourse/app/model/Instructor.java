package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instructor database table.
 * 
 */
@Entity
@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String about;

	private String email;

	@Column(name="LINKED_IN")
	private String linkedIn;

	private String name;

	@Column(name="YOUTUBE_CHANNEL")
	private String youtubeChannel;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="instructor")
	private List<Course> courses;

	//bi-directional many-to-one association to Lookup
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FIELD_ID")
	private Lookup filedId;

	//bi-directional one-to-one association to User
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID")
	private User user;

	public Instructor() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedIn() {
		return this.linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYoutubeChannel() {
		return this.youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setInstructor(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setInstructor(null);

		return cours;
	}

	public Lookup getFiledId() {
		return this.filedId;
	}

	public void setFiledId(Lookup lookup) {
		this.filedId = lookup;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}