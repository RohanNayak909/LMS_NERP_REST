package nirmalya.aatithya.restmodule.grc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateSafetyIdentificationParam;
import nirmalya.aatithya.restmodule.grc.model.SafetyIdentificationRestModel;

@Repository

public class SafetyIdentificationRestDao {

	Logger logger = LoggerFactory.getLogger(SafetyIdentificationRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewProject
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewProject(String userid,
			String organization, String orgDivision) {
		logger.info("Method : viewProject starts");
		List<SafetyIdentificationRestModel> respList = new ArrayList<SafetyIdentificationRestModel>();
		try {
			String values = "SET @p_createdBy='" + userid + "',@p_orgname='" + organization + "',@p_orgdiv='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_management_routines")
					.setParameter("actionType", "viewProjects").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SafetyIdentificationRestModel restPayroll = new SafetyIdentificationRestModel(m[0], m[1], m[2], m[3],
						m[4], null, m[5].toString(), m[6], m[7], m[8]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyIdentificationRestModel>> resp = new JsonResponse<List<SafetyIdentificationRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewProject ends" + respList);
		return response;

	}

	// viewCategory
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewCategory(String userid,
			String organization, String orgDivision) {
		logger.info("Method : viewCategory starts");
		List<SafetyIdentificationRestModel> respList = new ArrayList<SafetyIdentificationRestModel>();
		try {
			String values = "SET @p_createdBy='" + userid + "',@p_orgname='" + organization + "',@p_orgdiv='"
					+ orgDivision + "';";
			
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_management_routines")
					.setParameter("actionType", "viewSafetyList").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SafetyIdentificationRestModel restPayroll = new SafetyIdentificationRestModel(m[0], m[1], m[2], m[3],
						m[4], m[5]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyIdentificationRestModel>> resp = new JsonResponse<List<SafetyIdentificationRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewCategory ends" + respList);
		return response;

	}

// add safety
	public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> addSafetyIdentification(
			List<SafetyIdentificationRestModel> model) {
		logger.info("Method : addSafetyIdentification starts");

		JsonResponse<List<SafetyIdentificationRestModel>> resp = new JsonResponse<List<SafetyIdentificationRestModel>>();
		List<SafetyIdentificationRestModel> listData = new ArrayList<SafetyIdentificationRestModel>();

		try {
			String values = GenerateSafetyIdentificationParam.getAddQuotParam(model);
			if (model.get(0).getSafetyId() == "" || model.get(0).getSafetyId() == null) {

				em.createNamedStoredProcedureQuery("ehs_safety_management_routines")
						.setParameter("actionType", "addData").setParameter("actionValue", values).execute();
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addSafetyIdentification ends");
		return response;
	}

	// viewCategory
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> viewSafety(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : viewCategory starts");
		List<SafetyIdentificationRestModel> respList = new ArrayList<SafetyIdentificationRestModel>();
		try {
			String values = "SET @p_projectId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_management_routines")
					.setParameter("actionType", "viewSafety").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SafetyIdentificationRestModel restPayroll = new SafetyIdentificationRestModel(m[0], m[1], m[2], m[3],
						m[4], m[5], m[6], m[7]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyIdentificationRestModel>> resp = new JsonResponse<List<SafetyIdentificationRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyIdentificationRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewCategory ends" + respList);
		return response;

	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteSafety(String id, String userId, String org, String orgDiv) {
		logger.info("Method : manageNoticeDelete starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = "SET @p_safetyId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
						+ "',@p_orgdiv='" + orgDiv + "';";
				em.createNamedStoredProcedureQuery("ehs_safety_management_routines")
						.setParameter("actionType", "deleteSafety").setParameter("actionValue", values).execute();
			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method :  manageNoticeDelete ends");
		return response;
	}
}
