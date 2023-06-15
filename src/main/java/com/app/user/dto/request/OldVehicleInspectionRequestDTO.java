package com.app.user.dto.request;

import java.util.Date;

public class OldVehicleInspectionRequestDTO {
	
	private Long srNo;
	private String  nameAndAddressofTransportCompany;
	private String  mobileNo;
	private Date dateRegistered;
	private   Long vehicleMakeModel;
	private String  vehicleMakeModelLabel;
	private Long vehicleConfiguration;
	private String  vehicleConfigurationLabel;
	private Long   odometerReading;
	private String  recommendedAirPressure;
	private int oldVehicleInspectionStatus;
	private String  registrationNo;
	public Long getSrNo() {
		return srNo;
	}
	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}
	public String getNameAndAddressofTransportCompany() {
		return nameAndAddressofTransportCompany;
	}
	public void setNameAndAddressofTransportCompany(String nameAndAddressofTransportCompany) {
		this.nameAndAddressofTransportCompany = nameAndAddressofTransportCompany;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getDateRegistered() {
		return dateRegistered;
	}
	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}
	public Long getVehicleMakeModel() {
		return vehicleMakeModel;
	}
	public void setVehicleMakeModel(Long vehicleMakeModel) {
		this.vehicleMakeModel = vehicleMakeModel;
	}
	public String getVehicleMakeModelLabel() {
		return vehicleMakeModelLabel;
	}
	public void setVehicleMakeModelLabel(String vehicleMakeModelLabel) {
		this.vehicleMakeModelLabel = vehicleMakeModelLabel;
	}
	public Long getVehicleConfiguration() {
		return vehicleConfiguration;
	}
	public void setVehicleConfiguration(Long vehicleConfiguration) {
		this.vehicleConfiguration = vehicleConfiguration;
	}
	public String getVehicleConfigurationLabel() {
		return vehicleConfigurationLabel;
	}
	public void setVehicleConfigurationLabel(String vehicleConfigurationLabel) {
		this.vehicleConfigurationLabel = vehicleConfigurationLabel;
	}
	public Long getOdometerReading() {
		return odometerReading;
	}
	public void setOdometerReading(Long odometerReading) {
		this.odometerReading = odometerReading;
	}
	public String getRecommendedAirPressure() {
		return recommendedAirPressure;
	}
	public void setRecommendedAirPressure(String recommendedAirPressure) {
		this.recommendedAirPressure = recommendedAirPressure;
	}
	public int getOldVehicleInspectionStatus() {
		return oldVehicleInspectionStatus;
	}
	public void setOldVehicleInspectionStatus(int oldVehicleInspectionStatus) {
		this.oldVehicleInspectionStatus = oldVehicleInspectionStatus;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OldVehicleInspectionRequestDTO [srNo=");
		builder.append(srNo);
		builder.append(", nameAndAddressofTransportCompany=");
		builder.append(nameAndAddressofTransportCompany);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", dateRegistered=");
		builder.append(dateRegistered);
		builder.append(", vehicleMakeModel=");
		builder.append(vehicleMakeModel);
		builder.append(", vehicleMakeModelLabel=");
		builder.append(vehicleMakeModelLabel);
		builder.append(", vehicleConfiguration=");
		builder.append(vehicleConfiguration);
		builder.append(", vehicleConfigurationLabel=");
		builder.append(vehicleConfigurationLabel);
		builder.append(", odometerReading=");
		builder.append(odometerReading);
		builder.append(", recommendedAirPressure=");
		builder.append(recommendedAirPressure);
		builder.append(", oldVehicleInspectionStatus=");
		builder.append(oldVehicleInspectionStatus);
		builder.append(", registrationNo=");
		builder.append(registrationNo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
