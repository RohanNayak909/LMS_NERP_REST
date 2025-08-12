package nirmalya.aatithya.restmodule.recruitment.model;

public class CandidateReferenceModel {

	private String candidateId;
	private String referenceId;
	private String name;
	private String mobileNo;
	private String emailId;
	private String description;
	private String createdBy;
	public CandidateReferenceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateReferenceModel(Object candidateId, Object referenceId, Object name, Object mobileNo, Object emailId,
			Object description, Object createdBy) {
		super();
		this.candidateId = (String) candidateId;
		this.referenceId = (String) referenceId;
		this.name = (String) name;
		this.mobileNo = (String) mobileNo;
		this.emailId = (String) emailId;
		this.description = (String) description;
		this.createdBy = (String) createdBy;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
}
