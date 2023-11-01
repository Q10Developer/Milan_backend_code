package com.app.user.constants;

public class ResponseKeysValue {

	private ResponseKeysValue() {
	}

	public static final String SUCCESS_STATUS_CODE_200 = "200";
	public static final String SUCCESS_STATUS_DESCRIPTION_200 = "SUCCESS";
	public static final String SUCCESS_STATUS_CODE_201 = "201";
	public static final String SUCCESS_STATUS_DESCRIPTION_201 = "CREATED SUCCEFULLY";
	public static final String FAILURE_STATUS_CODE_500 = "500";
	public static final String FAILURE_STATUS_DESCRIPTION_500 = "FAILURE";
	public static final String FAILURE_STATUS_CODE_400 = "400";
	public static final String FAILURE_STATUS_DESCRIPTION_400 = "Bad Request";
	public static final String FAILURE_INCORRECT_INSPECTION_CODE_400 = "400";
	public static final String FAILURE_INCORRECT_INSPECTION_DESCRIPTION_400 = "Inspection doesn't exist";
	public static final String FAILURE_STATUS_CODE_401 = "401";
	public static final String FAILURE_STATUS_DESCRIPTION_401 = "AUTHENTICATION FAIL";
	public static final String USE_ADMIN_CREDENTIAL = "USE ADMIN CREDENTIAL";
	public static final String USE_USER_CREDENTIAL = "USE USER CREDENTIAL";
	public static final String FAILURE_LOGIN_DESCRIPTION_401 = "WRONG LOGIN CREDENTIAL";
	public static final String FAILURE_OTP_DESCRIPTION = "OTP SENDING PROCESS FAIL";
	public static final String SUCCESS_OTP_DESCRIPTION = "OTP SENT SUCCESSFULLY";
	public static final String FAILURE_PASS_CPASS_DESCRIPTION = "PASSWORD AND CONFIRM PASSWORD ARE NOT SAME";
	public static final String FAILURE_MPIN_CMPIN_DESCRIPTION = "MPIN AND CONFIRM MPIN ARE NOT SAME";
	public static final String NO_RECORDS_FOUND = "No Data Found";
	public static final String NO_VEHICLE_REG_NUMBER_FOUND = "no vehicle reg number found";

	/* WARNING */
	public static final String WARNING_MULTIPLE_DEVICE_LOGIN_DESCRIPTION_401 = "DO YOU WANT TO LOGOUT FROM OTHER DEVICE?";
	public static final String WARNING_MULTIPLE_DEVICE_LOGIN_STATUS_401 = "100";
	public static final String WARNING_MPIN_GENERATION_DESCRIPTION = "NEED TO GENERATE MPIN";
	public static final String WARNING_MPIN_GENERATION_STATUS = "100";

	public static final String SUCCESS_LOGOUT_STATUS_STATUS_201 = "201";
	public static final String SUCCESS_LOGOUT_STATUS_DESCRIPTION_201 = "LOGOUT SUCCEFULLY";

	public static final String SUCCESS_LOGIN_STATUS_STATUS_200 = "200";
	public static final String SUCCESS_LOGIN_STATUS_DESCRIPTION_200 = "LOGIN SUCCEFULLY";

	public static final String SUCCESS_FORGET_PASSWORD_STATUS_CODE_200 = "200";
	public static final String SUCCESS_FORGET_PASSWORD_STATUS_DESCRIPTION_200 = "FORGET PASSWORD PROCCESS SUCCESS";

	public static final String FAILURE_DATA_NOT_FOUNT_DESCRIPTION_500 = "DATA NOT FOUND";

	public static final String WARNING_USER_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_USER_ALREADY_EXIST_DESC = "User Already Exist";

	public static final String WARNING_USER_EMAIL_NOT_EXIST_CODE = "104";
	public static final String WARNING_USER_EMAIL_NOT_EXIST_DESC = "User Email Does Not Exist";

	public static final String WARNING_USER_DOSENT_EXIST_CODE = "100";
	public static final String WARNING_USER_DOSENT_EXIST_DESC = "User doesn't Exist";

	public static final String WARNING_WRONG_OLD_PASSWORD_CODE = "104";
	public static final String WARNING_WRONG_OLD_PASSWORD_DESC = "Wrong Old Password";

