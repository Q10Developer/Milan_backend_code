package com.app.user.dto.request;

public class ChangePasswordRequestDto {
	private String oldPassword;
	private String confirmNewPassword;
	private String newPassword;
	private String emailId;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ChangePasswordRequestDto [oldPassword=" + oldPassword + ", confirmNewPassword=" + confirmNewPassword
				+ ", newPassword=" + newPassword + ", emailId=" + emailId + "]";
	}	
}
