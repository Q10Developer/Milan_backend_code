package com.app.user.dto.request;

public class TireMakeRequestDTO {

	private Long tireMakeId;
	private String tireMakeName;
	private int activeStatus;

	public Long getTireMakeId() {
		return tireMakeId;
	}

	public void setTireMakeId(Long tireMakeId) {
		this.tireMakeId = tireMakeId;
	}

	public String getTireMakeName() {
		return tireMakeName;
	}

	public void setTireMakeName(String tireMakeName) {
		this.tireMakeName = tireMakeName;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "TireMakeRequestDTO [tireMakeId=" + tireMakeId + ", tireMakeName=" + tireMakeName + ", activeStatus="
				+ activeStatus + "]";
	}

}
