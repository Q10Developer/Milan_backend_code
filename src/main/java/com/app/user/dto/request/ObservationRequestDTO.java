package com.app.user.dto.request;

public class ObservationRequestDTO {

	private Long observationId;
	private String observationName;
	private String observationRecommendation;
	private Long observationCategoryId;
	private String observationCategoryType;
	private int activeStatus;

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
		StringBuilder builder = new StringBuilder();
		builder.append("ObservationRequestDTO [observationId=");
		builder.append(observationId);
		builder.append(", observationName=");
		builder.append(observationName);
		builder.append(", observationRecommendation=");
		builder.append(observationRecommendation);
		builder.append(", observationCategoryId=");
		builder.append(observationCategoryId);
		builder.append(", observationCategoryType=");
		builder.append(observationCategoryType);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
