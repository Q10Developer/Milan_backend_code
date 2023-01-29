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
	private String emailId;
	private Long mobileNumber;
	private String password;
	private String confirmPassword;
	private Integer roleType;
	private Integer activeStatus;

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserRequestDTO [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", password=");
		builder.append(password);
		builder.append(", confirmPassword=");
		builder.append(confirmPassword);
		builder.append(", roleType=");
		builder.append(roleType);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}
}