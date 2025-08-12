package nirmalya.aatithya.restmodule.user.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SelfServiceActivityModel {

	private String moduleId;
	private String moduleKeyName;
	private String functionId;
	private String functionKeyName;
	private String activityId;
	private String activityKeyName;
	private String activityURL;
	private String activityLogo;

	public SelfServiceActivityModel() {
		super();
	}

	public SelfServiceActivityModel(Object moduleId, Object moduleKeyName, Object functionId, Object functionKeyName,
			Object activityId, Object activityKeyName, Object activityURL, Object activityLogo) {
		super();
		try {
			this.moduleId = (String) moduleId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.moduleKeyName = (String) moduleKeyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.functionId = (String) functionId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.functionKeyName = (String) functionKeyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.activityId = (String) activityId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.activityKeyName = (String) activityKeyName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.activityURL = (String) activityURL;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.activityLogo = (String) activityLogo;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleKeyName() {
		return moduleKeyName;
	}

	public void setModuleKeyName(String moduleKeyName) {
		this.moduleKeyName = moduleKeyName;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getFunctionKeyName() {
		return functionKeyName;
	}

	public void setFunctionKeyName(String functionKeyName) {
		this.functionKeyName = functionKeyName;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityKeyName() {
		return activityKeyName;
	}

	public void setActivityKeyName(String activityKeyName) {
		this.activityKeyName = activityKeyName;
	}

	public String getActivityURL() {
		return activityURL;
	}

	public void setActivityURL(String activityURL) {
		this.activityURL = activityURL;
	}

	public String getActivityLogo() {
		return activityLogo;
	}

	public void setActivityLogo(String activityLogo) {
		this.activityLogo = activityLogo;
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