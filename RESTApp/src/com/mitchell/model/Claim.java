package com.mitchell.model;


import java.util.Date;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mitchell.JXAB.model.MitchellClaim.LossInfo;
import com.mitchell.JXAB.model.MitchellClaim.Vehicles;

@XmlRootElement
@Entity
@Table(name = "CLAIM")
public class Claim implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String claimNumber;
	private String firstName;
	private String lastName;
	private String status;
	
	private Date lossDate;
	private String causeOfLoss;
	private Date reportedDate;
	private String lossDescription;
	private int assignedAdjusterId;	
	private Set<Vehicle> vehicle;
	
	public Claim() {};
	
	@Id
    @Column(name = "CLAIM_ID")
	public String getClaimNumber() {
		return claimNumber;
	}
	 
	
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	@Transient
	public Date getLossDate() {
		return lossDate;
	}
	
	public void setLossDate(Date xmlGregorianCalendar) {
		this.lossDate = xmlGregorianCalendar;
	}
	
	public String getCauseOfLoss() {
		return causeOfLoss;
	}
	
	public void setCauseOfLoss(String causeOfLoss) {
		this.causeOfLoss = causeOfLoss;
	}
	
	public Date getReportedDate() {
		return reportedDate;
	}
	
	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}
	
	public String getLossDescription() {
		return lossDescription;
	}
	
	public void setLossDescription(String lossInfo) {
		this.lossDescription = lossInfo;
	}
	
	public int getAssignedAdjusterId() {
		return assignedAdjusterId;
	}
	
	public void setAssignedAdjusterId(int value) {
		this.assignedAdjusterId = value;
	}
	
	
	public void setVehicle(Set<Vehicle> vechicle) {
		this.vehicle = vechicle;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Cliam_vehicle", 
	joinColumns = { @JoinColumn(name = "Claim_ID") }, 
	inverseJoinColumns = { @JoinColumn(name = "Vehicle_ID") })
	public Set<Vehicle> getVehicle() {
		return this.vehicle;
	}
	
}
