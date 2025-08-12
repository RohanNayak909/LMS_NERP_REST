package nirmalya.aatithya.restmodule.asset.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.asset.model.AssetDocumentRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetPlanningRestModel;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.asset.GenerateAssetViewMaster;
import nirmalya.aatithya.restmodule.common.utils.asset.GeneratePropertyPlanningParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.training.model.ManageTrainingRestDocumentModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManagePropertyPlanningDao {
	Logger logger = LoggerFactory.getLogger(ManagePropertyPlanningDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// addAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addPropertyPlanning(List<AssetPlanningRestModel> av) {
		logger.info("Method : addPropertyPlanning dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		JSONObject json = new JSONObject();
		logger.info("MODEL DATA === " + av);
		String value = GeneratePropertyPlanningParam.addPlanProperty(av);
		try {

			if (av.get(0).getPlanId() != null && av.get(0).getPlanId() != "") {

				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "modifyPlanning").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("assetPropertyRoutines").setParameter("actionType", "addPlanning")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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


		logger.info("Method : addPropertyPlanning dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyPlan(String id,String orgName, String orgDivision) {
		logger.info("Method : viewPropertyPlan Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_id='" + id + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewPropertyPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyPlan Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> deletePlanning(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePlanning starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "deletePlanning").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Plan Deleted successfully");
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

		logger.info("Method : deletePlanning ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPropertyPlan(String id, String orgName, String orgDivision) {
		logger.info("Method : editPropertyPlan Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "editPropertyPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editPropertyPlan Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPropertyApproved(String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method : viewPropertyApproved Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision+ "',@p_property='" + property + "',@p_floor='" + floor + "',@p_space='" + space + "';";
			System.out.println("VALUES::::"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("assetPropertyRoutines")
					.setParameter("actionType", "viewPropertyApproved").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPropertyApproved Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> rejectPlanning(String id, String orgName, String orgDivision) {
		logger.info("Method : rejectPlanning starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("assetPropertyRoutines")
						.setParameter("actionType", "rejectPlanning").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Plan Deleted successfully");
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

		logger.info("Method : rejectPlanning ends");
		return response;
	}
}
