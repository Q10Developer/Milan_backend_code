package com.app.user.dto.request;

public class ObservationRequestDTO {
	
	private Long observationId;
	private int observationValue;
	private String observationLabel;
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



	public int getObservationValue() {
		return observationValue;
	}



	public void setObservationValue(int observationValue) {
		this.observationValue = observationValue;
	}



	public String getObservationLabel() {
		return observationLabel;
	}



	public void setObservationLabel(String observationLabel) {
		this.observationLabel = observationLabel;
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
