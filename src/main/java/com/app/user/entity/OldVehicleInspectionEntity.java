package com.app.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = " old_vehicle_inspection")
public class OldVehicleInspectionEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "sr_No")
	private Long srNo;
	
	@Column(name="name_and_address_of_transport_company")
	private  String  nameAndAddressofTransportCompany;
	
	@Column(name="mobile_no")
	private String  mobileNo;
	
	@Column(name=" date_registered")
	private Date dateRegistered;
	
	
	@Column(name="vehicle_make_model")
	private Long  vehicleMakemodel;
	
	@Column(name="vehicle_make_model_label")
	private String vehicleMakeModelLabel;
	
	@Column(name="vehicle_configuration")
	private Long vehicleConfiguration;
	
	@Column (name="odometer_reading")
	private Long odometerReading;
	
	
	@Column(name="recommended_air_pressure")
	private String recommendedAirPressure;

	
	@Column(name="old_vehicle_inspection_status")
	private int oldVehicleInspectionStatus;

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


	public Long getVehicleMakemodel() {
		return vehicleMakemodel;
	}


	public void setVehicleMakemodel(Long vehicleMakemodel) {
		this.vehicleMakemodel = vehicleMakemodel;
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OldVehicleInspectionEntity [srNo=");
		builder.append(srNo);
		builder.append(", nameAndAddressofTransportCompany=");
		builder.append(nameAndAddressofTransportCompany);
		builder.append(", mobileNo=");
		builder.append(mobileNo);
		builder.append(", dateRegistered=");
		builder.append(dateRegistered);
		builder.append(", vehicleMakemodel=");
		builder.append(vehicleMakemodel);
		builder.append(", vehicleMakeModelLabel=");
		builder.append(vehicleMakeModelLabel);
		builder.append(", vehicleConfiguration=");
		builder.append(vehicleConfiguration);
		builder.append(", odometerReading=");
		builder.append(odometerReading);
		builder.append(", recommendedAirPressure=");
		builder.append(recommendedAirPressure);
		builder.append(", oldVehicleInspectionStatus=");
		builder.append(oldVehicleInspectionStatus);
		builder.append("]");
		return builder.toString();
	}
	
	

}
