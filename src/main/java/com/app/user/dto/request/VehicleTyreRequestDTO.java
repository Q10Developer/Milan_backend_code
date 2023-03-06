package com.app.user.dto.request;

public class VehicleTyreRequestDTO {

	private Long vehicleTyreId;
	private Long vehicleTypeId;
	private Long vehicleSubTypeId;
	private Long vehicleMakerId;
	private Long noofTyresId;
	private Long vehicleUsageId;
	private Long tyreSizeId;
	private Long tyreLocationId;
	private Long loadIndexId;
	private Long speedIndexId;
	private int activeStatus;

	public Long getVehicleTyreId() {
		return vehicleTyreId;
	}

	public void setVehicleTyreId(Long vehicleTyreId) {
		this.vehicleTyreId = vehicleTyreId;
	}

	public Long getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Long vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public Long getVehicleSubTypeId() {
		return vehicleSubTypeId;
	}

	public void setVehicleSubTypeId(Long vehicleSubTypeId) {
		this.vehicleSubTypeId = vehicleSubTypeId;
	}

	public Long getVehicleMakerId() {
		return vehicleMakerId;
	}

	public void setVehicleMakerId(Long vehicleMakerId) {
		this.vehicleMakerId = vehicleMakerId;
	}

	public Long getNoofTyresId() {
		return noofTyresId;
	}

	public void setNoofTyresId(Long noofTyresId) {
		this.noofTyresId = noofTyresId;
	}

	public Long getVehicleUsageId() {
		return vehicleUsageId;
	}

	public void setVehicleUsageId(Long vehicleUsageId) {
		this.vehicleUsageId = vehicleUsageId;
	}

	public Long getTyreSizeId() {
		return tyreSizeId;
	}

	public void setTyreSizeId(Long tyreSizeId) {
		this.tyreSizeId = tyreSizeId;
	}

	public Long getTyreLocationId() {
		return tyreLocationId;
	}

	public void setTyreLocationId(Long tyreLocationId) {
		this.tyreLocationId = tyreLocationId;
	}

	public Long getLoadIndexId() {
		return loadIndexId;
	}

	public void setLoadIndexId(Long loadIndexId) {
		this.loadIndexId = loadIndexId;
	}

	public Long getSpeedIndexId() {
		return speedIndexId;
	}

	public void setSpeedIndexId(Long speedIndexId) {
		this.speedIndexId = speedIndexId;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleTyreRequestDTO [vehicleTyreId=");
		builder.append(vehicleTyreId);
		builder.append(", vehicleTypeId=");
		builder.append(vehicleTypeId);
		builder.append(", vehicleSubTypeId=");
		builder.append(vehicleSubTypeId);
		builder.append(", vehicleMakerId=");
		builder.append(vehicleMakerId);
		builder.append(", noofTyresId=");
		builder.append(noofTyresId);
		builder.append(", vehicleUsageId=");
		builder.append(vehicleUsageId);
		builder.append(", tyreSizeId=");
		builder.append(tyreSizeId);
		builder.append(", tyreLocationId=");
		builder.append(tyreLocationId);
		builder.append(", loadIndexId=");
		builder.append(loadIndexId);
		builder.append(", speedIndexId=");
		builder.append(speedIndexId);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
