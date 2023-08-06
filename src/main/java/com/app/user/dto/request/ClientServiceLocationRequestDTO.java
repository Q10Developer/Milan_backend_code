package com.app.user.dto.request;

public class ClientServiceLocationRequestDTO {

	private Long clientServiceLocationId;
	private String clientServiceAddress;
	private String clientServicePincode;
	private String clientServiceCity;
	private String clientServiceState;
	private String clientServiceCountry;
	private int activeStatus;

	public Long getClientServiceLocationId() {
		return clientServiceLocationId;
	}

	public void setClientServiceLocationId(Long clientServiceLocationId) {
		this.clientServiceLocationId = clientServiceLocationId;
	}

	public String getClientServiceAddress() {
		return clientServiceAddress;
	}

	public void setClientServiceAddress(String clientServiceAddress) {
		this.clientServiceAddress = clientServiceAddress;
	}

	public String getClientServicePincode() {
		return clientServicePincode;
	}

	public void setClientServicePincode(String clientServicePincode) {
		this.clientServicePincode = clientServicePincode;
	}

	public String getClientServiceCity() {
		return clientServiceCity;
	}

	public void setClientServiceCity(String clientServiceCity) {
		this.clientServiceCity = clientServiceCity;
	}

	public String getClientServiceState() {
		return clientServiceState;
	}

	public void setClientServiceState(String clientServiceState) {
		this.clientServiceState = clientServiceState;
	}

	public String getClientServiceCountry() {
		return clientServiceCountry;
	}

	public void setClientServiceCountry(String clientServiceCountry) {
		this.clientServiceCountry = clientServiceCountry;
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
		builder.append("ClientServiceLocationRequestDTO [clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientServiceAddress=");
		builder.append(clientServiceAddress);
		builder.append(", clientServicePincode=");
		builder.append(clientServicePincode);
		builder.append(", clientServiceCity=");
		builder.append(clientServiceCity);
		builder.append(", clientServiceState=");
		builder.append(clientServiceState);
		builder.append(", clientServiceCountry=");
		builder.append(clientServiceCountry);
		builder.append(", activeStatus=");
		builder.append(activeStatus);
		builder.append("]");
		return builder.toString();
	}

}
