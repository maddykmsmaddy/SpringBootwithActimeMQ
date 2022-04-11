package com.sapiens.activemq.securingweb;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	        auth.inMemoryAuthentication()
	                .withUser("user").password("{noop}password").roles("USER")
	                .and()
	                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");

	    }
	 
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {

	        http
	                //HTTP Basic authentication
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.POST, "/produce/**").hasRole("USER")
	                .antMatchers(HttpMethod.POST, "/produce").hasRole("ADMIN")
	                .antMatchers(HttpMethod.PUT, "/produce/**").hasRole("ADMIN")
	                .antMatchers(HttpMethod.PATCH, "/produce/**").hasRole("ADMIN")
	                .antMatchers(HttpMethod.DELETE, "/produce/**").hasRole("ADMIN")
	                .and()
	                .csrf().disable()
	                .formLogin().disable();
	    }

}