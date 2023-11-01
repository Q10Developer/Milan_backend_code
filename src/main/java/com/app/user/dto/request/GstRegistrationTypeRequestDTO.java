package com.app.user.dto.request;

public class GstRegistrationTypeRequestDTO {
	
	private Long  gstRegistrationId;
	private int  gstRegistrationType;
	private int  gstRegistrationStatus;
	
	
	public Long getGstRegistrationId() {
		return gstRegistrationId;
	}
	public void setGstRegistrationId(Long gstRegistrationId) {
		this.gstRegistrationId = gstRegistrationId;
	}
	public int getGstRegistrationType() {
		return gstRegistrationType;
	}
	public void setGstRegistrationType(int gstRegistrationType) {
		this.gstRegistrationType = gstRegistrationType;
	}
	public int getGstRegistrationStatus() {
		return gstRegistrationStatus;
	}
	public void setGstRegistrationStatus(int gstRegistrationStatus) {
		this.gstRegistrationStatus = gstRegistrationStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GstRegistrationTypeRequestDTO [gstRegistrationId=");
		builder.append(gstRegistrationId);
		builder.append(", gstRegistrationType=");
		builder.append(gstRegistrationType);
		builder.append(", gstRegistrationStatus=");
		builder.append(gstRegistrationStatus);
		builder.append("]");
		return builder.toString();
	}
	

}
