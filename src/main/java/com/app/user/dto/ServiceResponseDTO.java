package com.app.user.dto;

import java.io.Serializable;

public class ServiceResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String statusDescription;
	private Object result;
	
	
	public ServiceResponseDTO() {
	
	}
	public ServiceResponseDTO(String statusCode, String statusDescription, Object result) {
		super();
		this.statusCode = statusCode;
		this.statusDescription = statusDescription;
		this.result = result;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "ServiceResponseDTO [statusCode=" + statusCode + ", statusDescription=" + statusDescription + ", result="
				+ result + "]";
	}
	
	

}
