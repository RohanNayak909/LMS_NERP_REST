package nirmalya.aatithya.restmodule.projects.model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;



public class ProjectCreationRestModel {

	private String projectId;
	private String projectName;
	private String creationDate;
	private String location;
	private String country2;
	private String stateid2;
	private String pPin;
	private String pIncharge;
	private String cName;
	private String cAddress;
	private String country;
	private String stateid;
	private String cityb;
	private String street1b;
	private String street2b;
	private String cPin;
	private String email;
	private String mobile;
	private String remark;
	private String status;

	private String createdBy;
	private String CreatedOn;
	private String UpdatedBy;
	private String UpdatedOn;
	private String OrganizationName;
	private String OrganizationDivision;
	private String billingStreet1;
	private String billingStreet2;
	private String billingGstNo;
	
	private String documentTypeId;
	private String prjDocumentId;
	private String fileAttach;
	private String documentTypeName;
	private String nfaId;
	private String nfaDescription;
	private String temaplteId;
	private String productSkuId;
	private String projectType;
	private String date;

	List<RestProjectFileuploadModel> documentList;
	

	List<RestProjectShippingModel> shippingList;
	
	List<RestProjectShippingModel> productList;
	
	List<RestProjectShippingModel> skuList;

	public List<RestProjectShippingModel> getShippingList() {
		return shippingList;
	}

	public void setShippingList(List<RestProjectShippingModel> shippingList) {
		this.shippingList = shippingList;
	}

	public List<RestProjectFileuploadModel> getDocumentList() {
		return documentList;
	}

	public void setDocumentList(List<RestProjectFileuploadModel> documentList) {
		this.documentList = documentList;
	}
	

	public ProjectCreationRestModel() {
		super();
	}

	// FOR MAIN AG-GRID

	public ProjectCreationRestModel(Object projectId, Object projectName, Object creationDate, Object location,
			Object country2, Object stateid2, Object pPin, Object pIncharge, Object cName, Object cAddress,
			Object country, Object stateid, Object cityb, Object street1b, Object street2b, Object cPin, Object email,
			Object mobile, Object remark, Object status, Object createdBy, Object CreatedOn, Object UpdatedBy,
			Object UpdatedOn, Object OrganizationName, Object OrganizationDivision) {
		super();
		this.projectId = (String) projectId;
		this.projectName = (String) projectName;
		this.creationDate = (String) creationDate;
		this.location = (String) location;
		this.country2 = (String) country2;
		this.stateid2 = (String) stateid2;
		this.pPin = (String) pPin;
		this.pIncharge = (String) pIncharge;
		this.cName = (String) cName;
		this.cAddress = (String) cAddress;
		this.country = (String) country;
		this.stateid = (String) stateid;
		this.cityb = (String) cityb;
		this.street1b = (String) street1b;
		this.street2b = (String) street2b;
		this.cPin = (String) cPin;
		this.email = (String) email;
		this.mobile = (String) mobile;
		this.remark = (String) remark;
		this.status = (String) status;
		this.createdBy = (String) createdBy;
		this.CreatedOn = (String) CreatedOn;
		this.UpdatedBy = (String) UpdatedBy;
		this.UpdatedOn = (String) UpdatedOn;
		this.OrganizationName = (String) OrganizationName;
		this.OrganizationDivision = (String) OrganizationDivision;
	}
	
	//for edit
	public ProjectCreationRestModel(Object projectId, Object projectName, Object creationDate, Object location,
			Object country2, Object stateid2, Object pPin, Object pIncharge, Object cName, Object cAddress,
			Object country, Object stateid, Object cityb, Object street1b, Object street2b, Object cPin, Object email,
			Object mobile, Object remark, Object status,Object billingStreet1,Object billingStreet2
			,Object billingGstNo,Object projectType) {
		super();
		this.projectId = (String)projectId;
		this.projectName = (String)projectName;
		this.creationDate = (String)creationDate;
		this.location = (String)location;
		this.country2 = (String)country2;
		this.stateid2 = (String)stateid2;
		this.pPin = (String)pPin;
		this.pIncharge = (String)pIncharge;
		this.cName = (String)cName;
		this.cAddress = (String)cAddress;
		this.country = (String)country;
		this.stateid = (String)stateid;
		this.cityb = (String)cityb;
		this.street1b = (String)street1b;
		this.street2b = (String)street2b;
		this.cPin = (String)cPin;
		this.email = (String)email;
		this.mobile = (String)mobile;
		this.remark = (String)remark;
		this.status = (String)status;
		this.status = (String)status;
		this.status = (String)status;
		this.status = (String)status;
		this.billingStreet1 = (String)billingStreet1;
		this.billingStreet2 = (String)billingStreet2;
		this.billingGstNo = (String)billingGstNo;
		this.projectType = (String)projectType;
		
	}

	// FOR PARENT AND CHILD AG-GRID

