package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestContactModel {
	private String pipelineId;
	private String contactOwner;
	private String contactOwnerId;
	private String leadSource;
	private String firstName;
	private String lastName;
	private String accountId;
	private String accountName;
	private String title;
	private String email;
	private String contactId;
	private String vendorName;
	private String department;
	private String phone;
	private String homePhone;
	private String otherPhone;
	private String fax;
	private String mobile;
	private String dateBirth;
	private String assistant;
	private String assistPhone;
	private String emailOpt;
	private String skypeId;
	private String secondaryEmail;
	private String twitter;
	private String reportingTo;
	
	private String mailingStreet;
	private String otherMailing;
	private String mailingCity;
	private String otherCity;
	
	private String mailingState;
	private String otherState;
	private String mailingZip;
	private String otherZip;
	
	private String mailingCountry;
	private String otherCountry;
	private String description;
	private String createdBy;
	private String createdDate;
	
	private String ownerImage;
	private String createdTime;
	private String referenceContact;
	public String updatedDate;
	
	private String totalPageno;
	private String totalOrderById;
	
	private String organization;
	private String orgDivision;
	private String customerId;
	private String projectName;
	
	// Sales Customer Details
	private String salesCustName;
	private String salesCustPhone; 
	private String salesCustEmail;
	
	
	public String getSalesCustName() {
		return salesCustName;
	}

	public void setSalesCustName(String salesCustName) {
		this.salesCustName = salesCustName;
	}

	public String getSalesCustPhone() {
		return salesCustPhone;
	}

	public void setSalesCustPhone(String salesCustPhone) {
		this.salesCustPhone = salesCustPhone;
	}

	public String getSalesCustEmail() {
		return salesCustEmail;
	}

	public void setSalesCustEmail(String salesCustEmail) {
		this.salesCustEmail = salesCustEmail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getContactOwnerId() {
		return contactOwnerId;
	}

	public void setContactOwnerId(String contactOwnerId) {
		this.contactOwnerId = contactOwnerId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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



	public String getTotalPageno() {
		return totalPageno;
	}



	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}



	public String getTotalOrderById() {
		return totalOrderById;
	}



	public void setTotalOrderById(String totalOrderById) {
		this.totalOrderById = totalOrderById;
	}



	public String getUpdatedDate() {
		return updatedDate;
	}



	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}



	public String getReferenceContact() {
		return referenceContact;
	}



	public void setReferenceContact(String referenceContact) {
		this.referenceContact = referenceContact;
	}



	public String getOwnerImage() {
		return ownerImage;
	}



	public void setOwnerImage(String ownerImage) {
		this.ownerImage = ownerImage;
	}



	public String getCreatedTime() {
		return createdTime;
	}



	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}



	public RestContactModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RestContactModel(Object pipelineId, Object contactOwner,  Object firstName,
			Object accountName, Object email, Object phone,
			 Object createdDate, Object createdTime, 
			Object ownerImage,Object totalPageno,Object totalOrderById) {
		super();
		this.pipelineId = (String) pipelineId;
		this.contactOwner = (String) contactOwner;
		this.firstName = (String) firstName;
		this.accountName = (String) accountName;
		this.email = (String) email;
		this.phone = (String) phone;
		this.createdDate = (String) createdDate;
		this.createdTime = (String) createdTime;
		this.ownerImage = (String) ownerImage;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;
	
		
	}
	
	public RestContactModel(Object pipelineId, Object contactOwner, Object leadSource, Object firstName,
			Object lastName, Object accountId, Object accountName, Object title, Object email, Object department, Object phone,
			Object homePhone, Object otherPhone, Object fax, Object mobile, Object dateBirth, Object assistant,
			Object assistPhone, Object emailOpt, Object skypeId, Object secondaryEmail, Object twitter,
			Object reportingTo, Object mailingStreet, Object otherMailing, Object mailingCity, Object otherCity,
			Object mailingState, Object otherState, Object mailingZip, Object otherZip, Object mailingCountry,
			Object otherCountry, Object description, Object createdDate, Object createdTime, 
			Object ownerImage, Object referenceContact,Object updatedDate) {
		super();
		try {
			this.pipelineId = (String) pipelineId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.contactOwner = (String) contactOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.leadSource = (String) leadSource;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.firstName = (String) firstName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.lastName = (String) lastName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountId = (String) accountId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountName = (String) accountName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.title = (String) title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.email = (String) email;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.department = (String) department;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.phone = (String) phone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.homePhone = (String) homePhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.otherPhone = (String) otherPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.fax = (String) fax;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mobile = (String) mobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.dateBirth = (String) dateBirth;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.assistant = (String) assistant;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.assistPhone = (String) assistPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.emailOpt = (String) emailOpt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.skypeId = (String) skypeId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.secondaryEmail = (String) secondaryEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.twitter = (String) twitter;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.reportingTo = (String) reportingTo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingStreet = (String) mailingStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherMailing = (String) otherMailing;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.mailingCity = (String) mailingCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherCity = (String) otherCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingState = (String) mailingState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherState = (String) otherState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingZip = (String) mailingZip;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.otherZip = (String) otherZip;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingCountry = (String) mailingCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherCountry = (String) otherCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.description = (String) description;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.createdTime = (String) createdTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ownerImage = (String) ownerImage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.referenceContact = (String) referenceContact;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.updatedDate = (String) updatedDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	
	public RestContactModel(Object pipelineId, Object contactOwner, Object leadSource, Object firstName,
			Object lastName, Object accountId, Object accountName, Object title, Object email, Object department, Object phone,
			Object homePhone, Object otherPhone, Object fax, Object mobile, Object dateBirth, Object assistant,
			Object assistPhone, Object emailOpt, Object skypeId, Object secondaryEmail, Object twitter,
			Object reportingTo, Object mailingStreet, Object otherMailing, Object mailingCity, Object otherCity,
			Object mailingState, Object otherState, Object mailingZip, Object otherZip, Object mailingCountry,
			Object otherCountry, Object description, Object vendorName, Object createdDate, Object createdTime, 
			Object ownerImage, Object referenceContact,Object updatedDate, Object customerId,Object contactOwnerId, 
			Object projectName,Object salesCustName,Object salesCustPhone,Object salesCustEmail) {
		
		this.contactOwnerId = (String) contactOwnerId;
		this.customerId = (String) customerId;
		this.projectName = (String) projectName;
		this.salesCustName = (String) salesCustName;
		this.salesCustPhone = (String) salesCustPhone;
		this.salesCustEmail = (String) salesCustEmail;
		try {
			this.pipelineId = (String) pipelineId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.contactOwner = (String) contactOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.leadSource = (String) leadSource;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.firstName = (String) firstName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.lastName = (String) lastName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountId = (String) accountId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.accountName = (String) accountName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.title = (String) title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.email = (String) email;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.department = (String) department;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.phone = (String) phone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.homePhone = (String) homePhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.otherPhone = (String) otherPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.fax = (String) fax;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mobile = (String) mobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.dateBirth = (String) dateBirth;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.assistant = (String) assistant;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.assistPhone = (String) assistPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.emailOpt = (String) emailOpt;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.skypeId = (String) skypeId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.secondaryEmail = (String) secondaryEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.twitter = (String) twitter;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.reportingTo = (String) reportingTo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingStreet = (String) mailingStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherMailing = (String) otherMailing;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.mailingCity = (String) mailingCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherCity = (String) otherCity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingState = (String) mailingState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherState = (String) otherState;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingZip = (String) mailingZip;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.otherZip = (String) otherZip;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.mailingCountry = (String) mailingCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.otherCountry = (String) otherCountry;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.description = (String) description;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.vendorName = (String) vendorName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.createdTime = (String) createdTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.ownerImage = (String) ownerImage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.referenceContact = (String) referenceContact;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.updatedDate = (String) updatedDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			}

	

	public RestContactModel(String pipelineId, String contactOwner, String leadSource, String firstName,
			String lastName, String accountId, String accountName, String title, String email, String department, String phone,
			String homePhone, String otherPhone, String fax, String mobile, String dateBirth, String assistant,
			String assistPhone, String emailOpt, String skypeId, String secondaryEmail, String twitter,
			String reportingTo, String mailingStreet, String otherMailing, String mailingCity, String otherCity,
			String mailingState, String otherState, String mailingZip, String otherZip, String mailingCountry,
			String otherCountry, String createdBy, String createdDate) {
		super();
		this.pipelineId = pipelineId;
		this.contactOwner = contactOwner;
		this.leadSource = leadSource;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountId = accountId;
		this.accountName = accountName;
		this.title = title;
		this.email = email;
		this.department = department;
		this.phone = phone;
		this.homePhone = homePhone;
		this.otherPhone = otherPhone;
		this.fax = fax;
		this.mobile = mobile;
		this.dateBirth = dateBirth;
		this.assistant = assistant;
		this.assistPhone = assistPhone;
		this.emailOpt = emailOpt;
		this.skypeId = skypeId;
		this.secondaryEmail = secondaryEmail;
		this.twitter = twitter;
		this.reportingTo = reportingTo;
		this.mailingStreet = mailingStreet;
		this.otherMailing = otherMailing;
		this.mailingCity = mailingCity;
		this.otherCity = otherCity;
		this.mailingState = mailingState;
		this.otherState = otherState;
		this.mailingZip = mailingZip;
		this.otherZip = otherZip;
		this.mailingCountry = mailingCountry;
		this.otherCountry = otherCountry;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}

	
	

	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	public String getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(String pipelineId) {
		this.pipelineId = pipelineId;
	}

	
	
	public String getContactOwner() {
		return contactOwner;
	}

	public void setContactOwner(String contactOwner) {
		this.contactOwner = contactOwner;
	}

	public String getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(String leadSource) {
		this.leadSource = leadSource;
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

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getOtherPhone() {
		return otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getAssistPhone() {
		return assistPhone;
	}

	public void setAssistPhone(String assistPhone) {
		this.assistPhone = assistPhone;
	}

	public String getEmailOpt() {
		return emailOpt;
	}

	public void setEmailOpt(String emailOpt) {
		this.emailOpt = emailOpt;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	public String getMailingStreet() {
		return mailingStreet;
	}

	public void setMailingStreet(String mailingStreet) {
		this.mailingStreet = mailingStreet;
	}

	public String getOtherMailing() {
		return otherMailing;
	}

	public void setOtherMailing(String otherMailing) {
		this.otherMailing = otherMailing;
	}

	public String getMailingCity() {
		return mailingCity;
	}

	public void setMailingCity(String mailingCity) {
		this.mailingCity = mailingCity;
	}

	public String getOtherCity() {
		return otherCity;
	}

	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}

	public String getMailingState() {
		return mailingState;
	}

	public void setMailingState(String mailingState) {
		this.mailingState = mailingState;
	}

	public String getOtherState() {
		return otherState;
	}

	public void setOtherState(String otherState) {
		this.otherState = otherState;
	}

	public String getMailingZip() {
		return mailingZip;
	}

	public void setMailingZip(String mailingZip) {
		this.mailingZip = mailingZip;
	}

	public String getOtherZip() {
		return otherZip;
	}

	public void setOtherZip(String otherZip) {
		this.otherZip = otherZip;
	}

	public String getMailingCountry() {
		return mailingCountry;
	}

	public void setMailingCountry(String mailingCountry) {
		this.mailingCountry = mailingCountry;
	}

	public String getOtherCountry() {
		return otherCountry;
	}

	public void setOtherCountry(String otherCountry) {
		this.otherCountry = otherCountry;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getDescription() {
		return description;
	}
	/*
	 * public RestContactModel(String pipelineId, String contactOwner, String
	 * leadSource, String firstName, String lastName, String accountName, String
	 * title, String email, String department, String phone, String homePhone,
	 * String otherPhone, String fax, String mobile, String dateBirth, String
	 * assistant, String assistPhone, String emailOpt, String skypeId, String
	 * secondaryEmail, String twitter, String reportingTo, String mailingStreet,
	 * String otherMailing, String mailingCity, String otherCity, String
	 * mailingState, String otherState, String mailingZip, String otherZip, String
	 * mailingCountry, String otherCountry, String description, String createdBy,
	 * String createdDate) { super(); this.pipelineId = pipelineId;
	 * this.contactOwner = contactOwner; this.leadSource = leadSource;
	 * this.firstName = firstName; this.lastName = lastName; this.accountName =
	 * accountName; this.title = title; this.email = email; this.department =
	 * department; this.phone = phone; this.homePhone = homePhone; this.otherPhone =
	 * otherPhone; this.fax = fax; this.mobile = mobile; this.dateBirth = dateBirth;
	 * this.assistant = assistant; this.assistPhone = assistPhone; this.emailOpt =
	 * emailOpt; this.skypeId = skypeId; this.secondaryEmail = secondaryEmail;
	 * this.twitter = twitter; this.reportingTo = reportingTo; this.mailingStreet =
	 * mailingStreet; this.otherMailing = otherMailing; this.mailingCity =
	 * mailingCity; this.otherCity = otherCity; this.mailingState = mailingState;
	 * this.otherState = otherState; this.mailingZip = mailingZip; this.otherZip =
	 * otherZip; this.mailingCountry = mailingCountry; this.otherCountry =
	 * otherCountry; this.description = description; this.createdBy = createdBy;
	 * this.createdDate = createdDate; }
	 */


	public void setDescription(String description) {
		this.description = description;
	}



	public String getContactId() {
		return contactId;
	}



	public void setContactId(String contactId) {
		this.contactId = contactId;
	}



	public String getVendorName() {
		return vendorName;
	}



	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
