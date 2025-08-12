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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateSafetyControlParam;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateSafetyPlanningParam;
import nirmalya.aatithya.restmodule.grc.model.SafetyControlRestModel;

@Repository
public class SafetyControlRestDao {
	Logger logger = LoggerFactory.getLogger(SafetyAssesmentRestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// viewSafetyPlanning
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> viewSafetyControl(String id, String pid,
			String userId, String org, String orgDiv) {
		logger.info("Method : viewSafetyControl starts");
		List<SafetyControlRestModel> respList = new ArrayList<SafetyControlRestModel>();
		try {
			String values = "SET @p_safetyId='" + id + "',@p_projectId='" + pid + "',@p_createdBy='" + userId
					+ "',@p_orgname='" + org + "',@p_orgdiv='" + orgDiv + "';";
			
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_control_routines")
					.setParameter("actionType", "viewSafetyControl").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				SafetyControlRestModel restPayroll = new SafetyControlRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyControlRestModel>> resp = new JsonResponse<List<SafetyControlRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyControlRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewSafetyControl ends" + respList);
		return response;

	}

	// editSafetyPlanning
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> editSafetyControl(String id, String sid,
			String pid, String userId, String org, String orgDiv) {
		logger.info("Method : editSafetyControl starts");
		List<SafetyControlRestModel> respList = new ArrayList<SafetyControlRestModel>();
		try {
			String values = "SET @p_actionId='" + id + "',@p_safetyId='" + sid + "',@p_projectId='" + pid
					+ "',@p_createdBy='" + userId + "',@p_orgname='" + org + "',@p_orgdiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_control_routines")
					.setParameter("actionType", "editSafetyControl").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				SafetyControlRestModel restPayroll = new SafetyControlRestModel(m[0], m[1], m[2], m[3], m[4], m[5],
						m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14]);
				respList.add(restPayroll);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<SafetyControlRestModel>> resp = new JsonResponse<List<SafetyControlRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<SafetyControlRestModel>>> response = new ResponseEntity<JsonResponse<List<SafetyControlRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : editSafetyControl ends" + respList);
		return response;

	}

	// add safety
	public ResponseEntity<JsonResponse<Object>> addSafetyControl(SafetyControlRestModel model) {
		logger.info("Method : addSafetyControl starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = GenerateSafetyControlParam.getAddQuotParam(model);
			em.createNamedStoredProcedureQuery("ehs_safety_control_routines")
					.setParameter("actionType", "addModSafetyControl").setParameter("actionValue", values).execute();
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
		logger.info("Method in Dao: addSafetyControl ends");
		return response;
	}
	// auto search

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIndentNoAutoSearchList(String id) {
		logger.info("Method : getIndentNoAutoSearchList dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_safety_control_routines")
					.setParameter("actionType", "getIndentNo").setParameter("actionValue", value).getResultList();
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
		logger.info("Method : getIndentNoAutoSearchList dao ends");
		return response;
	}

}
