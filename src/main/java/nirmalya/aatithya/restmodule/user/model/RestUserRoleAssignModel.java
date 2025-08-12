package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestUserRoleAssignModel {

	private String empId;
	private String name;
	private String cont;
	private String email;
	private Boolean empStatus;
	private String role;
	private String organization;
	private String orgDivision;
	private String status;
	private String role1;
	private List<String> roleList = new ArrayList<String>();
	private List<String> roleNameList = new ArrayList<String>();
	private String roleName;

	public RestUserRoleAssignModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestUserRoleAssignModel(Object empId, Object name, Object cont, Object email, Object role) {
		super();
		this.empId = (String) empId;
		this.name = (String) name;
		this.cont = (String) cont;
		this.email = (String) email;
		this.role = (String) role;
	}

	public RestUserRoleAssignModel(Object empId, Object name, Object cont, Object email, Object empStatus, Object role,
			Object role1) {
		super();
		this.empId = (String) empId;
		this.name = (String) name;
		this.cont = (String) cont;
		this.email = (String) email;
		this.empStatus = (Boolean) empStatus;
		this.role = (String) role;
		this.role1 = (String) role1;
	}

	public RestUserRoleAssignModel(Object empId, Object name, Object cont, Object email, Object role, Object roleName) {
		super();
		this.empId = (String) empId;
		this.name = (String) name;
		this.cont = (String) cont;
		this.email = (String) email;
		this.role = (String) role;
		this.roleName = (String) roleName;
	}

	public Boolean getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(Boolean empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public List<String> getRoleNameList() {
		return roleNameList;
	}

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public void setRoleNameList(List<String> roleNameList) {
		this.roleNameList = roleNameList;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
