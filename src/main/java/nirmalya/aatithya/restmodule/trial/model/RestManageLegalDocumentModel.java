package nirmalya.aatithya.restmodule.trial.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestManageLegalDocumentModel {

	private String legalId;
	private String documentId;
	private String vendorId;
	private String vehicleId;
	private String notifyId;
	private String lastIssueId;
	private String emailId;
	private String expireDate;
	private String smsId;
	private String chargeId;
	private String fileUpload;
	private String sms;
	private String email;
	


	public RestManageLegalDocumentModel(Object legalId, Object documentId, Object vehicleId, Object vendorId,
			Object notifyId, Object lastIssueId, Object emailId, Object expireDate, Object smsId, Object chargeId,
			Object fileUpload , Object sms, Object email ) {
		
		super();
		
		this.legalId = (String) legalId;
		this.documentId =(String) documentId;
		this.vehicleId = (String) vehicleId;
		this.vendorId =(String) vendorId;
		this.notifyId = (String) notifyId;
		this.lastIssueId = (String) lastIssueId;
		this.emailId = (String) emailId;
		this.expireDate = (String) expireDate;
		this.smsId = (String) smsId;
		this.chargeId =(String) chargeId;
		this.fileUpload = (String) fileUpload;
		this.sms = (String) sms; 
		this.email = (String) email;
		 
		
	}


	
	  public String getSms() { 
		   return sms;
		 }
	  
	  
	  public void setSms(String sms) { 
		  this.sms = sms; 
		  }
	  
	  
	  public String getEmail() { 
		  return email; 
		  }
	  
	  
	  
	  public void setEmail(String email) {
		  this.email = email; 
		  }
	 




	
	public String getLegalId() {
		return legalId;
	}


	public void setLegalId(String legalId) {
		this.legalId = legalId;
	}




	public String getDocumentId() {
		return documentId;
	}





	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}





	public String getVendorId() {
		return vendorId;
	}





	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}





	public String getVehicleId() {
		return vehicleId;
	}





	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}





	public String getNotifyId() {
		return notifyId;
	}





	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}





	public String getLastIssueId() {
		return lastIssueId;
	}





	public void setLastIssueId(String lastIssueId) {
		this.lastIssueId = lastIssueId;
	}





	public String getEmailId() {
		return emailId;
	}





	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public String getExpireDate() {
		return expireDate;
	}





	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}





	public String getSmsId() {
		return smsId;
	}





	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}





	public String getChargeId() {
		return chargeId;
	}





	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}


	public RestManageLegalDocumentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getFileUpload() {
		return fileUpload;
	}



	public void setFileUpload(String fileUpload) {
		this.fileUpload = fileUpload;
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

