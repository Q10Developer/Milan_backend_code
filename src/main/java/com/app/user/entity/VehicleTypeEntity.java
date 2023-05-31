package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " mst_vehicle_type")
public class VehicleTypeEntity {

	@Id
	@GeneratedValue
	@Column(name = "vehicle_type_id")
	private Long vehicleTypeId;

	@Column(name = "vehicle_type_name")
	private String vehicleTypeName;

	@Column(name = "active_status")
	private int activeStatus;

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getVehicleTypeName() {
		return vehicleTypeName;
	}

	public void setVehicleTypeName(String vehicleTypeName) {
		this.vehicleTypeName = vehicleTypeName;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "VehicleTypeEntity [vehicleTypeId=" + vehicleTypeId + ", vehicleTypeName=" + vehicleTypeName
				+ ", activeStatus=" + activeStatus + "]";
	}

}
