package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Student")
public class Student {
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Student(String firstName, String lastName, String section) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
	}

	@Id
	@GeneratedValue
	@Column(name = "student_id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	public Student(long id) {
		super();
		this.id = id;
	}

	public Student(String firstName, String lastName, String section, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
		this.address = address;
	}

	public Student() {
		super();
	}

	public Student(long id, String firstName, String lastName, String section, Address address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
		this.address = address;
	}

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "section")
	private String section;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	@Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
                + lastName + ", section=" + section + "]";
    }
}
