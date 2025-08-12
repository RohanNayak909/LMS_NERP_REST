package nirmalya.aatithya.restmodule.budget.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestMonitoringBudgetModel {
	private String groupId;
	private String id;
	private String particulars;
	private String departmentId;
	private String departmentName;
	private String fyId;
	private String fyName;
	
	
	private Double madeBudgetAmnt;
	private Double actualBudgetAmnt;
	private Double varienceBudgetAmnt;
	
	private Double madeBudgetAmntQ1;
	private Double actualBudgetAmntQ1;
	private Double varienceBudgetAmntQ1;
	
	private Double madeBudgetAmntQ2;
	private Double actualBudgetAmntQ2;
	private Double varienceBudgetAmntQ2;
	
	private Double madeBudgetAmntQ3;
	private Double actualBudgetAmntQ3;
	private Double varienceBudgetAmntQ3;
	
	private Double madeBudgetAmntQ4;
	private Double actualBudgetAmntQ4;
	private Double varienceBudgetAmntQ4;
	private String remark;
	
	private String parentId;
	private String parentName;
	private String treeLevel;
	private String quarter;
	private String groupType;
	private String childAvailable;
	
	
	
	public RestMonitoringBudgetModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RestMonitoringBudgetModel(Object id,Object particulars,
			Object departmentId, Object departmentName, Object fyId,			
			Object fyName, Object madeBudgetAmnt, Object actualBudgetAmnt,Object varienceBudgetAmnt, 
			Object madeBudgetAmntQ1, Object actualBudgetAmntQ1,	Object varienceBudgetAmntQ1,
			Object madeBudgetAmntQ2, Object actualBudgetAmntQ2,	Object varienceBudgetAmntQ2,
			Object madeBudgetAmntQ3, Object actualBudgetAmntQ3,	Object varienceBudgetAmntQ3,
			Object madeBudgetAmntQ4, Object actualBudgetAmntQ4,	Object varienceBudgetAmntQ4,
			Object parentId, Object parentName,	Object treeLevel,
			Object quarter, Object groupType,	Object childAvailable
			) {
		super();
		this.id = (String) id;
		this.particulars = (String) particulars;
		this.departmentId = (String) departmentId;
		this.departmentName = (String) departmentName;
		this.fyId = (String) fyId;		
		this.fyName = (String) fyName;
		
		
		this.madeBudgetAmnt = (Double) madeBudgetAmnt;
		this.actualBudgetAmnt = (Double) actualBudgetAmnt;
		this.varienceBudgetAmnt = (Double) varienceBudgetAmnt;
		
		this.madeBudgetAmntQ1 = (Double) madeBudgetAmntQ1;		
		this.actualBudgetAmntQ1 = (Double) actualBudgetAmntQ1;
		this.varienceBudgetAmntQ1 = (Double) varienceBudgetAmntQ1;
		
		this.madeBudgetAmntQ2 = (Double) madeBudgetAmntQ2;		
		this.actualBudgetAmntQ2 = (Double) actualBudgetAmntQ2;
		this.varienceBudgetAmntQ2 = (Double) varienceBudgetAmntQ2;
		
		this.madeBudgetAmntQ3 = (Double) madeBudgetAmntQ3;		
		this.actualBudgetAmntQ3 = (Double) actualBudgetAmntQ3;
		this.varienceBudgetAmntQ3 = (Double) varienceBudgetAmntQ3;
		
		this.madeBudgetAmntQ4 = (Double) madeBudgetAmntQ4;		
		this.actualBudgetAmntQ4 = (Double) actualBudgetAmntQ4;
		this.varienceBudgetAmntQ4 = (Double) varienceBudgetAmntQ4;
		
		this.parentId = (String) parentId;
		this.parentName = (String) parentName;
		this.treeLevel = (String) treeLevel;
		this.quarter = (String) quarter;
		this.groupType = (String) groupType;
		this.childAvailable = (String) childAvailable;
		
	}
	
	
	public RestMonitoringBudgetModel(Object groupId,Object particulars,
			Object departmentId, Object departmentName, Object fyId,			
			Object fyName, Object madeBudgetAmnt, Object remark,
			Object madeBudgetAmntQ1,Object madeBudgetAmntQ2, 
			Object madeBudgetAmntQ3, Object madeBudgetAmntQ4) {
		super();
		this.groupId = (String) groupId;
		this.particulars = (String) particulars;
		this.departmentId = (String) departmentId;
		this.departmentName = (String) departmentName;
		this.fyId = (String) fyId;		
		this.fyName = (String) fyName;
		
		
		this.madeBudgetAmnt = (Double) madeBudgetAmnt;
		this.remark = (String) remark;
		this.madeBudgetAmntQ1 = (Double) madeBudgetAmntQ1;		
		
		this.madeBudgetAmntQ2 = (Double) madeBudgetAmntQ2;	
		
		this.madeBudgetAmntQ3 = (Double) madeBudgetAmntQ3;	
		
		this.madeBudgetAmntQ4 = (Double) madeBudgetAmntQ4;	
		
	}
	
	
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public String getParentName() {
		return parentName;
	}


	public void setParentName(String parentName) {
		this.parentName = parentName;
	}





	public String getTreeLevel() {
		return treeLevel;
	}


	public void setTreeLevel(String treeLevel) {
		this.treeLevel = treeLevel;
	}


	public String getQuarter() {
		return quarter;
	}


	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}


	public String getGroupType() {
		return groupType;
	}


	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}


	public String getChildAvailable() {
		return childAvailable;
	}


	public void setChildAvailable(String childAvailable) {
		this.childAvailable = childAvailable;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Double getMadeBudgetAmntQ4() {
		return madeBudgetAmntQ4;
	}


	public void setMadeBudgetAmntQ4(Double madeBudgetAmntQ4) {
		this.madeBudgetAmntQ4 = madeBudgetAmntQ4;
	}


	public Double getActualBudgetAmntQ4() {
		return actualBudgetAmntQ4;
	}


	public void setActualBudgetAmntQ4(Double actualBudgetAmntQ4) {
		this.actualBudgetAmntQ4 = actualBudgetAmntQ4;
	}


	public Double getVarienceBudgetAmntQ4() {
		return varienceBudgetAmntQ4;
	}


	public void setVarienceBudgetAmntQ4(Double varienceBudgetAmntQ4) {
		this.varienceBudgetAmntQ4 = varienceBudgetAmntQ4;
	}


	public String getGroupId() {
		return groupId;
	}


	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}


	public String getParticulars() {
		return particulars;
	}


	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}


	public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getFyId() {
		return fyId;
	}


	public void setFyId(String fyId) {
		this.fyId = fyId;
	}


	public String getFyName() {
		return fyName;
	}


	public void setFyName(String fyName) {
		this.fyName = fyName;
	}
	


	public Double getMadeBudgetAmnt() {
		return madeBudgetAmnt;
	}


	public void setMadeBudgetAmnt(Double madeBudgetAmnt) {
		this.madeBudgetAmnt = madeBudgetAmnt;
	}


	public Double getActualBudgetAmnt() {
		return actualBudgetAmnt;
	}


	public void setActualBudgetAmnt(Double actualBudgetAmnt) {
		this.actualBudgetAmnt = actualBudgetAmnt;
	}


	public Double getVarienceBudgetAmnt() {
		return varienceBudgetAmnt;
	}


	public void setVarienceBudgetAmnt(Double varienceBudgetAmnt) {
		this.varienceBudgetAmnt = varienceBudgetAmnt;
	}


	public Double getMadeBudgetAmntQ1() {
		return madeBudgetAmntQ1;
	}


	public void setMadeBudgetAmntQ1(Double madeBudgetAmntQ1) {
		this.madeBudgetAmntQ1 = madeBudgetAmntQ1;
	}


	public Double getActualBudgetAmntQ1() {
		return actualBudgetAmntQ1;
	}


	public void setActualBudgetAmntQ1(Double actualBudgetAmntQ1) {
		this.actualBudgetAmntQ1 = actualBudgetAmntQ1;
	}


	public Double getVarienceBudgetAmntQ1() {
		return varienceBudgetAmntQ1;
	}


	public void setVarienceBudgetAmntQ1(Double varienceBudgetAmntQ1) {
		this.varienceBudgetAmntQ1 = varienceBudgetAmntQ1;
	}


	public Double getMadeBudgetAmntQ2() {
		return madeBudgetAmntQ2;
	}


	public void setMadeBudgetAmntQ2(Double madeBudgetAmntQ2) {
		this.madeBudgetAmntQ2 = madeBudgetAmntQ2;
	}


	public Double getActualBudgetAmntQ2() {
		return actualBudgetAmntQ2;
	}


	public void setActualBudgetAmntQ2(Double actualBudgetAmntQ2) {
		this.actualBudgetAmntQ2 = actualBudgetAmntQ2;
	}


	public Double getVarienceBudgetAmntQ2() {
		return varienceBudgetAmntQ2;
	}


	public void setVarienceBudgetAmntQ2(Double varienceBudgetAmntQ2) {
		this.varienceBudgetAmntQ2 = varienceBudgetAmntQ2;
	}


	public Double getMadeBudgetAmntQ3() {
		return madeBudgetAmntQ3;
	}


	public void setMadeBudgetAmntQ3(Double madeBudgetAmntQ3) {
		this.madeBudgetAmntQ3 = madeBudgetAmntQ3;
	}


	public Double getActualBudgetAmntQ3() {
		return actualBudgetAmntQ3;
	}


	public void setActualBudgetAmntQ3(Double actualBudgetAmntQ3) {
		this.actualBudgetAmntQ3 = actualBudgetAmntQ3;
	}


	public Double getVarienceBudgetAmntQ3() {
		return varienceBudgetAmntQ3;
	}


	public void setVarienceBudgetAmntQ3(Double varienceBudgetAmntQ3) {
		this.varienceBudgetAmntQ3 = varienceBudgetAmntQ3;
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
