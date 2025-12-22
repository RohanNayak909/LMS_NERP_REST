package nirmalya.aatithya.restmodule.sales.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCustoomerNewModel {
	private String customerId;
	private String customerType;
	private String salutation;
	private String customerName;
	private String companyName;
	private String customerDisplayName;
	private String cusEmail;
	private String custMobile;
	private String custSkype;
	private String custDesignation;
	private String department;
	private String webSite;
	private String status;
	private String pan;
	private String gstNo;
	private String currency;
	private String openingBalance;
	private String paymentTerms;
	private String enableDtls;
	private String portableLang;
	private String whatsApp;
	private String faceBook;
	private String twitter;
	private String country;
	private String states;
	private String city;
	private String street1;
	private String street2;
	private String zipCode;
	private String phone;
	private String fax;

	private String country1;
	private String states1;
	private String city1;
	private String street11;
	private String street21;
	private String zipCode1;
	private String phone1;
	private String fax1;

	private String salutation1;
	private String firstName;
	private String lastName;
	private String emailAdd;
	private String mobile;
	private String remarks;

	private String createdDate;
	private String createdTime;
	private String createdBy;
	private String organization;
	private String orgDivision;
	private String defaultStatus;
	private String shippingId;
	private String custType;

	private String shipAlterMob;
	private String shipOrderReciever;
	private String deliveryNote;
	private String districtName;
	private String locality;
	private String districtName1;
	private String locality1;
	private String crmContactId;
	
	private String shippingDetails;
	private String pocDetails;
	private String leadId;
	private String gstIn;
	/**
	 * 
	 */
	public RestCustoomerNewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestCustoomerNewModel(Object customerId, Object customerDisplayName, Object companyName, Object cusEmail,
			Object custMobile, Object openingBalance, Object createdTime, Object createdDate, Object status, Object pan,
			Object gstNo, Object paymentTerms, Object country, Object states, Object city, Object street1,
			Object customerType) {
		super();
		this.customerId = (String) customerId;
		this.customerDisplayName = (String) customerDisplayName;
		this.companyName = (String) companyName;
		this.cusEmail = (String) cusEmail;
		this.custMobile = (String) custMobile;
		this.openingBalance = (String) openingBalance;
		this.createdTime = (String) createdTime;
		this.createdDate = (String) createdDate;
		this.status = (String) status;
		this.pan = (String) pan;
		this.gstNo = (String) gstNo;

		this.paymentTerms = (String) paymentTerms;
		this.country = (String) country;
		this.states = (String) states;
		this.city = (String) city;
		this.street1 = (String) street1;
		this.customerType = (String) customerType;
	}

	public RestCustoomerNewModel(Object customerId, Object country1, Object states1, Object city1, Object street11,
			Object street21, Object zipCode1, Object phone1, Object fax1, Object organization, Object orgDivision,
			Object defaultStatus, Object shippingId) {
		super();
		this.customerId = (String) customerId;
		this.country1 = (String) country1;
		this.states1 = (String) states1;
		this.city1 = (String) city1;
		this.street11 = (String) street11;
		this.street21 = (String) street21;
		this.zipCode1 = (String) zipCode1;
		this.phone1 = (String) phone1;
		this.fax1 = (String) fax1;
		this.organization = (String) organization;
		this.orgDivision = (String) orgDivision;
		this.defaultStatus = (String) defaultStatus;
		this.shippingId = (String) shippingId;
	}

	public RestCustoomerNewModel(Object customerId, Object pan) {
		super();
		this.customerId = (String) customerId;
		this.pan = (String) pan;
	}

	public RestCustoomerNewModel(Object customerId, Object customerType, Object salutation, Object customerName,
			Object companyName, Object customerDisplayName, Object cusEmail, Object custMobile, Object custSkype,
			Object webSite, Object status, Object pan, Object gstNo, Object currency, Object openingBalance,
			Object paymentTerms, Object portableLang, Object whatsApp, Object faceBook, Object twitter, Object country,
			Object states, Object city, Object street1, Object street2, Object zipCode, Object phone, Object fax) {
		super();
		this.customerId = (String) customerId;
		this.customerType = (String) customerType;
		this.salutation = (String) salutation;
		this.customerName = (String) customerName;
		this.companyName = (String) companyName;
		this.customerDisplayName = (String) customerDisplayName;
		this.cusEmail = (String) cusEmail;
		this.custMobile = (String) custMobile;
		this.custSkype = (String) custSkype;
		this.webSite = (String) webSite;
		this.status = (String) status;
		this.pan = (String) pan;
		this.gstNo = (String) gstNo;
		this.currency = (String) currency;
		this.openingBalance = (String) openingBalance;
		this.paymentTerms = (String) paymentTerms;
		this.portableLang = (String) portableLang;
		this.whatsApp = (String) whatsApp;
		this.faceBook = (String) faceBook;
		this.twitter = (String) twitter;
		this.country = (String) country;
		this.states = (String) states;
		this.city = (String) city;
		this.street1 = (String) street1;
		this.street2 = (String) street2;
		this.zipCode = (String) zipCode;
		this.phone = (String) phone;
		this.fax = (String) fax;
	}

	public RestCustoomerNewModel(Object customerId, Object gstNo, Object country, Object states, Object city,
			Object street1, Object street2, Object zipCode, Object phone, Object fax, Object country1, Object states1,
			Object city1, Object street11, Object street21, Object zipCode1, Object phone1, Object fax1,
			Object shippingDetails, Object custType) {
		super();
		this.customerId = (String) customerId;
		this.gstNo = (String) gstNo;
		this.country = (String) country;
		this.states = (String) states;
		this.city = (String) city;
		this.street1 = (String) street1;
		this.street2 = (String) street2;
		this.zipCode = (String) zipCode;
		this.phone = (String) phone;
		this.fax = (String) fax;
		this.country1 = (String) country1;
		this.states1 = (String) states1;
		this.city1 = (String) city1;
		this.street11 = (String) street11;
		this.street21 = (String) street21;
		this.zipCode1 = (String) zipCode1;
		this.phone1 = (String) phone1;
		this.fax1 = (String) fax1;
		this.shippingDetails = (String) shippingDetails;
		this.custType = (String) custType;
	}
	public RestCustoomerNewModel(Object customerId, Object gstNo,Object country,Object country1, Object states,Object states1,
			Object city1, Object street11, Object street21, Object zipCode1, Object phone1, Object fax1,
			Object shippingId,Object customerType) {
		super();
		this.customerId = (String) customerId;
		this.gstNo = (String) gstNo;
		this.country = (String) country;
		this.country1 = (String) country1;
		this.states = (String) states;
		this.states1 = (String) states1;
		this.city1 = (String) city1;
		this.street11 = (String) street11;
		this.street21 = (String) street21;
		this.zipCode1 = (String) zipCode1;
		this.phone1 = (String) phone1;
		this.fax1 = (String) fax1;
		this.shippingId = (String) shippingId;
		this.customerType = (String) customerType;
	}

	public RestCustoomerNewModel(Object customerId, Object customerType, Object salutation, Object customerName,
			Object companyName, Object customerDisplayName, Object cusEmail, Object custMobile, Object custSkype,
			Object custDesignation, Object department, Object webSite, Object status, Object pan, Object currency,
			Object openingBalance, Object paymentTerms, Object enableDtls, Object portableLang, Object faceBook,
			Object twitter, Object country, Object states, Object city, Object street1, Object street2, Object zipCode,
			Object phone, Object fax, Object country1, Object states1, Object city1, Object street11, Object street21,
			Object zipCode1, Object phone1, Object fax1, Object salutation1, Object firstName, Object lastName,
			Object emailAdd, Object mobile, Object remarks, Object whatsApp, Object gstNo, Object shippingDetails,Object pocDetails) {
		super();

		try {
			this.customerId = (String) customerId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.customerType = (String) customerType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.salutation = (String) salutation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.customerName = (String) customerName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.companyName = (String) companyName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.customerDisplayName = (String) customerDisplayName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.cusEmail = (String) cusEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.custMobile = (String) custMobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.custSkype = (String) custSkype;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.custDesignation = (String) custDesignation;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.department = (String) department;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.webSite = (String) webSite;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.status = (String) status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.pan = (String) pan;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.currency = (String) currency;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.openingBalance = (String) openingBalance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.paymentTerms = (String) paymentTerms;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.enableDtls = (String) enableDtls;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.portableLang = (String) portableLang;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.faceBook = (String) faceBook;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.twitter = (String) twitter;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.country = (String) country;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.states = (String) states;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.city = (String) city;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.street1 = (String) street1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.street2 = (String) street2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.zipCode = (String) zipCode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.phone = (String) phone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.fax = (String) fax;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.country1 = (String) country1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.states1 = (String) states1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.city1 = (String) city1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.street11 = (String) street11;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.street21 = (String) street21;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.zipCode1 = (String) zipCode1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.phone1 = (String) phone1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.fax1 = (String) fax1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.salutation1 = (String) salutation1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.firstName = (String) firstName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.lastName = (String) lastName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.emailAdd = (String) emailAdd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.mobile = (String) mobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.remarks = (String) remarks;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.whatsApp = (String) whatsApp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.gstNo = (String) gstNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.shippingDetails = (String) shippingDetails;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pocDetails = (String) pocDetails;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RestCustoomerNewModel(Object customerId, Object customerDisplayName, Object companyName, Object cusEmail,
			Object custMobile, Object openingBalance, Object createdTime, Object createdDate, Object status) {
		super();

		try {
			this.customerId = (String) customerId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.customerDisplayName = (String) customerDisplayName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.companyName = (String) companyName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.cusEmail = (String) cusEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.custMobile = (String) custMobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.openingBalance = (String) openingBalance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.status = (String) status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.createdTime = (String) createdTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Generate Getter & Setter
	 * 
	 * 
	 */

	public String getCustomerId() {
		return customerId;
	}

	public String getLeadId() {
		return leadId;
	}

	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}

	public String getCountry1() {
		return country1;
	}

	public void setCountry1(String country1) {
		this.country1 = country1;
	}

	public String getStates1() {
		return states1;
	}

	public void setStates1(String states1) {
		this.states1 = states1;
	}

	public String getCity1() {
		return city1;
	}

	public void setCity1(String city1) {
		this.city1 = city1;
	}

	public String getStreet11() {
		return street11;
	}

	public void setStreet11(String street11) {
		this.street11 = street11;
	}

	public String getStreet21() {
		return street21;
	}

	public void setStreet21(String street21) {
		this.street21 = street21;
	}

	public String getZipCode1() {
		return zipCode1;
	}

	public void setZipCode1(String zipCode1) {
		this.zipCode1 = zipCode1;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getFax1() {
		return fax1;
	}

	public void setFax1(String fax1) {
		this.fax1 = fax1;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerDisplayName() {
		return customerDisplayName;
	}

	public void setCustomerDisplayName(String customerDisplayName) {
		this.customerDisplayName = customerDisplayName;
	}

	public String getCusEmail() {
		return cusEmail;
	}

	public void setCusEmail(String cusEmail) {
		this.cusEmail = cusEmail;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getCustSkype() {
		return custSkype;
	}

	public void setCustSkype(String custSkype) {
		this.custSkype = custSkype;
	}

	public String getCustDesignation() {
		return custDesignation;
	}

	public void setCustDesignation(String custDesignation) {
		this.custDesignation = custDesignation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}

	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public String getEnableDtls() {
		return enableDtls;
	}

	public void setEnableDtls(String enableDtls) {
		this.enableDtls = enableDtls;
	}

	public String getPortableLang() {
		return portableLang;
	}

	public void setPortableLang(String portableLang) {
		this.portableLang = portableLang;
	}

	public String getFaceBook() {
		return faceBook;
	}

	public void setFaceBook(String faceBook) {
		this.faceBook = faceBook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSalutation1() {
		return salutation1;
	}

	public void setSalutation1(String salutation1) {
		this.salutation1 = salutation1;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
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

	public String getDefaultStatus() {
		return defaultStatus;
	}

	public void setDefaultStatus(String defaultStatus) {
		this.defaultStatus = defaultStatus;
	}

	public String getShippingId() {
		return shippingId;
	}

	public void setShippingId(String shippingId) {
		this.shippingId = shippingId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getShipAlterMob() {
		return shipAlterMob;
	}

	public void setShipAlterMob(String shipAlterMob) {
		this.shipAlterMob = shipAlterMob;
	}

	public String getShipOrderReciever() {
		return shipOrderReciever;
	}

	public void setShipOrderReciever(String shipOrderReciever) {
		this.shipOrderReciever = shipOrderReciever;
	}

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getDistrictName1() {
		return districtName1;
	}

	public void setDistrictName1(String districtName1) {
		this.districtName1 = districtName1;
	}

	public String getLocality1() {
		return locality1;
	}

	public void setLocality1(String locality1) {
		this.locality1 = locality1;
	}
	
	public String getCrmContactId() {
		return crmContactId;
	}

	public void setCrmContactId(String crmContactId) {
		this.crmContactId = crmContactId;
	}
	
	

	public String getShippingDetails() {
		return shippingDetails;
	}

	public void setShippingDetails(String shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	 

	public String getPocDetails() {
		return pocDetails;
	}

	public void setPocDetails(String pocDetails) {
		this.pocDetails = pocDetails;
	}

	public String getGstIn() {
		return gstIn;
	}

	public void setGstIn(String gstIn) {
		this.gstIn = gstIn;
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
