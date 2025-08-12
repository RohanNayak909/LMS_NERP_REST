package nirmalya.aatithya.restmodule.recruitment.model;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CandidateEducationModel {

	private String candidaateId;
	private String educationId;
	private String qualification;
	private String institution;
	private String passingYear;
	private String createdBy;
	private String qualificationId;
	public CandidateEducationModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateEducationModel(Object candidaateId, Object educationId, Object qualification, Object institution,
			Object passingYear, Object createdBy, Object qualificationId) {
		super();
		this.candidaateId = (String) candidaateId;
		this.educationId = (String) educationId;
		this.qualification = (String) qualification;
		this.institution = (String) institution;
		this.passingYear = (String) passingYear;
		this.createdBy = (String) createdBy;
		this.qualificationId = (String) qualificationId;
	}
	public String getCandidaateId() {
		return candidaateId;
	}
	public void setCandidaateId(String candidaateId) {
		this.candidaateId = candidaateId;
	}
	public String getEducationId() {
		return educationId;
	}
	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPassingYear() {
		return passingYear;
	}
	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(String qualificationId) {
		this.qualificationId = qualificationId;
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
