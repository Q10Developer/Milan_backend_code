package com.app.user.dto.response;

public class CreateUserResponseDTO {

	private Long userID;
	private Long roleType;

	public CreateUserResponseDTO() {

	}

	public CreateUserResponseDTO(Long userID, Long roleType) {
		super();
		this.userID = userID;
		this.roleType = roleType;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getRoleType() {
		return roleType;
	}

	public void setRoleType(Long roleType) {
		this.roleType = roleType;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreateUserResponseDTO [userID=");
		builder.append(userID);
		builder.append(", roleType=");
		builder.append(roleType);
		builder.append("]");
		return builder.toString();
	}
}
