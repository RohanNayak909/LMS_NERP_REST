package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestDealModel {
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
	private String createdTime;
	private String ownerImage;
	private String createdBy;

	private String accountId;
	private String campaignSourceId;
	private String contactId;

	private String stageId;
	private String stageDuration;
	private String updatedOn;
	private String updatedBy;
	private String stageName;
	private String preStageName;

	private String organization;
	private String orgDivision;

	private String stageSummary;
	private String previousStage;
	
	public String getPreviousStage() {
		return previousStage;
	}

	public void setPreviousStage(String previousStage) {
		this.previousStage = previousStage;
	}

	public String getStageSummary() {
		return stageSummary;
	}

	public void setStageSummary(String stageSummary) {
		this.stageSummary = stageSummary;
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

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getOwnerImage() {
		return ownerImage;
	}

	public void setOwnerImage(String ownerImage) {
		this.ownerImage = ownerImage;
	}

	public String getPreStageName() {
		return preStageName;
	}

	public void setPreStageName(String preStageName) {
		this.preStageName = preStageName;
	}

	public RestDealModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * public RestDealModel(String dealName,String dealAmount, String
	 * dealStage,String dealClosingDate, String createdDate,String dealType, String
	 * probability, String nextStep, String expectedRevenue,String
	 * description,String dealOwner) {
	 * 
	 * super(); this.dealName = dealName; this.dealAmount = dealAmount;
	 * this.dealStage = dealStage; this.dealClosingDate = dealClosingDate;
	 * this.createdDate = createdDate; this.dealType = dealType; this.probability =
	 * probability; this.nextStep = nextStep; this.expectedRevenue =
	 * expectedRevenue; this.description = description; this.dealOwner = dealOwner;
	 * }
	 */

	public RestDealModel(Object stageId, Object stageName, Object dealId, Object dealName, Object dealAmount,
			Object probability, Object expectedRevenue, Object dealClosingDate, Object updatedOn, Object updatedBy,Object stageSummary) {

		super();

		try {
			this.stageId = (String) stageId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.stageName = (String) stageName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.dealId = (String) dealId;
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
			this.dealAmount = (String) dealAmount;
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
			this.expectedRevenue = (String) expectedRevenue;
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
			this.updatedOn = (String) updatedOn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.updatedBy = (String) updatedBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.stageSummary = (String) stageSummary;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public RestDealModel(Object dealId, Object dealOwner, Object dealAmount, Object dealName, Object dealClosingDate,
			Object dealAccountName, Object dealStage, Object dealType, Object probability, Object nextStep,
			Object expectedRevenue, Object dealLeadSource, Object campaignSource, Object contactName,
			Object description, Object createdDate, Object accountId, Object campaignSourceId, Object contactId,
			Object stageId, Object createdTime, Object ownerImage) {

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
		try {
			this.accountId = (String) accountId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.campaignSourceId = (String) campaignSourceId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.contactId = (String) contactId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.stageId = (String) stageId;
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
			this.ownerImage = (String) ownerImage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RestDealModel(String dealId, String dealOwner, String dealAmount, String dealName, String dealClosingDate,
			String dealAccountName, String dealStage, String dealType, String probability, String nextStep,
			String expectedRevenue, String dealLeadSource, String campaignSource, String contactName,
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

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	public String getStageDuration() {
		return stageDuration;
	}

	public void setStageDuration(String stageDuration) {
		this.stageDuration = stageDuration;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
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

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCampaignSourceId() {
		return campaignSourceId;
	}

	public void setCampaignSourceId(String campaignSourceId) {
		this.campaignSourceId = campaignSourceId;
	}

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
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
