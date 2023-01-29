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
	String UPDATE_USER = "/updateuser/{id}";
	String GET_ALL_USER_DETAILS = "/getallusers";
	String GET_USER_DETAIL_BY_ID = "/getuserdetail";
	String ENABLE_DISABLE_USER = "/enabledisableuser/{id}";
	String FORGOT_PASSWORD = "/forgotpassword";
	String GENERATE_MPIN = "/generatempin";
	String SEND_OTP = "/sendotp";
	String LOGOUT = "/logout";
	String FORGET_PASSWORD = "/fogetPassword";
	String MASTER_SERVICE = "/masterservice";
	String SAVE_CLIENT = "/saveclient";
	String UPDATE_CLIENT = "/updateclient/{id}";
	String DELETE_CLIENT = "/deleclient";
	String GET_CLIENT = "/getallclientdata";
	String GET_CLIENT_BY_ID = "/getclientdata/{id}";
	String GET_MASTER_DATA_LIST = "/masterdatalist";

}