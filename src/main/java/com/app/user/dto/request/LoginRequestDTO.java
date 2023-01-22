package com.app.user.dto.request;

import java.io.Serializable;


public class LoginRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private Long mobileNumber;
	private String email;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginRequestDTO [password=" + password + ", mobileNumber=" + mobileNumber + ", email=" + email + "]";
	}
	
	
	
}
