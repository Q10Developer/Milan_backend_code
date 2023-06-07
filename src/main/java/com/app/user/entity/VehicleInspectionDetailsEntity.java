package com.app.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle_inspection_details")
public class VehicleInspectionDetailsEntity {

	@Id
	@GeneratedValue
	@Column(name = "row_id")
	private Long rowId;

	@Column(name = "inspection_id", nullable = false)
	private String inspectionId;

	@Column(name = "tire_position", nullable = false)
	private String tirePosition;

	@Column(name = "tire_type", nullable = false)
	private Long tireType;

	@Column(name = "tire_type_label", nullable = false)
	private String tireTypeLabel;

	@Column(name = "tire_make", nullable = false)
	private Long tireMake;

	@Column(name = "tire_make_label", nullable = false)
	private String tireMakeLabel;

	@Column(name = "tire_original_fitment_date", nullable = false)
	private Date tireOriginalFitmentDate;

	@Column(name = "tire_serial_no", nullable = false)
	private String tireSerialNo;

	@Column(name = "otd_projected_mileage", nullable = false)
	private Double otdProjectedMileage;

	@Column(name = "least_tire_thickness_allowed", nullable = false)
	private int leastTireThicknessAllowed;

	@Column(name = "odometer_reading_when_fitted", nullable = false)
	private Integer odometerReadingWhenFitted;

	@Column(name = "tire_pattern", nullable = false)
	private String tirePattern;

	@Column(name = "tire_removal_date", nullable = false)
	private Date tireRemovalDate;

	@Column(name = "odometer_reading_when_removed", nullable = false)
	private Integer odometerReadingWhenRemoved;

	@Column(name = "reco_pressure", nullable = false)
	private int recoPressure;

	@Column(name = "obs_pressure", nullable = false)
	private int obsPressure;

	@Column(name = "otd_mm", nullable = false)
	private int otdMm;

	@Column(name = "lst_mm", nullable = false)
	private int lstMm;

	@Column(name = "ct_mm", nullable = false)
	private int ctMm;

	@Column(name = "rst_mm", nullable = false)
	private int rstMm;

	@Column(name = "observation_category", nullable = false)
	private Long observationCategory;

	@Column(name = "observation_category_label", nullable = false)
	private String observationCategoryLabel;

	@Column(name = "observation", nullable = false)
	private Long observation;

	@Column(name = "observation_label", nullable = false)
	private String observationLabel;

	@Column(name = "recommendation", nullable = false)
	private Long recommendation;

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public String getInspectionId() {
		return inspectionId;
	}

	public void setInspectionId(String inspectionId) {
		this.inspectionId = inspectionId;
	}

	public String getTirePosition() {
		return tirePosition;
	}

	public void setTirePosition(String tirePosition) {
		this.tirePosition = tirePosition;
	}

	public Long getTireType() {
		return tireType;
	}

	public void setTireType(Long tireType) {
		this.tireType = tireType;
	}

	public String getTireTypeLabel() {
		return tireTypeLabel;
	}

	public void setTireTypeLabel(String tireTypeLabel) {
		this.tireTypeLabel = tireTypeLabel;
	}

	public Long getTireMake() {
		return tireMake;
	}

	public void setTireMake(Long tireMake) {
		this.tireMake = tireMake;
	}

	public String getTireMakeLabel() {
		return tireMakeLabel;
	}

	public void setTireMakeLabel(String tireMakeLabel) {
		this.tireMakeLabel = tireMakeLabel;
	}

	public Date getTireOriginalFitmentDate() {
		return tireOriginalFitmentDate;
	}

	public void setTireOriginalFitmentDate(Date tireOriginalFitmentDate) {
		this.tireOriginalFitmentDate = tireOriginalFitmentDate;
	}

	public String getTireSerialNo() {
		return tireSerialNo;
	}

	public void setTireSerialNo(String tireSerialNo) {
		this.tireSerialNo = tireSerialNo;
	}

	public Double getOtdProjectedMileage() {
		return otdProjectedMileage;
	}

	public void setOtdProjectedMileage(Double otdProjectedMileage) {
		this.otdProjectedMileage = otdProjectedMileage;
	}

	public int getLeastTireThicknessAllowed() {
		return leastTireThicknessAllowed;
	}

	public void setLeastTireThicknessAllowed(int leastTireThicknessAllowed) {
		this.leastTireThicknessAllowed = leastTireThicknessAllowed;
	}

	public Integer getOdometerReadingWhenFitted() {
		return odometerReadingWhenFitted;
	}

