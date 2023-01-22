package com.app.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="login_trail")
public class LoginTrailEntity {
	//@Id
	//@GeneratedValue
	//@Column(name="id")
	private long id;
	//@Column(name="userId")
	private long user_id;
	//@Column(name="lastLoginDateTime")
	private Date lastLoginDateTime;
	//@Column(name="last_logout_date_time")
	private Date lastLogoutDateTime;
	//@Column(name="is_logged_in")
	private boolean isLoggedIn;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}
	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	public Date getLastLogoutDateTime() {
		return lastLogoutDateTime;
	}
	public void setLastLogoutDateTime(Date lastLogoutDateTime) {
		this.lastLogoutDateTime = lastLogoutDateTime;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	@Override
	public String toString() {
		return "LoginTrailEntity [id=" + id + ", user_id=" + user_id + ", lastLoginDateTime=" + lastLoginDateTime
				+ ", lastLogoutDateTime=" + lastLogoutDateTime + ", isLoggedIn=" + isLoggedIn + "]";
	}
}
