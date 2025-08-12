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
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateRiskControlParam;
import nirmalya.aatithya.restmodule.grc.model.RestRiskControlModel;

@Repository
public class RiskControlDao {
	Logger logger = LoggerFactory.getLogger(RiskControlDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRiskdetailsForControl(String orgName, String orgDivision, String userId) {
		logger.info("Method : viewRiskdetailsForControl Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_control_Routines")
					.setParameter("actionType", "viewRiskdetailsForControl").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRiskdetailsForControl Dao ends");
		return resp;

	}

	// Save
	public ResponseEntity<JsonResponse<Object>> saveControlDetails(RestRiskControlModel model) {
		logger.info("Method : saveControlDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GenerateRiskControlParam.getControlParam(model);

			if (model.getRiskId() != null || model.getRiskId() != "") {
				logger.info("model===" + model.getRiskId());
				em.createNamedStoredProcedureQuery("ehs_control_Routines")
						.setParameter("actionType", "saveControlDetails").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data save successfully");
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
		logger.info("Method : saveControlDetails ends");

		return response;
	}
	// edit Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editControlData(String id,String impactMitigationId, String riskIdentificationId,String orgName, String orgDivision) {
		logger.info("Method : editControlData Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_riskId='" + id + "', @p_org='" + orgName + "',@p_impactMitigationId='" + impactMitigationId + "',@p_riskIdentificationId='" + riskIdentificationId + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_control_Routines")
					.setParameter("actionType", "editControlData").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editControlData Dao ends");
		logger.info("resp" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> RequisitionList(String id,String orgName,
			String orgDiv) {

		logger.info("Method : RequisitionList starts");
		List<DropDownModel> referenceList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("ehs_control_Routines")
					.setParameter("actionType", "getRequisitionLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				referenceList.add(dropDownModel);
			}
			resp.setBody(referenceList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : RequisitionList ends"+response);
		return response;
	}
	
}
