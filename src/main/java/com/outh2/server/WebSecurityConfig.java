package com.outh2.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myUserDetailsService;
	
	@Bean
	PasswordEncoder passEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Override // to retrieve the authentication manager from super class
	@Bean // will responsible to authenticate the user
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override // we configure the user to authenticate the user
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(myUserDetailsService).passwordEncoder(passEncoder());
	}

	@Override // control the access to our end point
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().authenticated();
		http.cors().disable().anonymous().disable();
		http.headers().frameOptions().disable();
		http.csrf().disable();
		// TODO Auto-generated method stub
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring();
		web.ignoring().antMatchers("/user/**");
	}
}
