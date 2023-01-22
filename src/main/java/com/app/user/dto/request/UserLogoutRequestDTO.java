package com.app.user.dto.request;

public class UserLogoutRequestDTO {
  private Long userId;

public Long getUserId() {
	return userId;
}

public void setUserId(Long userId) {
	this.userId = userId;
}

@Override
public String toString() {
	return "UserLogoutRequestDTO [userId=" + userId + "]";
}
  

}
