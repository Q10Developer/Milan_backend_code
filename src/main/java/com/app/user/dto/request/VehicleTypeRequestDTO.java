package com.app.user.dto.request;

public class VehicleTypeRequestDTO {
	
	private Long  vehicleTypeId;
	private String  vehicleTypeName;
	private int activeStatus;

	public VehicleTypeRequestDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
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
		return "VehicleTypeRequestDTO [vehicleTypeId=" + vehicleTypeId + ", vehicleTypeName=" + vehicleTypeName
				+ ", activeStatus=" + activeStatus + "]";
	}

	
	
	
	
	

}