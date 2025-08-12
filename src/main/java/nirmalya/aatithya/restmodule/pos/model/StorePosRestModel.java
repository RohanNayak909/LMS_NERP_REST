package nirmalya.aatithya.restmodule.pos.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class StorePosRestModel {
	private Integer slNo;
	private String opId;
	private String opCunterName;
	private String opName;
	private String opMobile;
	private String opEmail;
	private String role1;
	private String opPassword;
	private String opCPassword;

	public StorePosRestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorePosRestModel(Object opId, Object opCunterName, Object opName, Object opMobile, Object opEmail) {
		super();
		this.opId = (String) opId;
		this.opCunterName = (String) opCunterName;
		this.opName = (String) opName;
		this.opMobile = (String) opMobile;
		this.opEmail = (String) opEmail;
	}
	
	public StorePosRestModel(Object opId, Object opCunterName, Object opMobile, Object opEmail ,Object role1, Object opCPassword) {
		super();
		this.opId = (String) opId;
		this.opCunterName = (String) opCunterName;
		this.opMobile = (String) opMobile;
		this.opEmail = (String) opEmail;
		this.role1 = (String) role1;
	}
	
	public StorePosRestModel(Object opId,Object opEmail,Object opName) {
		super();
		this.opId = (String) opId;
		this.opEmail = (String) opEmail;
		this.opName = (String) opName;
		
	}

	public Integer getSlNo() {
		return slNo;
	}

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	public String getOpId() {
		return opId;
	}

	public void setOpId(String opId) {
		this.opId = opId;
	}

	public String getOpCunterName() {
		return opCunterName;
	}

	public void setOpCunterName(String opCunterName) {
		this.opCunterName = opCunterName;
	}

	public String getOpName() {
		return opName;
	}

	public void setOpName(String opName) {
		this.opName = opName;
	}

	public String getOpMobile() {
		return opMobile;
	}

	public void setOpMobile(String opMobile) {
		this.opMobile = opMobile;
	}

	public String getOpEmail() {
		return opEmail;
	}

	public void setOpEmail(String opEmail) {
		this.opEmail = opEmail;
	}

	public String getOpPassword() {
		return opPassword;
	}

	public void setOpPassword(String opPassword) {
		this.opPassword = opPassword;
	}

	public String getOpCPassword() {
		return opCPassword;
	}

	public void setOpCPassword(String opCPassword) {
		this.opCPassword = opCPassword;
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
