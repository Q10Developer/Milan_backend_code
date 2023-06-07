package com.app.user.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vehicle_inspection")
public class VehicleInspectionEntity {

	@Id
	@GeneratedValue(generator = "custom-id-generator")
	@GenericGenerator(name = "custom-id-generator", strategy = "com.app.user.config.helper.CustomIdGenerator")
	@Column(name = "inspection_id")
	private String inspectionId;

	@Column(name = "client_id", nullable = false)
	private Long clientId;

	@Column(name = "client_information", nullable = false)
	private String clientInformation;

	@Column(name = "inspection_date_time", nullable = false)
	private Date inspectionDateTime;

	@Column(name = "vehicle_reg_number", nullable = false)
	private String vehicleRegNumber;

	@Column(name = "vehicle_odometer_reading", nullable = false)
	private Integer vehicleOdometerReading;

	@Column(name = "vehicle_id", nullable = false)
	private Long vehicleId;

	@Column(name = "configured_vehicle", nullable = false)
	private String configuredVehicle;

	@Column(name = "no_of_tires", nullable = false)
	private Long noOfTires;

	@Column(name = "no_of_stepneys", nullable = false)
	private Long noOfStepneys;

	@Column(name = "inspection_status", nullable = false)
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
		builder.append("VehicleInspectionEntity [inspectionId=");
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
