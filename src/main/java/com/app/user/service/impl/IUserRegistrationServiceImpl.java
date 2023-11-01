package com.app.user.service.impl;

import java.util.Map;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.app.user.constants.ResponseKeysValue;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ChangePasswordRequestDto;
import com.app.user.dto.request.CreateUserRequestDTO;
import com.app.user.entity.UserRegistrationEtity;
import com.app.user.entity.dto.mapper.UserSaveUpdateMapper;
import com.app.user.repository.UserRepository;

@Service
public class IUserRegistrationServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IUserRegistrationServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	public ServiceResponseDTO saveUserData(CreateUserRequestDTO userMasterCreateDTO) {
		LOGGER.info("user registration process start in IUserRegistrationServiceImpl and saveUserData method");
		ServiceResponseDTO response = new ServiceResponseDTO();
		if (userMasterCreateDTO != null) {
			UserRegistrationEtity entity = UserSaveUpdateMapper.getUserRegistrationEtityForSave(userMasterCreateDTO);
			try {
				if (null != userMasterCreateDTO.getId()) {
					LOGGER.info(" Need to do Updation (User exist) ");
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_ALREADY_EXIST_CODE,
							ResponseKeysValue.WARNING_USER_ALREADY_EXIST_DESC, null);
				} else {
					/* Checking unique Email or Mobile */
					long count = userRepository.findCountByEmailOrMobile(userMasterCreateDTO.getEmailId(),
							userMasterCreateDTO.getMobileNumber());
					if (count > 0) {
						return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_ALREADY_EXIST_CODE,
								ResponseKeysValue.WARNING_USER_ALREADY_EXIST_DESC,
								"Email or Mobile number Already Exist");
					}
					UserRegistrationEtity userData = userRepository.save(entity);
					if (userData.getUserId() > 0) {
						response.setResult(userData.getUserId());
						response.setStatusCode(ResponseKeysValue.SUCCESS_STATUS_CODE_201);
						response.setStatusDescription(ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_201);
						LOGGER.info(" User  creation Process Starts");
					} else {
						response.setStatusCode(ResponseKeysValue.FAILURE_STATUS_CODE_500);
						response.setStatusDescription(ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500);
					}
				}
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

