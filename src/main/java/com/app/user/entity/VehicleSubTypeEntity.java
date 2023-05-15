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
	private Long  vehicleSubTypeId;
	
	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private VehicleTypeEntity vehicleTypeId ;
	
	@Column(name = "vehicle_subtype_name")
	private String vehicleSubTypeName;

	@Column(name = "active_status", nullable = false)
	private int activeStatus;

	
	public VehicleSubTypeEntity() {
		// TODO Auto-generated constructor stub
	}


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


	@Override
	public String toString() {
		return "VehicleSubTypeEntity [vehicleSubTypeId=" + vehicleSubTypeId + ", vehicleTypeId=" + vehicleTypeId
				+ ", vehicleSubTypeName=" + vehicleSubTypeName + ", activeStatus=" + activeStatus + "]";
	}
	

}
