package nirmalya.aatithya.restmodule.samudyamproduction.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;


public class RestPatternMasterModel {
	private String patternId;
	private String projectName;
	private String itemName;
	private String date;
	private String height;
	private String width; 
	private String desc; 
	private String status;
	private String approvedBy;
	private String approvedDate;
	private String createdBy;
	private String organization;
	private String orgDivision;
	private List<InventoryVendorDocumentModel> documentList;
	public RestPatternMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestPatternMasterModel(Object patternId, Object projectName, Object itemName, Object date, Object height, Object width,
			Object desc, Object status,Object approvedBy,Object approvedDate, Object createdBy) {
		super();

		this.patternId = (String) patternId;
		this.projectName = (String) projectName;
		this.itemName = (String) itemName;
		this.date = (String) date;
		this.height = (String) height;
		this.width = (String) width;
		this.desc = (String) desc;
		this.status = (String) status;
		this.approvedBy = (String) approvedBy;
		this.approvedDate = (String) approvedDate;
		this.createdBy = (String) createdBy;

	}
	public String getPatternId() {
		return patternId;
	}
	public void setPatternId(String patternId) {
		this.patternId = patternId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}
	public String getApprovedDate() {
		return approvedDate;
	}
	public void setApprovedDate(String approvedDate) {
		this.approvedDate = approvedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public List<InventoryVendorDocumentModel> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<InventoryVendorDocumentModel> documentList) {
		this.documentList = documentList;
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
