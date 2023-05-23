package com.app.user.dto.request;

public class TireConfigurationRequestDTO {

	private Long tireConfigurationId;
	private Long tireMakeId;
	private String tireType;
	private int tireSize;
	private int tirePattern;
	private float  tireThickness;
	private int activeStatus;
	
	public TireConfigurationRequestDTO() {
		// TODO Auto-generated constructor stub
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

	public int getTireSize() {
		return tireSize;
	}

	public void setTireSize(int tireSize) {
		this.tireSize = tireSize;
	}

	public int getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(int tirePattern) {
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
		return "TireConfigurationRequestDTO [tireConfigurationId=" + tireConfigurationId + ", tireMakeId=" + tireMakeId
				+ ", tireType=" + tireType + ", tireSize=" + tireSize + ", tirePattern=" + tirePattern
				+ ", tireThickness=" + tireThickness + ", activeStatus=" + activeStatus + "]";
	}

	
	
	
}
