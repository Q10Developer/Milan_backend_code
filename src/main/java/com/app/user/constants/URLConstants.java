package com.app.user.constants;

public interface URLConstants {

	/*
	 * Services
	 */
	String REGISTRATION_SERVICE = "/registrationservice";
	String REGISTER_USER = "/registeruser";
	String LOGIN_SERVICE = "/loginservice";
	String LOGIN_USER = "/login";
	String MPIN_LOGIN_USER = "/mpinLogin";
	String CHANGE_PASSWORD = "/changepassword";
	String UPDATE_USER = "/updateuser";
	String GET_ALL_USER_DETAILS = "/getallusers";
	String GET_USER_DETAIL_BY_ID = "/getuserdetail";
	String ENABLE_DISABLE_USER = "/enabledisableuser";
	String FORGOT_PASSWORD = "/forgotpassword";
	String GENERATE_MPIN = "/generatempin";
	String SEND_OTP = "/sendotp";
	String LOGOUT = "/logout";
	String FORGET_PASSWORD = "/fogetPassword";
	String MASTER_SERVICE = "/masterservice";
	String SAVE_CLIENT = "/saveclient";
	String UPDATE_CLIENT = "/updateclient";
	String ENABLE_DISABLE_CLIENT = "/enabledisableclient";
	String GET_ALL_CLIENT = "/getallclientdata";
	String GET_CLIENT_BY_ID = "/getclientdata";
	String GET_MASTER_DATA_LIST = "/masterdatalist";
	String TOKEN_SERVICE = "/tokenservice";
	String TOKEN = "/token";
	Integer ACTIVE = 1;
	Integer IN_ACTIVE = 0;

}