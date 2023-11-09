package com.app.user.constants;

public class URLConstants {

	private URLConstants() {
	}

	/*
	 * Services
	 */
	public static final String REGISTRATION_SERVICE = "/registrationservice";
	public static final String REGISTER_USER = "/registeruser";
	public static final String LOGIN_SERVICE = "/loginservice";
	public static final String LOGIN_USER = "/login";
	public static final String MPIN_LOGIN_USER = "/mpinLogin";
	public static final String CHANGE_PASSWORD = "/changepassword";
	public static final String UPDATE_USER = "/updateuser";
	public static final String GET_ALL_USER_DETAILS = "/getallusers";
	public static final String GET_USER_DETAIL_BY_ID = "/getuserdetail";
	public static final String ENABLE_DISABLE_USER = "/enabledisableuser";
	public static final String FORGOT_PASSWORD = "/forgotpassword";
	public static final String GENERATE_MPIN = "/generatempin";
	public static final String SEND_OTP = "/sendotp";
	public static final String LOGOUT = "/logout";
	public static final String MASTER_SERVICE = "/masterservice";
	public static final String FILE_SERVICE = "/fileservice";
	public static final String SAVE_CLIENT = "/saveclient";
	public static final String UPDATE_CLIENT = "/updateclient";
	public static final String ENABLE_DISABLE_CLIENT = "/enabledisableclient";
	public static final String GET_ALL_CLIENT = "/getallclientdata";
	public static final String GET_ALL_CLIENT_BY_MULTIPLE_FILTERS = "/getallclientdatamultplefilters";
	public static final String GET_CLIENT_BY_ID = "/getclientdata";
	public static final String SAVE_VEHICLE = "/savevehicle";
	public static final String UPDATE_VEHICLE = "/updatevehicle";
	public static final String ENABLE_DISABLE_VEHICLE = "/enabledisablevehicle";
	public static final String GET_ALL_VEHICLE = "/getallvehicledata";
	public static final String GET_VEHICLE_BY_ID = "/getvehicledata";
	public static final String SAVE_TYRE = "/savetyre";
	public static final String UPDATE_TYRE = "/updatetyre";
	public static final String ENABLE_DISABLE_TYRE = "/enabledisabletyre";
	public static final String GET_ALL_TYRE = "/getalltyredata";
	public static final String GET_TYRE_BY_ID = "/gettyredata";
	public static final String TOKEN_SERVICE = "/tokenservice";
	public static final String TOKEN = "/token";
	public static final String SAVE_DROP_DOWN_MASTER = "/savedropdownmaster";
	public static final String UPDATE_DROP_DOWN_MASTER = "/updatedropdownmaster";
	public static final String ENABLE_DISABLE_DROP_DOWN_MASTER = "/enabledisabledropdownmaster";
	public static final String GET_ALL_DROP_DOWN_MASTER = "/getalldropdownmasterdata";
	public static final String GET_DROP_DOWN_MASTER_BY_ID = "/getdropdownmasterdata";
	public static final String CHECK_DROP_DOWN_MASTER_DUPLICATE = "/checkdropdownmasterduplicate";
	public static final String SAVE_MASTER_DATA_LIST_MASTER = "/savemasterdatalistmaster";
	public static final String UPDATE_MASTER_DATA_LIST_MASTER = "/updatemasterdatalistmaster";
	public static final String ENABLE_DISABLE_MASTER_DATA_LIST_MASTER = "/enabledisablemasterdatalistmaster";
	public static final String GET_MASTER_DATA_LIST = "/masterdatalist";
	public static final String GET_MASTER_DATA_BY_ID = "/getmasterdata";
	public static final String CHECK_MASTER_DATA_LIST_DUPLICATE = "/checkmasterdatalistduplicate";
	public static final Integer ACTIVE = 1;
	public static final Integer IN_ACTIVE = 0;
	public static final String SAVE_OBSERVATION_MASTER = "/saveobservationmaster";
	public static final String UPDATE_OBSERVATION_MASTER = "/updateobservationmaster";
	public static final String ENABLE_DISABLE_OBSERVATION_MASTER = "/enabledisableobservationmaster";
	public static final String GET_ALL_OBSERVATION = "/getallobservation";

	public static final String GET_OBSERVATION_DATA_BY_ID = "/getobservation";
	public static final String SAVE_VEHICLE_MANUFACTURER_MASTER = "/savevehiclemanufacturermaster";
	public static final String UPDATE_VEHICLE_MANUFACTURER_MASTER = "/updatevehiclemanufacturermaster";
	public static final String ENABLE_DISABLE_VEHICLE_MANUFACTURER_MASTER = "/enabledisablevehiclemanufacturermaster";
	public static final String GET_ALL_VEHICLE_MANUFACTURER = "/getallvehiclemanufacturer";
	public static final String GET_VEHICLE_MANUFACTURER_BY_ID = "/getvehiclemanufacturer";

