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

	@Column(name = "client_mobile_no")
	private Long clientMobileNo;

	@Column(name = "client_website")
	private String clientWebsite;

	@Column(name = "client_phone_no")
	private Long clientPhoneNo;

	@Column(name = "client_gst_number")
	private String clientGstNumber;

	@Column(name = "client_pan_number")
	private String clientPanNumber;

	@Column(name = "client_shipping_address")
	private String clientShippingAddress;

	@Column(name = "client_billing_address")
	private String clientBillingAddress;

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

	public Long getClientMobileNo() {
		return clientMobileNo;
	}

	public void setClientMobileNo(Long clientMobileNo) {
		this.clientMobileNo = clientMobileNo;
	}

	public String getClientWebsite() {
		return clientWebsite;
	}

	public void setClientWebsite(String clientWebsite) {
		this.clientWebsite = clientWebsite;
	}

	public Long getClientPhoneNo() {
		return clientPhoneNo;
	}

	public void setClientPhoneNo(Long clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
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

	public String getClientShippingAddress() {
		return clientShippingAddress;
	}

	public void setClientShippingAddress(String clientShippingAddress) {
		this.clientShippingAddress = clientShippingAddress;
	}

	public String getClientBillingAddress() {
		return clientBillingAddress;
	}

	public void setClientBillingAddress(String clientBillingAddress) {
		this.clientBillingAddress = clientBillingAddress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientMasterEntity [clientId=");
		builder.append(clientId);
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
		builder.append(", clientMobileNo=");
		builder.append(clientMobileNo);
		builder.append(", clientWebsite=");
		builder.append(clientWebsite);
		builder.append(", clientPhoneNo=");
		builder.append(clientPhoneNo);
		builder.append(", clientGstNumber=");
		builder.append(clientGstNumber);
		builder.append(", clientPanNumber=");
		builder.append(clientPanNumber);
		builder.append(", clientShippingAddress=");
		builder.append(clientShippingAddress);
		builder.append(", clientBillingAddress=");
		builder.append(clientBillingAddress);
		builder.append("]");
		return builder.toString();
	}

}
