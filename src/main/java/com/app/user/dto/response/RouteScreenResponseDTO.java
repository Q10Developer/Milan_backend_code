package com.app.user.dto.response;

public class RouteScreenResponseDTO {
	private Long userId;
	private String screenId;
	private String screenDescription;

	public RouteScreenResponseDTO() {
		super();
	}

	public RouteScreenResponseDTO(Long userId, String screenId, String screenDescription) {
		super();
		this.userId = userId;
		this.screenId = screenId;
		this.screenDescription = screenDescription;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getScreenDescription() {
		return screenDescription;
	}

	public void setScreenDescription(String screenDescription) {
		this.screenDescription = screenDescription;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "RouteScreenResponseDTO [userId=" + userId + ", screenId=" + screenId + ", screenDescription="
				+ screenDescription + "]";
	}
}
