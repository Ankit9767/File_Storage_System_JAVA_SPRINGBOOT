package com.example.FileStorageSystem.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

public class WebSecurityConfigurerAdapter {

	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		
	}

	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