	public void setOdometerReadingWhenFitted(Integer odometerReadingWhenFitted) {
		this.odometerReadingWhenFitted = odometerReadingWhenFitted;
	}

	public String getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(String tirePattern) {
		this.tirePattern = tirePattern;
	}

	public Date getTireRemovalDate() {
		return tireRemovalDate;
	}

	public void setTireRemovalDate(Date tireRemovalDate) {
		this.tireRemovalDate = tireRemovalDate;
	}

	public Integer getOdometerReadingWhenRemoved() {
		return odometerReadingWhenRemoved;
	}

	public void setOdometerReadingWhenRemoved(Integer odometerReadingWhenRemoved) {
		this.odometerReadingWhenRemoved = odometerReadingWhenRemoved;
	}

	public int getRecoPressure() {
		return recoPressure;
	}

	public void setRecoPressure(int recoPressure) {
		this.recoPressure = recoPressure;
	}

	public int getObsPressure() {
		return obsPressure;
	}

	public void setObsPressure(int obsPressure) {
		this.obsPressure = obsPressure;
	}

	public int getOtdMm() {
		return otdMm;
	}

	public void setOtdMm(int otdMm) {
		this.otdMm = otdMm;
	}

	public int getLstMm() {
		return lstMm;
	}

	public void setLstMm(int lstMm) {
		this.lstMm = lstMm;
	}

	public int getCtMm() {
		return ctMm;
	}

	public void setCtMm(int ctMm) {
		this.ctMm = ctMm;
	}

	public int getRstMm() {
		return rstMm;
	}

	public void setRstMm(int rstMm) {
		this.rstMm = rstMm;
	}

	public Long getObservationCategory() {
		return observationCategory;
	}

	public void setObservationCategory(Long observationCategory) {
		this.observationCategory = observationCategory;
	}

	public String getObservationCategoryLabel() {
		return observationCategoryLabel;
	}

	public void setObservationCategoryLabel(String observationCategoryLabel) {
		this.observationCategoryLabel = observationCategoryLabel;
	}

	public Long getObservation() {
		return observation;
	}

	public void setObservation(Long observation) {
		this.observation = observation;
	}

	public String getObservationLabel() {
		return observationLabel;
	}

	public void setObservationLabel(String observationLabel) {
		this.observationLabel = observationLabel;
	}

	public Long getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(Long recommendation) {
		this.recommendation = recommendation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleTyreInspection [rowId=");
		builder.append(rowId);
		builder.append(", inspectionId=");
		builder.append(inspectionId);
		builder.append(", tirePosition=");
		builder.append(tirePosition);
		builder.append(", tireType=");
		builder.append(tireType);
		builder.append(", tireTypeLabel=");
		builder.append(tireTypeLabel);
		builder.append(", tireMake=");
		builder.append(tireMake);
		builder.append(", tireMakeLabel=");
		builder.append(tireMakeLabel);
		builder.append(", tireOriginalFitmentDate=");
		builder.append(tireOriginalFitmentDate);
		builder.append(", tireSerialNo=");
		builder.append(tireSerialNo);
		builder.append(", otdProjectedMileage=");
		builder.append(otdProjectedMileage);
		builder.append(", leastTireThicknessAllowed=");
		builder.append(leastTireThicknessAllowed);
		builder.append(", odometerReadingWhenFitted=");
		builder.append(odometerReadingWhenFitted);
		builder.append(", tirePattern=");
		builder.append(tirePattern);
		builder.append(", tireRemovalDate=");
		builder.append(tireRemovalDate);
		builder.append(", odometerReadingWhenRemoved=");
		builder.append(odometerReadingWhenRemoved);
		builder.append(", recoPressure=");
		builder.append(recoPressure);
		builder.append(", obsPressure=");
		builder.append(obsPressure);
		builder.append(", otdMm=");
		builder.append(otdMm);
		builder.append(", lstMm=");
		builder.append(lstMm);
		builder.append(", ctMm=");
		builder.append(ctMm);
		builder.append(", rstMm=");
		builder.append(rstMm);
		builder.append(", observationCategory=");
		builder.append(observationCategory);
		builder.append(", observationCategoryLabel=");
		builder.append(observationCategoryLabel);
		builder.append(", observation=");
		builder.append(observation);
		builder.append(", observationLabel=");
		builder.append(observationLabel);
		builder.append(", recommendation=");
		builder.append(recommendation);
		builder.append("]");
		return builder.toString();
	}

}
