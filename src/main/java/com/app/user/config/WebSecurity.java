package com.app.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.user.constants.URLConstants;
import com.app.user.service.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/static/images/**",
				"/static/inspection-images/**", "/token", URLConstants.LOGIN_SERVICE + URLConstants.LOGIN_USER,
				URLConstants.LOGIN_SERVICE + URLConstants.FORGOT_PASSWORD,
				URLConstants.REGISTRATION_SERVICE + URLConstants.REGISTER_USER,
				URLConstants.REGISTRATION_SERVICE + URLConstants.CHANGE_PASSWORD,
				URLConstants.REGISTRATION_SERVICE + URLConstants.UPDATE_USER,
				URLConstants.REGISTRATION_SERVICE + URLConstants.ENABLE_DISABLE_USER,
				URLConstants.REGISTRATION_SERVICE + URLConstants.GET_ALL_USER_DETAILS,
				URLConstants.REGISTRATION_SERVICE + URLConstants.GET_USER_DETAIL_BY_ID,
				URLConstants.TOKEN_SERVICE + URLConstants.TOKEN, URLConstants.MASTER_SERVICE + URLConstants.SAVE_CLIENT,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_CLIENT,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_CLIENT,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_CLIENT,
				URLConstants.MASTER_SERVICE + URLConstants.GET_CLIENT_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_VEHICLE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_TYRE,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_TYRE,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_TYRE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_TYRE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TYRE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_DROP_DOWN_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_DROP_DOWN_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_DROP_DOWN_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_DROP_DOWN_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_DROP_DOWN_MASTER_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_MASTER_DATA_LIST_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_MASTER_DATA_LIST_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_MASTER_DATA_LIST_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_MASTER_DATA_LIST,
				URLConstants.MASTER_SERVICE + URLConstants.GET_MASTER_DATA_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.CHECK_DROP_DOWN_MASTER_DUPLICATE,
				URLConstants.MASTER_SERVICE + URLConstants.CHECK_MASTER_DATA_LIST_DUPLICATE,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_OBSERVATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_OBSERVATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_OBSERVATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_OBSERVATION,
				URLConstants.MASTER_SERVICE + URLConstants.GET_OBSERVATION_DATA_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE_MANUFACTURER_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE_MANUFACTURER_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE_MANUFACTURER_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_VEHICLE_MANUFACTURER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_MANUFACTURER_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE_TYPE,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE_TYPE,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE_TYPE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_VEHICLE_TYPE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_TYPE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE_USAGE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE_USAGE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE_USAGE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_VEHICLE_USAGE,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_USAGE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE_SUB_TYPE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE_SUB_TYPE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE_SUB_TYPE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_SUB_TYPE_MASTER_DATA,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_SUB_TYPE_MASTER_DATA_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_TIRE_MAKE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_TIRE_MAKE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_TIRE_MAKE_USAGE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_MAKE_TYPE_MASTER_DATA,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_MAKE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_VEHICLE_MODEL_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_VEHICLE_MODEL_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_VEHICLE_MODEL_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_MODEL_MASTER_DATA,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_MODEL_MASTER_DATA_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_OBSERVATION_CATEGORY_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_OBSERVATION_CATEGORY_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_OBSERVATION_CATEGORY_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_OBSERVATION_CATEGORY,
				URLConstants.MASTER_SERVICE + URLConstants.GET_OBSERVATION_CATEGORY_DATA_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_TIRE_CONFIGURATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_TIRE_CONFIGURATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_TIRE_CONFIGURATION_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_TIRE_CONFIGURATION,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_CONFIGURATION_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.GET_VEHICLE_BY_MULTIPLE_FILTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_CLIENT_SERVICE_LOCATION_BY_CLIENT_ID,
				URLConstants.MASTER_SERVICE + URLConstants.SAVE_TIRE_PATTERN,
				URLConstants.MASTER_SERVICE + URLConstants.UPDATE_TIRE_PATTERN,
				URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_TIRE_MASTER,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_TIRE_PATTERN,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_PATTERN_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_PATERN_MAKE_BY_ID,
				URLConstants.MASTER_SERVICE + URLConstants.GET_CLIENT_SERVICE_LOCATION_BY_CLIENT_ID,
				URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_CLIENT_BY_MULTIPLE_FILTERS,
				URLConstants.MASTER_SERVICE + URLConstants.GET_TIRE_PATTERN,

				URLConstants.VEHICLE_INSPECTION + URLConstants.CREATE_VEHICLE_INSPECTION,
				URLConstants.VEHICLE_INSPECTION + URLConstants.UPDATE_VEHICLE_INSPECTION,
				URLConstants.VEHICLE_INSPECTION + URLConstants.GET_ALL_VEHICLE_INSPECTION,
				URLConstants.VEHICLE_INSPECTION + URLConstants.GET_VEHICLE_INSPECTION_BY_ID,
				URLConstants.VEHICLE_INSPECTION + URLConstants.GET_VEHICLE_INSPECTION_BY_CLIENT_ID,
				URLConstants.VEHICLE_INSPECTION + URLConstants.SAVE_VEHICLE_INSPECTION_DETAILS,
				URLConstants.VEHICLE_INSPECTION + URLConstants.GET_VEHICLE_INSPECTION_DETAILS,

				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.CREATE_OLD_VEHICLE_INSPECTION,
				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.UPDATE_OLD_VEHICLE_INSPECTION,
				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.GET_ALL_OLD_VEHICLE_INSPECTION,
				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.GET_OLD_VEHICLE_INSPECTION_BY_REGISTRATION_NO,
				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.SAVE_OLD_VEHICLE_INSPECTION_DETAILS,
				URLConstants.OLD_VEHICLE_INSPECTION + URLConstants.GET_OLD_VEHICLE_INSPECTION_DETAILS,

				URLConstants.FILE_SERVICE + URLConstants.UPLOAD_FILE).permitAll().anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
