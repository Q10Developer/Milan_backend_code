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
	private Double otdProjectedMileage;
	private Integer leastTireThicknessAllowed;
	private Integer odometerReadingWhenFitted;
	private String tirePattern;
	private String tireSize;
	private Date tireRemovalDate;
	private Integer odometerReadingWhenRemoved;
	private Integer recoPressure;
	private Integer obsPressure;
	private Integer otdMm;
	private Integer lstMm;
	private Integer ctMm;
	private Integer rstMm;
	private Long observationCategory;
	private String observationCategoryLabel;
	private Long observation;
	private String observationLabel;
	private String recommendationLabel;
	private String tireImageUrl;
	private String pressureAnalysis;
	private String leastTireThicknessAllowedAnalysis;
	private String wearAnalysis;
	private Integer rtd;
	private Double mileagePerMm;
	private Double projectedMileage;

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
		if (leastTireThicknessAllowed == 0) {
			this.leastTireThicknessAllowed = 3;
		} else {
			this.leastTireThicknessAllowed = leastTireThicknessAllowed;
		}
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

	public Integer getOdometerReadingWhenRemoved() {
		return odometerReadingWhenRemoved;
	}

	public void setOdometerReadingWhenRemoved(Integer odometerReadingWhenRemoved) {
		this.odometerReadingWhenRemoved = odometerReadingWhenRemoved;
	}

	public Integer getRecoPressure() {
		return recoPressure;
	}

	public void setRecoPressure(Integer recoPressure) {
		this.recoPressure = recoPressure;
	}

	public Integer getObsPressure() {
		return obsPressure;
	}

	public void setObsPressure(Integer obsPressure) {
		this.obsPressure = obsPressure;
	}

	public Integer getOtdMm() {
		return otdMm;
	}

	public void setOtdMm(Integer otdMm) {
		this.otdMm = otdMm;
	}

	public Integer getLstMm() {
		return lstMm;
	}

	public void setLstMm(Integer lstMm) {
		this.lstMm = lstMm;
	}

	public Integer getCtMm() {
		return ctMm;
	}

	public void setCtMm(Integer ctMm) {
		this.ctMm = ctMm;
	}

	public Integer getRstMm() {
		return rstMm;
	}

	public void setRstMm(Integer rstMm) {
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

	public Integer getRtd() {
		return rtd;
	}

	public void setRtd(Integer rtd) {
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
		builder.append(", otdProjectedMileage=");
		builder.append(otdProjectedMileage);
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
		builder.append(", pressureAnalysis=");
		builder.append(pressureAnalysis);
		builder.append(", leastTireThicknessAllowedAnalysis=");
		builder.append(leastTireThicknessAllowedAnalysis);
		builder.append(", wearAnalysis=");
		builder.append(wearAnalysis);
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
