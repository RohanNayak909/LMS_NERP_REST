package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TemplatesMasterModel {

	private String tempId;
	private String module;
	private String function;
	private String activity;
	private String tempName;
	private String createdBy;
	private String fileName;
	private List<String> htmlFile = new ArrayList<String>();

	public TemplatesMasterModel() {
		super();
	}

	public TemplatesMasterModel(Object tempId, Object module, Object function, Object activity, Object tempName,
			Object fileName) {
		super();
		this.tempId = (String) tempId;
		this.module = (String) module;
		this.function = (String) function;
		this.activity = (String) activity;
		this.tempName = (String) tempName;
		this.fileName = (String) fileName;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getHtmlFile() {
		return htmlFile;
	}

	public void setHtmlFile(List<String> htmlFile) {
		this.htmlFile = htmlFile;
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
