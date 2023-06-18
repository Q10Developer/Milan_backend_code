package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_observation")
public class ObservationEntity {

	@Id
	@GeneratedValue
	@Column(name = "observation_id")
	private Long observationId;

	@Column(name = "observation_name")
	private String observationName;

	@Column(name = "observation_recommendation")
	private String observationRecommendation;

	@Column(name = "observation_category_id")
	private Long observationCategoryId;

	@Column(name = "observation_category_type")
	private String observationCategoryType;

	@Column(name = "active_status")
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
		builder.append("ObservationEntity [observationId=");
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
