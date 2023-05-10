package com.app.user.dto.request;

public class VehicleSubTypeRequestDTO {
	
	
	private Long vehicleSubTypeId;
	private String vehicleSubTypeName;
private int ActiveStatus;
private Long vehicleTypeId;


	public VehicleSubTypeRequestDTO() {
		// TODO Auto-generated constructor stub
	}


	public Long getVehicleSubTypeId() {
		return vehicleSubTypeId;
	}


	public void setVehicleSubTypeId(Long vehicleSubTypeId) {
		this.vehicleSubTypeId = vehicleSubTypeId;
	}


	public String getVehicleSubTypeName() {
		return vehicleSubTypeName;
	}


	public void setVehicleSubTypeName(String vehicleSubTypeName) {
		this.vehicleSubTypeName = vehicleSubTypeName;
	}


	public int getActiveStatus() {
		return ActiveStatus;
	}


	public void setActiveStatus(int activeStatus) {
		ActiveStatus = activeStatus;
	}


	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}


	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}


	@Override
	public String toString() {
		return "VehicleSubTypeDTO [vehicleSubTypeId=" + vehicleSubTypeId + ", vehicleSubTypeName=" + vehicleSubTypeName
				+ ", ActiveStatus=" + ActiveStatus + ", vehicleTypeId=" + vehicleTypeId + "]";
	}

	
	
}
