package nirmalya.aatithya.restmodule.purchase.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestVendorNewModel {

	private String vendorId;
	private String vendorType;
	private String salutation;
	private String vendorName;
	private String companyName;
	private String vendorDisplayName;
	private String vendorEmail;
	private String vendorPhone;
	private String vendorMobile;
	private String vendorSkype;
	private String vendorDesignation;
	private String department;
	private String webSite;
	private String status;

	private String pan;
	private String currency;
	private String openingBalance;
	private String paymentTerms;
	private String tds;
	private String gstNumber;
	private String vendorCategory;
	private String whatsAppNo;
	private String tanNo;
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

	private String beneficiaryName;
	private String bankName;
	private String accountNo;
	private String ifsc;

	private String remarks;

	private String createdDate;
	private String createdTime;
	private String createdBy;
	private String orgName;
	private String orgDivision;
	// private String expertizeId;
	// private String expertizeName;
	private Double reqSent;
	private Double candidates;
	private Double closed;
	private String vendorIdHead;

	private String cinno;
	private String branchDetails;
	private String delLocDetails;
	private String pocDetails;
	private String bankDetails;
	private String productDetails;

	public RestVendorNewModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestVendorNewModel(Object vendorId, Object vendorName, Object createdDate, Object createdBy, Object reqSent,
			Object candidates, Object closed) {
		super();
		this.vendorId = (String) vendorId;
		this.vendorName = (String) vendorName;
		this.createdDate = (String) createdDate;
		this.createdBy = (String) createdBy;

		this.reqSent = (Double) reqSent;
		this.candidates = (Double) candidates;
		this.closed = (Double) closed;
	}

	public RestVendorNewModel(Object vendorId, Object salutation, Object vendorName, Object companyName,
			Object vendorDisplayName, Object vendorEmail, Object vendorPhone, Object vendorMobile, Object vendorSkype,
			Object vendorDesignation, Object department, Object webSite, Object pan, Object currency,
			Object openingBalance, Object paymentTerms, Object tds, Object faceBook, Object twitter, Object country,
			Object states, Object city, Object street1, Object street2, Object zipCode, Object phone, Object fax,
			Object country1, Object states1, Object city1, Object street11, Object street21, Object zipCode1,
			Object phone1, Object fax1, Object salutation1, Object firstName, Object lastName, Object emailAdd,
			Object mobile, Object beneficiaryName, Object bankName, Object accountNo, Object ifsc, Object remarks,
			Object createdDate, Object createdTime, Object gstNumber, Object vendorCategory, Object whatsAppNo,
			Object tanNo, Object orgName, Object orgDivision, Object cinno, Object branchDetails, Object delLocDetails,
			Object pocDetails, Object bankDetails, Object productDetails) {
		super();

		try {
			this.vendorId = (String) vendorId;
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
			this.vendorName = (String) vendorName;
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
			this.vendorDisplayName = (String) vendorDisplayName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorEmail = (String) vendorEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorPhone = (String) vendorPhone;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorMobile = (String) vendorMobile;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.vendorSkype = (String) vendorSkype;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorDesignation = (String) vendorDesignation;
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
			this.tds = (String) tds;
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
			this.beneficiaryName = (String) beneficiaryName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.bankName = (String) bankName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.accountNo = (String) accountNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.ifsc = (String) ifsc;
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

		try {
			this.gstNumber = (String) gstNumber;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.vendorCategory = (String) vendorCategory;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.whatsAppNo = (String) whatsAppNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.tanNo = (String) tanNo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.orgName = (String) orgName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.orgDivision = (String) orgDivision;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.cinno = (String) cinno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.branchDetails = (String) branchDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.delLocDetails = (String) delLocDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.pocDetails = (String) pocDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.bankDetails = (String) bankDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.productDetails = (String) productDetails;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getVendorId() {
		return vendorId;
	}

	public String getVendorType() {
		return vendorType;
	}

	public void setVendorType(String vendorType) {
		this.vendorType = vendorType;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getVendorDisplayName() {
		return vendorDisplayName;
	}

	public void setVendorDisplayName(String vendorDisplayName) {
		this.vendorDisplayName = vendorDisplayName;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public String getVendorPhone() {
		return vendorPhone;
	}

	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}

	public String getVendorMobile() {
		return vendorMobile;
	}

	public void setVendorMobile(String vendorMobile) {
		this.vendorMobile = vendorMobile;
	}

	public String getVendorSkype() {
		return vendorSkype;
	}

	public void setVendorSkype(String vendorSkype) {
		this.vendorSkype = vendorSkype;
	}

	public String getVendorDesignation() {
		return vendorDesignation;
	}

	public void setVendorDesignation(String vendorDesignation) {
		this.vendorDesignation = vendorDesignation;
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

	public String getTds() {
		return tds;
	}

	public void setTds(String tds) {
		this.tds = tds;
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

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
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

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getVendorCategory() {
		return vendorCategory;
	}

	public void setVendorCategory(String vendorCategory) {
		this.vendorCategory = vendorCategory;
	}

	public String getWhatsAppNo() {
		return whatsAppNo;
	}

	public void setWhatsAppNo(String whatsAppNo) {
		this.whatsAppNo = whatsAppNo;
	}

	public String getTanNo() {
		return tanNo;
	}

	public void setTanNo(String tanNo) {
		this.tanNo = tanNo;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgDivision() {
		return orgDivision;
	}

	public void setOrgDivision(String orgDivision) {
		this.orgDivision = orgDivision;
	}

	public Double getReqSent() {
		return reqSent;
	}

	public void setReqSent(Double reqSent) {
		this.reqSent = reqSent;
	}

	public Double getCandidates() {
		return candidates;
	}

	public void setCandidates(Double candidates) {
		this.candidates = candidates;
	}

	public Double getClosed() {
		return closed;
	}

	public void setClosed(Double closed) {
		this.closed = closed;
	}

	public String getVendorIdHead() {
		return vendorIdHead;
	}

	public void setVendorIdHead(String vendorIdHead) {
		this.vendorIdHead = vendorIdHead;
	}

	public String getCinno() {
		return cinno;
	}

	public void setCinno(String cinno) {
		this.cinno = cinno;
	}

	public String getBranchDetails() {
		return branchDetails;
	}

	public void setBranchDetails(String branchDetails) {
		this.branchDetails = branchDetails;
	}

	public String getDelLocDetails() {
		return delLocDetails;
	}

	public void setDelLocDetails(String delLocDetails) {
		this.delLocDetails = delLocDetails;
	}

	public String getPocDetails() {
		return pocDetails;
	}

	public void setPocDetails(String pocDetails) {
		this.pocDetails = pocDetails;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
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
