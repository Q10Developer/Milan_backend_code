package com.app.user.dto.request;

import java.math.BigInteger;
import java.util.Date;

public class VehicleInspectionRequestDTO {

	private String inspectionId;
	private Long clientId;
	private String clientInformation;
	private Date inspectionDateTime;
	private String vehicleRegNumber;
	private BigInteger vehicleOdometerReading;
	private Long vehicleId;
	private String configuredVehicle;
	private Long noOfTires;
	private Long noOfStepneys;
	private int inspectionStatus;

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

	public BigInteger getVehicleOdometerReading() {
		return vehicleOdometerReading;
	}

	public void setVehicleOdometerReading(BigInteger vehicleOdometerReading) {
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
		builder.append(", clientInformation=");
		builder.append(clientInformation);
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
