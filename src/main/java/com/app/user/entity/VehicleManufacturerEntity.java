package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mst_vehicle_manufacturer")
public class VehicleManufacturerEntity {
	
	

	public VehicleManufacturerEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	@Column(name = "vehicle_manufacturer_id")
	private Long vehicleManufacturerId;
	              
	@Column(name = "vehicle_manufacturer_name")
	private String  vehicleManufacturerName;
	

	@Column(name = "active_status")
	private int activeStatus;
	
	

	public Long getVehicleManufacturerId() {
		return vehicleManufacturerId;
	}



	public void setVehicleManufacturerId(Long vehicleManufacturerId) {
		this.vehicleManufacturerId = vehicleManufacturerId;
	}



	public String getVehicleManufacturerName() {
		return vehicleManufacturerName;
	}



	public void setVehicleManufacturerName(String vehicleManufacturerName) {
		this.vehicleManufacturerName = vehicleManufacturerName;
	}



	public int getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}



	@Override
	public String toString() {
		return "VehicleManufacturerEntity [vehicleManufacturerId=" + vehicleManufacturerId
				+ ", vehicleManufacturerName=" + vehicleManufacturerName + ", activeStatus=" + activeStatus + "]";
	}
	
	

}
