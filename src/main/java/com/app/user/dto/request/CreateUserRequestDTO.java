package com.app.user.dto.request;

import java.io.Serializable;

public class CreateUserRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long id;
	private String name;
	private String password;
	private String confirmPassword;
	private Long mobileNumber;
	private String emailId;
	private int usertype;
	
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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



	public int getUsertype() {
		return usertype;
	}


	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CreateUserRequestDTO [id=" + id + ", name=" + name + ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId + ",  usertype=" + usertype
				+ "]";
	}
}