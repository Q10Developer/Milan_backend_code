package com.app.user.dto.request;

import java.util.Date;

public class VehicleInspectionRequestDTO {

	private String inspectionId;
	private Long clientId;
	private Long clientServiceLocationId;
	private String clientServiceLocationAddress;
	private String clientInformation;
	private String clientName;
	private Date inspectionDateTime;
	private String vehicleRegNumber;
	private Integer vehicleOdometerReading;
	private Long vehicleId;
	private String configuredVehicle;
	private Long vehicleManufacturer;
	private String vehicleManufacturerLabel;
	private Long vehicleModel;
	private String vehicleModelLabel;
	private Long vehicleType;
	private String vehicleTypeLabel;
	private Long noOfTires;
	private Long noOfStepneys;
	private int inspectionStatus;

	public Long getClientServiceLocationId() {
		return clientServiceLocationId;
	}

	public void setClientServiceLocationId(Long clientServiceLocationId) {
		this.clientServiceLocationId = clientServiceLocationId;
	}

	public String getClientServiceLocationAddress() {
		return clientServiceLocationAddress;
	}

	public void setClientServiceLocationAddress(String clientServiceLocationAddress) {
		this.clientServiceLocationAddress = clientServiceLocationAddress;
	}

	public String getInspectionId() {
		return inspectionId;

	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientInformation() {
		return clientInformation;
	}

	public void setClientInformation(String clientInformation) {
		this.clientInformation = clientInformation;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getInspectionDateTime() {
		return inspectionDateTime;
	}

	public void setInspectionDateTime(Date inspectionDateTime) {
		this.inspectionDateTime = inspectionDateTime;
	}

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
	}

	public Integer getVehicleOdometerReading() {
		return vehicleOdometerReading;
	}

	public void setVehicleOdometerReading(Integer vehicleOdometerReading) {
		this.vehicleOdometerReading = vehicleOdometerReading;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getConfiguredVehicle() {
		return configuredVehicle;
	}

	public void setConfiguredVehicle(String configuredVehicle) {
		this.configuredVehicle = configuredVehicle;
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

	public Long getNoOfTires() {
		return noOfTires;
	}

	public void setNoOfTires(Long noOfTires) {
		this.noOfTires = noOfTires;
	}

	public Long getNoOfStepneys() {
		return noOfStepneys;
	}

	public void setNoOfStepneys(Long noOfStepneys) {
		this.noOfStepneys = noOfStepneys;
	}

	public int getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(int inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleInspectionRequestDTO [inspectionId=");
		builder.append(inspectionId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientServiceLocationAddress=");
		builder.append(clientServiceLocationAddress);
		builder.append(", clientInformation=");
		builder.append(clientInformation);
		builder.append(", clientName=");
		builder.append(clientName);
		builder.append(", inspectionDateTime=");
		builder.append(inspectionDateTime);
		builder.append(", vehicleRegNumber=");
		builder.append(vehicleRegNumber);
		builder.append(", vehicleOdometerReading=");
		builder.append(vehicleOdometerReading);
		builder.append(", vehicleId=");
		builder.append(vehicleId);
		builder.append(", configuredVehicle=");
		builder.append(configuredVehicle);
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
		builder.append(", noOfTires=");
		builder.append(noOfTires);
		builder.append(", noOfStepneys=");
		builder.append(noOfStepneys);
		builder.append(", inspectionStatus=");
		builder.append(inspectionStatus);
		builder.append("]");
		return builder.toString();
	}

}
