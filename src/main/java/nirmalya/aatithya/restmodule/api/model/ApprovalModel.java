package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ApprovalModel {

	public String requisitionId;
	public String requisitionName;
	public String employeeId;
	public String employeeName;
	public String status;
	public String approvedBy;
	public String rejectedBy;
	public String comment;
	private List<String> userRole = new ArrayList<String>();
	
	
	public ApprovalModel(Object requisitionId,Object requisitionName, Object employeeId, Object employeeName,
			Object status, Object approvedBy,Object rejectedBy,Object comment) {
		super();
		this.requisitionId = (String) requisitionId;
		this.requisitionName = (String) requisitionName; 
		this.employeeId = (String) employeeId;
		this.employeeName = (String) employeeName;
		this.status = (String) status;
		this.approvedBy = (String) approvedBy;
		this.rejectedBy = (String) rejectedBy;
		this.comment = (String) comment;
		}
	
	
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getRequisitionName() {
		return requisitionName;
	}
	public void setRequisitionName(String requisitionName) {
		this.requisitionName = requisitionName;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
	public String getRejectedBy() {
		return rejectedBy;
	}
	public void setRejectedBy(String rejectedBy) {
		this.rejectedBy = rejectedBy;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<String> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<String> userRole) {
		this.userRole = userRole;
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
