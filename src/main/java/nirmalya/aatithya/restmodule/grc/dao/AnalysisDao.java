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
import nirmalya.aatithya.restmodule.common.utils.GenerateAdvanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAnalysisParam;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateRiskIdentificationParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.RestAnalysisModel;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AnalysisDao {
	Logger logger = LoggerFactory.getLogger(IdentificationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add main
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAnalysisModel>>> addAnalysisDetails(
			List<RestAnalysisModel> restAnalysisModel) {

		logger.info("Method : addAnalysisDetails starts");

		JsonResponse<List<RestAnalysisModel>> resp = new JsonResponse<List<RestAnalysisModel>>();
		List<RestAnalysisModel> listData = new ArrayList<RestAnalysisModel>();

		try {
			String values = GenerateAnalysisParam.getAddAnalysis(restAnalysisModel);

			logger.info("IDd" + restAnalysisModel.get(0).getIdentificationId());
			if (restAnalysisModel.get(0).getAnalysisId() == null || restAnalysisModel.get(0).getAnalysisId() == "") {
				logger.info("ADS#" + values);

				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "addAnalysisDetails").setParameter("actionValue", values).execute();

			} else {

				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "modifyAnalysisDetails").setParameter("actionValue", values)
						.execute();

				logger.info("modify print" + listData);

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
		ResponseEntity<JsonResponse<List<RestAnalysisModel>>> response = new ResponseEntity<JsonResponse<List<RestAnalysisModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addAnalysisDetails ends");
		return response;
	}

	/*
	 * view main
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewaAllDetails(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewaAllDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "viewaAllDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewaAllDetails Dao ends");
		return resp;

	}

	// Save

	public ResponseEntity<JsonResponse<Object>> saveRiskdetails(RestAnalysisModel model) {
		logger.info("Method : saveRiskdetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("advance===" + model);
		try {

			String value = GenerateAnalysisParam.getriskParam(model);
			logger.info("Metho"+value);
			if (model.getRiskId() != null || model.getRiskId() != "") {
				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "saveRiskdetails").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");
			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode("failed");
				resp.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : saveRiskdetails ends");
		return response;
	}

	// Save
	public ResponseEntity<JsonResponse<Object>> saveImpactDetails(RestAnalysisModel model) {
		logger.info("Method : saveImpactDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("model===" + model);
		try {

			String value = GenerateAnalysisParam.getimpacteParam(model);

			if (model.getImpactAnalysisId() == null || model.getImpactAnalysisId() == "") {
				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "saveImpactDetails").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data save successfully");
			} else {
				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "modifyImpactDetails").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data modified successfully");
			}

		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);

				resp.setCode("failed");
				resp.setMessage("Something went wrong");

			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : saveImpactDetails ends");

		return response;
	}

	/*
	 * view risk details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRiskDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : viewRiskDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "viewRiskDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRiskDetails Dao ends" + resp);
		return resp;

	}

	/*
	 * view impact details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewImpactDetails(String orgName, String orgDivision, String riskId) {
		logger.info("Method : viewIdentification Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_riskId='" + riskId + "';";
			logger.info("Method"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "viewImpactDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewImpactDetails Dao ends");
		return resp;

	}

	// edit main Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAnalysisData(String id, String orgName, String orgDivision) {
		logger.info("Method : editAnalysisData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_analysisId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "editAnalysisData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAnalysisData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}
	// edit Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editImpactData(String id, String orgName, String orgDivision) {
		logger.info("Method : editImpactData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_impanalysisId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "editImpactData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editImpactData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	// get ImpactAndRiskData

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getImpactAndRiskData(String id, String orgName, String orgDivision) {
		logger.info("Method : getImpactAndRiskData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_riskId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "getImpactAndRiskData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getImpactAndRiskData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteAnalysisDetails(String id) {
		logger.info("Method : deleteAnalysisDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_analysisId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
						.setParameter("actionType", "deleteAnalysisDetails").setParameter("actionValue", value)
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

		logger.info("Method : deleteAnalysisDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveAnalysisDetails(String approveStatus, String analysisId,
			String orgName, String orgDivision) {
		logger.info("Method : approveAnalysisDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_analysisId='" + analysisId
					+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("ehs_analysis_Routines")
					.setParameter("actionType", "approveAnalysisDetails").setParameter("actionValue", value)
					.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveAnalysisDetails ends");
		return resp;
	}
}
