package com.mitchell.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")    // all the request from ../Mitchell-ClaimWS/api
                           //  handeled here  
public class RESTAppConfig extends ResourceConfig {
   
	public RESTAppConfig(){
		System.out.println("hi");
		packages("com.mitchell.rest");
	}
	
}