package com.mitchell.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.mitchell.model.Claim;
@Path("/claim")

public class HomeController {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public JAXBElement<Claim> getall(){
		int i=5;
	    Claim c = new Claim();
		
	    
		return new JAXBElement<Claim>(new QName("c"), Claim.class, c);
	}
	
}
