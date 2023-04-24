package com.app.user.dto.request;

public class VehicleRequestDTO {

	private Long vehicleId;
	private String vehicleModel;
	private Long vehicleManufacturer;
	private Long vehicleType;
	private Long vehicleSubType;
	private Long vehicleUsage;
	private Long noOfTires;
	private Long noOfAxle;
	private Long noOfBatteries;
	private Long noOfStepneys;
	private int activeStatus;
	private String vehicleManufacturerLabel;
	private String vehicleTypeLabel;
	private String vehicleSubTypeLabel;
	private String vehicleUsageLabel;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public Long getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(Long vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public Long getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Long vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Long getVehicleSubType() {
		return vehicleSubType;
	}

	public void setVehicleSubType(Long vehicleSubType) {
		this.vehicleSubType = vehicleSubType;
	}

	public Long getVehicleUsage() {
		return vehicleUsage;
	}

	public void setVehicleUsage(Long vehicleUsage) {
		this.vehicleUsage = vehicleUsage;
	}

	public Long getNoOfTires() {
		return noOfTires;
	}

	public void setNoOfTires(Long noOfTires) {
		this.noOfTires = noOfTires;
	}

	public Long getNoOfAxle() {
		return noOfAxle;
	}

	public void setNoOfAxle(Long noOfAxle) {
		this.noOfAxle = noOfAxle;
	}

	public Long getNoOfBatteries() {
		return noOfBatteries;
	}

	public void setNoOfBatteries(Long noOfBatteries) {
		this.noOfBatteries = noOfBatteries;
	}

	public Long getNoOfStepneys() {
		return noOfStepneys;
	}

	public void setNoOfStepneys(Long noOfStepneys) {
		this.noOfStepneys = noOfStepneys;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}
	

	public String getVehicleManufacturerLabel() {
		return vehicleManufacturerLabel;
	}

	public void setVehicleManufacturerLabel(String vehicleManufacturerLabel) {
		this.vehicleManufacturerLabel = vehicleManufacturerLabel;
	}

	public String getVehicleTypeLabel() {
		return vehicleTypeLabel;
	}

	public void setVehicleTypeLabel(String vehicleTypeLabel) {
		this.vehicleTypeLabel = vehicleTypeLabel;
	}

	public String getVehicleSubTypeLabel() {
		return vehicleSubTypeLabel;
	}

	public void setVehicleSubTypeLabel(String vehicleSubTypeLabel) {
		this.vehicleSubTypeLabel = vehicleSubTypeLabel;
	}

	public String getVehicleUsageLabel() {
		return vehicleUsageLabel;
	}

	public void setVehicleUsageLabel(String vehicleUsageLabel) {
		this.vehicleUsageLabel = vehicleUsageLabel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleRequestDTO [vehicleId=");
		builder.append(vehicleId);
		builder.append(", vehicleModel=");
		builder.append(vehicleModel);
		builder.append(", vehicleManufacturer=");
		builder.append(vehicleManufacturer);
		builder.append(", vehicleType=");
		builder.append(vehicleType);
		builder.append(", vehicleSubType=");
		builder.append(vehicleSubType);
		builder.append(", vehicleUsage=");
		builder.append(vehicleUsage);
		builder.append(", noOfTires=");
		builder.append(noOfTires);
		builder.append(", noOfAxle=");
		builder.append(noOfAxle);
		builder.append(", noOfBatteries=");
		builder.append(noOfBatteries);
		builder.append(", noOfStepneys=");
		builder.append(noOfStepneys);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append(", vehicleManufacturerLabel=");
		builder.append(vehicleManufacturerLabel);
		builder.append(", vehicleTypeLabel=");
		builder.append(vehicleTypeLabel);
		builder.append(", vehicleSubTypeLabel=");
		builder.append(vehicleSubTypeLabel);
		builder.append(", vehicleUsageLabel=");
		builder.append(vehicleUsageLabel);		
		builder.append("]");
		return builder.toString();
	}

}
