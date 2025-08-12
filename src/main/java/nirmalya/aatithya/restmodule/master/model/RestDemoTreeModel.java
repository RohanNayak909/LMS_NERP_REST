package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.math.BigInteger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestDemoTreeModel {
	
	private String demoId;
	private String demoName;
	private String demoDesc;
	private String demoStatus;
	private String parentId;
	private String createdBy;
	private String demoLevel;
	private String parentName;
	private BigInteger nodeCount;

	public RestDemoTreeModel() {
		super();
	}
	public RestDemoTreeModel(Object demoId, Object demoName, Object demoDesc, Object demoStatus,Object parentId,Object createdBy,
			Object demoLevel, Object parentName,Object nodeCount) {
		super();
		
		this.demoId =(String) demoId;
		this.demoName =(String) demoName;
		this.demoDesc =(String) demoDesc;
		this.demoStatus =(String) demoStatus;
		this.parentId =(String) parentId;
		this.createdBy = (String)createdBy;
		this.demoLevel = (String)demoLevel;
		this.parentName =(String) parentName;
		this.nodeCount = (BigInteger) nodeCount;
	}

	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public BigInteger getNodeCount() {
		return nodeCount;
	}
	public void setNodeCount(BigInteger nodeCount) {
		this.nodeCount = nodeCount;
	}
	public String getDemoId() {
		return demoId;
	}
	public void setDemoId(String demoId) {
		this.demoId = demoId;
	}
	public String getDemoName() {
		return demoName;
	}
	public void setDemoName(String demoName) {
		this.demoName = demoName;
	}
	public String getDemoDesc() {
		return demoDesc;
	}
	public void setDemoDesc(String demoDesc) {
		this.demoDesc = demoDesc;
	}
	public String getDemoStatus() {
		return demoStatus;
	}
	public void setDemoStatus(String demoStatus) {
		this.demoStatus = demoStatus;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDemoLevel() {
		return demoLevel;
	}
	public void setDemoLevel(String demoLevel) {
		this.demoLevel = demoLevel;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
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
