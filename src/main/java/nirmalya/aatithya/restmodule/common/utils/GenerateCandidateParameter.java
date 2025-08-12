package nirmalya.aatithya.restmodule.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateAddressModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateApplyRequisitionModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateAwardsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDetailsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateDocumentModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateEducationModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateReferenceModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateSkillsModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateSourceModel;
import nirmalya.aatithya.restmodule.recruitment.model.CandidateWorkExperienceModel;
import nirmalya.aatithya.restmodule.recruitment.model.candidateBankAccountDetailsRestModel;

public class GenerateCandidateParameter {

	/*public static String addPersonalDetails(CandidateDetailsModel form) {
		String s = "";
		// String qItem = "";
		String addReq = "";

		if (form.getCandidateId() == null || form.getCandidateId() == "") {

			if (form.getDob() == null || form.getDob() == "") {
				addReq = addReq + "(@p_candidateId,\"" + form.getFirstName() + "\",\"" + form.getLastName() + "\",\""
						+ form.getGender() + "\"," + null + ",\"" + form.getBloodGroup() + "\",\""
						+ form.getMaritalStatus() + "\",\"" + form.getNationality() + "\",\"" + form.getFatherName()
						+ "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo() + "\",\""
						+ form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\"" + form.getAadharNo()
						+ "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\"" + form.getFileUpload()
						+ "\",\"" + form.getCreatedBy() + "\",\"" + form.getOrganization() + "\",\""
						+ form.getOrgDivision() + "\",\"" + form.getCreatedBy() + "\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			} else {
				addReq = addReq + "(@p_candidateId,\"" + form.getFirstName() + "\",\"" + form.getLastName() + "\",\""
						+ form.getGender() + "\",\"" + form.getDob() + "\",\"" + form.getBloodGroup() + "\",\""
						+ form.getMaritalStatus() + "\",\"" + form.getNationality() + "\",\"" + form.getFatherName()
						+ "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo() + "\",\""
						+ form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\"" + form.getAadharNo()
						+ "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\"" + form.getFileUpload()
						+ "\",\"" + form.getCreatedBy() + "\",\"" + form.getOrganization() + "\",\""
						+ form.getOrgDivision() + "\",\"" + form.getCreatedBy() + "\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			}

			s = s + "@p_activityBy='" + form.getCreatedBy() + "',";

		} else {
			if (form.getDob() == null || form.getDob() == "") {
				addReq = addReq + "(\"" + form.getCandidateId() + "\",\"" + form.getFirstName() + "\",\""
						+ form.getLastName() + "\",\"" + form.getGender() + "\"," + null + ",\"" + form.getBloodGroup()
						+ "\",\"" + form.getMaritalStatus() + "\",\"" + form.getNationality() + "\",\""
						+ form.getFatherName() + "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo() + "\",\""
						+ form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\"" + form.getAadharNo()
						+ "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\"" + form.getFileUpload()
						+ "\",\"" + form.getOrganization() + "\",\"" + form.getOrgDivision() + "\",\""
						+ form.getCreatedBy() + "\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			} else {
				addReq = addReq + "(\"" + form.getCandidateId() + "\",\"" + form.getFirstName() + "\",\""
						+ form.getLastName() + "\",\"" + form.getGender() + "\",\"" + form.getDob() + "\",\""
						+ form.getBloodGroup() + "\",\"" + form.getMaritalStatus() + "\",\"" + form.getNationality()
						+ "\",\"" + form.getFatherName() + "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo()
						+ "\",\"" + form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\""
						+ form.getAadharNo() + "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\""
						+ form.getFileUpload() + "\",\"" + form.getOrganization() + "\",\"" + form.getOrgDivision()
						+ "\",\"" + form.getCreatedBy() + "\"),";
				addReq = addReq.substring(0, addReq.length() - 1);
			}

			s = s + "@p_candidateId='" + form.getCandidateId() + "',";
			s = s + "@p_activityBy='" + form.getCreatedBy() + "',";
		}

		s = s + "@p_addCandidate='" + addReq + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}*/

