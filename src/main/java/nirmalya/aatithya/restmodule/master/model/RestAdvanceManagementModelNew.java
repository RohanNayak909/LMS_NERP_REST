package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAdvanceManagementModelNew {
	
	private String reqId;
	private String date;
	private String eligibility;
	private Double loanamt;
	private String ternure;
	private Double intrestRate;
	
	private String createdBy;
	private String status;
	
	private String organization;
	private String orgDivision;
	
	public RestAdvanceManagementModelNew() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestAdvanceManagementModelNew( Object reqId, Object date, Object eligibility, Object loanamt,
			Object ternure, Object intrestRate, Object status) {
		super();
		
		this.reqId = (String)reqId;
		this.date = (String)date;
		this.eligibility = (String)eligibility;
		this.loanamt = (Double)loanamt;
		this.ternure = (String)ternure;
		this.intrestRate = (Double)intrestRate;
		this.status = (String)status;
	}
	
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEligibility() {
		return eligibility;
	}
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getTernure() {
		return ternure;
	}
	public void setTernure(String ternure) {
		this.ternure = ternure;
	}
	
	public Double getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(Double intrestRate) {
		this.intrestRate = intrestRate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Double getLoanamt() {
		return loanamt;
	}
	public void setLoanamt(Double loanamt) {
		this.loanamt = loanamt;
	}


	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getOrgDivision() {
		return orgDivision;
	}
	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}
	@Override
	public String toString() {
		ObjectMapper mapperObj = new ObjectMapper();
		String jsonStr;
		try {
			jsonStr = mapperObj.writeValueAsString(this);
		} catch (IOException ex) {

			jsonStr = ex.toString();
		}
		return jsonStr;
	}	
	
}
