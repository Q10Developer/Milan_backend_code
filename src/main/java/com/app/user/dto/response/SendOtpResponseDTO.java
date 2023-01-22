package com.app.user.dto.response;

public class SendOtpResponseDTO {
	
	public SendOtpResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SendOtpResponseDTO(String otp) {
		super();
		this.otp = otp;
	}
	private String otp;

	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "SendOtpResponseDTO [otp=" + otp + "]";
	}
}
