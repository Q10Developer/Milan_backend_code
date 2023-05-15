package com.app.user.dto.request;

public class VehicleModelRequestDTO {
	
	private Long  vehicleModelId;
	private String vehicleModelName;
	private int ActiveStatus;
	private Long  vehicleManufacturerId;

	public VehicleModelRequestDTO() {
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
		return ActiveStatus;
	}

	public void setActiveStatus(int activeStatus) {
		ActiveStatus = activeStatus;
	}

	public Long getVehicleManufacturerId() {
		return vehicleManufacturerId;
	}

	public void setVehicleManufacturerId(Long vehicleManufacturerId) {
		this.vehicleManufacturerId = vehicleManufacturerId;
	}

	@Override
	public String toString() {
		return "VehicleModelRequestDTO [vehicleModelId=" + vehicleModelId + ", vehicleModelName=" + vehicleModelName
				+ ", ActiveStatus=" + ActiveStatus + ", vehicleManufacturerId=" + vehicleManufacturerId + "]";
	}
	

}
