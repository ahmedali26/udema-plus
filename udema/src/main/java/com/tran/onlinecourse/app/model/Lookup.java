package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lookup database table.
 * 
 */
@Entity
@NamedQuery(name="Lookup.findAll", query="SELECT l FROM Lookup l")
public class Lookup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String code;

	private String name;

	private String type;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="categoryId")
	private List<Course> courses;

	//bi-directional many-to-one association to Instructor
	@OneToMany(mappedBy="filedId")
	private List<Instructor> instructors;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="typeId")
	private List<User> users1;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="genderId")
	private List<User> users2;

	public Lookup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setCategoryId(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setCategoryId(null);

		return cours;
	}

	public List<Instructor> getInstructors() {
		return this.instructors;
	}

	public void setInstructors(List<Instructor> instructors) {
		this.instructors = instructors;
	}

	public Instructor addInstructor(Instructor instructor) {
		getInstructors().add(instructor);
		instructor.setFiledId(this);

		return instructor;
	}

	public Instructor removeInstructor(Instructor instructor) {
		getInstructors().remove(instructor);
		instructor.setFiledId(null);

		return instructor;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public User addUsers1(User users1) {
		getUsers1().add(users1);
		users1.setTypeId(this);

		return users1;
	}

	public User removeUsers1(User users1) {
		getUsers1().remove(users1);
		users1.setTypeId(null);

		return users1;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

	public User addUsers2(User users2) {
		getUsers2().add(users2);
		users2.setGenderId(this);

		return users2;
	}

	public User removeUsers2(User users2) {
		getUsers2().remove(users2);
		users2.setGenderId(null);

		return users2;
	}

}