	public static final String SUCCESS_CHANGE_PASSWORD_STATUS_CODE_200 = "200";
	public static final String SUCCESS_CHANGE_PASSWORD_STATUS_DESCRIPTION_200 = "CHANGE PASSWORD PROCCESS SUCCESS";

	public static final String WARNING_CLIENT_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_CLIENT_ALREADY_EXIST_DESC = "Client Already Exist";

	public static final String WARNING_CLIENT_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_CLIENT_DOESNT_EXIST_DESC = "Client doesn't Exist";

	public static final String WARNING_VEHICLE_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_DOESNT_EXIST_DESC = "Vehicle doesn't Exist";

	public static final String WARNING_TYRE_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_TYRE_DOESNT_EXIST_DESC = "Tyre doesn't Exist";

	public static final String WARNING_VEHICLE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_ALREADY_EXIST_DESC = "Vehicle Already Exist";

	public static final String WARNING_TYRE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_TYRE_ALREADY_EXIST_DESC = "Tyre Already Exist";

	public static final String WARNING_DROP_DOWN_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_DROP_DOWN_ALREADY_EXIST_DESC = "Drop down Already Exist";

	public static final String WARNING_DROP_DOWN_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_DROP_DOWN_DOESNT_EXIST_DESC = "Drop down doesn't Exist";

	public static final String WARNING_MASTER_DATA_LIST_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_MASTER_DATA_LIST_ALREADY_EXIST_DESC = "Master data Already Exist";

	public static final String WARNING_MASTER_DATA_LIST_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_MASTER_DATA_LIST_DOESNT_EXIST_DESC = "Master data doesn't Exist";

	public static final String DUPLICATE_DROP_DOWN_COMBINATION_CODE = "500";
	public static final String DUPLICATE_DROP_DOWN_COMBINATION_DESC = "Drop Down already exist";

	public static final String VALID_DROP_DOWN_DATA_CODE = "200";
	public static final String VALID_DROP_DOWN_DATA_DESC = "Drop Down Data Key Available";

	public static final String VALID_MASTER_DATA_LIST_CODE = "200";
	public static final String VALID_MASTER_DATA_LIST_DESC = "Master Data List Key Available";

