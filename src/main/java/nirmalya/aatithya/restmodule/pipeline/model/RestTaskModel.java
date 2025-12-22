package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTaskModel {
	private String dealId;
	private String dealLeadSource;
	private String campaignSource;
	private String contactName;
	private String dealAccountName;
	private String dealAmount;
	private String dealClosingDate;
	private String dealName;
	private String dealOwner;
	private String dealStage;
	private String dealType;
	private String description;
	private String expectedRevenue;
	private String nextStep;
	private String probability;
	private String createdDate;
	private String createdBy;
	
	public RestTaskModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public RestTaskModel(Object dealId, Object dealOwner,Object dealAmount, Object dealName, Object dealClosingDate,
			Object dealAccountName, Object dealStage, Object dealType, Object probability, Object nextStep,
			Object expectedRevenue,Object dealLeadSource, Object campaignSource, Object contactName,
			Object description, Object createdDate) {
		
		
		super();
		try {
			this.dealId = (String) dealId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.dealOwner = (String) dealOwner;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dealAmount = (String) dealAmount;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			this.dealName = (String) dealName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dealClosingDate = (String) dealClosingDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.dealAccountName = (String) dealAccountName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dealStage = (String) dealStage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.dealType = (String) dealType;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.probability = (String) probability;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.nextStep = (String) nextStep;
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
			this.dealLeadSource = (String) dealLeadSource;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			this.campaignSource = (String) campaignSource;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			this.contactName = (String) contactName;
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
			this.createdDate = (String) createdDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public RestTaskModel(String dealId, String dealOwner, String dealAmount, String dealName, String dealClosingDate,
			String dealAccountName, String dealStage, String dealType, String probability, String nextStep,
			String expectedRevenue,String dealLeadSource, String campaignSource, String contactName,
			String description, String createdDate) {
	
		super();
		this.dealId = dealId;
		this.dealOwner = dealOwner;
		this.dealAmount = dealAmount;
		this.dealName = dealName;
		this.dealClosingDate = dealClosingDate;
		this.dealAccountName = dealAccountName;
		this.dealStage = dealStage;
		this.dealType = dealType;
		this.probability = probability;
		this.nextStep = nextStep;
		this.expectedRevenue = expectedRevenue;
		this.dealLeadSource = dealLeadSource;
		this.campaignSource = campaignSource;
		this.contactName = contactName;
		this.description = description;
		this.createdDate = createdDate;
	}

	
	
	

	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getDealId() {
		return dealId;
	}



	public void setDealId(String dealId) {
		this.dealId = dealId;
	}



	

	public String getDealLeadSource() {
		return dealLeadSource;
	}



	public void setDealLeadSource(String dealLeadSource) {
		this.dealLeadSource = dealLeadSource;
	}



	public String getCampaignSource() {
		return campaignSource;
	}



	public void setCampaignSource(String campaignSource) {
		this.campaignSource = campaignSource;
	}



	public String getContactName() {
		return contactName;
	}



	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



	public String getDealAccountName() {
		return dealAccountName;
	}



	public void setDealAccountName(String dealAccountName) {
		this.dealAccountName = dealAccountName;
	}



	public String getDealAmount() {
		return dealAmount;
	}



	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}



	public String getDealClosingDate() {
		return dealClosingDate;
	}



	public void setDealClosingDate(String dealClosingDate) {
		this.dealClosingDate = dealClosingDate;
	}



	public String getDealName() {
		return dealName;
	}



	public void setDealName(String dealName) {
		this.dealName = dealName;
	}



	public String getDealOwner() {
		return dealOwner;
	}



	public void setDealOwner(String dealOwner) {
		this.dealOwner = dealOwner;
	}



	public String getDealStage() {
		return dealStage;
	}



	public void setDealStage(String dealStage) {
		this.dealStage = dealStage;
	}



	public String getDealType() {
		return dealType;
	}



	public void setDealType(String dealType) {
		this.dealType = dealType;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getExpectedRevenue() {
		return expectedRevenue;
	}



	public void setExpectedRevenue(String expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}



	public String getNextStep() {
		return nextStep;
	}



	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}



	public String getProbability() {
		return probability;
	}



	public void setProbability(String probability) {
		this.probability = probability;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