	public static String addPersonalDetails(CandidateDetailsModel form) {
	    String s = "";
	    String addReq = "";
	    
	    // Initialize BCryptPasswordEncoder
	    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    
	    // Encode password if it's present
	    String encodedPassword = form.getPassword() != null ? passwordEncoder.encode(form.getPassword()) : null;

	    if (form.getCandidateId() == null || form.getCandidateId().isEmpty()) {
	        addReq = addReq + "(@p_candidateId,\"" + form.getFirstName() + "\",\"" + form.getLastName() + "\",\""
	                + form.getGender() + "\",\"" + form.getDob() + "\",\"" + form.getBloodGroup() + "\",\""
	                + form.getMaritalStatus() + "\",\"" + form.getNationality() + "\",\"" + form.getFatherName()
	                + "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo() + "\",\""
	                + form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\"" + form.getAadharNo()
	                + "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\"" + form.getFileUpload()
	                + "\",\"" + form.getCreatedBy() + "\",\"" + form.getOrganization() + "\",\""
	                + form.getOrgDivision() + "\",\"" + form.getCreatedBy() + "\",\"" + encodedPassword + "\"),";
	        
	        addReq = addReq.substring(0, addReq.length() - 1);
	        s = s + "@p_activityBy='" + form.getCreatedBy() + "',";
	    } else {
	        addReq = addReq + "(\"" + form.getCandidateId() + "\",\"" + form.getFirstName() + "\",\""
	                + form.getLastName() + "\",\"" + form.getGender() + "\",\"" + form.getDob() + "\",\""
	                + form.getBloodGroup() + "\",\"" + form.getMaritalStatus() + "\",\"" + form.getNationality()
	                + "\",\"" + form.getFatherName() + "\",\"" + form.getMotherName() + "\",\"" + form.getMobileNo()
	                + "\",\"" + form.getPersonalEmail() + "\",\"" + form.getWorkEmail() + "\",\""
	                + form.getAadharNo() + "\",\"" + form.getPanNo() + "\",\"" + form.getEmergencyMob() + "\",\""
	                + form.getFileUpload() + "\",\"" + form.getOrganization() + "\",\"" + form.getOrgDivision()
	                + "\",\"" + form.getCreatedBy() + "\"),";
	        
	        addReq = addReq.substring(0, addReq.length() - 1);
	        s = s + "@p_candidateId='" + form.getCandidateId() + "',";
	        s = s + "@p_activityBy='" + form.getCreatedBy() + "',";
	    }

	    s = s + "@p_addCandidate='" + addReq + "',";

	    if (!s.isEmpty()) {
	        s = s.substring(0, s.length() - 1);
	        s = "SET " + s + ";";
	    }

	    return s;
	}

	public static String addAddress(CandidateAddressModel form) {

		String s = "";
		String addReq = "";

		String addressEscaped = form.getAddress().replace("'", "''").replace("\"", "\\\"");

		if (form.getAddressId() == null || form.getAddressId() == "") {

			addReq = addReq + "(@p_addressId,\"" + form.getCandidateId() + "\",\"" + form.getType() + "\",\""
					+ addressEscaped + "\",\"" + form.getCountry() + "\",\"" + form.getState() + "\",\""
					+ form.getCity() + "\",\"" + form.getPinCode() + "\",\"" + form.getCreatedBy() + "\",\""
					+ form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		} else {

			addReq = addReq + "(\"" + form.getAddressId() + "\",\"" + form.getCandidateId() + "\",\"" + form.getType()
					+ "\",\"" + addressEscaped + "\",\"" + form.getCountry() + "\",\"" + form.getState() + "\",\""
					+ form.getCity() + "\",\"" + form.getPinCode() + "\",\"" + form.getCreatedBy() + "\",\""
					+ form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_canid='" + form.getCandidateId() + "',";
		s = s + "@p_addType='" + form.getType() + "',";
		s = s + "@p_addAddress='" + addReq + "',";
		s = s + "@p_addressId='" + form.getAddressId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}
		return s;

	}

