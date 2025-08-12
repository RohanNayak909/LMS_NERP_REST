package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CloseOutRestModel {

	private String projectId;
	private String pname;
	private String location;
	private String customer;
	private String pPdate;
	private String pCdate;
	private String status;
	private String CreatedOn;
	private String CreatedBy;
	private String UpdatedOn;
	private String UpdatedBy;
	private String DeletedFlag;
	private String OrganizationName;
	private String OrganizationDivision;
	
	private String closeOutId;	
	private String winorissue;
	private String description;
	private String impact;
	private String futureproject;
	private String action;

	

	public CloseOutRestModel() {
		super();
	}

	public CloseOutRestModel(Object projectId, Object pname, Object location, Object customer, Object pPdate,
			Object pCdate, Object status, Object CreatedOn, Object CreatedBy, Object UpdatedOn, Object UpdatedBy,
			Object DeletedFlag, Object OrganizationName, Object OrganizationDivision) {
		super();

		this.projectId = (String) projectId;
		this.pname = (String) pname;
		this.location = (String) location;
		this.customer = (String) customer;
		this.pPdate = (String) pPdate;
		this.pCdate = (String) pCdate;
		this.status = (String) status;
		this.CreatedOn = (String) CreatedOn;
		this.CreatedBy = (String) CreatedBy;
		this.UpdatedOn = (String) UpdatedOn;
		this.DeletedFlag = (String) DeletedFlag;
		this.UpdatedBy = (String) UpdatedBy;
		this.OrganizationName = (String) OrganizationName;
		this.OrganizationDivision = (String) OrganizationDivision;
	}
	
	
	public CloseOutRestModel(Object closeOutId,Object winorissue, Object description, Object impact, Object futureproject,
			Object action) {
		super();
		
		this.closeOutId = (String)closeOutId;
		this.winorissue = (String)winorissue;
		this.description = (String)description;
		this.impact = (String)impact;
		this.futureproject = (String)futureproject;
		this.action = (String)action;
	}
	
	public CloseOutRestModel(Object winorissue, Object description, Object impact, Object futureproject,
			Object action) {
		super();
		
		this.winorissue = (String)winorissue;
		this.description = (String)description;
		this.impact = (String)impact;
		this.futureproject = (String)futureproject;
		this.action = (String)action;
	}
	
	private List<CloseOutRestModel> projectList ;
	
	public List<CloseOutRestModel> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<CloseOutRestModel> projectList) {
		this.projectList = projectList;
	}

	public String getCloseOutId() {
		return closeOutId;
	}

	public void setCloseOutId(String closeOutId) {
		this.closeOutId = closeOutId;
	}
	
	public String getWinorissue() {
		return winorissue;
	}

	public void setWinorissue(String winorissue) {
		this.winorissue = winorissue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getFutureproject() {
		return futureproject;
	}

	public void setFutureproject(String futureproject) {
		this.futureproject = futureproject;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getpPdate() {
		return pPdate;
	}

	public void setpPdate(String pPdate) {
		this.pPdate = pPdate;
	}

	public String getpCdate() {
		return pCdate;
	}

	public void setpCdate(String pCdate) {
		this.pCdate = pCdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		UpdatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public String getDeletedFlag() {
		return DeletedFlag;
	}

	public void setDeletedFlag(String deletedFlag) {
		DeletedFlag = deletedFlag;
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
