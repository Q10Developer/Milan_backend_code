package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_master")
public class VehicleMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "vehicle_id")
	private Long vehicleId;

	@Column(name = "vehicle_model", nullable = false)
	private String vehicleModel;

	@Column(name = "vehicle_manufacturer", nullable = false)
	private Long vehicleManufacturer;

	@Column(name = "vehicle_type", nullable = false)
	private Long vehicleType;

	@Column(name = "vehicle_sub_type", nullable = false)
	private Long vehicleSubType;

	@Column(name = "vehicle_usage", nullable = false)
	private Long vehicleUsage;

	@Column(name = "no_of_tires")
	private Long noOfTires;

	@Column(name = "no_of_axle")
	private Long noOfAxle;

	@Column(name = "no_of_batteries")
	private Long noOfBatteries;

	@Column(name = "no_of_stepneys")
	private Long noOfStepneys;

	@Column(name = "active_status")
	private int activeStatus;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleMasterEntity [vehicleId=");
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
		builder.append("]");
		return builder.toString();
	}

}
