package com.app.user.dto.request;

public class TireConfigurationRequestDTO {

	private Long tireConfigurationId;
	private Long tireMakeId;
	private String tireType;
	private String tireSize;
	private String tirePattern;
	private float  tireThickness;
	private int activeStatus;
	
	public TireConfigurationRequestDTO() {
	}

	public Long getTireConfigurationId() {
		return tireConfigurationId;
	}

	public void setTireConfigurationId(Long tireConfigurationId) {
		this.tireConfigurationId = tireConfigurationId;
	}

	public Long getTireMakeId() {
		return tireMakeId;
	}

	public void setTireMakeId(Long tireMakeId) {
		this.tireMakeId = tireMakeId;
	}

	public String getTireType() {
		return tireType;
	}

	public void setTireType(String tireType) {
		this.tireType = tireType;
	}

	public String getTireSize() {
		return tireSize;
	}

	public void setTireSize(String tireSize) {
		this.tireSize = tireSize;
	}

	public String getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(String tirePattern) {
		this.tirePattern = tirePattern;
	}

	public float getTireThickness() {
		return tireThickness;
	}

	public void setTireThickness(float tireThickness) {
		this.tireThickness = tireThickness;
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
		builder.append("TireConfigurationRequestDTO [tireConfigurationId=");
		builder.append(tireConfigurationId);
		builder.append(", tireMakeId=");
		builder.append(tireMakeId);
		builder.append(", tireType=");
		builder.append(tireType);
		builder.append(", tireSize=");
		builder.append(tireSize);
		builder.append(", tirePattern=");
		builder.append(tirePattern);
		builder.append(", tireThickness=");
		builder.append(tireThickness);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	}