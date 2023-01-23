package com.app.user.service.impl;

import java.util.Map;
import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.constants.ScreenRouteConstant;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ChangePasswordRequestDto;
import com.app.user.dto.request.ForgetPasswordRequestDTO;
import com.app.user.dto.request.LoginRequestDTO;
import com.app.user.dto.request.SendOTPRequestDTO;
import com.app.user.dto.response.RouteScreenResponseDTO;
import com.app.user.dto.response.SendOtpResponseDTO;
import com.app.user.repository.UserRepository;

@Service
public class IUserLoginServiceImpl {
	private static final Logger LOGGER = LoggerFactory.getLogger(IUserLoginServiceImpl.class);

	@Autowired
	private UserRepository userRepogitory;
	
	public ServiceResponseDTO userLogin(LoginRequestDTO loginDTO) {
		LOGGER.info("user userLogin process start in IUserLoginServiceImpl and userLogin method Executing");
		try {
			if (loginDTO != null && (loginDTO.getMobileNumber() != null || loginDTO.getEmail() != null)
					&& loginDTO.getPassword() != null) {
				Map<String,Object> userData = userRepogitory.findIdByPasswordAndEmailOrMobile(
						loginDTO.getPassword(), loginDTO.getEmail(),loginDTO.getMobileNumber());
				LOGGER.info("User data: " + userData);
				if (userData!=null && !userData.isEmpty()) {
					// IsLogin with Other Device
					
					Long userId = (Long) userData.get("id");
						
						LOGGER.info("Login Success. Routing to Dashboard Screen");
						RouteScreenResponseDTO routeScreenResponseDTOForDashBoard = setRouteScreenResponseDTOForDashBoard(userId);
						return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200,routeScreenResponseDTOForDashBoard);																
					}					
					
				else {
					LOGGER.info("User authetication fail");
					return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_401,ResponseKeysValue.FAILURE_LOGIN_DESCRIPTION_401,null);
				}
			}

