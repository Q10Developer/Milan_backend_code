package com.app.user.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_tire_make")
public class TireMakeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "tire_make_id")
	private Long tireMakeId;

	@Column(name = "tire_make_name")
	private String tireMakeName;

	
	@Column(name = "active_status")
	private int activeStatus;

	
	public TireMakeEntity() {
		// TODO Auto-generated constructor stub
	}


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
		return "TireMakeEntity [tireMakeId=" + tireMakeId + ", tireMakeName=" + tireMakeName + ", activeStatus="
				+ activeStatus + "]";
	}
	
	

}
