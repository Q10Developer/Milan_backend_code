package com.app.user.dto.request;

public class ClientMasterRequestDTO {

	private Long clientId;
	private String clientTitle;
	private String clientFirstName;
	private String clientMiddleName;
	private String clientLasterName;
	private String clientCompanyName;
	private String clientEmailId;
	private String clientWebsite;
	private Long clientMobileNo;
	private String clientPhoneNo;
	private Long gstRegistrationType;
	private String clientGstNumber;
	private String clientPanNumber;
	private String clientBillingAddress;
	private String clientBillingState;
	private String clientBillingCity;
	private String clientBillingCountry;
	private String clientBillingPincode;
	private String clientServiceAddress;
	private String clientServiceState;
	private String clientServiceCity;
	private String clientServiceCountry;
	private String clientServicePincode;
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

	public Long getGstRegistrationType() {
		return gstRegistrationType;
	}

	public void setGstRegistrationType(Long gstRegistrationType) {
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

	public String getClientServiceAddress() {
		return clientServiceAddress;
	}

	public void setClientServiceAddress(String clientServiceAddress) {
		this.clientServiceAddress = clientServiceAddress;
	}

	public String getClientServiceState() {
		return clientServiceState;
	}

	public void setClientServiceState(String clientServiceState) {
		this.clientServiceState = clientServiceState;
	}

	public String getClientServiceCity() {
		return clientServiceCity;
	}

	public void setClientServiceCity(String clientServiceCity) {
		this.clientServiceCity = clientServiceCity;
	}

	public String getClientServiceCountry() {
		return clientServiceCountry;
	}

	public void setClientServiceCountry(String clientServiceCountry) {
		this.clientServiceCountry = clientServiceCountry;
	}

	public String getClientServicePincode() {
		return clientServicePincode;
	}

	public void setClientServicePincode(String clientServicePincode) {
		this.clientServicePincode = clientServicePincode;
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
		builder.append("ClientMasterRequestDTO [clientId=");
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
		builder.append(", clientServiceAddress=");
		builder.append(clientServiceAddress);
		builder.append(", clientServiceState=");
		builder.append(clientServiceState);
		builder.append(", clientServiceCity=");
		builder.append(clientServiceCity);
		builder.append(", clientServiceCountry=");
		builder.append(clientServiceCountry);
		builder.append(", clientServicePincode=");
		builder.append(clientServicePincode);
		builder.append(", clientActiveStatus=");
		builder.append(clientActiveStatus);
		builder.append("]");
		return builder.toString();
	}

}
