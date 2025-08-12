package nirmalya.aatithya.restmodule.grc.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateRiskIdentificationParam;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseIndentParam;
import nirmalya.aatithya.restmodule.grc.model.RiskIdentifictionRestModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

@Repository
public class IdentificationDao {
	Logger logger = LoggerFactory.getLogger(IdentificationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	/*
	 * view risk details
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIdentification(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewIdentification Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_identification_Routines")
					.setParameter("actionType", "viewIdentification").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewIdentification Dao ends");
		return resp;

	}

	// editIdentificationData

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editIdentificationData(String id, String orgName, String orgDivision) {
		logger.info("Method : editIdentificationData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_identificationId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_identification_Routines")
					.setParameter("actionType", "editIdentificationData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editIdentificationData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RiskIdentifictionRestModel>>> addIdentificationDetails(
			List<RiskIdentifictionRestModel> RiskIdentifictionRestModel) {

		logger.info("Method : addIdentificationDetails starts");

		JsonResponse<List<RiskIdentifictionRestModel>> resp = new JsonResponse<List<RiskIdentifictionRestModel>>();
		List<RiskIdentifictionRestModel> listData = new ArrayList<RiskIdentifictionRestModel>();

		try {
			String values = GenerateRiskIdentificationParam.getAddIdentification(RiskIdentifictionRestModel);

			logger.info("IDd" + RiskIdentifictionRestModel.get(0).getIdentificationId());
			if (RiskIdentifictionRestModel.get(0).getIdentificationId() == null
					|| RiskIdentifictionRestModel.get(0).getIdentificationId() == "") {
				logger.info("ADS#" + values);

				em.createNamedStoredProcedureQuery("ehs_identification_Routines")
						.setParameter("actionType", "addIdentificationDetails").setParameter("actionValue", values)
						.execute();

			} else {

				em.createNamedStoredProcedureQuery("ehs_identification_Routines")
						.setParameter("actionType", "modifyIdentificationDetails").setParameter("actionValue", values)
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
		ResponseEntity<JsonResponse<List<RiskIdentifictionRestModel>>> response = new ResponseEntity<JsonResponse<List<RiskIdentifictionRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addIdentificationDetails ends");
		return response;
	}

	/*
	 * view Data
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIdentificationProjectDetails(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewIdentification Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_identification_Routines")
					.setParameter("actionType", "viewIdentificationProjectDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewIdentificationProjectDetails Dao ends");
		return resp;

	}
	// delete

	public ResponseEntity<JsonResponse<Object>> deleteIdentificationDetails(String id) {
		logger.info("Method : deleteIdentificationDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_identificationId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("ehs_identification_Routines")
						.setParameter("actionType", "deleteIdentificationDetails").setParameter("actionValue", value).execute();

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

		logger.info("Method : deleteIdentificationDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveIdentificationDetails(String approveStatus, String identificationId, String orgName,
			String orgDivision) {
		logger.info("Method : approveIdentificationDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			// String value = "SET @p_approveStatus='" + approveStatus +
			// "',@p_quotationId='" + quotationId + "', @p_org='" + orgName +
			// "',@p_orgDiv='" + orgDivision + "';";

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_identificationId='" + identificationId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("ehs_identification_Routines")
					.setParameter("actionType", "approveIdentificationDetails").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveIdentificationDetails ends");
		return resp;
	}
}
