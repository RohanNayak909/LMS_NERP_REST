package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProjectCategoryModel {
	private String categoryId;
	private String categoryName;
	private String categoryDesc;
	private String categoryStatus;
	private String parentId;
	private String createdBy;
	private String catLevel;
	private String parentName;
	private BigInteger nodeCount;
	private String OrganizationName;
	private String OrganizationDivision;
	private String projectId;
	private String nodeSlNo;
	private String executionId;
	private String phase;
	private String startDate;
	private String endDate;
	private String assignedTo;
	private String maintype;
	private String qtyNeeded;
	private String plannedHrs;
	private String actualHrs;
	private String requiDate;
	private String needDate;
	private String fileAttach;
	private String reqid;
	private String notes;
	private String SlNo;
	private int Id;
	private String actualStartDate;
	private String actualEndDate;
	private String qtyRecieved;
	private String preced;
	
	private String subcategoryId;
	private String subcategoryName;
	
	public RestProjectCategoryModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, Object parentName, Object nodeCount) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.categoryDesc = (String) categoryDesc;
		this.categoryStatus = (String) categoryStatus;
		this.parentId = (String) parentId;
		this.createdBy = (String) createdBy;
		this.catLevel = (String) catLevel;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
	}
	
	public RestProjectCategoryModel(Object categoryId, Object categoryName,
			Object parentId, Object parentName, Object nodeCount, Object catLevel) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.parentId = (String) parentId;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
		this.catLevel = (String) catLevel;
	}
	public RestProjectCategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RestProjectCategoryModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, 
			Object parentName,Object nodeCount,Object projectId,Object nodeSlNo,Object executionId) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.categoryDesc = (String) categoryDesc;
		this.categoryStatus = (String) categoryStatus;
		this.parentId = (String) parentId;
		this.createdBy = (String) createdBy;
		this.catLevel = (String) catLevel;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
		this.projectId = (String) projectId;
		this.nodeSlNo = (String) nodeSlNo;
		this.executionId = (String) executionId;
	}
	
	
	
	public RestProjectCategoryModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, 
			Object parentName,Object nodeCount,Object projectId,Object nodeSlNo,Object executionId,Object startDate,
			Object endDate, Object assignedTo, Object maintype, Object qtyNeeded, Object plannedHrs, Object actualHrs,
			Object requiDate, Object needDate, Object fileAttach, Object reqid, Object notes,Object preced) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.categoryDesc = (String) categoryDesc;
		this.categoryStatus = (String) categoryStatus;
		this.parentId = (String) parentId;
		this.createdBy = (String) createdBy;
		this.catLevel = (String) catLevel;
		this.parentName = (String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
		this.projectId = (String) projectId;
		this.nodeSlNo = (String) nodeSlNo;
		this.executionId = (String) executionId;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.assignedTo = (String) assignedTo;
		this.maintype = (String) maintype;
		this.qtyNeeded = (String) qtyNeeded;
		this.plannedHrs = (String) plannedHrs;
		this.actualHrs = (String) actualHrs;
		this.requiDate = (String) requiDate;
		this.needDate = (String) needDate;
		this.fileAttach = (String) fileAttach;
		this.reqid = (String) reqid;
		this.notes = (String) notes;
		this.preced = (String) preced;
	}



	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDesc() {
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(String categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCatLevel() {
		return catLevel;
	}
	public void setCatLevel(String catLevel) {
		this.catLevel = catLevel;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
	

	public String getExecutionId() {
		return executionId;
	}

	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}

	public BigInteger getNodeCount() {
		return nodeCount;
	}



	public void setNodeCount(BigInteger nodeCount) {
		this.nodeCount = nodeCount;
	}



	public String getProjectId() {
		return projectId;
	}



	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}



	public String getNodeSlNo() {
		return nodeSlNo;
	}



	public void setNodeSlNo(String nodeSlNo) {
		this.nodeSlNo = nodeSlNo;
	}



	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getMaintype() {
		return maintype;
	}

	public void setMaintype(String maintype) {
		this.maintype = maintype;
	}

	public String getQtyNeeded() {
		return qtyNeeded;
	}

	public void setQtyNeeded(String qtyNeeded) {
		this.qtyNeeded = qtyNeeded;
	}

	public String getPlannedHrs() {
		return plannedHrs;
	}

	public void setPlannedHrs(String plannedHrs) {
		this.plannedHrs = plannedHrs;
	}

	public String getActualHrs() {
		return actualHrs;
	}

	public void setActualHrs(String actualHrs) {
		this.actualHrs = actualHrs;
	}

	public String getRequiDate() {
		return requiDate;
	}

	public void setRequiDate(String requiDate) {
		this.requiDate = requiDate;
	}

	public String getNeedDate() {
		return needDate;
	}

	public void setNeedDate(String needDate) {
		this.needDate = needDate;
	}

	public String getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(String fileAttach) {
		this.fileAttach = fileAttach;
	}

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSlNo() {
		return SlNo;
	}

	public void setSlNo(String slNo) {
		SlNo = slNo;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(String actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(String actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getQtyRecieved() {
		return qtyRecieved;
	}

	public void setQtyRecieved(String qtyRecieved) {
		this.qtyRecieved = qtyRecieved;
	}

	public String getPreced() {
		return preced;
	}

	public void setPreced(String preced) {
		this.preced = preced;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
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
