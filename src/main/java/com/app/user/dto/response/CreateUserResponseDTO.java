package com.app.user.dto.response;

public class CreateUserResponseDTO {

	private Long userID;

	public CreateUserResponseDTO() {

	}

	public CreateUserResponseDTO(Long userID) {
		super();
		this.userID = userID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "CreateUserResponseDTO [userID=" + userID + "]";
	}
}
