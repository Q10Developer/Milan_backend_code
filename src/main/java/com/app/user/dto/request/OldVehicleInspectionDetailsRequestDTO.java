package com.app.user.dto.request;

import java.util.Date;

public class OldVehicleInspectionDetailsRequestDTO {
	
	private Long rowId;
	private Long registrationNo;
	private Long sizeAndBrand;
    private String  pattern;
    private int  pressure;
    private int  treadDepth;
    private String  tireSerialNo;
    private String  inspectionId;
    private Date  wheelAlignmentDateTime;
    private  Long  wheelAlignmentKm;
    private  String  wheelAlignmentTechnicianObservations;
    private  String   driverName;
    private int  driverMobNo;
    private  String driverSignaturet;
    private Date  tyreRotationDateTime;
    private Long  tyreRotationkm;
    private String  technicianRecommendations;
    private  String  maintenanceManagerName;
    private int  maintenanceManagerMobNo;
    private  String  maintenanceManagerSignaturet;
    private   String  milanTireServiceAnddSolution;
    private  int   milanTireServiceAndSolutionMobnNo;
    private  String  milanTireServiceAndSolutionSignaturet;
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
	public int getDriverMobNo() {
		return driverMobNo;
	}
	public void setDriverMobNo(int driverMobNo) {
		this.driverMobNo = driverMobNo;
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
	public Long getTyreRotationkm() {
		return tyreRotationkm;
	}
	public void setTyreRotationkm(Long tyreRotationkm) {
		this.tyreRotationkm = tyreRotationkm;
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
	public int getMaintenanceManagerMobNo() {
		return maintenanceManagerMobNo;
	}
	public void setMaintenanceManagerMobNo(int maintenanceManagerMobNo) {
		this.maintenanceManagerMobNo = maintenanceManagerMobNo;
	}
	public String getMaintenanceManagerSignaturet() {
		return maintenanceManagerSignaturet;
	}
	public void setMaintenanceManagerSignaturet(String maintenanceManagerSignaturet) {
		this.maintenanceManagerSignaturet = maintenanceManagerSignaturet;
	}
	public String getMilanTireServiceAnddSolution() {
		return milanTireServiceAnddSolution;
	}
	public void setMilanTireServiceAnddSolution(String milanTireServiceAnddSolution) {
		this.milanTireServiceAnddSolution = milanTireServiceAnddSolution;
	}
	public int getMilanTireServiceAndSolutionMobnNo() {
		return milanTireServiceAndSolutionMobnNo;
	}
	public void setMilanTireServiceAndSolutionMobnNo(int milanTireServiceAndSolutionMobnNo) {
		this.milanTireServiceAndSolutionMobnNo = milanTireServiceAndSolutionMobnNo;
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
		builder.append("OldVehicleInspectionDetailsRequestDTO [rowId=");
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
		builder.append(", driverMobNo=");
		builder.append(driverMobNo);
		builder.append(", driverSignaturet=");
		builder.append(driverSignaturet);
		builder.append(", tyreRotationDateTime=");
		builder.append(tyreRotationDateTime);
		builder.append(", tyreRotationkm=");
		builder.append(tyreRotationkm);
		builder.append(", technicianRecommendations=");
		builder.append(technicianRecommendations);
		builder.append(", maintenanceManagerName=");
		builder.append(maintenanceManagerName);
		builder.append(", maintenanceManagerMobNo=");
		builder.append(maintenanceManagerMobNo);
		builder.append(", maintenanceManagerSignaturet=");
		builder.append(maintenanceManagerSignaturet);
		builder.append(", milanTireServiceAnddSolution=");
		builder.append(milanTireServiceAnddSolution);
		builder.append(", milanTireServiceAndSolutionMobnNo=");
		builder.append(milanTireServiceAndSolutionMobnNo);
		builder.append(", milanTireServiceAndSolutionSignaturet=");
		builder.append(milanTireServiceAndSolutionSignaturet);
		builder.append("]");
		return builder.toString();
	}
    
    
    

}
