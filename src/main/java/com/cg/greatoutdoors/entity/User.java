package com.cg.greatoutdoors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="guser")
public class User {
	@Id
	@Column(name="user_Id",nullable=false)
	private int userId;
	@Column(name="password",length = 20)
	private String password;

	@Column(name="role",length = 10)
	private String role;

	@Column(name="phone_number",length = 20)
	private String phoneNumber;

	@Column(name="email",length = 20)
	private String email;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
