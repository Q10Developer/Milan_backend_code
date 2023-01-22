package com.app.user.dto.request;

public class SendOTPRequestDTO {
	private Long userId;
	private Long mobileNumber;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "SendOTPRequestDTO [userId=" + userId + ", mobileNumber=" + mobileNumber + "]";
	}
	
}
