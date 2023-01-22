package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_master")
public class UserRegistrationEtity {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private long id;
	
	@Column(name="user_name" ,nullable = false)
	private String name;
	
	
	@Column(name="user_password",nullable = false)
	private String password;
	
	@Column(name="user_mobile",nullable = false)
	private Long mobileNumber;
	
	
	@Column(name="user_email",nullable = true)
	private String emailId;
	
	
	@Column(name="user_type")
	private int userType;


	
	@Column(name="user_status")
	private boolean status;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "UserRegistrationEtity [id=" + id + ", name=" + name + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ",  emailId=" + emailId + ",  userType="
				+ userType + ", status=" + status + "]";
	}

	
}
