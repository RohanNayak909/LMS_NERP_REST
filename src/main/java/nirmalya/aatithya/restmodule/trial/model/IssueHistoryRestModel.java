package nirmalya.aatithya.restmodule.trial.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class IssueHistoryRestModel {
	
	
	private String issuergnumber;
	private String issuergname;
	private String ticketname;
	private String vehiclename;
	private String description;
	private String fromDate;
	private String phonenumber;
	private String vendorname;
	private String createdBy;
	private String docName;
	
	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getIssuergnumber() {
		return issuergnumber;
	}

	public void setIssuergnumber(String issuergnumber) {
		this.issuergnumber = issuergnumber;
	}

	public String getIssuergname() {
		return issuergname;
	}

	public void setIssuergname(String issuergname) {
		this.issuergname = issuergname;
	}

	public String getTicketname() {
		return ticketname;
	}


	public void setTicketname(String ticketname) {
		this.ticketname = ticketname;
	}


	public String getVehiclename() {
		return vehiclename;
	}


	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	
	public IssueHistoryRestModel (Object issuergnumber, Object issuergname, Object description, Object ticketname, Object vehiclename, Object fromDate, Object docName, Object phonenumber, Object vendorname)
	
	{
		super();
		this.issuergnumber = (String) issuergnumber;
		this.issuergname= (String) issuergname;
		this.ticketname= (String) ticketname;
		this.vehiclename= (String) vehiclename;
		this.description= (String) description;
		this.fromDate= (String) fromDate;
		this.docName= (String) docName;
		this.phonenumber= (String) phonenumber;
		this.vendorname= (String) vendorname;
	}
	
	public IssueHistoryRestModel() {
		super();
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
