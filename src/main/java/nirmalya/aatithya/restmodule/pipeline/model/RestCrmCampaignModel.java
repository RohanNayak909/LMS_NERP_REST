package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestCrmCampaignModel {
	
	private String campaignId;
	private String campaignOwner;
	private String campaignType;
	private String campaignName;
	private String campaignStatus;
	private String startDate;
	private String endDate;
	private String expectedRevenue;
	private String budgetedCost;
	private String actualCost;
	private String expectedResponse;	
	private String numberSent;
	private String description;
	private String createdBy;
	private String createdOn;
	private String leadId;
	private String campaignContactId;
	private String campaignAccountId;
	private String ownerName;
	private String pageType;
	
	private String accountId;
	
	private String totalPageno;
	private String totalOrderById;
	
	private String organization;
	private String orgDivision;
	
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
	public String getTotalPageno() {
		return totalPageno;
	}
	public void setTotalPageno(String totalPageno) {
		this.totalPageno = totalPageno;
	}
	public String getTotalOrderById() {
		return totalOrderById;
	}
	public void setTotalOrderById(String totalOrderById) {
		this.totalOrderById = totalOrderById;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public RestCrmCampaignModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestCrmCampaignModel(Object campaignId, Object campaignOwner, Object campaignType, Object campaignName,
			Object campaignStatus, Object startDate, Object endDate,Object expectedRevenue, Object budgetedCost,Object actualCost,
			Object expectedResponse, Object numberSent,
			Object description,  Object createdBy,
			Object createdOn,Object totalPageno,Object totalOrderById) {
		
		
		super();
		try {
			this.campaignId = (String) campaignId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.campaignOwner = (String) campaignOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.campaignType = (String) campaignType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.campaignName = (String) campaignName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.campaignStatus = (String) campaignStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.startDate = (String) startDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.endDate = (String) endDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.expectedRevenue = (String) expectedRevenue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.budgetedCost = (String) budgetedCost;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.actualCost = (String) actualCost;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.expectedResponse = (String) expectedResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.numberSent = (String) numberSent;
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
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		try {
			this.totalPageno = (String) totalPageno;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.totalOrderById = (String) totalOrderById;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RestCrmCampaignModel(Object campaignId, Object campaignOwner, Object campaignType, Object campaignName,
			Object campaignStatus, Object startDate, Object endDate,Object expectedRevenue, Object budgetedCost,Object actualCost,
			Object expectedResponse, Object numberSent,
			Object description,  Object createdBy,
			Object createdOn) {
		
		
		super();
		try {
			this.campaignId = (String) campaignId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.campaignOwner = (String) campaignOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.campaignType = (String) campaignType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.campaignName = (String) campaignName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.campaignStatus = (String) campaignStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.startDate = (String) startDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.endDate = (String) endDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.expectedRevenue = (String) expectedRevenue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.budgetedCost = (String) budgetedCost;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.actualCost = (String) actualCost;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.expectedResponse = (String) expectedResponse;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.numberSent = (String) numberSent;
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
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.createdOn = (String) createdOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


	public String getLeadId() {
		return leadId;
	}
	
	public void setLeadId(String leadId) {
		this.leadId = leadId;
	}
	
	public String getCampaignId() {
		return campaignId;
	}


	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}


	public String getCampaignOwner() {
		return campaignOwner;
	}


	public void setCampaignOwner(String campaignOwner) {
		this.campaignOwner = campaignOwner;
	}


	public String getCampaignType() {
		return campaignType;
	}
	

	public String getCampaignContactId() {
		return campaignContactId;
	}
	public void setCampaignContactId(String campaignContactId) {
		this.campaignContactId = campaignContactId;
	}
	public void setCampaignType(String campaignType) {
		this.campaignType = campaignType;
	}

	public String getCampaignName() {
		return campaignName;
	}


	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}


	public String getCampaignStatus() {
		return campaignStatus;
	}


	public void setCampaignStatus(String campaignStatus) {
		this.campaignStatus = campaignStatus;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getExpectedRevenue() {
		return expectedRevenue;
	}


	public void setExpectedRevenue(String expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}


	public String getBudgetedCost() {
		return budgetedCost;
	}


	public void setBudgetedCost(String budgetedCost) {
		this.budgetedCost = budgetedCost;
	}


	public String getActualCost() {
		return actualCost;
	}


	public void setActualCost(String actualCost) {
		this.actualCost = actualCost;
	}

	public String getExpectedResponse() {
		return expectedResponse;
	}


	public void setExpectedResponse(String expectedResponse) {
		this.expectedResponse = expectedResponse;
	}


	public String getNumberSent() {
		return numberSent;
	}


	public void setNumberSent(String numberSent) {
		this.numberSent = numberSent;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}



	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public String getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
	public String getCampaignAccountId() {
		return campaignAccountId;
	}
	public void setCampaignAccountId(String campaignAccountId) {
		this.campaignAccountId = campaignAccountId;
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
