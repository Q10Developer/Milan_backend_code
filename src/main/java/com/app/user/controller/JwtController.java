package com.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.user.config.helper.JwtUtil;
import com.app.user.dto.ServiceResponseDTO;
import com.app.user.dto.request.JwtRequestDTO;
import com.app.user.dto.request.JwtTokenResponseDTO;
import com.app.user.service.CustomUserDetailsService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping(value = "/token")
	public Object getToken(@RequestBody JwtRequestDTO jwtRequestDTO) throws Exception {

		try {
			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequestDTO.getUserId(), jwtRequestDTO.getPassword()));
		} catch (DisabledException ex) {
			ex.printStackTrace();
			return new ServiceResponseDTO("401", "BAD_CREDENTIALS",
					"Token can not be creataed due to BAD CREDENTIALS. Please provide valid credential");
		} catch (BadCredentialsException e) {
			e.printStackTrace();
			return new ServiceResponseDTO("401", "INVALID_CREDENTIALS",
					"Token can not be creataed due to INVALID CREDENTIALS. Please provide valid credential");
		} catch (Exception e) {
			e.printStackTrace();
			return new ServiceResponseDTO("500", "FAILURE", e.getMessage());
		}
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequestDTO.getUserId());
		String topken = this.jwtUtil.generateToken(userDetails);
		System.err.print("Token is:" + topken);
		return new JwtTokenResponseDTO(topken);
	}

}