	public static final String UPDATE_VEHICLE_TYPE = "/updatevehicletype";
	public static final String ENABLE_DISABLE_VEHICLE_TYPE_MASTER = "/enabledisablevehicletypemaster";
	public static final String GET_ALL_VEHICLE_TYPE = "/getallvehicletype";
	public static final String GET_VEHICLE_TYPE_BY_ID = "/getallvehicletypeid";
	public static final String UPDATE_VEHICLE_USAGE_MASTER = "/updatevehicleusagemaster";
	public static final String SAVE_VEHICLE_USAGE_MASTER = "/savevehicleusagemaster";
	public static final String SAVE_VEHICLE_TYPE = "/savevehicletype";
	public static final String ENABLE_DISABLE_VEHICLE_USAGE_MASTER = "/enabledisablevehicleusagemaster";
	public static final String GET_ALL_VEHICLE_USAGE = "/getallvehicleusage";
	public static final String GET_VEHICLE_USAGE_BY_ID = "/getvehicleusageid";
	public static final String SAVE_VEHICLE_SUB_TYPE_MASTER = "/savevehiclesubtypemaster";
	public static final String UPDATE_VEHICLE_SUB_TYPE_MASTER = "/updatevehiclesubtypemaster";
	public static final String ENABLE_DISABLE_VEHICLE_SUB_TYPE_MASTER = "/enabledisablevehiclesubtypemaster";
	public static final String GET_VEHICLE_SUB_TYPE_MASTER_DATA = "/getvehiclesubtypemasterdata";
	public static final String GET_VEHICLE_SUB_TYPE_MASTER_DATA_BY_ID = "/getvehiclesubtypemasterdatabyid";
	public static final String SAVE_TIRE_MAKE_MASTER = "/savetiremakemaster";
	public static final String UPDATE_TIRE_MAKE_MASTER = "/updatetiremakemaster";
	public static final String ENABLE_DISABLE_TIRE_MAKE_USAGE_MASTER = "/enabledisabletiremakemaster";
	public static final String GET_TIRE_MAKE_TYPE_MASTER_DATA = "/tiremaketypemasterdata";
	public static final String GET_TIRE_MAKE_BY_ID = "/tiremakebyid";
	public static final String SAVE_VEHICLE_MODEL_MASTER = "/savevehiclemodelmaster";
	public static final String UPDATE_VEHICLE_MODEL_MASTER = "/updatevehiclemodelmaster";
	public static final String ENABLE_DISABLE_VEHICLE_MODEL_MASTER = "/enabledisablevehiclemodelmaster";
	public static final String GET_VEHICLE_MODEL_MASTER_DATA = "/getVehicleModel";
	public static final String GET_VEHICLE_MODEL_MASTER_DATA_BY_ID = "/getvehiclemodelmasterdatabyid";
	public static final String SAVE_OBSERVATION_CATEGORY_MASTER = "/saveobservationcategorymaster";
	public static final String UPDATE_OBSERVATION_CATEGORY_MASTER = "/updateobservationcategorymaster";
	public static final String ENABLE_DISABLE_OBSERVATION_CATEGORY_MASTER = "/enabledisableobservationcategorymaster";
	public static final String GET_ALL_OBSERVATION_CATEGORY = "/getallcategoryobservtion";
	public static final String GET_OBSERVATION_CATEGORY_DATA_BY_ID = "/getobservationcategorydatabyid";
	public static final String SAVE_TIRE_CONFIGURATION_TYPE_MASTER = "/savetireconfigurationtypemaster";
	public static final String SAVE_TIRE_CONFIGURATION_MASTER = "/savetireconfigurationmaster";
	public static final String UPDATE_TIRE_CONFIGURATION_MASTER = "/updatetireconfigurationmaster";
	public static final String ENABLE_DISABLE_TIRE_CONFIGURATION_MASTER = "/enabledisabletireconfigurationmaster";
	public static final String GET_ALL_TIRE_CONFIGURATION = "/getalltireconfiguration";
	public static final String GET_TIRE_CONFIGURATION_BY_ID = "/gettireconfigurationbyid";
	public static final String VEHICLE_INSPECTION = "/vehicleinspection";
	public static final String CREATE_VEHICLE_INSPECTION = "/createvehicleinspection";
	public static final String GET_ALL_VEHICLE_INSPECTION = "/getallvehicleinspection";
	public static final String GET_VEHICLE_INSPECTION_BY_ID = "/getvehicleinspection";
	public static final String GET_VEHICLE_INSPECTION_BY_CLIENT_ID = "/getvehicleinspectionbyclient";
	public static final String SAVE_VEHICLE_INSPECTION_DETAILS = "/savevehicleinspectiondetails";
	public static final String UPDATE_VEHICLE_INSPECTION_DETAILS = "/updatevehicleinspectiondetails";
	public static final String GET_VEHICLE_INSPECTION_DETAILS = "/getvehicleinspectiondetails";
	public static final Integer DRAFT = 2;
	public static final Integer SUBMITTED = 1;
	public static final Double RTD_MIN_VALUE = 3.0;
	public static final String GET_VEHICLE_BY_MULTIPLE_FILTER = "/getvehiclebymultiplefilter";
	public static final String UPDATE_VEHICLE_INSPECTION = "/updatevehicleinspection";

