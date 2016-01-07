package com.mitchell.dao;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.mitchell.model.Claim;
import com.mitchell.JXAB.model.MitchellClaim;

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
		try {
			session.save(pojo);
			tx.commit();
			session.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

		return pojo;

	}

	public Claim retriveRecordData(String claimNumber) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Claim claim = (Claim) session.get(Claim.class, claimNumber);
			tx.commit();
			session.close();
			return claim;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	public Claim update(JAXBElement<MitchellClaim> claim) throws JAXBException {

		MitchellClaim mc = ValidatorJAXB.Validatoor(claim);
		Claim pojo = JAXBtoOBJ.toObj(mc);

		if (claim != null) {
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Claim temp = (Claim) session.load(Claim.class, pojo.getClaimNumber());

			// CHECKING IF THE VALID RECORD EXSIST

			if (temp.getClaimNumber().equals(pojo.getClaimNumber()) && !temp.getClaimNumber().equals(null)) {
				try {
					session.update(pojo);
					tx.commit();
					session.close();
					return pojo;
				} catch (Exception e) {
					System.out.println(e);
					System.out.println("Update failed");
					return null;
				}
			}
		}
		return null;
	}

	public boolean delete(String ClaimID) {

		Claim claim;

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		claim = (Claim) session.get(Claim.class, ClaimID);

		// CHECKING IF THE VALID RECORD EXSIST

		if (claim.getClaimNumber().equals(ClaimID) && !claim.getClaimNumber().equals(null)) {
			try {
				session.delete(claim);
				tx.commit();
				session.close();
				return true;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}

		return false;

	}

}
