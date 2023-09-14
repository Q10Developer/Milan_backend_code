package com.app.user.dto.request;

public class VehicleUsageRequestDTO {

	private Long vehicleUsageId;
	private String vehicleUsageName;
	private int activeStatus;

	public Long getVehicleUsageId() {
		return vehicleUsageId;
	}

	public void setVehicleUsageId(Long vehicleUsageId) {
		this.vehicleUsageId = vehicleUsageId;
	}

	public String getVehicleUsageName() {
		return vehicleUsageName;
	}

	public void setVehicleUsageName(String vehicleUsageName) {
		this.vehicleUsageName = vehicleUsageName;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		return "VehicleUsageRequestDTO [vehicleUsageId=" + vehicleUsageId + ", vehicleUsageName=" + vehicleUsageName
				+ ", activeStatus=" + activeStatus + "]";
	}

}
