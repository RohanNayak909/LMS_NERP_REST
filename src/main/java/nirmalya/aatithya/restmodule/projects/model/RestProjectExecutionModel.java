package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestProjectExecutionModel {
	private String executionId;
	private List<RestProjectCategoryModel> categoryNameList;
	private String createdBy;
	private String OrganizationName;
	private String OrganizationDivision;
	private String categoryId;
	private String categoryName;
	private String categoryDesc;
	private String categoryStatus;
	private String parentId;
	private String catLevel;
	private String parentName;
	private BigInteger nodeCount;
	private String projectId;
	private String nodeSlNo;
	private String planningId;
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
	private MultipartFile mulFile;
	private String extension;
	private String reqid;
	private String notes;
	private String slNo;
	private int Id;
	private String actualStartDate;
	private String actualEndDate;
	private String qtyRecieved;
	private String preced;
	private String feedBack;
	
	
	private String slipage;
	private String dateReceive;
	private String varienceQuant;
	private String varienceHour;
	private String planCost;
	private String actCost;
	private String varienceRup;
	private String assignToId;
	
	private String estimatedCost;
	private String baseline;
	private String actualCost;
	private String projectStatus;
	private String duration;
	private String budgetCategoryId;
	private String budgetSubCategoryId;
	
	private String uom;
	private String unitPrice;
	private String totalAmnt;
	private String areaAcer;
	private String areaAssigned;
	private String quantity;
	private String projectName;
	
	//FOR PDF 
	
		private String itemId;
		//private String slNo;
		private String itemName;
		private String unitName;
		private String unitRate;
		//private String quantity;
		//private String totalAmnt;
		private String billQuantity;
		private String prevQuantity;
		private String cumulativeQty;
		private String billAmnt;
		private String prevAmnt;
		private String cumulativeAmnt;
	
	public RestProjectExecutionModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MultipartFile getMulFile() {
		return mulFile;
	}

	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getPreced() {
		return preced;
	}


	public void setPreced(String preced) {
		this.preced = preced;
	}




	public String getSlNo() {
		return slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
	}

	public RestProjectExecutionModel(Object executionId, Object projectId) {
		super();
		this.executionId = (String) executionId;
		this.projectId = (String) projectId;
	}
	
	

	public String getBudgetCategoryId() {
		return budgetCategoryId;
	}

	public void setBudgetCategoryId(String budgetCategoryId) {
		this.budgetCategoryId = budgetCategoryId;
	}

	public String getBudgetSubCategoryId() {
		return budgetSubCategoryId;
	}

	public void setBudgetSubCategoryId(String budgetSubCategoryId) {
		this.budgetSubCategoryId = budgetSubCategoryId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getTotalAmnt() {
		return totalAmnt;
	}

	public void setTotalAmnt(String totalAmnt) {
		this.totalAmnt = totalAmnt;
	}

	public RestProjectExecutionModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, 
			Object parentName,Object nodeCount,Object projectId,Object nodeSlNo,Object executionId,Object startDate,
			Object endDate, Object assignedTo, Object maintype, Object qtyNeeded, Object plannedHrs, Object actualHrs,
			Object requiDate, Object needDate, Object fileAttach, Object reqid, Object notes,Object preced,Object assignToId) {
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
		this.assignToId = (String) assignToId;
	}
	
	
	
	public RestProjectExecutionModel(Object categoryId, Object categoryName, Object categoryDesc, Object categoryStatus,
			Object parentId, Object createdBy, Object catLevel, 
			Object parentName,Object nodeCount,Object projectId,Object nodeSlNo,Object executionId,Object startDate,
			Object endDate, Object actualStartDate, Object actualEndDate, Object assignedTo, Object qtyNeeded, Object qtyRecieved,
			Object plannedHrs, Object actualHrs, Object varienceHour, Object planCost, Object actCost,Object varienceRup
			,Object needDate,Object dateReceive,Object fileAttach,Object notes,Object varienceQuant
			,Object slipage) {
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
		this.actualStartDate = (String) actualStartDate;
		this.actualEndDate = (String) actualEndDate;
		this.assignedTo = (String) assignedTo;
		this.qtyNeeded = (String) qtyNeeded;
		this.qtyRecieved = (String) qtyRecieved;
		this.plannedHrs = (String) plannedHrs;
		this.actualHrs = (String) actualHrs;
		this.varienceHour = (String) varienceHour;
		this.planCost = (String) planCost;
		this.actCost = (String) actCost;
		this.varienceRup = (String) varienceRup;
		this.needDate = (String) needDate;
		this.dateReceive = (String) dateReceive;
		this.fileAttach = (String) fileAttach;
		this.notes = (String) notes;
		this.varienceQuant = (String) varienceQuant;
		this.slipage = (String) slipage;
	}
	public RestProjectExecutionModel(Object slNo, Object categoryId, Object projectId,
			Object categoryName,Object startDate,Object endDate,Object actualStartDate,
			Object actualEndDate, Object maintype, Object assignedTo, Object qtyNeeded, 
			Object qtyRecieved,Object plannedHrs,Object actualHrs,Object fileAttach,Object notes, Object executionId,Object feedBack,Object  assignToId) {
		super();
		this.slNo = (String) slNo;
		this.categoryId = (String) categoryId;
		this.projectId = (String) projectId;
		this.categoryName = (String) categoryName;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.actualStartDate = (String) actualStartDate;
		this.actualEndDate = (String) actualEndDate;
		this.maintype = (String) maintype;
		this.assignedTo = (String) assignedTo;
		this.qtyNeeded = (String) qtyNeeded;
		this.qtyRecieved = (String) qtyRecieved;
		this.plannedHrs = (String) plannedHrs;
		this.actualHrs = (String) actualHrs;
		this.fileAttach = (String) fileAttach;
		this.notes = (String) notes;
		this.executionId = (String) executionId;
		this.feedBack = (String) feedBack;
		this.assignToId = (String) assignToId;;
	}
	//
	public RestProjectExecutionModel(Object categoryId, Object categoryName,Object assignedTo,
			 Object startDate, Object endDate,Object actualStartDate, Object actualEndDate
			 ,Object slipage,Object qtyNeeded,Object qtyRecieved,Object varienceQuant,
			 Object plannedHrs, Object actualHrs,
			 Object varienceHour, Object planCost,Object actCost,
			 Object varienceRup, Object needDate,
			 Object dateReceive, Object fileAttach,Object notes) {
		super();
		this.categoryId = (String) categoryId;
		this.categoryName = (String) categoryName;
		this.assignedTo = (String) assignedTo;
		this.startDate = (String) startDate;
		this.endDate = (String) endDate;
		this.actualStartDate = (String) actualStartDate;
		this.actualEndDate = (String) actualEndDate;
		this.slipage = (String) slipage;
		this.qtyNeeded = (String) qtyNeeded;
		this.qtyRecieved = (String) qtyRecieved;
		this.varienceQuant = (String) varienceQuant;
		this.plannedHrs = (String) plannedHrs;
		this.actualHrs = (String) actualHrs;
		this.varienceHour = (String) varienceHour;
		this.planCost = (String) planCost;
		this.actCost = (String) actCost;
		this.varienceRup = (String) varienceRup;
		this.needDate = (String) needDate;
		this.dateReceive = (String) dateReceive;
		this.fileAttach = (String) fileAttach;
		this.notes = (String) notes;
		
		
		
	}
	//
	public String getExecutionId() {
		return executionId;
	}





	public void setExecutionId(String executionId) {
		this.executionId = executionId;
	}





	public List<RestProjectCategoryModel> getCategoryNameList() {
		return categoryNameList;
	}





	public void setCategoryNameList(List<RestProjectCategoryModel> categoryNameList) {
		this.categoryNameList = categoryNameList;
	}





	public String getCreatedBy() {
		return createdBy;
	}





	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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


	public String getFeedBack() {
		return feedBack;
	}


	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	
	


	public String getSlipage() {
		return slipage;
	}

	public void setSlipage(String slipage) {
		this.slipage = slipage;
	}

	public String getVarienceQuant() {
		return varienceQuant;
	}

	public void setVarienceQuant(String varienceQuant) {
		this.varienceQuant = varienceQuant;
	}

	public String getVarienceHour() {
		return varienceHour;
	}

	public void setVarienceHour(String varienceHour) {
		this.varienceHour = varienceHour;
	}

	public String getPlanCost() {
		return planCost;
	}

	public void setPlanCost(String planCost) {
		this.planCost = planCost;
	}

	public String getActCost() {
		return actCost;
	}

	public void setActCost(String actCost) {
		this.actCost = actCost;
	}

	public String getVarienceRup() {
		return varienceRup;
	}

	public void setVarienceRup(String varienceRup) {
		this.varienceRup = varienceRup;
	}
	

	public String getDateReceive() {
		return dateReceive;
	}

	public void setDateReceive(String dateReceive) {
		this.dateReceive = dateReceive;
	}
	
	

	public String getAssignToId() {
		return assignToId;
	}

	public void setAssignToId(String assignToId) {
		this.assignToId = assignToId;
	}
	
	
	

	public String getPlanningId() {
		return planningId;
	}

	public void setPlanningId(String planningId) {
		this.planningId = planningId;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getBaseline() {
		return baseline;
	}

	public void setBaseline(String baseline) {
		this.baseline = baseline;
	}

	public String getActualCost() {
		return actualCost;
	}

	public void setActualCost(String actualCost) {
		this.actualCost = actualCost;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAreaAcer() {
		return areaAcer;
	}

	public void setAreaAcer(String areaAcer) {
		this.areaAcer = areaAcer;
	}

	public String getAreaAssigned() {
		return areaAssigned;
	}

	public void setAreaAssigned(String areaAssigned) {
		this.areaAssigned = areaAssigned;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitRate() {
		return unitRate;
	}

	public void setUnitRate(String unitRate) {
		this.unitRate = unitRate;
	}

	public String getBillQuantity() {
		return billQuantity;
	}

	public void setBillQuantity(String billQuantity) {
		this.billQuantity = billQuantity;
	}

	public String getPrevQuantity() {
		return prevQuantity;
	}

	public void setPrevQuantity(String prevQuantity) {
		this.prevQuantity = prevQuantity;
	}

	public String getCumulativeQty() {
		return cumulativeQty;
	}

	public void setCumulativeQty(String cumulativeQty) {
		this.cumulativeQty = cumulativeQty;
	}

	public String getBillAmnt() {
		return billAmnt;
	}

	public void setBillAmnt(String billAmnt) {
		this.billAmnt = billAmnt;
	}

	public String getPrevAmnt() {
		return prevAmnt;
	}

	public void setPrevAmnt(String prevAmnt) {
		this.prevAmnt = prevAmnt;
	}

	public String getCumulativeAmnt() {
		return cumulativeAmnt;
	}

	public void setCumulativeAmnt(String cumulativeAmnt) {
		this.cumulativeAmnt = cumulativeAmnt;
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
