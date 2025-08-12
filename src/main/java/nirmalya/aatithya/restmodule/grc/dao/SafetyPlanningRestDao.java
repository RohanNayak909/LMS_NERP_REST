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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateSafetyPlanningParam;
import nirmalya.aatithya.restmodule.grc.model.SafetyPlanningRestModel;

@Repository
public class SafetyPlanningRestDao {

	Logger logger = LoggerFactory.getLogger(SafetyAssesmentRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewCategory
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> getSafetyPlanning(String id, String userId,
			String org, String orgDiv) {
		logger.info("Method : getSafetyPlanning starts");
		List<SafetyPlanningRestModel> respList = new ArrayList<SafetyPlanningRestModel>();
		try {
			String values = "SET @p_safetyId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
					+ "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
					.setParameter("actionType", "getSafetyPlanning").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				SafetyPlanningRestModel restPayroll = new SafetyPlanningRestModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyPlanningRestModel>> resp = new JsonResponse<List<SafetyPlanningRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSafetyPlanning ends" + respList);
		return response;

	}

	// add safety
	public ResponseEntity<JsonResponse<Object>> addSafetyPlanning(SafetyPlanningRestModel model) {
		logger.info("Method : addSafetyPlanning starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateSafetyPlanningParam.getAddQuotParam(model);
			if (model.getActionId() == "" || model.getActionId() == null) {
				em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
						.setParameter("actionType", "addSafetyPlanning").setParameter("actionValue", values).execute();
			} else {
				em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
						.setParameter("actionType", "modifySafetyPlanning").setParameter("actionValue", values)
						.execute();
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Success");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addSafetyPlanning ends");
		return response;
	}

	// viewSafetyPlanning
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> viewSafetyPlanning(String id, String pid,
			String userId, String org, String orgDiv) {
		logger.info("Method : viewSafetyPlanning starts");
		List<SafetyPlanningRestModel> respList = new ArrayList<SafetyPlanningRestModel>();
		try {
			String values = "SET @p_safetyId='" + id + "',@p_projectId='" + pid + "',@p_createdBy='" + userId
					+ "',@p_orgname='" + org + "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
					.setParameter("actionType", "viewSafetyPlanning").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				SafetyPlanningRestModel restPayroll = new SafetyPlanningRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyPlanningRestModel>> resp = new JsonResponse<List<SafetyPlanningRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSafetyPlanning ends");
		return response;

	}

	// editSafetyPlanning
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> editSafetyPlanning(String id, String sid,
			String pid, String userId, String org, String orgDiv) {
		logger.info("Method : editSafetyPlanning starts");
		List<SafetyPlanningRestModel> respList = new ArrayList<SafetyPlanningRestModel>();
		try {
			String values = "SET @p_actionId='" + id + "',@p_safetyId='" + sid + "',@p_projectId='" + pid
					+ "',@p_createdBy='" + userId + "',@p_orgname='" + org + "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
					.setParameter("actionType", "editSafetyPlanning").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				SafetyPlanningRestModel restPayroll = new SafetyPlanningRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyPlanningRestModel>> resp = new JsonResponse<List<SafetyPlanningRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyPlanningRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editSafetyPlanning ends");
		return response;

	}

	// delete
	public ResponseEntity<JsonResponse<Object>> deleteSafetyPlanning(String id, String userId, String org,
			String orgDiv) {
		logger.info("Method : deleteSafetyPlanning starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String values = "SET @p_actionId='" + id + "',@p_createdBy='" + userId + "',@p_orgname='" + org
						+ "',@p_orgdiv='" + orgDiv + "';";
				em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
						.setParameter("actionType", "deleteSafetyPlanning").setParameter("actionValue", values)
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}
		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method :  deleteSafetyPlanning ends");
		return response;
	}
	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getOwnerAutoSearchList(String id) {
		logger.info("Method : getOwnerAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_planning_routines")
					.setParameter("actionType", "getOwner").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getOwnerAutoSearchList dao ends");
		return response;
	}
}
