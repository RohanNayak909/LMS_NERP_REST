package nirmalya.aatithya.restmodule.recruitment.model;

public class CandidateAwardsModel {

	private String candidateId;
	private String awardId;
	private String awardName;
	private String awardYear;
	private String awardDescription;
	private String createdBy;
	public CandidateAwardsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateAwardsModel(Object candidateId, Object awardId, Object awardName, Object awardYear,
			Object awardDescription, Object createdBy) {
		super();
		this.candidateId = (String) candidateId;
		this.awardId = (String) awardId;
		this.awardName = (String) awardName;
		this.awardYear = (String) awardYear;
		this.awardDescription = (String) awardDescription;
		this.createdBy = (String) createdBy;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getAwardId() {
		return awardId;
	}
	public void setAwardId(String awardId) {
		this.awardId = awardId;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public String getAwardYear() {
		return awardYear;
	}
	public void setAwardYear(String awardYear) {
		this.awardYear = awardYear;
	}
	public String getAwardDescription() {
		return awardDescription;
	}
	public void setAwardDescription(String awardDescription) {
		this.awardDescription = awardDescription;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