			else {
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400,null);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception occur in IUserLoginServiceImpl calss in method userLogin with Exception {}",
					ex.getMessage());
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,ResponseKeysValue.FAILURE_STATUS_CODE_500,ex.getMessage());
		}
	}

	private RouteScreenResponseDTO setRouteScreenResponseDTOForDashBoard(Long userId) {
        RouteScreenResponseDTO routeScreenResponseDTO=new RouteScreenResponseDTO();
		routeScreenResponseDTO.setUserId(userId);
		routeScreenResponseDTO.setScreenId(ScreenRouteConstant.DASHBOARD_SCREEN_ID);
		routeScreenResponseDTO.setScreenDescription(ScreenRouteConstant.DASHBOARD_SCREEN_DESC);
		return routeScreenResponseDTO;
	}


	@Transactional
	public ServiceResponseDTO sendOtp(SendOTPRequestDTO sendOTPRequestDTO) {
		LOGGER.info("user userLogin process start in IUserLoginServiceImpl and sendOtp method Executing ");
		ServiceResponseDTO response = new ServiceResponseDTO();

		try {
			if (sendOTPRequestDTO != null && sendOTPRequestDTO.getUserId() != null
					&& sendOTPRequestDTO.getMobileNumber() != null) {
				boolean status = false;
				String otp = generateOtp();
				if (StringUtils.isNoneEmpty(otp)) {
					//int isUpdated=userRepogitory.updateOtpByUserId(otp, sendOTPRequestDTO.getUserId());
					int isUpdated=1;//need to modify
					
					if(isUpdated>0) {
						LOGGER.info("otp updated in database");
						status = sendOtpToMobileNumber(otp, sendOTPRequestDTO.getMobileNumber());
					}
					setResponseStatusAndDesc(response,status,otp);
				} else 
					setOtoFailureStatusAndDesc(response);				
			} else {
				response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
				response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception occur in IUserLoginServiceImpl calss in method userLogin with Exception {}",
					ex.getMessage());
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
		}
		return response;
	}

	

	private String generateOtp() {
		LOGGER.info("OTP Send to user Mobile");
		return "1234";
	}

	private boolean sendOtpToMobileNumber(String otp, Long mobileNumber) {
		LOGGER.info("OTP Send to user Mobile");
		return true;

	}
	
	private void setResponseStatusAndDesc(ServiceResponseDTO response, boolean status,String otp) {
		if (status)
			setOtoSuccessStatusAndDesc(response,otp);
		 else
			setOtoFailureStatusAndDesc(response);	
	}

	private void setOtoFailureStatusAndDesc(ServiceResponseDTO response) {
		response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
		response.setStatusDescription(ResponseKeysValue.FAILURE_OTP_DESCRIPTION);
	}
	private void setOtoSuccessStatusAndDesc(ServiceResponseDTO response,String opt) {
		response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_200);
		response.setStatusDescription(ResponseKeysValue.SUCCESS_OTP_DESCRIPTION);
		response.setResult(new SendOtpResponseDTO(opt));
	}
	
	
	
	public ServiceResponseDTO forgetPassword(ForgetPasswordRequestDTO forgetPasswordRequestDTO) {
		LOGGER.info("forgetPassword process start in IUserLoginServiceImpl and forgetPassword method Executing ");
		try {
			if (forgetPasswordRequestDTO != null && StringUtils.isNotEmpty(forgetPasswordRequestDTO.getEmailId())&& 
					StringUtils.isNotEmpty(forgetPasswordRequestDTO.getPassword()) 
					&& StringUtils.isNotEmpty(forgetPasswordRequestDTO.getConfirmPassword())) {	
				if(!forgetPasswordRequestDTO.getConfirmPassword().equals(forgetPasswordRequestDTO.getPassword()))
					return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_PASS_CPASS_DESCRIPTION,null); 
				
				/* old password/Email Validation */
				Map<String,Object> userData = userRepogitory.findUserIdByEmail(forgetPasswordRequestDTO.getEmailId());
				
				if(userData!=null && !userData.isEmpty()) {
					Long id=(Long)userData.get("id");
					Integer status=userRepogitory.updatePasswordById(forgetPasswordRequestDTO.getPassword(),id);
					if(status<=0)
						return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,ResponseKeysValue.FAILURE_DATA_NOT_FOUNT_DESCRIPTION_500,null);
					else {
						LOGGER.info("FORGET PASSWORD PROCCESS SUCCESS");
						return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_FORGET_PASSWORD_STATUS_CODE_200,ResponseKeysValue.SUCCESS_FORGET_PASSWORD_STATUS_DESCRIPTION_200,new RouteScreenResponseDTO(id,ScreenRouteConstant.LOGIN_SCREEN_ID,ScreenRouteConstant.LOGIN_SCREEN_DESC));

					}
				}
				else
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_CODE,ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_DESC,null);

						
								
			} else {
				LOGGER.info("INVALID DATA");
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400,null);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception occur in IUserLoginServiceImpl calss in method forgetPassword with Exception {}",
					ex.getMessage());
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500,null);
		}
	}
	
	public ServiceResponseDTO changePassword(ChangePasswordRequestDto changePasswordRequestDTO) {
		LOGGER.info("forgetPassword process start in IUserLoginServiceImpl and forgetPassword method Executing ");
		try {
			if (changePasswordRequestDTO != null && StringUtils.isNotEmpty(changePasswordRequestDTO.getEmailId()) && 
					StringUtils.isNotEmpty(changePasswordRequestDTO.getOldPassword()) 
					&& StringUtils.isNotEmpty(changePasswordRequestDTO.getNewPassword()) && StringUtils.isNotEmpty(changePasswordRequestDTO.getConfirmNewPassword())) {	
				if(!changePasswordRequestDTO.getNewPassword().equals(changePasswordRequestDTO.getConfirmNewPassword()))
					return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_PASS_CPASS_DESCRIPTION,null); 
				
				/* old password/Email Validation */
				Map<String,Object> userData = userRepogitory.findPasswordAndUSerIdByEmail(changePasswordRequestDTO.getEmailId());
				
				if(userData!=null && !userData.isEmpty()) {
					String password=(String)userData.get("password");
					Long id=(Long)userData.get("id");
					if(!password.equals(changePasswordRequestDTO.getOldPassword()))
							return new ServiceResponseDTO(ResponseKeysValue.WARNING_WRONG_OLD_PASSWORD_CODE,ResponseKeysValue.WARNING_WRONG_OLD_PASSWORD_DESC,null);	
					Integer status=userRepogitory.updatePasswordById(changePasswordRequestDTO.getNewPassword(),id);
					if(status<=0)
						return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,ResponseKeysValue.FAILURE_DATA_NOT_FOUNT_DESCRIPTION_500,null);
					else
					{
						LOGGER.info("CHANGE PASSWORD PROCCESS SUCCESS");
						return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_CHANGE_PASSWORD_STATUS_CODE_200,ResponseKeysValue.SUCCESS_CHANGE_PASSWORD_STATUS_DESCRIPTION_200,new RouteScreenResponseDTO(id,ScreenRouteConstant.LOGIN_SCREEN_ID,ScreenRouteConstant.LOGIN_SCREEN_DESC));
					}
					}
				else
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_CODE,ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_DESC,null);
				
				
				
				
			} else {
				LOGGER.info("INVALID DATA");
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400,null);
			}

		} catch (Exception ex) {
			LOGGER.error("Exception occur in IUserLoginServiceImpl calss in method changePassword with Exception {}",
					ex.getMessage());
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500,null);
		}
	}
}
