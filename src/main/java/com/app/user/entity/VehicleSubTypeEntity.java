package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mst_vehicle_sub_type")
public class VehicleSubTypeEntity {

	@Id
	@GeneratedValue
	@Column(name = " vehicle_subtype_id")
	private Long vehicleSubTypeId;

	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private VehicleTypeEntity vehicleTypeId;

	@Column(name = "vehicle_subtype_name")
	private String vehicleSubTypeName;

	@Column(name = "no_of_tires")
	private Long noOfTires;

	@Column(name = "active_status", nullable = false)
	private int activeStatus;

	public Long getVehicleSubTypeId() {
		return vehicleSubTypeId;
	}

	public void setVehicleSubTypeId(Long vehicleSubTypeId) {
		this.vehicleSubTypeId = vehicleSubTypeId;
	}

	public VehicleTypeEntity getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(VehicleTypeEntity vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getVehicleSubTypeName() {
		return vehicleSubTypeName;
	}

	public void setVehicleSubTypeName(String vehicleSubTypeName) {
		this.vehicleSubTypeName = vehicleSubTypeName;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Long getNoOfTires() {
		return noOfTires;
	}

	public void setNoOfTires(Long noOfTires) {
		this.noOfTires = noOfTires;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleSubTypeEntity [vehicleSubTypeId=");
		builder.append(vehicleSubTypeId);
		builder.append(", vehicleTypeId=");
		builder.append(vehicleTypeId);
		builder.append(", vehicleSubTypeName=");
		builder.append(vehicleSubTypeName);
		builder.append(", noOfTires=");
		builder.append(noOfTires);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
