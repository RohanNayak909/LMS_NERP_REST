package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BreadcrumbModel {

	private String modId;
	private String modName;
	private String funId;
	private String funName;
	private String actId;
	private String actName;
	private String actURL;

	public BreadcrumbModel() {
		super();
	}

	public BreadcrumbModel(Object modId, Object modName, Object funId, Object funName, Object actId, Object actName,
			Object actURL) {
		super();
		this.modId = (String) modId;
		this.modName = (String) modName;
		this.funId = (String) funId;
		this.funName = (String) funName;
		this.actId = (String) actId;
		this.actName = (String) actName;
		this.actURL = (String) actURL;
	}

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getActId() {
		return actId;
	}

	public void setActId(String actId) {
		this.actId = actId;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getActURL() {
		return actURL;
	}

	public void setActURL(String actURL) {
		this.actURL = actURL;
	}

	/**
	 * Overrides toString method for converting class to string and back
	 **/
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
