package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = " mst_vehicle_usage")
public class VehicleUsageEntity {

	
	@Id
	@GeneratedValue
	@Column(name = "vehicle_usage_id")
	private Long  vehicleUsageId;
	
	
	@Column(name = "vehicle_usage_name")
	private String  vehicleUsageName;
	
	@Column(name = "active_status")
	private int activeStatus;

	
	public VehicleUsageEntity() {
		// TODO Auto-generated constructor stub
	}


	public Long getVehicleUsageId() {
		return vehicleUsageId;
	}


	public void setVehicleUsageId(Long vehicleUsageId) {
		this.vehicleUsageId = vehicleUsageId;
	}


	public String getVehicleUsageName() {
		return vehicleUsageName;
	}


	public void setVehicleUsageName(String vehicleUsageName) {
		this.vehicleUsageName = vehicleUsageName;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	@Override
	public String toString() {
		return "VehicleUsageEntity [vehicleUsageId=" + vehicleUsageId + ", vehicleUsageName=" + vehicleUsageName
				+ ", activeStatus=" + activeStatus + "]";
	}
	

}
