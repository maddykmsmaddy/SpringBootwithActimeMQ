package com.sapiens.activemq.portal_activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com.sapiens.*")
public class PortalActivemqApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(PortalActivemqApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(PortalActivemqApplication.class);
	}

}
