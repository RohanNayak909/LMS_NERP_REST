package nirmalya.aatithya.restmodule.inventory.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestShoukeenDealerModel {
	private String dealerId;
	private String dealerName;
	private String dealerMobile;
	private String dealerEmail;
	private String dealerPassword;
	private String legalName;
	
	private String storeName;	
	private String productCategory;
	private String country;
	private String states;
	private String city;
	private String address1;
	private String address2;
	private String pinCode;
		
	private String isTaxable;
	private String taxStateGst;
	private String provisionalGSTINNo;
	private String panNumber;
	private String buyProductFrom;
	private String annualTurnOver;
	private String annualSell;
	private String sellOnOtherWebsiteYesOrNo;
	

	private String otherWebsiteName;
	private String productCategoryWishToSell;
	private String description;
	private String isAgreeWithTermCondition;
	private String imageName;
	
	private String createdDate;
	private String createdTime;
	private String updatedDate;
	private String createdBy;
	
public RestShoukeenDealerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

public RestShoukeenDealerModel(Object dealerId, Object dealerName, Object dealerMobile, Object dealerEmail,
		Object dealerPassword, Object legalName, Object storeName, Object productCategory,
		Object country, Object states, Object city, Object address1,
		Object address2, Object pinCode, Object isTaxable, Object taxStateGst,
		Object provisionalGSTINNo, Object panNumber, Object buyProductFrom, Object annualTurnOver,
		Object annualSell, Object sellOnOtherWebsiteYesOrNo, Object otherWebsiteName,  
		Object productCategoryWishToSell, Object description,
		Object isAgreeWithTermCondition, Object imageName) {
	
	super();
	try {
		this.dealerId = (String) dealerId;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	try {
		this.dealerName = (String) dealerName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.dealerMobile = (String) dealerMobile;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.dealerEmail = (String) dealerEmail;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	try {
		this.dealerPassword = (String) dealerPassword;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.legalName = (String) legalName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	try {
		this.storeName = (String) storeName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.productCategory = (String) productCategory;
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
		this.address1 = (String) address1;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.address2 = (String) address2;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.pinCode = (String) pinCode;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.isTaxable = (String) isTaxable;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.taxStateGst = (String) taxStateGst;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		this.provisionalGSTINNo = (String) provisionalGSTINNo;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.panNumber = (String) panNumber;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.buyProductFrom = (String) buyProductFrom;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.annualTurnOver = (String) annualTurnOver;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	try {
		this.annualSell = (String) annualSell;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.sellOnOtherWebsiteYesOrNo = (String) sellOnOtherWebsiteYesOrNo;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.otherWebsiteName = (String) otherWebsiteName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.productCategoryWishToSell = (String) productCategoryWishToSell;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.description = (String) description;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.isAgreeWithTermCondition = (String) isAgreeWithTermCondition;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		this.imageName = (String) imageName;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}


	public RestShoukeenDealerModel(Object dealerId, Object dealerName, 
			Object dealerEmail, Object dealerMobile, Object city,
			Object createdDate, Object createdTime) {
		
		super();
		try {
			this.dealerId = (String) dealerId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.dealerName = (String) dealerName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dealerEmail = (String) dealerEmail;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		try {
			this.dealerMobile = (String) dealerMobile;
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
	
	


	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getDealerId() {
		return dealerId;
	}




	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public void setDealerId(String dealerId) {
		this.dealerId = dealerId;
	}




	public String getDealerName() {
		return dealerName;
	}




	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}




	public String getDealerMobile() {
		return dealerMobile;
	}




	public void setDealerMobile(String dealerMobile) {
		this.dealerMobile = dealerMobile;
	}




	public String getDealerEmail() {
		return dealerEmail;
	}




	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}




	public String getDealerPassword() {
		return dealerPassword;
	}




	public void setDealerPassword(String dealerPassword) {
		this.dealerPassword = dealerPassword;
	}




	public String getLegalName() {
		return legalName;
	}




	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}




	public String getStoreName() {
		return storeName;
	}




	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}




	public String getProductCategory() {
		return productCategory;
	}




	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
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




	public String getAddress1() {
		return address1;
	}




	public void setAddress1(String address1) {
		this.address1 = address1;
	}




	public String getAddress2() {
		return address2;
	}




	public void setAddress2(String address2) {
		this.address2 = address2;
	}




	public String getPinCode() {
		return pinCode;
	}




	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}




	public String getIsTaxable() {
		return isTaxable;
	}




	public void setIsTaxable(String isTaxable) {
		this.isTaxable = isTaxable;
	}




	public String getTaxStateGst() {
		return taxStateGst;
	}




	public void setTaxStateGst(String taxStateGst) {
		this.taxStateGst = taxStateGst;
	}




	public String getProvisionalGSTINNo() {
		return provisionalGSTINNo;
	}




	public void setProvisionalGSTINNo(String provisionalGSTINNo) {
		this.provisionalGSTINNo = provisionalGSTINNo;
	}




	public String getPanNumber() {
		return panNumber;
	}




	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}




	public String getBuyProductFrom() {
		return buyProductFrom;
	}




	public void setBuyProductFrom(String buyProductFrom) {
		this.buyProductFrom = buyProductFrom;
	}




	public String getAnnualTurnOver() {
		return annualTurnOver;
	}




	public void setAnnualTurnOver(String annualTurnOver) {
		this.annualTurnOver = annualTurnOver;
	}




	public String getAnnualSell() {
		return annualSell;
	}




	public void setAnnualSell(String annualSell) {
		this.annualSell = annualSell;
	}





	public String getSellOnOtherWebsiteYesOrNo() {
		return sellOnOtherWebsiteYesOrNo;
	}



	public void setSellOnOtherWebsiteYesOrNo(String sellOnOtherWebsiteYesOrNo) {
		this.sellOnOtherWebsiteYesOrNo = sellOnOtherWebsiteYesOrNo;
	}



	public String getOtherWebsiteName() {
		return otherWebsiteName;
	}




	public void setOtherWebsiteName(String otherWebsiteName) {
		this.otherWebsiteName = otherWebsiteName;
	}




	public String getProductCategoryWishToSell() {
		return productCategoryWishToSell;
	}




	public void setProductCategoryWishToSell(String productCategoryWishToSell) {
		this.productCategoryWishToSell = productCategoryWishToSell;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getIsAgreeWithTermCondition() {
		return isAgreeWithTermCondition;
	}




	public void setIsAgreeWithTermCondition(String isAgreeWithTermCondition) {
		this.isAgreeWithTermCondition = isAgreeWithTermCondition;
	}




	public String getImageName() {
		return imageName;
	}




	public void setImageName(String imageName) {
		this.imageName = imageName;
	}




	public String getCreatedDate() {
		return createdDate;
	}




	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}




	public String getUpdatedDate() {
		return updatedDate;
	}




	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
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
