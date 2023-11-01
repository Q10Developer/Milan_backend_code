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
	private Boolean isAdmin;
	
	

	
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginRequestDTO [password=");
		builder.append(password);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", email=");
		builder.append(email);
		builder.append(", isAdmin=");
		builder.append(isAdmin);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
