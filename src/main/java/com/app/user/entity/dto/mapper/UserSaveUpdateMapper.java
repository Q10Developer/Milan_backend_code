package com.app.user.entity.dto.mapper;

import com.app.user.dto.request.CreateUserRequestDTO;

import com.app.user.entity.UserRegistrationEtity;

public class UserSaveUpdateMapper {

	private UserSaveUpdateMapper() {

	}

	/* This method is used for Registration Service only */
	public static UserRegistrationEtity getUserRegistrationEtityForSave(CreateUserRequestDTO dto) {
		UserRegistrationEtity userRegEtity = new UserRegistrationEtity();
		userRegEtity.setName(dto.getName());
		userRegEtity.setPassword(dto.getPassword());
		userRegEtity.setMobileNumber(dto.getMobileNumber());
		userRegEtity.setEmailId(dto.getEmailId());
		userRegEtity.setRoleType(dto.getRoleType());
		userRegEtity.setActiveStatus(1);// by default it is set as true
		return userRegEtity;
	}
}