	public static final String DUPLICATE_MASTER_DATA_LIST_COMBINATION_CODE = "500";
	public static final String DUPLICATE_MASTER_DATA_LIST_COMBINATION_DESC = "Master Data List already exist";
	public static final String WARNING_OBSERVATION_MASTER_DATA_ALREADY_EXIT_DESC = "Observation master data Alrady Exist";
	public static final String WARNING_OBSERVATION_MASTER_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLEMANUFACTURE_MASTER_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLEMANUFACTURE_MASTER_DATA_ALREADY_EXIT_DESC = "vehicleManufacture master data  Alrady Exist";
	public static final String WARNING_VEHICLE_TYPE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_TYPE_ALREADY_EXIST_DESC = "vehicletypealreadyexit";
	public static final String WARNING_VEHICLE_USAGE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_USAGE_ALREADY_EXIST_DESC = "vehicleusagealreadyexit";
	public static final String WARNING_VEHICLE_SUB_TYPE_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_SUB_TYPE_DATA_ALREADY_EXIST_DESC = "vehiclesubtypedataalreadyexist";
	public static final String WARNING_TIRE_MAKE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_TIRE_MAKE_ALREADY_EXIST_DESC = "tiremakealreadyexist";
	public static final String WARNING_VEHICLEMANUFACTURE_MASTER_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLEMANUFACTURE_MASTER_DATA_DOESNT_EXIST_DESC = "vehiclemanufacture master data doesn't Exist";
	public static final String WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_OBSERVATION_MASTER_DATA_DOESNT_EXIT_DESC = "Observation master data doesn't Exist";
	public static final String WARNING_VEHICLE_TYPE_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_TYPE_DOESNT_EXIST_DESC = "vehicle type doesn't Exist";
	public static final String WARNING_VEHICLE_USAGE_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_USAGE_DOESNT_EXIST_DESC = "vehicle usage doesn't Exist";
	public static final String WARNING_VEHICLE_SUB_TYPE_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_SUB_TYPE_DATA_DOESNT_EXIST_DESC = "vehicle subType doesn't Exist";
	public static final String WARNING_TIRE_MAKE_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_TIRE_MAKE_DOESNT_EXIST_DESC = "tire Make doesn't Exist";
	public static final String WARNING_VEHICLE_MODEL_TYPE_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_MODEL_TYPE_DATA_ALREADY_EXIST_DESC = "vehicle model type data  Alrady Exist";
	public static final String WARNING_VEHICLE_MODEL_TYPE_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_MODEL_TYPE_DATA_DOESNT_EXIST_DESC = "vehicle model type data doesn't Exist";
	public static final String WARNING_OBSERVATION_CATEGORY_MASTER_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_OBSERVATION_CATEGORY_MASTER_DATA_ALREADY_EXIST_DESC = "observationcategory master data alrady existcode";
	public static final String WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_OBSERVATION_CATEGORY_MASTER_DATA_DOESNT_EXIT_DESC = "observationcategory master data doesn't Exist";
	public static final String WARNING_TIRE_CONFIGURATION_DATA_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_TIRE_CONFIGURATION_DATA_ALREADY_EXIST_DESC = "tire configuration data already exit";
	public static final String WARNING_TIRE_CONFIGURATION_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_TIRE_CONFIGURATION_DATA_DOESNT_EXIST_DESC = "tire configuration data doesn't exist";
	public static final String WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_INSPECTION_ALREADY_EXIST_DESC = "Vehicle Inspection Already Exist";
	public static final String FAILURE_INCORRECT_INSPECTION_CODE = "400";
	public static final String WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_OLD_VEHICLE_INSPECTION_ALREADY_EXIST_DESC = "old vehicle inspection already exist";
	public static final String WARNING_TIRE_PATTERN_DATA_ALREADY_EXIST_CODE = "100";

	public static final String WARNING_TIRE_PATTERN_DATA_ALREADY_EXIST_DESC = "tire pattern data already exist";
	public static final String WARNING_TIRE_PATTERN_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_TIRE_PATTERN_DATA_DOESNT_EXIST_DESC = "tire  pattern data doesn't Exist ";
	public static final String WARNING_CLIENT_SERVICE_LOCATION_ALREADY_EXIST_CODE = "100";

	public static final String WARNING_CLIENT_SERVICE_LOCATION_ALREADY_EXIST_DESC = "client service location alrady exist";
	public static final String WARNING_CLIENT_SERVICE_LOCATION_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_CLIENT_SERVICE_LOCATION_DATA_DOESNT_EXIST_DESC = "client service location data doesn't exist";
	public static final String FAILURE_DATE_CODE_400 = "400";
	public static final String INSPECTIONDATETIME_AND_TIREORIGINALFITMATEDATE_ARE_SAME_DESCRIPTION_400 = null;
	public static final String WARNING_VEHICLE_INSPECTION_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_INSPECTION_DOESNT_EXIST_DESC = "vehicle inspection data doesn't exist";
	public static final String WARNING_VEHICLE_REGISTER_NO_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_VEHICLE_REGISTER_NO_ALREADY_EXIST_DESC = "vehicle register no already exist";
	public static final String WARNING_SAVE_CLIENT_VEHICLE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_CLIENT_VEHICLE_ALREADY_EXIST_DESC = "client vehicle already exist";
	public static final String WARNING_CLIENT_VEHICLE_ALREADY_EXIST_CODE = "100";
	public static final String WARNING_CLENT_VEHICLE_ALREADY_EXIST_DESC = "client vehicle already exist";
	public static final String WARNING_CLIENT_VEHICLE_DATA_DOESNT_EXIST_CODE = "100";
	public static final String WARNING_CLIENT_VEHICLE_DATA_DOESNT_EXIST_DESC = "client vehicle data doesn't exist";
	public static final String WARNING_VEHICLE_REG_NUMBER_ALREADY_EXIST_CODE ="100";
	public static final String WARNING_VEHICLE_REG_NUMBER_ALREADY_EXIST_DESC = "vehicle reg number already exist";
	
	
	

	
	

}
