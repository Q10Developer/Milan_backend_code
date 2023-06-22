package com.app.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "old_vehicle_inspection_details")
public class OldVehicleInspectionDetailsEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "row_id")
	private Long rowId;


	@Column(name="registration_no")
	private Long  registrationNo;
	
	
	@Column(name="size_and_brand")
	private Long  sizeAndBrand;
	
	@Column(name="pattern")
	private String  pattern;
	
	@Column(name="pressure")
	private int pressure;
	
	@Column(name="tread_depth")
	private int treadDepth;
	
	@Column(name="tire_serial_no")
	private String tireSerialNo;
	
	@Column(name="inspection_id")
	private String  inspectionId;
	
	
	@Column(name="wheel_alignment_date_time")
	private Date wheelAlignmentDateTime;
	
	@Column(name="wheel_alignment_km")
	private Long  wheelAlignmentKm;
	
	
	@Column(name="wheel_alignment_technician_observations")
	private String  wheelAlignmentTechnicianObservations;
	
	@Column(name="driver_name")
	private String  driverName;
	
	@Column(name=" driver_mob_no")
	private  String  driverMobno;
	
	
	@Column(name=" driver_signaturet")
	private String  driverSignaturet;
	
	@Column(name="tyre_rotation_date_time")
	private Date tyreRotationDateTime;
	
	
	@Column(name="tyre_rotation_km")
	private int tyreRotationKm;
	
	@Column(name="technician_recommendations")
	private String  technicianRecommendations;
	

	@Column(name="maintenance_manager_name")
	private String  maintenanceManagerName;
	
	@Column(name=" maintenance_manager_mob_no")
	private String maintenanceManagerMobNo;
	
	
	@Column(name="maintenance_manager_signaturet")
	private String  maintenanceManagersignaturet;
	
	@Column(name="milan_tire_service_and_solution")
	private String  milanTireServiceAndSolution;
	
	@Column(name="milan_tire_service_and_solution_mob_no")
	private String  milanTireServiceAndSolutionMobNo;
	
	@Column(name="milan_tire_service_and_solution_signaturet")
	private String milanTireServiceAndSolutionSignaturet;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Long getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(Long registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Long getSizeAndBrand() {
		return sizeAndBrand;
	}

	public void setSizeAndBrand(Long sizeAndBrand) {
		this.sizeAndBrand = sizeAndBrand;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getTreadDepth() {
		return treadDepth;
	}

	public void setTreadDepth(int treadDepth) {
		this.treadDepth = treadDepth;
	}

	public String getTireSerialNo() {
		return tireSerialNo;
	}

	public void setTireSerialNo(String tireSerialNo) {
		this.tireSerialNo = tireSerialNo;
	}

	public String getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public Date getWheelAlignmentDateTime() {
		return wheelAlignmentDateTime;
	}

	public void setWheelAlignmentDateTime(Date wheelAlignmentDateTime) {
		this.wheelAlignmentDateTime = wheelAlignmentDateTime;
	}

	public Long getWheelAlignmentKm() {
		return wheelAlignmentKm;
	}

	public void setWheelAlignmentKm(Long wheelAlignmentKm) {
		this.wheelAlignmentKm = wheelAlignmentKm;
	}

	public String getWheelAlignmentTechnicianObservations() {
		return wheelAlignmentTechnicianObservations;
	}

	public void setWheelAlignmentTechnicianObservations(String wheelAlignmentTechnicianObservations) {
		this.wheelAlignmentTechnicianObservations = wheelAlignmentTechnicianObservations;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobno() {
		return driverMobno;
	}

	public void setDriverMobno(String driverMobno) {
		this.driverMobno = driverMobno;
	}

	public String getDriverSignaturet() {
		return driverSignaturet;
	}

	public void setDriverSignaturet(String driverSignaturet) {
		this.driverSignaturet = driverSignaturet;
	}

	public Date getTyreRotationDateTime() {
		return tyreRotationDateTime;
	}

	public void setTyreRotationDateTime(Date tyreRotationDateTime) {
		this.tyreRotationDateTime = tyreRotationDateTime;
	}

	public int getTyreRotationKm() {
		return tyreRotationKm;
	}

	public void setTyreRotationKm(int tyreRotationKm) {
		this.tyreRotationKm = tyreRotationKm;
	}

	public String getTechnicianRecommendations() {
		return technicianRecommendations;
	}

	public void setTechnicianRecommendations(String technicianRecommendations) {
		this.technicianRecommendations = technicianRecommendations;
	}

	public String getMaintenanceManagerName() {
		return maintenanceManagerName;
	}

	public void setMaintenanceManagerName(String maintenanceManagerName) {
		this.maintenanceManagerName = maintenanceManagerName;
	}

	public String getMaintenanceManagerMobNo() {
		return maintenanceManagerMobNo;
	}

	public void setMaintenanceManagerMobNo(String maintenanceManagerMobNo) {
		this.maintenanceManagerMobNo = maintenanceManagerMobNo;
	}

	public String getMaintenanceManagersignaturet() {
		return maintenanceManagersignaturet;
	}

	public void setMaintenanceManagersignaturet(String maintenanceManagersignaturet) {
		this.maintenanceManagersignaturet = maintenanceManagersignaturet;
	}

	public String getMilanTireServiceAndSolution() {
		return milanTireServiceAndSolution;
	}

	public void setMilanTireServiceAndSolution(String milanTireServiceAndSolution) {
		this.milanTireServiceAndSolution = milanTireServiceAndSolution;
	}

	public String getMilanTireServiceAndSolutionMobNo() {
		return milanTireServiceAndSolutionMobNo;
	}

	public void setMilanTireServiceAndSolutionMobNo(String milanTireServiceAndSolutionMobNo) {
		this.milanTireServiceAndSolutionMobNo = milanTireServiceAndSolutionMobNo;
	}

	public String getMilanTireServiceAndSolutionSignaturet() {
		return milanTireServiceAndSolutionSignaturet;
	}

	public void setMilanTireServiceAndSolutionSignaturet(String milanTireServiceAndSolutionSignaturet) {
		this.milanTireServiceAndSolutionSignaturet = milanTireServiceAndSolutionSignaturet;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OldVehicleInspectionDetailsEntity [rowId=");
		builder.append(rowId);
		builder.append(", registrationNo=");
		builder.append(registrationNo);
		builder.append(", sizeAndBrand=");
		builder.append(sizeAndBrand);
		builder.append(", pattern=");
		builder.append(pattern);
		builder.append(", pressure=");
		builder.append(pressure);
		builder.append(", treadDepth=");
		builder.append(treadDepth);
		builder.append(", tireSerialNo=");
		builder.append(tireSerialNo);
		builder.append(", inspectionId=");
		builder.append(inspectionId);
		builder.append(", wheelAlignmentDateTime=");
		builder.append(wheelAlignmentDateTime);
		builder.append(", wheelAlignmentKm=");
		builder.append(wheelAlignmentKm);
		builder.append(", wheelAlignmentTechnicianObservations=");
		builder.append(wheelAlignmentTechnicianObservations);
		builder.append(", driverName=");
		builder.append(driverName);
		builder.append(", driverMobno=");
		builder.append(driverMobno);
		builder.append(", driverSignaturet=");
		builder.append(driverSignaturet);
		builder.append(", tyreRotationDateTime=");
		builder.append(tyreRotationDateTime);
		builder.append(", tyreRotationKm=");
		builder.append(tyreRotationKm);
		builder.append(", technicianRecommendations=");
		builder.append(technicianRecommendations);
		builder.append(", maintenanceManagerName=");
		builder.append(maintenanceManagerName);
		builder.append(", maintenanceManagerMobNo=");
		builder.append(maintenanceManagerMobNo);
		builder.append(", maintenanceManagersignaturet=");
		builder.append(maintenanceManagersignaturet);
		builder.append(", milanTireServiceAndSolution=");
		builder.append(milanTireServiceAndSolution);
		builder.append(", milanTireServiceAndSolutionMobNo=");
		builder.append(milanTireServiceAndSolutionMobNo);
		builder.append(", milanTireServiceAndSolutionSignaturet=");
		builder.append(milanTireServiceAndSolutionSignaturet);
		builder.append("]");
		return builder.toString();
	}

	
}