	public static final String OLD_VEHICLE_INSPECTION = "/oldvehicleinspection";
	public static final String CREATE_OLD_VEHICLE_INSPECTION = "/createoldvehicleinspection";
	public static final String UPDATE_OLD_VEHICLE_INSPECTION = "/updateoldvehicleinspection";
	public static final String GET_ALL_OLD_VEHICLE_INSPECTION = "/getalloldvehicleinspection";

	public static final String GET_OLD_VEHICLE_INSPECTION_BY_ID = "/getoldinspectionbyid";
	public static final String GET_OLD_VEHICLE_INSPECTION_BY_REGISTRATION_NO = "/getoldinspectiponbyregistrationno";

	public static final String UPLOAD_FILE = "/uploadfile";
	public static final String SAVE_OLD_VEHICLE_INSPECTION_DETAILS = "/saveoldvehicleinspectiondetails";
	public static final String GET_OLD_VEHICLE_INSPECTION_DETAILS = "/getoldvehicleinspectiondetails";
	public static final String GET_TIRE_PATTERN = "/gettirepattern";
	public static final String SAVE_TIRE_PATTERN = "/savetirepattern";
	public static final String UPDATE_TIRE_PATTERN = "/updatetirepattern";
	public static final String ENABLE_DISABLE_TIRE_MASTER = "/enabledisabletiremaster";
	public static final String GET_ALL_TIRE_PATTERN = "/getalltirepattern";
	public static final String GET_TIRE_PATTERN_BY_ID = "/gettirepatternbyid";
	public static final String GET_TIRE_MAKE_ID = "/gettiremakeid";
	public static final String GET_TIRE_PATERN_MAKE_BY_ID = "/gettirepatternmakebyid";
	public static final String GET_CLIENT_SERVICE_LOCATION_BY_CLIENT_ID = "/getclientservicelocationbyclientId";
	public static final String ENABLE_DISABLE_INSPECTION = "/enabledisableinspection";
	public static final String CLIENT_LOGIN_USER = "/clientLoginUser";
	public static final String FORGET_PASSWORD = "/forgetpassword";
	public static final String GET_CLIENT_BY_USERID = "/getclientbyuserid";
	public static final String GET_CLIENT_VEHICLE_INSPECTION = "/getClientVehicleInspection";
	public static final String GET_VEHICLE_INSPECTION_BY_CLIENT_ID_USER_ID = "/getVehicleInspectionByClientIdUserId";
	public static final String GET_VEHICLE_BY_REG_NUMBER = "/getvehiclebyregnumber";

	public static final String GET_LAST_VEHICLE_INSPECTION_DATE = "/getlastvehicleinspectiondate";
	public static final String FORGOTE_PASSWORD = "/forgotepassword";
	public static final String SAVE_CLIENT_VEHICLE = "/saveclientVehicle";
	public static final String UPDATE_CLIENT_VEHICLE = "/updateClientvehicle";
	public static final String GET_ALL_CLIENT_VEHICLE = "/getallclientvehicle";
	public static final String ENABLE_DISABLE_CLIENT_VEHICLE_MASTER = "/enabledisableclientvehiclemaster";
	
	public static final String GET_VEHICLE_BY_USER_NAME = "/getvehiclebyusername";
	public static final String GET_CLIENT_VEHICLE_BY_ID = "/getclientvehiclebyid";
	public static final String GET_CLIENT_VEHICLE_BY_CLIENT_ID = "/getclientvehiclebyclientid";
	public static final String GET_ALL_USER = "/getalluser";
	public static final String GET_COUNT_OF_USERS = "/getcountofusers";
	public static final String GET_COUNT_OF_USER = "/getcountofuser";
	public static final String GET_COUNT_OF_CLIENT = "/getcountofclient";
	public static final String GET_COUNT = "/getcount";
	public static final String GET_TIRE_DETAILS_BY_CLIENT_ID_AND_VEHICLE_ID ="/gettiredetailsbyclientidandvehicleid";
	public static final String GET_TOP_TEN_ISSUE_CLIENT_ID_AND_VEHICLE_ID = "/gettoptenissueclientidandvehicleid";
	public static final String GET_TIRE_DETAILS_BY_INSPECTION_ID_CLIENT_ID = "/gettiredetailsbyinspectionidclientid";
	public static final String GET_CLIENT_VEHICLE_BY_CLIENT_ID_AND_LOCATION_ID = "/getclientvehiclebyclientidandlocationid";
	public static final String GET_INSPECTION_DONE_BY_CLIENT_ID_LOCATION_ID = "/getinspectiondonebyclientidandlocationid";
	
	

}