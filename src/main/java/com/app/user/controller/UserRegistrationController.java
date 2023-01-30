package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ChangePasswordRequestDto;
import com.app.user.dto.request.CreateUserRequestDTO;
import com.app.user.service.impl.IUserRegistrationServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.REGISTRATION_SERVICE)
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private IUserRegistrationServiceImpl iUserService;

	@PostMapping(value = URLConstants.REGISTER_USER)
	public ServiceResponseDTO registerUser(@RequestBody CreateUserRequestDTO userMasterDto) {
		LOGGER.info("Executing  registerUser() method of UserRegistrationController");
		return iUserService.saveUserData(userMasterDto);
	}

	@PutMapping(value = URLConstants.CHANGE_PASSWORD)
	public ServiceResponseDTO changePassword(@RequestBody ChangePasswordRequestDto changePasswordRequestDto) {
		LOGGER.info("Executing  changePassword() method of UserLoginController #####");
		return iUserService.changePassword(changePasswordRequestDto);
	}

	@PutMapping(value = URLConstants.UPDATE_USER)
	public ServiceResponseDTO updateUserDetails(@RequestParam(name = "userId") Long userId,
			@RequestBody CreateUserRequestDTO userMasterDto) {
		LOGGER.info("Executing  updateUserDetails() method of UserLoginController #####");
		return iUserService.updateUserDetails(userId, userMasterDto);
	}

	@PutMapping(value = URLConstants.ENABLE_DISABLE_USER)
	public ServiceResponseDTO enableDisableUser(@RequestParam(name = "userId") Long userId,
			@RequestBody CreateUserRequestDTO userMasterDto) {
		LOGGER.info("Executing  enableDisableUser() method of UserLoginController #####");
		return iUserService.enableDisableUser(userId, userMasterDto);
	}

	@GetMapping(value = URLConstants.GET_ALL_USER_DETAILS)
	public ServiceResponseDTO getUserAllDetails(@RequestParam(name = "page", defaultValue = "0") int pageNumber,
			@RequestParam(name = "size", defaultValue = "10") int size,
			@RequestParam(name = "sortBy", defaultValue = "userId") String sortBy) {
		LOGGER.info("Executing  getUserAllDetails() method of UserLoginController #####");
		return iUserService.getAllUserDetails(pageNumber, size, sortBy);
	}

	@GetMapping(value = URLConstants.GET_USER_DETAIL_BY_ID)
	public ServiceResponseDTO getUserDetail(@RequestParam(name = "userId") Long userId) {
		LOGGER.info("Executing  getUserDetail() method of UserLoginController #####");
		return iUserService.getUserDetailsById(userId);
	}

}
