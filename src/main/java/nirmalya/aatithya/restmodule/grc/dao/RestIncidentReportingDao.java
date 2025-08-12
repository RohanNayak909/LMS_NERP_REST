package nirmalya.aatithya.restmodule.grc.dao;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.grc.model.RestIncidentReportingModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateIncidentReportingParameters;

@Repository
public class RestIncidentReportingDao {

	Logger logger = LoggerFactory.getLogger(RestIncidentReportingDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	/* DAO Function to Add */

	public ResponseEntity<JsonResponse<Object>> addReportingMasterDao(RestIncidentReportingModel restData) {
		logger.info("Method : Rest addReportingMasterDao   starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = GenerateIncidentReportingParameters.getIncidentReportingParam(restData);

				if (restData.getIncidentNo() == null || restData.getIncidentNo() == "") {
					em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
							.setParameter("actionType", "addIncidentReporting").setParameter("actionValue", values)
							.execute();
				}

				else {
					em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
							.setParameter("actionType", "modifyIncidentReporting").setParameter("actionValue", values)
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

		logger.info("Method : Rest addReportingMasterDao Dao ends");
		return response;

	}

	/* typeList */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getType() {

		logger.info("Method : getType starts");

		List<DropDownModel> typeList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
					.setParameter("actionType", "getTypeList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				typeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getType ends" + typeList);
		return typeList;
	}

	/* view */

	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestIncidentReportingModel>> viewReportingDao(String uId, String orgName,
			String orgDivision) {
		logger.info("Method : viewMasterDao starts");

		List<RestIncidentReportingModel> viewMasterData = new ArrayList<RestIncidentReportingModel>();
		JsonResponse<List<RestIncidentReportingModel>> resp = new JsonResponse<List<RestIncidentReportingModel>>();
		try {

			String values = "SET @p_createdBy='" + uId + "',@p_organization='" + orgName + "',@p_orgDivision='"
					+ orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
					.setParameter("actionType", "viewIncidentReporting").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				RestIncidentReportingModel restMasterData = new RestIncidentReportingModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
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
	public JsonResponse<RestIncidentReportingModel> editReportingDao(String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : editReporting Dao starts");
		RestIncidentReportingModel req = new RestIncidentReportingModel();
		JsonResponse<RestIncidentReportingModel> resp = new JsonResponse<RestIncidentReportingModel>();
		try {
			String value = "SET @p_incidentNo='" + id + "',@p_createdBy='" + uId + "',@p_organization='" + orgName
					+ "',@p_orgDivision='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
					.setParameter("actionType", "editIncidentReporting").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestIncidentReportingModel restDaata = new RestIncidentReportingModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], null, null, null);
				req = restDaata;

			}
			resp.setBody(req);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editReporting Dao ends");
		return resp;
	}

	/* delete */

	public ResponseEntity<JsonResponse<Object>> deleteReportingDao(String id, String uId, String orgName,
			String orgDivision) {
		logger.info("Method : deleteReportingDao starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_incidentNo='" + id + "',@p_createdBy='" + uId + "',@p_organization='" + orgName
						+ "',@p_orgDivision='" + orgDivision + "';";

				em.createNamedStoredProcedureQuery("goalIncidentReportingMaster")
						.setParameter("actionType", "deleteIncidentReporting").setParameter("actionValue", value)
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

		logger.info("Method : deleteReportingDao ends");
		return response;
	}

}
