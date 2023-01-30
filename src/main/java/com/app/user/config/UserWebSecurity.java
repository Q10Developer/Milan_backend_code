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
public class UserWebSecurity extends WebSecurityConfigurerAdapter {

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
		http.csrf().disable().cors().disable().authorizeRequests()
				.antMatchers("/token", URLConstants.LOGIN_SERVICE + URLConstants.LOGIN_USER,
						URLConstants.LOGIN_SERVICE + URLConstants.FORGOT_PASSWORD,
						URLConstants.REGISTRATION_SERVICE + URLConstants.REGISTER_USER,
						URLConstants.REGISTRATION_SERVICE + URLConstants.CHANGE_PASSWORD,
						URLConstants.REGISTRATION_SERVICE + URLConstants.UPDATE_USER,
						URLConstants.REGISTRATION_SERVICE + URLConstants.ENABLE_DISABLE_USER,
						URLConstants.REGISTRATION_SERVICE + URLConstants.GET_ALL_USER_DETAILS,
						URLConstants.REGISTRATION_SERVICE + URLConstants.GET_USER_DETAIL_BY_ID,
						URLConstants.TOKEN_SERVICE + URLConstants.TOKEN,
						URLConstants.MASTER_SERVICE + URLConstants.SAVE_CLIENT,
						URLConstants.MASTER_SERVICE + URLConstants.UPDATE_CLIENT,
						URLConstants.MASTER_SERVICE + URLConstants.ENABLE_DISABLE_CLIENT,
						URLConstants.MASTER_SERVICE + URLConstants.GET_ALL_CLIENT,
						URLConstants.MASTER_SERVICE + URLConstants.GET_CLIENT_BY_ID,
						URLConstants.MASTER_SERVICE + URLConstants.GET_MASTER_DATA_LIST)
				.permitAll().anyRequest().authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
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
