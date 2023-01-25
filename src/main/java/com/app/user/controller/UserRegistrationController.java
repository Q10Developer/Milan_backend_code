package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.CreateUserRequestDTO;
import com.app.user.service.impl.IUserRegistrationServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.REGISTRATION_SERVICE)
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private IUserRegistrationServiceImpl iUserRegistrationService;

	@PostMapping(value = URLConstants.REGISTER_USER)
	public ServiceResponseDTO registerUser(@RequestBody CreateUserRequestDTO userMasterCreateDTO) {
		LOGGER.info("Executing  registerUser() method of UserRegistrationController");
		return iUserRegistrationService.saveUserData(userMasterCreateDTO);
	}

}
