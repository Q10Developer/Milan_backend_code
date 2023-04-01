package com.app.user.constants;

public interface ResponseKeysValue {

	String SUCCESS_STATUS_CODE_200 = "200";
	String SUCCESS_STATUS_DESCRIPTION_200 = "SUCCESS";
	String SUCCESS_STATUS_CODE_201 = "201";
	String SUCCESS_STATUS_DESCRIPTION_201 = "CREATED SUCCEFULLY";
	String FAILURE_STATUS_CODE_500 = "500";
	String FAILURE_STATUS_DESCRIPTION_500 = "FAILURE";
	String FAILURE_STATUS_CODE_400 = "400";
	String FAILURE_STATUS_DESCRIPTION_400 = "Bad Request";
	String FAILURE_STATUS_CODE_401 = "401";
	String FAILURE_STATUS_DESCRIPTION_401 = "AUTHENTICATION FAIL";
	String FAILURE_LOGIN_DESCRIPTION_401 = "WRONG LOGIN CREDENTIAL";
	String FAILURE_OTP_DESCRIPTION = "OTP SENDING PROCESS FAIL";
	String SUCCESS_OTP_DESCRIPTION = "OTP SENT SUCCESSFULLY";
	String FAILURE_PASS_CPASS_DESCRIPTION = "PASSWORD AND CONFIRM PASSWORD ARE NOT SAME";
	String FAILURE_MPIN_CMPIN_DESCRIPTION = "MPIN AND CONFIRM MPIN ARE NOT SAME";
	String NO_RECORDS_FOUND = "No Data Found";

	/* WARNING */
	String WARNING_MULTIPLE_DEVICE_LOGIN_DESCRIPTION_401 = "DO YOU WANT TO LOGOUT FROM OTHER DEVICE?";
	String WARNING_MULTIPLE_DEVICE_LOGIN_STATUS_401 = "100";
	String WARNING_MPIN_GENERATION_DESCRIPTION = "NEED TO GENERATE MPIN";
	String WARNING_MPIN_GENERATION_STATUS = "100";

	String SUCCESS_LOGOUT_STATUS_STATUS_201 = "201";
	String SUCCESS_LOGOUT_STATUS_DESCRIPTION_201 = "LOGOUT SUCCEFULLY";

	String SUCCESS_LOGIN_STATUS_STATUS_200 = "200";
	String SUCCESS_LOGIN_STATUS_DESCRIPTION_200 = "LOGIN SUCCEFULLY";

	String SUCCESS_FORGET_PASSWORD_STATUS_CODE_200 = "200";
	String SUCCESS_FORGET_PASSWORD_STATUS_DESCRIPTION_200 = "FORGET PASSWORD PROCCESS SUCCESS";

	String FAILURE_DATA_NOT_FOUNT_DESCRIPTION_500 = "DATA NOT FOUND";

	String WARNING_USER_ALREADY_EXIST_CODE = "100";
	String WARNING_USER_ALREADY_EXIST_DESC = "User Already Exist";

	String WARNING_USER_EMAIL_NOT_EXIST_CODE = "104";
	String WARNING_USER_EMAIL_NOT_EXIST_DESC = "User Email Does Not Exist";

	String WARNING_USER_DOSENT_EXIST_CODE = "100";
	String WARNING_USER_DOSENT_EXIST_DESC = "User doesn't Exist";

	String WARNING_WRONG_OLD_PASSWORD_CODE = "104";
	String WARNING_WRONG_OLD_PASSWORD_DESC = "Wrong Old Password";

	String SUCCESS_CHANGE_PASSWORD_STATUS_CODE_200 = "200";
	String SUCCESS_CHANGE_PASSWORD_STATUS_DESCRIPTION_200 = "CHANGE PASSWORD PROCCESS SUCCESS";

	String WARNING_CLIENT_ALREADY_EXIST_CODE = "100";
	String WARNING_CLIENT_ALREADY_EXIST_DESC = "Client Already Exist";

	String WARNING_CLIENT_DOESNT_EXIST_CODE = "100";
	String WARNING_CLIENT_DOESNT_EXIST_DESC = "Client doesn't Exist";

	String WARNING_VEHICLE_DOESNT_EXIST_CODE = "100";
	String WARNING_VEHICLE_DOESNT_EXIST_DESC = "Vehicle doesn't Exist";
	
	String WARNING_TYRE_DOESNT_EXIST_CODE = "100";
	String WARNING_TYRE_DOESNT_EXIST_DESC = "Tyre doesn't Exist";

	String WARNING_VEHICLE_ALREADY_EXIST_CODE = "100";
	String WARNING_VEHICLE_ALREADY_EXIST_DESC = "Vehicle Already Exist";

	String WARNING_TYRE_ALREADY_EXIST_CODE = "100";
	String WARNING_TYRE_ALREADY_EXIST_DESC = "Tyre Already Exist";

	String WARNING_DROP_DOWN_ALREADY_EXIST_CODE = "100";
	String WARNING_DROP_DOWN_ALREADY_EXIST_DESC = "Drop down Already Exist";

	String WARNING_DROP_DOWN_DOESNT_EXIST_CODE = "100";
	String WARNING_DROP_DOWN_DOESNT_EXIST_DESC = "Drop down doesn't Exist";

	String WARNING_MASTER_DATA_LIST_ALREADY_EXIST_CODE = "100";
	String WARNING_MASTER_DATA_LIST_ALREADY_EXIST_DESC = "Master data Already Exist";

	String WARNING_MASTER_DATA_LIST_DOESNT_EXIST_CODE = "100";
	String WARNING_MASTER_DATA_LIST_DOESNT_EXIST_DESC = "Master data doesn't Exist";

	String DUPLICATE_DROP_DOWN_COMBINATION_CODE = "500";
	String DUPLICATE_DROP_DOWN_COMBINATION_DESC = "Drop Down already exist";

	String VALID_DROP_DOWN_DATA_CODE = "200";
	String VALID_DROP_DOWN_DATA_DESC = "Drop Down Data Key Available";

	String VALID_MASTER_DATA_LIST_CODE = "200";
	String VALID_MASTER_DATA_LIST_DESC = "Master Data List Key Available";

	String DUPLICATE_MASTER_DATA_LIST_COMBINATION_CODE = "500";
	String DUPLICATE_MASTER_DATA_LIST_COMBINATION_DESC = "Master Data List already exist";

	// String SUCCESS_STATUS_DESCRIPTION_USER_UPDATE="User details Updated
	// Successfully";
	// String SUCCESS_STATUS_DESCRIPTION_USER_CREATE="User Registration Success";

}
