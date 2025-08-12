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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateIncidentCorrectiveActionParameters;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentCorrectiveActionModel;

@Repository
public class RestIncidentCorrectiveActionDao {

	Logger logger = LoggerFactory.getLogger(RestIncidentCorrectiveActionDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/* view */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestIncidentCorrectiveActionModel>> viewCorrectiveActionDao(String uId, String orgName,
			String orgDivision) {
		logger.info("Method : viewCorrectiveDao starts");

		List<RestIncidentCorrectiveActionModel> viewManageData = new ArrayList<RestIncidentCorrectiveActionModel>();
		JsonResponse<List<RestIncidentCorrectiveActionModel>> resp = new JsonResponse<List<RestIncidentCorrectiveActionModel>>();
		try {

			String values = "SET @p_createdBy='" + uId + "',@p_organization='" + orgName + "',@p_orgDivision='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentCorrectiveAction")
					.setParameter("actionType", "viewCorrectiveAction").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestIncidentCorrectiveActionModel restManageData = new RestIncidentCorrectiveActionModel(m[0], m[1],
						m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10]);
				viewManageData.add(restManageData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewManageData);
		logger.info("Method : viewCorrective Dao ends");
		return resp;
	}

	/* edit */

	@SuppressWarnings("unchecked")
	public JsonResponse<RestIncidentCorrectiveActionModel> editCorrectiveActionDao(String id, String uId,
			String orgName, String orgDivision) {
		logger.info("Method : editCasualAnalysis Dao starts");
		RestIncidentCorrectiveActionModel req = new RestIncidentCorrectiveActionModel();
		JsonResponse<RestIncidentCorrectiveActionModel> resp = new JsonResponse<RestIncidentCorrectiveActionModel>();
		try {
			String value = "SET @p_assignNo='" + id + "',@p_createdBy='" + uId + "',@p_organization='" + orgName
					+ "',@p_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentCorrectiveAction")
					.setParameter("actionType", "editCorrectiveAction").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestIncidentCorrectiveActionModel restDaata = new RestIncidentCorrectiveActionModel(m[0], m[1], m[2],
						m[3], m[4], m[5], m[6], m[7], null, null, null);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editCasualAnalysis Dao ends");
		return resp;
	}

//	/* DAO  Add */

	public ResponseEntity<JsonResponse<Object>> addCorrectiveActionDao(RestIncidentCorrectiveActionModel restData) {
		logger.info("Method : Rest addCasualAnalysisDao   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateIncidentCorrectiveActionParameters.getIncidentCorrectiveActionParam(restData);
				em.createNamedStoredProcedureQuery("goalIncidentCorrectiveAction")
						.setParameter("actionType", "modifyCorrectiveAction").setParameter("actionValue", values)
						.execute();
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

		logger.info("Method : Rest addCasualAnalysis Dao ends");
		return response;

	}
}
