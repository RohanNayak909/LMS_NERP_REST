package nirmalya.aatithya.restmodule.master.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VendorMasterModel {
	private String vendorId;
	private String vendorName;
	private String code;
	private String category;
	private String categoryType;
	private String comapanyOverview;
	private String vendorStatus;
	private String createdOn;
	private String createdBy;
	private String fileVendor;
	private String address;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String email;
	private String bankInfo;
	private String module;
	private String component;
	private String subcomponent;
	
	private String companyDate;
	private String grossAnnualSale;
	private String currency;
	private String totalEmployee;
	private String website;
	private String OrganizationName; 
	private String OrganizationDivision; 
	private String password;
	private String gst;
	private String cpriod;
	private String security;
	private String bGura;
	private String pdCheak;
	private String climits;
	
	public String getCpriod() {
		return cpriod;
	}
	public void setCpriod(String cpriod) {
		this.cpriod = cpriod;
	}
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	public String getbGura() {
		return bGura;
	}
	public void setbGura(String bGura) {
		this.bGura = bGura;
	}
	public String getPdCheak() {
		return pdCheak;
	}
	public void setPdCheak(String pdCheak) {
		this.pdCheak = pdCheak;
	}
	public String getClimits() {
		return climits;
	}
	public void setClimits(String climits) {
		this.climits = climits;
	}
	public VendorMasterModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VendorMasterModel(Object vendorId, Object vendorName, Object code, Object category,
			Object categoryType, Object comapanyOverview, Object vendorStatus, Object createdOn, 
			Object createdBy, Object fileVendor,
			Object address,Object city,Object state,Object country,Object phone,Object email,Object bankInfo,
			Object module,Object component,Object subcomponent,
			Object companyDate,Object grossAnnualSale,Object currency,Object totalEmployee,
			Object website,Object organizationName, Object organizationDivision,Object gst,Object cpriod,Object security,Object bGura,Object pdCheak,Object climits) {
		super();
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.code = (String) code;
		this.category = (String) category;
		this.categoryType = (String) categoryType;
		this.comapanyOverview = (String) comapanyOverview;
		this.vendorStatus = (String) vendorStatus;
		this.createdOn = (String) createdOn;
		this.createdBy = (String) createdBy;
		this.fileVendor = (String) fileVendor;
		this.address=(String) address;
		this.city=(String) city;
		this.state=(String) state;
		this.country=(String) country;
		this.phone=(String) phone;
		this.email=(String) email;
		this.bankInfo=(String) bankInfo;
		this.module=(String) module;
		this.component=(String) component;
		this.subcomponent=(String) subcomponent;
		this.companyDate=(String) companyDate;
		this.grossAnnualSale=(String) grossAnnualSale;
		this.currency=(String) currency;
		this.totalEmployee=(String) totalEmployee;
		this.website=(String) website;
		this.OrganizationName = (String)organizationName;
		this.OrganizationDivision = (String)organizationDivision;
		this.gst = (String)gst;
		this.cpriod = (String)cpriod;
		this.security = (String)security;
		this.bGura = (String)bGura;
		this.pdCheak = (String)pdCheak;
		this.climits = (String)climits;
		
	}
	
    public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getComapanyOverview() {
		return comapanyOverview;
	}
	public void setComapanyOverview(String comapanyOverview) {
		this.comapanyOverview = comapanyOverview;
	}
	public String getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(String vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getFileVendor() {
		return fileVendor;
	}
	public void setFileVendor(String fileVendor) {
		this.fileVendor = fileVendor;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBankInfo() {
		return bankInfo;
	}
	public void setBankInfo(String bankInfo) {
		this.bankInfo = bankInfo;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public String getSubcomponent() {
		return subcomponent;
	}
	public void setSubcomponent(String subcomponent) {
		this.subcomponent = subcomponent;
	}
	
	public String getCompanyDate() {
		return companyDate;
	}
	public void setCompanyDate(String companyDate) {
		this.companyDate = companyDate;
	}
	public String getGrossAnnualSale() {
		return grossAnnualSale;
	}
	public void setGrossAnnualSale(String grossAnnualSale) {
		this.grossAnnualSale = grossAnnualSale;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTotalEmployee() {
		return totalEmployee;
	}
	public void setTotalEmployee(String totalEmployee) {
		this.totalEmployee = totalEmployee;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getGst() {
		return gst;
	}
	public void setGst(String gst) {
		this.gst = gst;
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
