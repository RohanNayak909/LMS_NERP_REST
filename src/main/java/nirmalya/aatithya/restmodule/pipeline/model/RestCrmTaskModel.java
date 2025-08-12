package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmTaskModel {
	private String taskId;
	private String leadId;
	private String pageType;
	private String taskOwner;
	private String taskLead;
	private String taskSubject;
	private String dueDate;
	private String taskContactName;
	private String taskAccountName;
	private String taskStatus;
	private String taskPriority;
	private String reminderYesOrNo;
	private String repeateYesOrNo;
	private String reminderDateid;
	private String reminderTime;
	private String taskAlertBy;
	private String description;
	private String createdBy;
	private String createdOn;
	private String contactId;
	private String accountId;
	private String taskDealId;
	private String taskContactId;
	private String taskAccountId;	
	private String ownerName;
	
	
	private String quoteId;
	private String soId;
	private String poId;
	private String invoiceId;
	
	private String totalOrderById;
	private String totalPageno;
	
	private String organization;
	private String orgDivision;
	
	
	
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


	public String getTotalOrderById() {
		return totalOrderById;
	}


	public void setTotalOrderById(String totalOrderById) {
		this.totalOrderById = totalOrderById;
	}


	public String getTotalPageno() {
		return totalPageno;
	}


	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}


	public String getQuoteId() {
		return quoteId;
	}


	public void setQuoteId(String quoteId) {
		this.quoteId = quoteId;
	}


	public String getSoId() {
		return soId;
	}


	public void setSoId(String soId) {
		this.soId = soId;
	}


	public String getPoId() {
		return poId;
	}


	public void setPoId(String poId) {
		this.poId = poId;
	}


	public String getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}


	public String getPageType() {
		return pageType;
	}


	public void setPageType(String pageType) {
		this.pageType = pageType;
	}


	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getLeadId() {
		return leadId;
	}


	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}


	public String getTaskAccountId() {
		return taskAccountId;
	}


	public void setTaskAccountId(String taskAccountId) {
		this.taskAccountId = taskAccountId;
	}


	public String getTaskDealId() {
		return taskDealId;
	}


	public String getTaskContactId() {
		return taskContactId;
	}



	public void setTaskContactId(String taskContactId) {
		this.taskContactId = taskContactId;
	}



	public void setTaskDealId(String taskDealId) {
		this.taskDealId = taskDealId;
	}



	public RestCrmTaskModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RestCrmTaskModel(Object taskSubject, Object dueDate, Object taskStatus) {
		
		
		super();
		this.taskSubject = (String) taskSubject;
		this.dueDate = (String) dueDate;
		this.taskStatus = (String) taskStatus;
		
		
	}
	
	public RestCrmTaskModel(Object taskId, Object taskOwner,Object taskLead, Object taskSubject, Object dueDate,
			Object taskContactName, Object taskAccountName, Object taskStatus, Object taskPriority,
			Object totalPageno, Object totalOrderById) {
		
		
		super();
		this.taskId = (String) taskId;
		this.taskOwner = (String) taskOwner;
		this.taskLead = (String) taskLead;
		this.taskSubject = (String) taskSubject;
		this.dueDate = (String) dueDate;
		this.taskContactName = (String) taskContactName;
		this.taskAccountName = (String) taskAccountName;
		this.taskStatus = (String) taskStatus;
		this.taskPriority = (String) taskPriority;
		this.totalPageno = (String) totalPageno;
		this.totalOrderById = (String) totalOrderById;
		
		
	}
	
	public RestCrmTaskModel(Object taskId, Object taskOwner,Object taskLead, Object taskSubject, Object dueDate,
			Object taskContactName, Object taskAccountName, Object taskStatus, Object taskPriority, Object repeateYesOrNo,
			Object reminderYesOrNo,Object reminderDateid, Object reminderTime, Object taskAlertBy,
			Object description, Object createdOn,Object contactId,Object accountId,Object leadId) {
		
		
		super();
		try {
			this.taskId = (String) taskId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.taskOwner = (String) taskOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.taskLead = (String) taskLead;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.taskSubject = (String) taskSubject;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dueDate = (String) dueDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.taskContactName = (String) taskContactName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.taskAccountName = (String) taskAccountName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.taskStatus = (String) taskStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.taskPriority = (String) taskPriority;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.repeateYesOrNo = (String) repeateYesOrNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.reminderYesOrNo = (String) reminderYesOrNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.reminderDateid = (String) reminderDateid;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.reminderTime = (String) reminderTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.taskAlertBy = (String) taskAlertBy;
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
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.contactId = (String) contactId;
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
			this.leadId = (String) leadId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public RestCrmTaskModel(String taskId, String taskOwner,String taskLead, String taskSubject, String dueDate,
			String taskContactName, String taskAccountName, String taskStatus, String taskPriority, String repeateYesOrNo,
			String reminderYesOrNo,String reminderDateid, String reminderTime, String taskAlertBy,
			String description, String createdOn) {
	
		super();
		this.taskId = taskId;
		this.taskOwner = taskOwner;
		this.taskLead = taskLead;
		this.taskSubject = taskSubject;
		this.dueDate = dueDate;
		this.taskContactName = taskContactName;
		this.taskAccountName = taskAccountName;
		this.taskStatus = taskStatus;
		this.taskPriority = taskPriority;
		this.repeateYesOrNo = repeateYesOrNo;
		this.reminderYesOrNo = reminderYesOrNo;
		this.reminderDateid = reminderDateid;
		this.reminderTime = reminderTime;
		this.taskAlertBy = taskAlertBy;
		this.description = description;
		this.createdOn = createdOn;
	}
	
	public RestCrmTaskModel(String taskSubject, String dueDate) {
	
		super();
		this.taskSubject = taskSubject;
		this.dueDate = dueDate;
		
	}
		
	public String getTaskLead() {
		return taskLead;
	}


	public void setTaskLead(String taskLead) {
		this.taskLead = taskLead;
	}


	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getTaskOwner() {
		return taskOwner;
	}



	public void setTaskOwner(String taskOwner) {
		this.taskOwner = taskOwner;
	}



	public String getTaskSubject() {
		return taskSubject;
	}



	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}



	public String getDueDate() {
		return dueDate;
	}



	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}



	public String getTaskContactName() {
		return taskContactName;
	}



	public void setTaskContactName(String taskContactName) {
		this.taskContactName = taskContactName;
	}



	public String getTaskAccountName() {
		return taskAccountName;
	}



	public void setTaskAccountName(String taskAccountName) {
		this.taskAccountName = taskAccountName;
	}



	public String getTaskStatus() {
		return taskStatus;
	}



	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}



	public String getTaskPriority() {
		return taskPriority;
	}



	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}



	public String getReminderYesOrNo() {
		return reminderYesOrNo;
	}



	public void setReminderYesOrNo(String reminderYesOrNo) {
		this.reminderYesOrNo = reminderYesOrNo;
	}



	



	public String getRepeateYesOrNo() {
		return repeateYesOrNo;
	}



	public void setRepeateYesOrNo(String repeateYesOrNo) {
		this.repeateYesOrNo = repeateYesOrNo;
	}



	public String getReminderDateid() {
		return reminderDateid;
	}



	public void setReminderDateid(String reminderDateid) {
		this.reminderDateid = reminderDateid;
	}



	public String getReminderTime() {
		return reminderTime;
	}



	public void setReminderTime(String reminderTime) {
		this.reminderTime = reminderTime;
	}



	public String getTaskAlertBy() {
		return taskAlertBy;
	}



	public void setTaskAlertBy(String taskAlertBy) {
		this.taskAlertBy = taskAlertBy;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getCreatedOn() {
		return createdOn;
	}



	public String getContactId() {
		return contactId;
	}



	public void setContactId(String contactId) {
		this.contactId = contactId;
	}



	public String getAccountId() {
		return accountId;
	}



	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}



	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
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
