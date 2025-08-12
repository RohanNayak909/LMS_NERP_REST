package nirmalya.aatithya.restmodule.grc.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateSafetyAssesmentParam;
import nirmalya.aatithya.restmodule.grc.model.SafetyAssesmentRestModel;

@Repository
public class SafetyAssesmentRestDao {

	Logger logger = LoggerFactory.getLogger(SafetyAssesmentRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewCategory
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> viewSafetyAssess(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : viewSafetyAssess starts");
		List<SafetyAssesmentRestModel> respList = new ArrayList<SafetyAssesmentRestModel>();
		try {
			String values = "SET @p_projectId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_assesment_routines")
					.setParameter("actionType", "viewAssess").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SafetyAssesmentRestModel restPayroll = new SafetyAssesmentRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyAssesmentRestModel>> resp = new JsonResponse<List<SafetyAssesmentRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSafetyAssess ends");
		return response;

	}

	// viewCategory
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> editSafetyAssess(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : editSafetyAssess starts");
		List<SafetyAssesmentRestModel> respList = new ArrayList<SafetyAssesmentRestModel>();
		try {
			String values = "SET @p_safetyId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_assesment_routines")
					.setParameter("actionType", "editSafetyAssess").setParameter("actionValue", values).getResultList();

			for (Object[] m : x) {
				SafetyAssesmentRestModel restPayroll = new SafetyAssesmentRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], null, null);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyAssesmentRestModel>> resp = new JsonResponse<List<SafetyAssesmentRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyAssesmentRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editSafetyAssess ends");
		return response;

	}

	// add safety
	public ResponseEntity<JsonResponse<Object>> addSafetyAssess(SafetyAssesmentRestModel model) {
		logger.info("Method : addSafetyAssess starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateSafetyAssesmentParam.getAddQuotParam(model);
			em.createNamedStoredProcedureQuery("ehs_safety_assesment_routines")
					.setParameter("actionType", "addModifyAssess").setParameter("actionValue", values).execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Success");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: estimateBudgetAddDao ends");

		return response;
	}
}
