package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="gst_registration_type")
public class GstRegistrationTypeEntity {
	

	
	@Id
	@GeneratedValue
	@Column(name=" gst_registration_id")
	private Long  gstRegistrationId;
	
	@Column(name="gst_registration_type")
	private int gstRegistrationType;
	
	@Column(name=" gst_registration_status")
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
		builder.append("GstRegistrationTypeEntity [gstRegistrationId=");
		builder.append(gstRegistrationId);
		builder.append(", gstRegistrationType=");
		builder.append(gstRegistrationType);
		builder.append(", gstRegistrationStatus=");
		builder.append(gstRegistrationStatus);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
