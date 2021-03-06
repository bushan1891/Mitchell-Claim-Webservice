package com.mitchell.rest;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.mitchell.JXAB.model.MitchellClaim;
import com.mitchell.Utils.JAXBtoOBJ;
import com.mitchell.dao.ClaimImpliDAO;
import com.mitchell.model.Claim;

@Path("/claim")
public class HomeController {

	@GET
	@Path("/{ClaimId}")
	@Produces(MediaType.APPLICATION_XML)
	public Claim getCliam(@PathParam("ClaimId") String Id) {
		// to obtain the data from the backstore

		ClaimImpliDAO dao = new ClaimImpliDAO();
		Claim claim = dao.retriveRecordData(Id);

		return claim;
	}

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Claim pushClaim(JAXBElement<MitchellClaim> claim) throws JAXBException {

		ClaimImpliDAO dao = new ClaimImpliDAO();
		Claim pojo = dao.insert(claim);

		return pojo;

	}

	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Claim putClaim(JAXBElement<MitchellClaim> claim) throws JAXBException {

		ClaimImpliDAO dao = new ClaimImpliDAO();
		Claim pojo = dao.update(claim);

		return pojo;

	}

	@DELETE
	@Path("/delete/{Claim_ID}")
	@Consumes(MediaType.APPLICATION_XML)
	public boolean deleteClaim(@PathParam("Claim_ID") String Id) {

		ClaimImpliDAO dao = new ClaimImpliDAO();
		boolean delete = dao.delete(Id);
		if (delete)
			return true;

		return false;

	}

}
