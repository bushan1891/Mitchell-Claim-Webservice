package com.mitchell.dao;

import java.io.File;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.xml.sax.SAXException;

import com.mitchell.model.Claim;
import com.mitchell.model.Vehicle;
import com.mysql.jdbc.Connection;
import com.mitchell.dao.*;
import com.mitchell.exception.AppException;
import com.mitchell.JXAB.model.MitchellClaim;
import com.mitchell.JXAB.model.MitchellClaim.Vehicles;
import com.mitchell.JXAB.model.ObjectFactory;
import com.mitchell.Utils.*;

public class ClaimImpliDAO {

	public Claim insert(JAXBElement<MitchellClaim> claim) throws JAXBException {
		
         // VALIDATING OUR DATA 
		
        MitchellClaim mc = ValidatorJAXB.Validatoor(claim); 
		Claim pojo = JAXBtoOBJ.toObj(mc);

		// SAVE POJO TO DB USE HIBERNATE

		System.out.println("hibernate pushing data at insert");

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(pojo);
		tx.commit();
		session.close();
		return pojo;
	}

	public List<Claim> retriveData() {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		try {
			List<Claim> list = session.createCriteria(Claim.class).list();
			Claim claim = list.get(0);
			if (claim.getClaimNumber() != null) {
				return list;
			}

		} catch (Exception e) {
			System.out.println("no elements");
		}
		return null;
	}

	public Claim retriveRecordData(String claimNumber) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Claim claim = (Claim) session.get(Claim.class, claimNumber);
			if (claim.getClaimNumber() != null) {
				return claim;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		// System.out.println(claim.getFirstName());

		return null;
	}

	public Claim update(JAXBElement<MitchellClaim> claim) throws JAXBException {
        
		MitchellClaim mc = ValidatorJAXB.Validatoor(claim);      
		Claim pojo =  JAXBtoOBJ.toObj(mc);
		
		if(claim!=null){
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();	
			session.update(pojo);
			tx.commit();
			session.close();
			return pojo;
		}
		
		
		return null;
	}
	
	public boolean delete(String ClaimID ){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Claim claim =  (Claim) session.get(Claim.class, ClaimID);
		session.delete(claim);
		tx.commit();
		session.close();
		
		return false;
		
	}
	
	

}
