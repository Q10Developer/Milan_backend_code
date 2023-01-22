package com.app.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.CreateUserRequestDTO;
import com.app.user.dto.response.CreateUserResponseDTO;
import com.app.user.entity.UserRegistrationEtity;
import com.app.user.entityDtoMapper.UserSaveUpdateMapper;
import com.app.user.repository.UserRepogitory;

@Service
public class IUserRegistrationServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IUserRegistrationServiceImpl.class);

	@Autowired
	private UserRepogitory userRegistrationRepogitory;

	public ServiceResponseDTO saveUserData(CreateUserRequestDTO userMasterCreateDTO) {
		LOGGER.info("user registration process start in IUserRegistrationServiceImpl and saveUserData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (userMasterCreateDTO != null) {
			if(!userMasterCreateDTO.getPassword().equals(userMasterCreateDTO.getConfirmPassword()))
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,ResponseKeysValue.FAILURE_PASS_CPASS_DESCRIPTION,null); 
		   UserRegistrationEtity entity = UserSaveUpdateMapper.getUserRegistrationEtityForSave(userMasterCreateDTO);				
			try {
				if (null != userMasterCreateDTO.getId()) {
					LOGGER.info(" Need to do Updation (User exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_ALREADY_EXIST_CODE,ResponseKeysValue.WARNING_USER_ALREADY_EXIST_DESC,null);
					
				} else {
					/*Checking unique Email or Mobile*/					
					long count = userRegistrationRepogitory.findCountByEmailOrMobile(userMasterCreateDTO.getEmailId(),userMasterCreateDTO.getMobileNumber());;
					if(count>0)
						return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_ALREADY_EXIST_CODE,ResponseKeysValue.WARNING_USER_ALREADY_EXIST_DESC,"Email or Mobile number Already Exist"); 
					response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
					response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
					LOGGER.info(" User  creation Process Starts");
				}
				UserRegistrationEtity userData = userRegistrationRepogitory.save(entity);			
				response.setResult(new CreateUserResponseDTO(userData.getId()));
				LOGGER.info(" User data save/update Successfully");
			} catch (Exception ex) {
				LOGGER.error(
						"Exception occur in IUserRegistrationServiceImpl calss in method saveUserData with Exception {}",
						ex.getMessage());
				response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
				response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
				response.setResult(ex.getMessage());
			}
		} else {
			response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_400);
			response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400);
		}
		return response;
	}

}
