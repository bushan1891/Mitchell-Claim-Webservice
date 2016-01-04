package com.mitchell.dao;
import java.util.List;

import com.mitchell.JXAB.model.MitchellClaim;
import com.mitchell.model.Claim;

public interface claimDAO {

	public Claim insert(MitchellClaim data);
	public List<Claim> retriveData();
	public Claim retriveRecordData(String claimNumber);
	public String update(String data);
}
