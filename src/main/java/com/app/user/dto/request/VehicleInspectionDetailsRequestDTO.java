package com.app.user.dto.request;

import java.util.Date;

public class VehicleInspectionDetailsRequestDTO {

	private Long rowId;
	private Long inspectionDetailIndex;
	private String inspectionId;
	private String tirePosition;
	private Long tireType;
	private String tireTypeLabel;
	private Long tireMake;
	private String tireMakeLabel;
	private Date tireOriginalFitmentDate;
	private String tireSerialNo;
	private Integer leastTireThicknessAllowed;
	private Double odometerReadingWhenFitted;
	private String tirePattern;
	private String tireSize;
	private Date tireRemovalDate;
	private Double odometerReadingWhenRemoved;
	private Double recoPressure;
	private Double obsPressure;
	private Double otdMm;
	private Double lstMm;
	private Double ctMm;
	private Double rstMm;
	private Long observationCategory;
	private String observationCategoryLabel;
	private Long observation;
	private String observationLabel;
	private String recommendationLabel;
	private String tireImageUrl;
	private String remark;
	private String pressureAnalysis;
	private String pressureColorCode;
	private String leastTireThicknessAllowedAnalysis;
	private String wearAnalysis;
	private Double currentTireLife;
	private Double rtd;
	private Double mileagePerMm;
	private Double projectedMileage;

	
	
	
	
	
	
	
	
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

	public Integer getLeastTireThicknessAllowed() {
		return 3;
	}

	public void setLeastTireThicknessAllowed(Integer leastTireThicknessAllowed) {
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

	public String getTireSize() {
		return tireSize;
	}

	public void setTireSize(String tireSize) {
		this.tireSize = tireSize;
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

	public Double getMileagePerMm() {
		return mileagePerMm;
	}

	public void setMileagePerMm(Double mileagePerMm) {
		this.mileagePerMm = mileagePerMm;
	}

	public Double getProjectedMileage() {
		return projectedMileage;
	}

	public void setProjectedMileage(Double projectedMileage) {
		this.projectedMileage = projectedMileage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleInspectionDetailsRequestDTO [rowId=");
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
		builder.append(", tireSize=");
		builder.append(tireSize);
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
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", pressureAnalysis=");
		builder.append(pressureAnalysis);
		builder.append(", pressureColorCode=");
		builder.append(pressureColorCode);
		builder.append(", leastTireThicknessAllowedAnalysis=");
		builder.append(leastTireThicknessAllowedAnalysis);
		builder.append(", wearAnalysis=");
		builder.append(wearAnalysis);
		builder.append(", currentTireLife=");
		builder.append(currentTireLife);
		builder.append(", rtd=");
		builder.append(rtd);
		builder.append(", mileagePerMm=");
		builder.append(mileagePerMm);
		builder.append(", projectedMileage=");
		builder.append(projectedMileage);
		builder.append("]");
		return builder.toString();
	}

}
