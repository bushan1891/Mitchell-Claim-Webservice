package com.mitchell.junitTest;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.mitchell.dao.ClaimImpliDAO;
import com.mitchell.model.Claim;

public class JunitTestDAO {

	private static final String claimid = "22c9c23bac142856018ce14a26b6c299";
	private static final String fakeid = "22c9c23bac142856018ce14a26b6c300";
	private static ClaimImpliDAO dao = new ClaimImpliDAO();

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void FetchData() {

		Claim claim = dao.retriveRecordData(claimid);
		// To verify if the correct data has been pulled
		assertNotNull(claim);
		assertNotNull(claim.getClaimNumber());
		assertEquals(claim.getClaimNumber(), claimid);

	}

	@Test
	public void pushData() {
		Claim claim = dao.retriveRecordData(claimid);
		// validating data pushed
		assertNotNull(claim);
		assertEquals(claim.getClaimNumber(), claimid);

	}

	public void deletedata() {

		boolean result = dao.delete(claimid);
		assertEquals(result, true);

		result = dao.delete(fakeid);
		assertEquals(result, false);

	}
}
