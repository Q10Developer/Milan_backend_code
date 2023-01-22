package com.app.user.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username.equals("user")) {
			System.err.println("################## User  found");
			return new User("user","$2a$10$JmCBTlXubtMsT6qJ1siz/.UGhBcJ7y2B1JeTTt.XQUZa19bBqIhEy",new ArrayList<>());
		}
		else {
			System.err.println("##################User not found");
			throw new UsernameNotFoundException("User not found");
		}
	}

}
