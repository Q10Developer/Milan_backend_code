package com.app.user.dto.request;

public class TyreRequestDTO {

	private Long tyreId;
	private Long tyreMake;
	private String tyreMakeLabel;
	private Long tyreType;
	private String tyreTypeLabel;
	private String tyreNumber;
	private Long tyreSize;
	private Long tyrePattern;
	private Double tyreThickness;
	private Double tyreRecommendedPressure;
	private int activeStatus;

	public Long getTyreId() {
		return tyreId;
	}

	public void setTyreId(Long tyreId) {
		this.tyreId = tyreId;
	}

	public Long getTyreMake() {
		return tyreMake;
	}

	public void setTyreMake(Long tyreMake) {
		this.tyreMake = tyreMake;
	}

	public Long getTyreType() {
		return tyreType;
	}

	public void setTyreType(Long tyreType) {
		this.tyreType = tyreType;
	}

	public String getTyreNumber() {
		return tyreNumber;
	}

	public void setTyreNumber(String tyreNumber) {
		this.tyreNumber = tyreNumber;
	}

	public Long getTyreSize() {
		return tyreSize;
	}

	public void setTyreSize(Long tyreSize) {
		this.tyreSize = tyreSize;
	}

	public Long getTyrePattern() {
		return tyrePattern;
	}

	public void setTyrePattern(Long tyrePattern) {
		this.tyrePattern = tyrePattern;
	}

	public Double getTyreThickness() {
		return tyreThickness;
	}

	public void setTyreThickness(Double tyreThickness) {
		this.tyreThickness = tyreThickness;
	}

	public Double getTyreRecommendedPressure() {
		return tyreRecommendedPressure;
	}

	public void setTyreRecommendedPressure(Double tyreRecommendedPressure) {
		this.tyreRecommendedPressure = tyreRecommendedPressure;
	}

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getTyreMakeLabel() {
		return tyreMakeLabel;
	}

	public void setTyreMakeLabel(String tyreMakeLabel) {
		this.tyreMakeLabel = tyreMakeLabel;
	}

	public String getTyreTypeLabel() {
		return tyreTypeLabel;
	}

	public void setTyreTypeLabel(String tyreTypeLabel) {
		this.tyreTypeLabel = tyreTypeLabel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TyreRequestDTO [tyreId=");
		builder.append(tyreId);
		builder.append(", tyreMake=");
		builder.append(tyreMake);
		builder.append(", tyreMakeLabel=");
		builder.append(tyreMakeLabel);
		builder.append(", tyreNumber=");
		builder.append(tyreNumber);
		builder.append(", tyreSize=");
		builder.append(tyreSize);
		builder.append(", tyrePattern=");
		builder.append(tyrePattern);
		builder.append(", tyreThickness=");
		builder.append(tyreThickness);
		builder.append(", tyreRecommendedPressure=");
		builder.append(tyreRecommendedPressure);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append(", tyreTypeLabel=");
		builder.append(tyreTypeLabel);
		builder.append("]");
		return builder.toString();
	}

}
