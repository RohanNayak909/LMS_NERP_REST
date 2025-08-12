package nirmalya.aatithya.restmodule.account.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataSetAccountTree {
private String groupId;

private String groupName;

private String levelName;

private String parentName;

private String parentId;

private String orgName;

private String orgDivision;

private String amount;

private String totalcreditAmount;

private String totalDebitAmount;

private String natureOfGroup;

private String childAmount;

private String subChildAmount;

private String subChildDebitAmount;
private String subChildCreditAmount;

public DataSetAccountTree() {
super();
// TODO Auto-generated constructor stub
}
public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName,Object parentId) {
super();
try {
this.groupId = (String) groupId;
} catch (Exception e) {
e.printStackTrace();
}

try {
this.groupName = (String) groupName;
} catch (Exception e) {
e.printStackTrace();
}

try {
this.levelName = (String) levelName;
} catch (Exception e) {
e.printStackTrace();
}

try {
this.parentName = (String) parentName;
} catch (Exception e) {
e.printStackTrace();
}



try {
this.parentId = (String) parentId;
} catch (Exception e) {
e.printStackTrace();
}



}

public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName,Object parentId, Object natureOfGroup, Object amount) {
super();
	this.groupId = (String) groupId;
	this.groupName = (String) groupName;
	this.levelName = (String) levelName;
	this.parentName = (String) parentName;
	this.parentId = (String) parentId;
	this.natureOfGroup = (String) natureOfGroup;
	this.amount = (String) amount;
}

	
	  public DataSetAccountTree(Object groupId, Object groupName) { this.groupId =
	  (String)groupId; this.groupName = (String)groupName; }
	


public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName) {
	this.groupId = (String)groupId;
	this.groupName = (String)groupName;
	this.levelName = (String)levelName;
	this.parentName = (String)parentName;
	
}


public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName ,Object amount,Object childAmount,Object subChildAmount,Object orgName,Object orgDivision) {
	this.groupId = (String)groupId;
	this.groupName = (String)groupName;
	this.levelName = (String)levelName;
	this.parentName = (String)parentName;
	this.amount = (String)amount;
	this.childAmount = (String)childAmount;
	this.subChildAmount=(String)subChildAmount;
	this.orgName = (String)orgName;
	this.orgDivision = (String)orgDivision;
	
}

public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName ,Object amount,Object childAmount,Object totalDebitAmount , Object totalcreditAmount) {
	this.groupId = (String)groupId;
	this.groupName = (String)groupName;
	this.levelName = (String)levelName;
	this.parentName = (String)parentName;
	this.amount = (String)amount;
	this.childAmount = (String)childAmount;
	this.totalDebitAmount = (String)totalDebitAmount;
	this.totalcreditAmount = (String)totalcreditAmount;
	
}


public DataSetAccountTree(Object groupId, Object groupName,Object levelName,Object parentName ,Object amount,Object childAmount,Object totalDebitAmount , Object totalcreditAmount,Object subChildCreditAmount,Object subChildDebitAmount) {
	this.groupId = (String)groupId;
	this.groupName = (String)groupName;
	this.levelName = (String)levelName;
	this.parentName = (String)parentName;
	this.amount = (String)amount;
	this.childAmount = (String)childAmount;
	this.totalDebitAmount = (String)totalDebitAmount;
	this.totalcreditAmount = (String)totalcreditAmount;
	this.subChildCreditAmount = (String)subChildCreditAmount;
	this.subChildDebitAmount = (String)subChildDebitAmount;
	
}





public String getParentId() {
return parentId;
}
public void setParentId(String parentId) {
this.parentId = parentId;
}
public String getGroupId() {
return groupId;
}
public void setGroupId(String groupId) {
this.groupId = groupId;
}
public String getGroupName() {
return groupName;
}
public void setGroupName(String groupName) {
this.groupName = groupName;
}
public String getLevelName() {
return levelName;
}
public void setLevelName(String levelName) {
this.levelName = levelName;
}
public String getParentName() {
return parentName;
}
public void setParentName(String parentName) {
this.parentName = parentName;
}
public String getOrgName() {
	return orgName;
}
public void setOrgName(String orgName) {
	this.orgName = orgName;
}
public String getOrgDivision() {
	return orgDivision;
}
public void setOrgDivision(String orgDivision) {
	this.orgDivision = orgDivision;
}


public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}



public String getChildAmount() {
	return childAmount;
}
public void setChildAmount(String childAmount) {
	this.childAmount = childAmount;
}



public String getTotalcreditAmount() {
	return totalcreditAmount;
}
public void setTotalcreditAmount(String totalcreditAmount) {
	this.totalcreditAmount = totalcreditAmount;
}
public String getTotalDebitAmount() {
	return totalDebitAmount;
}
public void setTotalDebitAmount(String totalDebitAmount) {
	this.totalDebitAmount = totalDebitAmount;
}
public String getNatureOfGroup() {
	return natureOfGroup;
}
public void setNatureOfGroup(String natureOfGroup) {
	this.natureOfGroup = natureOfGroup;
}

public String getSubChildAmount() {
	return subChildAmount;
}
public void setSubChildAmount(String subChildAmount) {
	this.subChildAmount = subChildAmount;
}

public String getSubChildDebitAmount() {
	return subChildDebitAmount;
}
public void setSubChildDebitAmount(String subChildDebitAmount) {
	this.subChildDebitAmount = subChildDebitAmount;
}
public String getSubChildCreditAmount() {
	return subChildCreditAmount;
}
public void setSubChildCreditAmount(String subChildCreditAmount) {
	this.subChildCreditAmount = subChildCreditAmount;
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

