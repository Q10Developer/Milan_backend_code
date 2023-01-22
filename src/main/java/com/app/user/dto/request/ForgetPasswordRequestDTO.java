package com.app.user.dto.request;

public class ForgetPasswordRequestDTO {
	private String password;
	private String confirmPassword;
	private String emailId;
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
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ForgetPasswordRequestDTO [password=" + password + ", confirmPassword=" + confirmPassword + ", emailId="
				+ emailId + "]";
	}
}
