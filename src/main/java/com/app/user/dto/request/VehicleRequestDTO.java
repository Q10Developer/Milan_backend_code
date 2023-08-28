package com.app.user.dto.request;

public class VehicleRequestDTO {

	private Long vehicleId;
	private Long vehicleManufacturer;
	private String vehicleManufacturerLabel;
	private Long vehicleModel;
	private String vehicleModelLabel;
	private Long vehicleType;
	private String vehicleTypeLabel;
	private String vehicleSubType;
	private String vehicleSubTypeLabel;
	private String tireSequence;
	private Long vehicleUsage;
	private String vehicleUsageLabel;
	private Long noOfTires;
	private Long noOfAxle;
	private Long noOfStepneys;
	private int activeStatus;

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Long getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(Long vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public String getVehicleManufacturerLabel() {
		return vehicleManufacturerLabel;
	}

	public void setVehicleManufacturerLabel(String vehicleManufacturerLabel) {
		this.vehicleManufacturerLabel = vehicleManufacturerLabel;
	}

	public Long getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(Long vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleModelLabel() {
		return vehicleModelLabel;
	}

	public void setVehicleModelLabel(String vehicleModelLabel) {
		this.vehicleModelLabel = vehicleModelLabel;
	}

	
	
	
	public Long getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Long vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleTypeLabel() {
		return vehicleTypeLabel;
	}

	public void setVehicleTypeLabel(String vehicleTypeLabel) {
		this.vehicleTypeLabel = vehicleTypeLabel;
	}

	public String getVehicleSubType() {
		return vehicleSubType;
	}

	public void setVehicleSubType(String vehicleSubType) {
		this.vehicleSubType = vehicleSubType;
	}

	public String getVehicleSubTypeLabel() {
		return vehicleSubTypeLabel;
	}

	public void setVehicleSubTypeLabel(String vehicleSubTypeLabel) {
		this.vehicleSubTypeLabel = vehicleSubTypeLabel;
	}


	public String getTireSequence() {
		return tireSequence;
	}

	public void setTireSequence(String tireSequence) {
		this.tireSequence = tireSequence;
	}

	public Long getVehicleUsage() {
		return vehicleUsage;
	}

	public void setVehicleUsage(Long vehicleUsage) {
		this.vehicleUsage = vehicleUsage;
	}

	public String getVehicleUsageLabel() {
		return vehicleUsageLabel;
	}

	public void setVehicleUsageLabel(String vehicleUsageLabel) {
		this.vehicleUsageLabel = vehicleUsageLabel;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleRequestDTO [vehicleId=");
		builder.append(vehicleId);
		builder.append(", vehicleManufacturer=");
		builder.append(vehicleManufacturer);
		builder.append(", vehicleManufacturerLabel=");
		builder.append(vehicleManufacturerLabel);
		builder.append(", vehicleModel=");
		builder.append(vehicleModel);
		builder.append(", vehicleModelLabel=");
		builder.append(vehicleModelLabel);
		builder.append(", vehicleType=");
		builder.append(vehicleType);
		builder.append(", vehicleTypeLabel=");
		builder.append(vehicleTypeLabel);
		builder.append(", vehicleSubType=");
		builder.append(vehicleSubType);
		builder.append(", vehicleSubTypeLabel=");
		builder.append(vehicleSubTypeLabel);
		builder.append(", tireSequence=");
		builder.append(tireSequence);
		builder.append(", vehicleUsage=");
		builder.append(vehicleUsage);
		builder.append(", vehicleUsageLabel=");
		builder.append(vehicleUsageLabel);
		builder.append(", noOfTires=");
		builder.append(noOfTires);
		builder.append(", noOfAxle=");
		builder.append(noOfAxle);
		builder.append(", noOfStepneys=");
		builder.append(noOfStepneys);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}


	
	
	

}
