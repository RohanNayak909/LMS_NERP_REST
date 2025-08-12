package nirmalya.aatithya.restmodule.recruitment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCandidateParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.model.ManageEmployeeDocumentRestModel;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.recruitment.model.AddRecruitentModel;
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
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class CandidateDao {

	Logger logger = LoggerFactory.getLogger(CandidateDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<CandidateDetailsModel>> addCandidate(CandidateDetailsModel req) {
		logger.info("Method : addCandidate starts");

		JsonResponse<CandidateDetailsModel> resp = new JsonResponse<CandidateDetailsModel>();
		String values = GenerateCandidateParameter.addPersonalDetails(req);
		System.out.println("values==="+values);
		try {

			if (req.getCandidateId() != null && req.getCandidateId() != "") {
				List<Object> x = em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyCandidate")
						.setParameter("actionValue", values).getResultList();
				
				CandidateDetailsModel candidate = new CandidateDetailsModel(x.get(0));
				Util.setJsonResponse(resp, candidate, ResponseStatus.success, ApiResponseMessage.MODIFIED_SUCCESSFULLY);
				
			} else {
				List<Object> x = em.createNamedStoredProcedureQuery("candidateRoutines")
						.setParameter("actionType", "addCandidate").setParameter("actionValue", values).getResultList();

				CandidateDetailsModel candidate = new CandidateDetailsModel(x.get(0));
				Util.setJsonResponse(resp, candidate, ResponseStatus.success,"Registration successful! Please provide additional details to complete the candidate profile.");
			}

		} catch

		(Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				System.err.println(err[0]);
				System.err.println(err[1]);
				
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<CandidateDetailsModel>> response = new ResponseEntity<JsonResponse<CandidateDetailsModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> viewCandidates() {
		logger.info("Method : viewCandidates starts");

		List<CandidateDetailsModel> countryList = new ArrayList<CandidateDetailsModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewCandidates").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				String sDate = null;
				if (m[3] != null) {
					sDate = m[3].toString();
				}

				String date = null;
				if (m[2] != null) {
					date = m[2].toString();
				}
				String exp = null;
				if (m[8] != null) {
					exp = m[8].toString();
				} else {
					exp = "0";
				}

				CandidateDetailsModel dropDownModel = new CandidateDetailsModel(m[0], m[1], null, null, date, null,
						null, null, null, null, null, null, null, null, sDate, m[4].toString(), null, m[5], m[6],
						m[7].toString(), null, null, null, null, null, exp, m[9], null, null, null, null);

				countryList.add(dropDownModel);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateDetailsModel>> resp = new JsonResponse<List<CandidateDetailsModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewCandidates ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> editCandidates(String id) {
		logger.info("Method : editCandidates starts");

		List<CandidateDetailsModel> countryList = new ArrayList<CandidateDetailsModel>();

		String values = "SET @p_candidateId='" + id + "';";
System.out.println("DATA----------"+values);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editCandidates").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				if (m[3] != null) {
					sDate = m[3].toString();
				}
				Object jDate = null;
				if (m[14] != null) {
					jDate = m[14].toString();
				}
				CandidateDetailsModel dropDownModel = new CandidateDetailsModel(null, m[0], m[1], m[2], sDate, m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null, m[12], m[13], null, null, null,
						null, null, jDate, null, null, null, null, m[15], m[16], m[17]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateDetailsModel>> resp = new JsonResponse<List<CandidateDetailsModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("response edit====" + response);
		logger.info("Method : editCandidates ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addAddress(CandidateAddressModel req) {
		logger.info("Method : addCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addAddress(req);
			
			logger.info("values-->" + values);

			if (req.getAddressId() == null || req.getAddressId() == "") {

				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addAddress")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyAddress")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateAddressModel>>> viewAddress(String id) {
		logger.info("Method : viewAddress starts");

		List<CandidateAddressModel> countryList = new ArrayList<CandidateAddressModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewAddress").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				CandidateAddressModel dropDownModel = new CandidateAddressModel(m[0], null, m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], null);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateAddressModel>> resp = new JsonResponse<List<CandidateAddressModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateAddressModel>>> response = new ResponseEntity<JsonResponse<List<CandidateAddressModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewAddress ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAddress(String id) {
		logger.info("Method : deleteAddress starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteAddress")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteAddress ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addEducation(CandidateEducationModel req) {
		logger.info("Method : addCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addEducation(req);
			logger.info(values);

			if (req.getEducationId() == null || req.getEducationId() == "") {
				logger.info("hi");
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addEducation")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");			
				}
			else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyEducation")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateEducationModel>>> viewEducation(String id) {
		logger.info("Method : viewAddress starts");

		List<CandidateEducationModel> countryList = new ArrayList<CandidateEducationModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewEducation").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				CandidateEducationModel dropDownModel = new CandidateEducationModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateEducationModel>> resp = new JsonResponse<List<CandidateEducationModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateEducationModel>>> response = new ResponseEntity<JsonResponse<List<CandidateEducationModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewAddress ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteEducation(String id) {
		logger.info("Method : deleteEducation starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteEducation")
					.setParameter("actionValue", values).execute();

		} catch(Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteEducation ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addSkills(CandidateSkillsModel req) {
		logger.info("Method : addCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info(req.getSkillId());
		try {
			String values = GenerateCandidateParameter.addSkills(req);

			if (req.getSkillId() == null || req.getSkillId() == "") {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addSkills")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {
				logger.info("hello");
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifySkills")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateSkillsModel>>> viewSkills(String id) {
		logger.info("Method : viewSkills starts");

		List<CandidateSkillsModel> countryList = new ArrayList<CandidateSkillsModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewSkills").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				CandidateSkillsModel dropDownModel = new CandidateSkillsModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateSkillsModel>> resp = new JsonResponse<List<CandidateSkillsModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateSkillsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateSkillsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewSkills ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteSkill(String id) {
		logger.info("Method : deleteSkill starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteSkill")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteSkill ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addWorkExperience(CandidateWorkExperienceModel req) {
		logger.info("Method : addWorkExperience starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("req==="+req);
		try {
			String values = GenerateCandidateParameter.addWorkExperience(req);
			logger.info(values);
			if (req.getWorkExperineceId() == null || req.getWorkExperineceId() == "") {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addWorkExperience")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {

				em.createNamedStoredProcedureQuery("candidateRoutines")
						.setParameter("actionType", "modifyWorkExperience").setParameter("actionValue", values)
						.execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addWorkExperience ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateWorkExperienceModel>>> viewWorkExperience(String id) {
		logger.info("Method : viewWorkExperience starts");

		List<CandidateWorkExperienceModel> countryList = new ArrayList<CandidateWorkExperienceModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewWorkExperience").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				String sDate = null;
				if (m[5] != null) {
					sDate = m[5].toString();
				}

				String sdate = null;
				if (m[6] != null) {
					sdate = m[6].toString();
				}

				CandidateWorkExperienceModel dropDownModel = new CandidateWorkExperienceModel(m[0], m[1], m[2], m[3],
						m[4], sDate, sdate, m[7], m[8], m[9], m[10]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateWorkExperienceModel>> resp = new JsonResponse<List<CandidateWorkExperienceModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateWorkExperienceModel>>> response = new ResponseEntity<JsonResponse<List<CandidateWorkExperienceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewWorkExperience ends");
		return response;
	}


	public ResponseEntity<JsonResponse<Object>> deleteWorkExperience(String id) {
		logger.info("Method : deleteWorkExperience starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteWorkExperience")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteWorkExperience ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addAward(CandidateAwardsModel req) {
		logger.info("Method : addAward starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addAward(req);
			logger.info(values);
			if (req.getAwardId() == null || req.getAwardId() == "") {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addAward")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyAward")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addAward ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateAwardsModel>>> viewAward(String id) {
		logger.info("Method : viewAward starts");

		List<CandidateAwardsModel> countryList = new ArrayList<CandidateAwardsModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewAward").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				CandidateAwardsModel dropDownModel = new CandidateAwardsModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateAwardsModel>> resp = new JsonResponse<List<CandidateAwardsModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateAwardsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateAwardsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewAward ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteAward(String id) {
		logger.info("Method : deleteAward starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteAward")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteAward ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addReference(CandidateReferenceModel req) {
		logger.info("Method : addReference starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addReference(req);
			logger.info(values);
			if (req.getReferenceId() == null || req.getReferenceId() == "") {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addReference")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyReference")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addReference ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateReferenceModel>>> viewReference(String id) {
		logger.info("Method : viewReference starts");

		List<CandidateReferenceModel> countryList = new ArrayList<CandidateReferenceModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewReference").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				CandidateReferenceModel dropDownModel = new CandidateReferenceModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateReferenceModel>> resp = new JsonResponse<List<CandidateReferenceModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateReferenceModel>>> response = new ResponseEntity<JsonResponse<List<CandidateReferenceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewReference ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteReference(String id) {
		logger.info("Method : deleteReference starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteReference")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteReference ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addSource(CandidateSourceModel req) {
		logger.info("Method : addSource starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addSource(req);
			logger.info(values);
			if (req.getSourceId() == null || req.getSourceId() == "") {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addSource")
						.setParameter("actionValue", values).execute();
				resp.setCode("201");
			} else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifySource")
						.setParameter("actionValue", values).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addSource ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateSourceModel>>> viewSource(String id) {
		logger.info("Method : viewSource starts");

		List<CandidateSourceModel> countryList = new ArrayList<CandidateSourceModel>();

		String values = "SET @p_candidateId='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewSource").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				CandidateSourceModel dropDownModel = new CandidateSourceModel(m[0], m[1], m[2], m[3], m[4]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateSourceModel>> resp = new JsonResponse<List<CandidateSourceModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateSourceModel>>> response = new ResponseEntity<JsonResponse<List<CandidateSourceModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : viewSource ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteSource(String id) {
		logger.info("Method : deleteSource starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_id='(" + id + ")'";

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteSource")
					.setParameter("actionValue", values).execute();

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteSource ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> applyRequisition(CandidateApplyRequisitionModel applyReq) {
		logger.info("Method : applyRequisition starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		List<CandidateApplyRequisitionModel> req = new ArrayList<CandidateApplyRequisitionModel>();
		try {
			String values = GenerateCandidateParameter.applyReq(applyReq);

			Object result = em.createNamedStoredProcedureQuery("candidateRoutines")
	                .setParameter("actionType", "applyRequisition")
	                .setParameter("actionValue", values)
	                .getSingleResult();

	        // Set the message returned from the database
	        if (result != null) {
	            resp.setMessage(result.toString());
	            resp.setCode("Success");
	        } else {
	            resp.setMessage("An unexpected error occurred.");
	        }

		} catch

		(Exception e) {

			e.printStackTrace();

		}

		resp.setBody(req);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : applyRequisition ends");
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<CandidateApplyRequisitionModel>>>
	 * getApplyReqList(String id) {
	 * logger.info("Method : addShortListCandidate starts");
	 * 
	 * JsonResponse<List<CandidateApplyRequisitionModel>> resp = new
	 * JsonResponse<List<CandidateApplyRequisitionModel>>();
	 * List<CandidateApplyRequisitionModel> req = new
	 * ArrayList<CandidateApplyRequisitionModel>();
	 * 
	 * 
	 * try { String values = "SET @p_id='" + id + "';"; logger.info(values);
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
	 * .setParameter("actionType", "getApplyReqList") .setParameter("actionValue",
	 * values) .getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * CandidateApplyRequisitionModel applyRequi = new
	 * CandidateApplyRequisitionModel(m[0],m[1],null); req.add(applyRequi); }
	 * 
	 * } catch (Exception e) { e.printStackTrace();
	 * 
	 * }
	 * 
	 * resp.setBody(req);
	 * 
	 * ResponseEntity<JsonResponse<List<CandidateApplyRequisitionModel>>> response =
	 * new ResponseEntity<JsonResponse<List<CandidateApplyRequisitionModel>>>(resp,
	 * HttpStatus.CREATED); logger.info("Method : addShortListCandidate ends");
	 * return response; }
	 */

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<AddRecruitentModel>>>
	 * getRequisitionOfCandidate(String id) {
	 * 
	 * logger.info("Method : getRequisitionOfCandidate starts");
	 * 
	 * List<AddRecruitentModel> countryList = new ArrayList<AddRecruitentModel>();
	 * String values = "SET @p_candId='" + id + "';";
	 * 
	 * try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
	 * .setParameter("actionType", "viewRequisition").setParameter("actionValue",
	 * values).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * String sDate = null; if (m[3] != null) { sDate = m[3].toString(); }
	 * 
	 * AddRecruitentModel dropDownModel = new AddRecruitentModel(m[0], null, m[1],
	 * null, null, null, m[2], null, null, null, null, null, null, sDate, null,
	 * null, null, null, null, null, null, null, null, null, null, null, null, null,
	 * null, null, null, null, null, null); countryList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * JsonResponse<List<AddRecruitentModel>> resp = new
	 * JsonResponse<List<AddRecruitentModel>>(); resp.setBody(countryList);
	 * 
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * ResponseEntity<JsonResponse<List<AddRecruitentModel>>> response = new
	 * ResponseEntity<JsonResponse<List<AddRecruitentModel>>>( resp,
	 * responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getRequisitionOfCandidate ends"); return response; }
	 */
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRequisitionOfCandidate(String id) {
		logger.info("Method : getRequisitionOfCandidate Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_candId='" + id + "';";
			
			List<Object[]> list = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewRequisition").setParameter("actionValue", values).getResultList();
			resp.setBody(list);
			resp.setCode("Success");
			resp.setMessage("Data fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getRequisitionOfCandidate Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<Object>> addShortListCandidate(CandidateDocumentModel candidate) {
		logger.info("Method : addShortListCandidate starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateCandidateParameter.addShortList(candidate);
			logger.info(values);
			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addDocList")
					.setParameter("actionValue", values).execute();

		} catch (Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addShortListCandidate ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public List<InventoryVendorDocumentModel> viewCandidateDocEdit(String id) {
		logger.info("Method : viewCandidateDocEdit starts");

		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		List<InventoryVendorDocumentModel> docList1 = new ArrayList<InventoryVendorDocumentModel>();
		String values = "SET @p_candd='" + id + "';";
		logger.info(values);
		try {
			List<Object[]> x1 = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "getCandidateDocs").setParameter("actionValue", values).getResultList();
			for (Object[] m : x1) {

				InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], null);
				docList.add(dropDownModel);
			}

			List<DropDownModel> documenttypeList = new ArrayList<DropDownModel>();

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("employeeMasterRoutines")
						.setParameter("actionType", "documentTypeList").setParameter("actionValue", "").getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					documenttypeList.add(dropDownModel);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (docList.size() > 0) {
				docList.get(0).setDrop(documenttypeList);
			} else {
				InventoryVendorDocumentModel abc = new InventoryVendorDocumentModel();
				abc.setDrop(documenttypeList);
				docList1.add(abc);
				return docList1;
			}

		} catch (Exception e) {

		}

		logger.info("Method : viewCandidateDocEdit ends");
		return docList;
	}
	/* Candidate Document Section */

	public ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> addCandidateDocument(
			ManageEmployeeDocumentRestModel manageEmployeeDocumentRestModel) {
		logger.info("Method : addEmpDocument starts");

		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = GenerateCandidateParameter.getCandidateOtherDoc(manageEmployeeDocumentRestModel);
			logger.info("value===" + value);

			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addCandidateDocument")
					.setParameter("actionValue", value).execute();
			resp.setCode("201");
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>> response = new ResponseEntity<JsonResponse<ManageEmployeeDocumentRestModel>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addCandidateDocument ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> viewCandidatedocument(String id,
			String organization, String orgDivision) {
		logger.info("Method : viewCandidatedocument starts");

		List<ManageEmployeeDocumentRestModel> viewempdoc = new ArrayList<ManageEmployeeDocumentRestModel>();
		JsonResponse<List<ManageEmployeeDocumentRestModel>> resp = new JsonResponse<List<ManageEmployeeDocumentRestModel>>();

		try {

			String value = "SET @p_canid='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "viewCandidatedocument").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				ManageEmployeeDocumentRestModel viewEmployeesss = new ManageEmployeeDocumentRestModel(m[0], m[1], m[2],
						m[3], m[4]);
				viewempdoc.add(viewEmployeesss);
			}
			if (viewempdoc.size() > 0) {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, viewempdoc, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} catch (Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		resp.setBody(viewempdoc);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>> response = new ResponseEntity<JsonResponse<List<ManageEmployeeDocumentRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : viewCandidatedocument ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> deleteCandidateDoc(String docType, String empid, String organization,
			String orgDivision) {
		logger.info("Method : deleteEmpDoc starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_canid='" + empid + "',@p_docType='" + docType + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value====" + value);
			em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "deleteCandidateDoc")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch

		(Exception e) {
			String[] err = serverDao.errorProcedureCall(e);
			logger.error("Error " + err[1]);
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deleteCandidateDoc ends");
		return response;
	}

	// Eidt Doc
	@SuppressWarnings("unchecked")
	public JsonResponse<ManageEmployeeDocumentRestModel> editDocumentDetails(String docType, String empid,
			String organization, String orgDivision) {
		logger.info("Method : editDocumentDetails dao starts");

		ManageEmployeeDocumentRestModel req = new ManageEmployeeDocumentRestModel();
		JsonResponse<ManageEmployeeDocumentRestModel> resp = new JsonResponse<ManageEmployeeDocumentRestModel>();
		try {
			String value = "SET @p_canid='" + empid + "',@p_docType='" + docType + "',@p_org='" + organization
					+ "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value====" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editDocumentDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				ManageEmployeeDocumentRestModel viewEmployeesss = new ManageEmployeeDocumentRestModel(m[0], m[1], m[2],
						m[3], m[4]);
				req = viewEmployeesss;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("editDocumentDetails" + resp);
		logger.info("Method : editDocumentDetails dao ends");
		return resp;
	}

	/*
	 * get document type list
	 * 
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<DropDownModel>> getDocumentTypeList(String empid, String orgName, String orgDivision) {

		logger.info("Method : getDocumentTypeList starts");
		List<DropDownModel> nameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_canid='" + empid + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "getDocumentCandidateList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				nameList.add(dropDownModel);
			}
			resp.setBody(nameList);
			if (nameList.size() > 0) {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, nameList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error " + e.getMessage());
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}

		logger.info("Method : getDocumentTypeList ends");

		logger.info("LISTTTT" + resp);
		return resp;
	}

	// Fetch pdf Details

	public JsonResponse<Object> getCandidateResumeDetails(String id, String organization, String orgDivision,
			String userId) {
		logger.info("Method : getCandidateResumeDetails starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {

			String value = "SET @p_candidateId='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "',@p_userId='" + userId + "';";
			
			System.out.println("value>>>>>>>"+value);

			Object x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "getCandidateResumePDFDetails").setParameter("actionValue", value)
					.getResultList();

			Util.setJsonResponse(resp, x, ResponseStatus.success, ApiResponseMessage.SAVED_SUCCESSFULLY);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			
			
		}
		logger.info("Method : getCandidateResumeDetails ends");

		return resp;
	}

	/* edit address */
	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateAddressModel> editAddressDetails(String addressId, String addressType) {
		logger.info("Method : editAddressDetails dao starts");
		CandidateAddressModel req = new CandidateAddressModel();
		JsonResponse<CandidateAddressModel> resp = new JsonResponse<CandidateAddressModel>();
		// String value = "SET @p_addressId='" + addressId + "',@p_addressType='" +
		// addressType + "';";

		String values = "SET @p_addressId='" + addressId + "',@P_addressType='" + addressType + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editAddress").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				CandidateAddressModel restaddress = new CandidateAddressModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7]);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAddressDetails dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateEducationModel> editEducation(String educationID) {
		logger.info("Values");
		logger.info("Method : editEducation dao starts");
		CandidateEducationModel req = new CandidateEducationModel();
		JsonResponse<CandidateEducationModel> resp = new JsonResponse<CandidateEducationModel>();

		String values = "SET @p_educationId='" + educationID + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editeducationDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				CandidateEducationModel restaddress = new CandidateEducationModel(m[0], m[1], m[2], m[3], m[4], null,
						null);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEducation dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateSkillsModel> editSkill(String skillId) {
		logger.info("Values");
		logger.info("Method : editSkill dao starts");
		CandidateSkillsModel req = new CandidateSkillsModel();
		JsonResponse<CandidateSkillsModel> resp = new JsonResponse<CandidateSkillsModel>();

		String values = "SET @p_skillId='" + skillId + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "SkillDetails").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				CandidateSkillsModel restaddress = new CandidateSkillsModel(m[0], m[1], m[2], m[3], m[4], m[5], null);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSkill dao ends");
		return resp;
	}
	//

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateWorkExperienceModel> editWorkDetails(String workId) {
		logger.info("Values");
		logger.info("Method : editWorkDetails dao starts");
		CandidateWorkExperienceModel req = new CandidateWorkExperienceModel();
		JsonResponse<CandidateWorkExperienceModel> resp = new JsonResponse<CandidateWorkExperienceModel>();

		String values = "SET @p_workId='" + workId + "';";
		
		
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "WorkDetails").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				CandidateWorkExperienceModel restaddress = new CandidateWorkExperienceModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7], m[8].toString(), m[9], m[10]);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editWorkDetails dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateAwardsModel> editAwardDetails(String workId) {
		logger.info("Method : editAwardDetails dao starts");
		CandidateAwardsModel req = new CandidateAwardsModel();
		JsonResponse<CandidateAwardsModel> resp = new JsonResponse<CandidateAwardsModel>();

		String values = "SET @p_awardId='" + workId + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editAwardDetails").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {
				CandidateAwardsModel restaddress = new CandidateAwardsModel(m[0], m[1], m[2], m[3], m[4], null);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAwardDetails dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateReferenceModel> editReference(String refId) {
		logger.info("Method : editReference dao starts");
		CandidateReferenceModel req = new CandidateReferenceModel();
		JsonResponse<CandidateReferenceModel> resp = new JsonResponse<CandidateReferenceModel>();

		String values = "SET @p_refId='" + refId + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editReferenceDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				CandidateReferenceModel restaddress = new CandidateReferenceModel(m[0], m[1], m[2], m[3], m[4], m[5],
						null);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editReference dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<CandidateSourceModel> editSourceDetails(String sourceId) {
		logger.info("Method : editSourceDetails dao starts");
		CandidateSourceModel req = new CandidateSourceModel();
		JsonResponse<CandidateSourceModel> resp = new JsonResponse<CandidateSourceModel>();

		String values = "SET @p_sourceId='" + sourceId + "';";
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editSourceDetails").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {
				CandidateSourceModel restaddress = new CandidateSourceModel(m[0], m[1], m[2], m[3], null);
				req = restaddress;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSourceDetails dao ends");
		return resp;
	}
	/*addNewDocInfo*/
	public JsonResponse<Object> addNewDocInfo(String newDocName,String newDocDesc,String userId) {
		logger.info("Method : addNewDocInfo dao starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		String values = "SET @p_newDocName=\"" + newDocName + "\",@P_newDocDesc=\"" + newDocDesc + "\",@P_userId=\"" + userId + "\";";
		try {
			em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "addNewDocInfo").setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : addNewDocInfo dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEducationDetails() {
		logger.info("Method : getEducationDetails starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			List<Object[]> edList = em.createNamedStoredProcedureQuery("requistionRoutines")
					.setParameter("actionType", "educationList").setParameter("actionValue", "").getResultList();
			
			
			  for (Object[] result : edList) {
		            String educationId = (String) result[0]; 
		            String educationName = (String) result[1]; 

		            DropDownModel dropDownModel = new DropDownModel(educationId, educationName);
		            respList.add(dropDownModel);
		        }
			resp.setBody(respList);
			resp.setMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Unsuccess");
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : getEducationDetails ends");
		return response;

	}
	
	
	public ResponseEntity<JsonResponse<Object>> addBankDetails(candidateBankAccountDetailsRestModel req,String orgName,String orgDiv) {
		logger.info("Method : addBankDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String bankAddress = req.getBankAddress().replace("'", "''").replace("\"", "\\\"");
		String bankName = req.getBankName().replace("'", "''").replace("\"", "\\\"");
		
		String value = "SET @p_bankId='" + req.getBankId()  + "',@P_candidateId='" + req.getCandidateid() +
						"',@P_accountNo='" + req.getAccountNo() + "',@P_bankName='" + bankName +
						"',@P_ifscCode='" + req.getIfscCode() + "',@P_bankAddress='" + bankAddress +
						"',@P_document='" + req.getDocument() + "',@P_createdBy='" + req.getCreatedBy() +
						"',@P_orgName='" + req.getOrgName() + "',@P_orgDiv='" + req.getOrgDiv() + "';";
		
		logger.info("values-->>" + value);

		try {
			//String values = GenerateCandidateParameter.addBankDetails(req);
			
			//logger.info("values-->" + values);

			if (req.getBankId() == null || req.getBankId() == "") {

				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "addBankDetails")
						.setParameter("actionValue", value).execute();
				resp.setCode("201");
			} else {
				em.createNamedStoredProcedureQuery("candidateRoutines").setParameter("actionType", "modifyBankDetails")
						.setParameter("actionValue", value).execute();
				resp.setCode("200");
			}

		} catch

		(Exception e) {
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addBankDetails ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<candidateBankAccountDetailsRestModel>>> viewBankDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : viewBankDetails Dao starts");
		List<candidateBankAccountDetailsRestModel> req = new ArrayList<candidateBankAccountDetailsRestModel>();
		JsonResponse<List<candidateBankAccountDetailsRestModel>> resp = new JsonResponse<List<candidateBankAccountDetailsRestModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_candidateId='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewBankDetails").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				candidateBankAccountDetailsRestModel restaddress = new candidateBankAccountDetailsRestModel(m[0], m[1], m[2], m[3], m[4],m[5]);
				req.add(restaddress);

			}
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		resp.setBody(req);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<candidateBankAccountDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<candidateBankAccountDetailsRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		System.out.println("vank resp -----------" + response);
		logger.info("Method : viewBankDetails Dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editBankDetails(String orgName, String orgDivision,String id) {
		logger.info("Method : editBankDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_bankId='" + id + "';";
			System.out.println("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "editBank").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : editBankDetails Dao ends" + resp);
		return resp;

	}
	
	
	/*addNewQualificationInfo*/
	public JsonResponse<Object> addNewQualiFication(String newQualName,String newQualDesc,String userId,String orgName,String orgDivision) {
		logger.info("Method : addNewQualiFication dao starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		String values = "SET @p_newQualName=\"" + newQualName + "\",@P_newQualDesc=\"" + newQualDesc + "\",@P_userId=\"" + userId + "\",@P_orgName=\"" + orgName + "\",@P_orgDiv=\"" + orgDivision + "\";";
		
		logger.info("values" + values);
		try {
			em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "addNewQualificationInfo").setParameter("actionValue", values).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : addNewQualiFication dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> getCandDetails(String candid) {
		logger.info("Method : getCandDetails Dao starts");

		List<CandidateDetailsModel> countryList = new ArrayList<CandidateDetailsModel>();

		String values = "SET @p_candidateId=\"" + candid + "\";";
		logger.info(values);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("candidateRoutines")
					.setParameter("actionType", "getEmpOfferDetail").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {

				Object sDate = null;
				if (m[4] != null) {
					sDate = m[4].toString();
				}
				Object jDate = null;
				if (m[14] != null) {
					jDate = m[14].toString();
				}
				CandidateDetailsModel dropDownModel = new CandidateDetailsModel( m[0],m[1],m[2],m[3],sDate,m[5],m[6],m[7],m[8],m[9],
						m[10],m[11],m[12],null,null,null,m[13],null,null,null,null,null,null,jDate,null,null,null,null,m[15],m[16],
						m[17]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		JsonResponse<List<CandidateDetailsModel>> resp = new JsonResponse<List<CandidateDetailsModel>>();
		resp.setBody(countryList);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		ResponseEntity<JsonResponse<List<CandidateDetailsModel>>> response = new ResponseEntity<JsonResponse<List<CandidateDetailsModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("response edit====" + response);
		logger.info("Method : getCandDetails ends");
		return response;
	}

}
