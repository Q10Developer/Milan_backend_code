package com.app.user.dto.request;

public class ObservationRequestDTO {
	
	private Long observationId;
	private String observationName;
	private String observationRecommendation;
	private int activeStatus;
	
	

	public ObservationRequestDTO() {
		// TODO Auto-generated constructor stub
	}



	public Long getObservationId() {
		return observationId;
	}



	public void setObservationId(Long observationId) {
		this.observationId = observationId;
	}



	public int getgetObservationName() {
		return observationName ;
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



	public int getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}



	@Override
	public String toString() {
		return "ObservatiomRequestDTO [observationId=" + observationId + ", observationValue=" + observationValue
				+ ", observationLabel=" + observationLabel + ", activeStatus=" + activeStatus + "]";
	}

	
	
	
}
