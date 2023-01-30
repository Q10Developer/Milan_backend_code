package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_master")
public class UserRegistrationEtity {
	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name", nullable = false)
	private String name;
	@Column(name = "user_password", nullable = false)
	@JsonIgnore
	private String password;
	@Column(name = "user_mobile", nullable = false)
	private Long mobileNumber;
	@Column(name = "user_email", nullable = true)
	private String emailId;
	@Column(name = "role_type")
	private Integer roleType;
	@Column(name = "active_status")
	private Integer activeStatus;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserRegistrationEtity [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", emailId=");
		builder.append(emailId);
		builder.append(", roleType=");
		builder.append(roleType);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
