package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_observation_category")
public class ObservationCategoryEntity {

	@Id
	@GeneratedValue
	@Column(name = "observation_category_id")
	private Long observationCategoryId;

	@Column(name = "observation_category_type")
	private String observationCategoryType;

	@Column(name = "active_status")
	private int activeStatus;

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
		return "ObservationCategoryEntity [observationCategoryId=" + observationCategoryId
				+ ", observationCategoryType=" + observationCategoryType + ", activeStatus=" + activeStatus + "]";
	}

}
