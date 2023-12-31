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

	@Column(name = "client_name", nullable = false)
	private String clientName;

	@Column(name = "client_information", nullable = false)
	private String clientInformation;

	@Column(name = "client_service_location_id", nullable = false)
	private Long clientServiceLocationId;

	@Column(name = "client_service_location_address", nullable = false)
	private String clientServiceLocationAddress;

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

	@Column(name = "vehicle_manufacturer", nullable = false)
	private Long vehicleManufacturer;

	@Column(name = "vehicle_manufacturer_label", nullable = false)
	private String vehicleManufacturerLabel;

	@Column(name = "vehicle_model", nullable = false)
	private Long vehicleModel;

	@Column(name = "vehicle_model_label", nullable = false)
	private String vehicleModelLabel;

	@Column(name = "vehicle_type", nullable = false)
	private Long vehicleType;

	@Column(name = "vehicle_type_label", nullable = false)
	private String vehicleTypeLabel;
	
	
	@Column(name="driver_name", nullable=true)
	private String driverName;
	
	@Column(name="driver_mobile_no", nullable=true)
	private Long driverMobileNo;
	
	@Column(name="maintanace_manager_name", nullable=true)
	private String maintanaceManagerName;
	
	@Column(name="maintanace_manager_mobile_no", nullable=true)
	private Long maintanaceManagerMobileNo;
	
	@Column(name="milan_tire_service_and_solution_name", nullable=true)
	private String milanTireServiceAndSolutionName;
	
	@Column(name="milan_tire_service_and_solution_mobile_no", nullable=true)
	private Long milanTireServiceAndSolutionMobileNo;
	
	
	@Column(name = "no_of_tires", nullable = false)
	private Long noOfTires;
	
	
	@Column(name="tire_sequence", nullable =false)
	private String tireSequence;

	@Column(name = "no_of_stepneys", nullable = false)
	private Long noOfStepneys;

	@Column(name = "inspection_status", nullable = false)
	private int inspectionStatus;

	
	
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Long getDriverMobileNo() {
		return driverMobileNo;
	}

	public void setDriverMobileNo(Long driverMobileNo) {
		this.driverMobileNo = driverMobileNo;
	}

	public String getMaintanaceManagerName() {
		return maintanaceManagerName;
	}

	public void setMaintanaceManagerName(String maintanaceManagerName) {
		this.maintanaceManagerName = maintanaceManagerName;
	}

	public Long getMaintanaceManagerMobileNo() {
		return maintanaceManagerMobileNo;
	}

	public void setMaintanaceManagerMobileNo(Long maintanaceManagerMobileNo) {
		this.maintanaceManagerMobileNo = maintanaceManagerMobileNo;
	}

	public String getMilanTireServiceAndSolutionName() {
		return milanTireServiceAndSolutionName;
	}

	public void setMilanTireServiceAndSolutionName(String milanTireServiceAndSolutionName) {
		this.milanTireServiceAndSolutionName = milanTireServiceAndSolutionName;
	}

	public Long getMilanTireServiceAndSolutionMobileNo() {
		return milanTireServiceAndSolutionMobileNo;
	}

	public void setMilanTireServiceAndSolutionMobileNo(Long milanTireServiceAndSolutionMobileNo) {
		this.milanTireServiceAndSolutionMobileNo = milanTireServiceAndSolutionMobileNo;
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

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientInformation() {
		return clientInformation;
	}

	public void setClientInformation(String clientInformation) {
		this.clientInformation = clientInformation;
	}

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


	public String getTireSequence() {
		return tireSequence;
	}

	public void setTireSequence(String tireSequence) {
		this.tireSequence = tireSequence;
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
		builder.append(", clientName=");
		builder.append(clientName);
		builder.append(", clientInformation=");
		builder.append(clientInformation);
		builder.append(", clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientServiceLocationAddress=");
		builder.append(clientServiceLocationAddress);
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
		builder.append(", driverName=");
		builder.append(driverName);
		builder.append(", driverMobileNo=");
		builder.append(driverMobileNo);
		builder.append(", maintanaceManagerName=");
		builder.append(maintanaceManagerName);
		builder.append(", maintanaceManagerMobileNo=");
		builder.append(maintanaceManagerMobileNo);
		builder.append(", milanTireServiceAndSolutionName=");
		builder.append(milanTireServiceAndSolutionName);
		builder.append(", milanTireServiceAndSolutionMobileNo=");
		builder.append(milanTireServiceAndSolutionMobileNo);
		builder.append(", noOfTires=");
		builder.append(noOfTires);
		builder.append(", tireSequence=");
		builder.append(tireSequence);
		builder.append(", noOfStepneys=");
		builder.append(noOfStepneys);
		builder.append(", inspectionStatus=");
		builder.append(inspectionStatus);
		builder.append("]");
		return builder.toString();
	}

	

}
