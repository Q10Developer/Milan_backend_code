package com.app.user.dto.request;

public class ObservationRequestDTO {

	private Long observationId;
	private String observationName;
	private String observationRecommendation;
	private String observationCategoryType;
	private int activeStatus;
	

<<<<<<< Updated upstream
=======
	public ObservationRequestDTO() {
		// TODO Auto-generated constructor stub
	}


>>>>>>> Stashed changes
	public Long getObservationId() {
		return observationId;
	}


	public void setObservationId(Long observationId) {
		this.observationId = observationId;
	}


	public String getObservationName() {
		return observationName;
	}


	public void setObservationName(String observationName) {
		this.observationName = observationName;
	}


	public String getObservationRecommendation() {
		return observationRecommendation;
	}


	public void setObservationRecommendation(String observationRecommendation) {
		this.observationRecommendation = observationRecommendation;
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
		return "ObservationRequestDTO [observationId=" + observationId + ", observationName=" + observationName
				+ ", observationRecommendation=" + observationRecommendation + ", observationCategoryType="
				+ observationCategoryType + ", activeStatus=" + activeStatus + "]";
	}

	
}
