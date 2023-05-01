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

	@Column(name = "observation_name")
	private String observationName;
	
	
	  @Column (name="observation_recommendation")
    private String observationRecommendation;
    
   
    

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


	public int getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}



	
	@Override
	public String toString() {
		return "ObservationEntity [observationId=" + observationId + ", observationName=" + observationName
				+ ", observationRecommendation=" + observationRecommendation + ", activeStatus=" + activeStatus + "]";
	}



	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}



	



	


	}



	 

	
	


