package com.app.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client_service_location_master")
public class ClientServiceLocationEntity {

	@Id
	@GeneratedValue
	@Column(name = "client_service_location_id")
	private Long clientServiceLocationId;

	@ManyToOne
	@JoinColumn(name = " client_id")
	private ClientMasterEntity clientId;

	@Column(name = "client_service_address")
	private String clientServiceAddress;

	@Column(name = "client_service_pincode")
	private String clientServicePincode;

	@Column(name = "client_service_city")
	private String clientServiceCity;

	@Column(name = "client_service_state")
	private String clientServiceState;

	@Column(name = "client_service_country")
	private String clientServiceCountry;

	@Column(name = "active_status")
	private int activeStatus;

	public Long getClientServiceLocationId() {
		return clientServiceLocationId;
	}

	public void setClientServiceLocationId(Long clientServiceLocationId) {
		this.clientServiceLocationId = clientServiceLocationId;
	}

	public ClientMasterEntity getClientId() {
		return clientId;
	}

	public void setClientId(ClientMasterEntity clientId) {
		this.clientId = clientId;
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
		builder.append("ClientServiceLocationEntity [clientServiceLocationId=");
		builder.append(clientServiceLocationId);
		builder.append(", clientId=");
		builder.append(clientId);
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
