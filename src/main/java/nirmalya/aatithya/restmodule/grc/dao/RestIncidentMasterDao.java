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
import nirmalya.aatithya.restmodule.grc.model.RestIncidentMasterModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateIncidentMasterParameters;

@Repository
public class RestIncidentMasterDao {

	Logger logger = LoggerFactory.getLogger(RestIncidentMasterDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/* DAO Function to Add */

	public ResponseEntity<JsonResponse<Object>> addMasterDao(RestIncidentMasterModel restData) {
		logger.info("Method : Rest addMasterDao   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateIncidentMasterParameters.getIncidentMasterParam(restData);

				if (restData.getIncidentCode() == null || restData.getIncidentCode() == "") {
					em.createNamedStoredProcedureQuery("goalIncidentMaster")
							.setParameter("actionType", "addIncidentMaster").setParameter("actionValue", values)
							.execute();

				}

				else {
					em.createNamedStoredProcedureQuery("goalIncidentMaster")
							.setParameter("actionType", "modifyIncidentMaster").setParameter("actionValue", values)
							.execute();
				}
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

		logger.info("Method : Rest addMaster Dao ends");
		return response;

	}

	/* view */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestIncidentMasterModel>> viewMasterDao() {
		logger.info("Method : viewMasterDao starts");

		List<RestIncidentMasterModel> viewMasterData = new ArrayList<RestIncidentMasterModel>();
		JsonResponse<List<RestIncidentMasterModel>> resp = new JsonResponse<List<RestIncidentMasterModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentMaster")
					.setParameter("actionType", "viewIncidentMaster").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				RestIncidentMasterModel restMasterData = new RestIncidentMasterModel(m[0], m[1], m[2], m[3], null, null,
						null);
				viewMasterData.add(restMasterData);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(viewMasterData);
		logger.info("Method : viewMaster Dao ends");
		return resp;
	}

	/* edit */

	@SuppressWarnings("unchecked")
	public JsonResponse<RestIncidentMasterModel> editMasterDao(String id, String orgName, String orgDivision,
			String uId) {
		logger.info("Method : editMaster Dao starts");
		RestIncidentMasterModel req = new RestIncidentMasterModel();
		JsonResponse<RestIncidentMasterModel> resp = new JsonResponse<RestIncidentMasterModel>();
		try {
			String value = "SET @p_incidentCode='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentMaster")
					.setParameter("actionType", "editIncidentMaster").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestIncidentMasterModel restDaata = new RestIncidentMasterModel(m[0], m[1], m[2], m[3], null, null,
						null);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editMaster Dao ends");
		return resp;
	}

	/* delete */

	public ResponseEntity<JsonResponse<Object>> deleteMasterDao(String id) {
		logger.info("Method : deleteMasterDao starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_incidentCode='" + id + "';";

				em.createNamedStoredProcedureQuery("goalIncidentMaster")
						.setParameter("actionType", "deleteIncidentMaster").setParameter("actionValue", value)
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

		logger.info("Method : deleteMasterDao ends");
		return response;
	}
}
