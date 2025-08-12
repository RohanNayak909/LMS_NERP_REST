package nirmalya.aatithya.restmodule.api.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerProfileApiModel {
	private String customerId; 
	private MultipartFile mulFile; 
	private String extension;
	private String docName;
	private String createdBy;
	private String organization;
	private String orgDivision;
	public CustomerProfileApiModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerProfileApiModel(Object customerId,Object docName) {
		super();
		this.customerId = (String)customerId;
		this.docName = (String)docName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public MultipartFile getMulFile() {
		return mulFile;
	}
	public void setMulFile(MultipartFile mulFile) {
		this.mulFile = mulFile;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
