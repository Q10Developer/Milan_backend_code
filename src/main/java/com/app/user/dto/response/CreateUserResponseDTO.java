package com.app.user.dto.response;

public class CreateUserResponseDTO {

	private Long userID;
	private Integer roleType;

	public CreateUserResponseDTO() {

	}

	public CreateUserResponseDTO(Long userID, Integer roleType) {
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

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
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
