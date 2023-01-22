package com.app.user.dto.request;

public class JwtRequestDTO {
private String userId;
private String password;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public JwtRequestDTO(String userId, String password) {
	super();
	this.userId = userId;
	this.password = password;
}
public JwtRequestDTO() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "JwtRequestDTO [userId=" + userId + ", password=" + password + "]";
}


}
