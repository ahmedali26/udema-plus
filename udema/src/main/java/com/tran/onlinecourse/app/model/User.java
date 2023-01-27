package com.tran.onlinecourse.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String address;

	private int age;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	private String username;

	//bi-directional one-to-one association to Instructor
	@OneToOne(mappedBy="user", fetch=FetchType.LAZY)
	private Instructor instructor;

	//bi-directional one-to-one association to Student
	@OneToOne(mappedBy="user", fetch=FetchType.LAZY)
	private Student student;

	//bi-directional many-to-one association to Lookup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TYPE_ID")
	private Lookup typeId;

	//bi-directional many-to-one association to Lookup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GENDER_ID")
	private Lookup genderId;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Lookup getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Lookup lookup1) {
		this.typeId = lookup1;
	}

	public Lookup getGenderId() {
		return this.genderId;
	}

	public void setGenderId(Lookup lookup2) {
		this.genderId = lookup2;
	}

}