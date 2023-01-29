package com.app.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.user.constants.URLConstants;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.ForgetPasswordRequestDTO;
import com.app.user.dto.request.LoginRequestDTO;
import com.app.user.service.impl.IUserLoginServiceImpl;

@RestController
@CrossOrigin
@RequestMapping(value = URLConstants.LOGIN_SERVICE)
public class UserLoginController {
	@Autowired
	private IUserLoginServiceImpl iUserLoginServiceImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);

	@PostMapping(value = URLConstants.LOGIN_USER)
	public ServiceResponseDTO login(@RequestBody LoginRequestDTO loginDto) {
		LOGGER.info("Executing  login() method of UserLoginController");
		return iUserLoginServiceImpl.userLogin(loginDto);
	}

	@PutMapping(value = URLConstants.FORGET_PASSWORD)
	public Object forgetPassword(@RequestBody ForgetPasswordRequestDTO forgetPasswordRequestDTO) {
		LOGGER.info("Executing  forgetPassword() method of UserLoginController #####");
		return iUserLoginServiceImpl.forgetPassword(forgetPasswordRequestDTO);
	}

}