	public ProjectCreationRestModel(Object projectId, Object projectName, Object creationDate, Object location,
			Object country2, Object stateid2, Object pPin, Object pIncharge, Object cName, Object cAddress,
			Object country, Object stateid, Object cityb, Object street1b, Object street2b, Object cPin, Object email,
			Object mobile, Object remark, Object status, Object shippingName, Object shippingAddress, Object country1,
			Object stateid1, Object shippingCity, Object shippingStreet1, Object shippingStreet2, Object shippingPin,
			Object shippingEmail, Object shippingMobileNo, Object shippingId, Object createdBy, Object organizationName,
			Object organizationDivision) {
		super();
		this.projectId = (String) projectId;
		this.projectName = (String) projectName;
		this.creationDate = (String) creationDate;
		this.location = (String) location;
		this.country2 = (String) country2;
		this.stateid2 = (String) stateid2;
		this.pPin = (String) pPin;
		this.pIncharge = (String) pIncharge;
		this.cName = (String) cName;
		this.cAddress = (String) cAddress;
		this.country = (String) country;
		this.stateid = (String) stateid;
		this.cityb = (String) cityb;
		this.street1b = (String) street1b;
		this.street2b = (String) street2b;
		this.cPin = (String) cPin;
		this.email = (String) email;
		this.mobile = (String) mobile;
		this.remark = (String) remark;
		this.status = (String) status;

	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCountry2() {
		return country2;
	}

	public void setCountry2(String country2) {
		this.country2 = country2;
	}

	public String getStateid2() {
		return stateid2;
	}

	public void setStateid2(String stateid2) {
		this.stateid2 = stateid2;
	}

	public String getpPin() {
		return pPin;
	}

	public void setpPin(String pPin) {
		this.pPin = pPin;
	}

	public String getpIncharge() {
		return pIncharge;
	}

	public void setpIncharge(String pIncharge) {
		this.pIncharge = pIncharge;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateid() {
		return stateid;
	}

	public void setStateid(String stateid) {
		this.stateid = stateid;
	}

	public String getCityb() {
		return cityb;
	}

	public void setCityb(String cityb) {
		this.cityb = cityb;
	}

	public String getStreet1b() {
		return street1b;
	}

	public void setStreet1b(String street1b) {
		this.street1b = street1b;
	}

	public String getStreet2b() {
		return street2b;
	}

	public void setStreet2b(String street2b) {
		this.street2b = street2b;
	}

	public String getcPin() {
		return cPin;
	}

	public void setcPin(String cPin) {
		this.cPin = cPin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOrganizationName() {
		return OrganizationName;
	}

	public void setOrganizationName(String organizationName) {
		OrganizationName = organizationName;
	}

	public String getOrganizationDivision() {
		return OrganizationDivision;
	}

	public void setOrganizationDivision(String organizationDivision) {
		OrganizationDivision = organizationDivision;
	}

	public String getCreatedOn() {
		return CreatedOn;
	}

	public void setCreatedOn(String createdOn) {
		CreatedOn = createdOn;
	}

	public String getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		UpdatedBy = updatedBy;
	}

	public String getUpdatedOn() {
		return UpdatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		UpdatedOn = updatedOn;
	}
	

	public String getBillingStreet1() {
		return billingStreet1;
	}

	public void setBillingStreet1(String billingStreet1) {
		this.billingStreet1 = billingStreet1;
	}

	public String getBillingStreet2() {
		return billingStreet2;
	}

	public void setBillingStreet2(String billingStreet2) {
		this.billingStreet2 = billingStreet2;
	}

	public String getBillingGstNo() {
		return billingGstNo;
	}

	public void setBillingGstNo(String billingGstNo) {
		this.billingGstNo = billingGstNo;
	}

	public String getDocumentTypeId() {
		return documentTypeId;
	}

	public void setDocumentTypeId(String documentTypeId) {
		this.documentTypeId = documentTypeId;
	}

	public String getPrjDocumentId() {
		return prjDocumentId;
	}

	public void setPrjDocumentId(String prjDocumentId) {
		this.prjDocumentId = prjDocumentId;
	}

	public String getFileAttach() {
		return fileAttach;
	}

	public void setFileAttach(String fileAttach) {
		this.fileAttach = fileAttach;
	}

	public String getDocumentTypeName() {
		return documentTypeName;
	}

	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}

	public String getNfaId() {
		return nfaId;
	}

	public void setNfaId(String nfaId) {
		this.nfaId = nfaId;
	}

	public String getNfaDescription() {
		return nfaDescription;
	}

	public void setNfaDescription(String nfaDescription) {
		this.nfaDescription = nfaDescription;
	}

	public String getTemaplteId() {
		return temaplteId;
	}

	public void setTemaplteId(String temaplteId) {
		this.temaplteId = temaplteId;
	}

	public List<RestProjectShippingModel> getProductList() {
		return productList;
	}

	public void setProductList(List<RestProjectShippingModel> productList) {
		this.productList = productList;
	}

	public List<RestProjectShippingModel> getSkuList() {
		return skuList;
	}

	public void setSkuList(List<RestProjectShippingModel> skuList) {
		this.skuList = skuList;
	}

	public String getProductSkuId() {
		return productSkuId;
	}

	public void setProductSkuId(String productSkuId) {
		this.productSkuId = productSkuId;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
