package nirmalya.aatithya.restmodule.pipeline.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestPipelineModel {
	private String pipelineId;
	private String oppertunity;
	private Double expectedRevenue;
	private Double probability;
	private String customer;
	private String email;
	private String phone;
	private String saleperson;
	private String salesTeam;
	private String expectedClosing;
	private String priority;
	private String tags;
	private String company;
	private String description;
	private String campanyName;
	private String addressStreet;
	private String addressStreet2;
	private String city;
	private String states;
	private String zip;
	private String country;
	private String website;
	private String language;
	private String contactName;
	private String tittle;
	private String jobPosition;
	private String mobile;
	private String referdBy;
	private String campaign;
	private String medium;
	private String source;
	private String createdBy;
	private Integer previousStage;
	private Integer currentStage;
	private String fromStage;
	private Integer toStage;
	private String createdDate;
	private List<String> fromStageList = new ArrayList<String>();
	private List<String> toStageList = new ArrayList<String>();	
	private List<String> createdDateList = new ArrayList<String>();
	private Integer pipelineStatus;
	private String statusName;
	private String meetingId;
	private String Summary;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private String title;
	private String customerId;
	private String location;
	private String descriptionMeeting;
	
	public RestPipelineModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestPipelineModel(Object pipelineId, Object oppertunity,Object expectedRevenue,Object probability,Object customer,Object email,Object phone,Object saleperson,Object salesTeam,
			Object expectedClosing,Object priority,Object tags,Object company,Object description,Object campanyName,Object addressStreet,Object addressStreet2,Object city,Object states,
			Object zip,Object country,Object website,Object language,Object contactName,Object tittle,Object jobPosition,Object mobile,Object referdBy,Object campaign,Object medium,Object source,
			Object previousStage,Object fromStage,Object toStage,Object createdDate,Object createdBy,Object pipelineStatus,Object statusName,Object meetingId,Object Summary,Object fromDate,Object toDate,Object fromTime,Object toTime,Object title,Object customerId,Object location,Object descriptionMeeting) {
		super();
		try {
			this.pipelineId = (String) pipelineId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.oppertunity = (String) oppertunity;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.expectedRevenue = (Double) expectedRevenue;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.probability = (Double) probability;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.customer = (String) customer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.email = (String) email;
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
			this.saleperson = (String) saleperson;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.salesTeam = (String) salesTeam;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.expectedClosing = (String) expectedClosing;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.priority = (String) priority;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.tags = (String) tags;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.company = (String) company;
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
			this.campanyName = (String) campanyName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.addressStreet = (String) addressStreet;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.addressStreet2 = (String) addressStreet2;
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
			this.states = (String) states;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.zip = (String) zip;
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
			this.website = (String) website;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.language = (String) language;
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
			this.tittle = (String) tittle;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.jobPosition = (String) jobPosition;
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
			this.referdBy = (String) referdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.campaign = (String) campaign;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.medium = (String) medium;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.source = (String) source;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.previousStage = (Integer) previousStage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.fromStage = (String) fromStage;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.toStage = (Integer) toStage;
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
			this.createdBy = (String) createdBy;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.pipelineStatus = (Integer) pipelineStatus;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.statusName = (String) statusName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.meetingId = (String) meetingId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.Summary = (String) Summary;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.fromDate = (String) fromDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.toDate = (String) toDate;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.fromTime = (String) fromTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.toTime = (String) toTime;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.title = (String) title;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.customerId = (String) customerId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.location = (String) location;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.descriptionMeeting = (String) descriptionMeeting;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getPipelineId() {
		return pipelineId;
	}

	public void setPipelineId(String pipelineId) {
		this.pipelineId = pipelineId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getOppertunity() {
		return oppertunity;
	}

	public void setOppertunity(String oppertunity) {
		this.oppertunity = oppertunity;
	}

	

	public Double getExpectedRevenue() {
		return expectedRevenue;
	}

	public void setExpectedRevenue(Double expectedRevenue) {
		this.expectedRevenue = expectedRevenue;
	}

	public Double getProbability() {
		return probability;
	}

	public void setProbability(Double probability) {
		this.probability = probability;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSaleperson() {
		return saleperson;
	}

	public void setSaleperson(String saleperson) {
		this.saleperson = saleperson;
	}

	public String getSalesTeam() {
		return salesTeam;
	}

	public void setSalesTeam(String salesTeam) {
		this.salesTeam = salesTeam;
	}

	public String getExpectedClosing() {
		return expectedClosing;
	}

	public void setExpectedClosing(String expectedClosing) {
		this.expectedClosing = expectedClosing;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCampanyName() {
		return campanyName;
	}

	public void setCampanyName(String campanyName) {
		this.campanyName = campanyName;
	}

	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public String getAddressStreet2() {
		return addressStreet2;
	}

	public void setAddressStreet2(String addressStreet2) {
		this.addressStreet2 = addressStreet2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}



	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getReferdBy() {
		return referdBy;
	}

	public void setReferdBy(String referdBy) {
		this.referdBy = referdBy;
	}

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Integer getPreviousStage() {
		return previousStage;
	}

	public void setPreviousStage(Integer previousStage) {
		this.previousStage = previousStage;
	}

	public Integer getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(Integer currentStage) {
		this.currentStage = currentStage;
	}

	public String getFromStage() {
		return fromStage;
	}

	public void setFromStage(String fromStage) {
		this.fromStage = fromStage;
	}

	public Integer getToStage() {
		return toStage;
	}

	public void setToStage(Integer toStage) {
		this.toStage = toStage;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public List<String> getFromStageList() {
		return fromStageList;
	}

	public void setFromStageList(List<String> fromStageList) {
		this.fromStageList = fromStageList;
	}

	public List<String> getToStageList() {
		return toStageList;
	}

	public void setToStageList(List<String> toStageList) {
		this.toStageList = toStageList;
	}

	public List<String> getCreatedDateList() {
		return createdDateList;
	}

	public void setCreatedDateList(List<String> createdDateList) {
		this.createdDateList = createdDateList;
	}

	public Integer getPipelineStatus() {
		return pipelineStatus;
	}

	public void setPipelineStatus(Integer pipelineStatus) {
		this.pipelineStatus = pipelineStatus;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMeetingId() {
		return meetingId;
	}


	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}



	public String getSummary() {
		return Summary;
	}


	public void setSummary(String summary) {
		Summary = summary;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	public String getFromTime() {
		return fromTime;
	}


	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}


	public String getToTime() {
		return toTime;
	}


	public void setToTime(String toTime) {
		this.toTime = toTime;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getCustomerId() {
		return customerId;
	}


	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getDescriptionMeeting() {
		return descriptionMeeting;
	}


	public void setDescriptionMeeting(String descriptionMeeting) {
		this.descriptionMeeting = descriptionMeeting;
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
