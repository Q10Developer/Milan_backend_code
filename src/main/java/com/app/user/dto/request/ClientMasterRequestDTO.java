package com.app.user.dto.request;

public class ClientMasterRequestDTO {

	private Long clientId;

	private String clientFirstName;

	private String clientMiddleName;

	private String clientLasterName;

	private String clientCompanyName;

	private String clientEmailId;

	private Long clientMobileNo;

	private String clientWebsite;

	private Long clientPhoneNo;

	private String clientGstNumber;

	private String clientPanNumber;

	private String clientShippingAddress;

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
		builder.append("ClientMasterRequestDTO [clientId=");
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
