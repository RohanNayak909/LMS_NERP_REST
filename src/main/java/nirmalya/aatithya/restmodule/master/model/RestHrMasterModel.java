package nirmalya.aatithya.restmodule.master.model;


import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestHrMasterModel {
	
	private String organization;
	private String orgDivision;

	private String jobTypeId;
	private String jobTypeOrder;
	private String jobTypeName;
	private String jobTypeStatus;
	private String createdOn;
	private String createdBy;
	private String updatedOn;
	private String deletedFlag;

	// work hour model
	private String workhourId;
	private String workhourOrder;
	private String workhourName;
	private String workhourStatus;
	private String workCreatedBy;
	private String workUpdatedBy;
	private String workFromTime;
	private String workToTime;
	private String workFromDate;
	private String workToDate;

	// education model
	private String educationId;
	private String educationLevelName;
	private String educationOrder;
	private String educationStatus;
	private String educationCreatedBy;
	private String educationupdatedBy;

	// job band model
	private String jobBandId;
	private String jobBandName;
	private String jobBandOrder;
	private String jobBandStatus;
	private String jobBandCreatedBy;
	private String jobBandupdatedBy;

	// benifit model
	private String benifitId;
	private String benifitName;
	private String benifitOrder;
	private String benifitStatus;
	private String benifitCreatedBy;
	private String benifitupdatedBy;

	// Address model
	private String addressId;
	private String addressName;
	private String addressOrder;
	private String addressStatus;
	private String addressCreatedBy;
	private String addressCreatedon;
	private String addressupdatedBy;
	private String addressupdatedOn;

	// Blood Group model
	private String bloodGroupId;
	private String bloodGroupName;
	private String bloodGroupOrder;
	private String bloodGroupStatus;
	private String bloodGroupCreatedBy;
	private String bloodGroupCreatedon;
	private String bloodGroupsupdatedBy;
	private String bloodGroupupdatedOn;

	// Marital Status model
	private String maritalId;
	private String maritalName;
	private String maritalOrder;
	private String maritalStatus;
	private String maritalCreatedBy;
	private String maritalCreatedon;
	private String maritalupdatedBy;
	private String maritalupdatedOn;

	// Document Status model
	private String documentId;
	private String documentOrder;
	private String documentName;
	private String documentStatus;
	private String documentCreatedBy;
	private String documentCreatedon;
	private String documentupdatedBy;
	private String documentupdatedOn;

	// Time Sheet model
	private String timeSheetId;
	private String timeSheetName;
	private String timeSheetOrder;
	private String timeSheetStatus;
	private String timeSheetCreatedBy;
	private String timeSheetCreatedon;
	private String timeSheetupdatedBy;
	private String timeSheetupdatedOn;

	// Employment Status model
	private String employmentstatusId;
	private String employmentstatusName;
	private String employmentstatusOrder;
	private String employmentstatusStatus;
	private String employmentstatusCreatedBy;
	private String employmentstatusCreatedon;
	private String employmentstatusupdatedBy;
	private String employmentstatusupdatedOn;

	// Project Type model
	private String projectTypeId;
	private String projectTypeName;
	private String projectTypeDesc;
	private String projectTypeStatus;
	private String projectTypeCreatedBy;
	private String projectTypeCreatedon;
	private String projectTypeupdatedBy;
	private String projectTypeupdatedOn;

	// Priority master model

	private String priorityId;
	private String priorityOrder;
	private String priorityName;
	private String priorityStatus;
	private String priorityCreatedon;
	private String priorityCreatedBy;
	private String priorityUpdatedOn;
	private String priorityUpdatedBy;

	// Gender master model

	private String genderId;
	private String genderName;
	private String genderDesc;
	private String genderStatus;
	private String genderCreatedBy;
	private String genderCreatedon;
	private String genderupdatedBy;
	private String genderupdatedOn;

	// Dependent Relationship model

	private String depRelationId;
	private String depRelationName;
	private String depRelationDesc;
	private String depRelationStatus;
	private String depRelationCreatedBy;
	private String depRelationCreatedon;
	private String depRelationupdatedBy;
	private String depRelationupdatedOn;

	// Employee Dependent type

	private String dependentId;
	private String dependentOrder;
	private String dependentName;
	private String dependentStatus;
	private String dependentCreatedon;
	private String dependentCreatedBy;
	private String dependentUpdatedOn;
	private String dependentUpdatedBy;

	// Employee Insurance Company

	private String insuranceId;
	private String insuranceName;
	private String insuranceDesc;
	private String insuranceStatus;
	private String insuranceCreatedOn;
	private String insuranceCreatedBy;
	private String insuranceUpdatedOn;
	private String insuranceUpdatedBy;
	
	//Shift Management Model
	private String shiftId;
	private String shiftDepartment;
	private String shiftDepartmentName;
	private String shiftSubDepartmentId;
	private String shiftSubDepartmentName;
	private String shiftName;
	private String shiftDesc;
	private String shiftStatus;
	private String shiftFromTime;
	private String shiftToTime;
	private String shiftCreatedBy;
	private String shiftUpdatedBy;
	private String shiftCreatedOn;
	private String shiftUpdatedOn;
	
	 //Designation Model
	  private String designationId;
	  private String designationOrder;
	  private String designationName;
	  private String designationStatus;
	  private String designationCreatedBy;
	  private String designationUpdatedBy;
	  
	//DepartmentModel
	  private String OrganizationName;
	  private String OrganizationDivision;
	  private String departmentId;
	  private String departmentOrder;
	  private String departmentName;
	  private String departmentStatus;
	  private String departmentCreatedBy;
	  private String OrganizationNames;
	  private String OrganizationDivisions;
	  private String subDepartmentId;
	  private String subDpartId;
	  private String subDepartmentName;
	  private String subdepartmentDept;
	  private String subDepartmentStatus;
	  private String subDepartmentCreatedBy;
	  
			
				
				

	public RestHrMasterModel(Object jobTypeId, Object jobTypeOrder, Object jobTypeName, Object jobTypeStatus,
			Object createdOn, Object createdBy, Object updatedOn, Object deletedFlag, Object workhourId,
			Object workhourOrder, Object workhourName, Object workhourStatus, Object workCreatedBy,
			Object workUpdatedBy, Object workFromTime, Object workToTime, Object workFromDate, Object workToDate,
			Object educationId, Object educationOrder, Object educationLevelName, Object educationStatus,
			Object educationCreatedBy, Object educationupdatedBy, Object jobBandId, Object jobBandOrder,
			Object jobBandName, Object jobBandStatus, Object jobBandCreatedBy, Object jobBandupdatedBy,
			Object benifitId, Object benifitOrder, Object benifitName, Object benifitStatus, Object benifitCreatedBy,
			Object benifitupdatedBy, Object addressId, Object addressOrder, Object addressName, Object addressStatus,
			Object addressCreatedBy, Object addressCreatedon, Object addressupdatedBy, Object addressupdatedOn,
			Object bloodGroupId, Object bloodGroupOrder, Object bloodGroupName, Object bloodGroupStatus,
			Object bloodGroupCreatedBy, Object bloodGroupCreatedon, Object bloodGroupsupdatedBy,
			Object bloodGroupupdatedOn, Object maritalId, Object maritalOrder, Object maritalName, Object maritalStatus,
			Object maritalCreatedBy, Object maritalCreatedon, Object maritalupdatedBy, Object maritalupdatedOn,
			Object documentId, Object documentOrder, Object documentName, Object documentStatus,
			Object documentCreatedBy, Object documentCreatedon, Object documentupdatedBy, Object documentupdatedOn,
			Object timeSheetId, Object timeSheetOrder, Object timeSheetName, Object timeSheetStatus,
			Object timeSheetCreatedBy, Object timeSheetCreatedon, Object timeSheetupdatedBy, Object timeSheetupdatedOn,
			Object employmentstatusId, Object employmentstatusOrder, Object employmentstatusName,
			Object employmentstatusStatus, Object employmentstatusCreatedBy, Object employmentstatusCreatedon,
			Object employmentstatusupdatedBy, Object employmentstatusupdatedOn, Object projectTypeId,
			Object projectTypeName, Object projectTypeDesc, Object projectTypeStatus, Object projectTypeCreatedBy,
			Object projectTypeCreatedon, Object projectTypeupdatedBy, Object projectTypeupdatedOn, Object priorityId,
			Object priorityOrder, Object priorityName, Object priorityStatus, Object priorityCreatedon,
			Object priorityCreatedBy, Object priorityUpdatedOn, Object priorityUpdatedBy, Object genderId,
			Object genderName, Object genderDesc, Object genderStatus, Object genderCreatedBy, Object genderCreatedon,
			Object genderupdatedBy, Object genderupdatedOn, Object depRelationId, Object depRelationName,
			Object depRelationDesc, Object depRelationStatus, Object depRelationCreatedBy, Object depRelationCreatedon,
			Object depRelationupdatedBy, Object depRelationupdatedOn, Object dependentId, Object dependentOrder,
			Object dependentName, Object dependentStatus, Object dependentCreatedon, Object dependentCreatedBy,
			Object dependentUpdatedOn, Object dependentUpdatedBy, Object insuranceId, Object insuranceName,
			Object insuranceDesc, Object insuranceStatus, Object insuranceCreatedOn, Object insuranceCreatedBy,
			Object insuranceUpdatedOn, Object insuranceUpdatedBy,Object shiftId, Object shiftName,
			Object shiftDesc,Object shiftStatus,Object shiftFromTime,Object shiftToTime,Object shiftCreatedBy,
			Object shiftUpdatedBy,Object shiftCreatedOn,Object shiftUpdatedOn,Object shiftDepartment,Object shiftDepartmentName,Object shiftSubDepartmentId,Object shiftSubDepartmentName) {
		
		super();
		this.jobTypeId = (String) jobTypeId;
		this.jobTypeOrder = (String) jobTypeOrder;
		this.jobTypeName = (String) jobTypeName;
		this.jobTypeStatus = (String) jobTypeStatus;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
		this.updatedOn = (String) updatedOn;
		this.deletedFlag = (String) deletedFlag;

		this.workhourId = (String) workhourId;
		this.workhourOrder = (String) workhourOrder;
		this.workhourName = (String) workhourName;
		this.workhourStatus = (String) workhourStatus;
		this.workCreatedBy = (String) workCreatedBy;
		this.workUpdatedBy = (String) workUpdatedBy;
		this.workFromTime = (String) workFromTime;
		this.workToTime = (String) workToTime;
		this.workFromDate = (String) workFromDate;
		this.workToDate = (String) workToDate;

		this.educationId = (String) educationId;
		this.educationOrder = (String) educationOrder;
		this.educationLevelName = (String) educationLevelName;
		this.educationStatus = (String) educationStatus;
		this.educationCreatedBy = (String) educationCreatedBy;
		this.educationupdatedBy = (String) educationupdatedBy;

		this.jobBandId = (String) jobBandId;
		this.jobBandOrder = (String) jobBandOrder;
		this.jobBandName = (String) jobBandName;
		this.jobBandStatus = (String) jobBandStatus;
		this.jobBandCreatedBy = (String) jobBandCreatedBy;
		this.jobBandupdatedBy = (String) jobBandupdatedBy;

		this.benifitId = (String) benifitId;
		this.benifitOrder = (String) benifitOrder;
		this.benifitName = (String) benifitName;
		this.benifitStatus = (String) benifitStatus;
		this.benifitCreatedBy = (String) benifitCreatedBy;
		this.benifitupdatedBy = (String) benifitupdatedBy;

		this.addressId = (String) addressId;
		this.addressOrder = (String) addressOrder;
		this.addressName = (String) addressName;
		this.addressStatus = (String) addressStatus;
		this.addressCreatedBy = (String) addressCreatedBy;
		this.addressCreatedon = (String) addressCreatedon;
		this.addressupdatedBy = (String) addressupdatedBy;
		this.addressupdatedOn = (String) addressupdatedOn;

		this.bloodGroupId = (String) bloodGroupId;
		this.bloodGroupOrder = (String) bloodGroupOrder;
		this.bloodGroupName = (String) bloodGroupName;
		this.bloodGroupStatus = (String) bloodGroupStatus;
		this.bloodGroupCreatedBy = (String) bloodGroupCreatedBy;
		this.bloodGroupCreatedon = (String) bloodGroupCreatedon;
		this.bloodGroupsupdatedBy = (String) bloodGroupsupdatedBy;
		this.bloodGroupupdatedOn = (String) bloodGroupupdatedOn;

		this.maritalId = (String) maritalId;
		this.maritalOrder = (String) maritalOrder;
		this.maritalName = (String) maritalName;
		this.maritalStatus = (String) maritalStatus;
		this.maritalCreatedBy = (String) maritalCreatedBy;
		this.maritalCreatedon = (String) maritalCreatedon;
		this.maritalupdatedBy = (String) maritalupdatedBy;
		this.maritalupdatedOn = (String) maritalupdatedOn;

		this.documentId = (String) documentId;
		this.documentOrder = (String) documentOrder;
		this.documentName = (String) documentName;
		this.documentStatus = (String) documentStatus;
		this.documentCreatedBy = (String) documentCreatedBy;
		this.documentCreatedon = (String) documentCreatedon;
		this.documentupdatedBy = (String) documentupdatedBy;
		this.documentupdatedOn = (String) documentupdatedOn;

		this.timeSheetId = (String) timeSheetId;
		this.timeSheetOrder = (String) timeSheetOrder;
		this.timeSheetName = (String) timeSheetName;
		this.timeSheetStatus = (String) timeSheetStatus;
		this.timeSheetCreatedBy = (String) timeSheetCreatedBy;
		this.timeSheetCreatedon = (String) timeSheetCreatedon;
		this.timeSheetupdatedBy = (String) timeSheetupdatedBy;
		this.timeSheetupdatedOn = (String) timeSheetupdatedOn;

		this.employmentstatusId = (String) employmentstatusId;
		this.employmentstatusOrder = (String) employmentstatusOrder;
		this.employmentstatusName = (String) employmentstatusName;
		this.employmentstatusStatus = (String) employmentstatusStatus;
		this.employmentstatusCreatedBy = (String) employmentstatusCreatedBy;
		this.employmentstatusCreatedon = (String) employmentstatusCreatedon;
		this.employmentstatusupdatedBy = (String) employmentstatusupdatedBy;
		this.employmentstatusupdatedOn = (String) employmentstatusupdatedOn;

		this.projectTypeId = (String) projectTypeId;
		this.projectTypeName = (String) projectTypeName;
		this.projectTypeDesc = (String) projectTypeDesc;
		this.projectTypeStatus = (String) projectTypeStatus;
		this.projectTypeCreatedBy = (String) projectTypeCreatedBy;
		this.projectTypeCreatedon = (String) projectTypeCreatedon;
		this.projectTypeupdatedBy = (String) projectTypeupdatedBy;
		this.projectTypeupdatedOn = (String) projectTypeupdatedOn;

		this.priorityId = (String) priorityId;
		this.priorityOrder = (String) priorityOrder;
		this.priorityName = (String) priorityName;
		this.priorityStatus = (String) priorityStatus;
		this.priorityCreatedon = (String) priorityCreatedon;
		this.priorityCreatedBy = (String) priorityCreatedBy;
		this.priorityUpdatedOn = (String) priorityUpdatedOn;
		this.priorityUpdatedBy = (String) priorityUpdatedBy;

		this.genderId = (String) genderId;
		this.genderName = (String) genderName;
		this.genderDesc = (String) genderDesc;
		this.genderStatus = (String) genderStatus;
		this.genderCreatedBy = (String) genderCreatedBy;
		this.genderCreatedon = (String) genderCreatedon;
		this.genderupdatedBy = (String) genderupdatedBy;
		this.genderupdatedOn = (String) genderupdatedOn;

		this.depRelationId = (String) depRelationId;
		this.depRelationName = (String) depRelationName;
		this.depRelationDesc = (String) depRelationDesc;
		this.depRelationStatus = (String) depRelationStatus;
		this.depRelationCreatedBy = (String) depRelationCreatedBy;
		this.depRelationCreatedon = (String) depRelationCreatedon;
		this.depRelationupdatedBy = (String) depRelationupdatedBy;
		this.depRelationupdatedOn = (String) depRelationupdatedOn;

		this.dependentId = (String) dependentId;
		this.dependentOrder = (String) dependentOrder;
		this.dependentName = (String) dependentName;
		this.dependentStatus = (String) dependentStatus;
		this.dependentCreatedon = (String) dependentCreatedon;
		this.dependentCreatedBy = (String) dependentCreatedBy;
		this.dependentUpdatedOn = (String) dependentUpdatedOn;
		this.dependentUpdatedBy = (String) dependentUpdatedBy;

		this.insuranceId = (String) insuranceId;
		this.insuranceName = (String) insuranceName;
		this.insuranceDesc = (String) insuranceDesc;
		this.insuranceStatus = (String) insuranceStatus;
		this.insuranceCreatedOn = (String) insuranceCreatedOn;
		this.insuranceCreatedBy = (String) insuranceCreatedBy;
		this.insuranceUpdatedOn = (String) insuranceUpdatedOn;
		this.insuranceUpdatedBy = (String) insuranceUpdatedBy;
		
		this.shiftId = (String) shiftId;
		this.shiftDepartment = (String) shiftDepartment;
		this.shiftDepartmentName = (String) shiftDepartmentName;
		this.shiftName = (String) shiftName;
		this.shiftDesc = (String) shiftDesc;
		this.shiftStatus = (String) shiftStatus;
		this.shiftFromTime = (String) shiftFromTime;
		this.shiftToTime = (String) shiftToTime;
		this.shiftCreatedBy = (String) shiftCreatedBy;
		this.shiftUpdatedBy = (String) shiftUpdatedBy;
		this.shiftCreatedOn = (String) shiftCreatedOn;
		this.shiftUpdatedOn = (String) shiftUpdatedOn;
		this.shiftSubDepartmentId = (String) shiftSubDepartmentId;
		this.shiftSubDepartmentName = (String) shiftSubDepartmentName;
		
		
		
		
	}

	public RestHrMasterModel(Object designationId, Object designationOrder, Object designationName,
			Object designationStatus,Object designationCreatedBy,Object designationUpdatedBy) {
		super();
		this.designationId = (String) designationId;
		this.designationOrder = (String) designationOrder;
		this.designationName = (String) designationName;
		this.designationStatus = (String) designationStatus;
		this.designationCreatedBy = (String) designationCreatedBy;
		this.designationUpdatedBy = (String) designationUpdatedBy;
	}
	public RestHrMasterModel(Object organizationName, Object organizationDivision, Object departmentId,
			Object departmentOrder, Object departmentName, Object departmentStatus, Object departmentCreatedBy,
			Object organizationNames, Object organizationDivisions, Object subDepartmentId, Object subDpartId,
			 Object subDepartmentName,Object subdepartmentDept, Object subDepartmentStatus,
			Object subDepartmentCreatedBy) {
		super();
		OrganizationName = (String)organizationName;
		OrganizationDivision = (String)organizationDivision;
		this.departmentId = (String)departmentId;
		this.departmentOrder = (String)departmentOrder;
		this.departmentName = (String)departmentName;
		this.departmentStatus = (String)departmentStatus;
		this.departmentCreatedBy = (String)departmentCreatedBy;
		OrganizationNames = (String)organizationNames;
		OrganizationDivisions = (String)organizationDivisions;
		this.subDepartmentId = (String)subDepartmentId;
		this.subDpartId = (String)subDpartId;
		this.subDepartmentName = (String)subDepartmentName;
		this.subdepartmentDept = (String)subdepartmentDept;
		this.subDepartmentStatus = (String)subDepartmentStatus;
		this.subDepartmentCreatedBy = (String)subDepartmentCreatedBy;
		
	}

	
	
	
	
	
	public RestHrMasterModel() {
		super();
	}
	public String getJobTypeId() {
		return jobTypeId;
	}

	public void setJobTypeId(String jobTypeId) {
		this.jobTypeId = jobTypeId;
	}

	public String getJobTypeOrder() {
		return jobTypeOrder;
	}

	public void setJobTypeOrder(String jobTypeOrder) {
		this.jobTypeOrder = jobTypeOrder;
	}

	public String getJobTypeName() {
		return jobTypeName;
	}

	public void setJobTypeName(String jobTypeName) {
		this.jobTypeName = jobTypeName;
	}

	public String getJobTypeStatus() {
		return jobTypeStatus;
	}

	public void setJobTypeStatus(String jobTypeStatus) {
		this.jobTypeStatus = jobTypeStatus;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getDeletedFlag() {
		return deletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	public String getWorkhourId() {
		return workhourId;
	}

	public void setWorkhourId(String workhourId) {
		this.workhourId = workhourId;
	}

	public String getWorkhourOrder() {
		return workhourOrder;
	}

	public void setWorkhourOrder(String workhourOrder) {
		this.workhourOrder = workhourOrder;
	}

	public String getWorkhourName() {
		return workhourName;
	}

	public void setWorkhourName(String workhourName) {
		this.workhourName = workhourName;
	}

	public String getWorkhourStatus() {
		return workhourStatus;
	}

	public void setWorkhourStatus(String workhourStatus) {
		this.workhourStatus = workhourStatus;
	}

	public String getWorkCreatedBy() {
		return workCreatedBy;
	}

	public void setWorkCreatedBy(String workCreatedBy) {
		this.workCreatedBy = workCreatedBy;
	}

	public String getWorkUpdatedBy() {
		return workUpdatedBy;
	}

	public void setWorkUpdatedBy(String workUpdatedBy) {
		this.workUpdatedBy = workUpdatedBy;
	}

	public String getEducationId() {
		return educationId;
	}

	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}

	public String getEducationLevelName() {
		return educationLevelName;
	}

	public void setEducationLevelName(String educationLevelName) {
		this.educationLevelName = educationLevelName;
	}

	public String getEducationOrder() {
		return educationOrder;
	}

	public void setEducationOrder(String educationOrder) {
		this.educationOrder = educationOrder;
	}

	public String getEducationStatus() {
		return educationStatus;
	}

	public void setEducationStatus(String educationStatus) {
		this.educationStatus = educationStatus;
	}

	public String getEducationCreatedBy() {
		return educationCreatedBy;
	}

	public void setEducationCreatedBy(String educationCreatedBy) {
		this.educationCreatedBy = educationCreatedBy;
	}

	public String getEducationupdatedBy() {
		return educationupdatedBy;
	}

	public void setEducationupdatedBy(String educationupdatedBy) {
		this.educationupdatedBy = educationupdatedBy;
	}

	public String getJobBandId() {
		return jobBandId;
	}

	public void setJobBandId(String jobBandId) {
		this.jobBandId = jobBandId;
	}

	public String getJobBandName() {
		return jobBandName;
	}

	public void setJobBandName(String jobBandName) {
		this.jobBandName = jobBandName;
	}

	public String getJobBandOrder() {
		return jobBandOrder;
	}

	public void setJobBandOrder(String jobBandOrder) {
		this.jobBandOrder = jobBandOrder;
	}

	public String getJobBandStatus() {
		return jobBandStatus;
	}

	public void setJobBandStatus(String jobBandStatus) {
		this.jobBandStatus = jobBandStatus;
	}

	public String getJobBandCreatedBy() {
		return jobBandCreatedBy;
	}

	public void setJobBandCreatedBy(String jobBandCreatedBy) {
		this.jobBandCreatedBy = jobBandCreatedBy;
	}

	public String getJobBandupdatedBy() {
		return jobBandupdatedBy;
	}

	public void setJobBandupdatedBy(String jobBandupdatedBy) {
		this.jobBandupdatedBy = jobBandupdatedBy;
	}

	public String getBenifitId() {
		return benifitId;
	}

	public void setBenifitId(String benifitId) {
		this.benifitId = benifitId;
	}

	public String getBenifitName() {
		return benifitName;
	}

	public void setBenifitName(String benifitName) {
		this.benifitName = benifitName;
	}

	public String getBenifitOrder() {
		return benifitOrder;
	}

	public void setBenifitOrder(String benifitOrder) {
		this.benifitOrder = benifitOrder;
	}

	public String getBenifitStatus() {
		return benifitStatus;
	}

	public void setBenifitStatus(String benifitStatus) {
		this.benifitStatus = benifitStatus;
	}

	public String getBenifitCreatedBy() {
		return benifitCreatedBy;
	}

	public void setBenifitCreatedBy(String benifitCreatedBy) {
		this.benifitCreatedBy = benifitCreatedBy;
	}

	public String getBenifitupdatedBy() {
		return benifitupdatedBy;
	}

	public void setBenifitupdatedBy(String benifitupdatedBy) {
		this.benifitupdatedBy = benifitupdatedBy;
	}

	public String getWorkFromTime() {
		return workFromTime;
	}

	public void setWorkFromTime(String workFromTime) {
		this.workFromTime = workFromTime;
	}

	public String getWorkToTime() {
		return workToTime;
	}

	public void setWorkToTime(String workToTime) {
		this.workToTime = workToTime;
	}

	public String getWorkFromDate() {
		return workFromDate;
	}

	public void setWorkFromDate(String workFromDate) {
		this.workFromDate = workFromDate;
	}

	public String getWorkToDate() {
		return workToDate;
	}

	public void setWorkToDate(String workToDate) {
		this.workToDate = workToDate;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressOrder() {
		return addressOrder;
	}

	public void setAddressOrder(String addressOrder) {
		this.addressOrder = addressOrder;
	}

	public String getAddressStatus() {
		return addressStatus;
	}

	public void setAddressStatus(String addressStatus) {
		this.addressStatus = addressStatus;
	}

	public String getAddressCreatedBy() {
		return addressCreatedBy;
	}

	public void setAddressCreatedBy(String addressCreatedBy) {
		this.addressCreatedBy = addressCreatedBy;
	}

	public String getAddressCreatedon() {
		return addressCreatedon;
	}

	public void setAddressCreatedon(String addressCreatedon) {
		this.addressCreatedon = addressCreatedon;
	}

	public String getAddressupdatedBy() {
		return addressupdatedBy;
	}

	public void setAddressupdatedBy(String addressupdatedBy) {
		this.addressupdatedBy = addressupdatedBy;
	}

	public String getAddressupdatedOn() {
		return addressupdatedOn;
	}

	public void setAddressupdatedOn(String addressupdatedOn) {
		this.addressupdatedOn = addressupdatedOn;
	}

	public String getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(String bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getBloodGroupName() {
		return bloodGroupName;
	}

	public void setBloodGroupName(String bloodGroupName) {
		this.bloodGroupName = bloodGroupName;
	}

	public String getBloodGroupOrder() {
		return bloodGroupOrder;
	}

	public void setBloodGroupOrder(String bloodGroupOrder) {
		this.bloodGroupOrder = bloodGroupOrder;
	}

	public String getBloodGroupStatus() {
		return bloodGroupStatus;
	}

	public void setBloodGroupStatus(String bloodGroupStatus) {
		this.bloodGroupStatus = bloodGroupStatus;
	}

	public String getBloodGroupCreatedBy() {
		return bloodGroupCreatedBy;
	}

	public void setBloodGroupCreatedBy(String bloodGroupCreatedBy) {
		this.bloodGroupCreatedBy = bloodGroupCreatedBy;
	}

	public String getBloodGroupCreatedon() {
		return bloodGroupCreatedon;
	}

	public void setBloodGroupCreatedon(String bloodGroupCreatedon) {
		this.bloodGroupCreatedon = bloodGroupCreatedon;
	}

	public String getBloodGroupsupdatedBy() {
		return bloodGroupsupdatedBy;
	}

	public void setBloodGroupsupdatedBy(String bloodGroupsupdatedBy) {
		this.bloodGroupsupdatedBy = bloodGroupsupdatedBy;
	}

	public String getBloodGroupupdatedOn() {
		return bloodGroupupdatedOn;
	}

	public void setBloodGroupupdatedOn(String bloodGroupupdatedOn) {
		this.bloodGroupupdatedOn = bloodGroupupdatedOn;
	}

	public String getMaritalId() {
		return maritalId;
	}

	public void setMaritalId(String maritalId) {
		this.maritalId = maritalId;
	}

	public String getMaritalName() {
		return maritalName;
	}

	public void setMaritalName(String maritalName) {
		this.maritalName = maritalName;
	}

	public String getMaritalOrder() {
		return maritalOrder;
	}

	public void setMaritalOrder(String maritalOrder) {
		this.maritalOrder = maritalOrder;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalCreatedBy() {
		return maritalCreatedBy;
	}

	public void setMaritalCreatedBy(String maritalCreatedBy) {
		this.maritalCreatedBy = maritalCreatedBy;
	}

	public String getMaritalCreatedon() {
		return maritalCreatedon;
	}

	public void setMaritalCreatedon(String maritalCreatedon) {
		this.maritalCreatedon = maritalCreatedon;
	}

	public String getMaritalupdatedBy() {
		return maritalupdatedBy;
	}

	public void setMaritalupdatedBy(String maritalupdatedBy) {
		this.maritalupdatedBy = maritalupdatedBy;
	}

	public String getMaritalupdatedOn() {
		return maritalupdatedOn;
	}

	public void setMaritalupdatedOn(String maritalupdatedOn) {
		this.maritalupdatedOn = maritalupdatedOn;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDocumentOrder() {
		return documentOrder;
	}

	public void setDocumentOrder(String documentOrder) {
		this.documentOrder = documentOrder;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
	}

	public String getDocumentCreatedBy() {
		return documentCreatedBy;
	}

	public void setDocumentCreatedBy(String documentCreatedBy) {
		this.documentCreatedBy = documentCreatedBy;
	}

	public String getDocumentCreatedon() {
		return documentCreatedon;
	}

	public void setDocumentCreatedon(String documentCreatedon) {
		this.documentCreatedon = documentCreatedon;
	}

	public String getDocumentupdatedBy() {
		return documentupdatedBy;
	}

	public void setDocumentupdatedBy(String documentupdatedBy) {
		this.documentupdatedBy = documentupdatedBy;
	}

	public String getDocumentupdatedOn() {
		return documentupdatedOn;
	}

	public void setDocumentupdatedOn(String documentupdatedOn) {
		this.documentupdatedOn = documentupdatedOn;
	}

	public String getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(String timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public String getTimeSheetName() {
		return timeSheetName;
	}

	public void setTimeSheetName(String timeSheetName) {
		this.timeSheetName = timeSheetName;
	}

	public String getTimeSheetOrder() {
		return timeSheetOrder;
	}

	public void setTimeSheetOrder(String timeSheetOrder) {
		this.timeSheetOrder = timeSheetOrder;
	}

	public String getTimeSheetStatus() {
		return timeSheetStatus;
	}

	public void setTimeSheetStatus(String timeSheetStatus) {
		this.timeSheetStatus = timeSheetStatus;
	}

	public String getTimeSheetCreatedBy() {
		return timeSheetCreatedBy;
	}

	public void setTimeSheetCreatedBy(String timeSheetCreatedBy) {
		this.timeSheetCreatedBy = timeSheetCreatedBy;
	}

	public String getTimeSheetCreatedon() {
		return timeSheetCreatedon;
	}

	public void setTimeSheetCreatedon(String timeSheetCreatedon) {
		this.timeSheetCreatedon = timeSheetCreatedon;
	}

	public String getTimeSheetupdatedBy() {
		return timeSheetupdatedBy;
	}

	public void setTimeSheetupdatedBy(String timeSheetupdatedBy) {
		this.timeSheetupdatedBy = timeSheetupdatedBy;
	}

	public String getTimeSheetupdatedOn() {
		return timeSheetupdatedOn;
	}

	public void setTimeSheetupdatedOn(String timeSheetupdatedOn) {
		this.timeSheetupdatedOn = timeSheetupdatedOn;
	}

	public String getEmploymentstatusId() {
		return employmentstatusId;
	}

	public void setEmploymentstatusId(String employmentstatusId) {
		this.employmentstatusId = employmentstatusId;
	}

	public String getEmploymentstatusName() {
		return employmentstatusName;
	}

	public void setEmploymentstatusName(String employmentstatusName) {
		this.employmentstatusName = employmentstatusName;
	}

	public String getEmploymentstatusOrder() {
		return employmentstatusOrder;
	}

	public void setEmploymentstatusOrder(String employmentstatusOrder) {
		this.employmentstatusOrder = employmentstatusOrder;
	}

	public String getEmploymentstatusStatus() {
		return employmentstatusStatus;
	}

	public void setEmploymentstatusStatus(String employmentstatusStatus) {
		this.employmentstatusStatus = employmentstatusStatus;
	}

	public String getEmploymentstatusCreatedBy() {
		return employmentstatusCreatedBy;
	}

	public void setEmploymentstatusCreatedBy(String employmentstatusCreatedBy) {
		this.employmentstatusCreatedBy = employmentstatusCreatedBy;
	}

	public String getEmploymentstatusCreatedon() {
		return employmentstatusCreatedon;
	}

	public void setEmploymentstatusCreatedon(String employmentstatusCreatedon) {
		this.employmentstatusCreatedon = employmentstatusCreatedon;
	}

	public String getEmploymentstatusupdatedBy() {
		return employmentstatusupdatedBy;
	}

	public void setEmploymentstatusupdatedBy(String employmentstatusupdatedBy) {
		this.employmentstatusupdatedBy = employmentstatusupdatedBy;
	}

	public String getEmploymentstatusupdatedOn() {
		return employmentstatusupdatedOn;
	}

	public void setEmploymentstatusupdatedOn(String employmentstatusupdatedOn) {
		this.employmentstatusupdatedOn = employmentstatusupdatedOn;
	}

	public String getProjectTypeId() {
		return projectTypeId;
	}

	public void setProjectTypeId(String projectTypeId) {
		this.projectTypeId = projectTypeId;
	}

	public String getProjectTypeName() {
		return projectTypeName;
	}

	public void setProjectTypeName(String projectTypeName) {
		this.projectTypeName = projectTypeName;
	}

	public String getProjectTypeDesc() {
		return projectTypeDesc;
	}

	public void setProjectTypeDesc(String projectTypeDesc) {
		this.projectTypeDesc = projectTypeDesc;
	}

	public String getProjectTypeStatus() {
		return projectTypeStatus;
	}

	public void setProjectTypeStatus(String projectTypeStatus) {
		this.projectTypeStatus = projectTypeStatus;
	}

	public String getProjectTypeCreatedBy() {
		return projectTypeCreatedBy;
	}

	public void setProjectTypeCreatedBy(String projectTypeCreatedBy) {
		this.projectTypeCreatedBy = projectTypeCreatedBy;
	}

	public String getProjectTypeCreatedon() {
		return projectTypeCreatedon;
	}

	public void setProjectTypeCreatedon(String projectTypeCreatedon) {
		this.projectTypeCreatedon = projectTypeCreatedon;
	}

	public String getProjectTypeupdatedBy() {
		return projectTypeupdatedBy;
	}

	public void setProjectTypeupdatedBy(String projectTypeupdatedBy) {
		this.projectTypeupdatedBy = projectTypeupdatedBy;
	}

	public String getProjectTypeupdatedOn() {
		return projectTypeupdatedOn;
	}

	public void setProjectTypeupdatedOn(String projectTypeupdatedOn) {
		this.projectTypeupdatedOn = projectTypeupdatedOn;
	}

	public String getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}

	public String getPriorityOrder() {
		return priorityOrder;
	}

	public void setPriorityOrder(String priorityOrder) {
		this.priorityOrder = priorityOrder;
	}

	public String getPriorityName() {
		return priorityName;
	}

	public void setPriorityName(String priorityName) {
		this.priorityName = priorityName;
	}

	public String getPriorityStatus() {
		return priorityStatus;
	}

	public void setPriorityStatus(String priorityStatus) {
		this.priorityStatus = priorityStatus;
	}

	public String getPriorityCreatedon() {
		return priorityCreatedon;
	}

	public void setPriorityCreatedon(String priorityCreatedon) {
		this.priorityCreatedon = priorityCreatedon;
	}

	public String getPriorityCreatedBy() {
		return priorityCreatedBy;
	}

	public void setPriorityCreatedBy(String priorityCreatedBy) {
		this.priorityCreatedBy = priorityCreatedBy;
	}

	public String getPriorityUpdatedOn() {
		return priorityUpdatedOn;
	}

	public void setPriorityUpdatedOn(String priorityUpdatedOn) {
		this.priorityUpdatedOn = priorityUpdatedOn;
	}

	public String getPriorityUpdatedBy() {
		return priorityUpdatedBy;
	}

	public void setPriorityUpdatedBy(String priorityUpdatedBy) {
		this.priorityUpdatedBy = priorityUpdatedBy;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	public String getGenderDesc() {
		return genderDesc;
	}

	public void setGenderDesc(String genderDesc) {
		this.genderDesc = genderDesc;
	}

	public String getGenderStatus() {
		return genderStatus;
	}

	public void setGenderStatus(String genderStatus) {
		this.genderStatus = genderStatus;
	}

	public String getGenderCreatedBy() {
		return genderCreatedBy;
	}

	public void setGenderCreatedBy(String genderCreatedBy) {
		this.genderCreatedBy = genderCreatedBy;
	}

	public String getGenderCreatedon() {
		return genderCreatedon;
	}

	public void setGenderCreatedon(String genderCreatedon) {
		this.genderCreatedon = genderCreatedon;
	}

	public String getGenderupdatedBy() {
		return genderupdatedBy;
	}

	public void setGenderupdatedBy(String genderupdatedBy) {
		this.genderupdatedBy = genderupdatedBy;
	}

	public String getGenderupdatedOn() {
		return genderupdatedOn;
	}

	public void setGenderupdatedOn(String genderupdatedOn) {
		this.genderupdatedOn = genderupdatedOn;
	}

	public String getDepRelationId() {
		return depRelationId;
	}

	public void setDepRelationId(String depRelationId) {
		this.depRelationId = depRelationId;
	}

	public String getDepRelationName() {
		return depRelationName;
	}

	public void setDepRelationName(String depRelationName) {
		this.depRelationName = depRelationName;
	}

	public String getDepRelationDesc() {
		return depRelationDesc;
	}

	public void setDepRelationDesc(String depRelationDesc) {
		this.depRelationDesc = depRelationDesc;
	}

	public String getDepRelationStatus() {
		return depRelationStatus;
	}

	public void setDepRelationStatus(String depRelationStatus) {
		this.depRelationStatus = depRelationStatus;
	}

	public String getDepRelationCreatedBy() {
		return depRelationCreatedBy;
	}

	public void setDepRelationCreatedBy(String depRelationCreatedBy) {
		this.depRelationCreatedBy = depRelationCreatedBy;
	}

	public String getDepRelationCreatedon() {
		return depRelationCreatedon;
	}

	public void setDepRelationCreatedon(String depRelationCreatedon) {
		this.depRelationCreatedon = depRelationCreatedon;
	}

	public String getDepRelationupdatedBy() {
		return depRelationupdatedBy;
	}

	public void setDepRelationupdatedBy(String depRelationupdatedBy) {
		this.depRelationupdatedBy = depRelationupdatedBy;
	}

	public String getDepRelationupdatedOn() {
		return depRelationupdatedOn;
	}

	public void setDepRelationupdatedOn(String depRelationupdatedOn) {
		this.depRelationupdatedOn = depRelationupdatedOn;
	}

	public String getDependentId() {
		return dependentId;
	}

	public void setDependentId(String dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentOrder() {
		return dependentOrder;
	}

	public void setDependentOrder(String dependentOrder) {
		this.dependentOrder = dependentOrder;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public String getDependentStatus() {
		return dependentStatus;
	}

	public void setDependentStatus(String dependentStatus) {
		this.dependentStatus = dependentStatus;
	}

	public String getDependentCreatedon() {
		return dependentCreatedon;
	}

	public void setDependentCreatedon(String dependentCreatedon) {
		this.dependentCreatedon = dependentCreatedon;
	}

	public String getDependentCreatedBy() {
		return dependentCreatedBy;
	}

	public void setDependentCreatedBy(String dependentCreatedBy) {
		this.dependentCreatedBy = dependentCreatedBy;
	}

	public String getDependentUpdatedOn() {
		return dependentUpdatedOn;
	}

	public void setDependentUpdatedOn(String dependentUpdatedOn) {
		this.dependentUpdatedOn = dependentUpdatedOn;
	}

	public String getDependentUpdatedBy() {
		return dependentUpdatedBy;
	}

	public void setDependentUpdatedBy(String dependentUpdatedBy) {
		this.dependentUpdatedBy = dependentUpdatedBy;
	}

	public String getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceDesc() {
		return insuranceDesc;
	}

	public void setInsuranceDesc(String insuranceDesc) {
		this.insuranceDesc = insuranceDesc;
	}

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

	public String getInsuranceCreatedOn() {
		return insuranceCreatedOn;
	}

	public void setInsuranceCreatedOn(String insuranceCreatedOn) {
		this.insuranceCreatedOn = insuranceCreatedOn;
	}

	public String getInsuranceCreatedBy() {
		return insuranceCreatedBy;
	}

	public void setInsuranceCreatedBy(String insuranceCreatedBy) {
		this.insuranceCreatedBy = insuranceCreatedBy;
	}

	public String getInsuranceUpdatedOn() {
		return insuranceUpdatedOn;
	}

	public void setInsuranceUpdatedOn(String insuranceUpdatedOn) {
		this.insuranceUpdatedOn = insuranceUpdatedOn;
	}

	public String getInsuranceUpdatedBy() {
		return insuranceUpdatedBy;
	}

	public void setInsuranceUpdatedBy(String insuranceUpdatedBy) {
		this.insuranceUpdatedBy = insuranceUpdatedBy;
	}
	
	public String getShiftId() {
		return shiftId;
	}
	public String getShiftDepartment() {
		return shiftDepartment;
	}
	
	public String getShiftName() {
		return shiftName;
	}

	public String getShiftDesc() {
		return shiftDesc;
	}

	public String getShiftStatus() {
		return shiftStatus;
	}

	public String getShiftFromTime() {
		return shiftFromTime;
	}

	public String getShiftToTime() {
		return shiftToTime;
	}

	public String getShiftCreatedBy() {
		return shiftCreatedBy;
	}

	public String getShiftUpdatedBy() {
		return shiftUpdatedBy;
	}

	public String getShiftCreatedOn() {
		return shiftCreatedOn;
	}

	public String getShiftUpdatedOn() {
		return shiftUpdatedOn;
	}

	public void setShiftId(String shiftId) {
		this.shiftId = shiftId;
	}

	public void setShiftDepartment(String shiftId) {
		this.shiftDepartment = shiftDepartment;
	}
	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public void setShiftDesc(String shiftDesc) {
		this.shiftDesc = shiftDesc;
	}

	public void setShiftStatus(String shiftStatus) {
		this.shiftStatus = shiftStatus;
	}

	public void setShiftFromTime(String shiftFromTime) {
		this.shiftFromTime = shiftFromTime;
	}

	public void setShiftToTime(String shiftToTime) {
		this.shiftToTime = shiftToTime;
	}

	public void setShiftCreatedBy(String shiftCreatedBy) {
		this.shiftCreatedBy = shiftCreatedBy;
	}

	public void setShiftUpdatedBy(String shiftUpdatedBy) {
		this.shiftUpdatedBy = shiftUpdatedBy;
	}

	public void setShiftCreatedOn(String shiftCreatedOn) {
		this.shiftCreatedOn = shiftCreatedOn;
	}

	public void setShiftUpdatedOn(String shiftUpdatedOn) {
		this.shiftUpdatedOn = shiftUpdatedOn;
	}
	
	

	public String getDesignationId() {
		return designationId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public String getDesignationOrder() {
		return designationOrder;
	}

	public void setDesignationOrder(String designationOrder) {
		this.designationOrder = designationOrder;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDesignationStatus() {
		return designationStatus;
	}

	public void setDesignationStatus(String designationStatus) {
		this.designationStatus = designationStatus;
	}
	
	

	public String getDesignationCreatedBy() {
		return designationCreatedBy;
	}

	public void setDesignationCreatedBy(String designationCreatedBy) {
		this.designationCreatedBy = designationCreatedBy;
	}

	public String getDesignationUpdatedBy() {
		return designationUpdatedBy;
	}

	public void setDesignationUpdatedBy(String designationUpdatedBy) {
		this.designationUpdatedBy = designationUpdatedBy;
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

	public String getShiftDepartmentName() {
		return shiftDepartmentName;
	}

	public void setShiftDepartmentName(String shiftDepartmentName) {
		this.shiftDepartmentName = shiftDepartmentName;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationDivision() {
		return OrganizationDivision;
	}

	public void setOrganizationDivision(String organizationDivision) {
		OrganizationDivision = organizationDivision;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentOrder() {
		return departmentOrder;
	}

	public void setDepartmentOrder(String departmentOrder) {
		this.departmentOrder = departmentOrder;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentStatus() {
		return departmentStatus;
	}

	public void setDepartmentStatus(String departmentStatus) {
		this.departmentStatus = departmentStatus;
	}

	public String getDepartmentCreatedBy() {
		return departmentCreatedBy;
	}

	public void setDepartmentCreatedBy(String departmentCreatedBy) {
		this.departmentCreatedBy = departmentCreatedBy;
	}

	public String getOrganizationNames() {
		return OrganizationNames;
	}

	public void setOrganizationNames(String organizationNames) {
		OrganizationNames = organizationNames;
	}

	public String getOrganizationDivisions() {
		return OrganizationDivisions;
	}

	public void setOrganizationDivisions(String organizationDivisions) {
		OrganizationDivisions = organizationDivisions;
	}

	public String getSubDepartmentId() {
		return subDepartmentId;
	}

	public void setSubDepartmentId(String subDepartmentId) {
		this.subDepartmentId = subDepartmentId;
	}

	public String getSubDpartId() {
		return subDpartId;
	}

	public void setSubDpartId(String subDpartId) {
		this.subDpartId = subDpartId;
	}

	public String getSubDepartmentName() {
		return subDepartmentName;
	}

	public void setSubDepartmentName(String subDepartmentName) {
		this.subDepartmentName = subDepartmentName;
	}

	public String getSubdepartmentDept() {
		return subdepartmentDept;
	}

	public void setSubdepartmentDept(String subdepartmentDept) {
		this.subdepartmentDept = subdepartmentDept;
	}

	public String getSubDepartmentStatus() {
		return subDepartmentStatus;
	}

	public void setSubDepartmentStatus(String subDepartmentStatus) {
		this.subDepartmentStatus = subDepartmentStatus;
	}

	public String getSubDepartmentCreatedBy() {
		return subDepartmentCreatedBy;
	}

	public void setSubDepartmentCreatedBy(String subDepartmentCreatedBy) {
		this.subDepartmentCreatedBy = subDepartmentCreatedBy;
	}

	public String getShiftSubDepartmentId() {
		return shiftSubDepartmentId;
	}

	public void setShiftSubDepartmentId(String shiftSubDepartmentId) {
		this.shiftSubDepartmentId = shiftSubDepartmentId;
	}

	public String getShiftSubDepartmentName() {
		return shiftSubDepartmentName;
	}

	public void setShiftSubDepartmentName(String shiftSubDepartmentName) {
		this.shiftSubDepartmentName = shiftSubDepartmentName;
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

