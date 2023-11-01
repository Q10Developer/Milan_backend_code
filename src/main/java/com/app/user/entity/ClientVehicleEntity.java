package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "client_vehicle")
public class ClientVehicleEntity {

	@Id
	@GeneratedValue
	@Column(name = "client_vehicle_id")
	private Long clientVehicleId;

	

	@Column(name = "client_id", nullable = false)
	private Long clientId;
	
	@Column(name = "client_name", nullable = false)
	private String clientName;

	
	@Column(name = "client_service_location_id", nullable = false)
	private Long clientServiceLocationId;

	@Column(name = "client_service_location_address", nullable = false)
	private String clientServiceLocationAddress;
	
	
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

	@Column(name = "vehicle_reg_number", nullable = false)
	private String vehicleRegNumber;
	
	
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
	
	
	@Column(name = "active_status")
	private int activeStatus;
	
	@Column(name = "inspection_status", nullable = false)
	private int inspectionStatus;
	

	public Long getClientVehicleId() {
		return clientVehicleId;
	}

	public void setClientVehicleId(Long clientVehicleId) {
		this.clientVehicleId = clientVehicleId;
	}

	public int getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(int inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
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

	public String getVehicleRegNumber() {
		return vehicleRegNumber;
	}

	public void setVehicleRegNumber(String vehicleRegNumber) {
		this.vehicleRegNumber = vehicleRegNumber;
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

	

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientVehicleEntity [clientVehicleId=");
		builder.append(clientVehicleId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", clientName=");
		builder.append(clientName);
		builder.append(", clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientServiceLocationAddress=");
		builder.append(clientServiceLocationAddress);
		builder.append(", vehicleRegNumber=");
		builder.append(vehicleRegNumber);
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
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append(", inspectionStatus=");
		builder.append(inspectionStatus);
		builder.append("]");
		return builder.toString();
	}
	
	

}
