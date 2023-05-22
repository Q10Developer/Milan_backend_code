package com.app.user.dto.request;

public class ObservationCategoryRequestDTO {
	
	private Long observationCategoryId;
	private String observationCategoryType;
	private int activeStatus;
	

	public ObservationCategoryRequestDTO() {
		// TODO Auto-generated constructor stub
	}


	public Long getObservationCategoryId() {
		return observationCategoryId;
	}

	public void setObservationCategoryId(Long observationCategoryId) {
		this.observationCategoryId = observationCategoryId;
	}


	public String getObservationCategoryType() {
		return observationCategoryType;
	}


	public void setObservationCategoryType(String observationCategoryType) {
		this.observationCategoryType = observationCategoryType;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	@Override
	public String toString() {
		return "ObservationCategoryRequestDTO [observationCategoryId=" + observationCategoryId
				+ ", observationCategoryType=" + observationCategoryType + ", activeStatus=" + activeStatus + "]";
	}

	
	
	
}
