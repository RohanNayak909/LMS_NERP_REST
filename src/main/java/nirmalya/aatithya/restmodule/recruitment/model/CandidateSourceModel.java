package nirmalya.aatithya.restmodule.recruitment.model;

public class CandidateSourceModel {

	public String candidateId;
	public String sourceId;
	public String name;
	public String description;
	public String createdBy;
	public CandidateSourceModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateSourceModel(Object candidateId, Object sourceId, Object name, Object description,
			Object createdBy) {
		super();
		this.candidateId = (String) candidateId;
		this.sourceId = (String) sourceId;
		this.name = (String) name;
		this.description = (String) description;
		this.createdBy = (String) createdBy;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
