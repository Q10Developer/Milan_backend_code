package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="mst_vehicle_sub_type")
public class VehicleSubTypeEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "vehicle_subtype_id")
	private Long vehicleSubTypeId ;
	             
	
	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private  VehicleTypeEntity VehicleTypeId;
	
	@Column(name = "vehicle_subtype_name")
	private String vehicleSubTypeName;
	
	@Column(name = "active_status")
	private int activeStatus;
	
	

	public VehicleSubTypeEntity() {
		// TODO Auto-generated constructor stub
	}



	public Long getVehicleSubTypeId() {
		return vehicleSubTypeId;
	}



	public void setVehicleSubTypeId(Long vehicleSubTypeId) {
		vehicleSubTypeId = vehicleSubTypeId;
	}



	public VehicleTypeEntity getVehicleTypeId() {
		return VehicleTypeId;
	}



	public void setVehicleTypeId(VehicleTypeEntity vehicleTypeId) {
		VehicleTypeId = vehicleTypeId;
	}



	public String getVehicleSubTypeName() {
		return vehicleSubTypeName;
	}



	public void setVehicleSubTypeName(String vehicleSubTypeName) {
		vehicleSubTypeName = vehicleSubTypeName;
	}



	public int getActiveStatus() {
		return activeStatus;
	}



	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}



	@Override
	public String toString() {
		return "VehicleSubTypeEntity [VehicleSubTypeId=" + vehicleSubTypeId + ", VehicleTypeId=" + VehicleTypeId
				+ ", VehicleSubTypeName=" + vehicleSubTypeName + ", activeStatus=" + activeStatus + "]";
	}

	
	
}
