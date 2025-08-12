package nirmalya.aatithya.restmodule.master.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.CommonConstants;
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.GenerateEmployeeTDSParameters;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.model.RestTDSModel;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestTDSDao {
	Logger logger = LoggerFactory.getLogger(RestTDSDao.class);

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager em;

	// view TDS data
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewTDSdata(String orgName, String orgDivision, String year, String month) {
		logger.info("Method : viewTDSdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = "SET @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "',@p_year='" + year
				+ "',@p_month='" + month + "';";
		logger.info(values);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthlyTDSRoutiness")
					.setParameter("actionType", "viewMonthlyEmployeeTDS").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			logger.info("Last Exception", e);
			// Handle other exceptions
			CommonUsed.getErrorDetails(resp, e, serverDao);///////// method called here
			Util.setJsonResponse(resp, null, CommonConstants.INTERNAL_SERVER_ERROR, resp.getMessage());
		}
		logger.info("resp : {}", resp);
		logger.info("Method : viewTDSdata Dao ends");
		return resp;
	}

//employeeTdsSave
	public ResponseEntity<JsonResponse<Object>> employeeTdsSave(RestTDSModel restTDSmodel) {
		logger.info("Method : employeeTdsSave starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String values = GenerateEmployeeTDSParameters.getTDSMasterParam(restTDSmodel);
			logger.info(values);

			if (restTDSmodel.getTdsId() == null || restTDSmodel.getTdsId().isEmpty()) {
				em.createNamedStoredProcedureQuery("monthlyTDSRoutiness").setParameter("actionType", "employeeTdsSave")
						.setParameter("actionValue", values).execute();
				String respMessage = "Data Saved successfully.";
				Util.setJsonResponse(resp, null, CommonConstants.HTTP_STATUS_OK, respMessage);
			} else {
				em.createNamedStoredProcedureQuery("monthlyTDSRoutiness")
						.setParameter("actionType", "employeeTdsModify").setParameter("actionValue", values).execute();
				String respMessage = "Data Modify successfully.";
				Util.setJsonResponse(resp, null, CommonConstants.HTTP_STATUS_OK, respMessage);
			}
		} catch (Exception e) {
			logger.info("Last Exception", e);
			// Handle other exceptions
			CommonUsed.getErrorDetails(resp, e, serverDao);///////// method called here
			Util.setJsonResponse(resp, null, CommonConstants.INTERNAL_SERVER_ERROR, resp.getMessage());
		}
		logger.info("resp : {}", resp);
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		return response;
	}

//employeeTdsEdit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> employeeTdsEdit(String id, String orgName, String orgDivision, String userId) {
		logger.info("Method : employeeTdsEdit dao starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_tdsId='" + id + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
					+ "',@p_userId='" + userId + "';";
			logger.info("value===" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("monthlyTDSRoutiness")
					.setParameter("actionType", "employeeTdsEdit").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			logger.info("Last Exception", e);
			// Handle other exceptions
			CommonUsed.getErrorDetails(resp, e, serverDao);///////// method called here
			Util.setJsonResponse(resp, null, CommonConstants.INTERNAL_SERVER_ERROR, resp.getMessage());
		}
		logger.info("Method : employeeTdsEdit dao ends");
		return resp;
	}

//employeeTdsApprove
	public JsonResponse<Object> employeeTdsApprove(String approveId, String orgName, String orgDivision,
			String userId) {
		logger.info("Method : employeeTdsApprove starts");
		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @p_tdsId='(" + approveId + ")', @p_orgName='" + orgName + "',@p_orgDivision='"
					+ orgDivision + "',@p_userId='" + userId + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("monthlyTDSRoutiness").setParameter("actionType", "employeeTdsApprove")
					.setParameter("actionValue", value).execute();
			String respMessage = "Data Approved Successfully.";
			Util.setJsonResponse(resp, null, CommonConstants.HTTP_STATUS_OK, respMessage);
		} catch (Exception e) {
			logger.info("Last Exception", e);
			// Handle other exceptions
			CommonUsed.getErrorDetails(resp, e, serverDao);///////// method called here
			Util.setJsonResponse(resp, null, CommonConstants.INTERNAL_SERVER_ERROR, resp.getMessage());
		}
		logger.info("resp : {}", resp);
		logger.info("Method : employeeTdsApprove ends");
		return resp;
	}

//employeeTdsDelete
	public JsonResponse<Object> employeeTdsDelete(String dltId, String orgName, String orgDivision, String userId) {
		logger.info("Method : employeeTdsDelete starts");
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_tdsId='(" + dltId + ")', @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision
					+ "',@p_userId='" + userId + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("monthlyTDSRoutiness").setParameter("actionType", "employeeTdsDelete")
					.setParameter("actionValue", value).execute();
			String respMessage = "Data Deleted Successfully.";
			Util.setJsonResponse(resp, null, CommonConstants.HTTP_STATUS_OK, respMessage);
		} catch (Exception e) {
			logger.info("Last Exception", e);
			// Handle other exceptions
			CommonUsed.getErrorDetails(resp, e, serverDao);///////// method called here
			Util.setJsonResponse(resp, null, CommonConstants.INTERNAL_SERVER_ERROR, resp.getMessage());
		}
		logger.info("resp : {}", resp);
		logger.info("Method : employeeTdsDelete ends");
		return resp;
	}
}
