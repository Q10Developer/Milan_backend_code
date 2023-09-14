package com.app.user.dto.request;

public class JwtTokenResponseDTO {
	private String token;

	public JwtTokenResponseDTO(String token) {
		super();
		this.token = token;
	}

	public JwtTokenResponseDTO() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtTokenResponseDTO [token=" + token + "]";
	}

}