	public ServiceResponseDTO changePassword(ChangePasswordRequestDto changePasswordRequestDTO) {
		LOGGER.info(
				"changePassword process start in IUserRegistrationServiceImpl and changePassword method Executing ");
		try {
			if (changePasswordRequestDTO == null || StringUtils.isEmpty(changePasswordRequestDTO.getEmailId())
					|| StringUtils.isEmpty(changePasswordRequestDTO.getOldPassword())
					|| StringUtils.isEmpty(changePasswordRequestDTO.getNewPassword())
					|| StringUtils.isEmpty(changePasswordRequestDTO.getConfirmNewPassword())
					|| (!changePasswordRequestDTO.getNewPassword()
							.equals(changePasswordRequestDTO.getConfirmNewPassword()))) {
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,
						ResponseKeysValue.FAILURE_PASS_CPASS_DESCRIPTION, null);
			}
			/* old password/Email Validation */
			Map<String, Object> userData = userRepository
					.findPasswordAndUserIdByEmail(changePasswordRequestDTO.getEmailId());
			if (!CollectionUtils.isEmpty(userData)) {
				String password = (String) userData.get("password");
				Long userId = (Long) userData.get("userId");
				if (!password.equals(changePasswordRequestDTO.getOldPassword()))
					return new ServiceResponseDTO(ResponseKeysValue.WARNING_WRONG_OLD_PASSWORD_CODE,
							ResponseKeysValue.WARNING_WRONG_OLD_PASSWORD_DESC, null);
				Integer status = userRepository.updatePasswordById(changePasswordRequestDTO.getNewPassword(), userId);
				if (status <= 0)
					return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
							ResponseKeysValue.FAILURE_DATA_NOT_FOUNT_DESCRIPTION_500, null);
				else {
					LOGGER.info("CHANGE PASSWORD PROCCESS SUCCESS");
					return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_CHANGE_PASSWORD_STATUS_CODE_200,
							ResponseKeysValue.SUCCESS_CHANGE_PASSWORD_STATUS_DESCRIPTION_200, null);
				}
			} else
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_CODE,
						ResponseKeysValue.WARNING_USER_EMAIL_NOT_EXIST_DESC, null);
		} catch (

		Exception ex) {
			LOGGER.error("Exception occur in IUserLoginServiceImpl calss in method changePassword with Exception {}",
					ex.getMessage());
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_500, null);
		}
	}

	public ServiceResponseDTO updateUserDetails(Long userId, CreateUserRequestDTO userRequestDTO) {
		LOGGER.info(
				"updateUserDetails process start in IUserRegistrationServiceImpl and updateUserDetails method Executing ");
		/* old password/Email Validation */
		if (userRequestDTO != null) {
			Optional<UserRegistrationEtity> userDataList = userRepository.findById(userId);
			if (userDataList.isEmpty()) {
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_DOSENT_EXIST_CODE,
						ResponseKeysValue.WARNING_USER_DOSENT_EXIST_DESC, null);
			}
			UserRegistrationEtity userEntity = userDataList.get();
			if (userRequestDTO.getRoleType() != null || userRequestDTO.getRoleType() != 0)
				userEntity.setRoleType(userRequestDTO.getRoleType());
			if (userRequestDTO.getActiveStatus() != null)
				userEntity.setActiveStatus(userRequestDTO.getActiveStatus());
			userEntity = userRepository.save(userEntity);
			if (userEntity.getUserId() > 0) {
				LOGGER.info(" User  updated successfully");
				return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
						ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, userEntity);
			} else {
				LOGGER.info(" Failed to update User");
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
						ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, null);
			}
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400, null);
		}
	}

	public ServiceResponseDTO enableDisableUser(Long userId, CreateUserRequestDTO userRequestDTO) {
		LOGGER.info(
				"enableDisableUser process start in IUserRegistrationServiceImpl and enableDisableUser method Executing ");
		/* old password/Email Validation */
		if (userRequestDTO != null) {
			Optional<UserRegistrationEtity> userDataList = userRepository.findById(userId);
			if (userDataList.isEmpty()) {
				return new ServiceResponseDTO(ResponseKeysValue.WARNING_USER_DOSENT_EXIST_CODE,
						ResponseKeysValue.WARNING_USER_DOSENT_EXIST_DESC, null);
			}
			UserRegistrationEtity userEntity = userDataList.get();
			if (userRequestDTO.getActiveStatus() != null)
				userEntity.setActiveStatus(userRequestDTO.getActiveStatus());
			userEntity = userRepository.save(userEntity);
			if (userEntity.getUserId() > 0) {
				LOGGER.info(" User  updated successfully");
				return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
						ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, userEntity);
			} else {
				LOGGER.info(" Failed to update User");
				return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_500,
						ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, null);
			}
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.FAILURE_STATUS_CODE_400,
					ResponseKeysValue.FAILURE_STATUS_DESCRIPTION_400, null);
		}
	}

	public ServiceResponseDTO getAllUserDetails(int pageNumber, int size, String sortBy) {
		LOGGER.info(
				"getAllUserDetails process start in IUserRegistrationServiceImpl and getAllUserDetails method Executing ");
		PageRequest pageable = PageRequest.of(pageNumber > 0 ? pageNumber - 1 : pageNumber, size, Sort.by(sortBy));
		Page<UserRegistrationEtity> userDetailList = userRepository.findAll(pageable);
		if (userDetailList.getSize() > 0) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, userDetailList);
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}

	public ServiceResponseDTO getUserDetailsById(Long userId) {
		LOGGER.info(
				"getUserDetailsById process start in IUserRegistrationServiceImpl and getUserDetailsById method Executing ");
		Optional<UserRegistrationEtity> userDetail = userRepository.findById(userId);
		if (!userDetail.isEmpty()) {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
					ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, userDetail.get());
		} else {
			return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200, ResponseKeysValue.NO_RECORDS_FOUND,
					null);
		}
	}
	
	
	
	public ServiceResponseDTO getUserCount() {
	    LOGGER.info("getUserCount process start in IUserRegistrationServiceImpl");
	    
	    long userCount = userRepository.count(); // Call the count method from your UserRepository.
	    
	    return new ServiceResponseDTO(ResponseKeysValue.SUCCESS_STATUS_CODE_200,
	            ResponseKeysValue.SUCCESS_STATUS_DESCRIPTION_200, userCount);
	}

	
	
	
	

}