package nirmalya.aatithya.restmodule.asset.dao;

import java.util.Base64;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetEquipementRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetStockRequestRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateStockRequestParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class AssetEquipementRequestDao {
	Logger logger = LoggerFactory.getLogger(AssetEquipementRequestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEquipementDetails(String orgName, String orgDivision) {
		logger.info("Method : viewEquipementDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_execution_request_routines")
					.setParameter("actionType", "viewEquipement").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEquipementDetails Dao ends");
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editEquipementDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : editEquipementDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_requestId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("asset_execution_request_routines")
					.setParameter("actionType", "editEquipement").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			resp.setCode("unsuccess");
			resp.setMessage("Data Couldn't Be Fetched");
			e.printStackTrace();
		}
		logger.info("Method : editEquipementDetails Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addApprovedEquipement(List<AssetEquipementRequestRestModel> av) {
		logger.info("Method : addApprovedEquipement dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = GenerateStockRequestParam.getRequestList(av);
		try {

			if (av.get(0).getRequestid() != null && av.get(0).getRequestid() != "") {

				em.createNamedStoredProcedureQuery("asset_execution_request_routines")
						.setParameter("actionType", "approveEquipe").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}


		logger.info("Method : addApprovedEquipement dao ends");
		return resp;

	}
	
	public ResponseEntity<JsonResponse<Object>> rejectEquipementRequest(String id, String orgName, String orgDivision) {
		logger.info("Method : rejectEquipementRequest starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_requestId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
						+ "';";
				em.createNamedStoredProcedureQuery("asset_execution_request_routines")
						.setParameter("actionType", "rejectEquipement").setParameter("actionValue", value).execute();
				resp.setMessage("Data Assigned Successfully");
				resp.setCode("success");
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

		logger.info("Method : rejectEquipementRequest ends");

		return response;
	}
}
