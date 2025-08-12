package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;


public class RestProjectFileuploadModel {
	private String documnentName;
	private String fileName;
	private String vendorRfqId;
	private List<String> documentFile = new ArrayList<String>();
	private String action;
	private String imageNameEdit;
	private String createdBy;
	private String docDate;
	private String mainId;
	
	private String projectId;
	private String documentName;
	private String documentFileName;
	private String slNo;
	private List<DropDownModel> drop = new ArrayList<DropDownModel>();

	public RestProjectFileuploadModel() {
		super();
	}
	public RestProjectFileuploadModel(Object documnentName, Object fileName, Object vendorRfqId) {
		super();
		this.documnentName = (String) documnentName;
		this.fileName = (String) fileName;
		this.vendorRfqId = (String) vendorRfqId;
	}
	public String getDocumnentName() {
		return documnentName;
	}

	public void setDocumnentName(String documnentName) {
		this.documnentName = documnentName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getVendorRfqId() {
		return vendorRfqId;
	}

	public void setVendorRfqId(String vendorRfqId) {
		this.vendorRfqId = vendorRfqId;
	}

	public List<String> getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(List<String> documentFile) {
		this.documentFile = documentFile;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getImageNameEdit() {
		return imageNameEdit;
	}

	public void setImageNameEdit(String imageNameEdit) {
		this.imageNameEdit = imageNameEdit;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public List<DropDownModel> getDrop() {
		return drop;
	}

	public void setDrop(List<DropDownModel> drop) {
		this.drop = drop;
	}

	public String getDocDate() {
		return docDate;
	}
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	
	public String getMainId() {
		return mainId;
	}
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	
	
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentFileName() {
		return documentFileName;
	}
	public void setDocumentFileName(String documentFileName) {
		this.documentFileName = documentFileName;
	}
	public String getSlNo() {
		return slNo;
	}
	public void setSlNo(String slNo) {
		this.slNo = slNo;
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
