package com.mitchell.Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.datatype.XMLGregorianCalendar;

import com.mitchell.JXAB.model.MitchellClaim;
import com.mitchell.JXAB.model.MitchellClaim.Vehicles;
import com.mitchell.model.Claim;
import com.mitchell.model.*;

public class JAXBtoOBJ {

	public static Claim toObj(MitchellClaim m) {
		Claim c = new Claim();
		Set<Vehicle> v = new HashSet<Vehicle>();
		
		short s = m.getAssignedAdjusterID();

		if (s != 0)
			c.setAssignedAdjusterId(m.getAssignedAdjusterID());

		c.setClaimNumber(m.getClaimNumber());

		if (m.getClaimantFirstName() != null)
			c.setFirstName(m.getClaimantFirstName());

		if (m.getClaimantLastName() != null)
			c.setLastName(m.getClaimantLastName());

		if (m.getLossDate() != null) {

			XMLGregorianCalendar xml = m.getLossDate();
			Date cal = xml.toGregorianCalendar().getTime();
			c.setLossDate(cal);
		}

		if (m.getLossInfo() != null)
			c.setLossDescription(m.getLossInfo().toString());

		if (m.getStatus() != null)
			c.setStatus(m.getStatus());

		Vehicles vjaxb = m.getVehicles();
		Vehicle vhiber = new Vehicle(vjaxb.getVehicleDetails().getModelYear(),
				vjaxb.getVehicleDetails().getMakeDescription(), vjaxb.getVehicleDetails().getModelDescription(),
				vjaxb.getVehicleDetails().getEngineDescription(), vjaxb.getVehicleDetails().getExteriorColor(),
				vjaxb.getVehicleDetails().getLicPlate(), vjaxb.getVehicleDetails().getLicPlateState(),
				vjaxb.getVehicleDetails().getDamageDescription(), vjaxb.getVehicleDetails().getMileage());
		v.add(vhiber);

		c.setVehicle(v);

		return c;

	}

	public static Vehicle toVobj(MitchellClaim m) {

		return null;

	}

}
