package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="mst_vehicle_model")
public class VehicleModelEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name = "vehicle_model_id")
	private Long  vehicleModelId;
	
	@Column(name = "vehicle_model_name")
	private String vehicleModelName;

	@Column(name = "active_status")
	private int activeStatus;
	
	@ManyToOne
	@JoinColumn(name ="vehicle_manufacturer_id")
	private  VehicleManufacturerEntity  vehicleManufacturerId;
	
	
	public VehicleModelEntity() {
		// TODO Auto-generated constructor stub
	}


	public Long getVehicleModelId() {
		return vehicleModelId;
	}


	public void setVehicleModelId(Long vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}


	public String getVehicleModelName() {
		return vehicleModelName;
	}


	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}


	public int getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}


	public VehicleManufacturerEntity getVehicleManufacturerId() {
		return vehicleManufacturerId;
	}


	public void setVehicleManufacturerId(VehicleManufacturerEntity vehicleManufacturerId) {
		this.vehicleManufacturerId = vehicleManufacturerId;
	}


	@Override
	public String toString() {
		return "VehicleModelEntity [vehicleModelId=" + vehicleModelId + ", vehicleModelName=" + vehicleModelName
				+ ", activeStatus=" + activeStatus + ", vehicleManufacturerId=" + vehicleManufacturerId + "]";
	}
	
	

}
