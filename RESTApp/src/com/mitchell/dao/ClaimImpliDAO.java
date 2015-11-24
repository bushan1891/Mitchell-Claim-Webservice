package com.mitchell.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mitchell.model.Claim;
import com.mysql.jdbc.Connection;
import com.mitchell.dao.*;
import com.mitchell.exception.AppException;
import com.mitchell.Utils.*;

public class ClaimImpliDAO implements claimDAO {

	@Override
	public String insert(String data) {
		// TODO Auto-generated method stub
		
		Connection con = (Connection) DBUtils.getConnection();
		
		
		return null;
	}

	@Override
	public List<Claim> retriveData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Claim retriveRecordData(String claimNumber) {
		// TODO Auto-generated method stub
		
		Claim claim = new Claim();

		Connection con = (Connection) DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM claim WHERE ID=?");
			Integer id = Integer.parseInt(claimNumber);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				
				claim.setAssignedAdjusterId(rs.getByte(""));
				claim.setCauseOfLoss(rs.getString(""));
				claim.setClaimNumber(rs.getString(""));
				claim.setFirstName(rs.getString(""));
				claim.setLastName(rs.getString(""));
				claim.setLossDate(rs.getDate(""));
				claim.setLossDescription(rs.getString(""));
				claim.setReportedDate(rs.getDate(""));
				claim.setStatus(rs.getString(""));	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBUtils.closeResource(ps, rs, con);
		}

		
		
		
		return claim;
	}

	@Override
	public String update(String data) {
		// TODO Auto-generated method stub
		return null;
	}

}
