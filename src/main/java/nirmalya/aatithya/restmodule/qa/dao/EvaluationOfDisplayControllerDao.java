package nirmalya.aatithya.restmodule.qa.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateDispCartonsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePolylinerParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfDisplayCartonsModel;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfPolylinerModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class EvaluationOfDisplayControllerDao {

	Logger logger = LoggerFactory.getLogger(EvaluationOfDisplayControllerDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@Autowired
	private EnvironmentVaribles env;

	// add.

	public ResponseEntity<JsonResponse<RestEvaluationOfDisplayCartonsModel>> addDispCartons(
			RestEvaluationOfDisplayCartonsModel qc) {
		logger.info("Method : addDispCartons dao starts");
		System.out.println(qc);
		JsonResponse<RestEvaluationOfDisplayCartonsModel> resp = new JsonResponse<RestEvaluationOfDisplayCartonsModel>();
		
		String img = "";
		String delimiters = "\\.";
		System.out.println("qc.getImgUrl()==" + qc.getImgUrl());
		if (qc.getImgUrl() != null && qc.getImgUrl() != "") {
			String[] x = qc.getImgName().split(delimiters);
			try {
				byte[] bytes = Base64.getDecoder().decode(qc.getImgUrl());
				img = saveAllMediaDocuments(bytes, x[1].toString(), qc.getCreatedBy());
				System.out.println("json==" + img);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String url = env.getMobileView() + "document/document/" + img;

			JSONObject json = new JSONObject();

			try {
				json.put("filename", img);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				json.put("fileurl", url);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			qc.setImgUrl(url);
			qc.setImgName(img);
		}

		

		try {
			String value = GenerateDispCartonsParam.getEvalOfDispCartons(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.getEvalutionId());

			if (qc.getEvalutionId() != null && qc.getEvalutionId() != "") {

				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
						.setParameter("actionType", "modifyDispCartons").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
						.setParameter("actionType", "addDispCartons").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<RestEvaluationOfDisplayCartonsModel>> response = new ResponseEntity<JsonResponse<RestEvaluationOfDisplayCartonsModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addDispCartons dao ends");
		return response;

	}
	
	
	
	// Save Document
	
	public String saveAllMediaDocuments(byte[] imageBytes, String ext, String user_id) {
		logger.info("Method : saveAllMedicalDocuments starts");

		String imageName = null;
		try {

			if (imageBytes != null) {
				long nowTime = new Date().getTime();

				if (ext.contentEquals("jpeg")) {
					imageName = user_id + "_" + nowTime + ".jpg";
				} else {
					imageName = user_id + "_" + nowTime + "." + ext;
				}
			}

			Path path = Paths.get(env.getFileUploadDocumenttUrl() + imageName);
			if (imageBytes != null) {
				Files.write(path, imageBytes);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		logger.info("Method : saveAllMediaDocuments ends");
		return imageName;
	}
	

	// View.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDispCartonsView(String orgName, String orgDivision) {
		logger.info("Method : getDispCartonsView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
					.setParameter("actionType", "getDispCartonsView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getDispCartonsView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// Edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editDispCartons(String id, String orgName, String orgDivision) {
		logger.info("Method : editDispCartons Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
					.setParameter("actionType", "editDispCartons").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : editDispCartons Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// Delete.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteDispCartons(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteDispCartons Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
					.setParameter("actionType", "deleteDispCartons").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : deleteDispCartons Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// Approve.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveDispCartons(String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveDispCartons Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "',@p_approvedBy='" + approvedBy + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
					.setParameter("actionType", "approveDispCartons").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : approveDispCartons Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDispCartonsDatas(String orgName, String orgDivision) {
		logger.info("Method : getAggridDispCartonsDatas Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
					.setParameter("actionType", "getAggridDispCartonsDatas").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDispCartonsDatas Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	//pdf
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewPdf(String id) {
			logger.info("Method : viewPdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_evalId='" + id +"';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_DISPLAY_CARTONS_ROUTINES)
						.setParameter("actionType", "viewPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : viewPdf Dao ends");
			return resp;

		}

}
