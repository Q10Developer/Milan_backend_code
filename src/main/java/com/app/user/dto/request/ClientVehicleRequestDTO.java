package com.app.user.dto.request;

public class ClientVehicleRequestDTO {
	
	private Long clientVehicleId;
	private Long clientId;
	private Long clientServiceLocationId;
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
	private String clientServiceLocationAddress;
    private String clientName;
    private String vehicleRegNumber;
    private Long vehicleId;
	private String configuredVehicle;
	private Long vehicleManufacturer;
	private String vehicleManufacturerLabel;
	private Long vehicleModel;
	private String vehicleModelLabel;
	private Long vehicleType;
	private String vehicleTypeLabel;
	private int inspectionStatus;
	private int activeStatus;
	
	
	public Long getClientVehicleId() {
		return clientVehicleId;
	}
	public void setClientVehicleId(Long clientVehicleId) {
		this.clientVehicleId = clientVehicleId;
	}
	public int getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientVehicleRequestDTO [clientVehicleId=");
		builder.append(clientVehicleId);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientServiceLocationAddress=");
		builder.append(clientServiceLocationAddress);
		builder.append(", clientName=");
		builder.append(clientName);
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
		builder.append(", inspectionStatus=");
		builder.append(inspectionStatus);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}
	public int getInspectionStatus() {
		return inspectionStatus;
	}
	public void setInspectionStatus(int inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}
	
	
		
	
	
	
	
 

}
