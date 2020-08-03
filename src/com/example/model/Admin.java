package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin {
	public Admin(String userName,String gmail, String password) {
		super();
		this.userName = userName;
		this.password = password;
		this.gmail=gmail;
	}

	public Admin(long id, String userName,String gmail, String password) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gmail=gmail;
	}

	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gmail")
	private String gmail;
	public long getId() {
		return id;
	}

	public Admin() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
}