	public static String addEducation(CandidateEducationModel form) {

		String s = "";
		String addReq = "";

		if (form.getEducationId() == null || form.getEducationId() == "") {
			addReq = addReq + "(@p_educationId,\"" + form.getCandidaateId() + "\",\"" + form.getQualification()
					+ "\",\"" + form.getInstitution() + "\",\"" + form.getPassingYear() + "\",\"" + form.getCreatedBy()
					+ "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);

		} else {
			addReq = addReq + "(\"" + form.getEducationId() + "\",\"" + form.getCandidaateId() + "\",\""
					+ form.getQualification() + "\",\"" + form.getInstitution() + "\",\"" + form.getPassingYear()
					+ "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_addEducation='" + addReq + "',";
		s = s + "@p_educationId='" + form.getEducationId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addSkills(CandidateSkillsModel form) {

		String s = "";
		String addReq = "";

		String description = form.getSkillDesc().replace("'", "''");

		if (form.getSkillId() == null || form.getSkillId() == "") {
			addReq = addReq + "(@p_skillsId,\"" + form.getCandidateId() + "\",\"" + form.getSkills() + "\",\""
					+ description + "\",\"" + form.getSkillLevel() + "\",\"" + form.getExperience() + "\",\""
					+ form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);

		} else {
			addReq = addReq + "(\"" + form.getSkillId() + "\",\"" + form.getCandidateId() + "\",\"" + form.getSkills()
					+ "\",\"" + form.getSkillDesc() + "\",\"" + form.getSkillLevel() + "\",\"" + form.getExperience()
					+ "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_addSkills='" + addReq + "',";
		s = s + "@p_skillsId='" + form.getSkillId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addWorkExperience(CandidateWorkExperienceModel form) {
		String s = "";
		String addReq = "";

		/*
		 * String workFrom = (form.getWorkFrom() == null ||
		 * form.getWorkFrom().isEmpty()) ? "NULL" : "\"" + form.getWorkFrom() + "\"";
		 * String workTill = (form.getWorkTill() == null ||
		 * form.getWorkTill().isEmpty()) ? "NULL" : "\"" + form.getWorkTill() + "\"";
		 */

		String descriptionEscaped = form.getDescription().replace("'", "''");

		if (form.getWorkExperineceId() == null || form.getWorkExperineceId().isEmpty()) {
			addReq = addReq + "(@p_workExperienceId,\"" + form.getCandidateId() + "\",\"" + form.getDesignation()
					+ "\",\"" + form.getOrganization() + "\"," + form.getWorkFrom() + "," + form.getWorkTill() + ",\""
					+ form.getNoticePeriod() + "\",\"" + descriptionEscaped + "\",\"" + form.getWorkExp() + "\",\""
					+ form.getQualification() + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
		} else {
			addReq = addReq + "(\"" + form.getWorkExperineceId() + "\",\"" + form.getCandidateId() + "\",\""
					+ form.getDesignation() + "\",\"" + form.getOrganization() + "\"," + form.getWorkFrom() + "," + form.getWorkTill()
					+ ",\"" + form.getNoticePeriod() + "\",\"" + descriptionEscaped + "\",\"" + form.getWorkExp()
					+ "\",\"" + form.getQualification() + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy()
					+ "\"),";
		}

		addReq = addReq.substring(0, addReq.length() - 1);

		s = s + "@p_addWorkExperience='" + addReq + "',";
		s = s + "@p_workExperienceId='" + form.getWorkExperineceId() + "',";

		if (!s.isEmpty()) {
			s = s.substring(0, s.length() - 1);
			s = "SET " + s + ";";
		}

		return s;
	}

	public static String addAward(CandidateAwardsModel form) {

		String s = "";
		String addReq = "";

		String descriptionEscaped = form.getAwardDescription().replace("'", "''");

		if (form.getAwardId() == null || form.getAwardId() == "") {
			addReq = addReq + "(@p_awardId,\"" + form.getCandidateId() + "\",\"" + form.getAwardName() + "\",\""
					+ form.getAwardYear() + "\",\"" + descriptionEscaped + "\",\"" + form.getCreatedBy() + "\",\""
					+ form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);

		} else {

			addReq = addReq + "(\"" + form.getAwardId() + "\",\"" + form.getCandidateId() + "\",\""
					+ form.getAwardName() + "\",\"" + form.getAwardYear() + "\",\"" + descriptionEscaped + "\",\""
					+ form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_addAward='" + addReq + "',";
		s = s + "@p_awardId='" + form.getAwardId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addReference(CandidateReferenceModel form) {

		String s = "";
		String addReq = "";

		String descriptionEscaped = form.getDescription().replace("'", "''");

		if (form.getReferenceId() == null || form.getReferenceId() == "") {
			addReq = addReq + "(@p_referenceId,\"" + form.getCandidateId() + "\",\"" + form.getName() + "\",\""
					+ form.getMobileNo() + "\",\"" + form.getEmailId() + "\",\"" + descriptionEscaped + "\",\""
					+ form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);

		} else {

			addReq = addReq + "(\"" + form.getReferenceId() + "\",\"" + form.getCandidateId() + "\",\"" + form.getName()
					+ "\",\"" + form.getMobileNo() + "\",\"" + form.getEmailId() + "\",\"" + form.getDescription()
					+ "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_addReference='" + addReq + "',";
		s = s + "@p_referenceId='" + form.getReferenceId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addSource(CandidateSourceModel form) {

		String s = "";
		String addReq = "";

		String descriptionEscaped = form.getDescription().replace("'", "''");
		if (form.getSourceId() == null || form.getSourceId() == "") {
			addReq = addReq + "(@p_sourceId,\"" + form.getCandidateId() + "\",\"" + form.getName() + "\",\""
					+ descriptionEscaped + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy() + "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);

		} else {

			addReq = addReq + "(\"" + form.getSourceId() + "\",\"" + form.getCandidateId() + "\",\"" + form.getName()
					+ "\",\"" + descriptionEscaped + "\",\"" + form.getCreatedBy() + "\",\"" + form.getCreatedBy()
					+ "\"),";
			addReq = addReq.substring(0, addReq.length() - 1);
		}

		s = s + "@p_addSource='" + addReq + "',";
		s = s + "@p_sourceId='" + form.getSourceId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}

	public static String addShortList(CandidateDocumentModel candidate) {

		String s = "";
		String qItem = "";

		s = s + "@p_candId='" + candidate.getCandidateId() + "',";
		s = s + "@p_createdBy='" + candidate.getCreatedBy() + "',";

		for (InventoryVendorDocumentModel a : candidate.getDocumentList()) {
			qItem = qItem + "(@p_candId,\"" + a.getDocumnentName() + "\",\"" + a.getFileName() + "\",@p_createdBy),";
		}
		if (!qItem.isEmpty()) {
			qItem = qItem.substring(0, qItem.length() - 1);
			s = s + "@p_candDocuments='" + qItem + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
	
	public static String applyReq(CandidateApplyRequisitionModel applyReq) {

	    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();

	    String query = "";

	    // Assuming single candidateId and requisitionId
	    if (applyReq.getCandidateId() != null && !applyReq.getCandidateId().isEmpty()
	            && applyReq.getRequisitionId() != null && !applyReq.getRequisitionId().isEmpty()) {

	        String candidateId = applyReq.getCandidateId();
	        String requisitionId = applyReq.getRequisitionId();
	        String createdBy = applyReq.getCreatedBy();
	        String createdDate = dateFormat.format(cal.getTime());

	        // Construct the query with key-value pairs
	        query = "SET @p_candidateId='" + candidateId + "', "
	              + "@p_requisitionId='" + requisitionId + "', "
	              + "@p_createdDate='" + createdDate + "', "
	              + "@p_createdBy='" + createdBy + "';";

	    } else {
	        // Handle cases where candidateId or requisitionId is null or empty
	        throw new IllegalArgumentException("CandidateId and RequisitionId cannot be null or empty");
	    }

	    return query;
	}


	/*
	 * public static String applyReq(CandidateApplyRequisitionModel applyReq) {
	 * 
	 * DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Calendar
	 * cal = Calendar.getInstance();
	 * 
	 * String s = ""; String qItem = ""; String id = "";
	 * 
	 * for (int i = 0; i < applyReq.getRequisitionId().size(); i++) { for (int j =
	 * 0; j < applyReq.getCandidateId().size(); j++) { qItem = qItem + "(\"" +
	 * applyReq.getCandidateId().get(j) + "\",\"" +
	 * applyReq.getRequisitionId().get(i) + "\",\"" +
	 * dateFormat.format(cal.getTime()) + "\",\"" + applyReq.getCreatedBy() +
	 * "\",\"" + applyReq.getCreatedBy() + "\"),"; } } qItem = qItem.substring(0,
	 * qItem.length() - 1);
	 * 
	 * for (int j = 0; j < applyReq.getCandidateId().size(); j++) { id = id + "\"" +
	 * applyReq.getCandidateId().get(j) + "\","; } id = id.substring(0, id.length()
	 * - 1);
	 * 
	 * s = s + "@p_applyReq='" + qItem + "',"; s = s + "@p_candId='(" + id + ")',";
	 * 
	 * if (s != "") { s = s.substring(0, s.length() - 1);
	 * 
	 * s = "SET " + s + ";"; }
	 * 
	 * return s;
	 * 
	 * }
	 */

	public static String getCandidateOtherDoc(ManageEmployeeDocumentRestModel employeeDocumentModel) {

		String s = "";
		if (employeeDocumentModel.getEmployeeId() != null && employeeDocumentModel.getEmployeeId() != "") {
			s = s + "@p_candid='" + employeeDocumentModel.getEmployeeId() + "',";
		}
		if (employeeDocumentModel.getDocumentType() != null && employeeDocumentModel.getDocumentType() != "") {
			s = s + "@p_docType='" + employeeDocumentModel.getDocumentType() + "',";
		}
		if (employeeDocumentModel.getDocumentName() != null && employeeDocumentModel.getDocumentName() != "") {
			s = s + "@p_docName='" + employeeDocumentModel.getDocumentName() + "',";
		}
		if (employeeDocumentModel.getCreatedBy() != null && employeeDocumentModel.getCreatedBy() != "") {
			s = s + "@p_createdBy='" + employeeDocumentModel.getCreatedBy() + "',";
		}
		if (employeeDocumentModel.getStatus() != null && employeeDocumentModel.getStatus() != "") {
			s = s + "@p_status='" + employeeDocumentModel.getStatus() + "',";
		}
		if (employeeDocumentModel.getOrganization() != null && employeeDocumentModel.getOrganization() != "") {
			s = s + "@p_org='" + employeeDocumentModel.getOrganization() + "',";
		}
		if (employeeDocumentModel.getOrgDivision() != null && employeeDocumentModel.getOrgDivision() != "") {
			s = s + "@p_orgDiv='" + employeeDocumentModel.getOrgDivision() + "',";
		}

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;
	}
	
	
	public static String addBankDetails(candidateBankAccountDetailsRestModel form) {

		String s = "";
		String addReq = "";

		String bankAddress = form.getBankAddress().replace("'", "''").replace("\"", "\\\"");

		if (form.getBankId() == null || form.getBankId().isEmpty()) {
		    addReq = addReq + "(@p_bankId, \"" + form.getCandidateid() + "\", \"" + form.getAccountNo() + "\", \"" 
		            + form.getBankName() + "\", \"" + form.getIfscCode() + "\", \"" + bankAddress + "\", \"" 
		            + form.getDocument() + "\", \"" + form.getCreatedBy() + "\", NOW(), 0, \"" 
		            + form.getOrgName() + "\", \"" + form.getOrgDiv() + "\"),";
		} else {
		    addReq = addReq + "(\"" + form.getBankId() + "\", \"" + form.getCandidateid() + "\", \"" + form.getAccountNo() + "\", \"" 
		            + form.getBankName() + "\", \"" + form.getIfscCode() + "\", \"" + bankAddress + "\", \"" 
		            + form.getDocument() + "\", \"" + form.getCreatedBy() + "\", NOW(), 0, \"" 
		            + form.getOrgName() + "\", \"" + form.getOrgDiv() + "\"),";
		}

		s = s + "@p_addReference='" + addReq + "',";
		s = s + "@p_bankId='" + form.getBankId() + "',";

		if (s != "") {
			s = s.substring(0, s.length() - 1);

			s = "SET " + s + ";";
		}

		return s;

	}
}
