package com.app.user.constants;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ClientMasterRequestDTO;

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
	public static final String FORGET_PASSWORD = "/fogetPassword";
	public static final String MASTER_SERVICE = "/masterservice";
	public static final String SAVE_CLIENT = "/saveclient";
	public static final String UPDATE_CLIENT = "/updateclient";
	public static final String ENABLE_DISABLE_CLIENT = "/enabledisableclient";
	public static final String GET_ALL_CLIENT = "/getallclientdata";
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
	public static final String SAVE__OBSERVATION_MASTER = "/saveobservationmaster";
	public static final String UPDATE_OBSERVATION_MASTER = "/updateobservationmaster";
	public static final String ENABLE_DISABLE_OBSERVATION_MASTER ="/enabledisableobservationmaster";
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
	public static final String SAVE_VEHICLE_USAGE_MASTER  = "/savevehicleusagemaster";
	public static final String SAVE_VEHICLE_TYPE = "/savevehicletype";
	public static final String ENABLE_DISABLE_VEHICLE_USAGE_MASTER = "/enabledisablevehicleusagemaster";
	public static final String GET_ALL_VEHICLE_USAGE = "/getallvehicleusage";
	public static final String GET_VEHICLE_USAGE_BY_ID = "/getvehicleusageid";
	public static final String SAVE_VEHICLE_SUB_TYPE_MASTER = "/savevehiclesubtypemaster";
	public static final String UPDATE_VEHICLE_SUB_TYPE_MASTER = "/updatevehiclesubtypemaster";
	public static final String ENABLE_DISABLE_VEHICLE_SUB_TYPE__MASTER = "/enabledisablevehiclesubtypemaster";
	public static final String GET_VEHICLE_SUB_TYPE_MASTER_DATA = "/getvehiclesubtypemasterdata";
	public static final String GET_VEHICLE_SUB_TYPE_MASTER_DATA_BY_ID = "/getvehiclesubtypemasterdatabyid";
	public static final String SAVE_TIRE_MAKE_MASTER = "/savetiremakemaster";
	public static final String UPDATE_TIRE_MAKE_MASTER ="/updatetiremakemaster";
	public static final String ENABLE_DISABLE_TIRE_MAKE_USAGE_MASTER = "/enabledisabletiremakemaster";
	public static final String GET_TIRE_MAKE_TYPE_MASTER_DATA = "/tiremaketypemasterdata";
	public static final String GET_TIRE_MAKE_BY_ID = "/tiremakebyid";
	
}