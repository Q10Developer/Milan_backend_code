package com.app.user.dto.request;

import java.io.Serializable;


public class LoginWithMpinRequestDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long userId;
	private Integer mpin;
	private String deviceId;
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
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	@Override
	public String toString() {
		return "LoginWithMpinRequestDTO [userId=" + userId + ", mpin=" + mpin + ", deviceId=" + deviceId + "]";
	}
}
