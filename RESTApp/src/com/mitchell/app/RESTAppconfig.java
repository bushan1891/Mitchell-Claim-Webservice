package com.mitchell.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class RESTAppconfig extends ResourceConfig {

	public RESTAppconfig(){
		System.out.println("called");
		packages("com.mitchell.rest");
	}
	
}
