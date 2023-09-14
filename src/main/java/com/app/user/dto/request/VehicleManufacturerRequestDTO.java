package com.app.user.dto.request;

public class VehicleManufacturerRequestDTO {

	private Long vehicleManufacturerId;
	private String vehicleManufacturerName;
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
		return "VehicleManufacturerRequestDTO [vehicleManufacturerId=" + vehicleManufacturerId
				+ ", vehicleManufacturerName=" + vehicleManufacturerName + ", activeStatus=" + activeStatus + "]";
	}

}
