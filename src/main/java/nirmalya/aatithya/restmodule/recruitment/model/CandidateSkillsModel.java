package nirmalya.aatithya.restmodule.recruitment.model;

public class CandidateSkillsModel {

	private String candidateId;
	private String skillId;
	private String skills;
	private String skillDesc;
	private String skillLevel;
	private String experience;
	private String createdBy;
	public CandidateSkillsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateSkillsModel(Object candidateId, Object skillId, Object skills, Object skillDesc, Object skillLevel,
			Object experience, Object createdBy) {
		super();
		this.candidateId = (String) candidateId;
		this.skillId = (String) skillId;
		this.skills = (String) skills;
		this.skillDesc = (String) skillDesc;
		this.skillLevel = (String) skillLevel;
		this.experience = (String) experience;
		this.createdBy = (String) createdBy;
	}
	public String getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}
	public String getSkillId() {
		return skillId;
	}
	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getSkillDesc() {
		return skillDesc;
	}
	public void setSkillDesc(String skillDesc) {
		this.skillDesc = skillDesc;
	}
	public String getSkillLevel() {
		return skillLevel;
	}
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
