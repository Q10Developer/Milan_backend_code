package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_observation")
public class ObservationEntity {

	public ObservationEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "observation_id")
	private Long observationId;

	@Column(name = "observation_value")
	private  int observationValue;
	
	
    @Column (name=" observation_label")
    private String observationLabel;
    
    

	@Column(name = "active_status")
	private int activeStatus;




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
		return "ObservationEntity [observationId=" + observationId + ", observationValue=" + observationValue
				+ ", observationLabel=" + observationLabel + ", activeStatus=" + activeStatus + "]";
	}



	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	



	


	}



	 

	
	


