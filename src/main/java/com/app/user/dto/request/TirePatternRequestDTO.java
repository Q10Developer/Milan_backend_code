package com.app.user.dto.request;

public class TirePatternRequestDTO {

	private Long tirePatternId;
	private String tirePattern;
	private Long tireMakeId;
	private int activeStatus;

	public Long getTirePatternId() {
		return tirePatternId;
	}

	public void setTirePatternId(Long tirePatternId) {
		this.tirePatternId = tirePatternId;
	}

	public String getTirePattern() {
		return tirePattern;
	}

	public void setTirePattern(String tirePattern) {
		this.tirePattern = tirePattern;
	}

	public Long getTireMakeId() {
		return tireMakeId;
	}

	public void setTireMakeId(Long tireMakeId) {
		this.tireMakeId = tireMakeId;
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
		builder.append("TirePatternRequestDTO [tirePatternId=");
		builder.append(tirePatternId);
		builder.append(", tirePattern=");
		builder.append(tirePattern);
		builder.append(", tireMakeId=");
		builder.append(tireMakeId);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
