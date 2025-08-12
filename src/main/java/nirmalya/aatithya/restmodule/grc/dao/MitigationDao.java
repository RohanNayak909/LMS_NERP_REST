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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateMitigationParam;
import nirmalya.aatithya.restmodule.grc.model.RestMitigationModel;

@Repository
public class MitigationDao {
	Logger logger = LoggerFactory.getLogger(MitigationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * add main
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestMitigationModel>>> addMitigationDetails(
			List<RestMitigationModel> RestMitigationModel) {

		logger.info("Method : addMitigationDetails starts");

		JsonResponse<List<RestMitigationModel>> resp = new JsonResponse<List<RestMitigationModel>>();
		List<RestMitigationModel> listData = new ArrayList<RestMitigationModel>();

		try {
			String values = GenerateMitigationParam.getAddMitigation(RestMitigationModel);

			if (RestMitigationModel.get(0).getMitigationId() == null || RestMitigationModel.get(0).getMitigationId() == "") {
				logger.info("ADS#" + values);

				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
						.setParameter("actionType", "addMitigationDetails").setParameter("actionValue", values).execute();

			} else {

				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
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
		ResponseEntity<JsonResponse<List<RestMitigationModel>>> response = new ResponseEntity<JsonResponse<List<RestMitigationModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addMitigationDetails ends");
		return response;
	}

	/*
	 * view main
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewaAllDetailsForMitigation(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewaAllDetailsForMitigation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "viewaAllDetailsForMitigation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewaAllDetailsForMitigation Dao ends");
		return resp;

	}

	// Save

	public ResponseEntity<JsonResponse<Object>> saveRiskdetailsForMitigation(RestMitigationModel model) {
		logger.info("Method : saveRiskdetailsForMitigation starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("advance===" + model);
		try {

			String value = GenerateMitigationParam.getriskParam(model);

			if (model.getRiskId() != null || model.getRiskId() != "") {
				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
						.setParameter("actionType", "saveRiskdetailsForMitigation").setParameter("actionValue", value).execute();
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
		logger.info("Method : saveRiskdetailsForMitigation ends");
		return response;
	}

	// Save
	public ResponseEntity<JsonResponse<Object>> saveImpactDetailsForMitigation(RestMitigationModel model) {
		logger.info("Method : saveImpactDetailsForMitigation starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("model===" + model);
		try {

			String value = GenerateMitigationParam.getimpacteParam(model);

			if (model.getImpactMitigationId() == null || model.getImpactMitigationId() == "") {
				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
						.setParameter("actionType", "saveImpactDetailsForMitigation").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data save successfully");
			} else {
				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
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
		logger.info("Method : saveImpactDetailsForMitigation ends");

		return response;
	}

	/*
	 * view risk details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRiskDetailsForMitigation(String id, String orgName, String orgDivision) {
		logger.info("Method : viewRiskDetailsForMitigation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "viewRiskDetailsForMitigation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRiskDetailsForMitigation Dao ends" + resp);
		return resp;

	}

	/*
	 * view impact details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewImpactDetailsForMitigation(String orgName, String orgDivision, String riskId) {
		logger.info("Method : viewIdentification Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_riskId='" + riskId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "viewImpactDetailsForMitigation").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewImpactDetailsForMitigation Dao ends");
		return resp;

	}

	// edit main Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editMitigationData(String id, String orgName, String orgDivision) {
		logger.info("Method : editMitigationData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_mitigationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "editMitigationData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editMitigationData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}
	// edit Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editImpactDataForMitigation(String id, String orgName, String orgDivision) {
		logger.info("Method : editImpactDataForMitigation Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_impactMitigationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "editImpactDataForMitigation").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editImpactDataForMitigation Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	// get ImpactAndRiskData

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getImpactAndRiskDataForMitigation(String id, String orgName, String orgDivision) {
		logger.info("Method : getImpactAndRiskDataForMitigation Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_riskId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "getImpactAndRiskDataForMitigation").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getImpactAndRiskDataForMitigation Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteMitigationsDetails(String id) {
		logger.info("Method : deleteMitigationsDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @P_mitigationId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
						.setParameter("actionType", "deleteMitigationsDetails").setParameter("actionValue", value)
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

		logger.info("Method : deleteMitigationsDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveMitigationDetails(String approveStatus, String mitigationId, String orgName,
			String orgDivision) {
		logger.info("Method : approveMitigationDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {

			String value = "SET @p_approveStatus='" + approveStatus + "',@P_mitigationId='" + mitigationId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("ehs_mitigation_Routines")
					.setParameter("actionType", "approveMitigationDetails").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveMitigationDetails ends");
		return resp;
	}
}
