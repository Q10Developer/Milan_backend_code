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

	@Column(name = "inspection_detail_index", nullable = false)
	private Long inspectionDetailIndex;

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

	@Column(name = "tire_original_fitment_date", nullable = true)
	private Date tireOriginalFitmentDate;

	@Column(name = "tire_serial_no", nullable = true)
	private String tireSerialNo;

	@Column(name = "least_tire_thickness_allowed", nullable = false, columnDefinition = "int default 3")
	private int leastTireThicknessAllowed;

	@Column(name = "odometer_reading_when_fitted", nullable = true)
	private Double odometerReadingWhenFitted;

	@Column(name = "tire_pattern", nullable = false)
	private String tirePattern;

	@Column(name = "tire_removal_date", nullable = true)
	private Date tireRemovalDate;

	@Column(name = "odometer_reading_when_removed", nullable = true)
	private Double odometerReadingWhenRemoved;

	@Column(name = "reco_pressure", nullable = false)
	private Double recoPressure;

	@Column(name = "obs_pressure", nullable = false)
	private Double obsPressure;

	@Column(name = "otd_mm", nullable = false)
	private Double otdMm;

	@Column(name = "lst_mm", nullable = false)
	private Double lstMm;

	@Column(name = "ct_mm", nullable = false)
	private Double ctMm;

	@Column(name = "rst_mm", nullable = false)
	private Double rstMm;

	@Column(name = "observation_category", nullable = false)
	private Long observationCategory;

	@Column(name = "observation_category_label", nullable = false)
	private String observationCategoryLabel;

	@Column(name = "observation", nullable = false)
	private Long observation;

	@Column(name = "observation_label", nullable = false)
	private String observationLabel;

	@Column(name = "recommendation_label", nullable = false)
	private String recommendationLabel;

	@Column(name = "tire_image_url")
	private String tireImageUrl;

	@Column(name = "tire_size")
	private String tireSize;

	@Column(name = "pressure_analysis", nullable = true)
	private String pressureAnalysis;

	@Column(name = "pressure_color_code", nullable = true)
	private String pressureColorCode;

	@Column(name = "least_tire_thickness_allowed_analysis", nullable = true)
	private String leastTireThicknessAllowedAnalysis;

	@Column(name = "wear_analysis", nullable = true)
	private String wearAnalysis;

	@Column(name = "rtd", nullable = true)
	private Double rtd;
	
	@Column(name="remark", nullable=true)
	private String remark;
	
	
	@Column(name="current_tire_life" , nullable=true)
	private Double currentTireLife;

	@Column(name = "projected_mileage", nullable = true)
	private Double projectedMileage;

	@Column(name = "mileage_per_mm", nullable = true)
	private Double mileagePerMm;

	
	
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getCurrentTireLife() {
		return currentTireLife;
	}

	public void setCurrentTireLife(Double currentTireLife) {
		this.currentTireLife = currentTireLife;
	}

	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	public Long getInspectionDetailIndex() {
		return inspectionDetailIndex;
	}

	public void setInspectionDetailIndex(Long inspectionDetailIndex) {
		this.inspectionDetailIndex = inspectionDetailIndex;
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

	public int getLeastTireThicknessAllowed() {
		return leastTireThicknessAllowed;
	}

	public void setLeastTireThicknessAllowed(int leastTireThicknessAllowed) {
		this.leastTireThicknessAllowed = leastTireThicknessAllowed;
	}

	public Double getOdometerReadingWhenFitted() {
		return odometerReadingWhenFitted;
	}

	public void setOdometerReadingWhenFitted(Double odometerReadingWhenFitted) {
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

	public Double getOdometerReadingWhenRemoved() {
		return odometerReadingWhenRemoved;
	}

	public void setOdometerReadingWhenRemoved(Double odometerReadingWhenRemoved) {
		this.odometerReadingWhenRemoved = odometerReadingWhenRemoved;
	}

	public Double getRecoPressure() {
		return recoPressure;
	}

	public void setRecoPressure(Double recoPressure) {
		this.recoPressure = recoPressure;
	}

	public Double getObsPressure() {
		return obsPressure;
	}

	public void setObsPressure(Double obsPressure) {
		this.obsPressure = obsPressure;
	}

	public Double getOtdMm() {
		return otdMm;
	}

	public void setOtdMm(Double otdMm) {
		this.otdMm = otdMm;
	}

	public Double getLstMm() {
		return lstMm;
	}

	public void setLstMm(Double lstMm) {
		this.lstMm = lstMm;
	}

	public Double getCtMm() {
		return ctMm;
	}

	public void setCtMm(Double ctMm) {
		this.ctMm = ctMm;
	}

	public Double getRstMm() {
		return rstMm;
	}

	public void setRstMm(Double rstMm) {
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

	public String getRecommendationLabel() {
		return recommendationLabel;
	}

	public void setRecommendationLabel(String recommendationLabel) {
		this.recommendationLabel = recommendationLabel;
	}

	public String getTireImageUrl() {
		return tireImageUrl;
	}

	public void setTireImageUrl(String tireImageUrl) {
		this.tireImageUrl = tireImageUrl;
	}

	public String getTireSize() {
		return tireSize;
	}

	public void setTireSize(String tireSize) {
		this.tireSize = tireSize;
	}

	public String getPressureAnalysis() {
		return pressureAnalysis;
	}

	public void setPressureAnalysis(String pressureAnalysis) {
		this.pressureAnalysis = pressureAnalysis;
	}

	public String getPressureColorCode() {
		return pressureColorCode;
	}

	public void setPressureColorCode(String pressureColorCode) {
		this.pressureColorCode = pressureColorCode;
	}

	public String getLeastTireThicknessAllowedAnalysis() {
		return leastTireThicknessAllowedAnalysis;
	}

	public void setLeastTireThicknessAllowedAnalysis(String leastTireThicknessAllowedAnalysis) {
		this.leastTireThicknessAllowedAnalysis = leastTireThicknessAllowedAnalysis;
	}

	public String getWearAnalysis() {
		return wearAnalysis;
	}

	public void setWearAnalysis(String wearAnalysis) {
		this.wearAnalysis = wearAnalysis;
	}

	public Double getRtd() {
		return rtd;
	}

	public void setRtd(Double rtd) {
		this.rtd = rtd;
	}

	public Double getProjectedMileage() {
		return projectedMileage;
	}

	public void setProjectedMileage(Double projectedMileage) {
		this.projectedMileage = projectedMileage;
	}

	public Double getMileagePerMm() {
		return mileagePerMm;
	}

	public void setMileagePerMm(Double mileagePerMm) {
		this.mileagePerMm = mileagePerMm;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleInspectionDetailsEntity [rowId=");
		builder.append(rowId);
		builder.append(", inspectionDetailIndex=");
		builder.append(inspectionDetailIndex);
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
		builder.append(", recommendationLabel=");
		builder.append(recommendationLabel);
		builder.append(", tireImageUrl=");
		builder.append(tireImageUrl);
		builder.append(", tireSize=");
		builder.append(tireSize);
		builder.append(", pressureAnalysis=");
		builder.append(pressureAnalysis);
		builder.append(", pressureColorCode=");
		builder.append(pressureColorCode);
		builder.append(", leastTireThicknessAllowedAnalysis=");
		builder.append(leastTireThicknessAllowedAnalysis);
		builder.append(", wearAnalysis=");
		builder.append(wearAnalysis);
		builder.append(", rtd=");
		builder.append(rtd);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", currentTireLife=");
		builder.append(currentTireLife);
		builder.append(", projectedMileage=");
		builder.append(projectedMileage);
		builder.append(", mileagePerMm=");
		builder.append(mileagePerMm);
		builder.append("]");
		return builder.toString();
	}
}
