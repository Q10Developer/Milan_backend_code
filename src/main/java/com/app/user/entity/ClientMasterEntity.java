package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client_master")
public class ClientMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "client_id")
	private Long clientId;

	@Column(name = "client_title", nullable = false)
	private String clientTitle;

	@Column(name = "client_first_name", nullable = false)
	private String clientFirstName;

	@Column(name = "client_middle_name")
	private String clientMiddleName;

	@Column(name = "client_last_name")
	private String clientLasterName;

	@Column(name = "client_company_name", nullable = false)
	private String clientCompanyName;

	@Column(name = "client_email_id")
	private String clientEmailId;

	@Column(name = "client_website")
	private String clientWebsite;

	@Column(name = "client_mobile_no")
	private Long clientMobileNo;

	@Column(name = "client_phone_no")
	private String clientPhoneNo;

	@Column(name = "client_gst_registration_type")
	private int gstRegistrationType;

	@Column(name = "client_gst_number")
	private String clientGstNumber;

	@Column(name = "client_pan_number")
	private String clientPanNumber;

	@Column(name = "client_billing_address")
	private String clientBillingAddress;

	@Column(name = "client_billing_state")
	private String clientBillingState;

	@Column(name = "client_billing_city")
	private String clientBillingCity;

	@Column(name = "client_billing_country")
	private String clientBillingCountry;

	@Column(name = "client_billing_pincode")
	private String clientBillingPincode;

	@Column(name = "client_active_status")
	private int clientActiveStatus;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientTitle() {
		return clientTitle;
	}

	public void setClientTitle(String clientTitle) {
		this.clientTitle = clientTitle;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientMiddleName() {
		return clientMiddleName;
	}

	public void setClientMiddleName(String clientMiddleName) {
		this.clientMiddleName = clientMiddleName;
	}

	public String getClientLasterName() {
		return clientLasterName;
	}

	public void setClientLasterName(String clientLasterName) {
		this.clientLasterName = clientLasterName;
	}

	public String getClientCompanyName() {
		return clientCompanyName;
	}

	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}

	public String getClientEmailId() {
		return clientEmailId;
	}

	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}

	public String getClientWebsite() {
		return clientWebsite;
	}

	public void setClientWebsite(String clientWebsite) {
		this.clientWebsite = clientWebsite;
	}

	public Long getClientMobileNo() {
		return clientMobileNo;
	}

	public void setClientMobileNo(Long clientMobileNo) {
		this.clientMobileNo = clientMobileNo;
	}

	public String getClientPhoneNo() {
		return clientPhoneNo;
	}

	public void setClientPhoneNo(String clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
	}

	public int getGstRegistrationType() {
		return gstRegistrationType;
	}

	public void setGstRegistrationType(int gstRegistrationType) {
		this.gstRegistrationType = gstRegistrationType;
	}

	public String getClientGstNumber() {
		return clientGstNumber;
	}

	public void setClientGstNumber(String clientGstNumber) {
		this.clientGstNumber = clientGstNumber;
	}

	public String getClientPanNumber() {
		return clientPanNumber;
	}

	public void setClientPanNumber(String clientPanNumber) {
		this.clientPanNumber = clientPanNumber;
	}

	public String getClientBillingAddress() {
		return clientBillingAddress;
	}

	public void setClientBillingAddress(String clientBillingAddress) {
		this.clientBillingAddress = clientBillingAddress;
	}

	public String getClientBillingState() {
		return clientBillingState;
	}

	public void setClientBillingState(String clientBillingState) {
		this.clientBillingState = clientBillingState;
	}

	public String getClientBillingCity() {
		return clientBillingCity;
	}

	public void setClientBillingCity(String clientBillingCity) {
		this.clientBillingCity = clientBillingCity;
	}

	public String getClientBillingCountry() {
		return clientBillingCountry;
	}

	public void setClientBillingCountry(String clientBillingCountry) {
		this.clientBillingCountry = clientBillingCountry;
	}

	public String getClientBillingPincode() {
		return clientBillingPincode;
	}

	public void setClientBillingPincode(String clientBillingPincode) {
		this.clientBillingPincode = clientBillingPincode;
	}

	public int getClientActiveStatus() {
		return clientActiveStatus;
	}

	public void setClientActiveStatus(int clientActiveStatus) {
		this.clientActiveStatus = clientActiveStatus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientMasterEntity [clientId=");
		builder.append(clientId);
		builder.append(", clientTitle=");
		builder.append(clientTitle);
		builder.append(", clientFirstName=");
		builder.append(clientFirstName);
		builder.append(", clientMiddleName=");
		builder.append(clientMiddleName);
		builder.append(", clientLasterName=");
		builder.append(clientLasterName);
		builder.append(", clientCompanyName=");
		builder.append(clientCompanyName);
		builder.append(", clientEmailId=");
		builder.append(clientEmailId);
		builder.append(", clientWebsite=");
		builder.append(clientWebsite);
		builder.append(", clientMobileNo=");
		builder.append(clientMobileNo);
		builder.append(", clientPhoneNo=");
		builder.append(clientPhoneNo);
		builder.append(", gstRegistrationType=");
		builder.append(gstRegistrationType);
		builder.append(", clientGstNumber=");
		builder.append(clientGstNumber);
		builder.append(", clientPanNumber=");
		builder.append(clientPanNumber);
		builder.append(", clientBillingAddress=");
		builder.append(clientBillingAddress);
		builder.append(", clientBillingState=");
		builder.append(clientBillingState);
		builder.append(", clientBillingCity=");
		builder.append(clientBillingCity);
		builder.append(", clientBillingCountry=");
		builder.append(clientBillingCountry);
		builder.append(", clientBillingPincode=");
		builder.append(clientBillingPincode);
		builder.append(", clientActiveStatus=");
		builder.append(clientActiveStatus);
		builder.append("]");
		return builder.toString();
	}

}
