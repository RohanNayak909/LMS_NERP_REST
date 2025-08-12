package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
public class RestCrmApiTaskModel {
	private String taskId;
	private String taskExcutive; 
	private String taskLead;
	private String taskDecisionMaker;
	private String taskDecisionMakerName;
	private String taskLeadName;
	private String taskSubject;
	private String taskDeliveryDate;
	private String taskContactName; 
	private String taskAccountName;
	private String taskStatus; 
	private String taskPriority;
	private String taskRepeate;
	private String taskReminder;
	private String taskDesc;
	private String taskCreatedBy;
	private String taskCreatedOn;
	private String orgName;
	private String orgDiv;
	
// check in 
	private String taskLongitude;
	private String taskLatitude;
	private String taskCheckDate;
	private String taskCheckTime;
	private String ckeckAddress;
	private String ckeckDesc;
	private String meetOtherName;
	private String meetOtherMob;
	private String checkInStatus;
	private String dealStatus;
	private String checkImg;
	private MultipartFile mulFile;
	private String extension;
	
	//private List<RestDirecterManagerCrmModel> taskList;
	public RestCrmApiTaskModel() {
		super();
	}
	public RestCrmApiTaskModel(Object taskId, Object taskExcutive, Object taskLead,Object taskLeadName ,Object taskSubject,
			Object taskDeliveryDate,Object taskContactName,Object taskAccountName,
			Object taskStatus, Object taskPriority, Object taskRepeate,
			Object taskReminder,Object taskDesc,Object taskCreatedBy,Object taskDecisionMaker,Object taskDecisionMakerName,Object taskCheckDate,Object ckeckDesc,Object ckeckAddress,Object taskCheckTime,
			Object checkInStatus,Object dealStatus) {
		super();
		this.taskId = String.valueOf(taskId);
		this.taskExcutive = (String)taskExcutive;
		this.taskLead = (String)taskLead;
		this.taskLeadName= (String)taskLeadName; 
		this.taskSubject = (String)taskSubject;
		this.taskDeliveryDate = (String)taskDeliveryDate;
		this.taskContactName = (String)taskContactName;
		this.taskAccountName = (String)taskAccountName;
		this.taskStatus = (String)taskStatus;
		this.taskPriority = (String)taskPriority;
		this.taskRepeate = (String)taskRepeate;
		this.taskReminder = (String)taskReminder;
		this.taskDesc = (String)taskDesc;
		this.taskCreatedBy = (String)taskCreatedBy;
		this.taskDecisionMaker = (String)taskDecisionMaker;
		this.taskDecisionMakerName = (String)taskDecisionMakerName;
		this.taskCheckDate = (String)taskCheckDate;
		this.ckeckDesc = (String)ckeckDesc;
		this.ckeckAddress = (String)ckeckAddress;
		this.taskCheckTime = (String)taskCheckTime;
		this.checkInStatus = (String)checkInStatus;
		this.dealStatus = (String)dealStatus;
	}


	public String getTaskCheckDate() {
		return taskCheckDate;
	}
	public void setTaskCheckDate(String taskCheckDate) {
		this.taskCheckDate = taskCheckDate;
	}
	public String getCkeckDesc() {
		return ckeckDesc;
	}
	public void setCkeckDesc(String ckeckDesc) {
		this.ckeckDesc = ckeckDesc;
	}
	public String getTaskLongitude() {
		return taskLongitude;
	}
	public void setTaskLongitude(String taskLongitude) {
		this.taskLongitude = taskLongitude;
	}
	public String getTaskLatitude() {
		return taskLatitude;
	}
	public void setTaskLatitude(String taskLatitude) {
		this.taskLatitude = taskLatitude;
	}
	public String getTaskCheckTime() {
		return taskCheckTime;
	}
	public void setTaskCheckTime(String taskCheckTime) {
		this.taskCheckTime = taskCheckTime;
	}
	public String getTaskId() {
		return taskId;
	}


	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}


	public String getTaskExcutive() {
		return taskExcutive;
	}


	public void setTaskExcutive(String taskExcutive) {
		this.taskExcutive = taskExcutive;
	}


	public String getTaskLead() {
		return taskLead;
	}


	public void setTaskLead(String taskLead) {
		this.taskLead = taskLead;
	}


	public String getTaskLeadName() {
		return taskLeadName;
	}
	public void setTaskLeadName(String taskLeadName) {
		this.taskLeadName = taskLeadName;
	}
	public String getTaskSubject() {
		return taskSubject;
	}


	public void setTaskSubject(String taskSubject) {
		this.taskSubject = taskSubject;
	}


	public String getTaskDeliveryDate() {
		return taskDeliveryDate;
	}


	public void setTaskDeliveryDate(String taskDeliveryDate) {
		this.taskDeliveryDate = taskDeliveryDate;
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


	public String getTaskRepeate() {
		return taskRepeate;
	}


	public void setTaskRepeate(String taskRepeate) {
		this.taskRepeate = taskRepeate;
	}


	public String getTaskReminder() {
		return taskReminder;
	}


	public void setTaskReminder(String taskReminder) {
		this.taskReminder = taskReminder;
	}


	public String getTaskDesc() {
		return taskDesc;
	}


	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}


	public String getTaskCreatedBy() {
		return taskCreatedBy;
	}


	public void setTaskCreatedBy(String taskCreatedBy) {
		this.taskCreatedBy = taskCreatedBy;
	}


	public String getTaskCreatedOn() {
		return taskCreatedOn;
	}


	public void setTaskCreatedOn(String taskCreatedOn) {
		this.taskCreatedOn = taskCreatedOn;
	}


	public String getOrgName() {
		return orgName;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}


	public String getOrgDiv() {
		return orgDiv;
	}


	public void setOrgDiv(String orgDiv) {
		this.orgDiv = orgDiv;
	}
	
	public String getTaskDecisionMaker() {
		return taskDecisionMaker;
	}
	public void setTaskDecisionMaker(String taskDecisionMaker) {
		this.taskDecisionMaker = taskDecisionMaker;
	}
	
	public String getTaskDecisionMakerName() {
		return taskDecisionMakerName;
	}
	public void setTaskDecisionMakerName(String taskDecisionMakerName) {
		this.taskDecisionMakerName = taskDecisionMakerName;
	}
	
	public String getCkeckAddress() {
		return ckeckAddress;
	}
	public void setCkeckAddress(String ckeckAddress) {
		this.ckeckAddress = ckeckAddress;
	}
	
	public String getMeetOtherName() {
		return meetOtherName;
	}
	public void setMeetOtherName(String meetOtherName) {
		this.meetOtherName = meetOtherName;
	}
	public String getMeetOtherMob() {
		return meetOtherMob;
	}
	public void setMeetOtherMob(String meetOtherMob) {
		this.meetOtherMob = meetOtherMob;
	}

	public String getCheckInStatus() {
		return checkInStatus;
	}
	public void setCheckInStatus(String checkInStatus) {
		this.checkInStatus = checkInStatus;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getCheckImg() {
		return checkImg;
	}
	public void setCheckImg(String checkImg) {
		this.checkImg = checkImg;
	}
	public MultipartFile getMulFile() {
		return mulFile;
	}
	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
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
