package com.app.user.dto.request;

public class VehicleModelRequestDTO {

	private Long vehicleModelId;
	private String vehicleModelName;
	private int activeStatus;
	private Long vehicleManufacturerId;

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

	public Long getVehicleManufacturerId() {
		return vehicleManufacturerId;
	}

	public void setVehicleManufacturerId(Long vehicleManufacturerId) {
		this.vehicleManufacturerId = vehicleManufacturerId;
	}

	@Override
	public String toString() {
		return "VehicleModelRequestDTO [vehicleModelId=" + vehicleModelId + ", vehicleModelName=" + vehicleModelName
				+ ", activeStatus=" + activeStatus + ", vehicleManufacturerId=" + vehicleManufacturerId + "]";
	}

}
