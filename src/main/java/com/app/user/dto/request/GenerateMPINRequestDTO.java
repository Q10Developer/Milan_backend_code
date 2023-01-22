package com.app.user.dto.request;

public class GenerateMPINRequestDTO {
	private Long userId;
	private Integer mpin;
	private Integer confirmMpin;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getMpin() {
		return mpin;
	}
	public void setMpin(Integer mpin) {
		this.mpin = mpin;
	}
	
	public Integer getConfirmMpin() {
		return confirmMpin;
	}
	public void setConfirmMpin(Integer confirmMpin) {
		this.confirmMpin = confirmMpin;
	}
	@Override
	public String toString() {
		return "GenerateMPINRequestDTO [userId=" + userId + ", mpin=" + mpin + ", confirmMpin=" + confirmMpin + "]";
	}	
}
