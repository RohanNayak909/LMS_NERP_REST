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
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePolylinerParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfPolylinerModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class EvaluationOfPolylinerDao {

	Logger logger = LoggerFactory.getLogger(EvaluationOfPolylinerDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@Autowired
	private EnvironmentVaribles env;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// add.

	public ResponseEntity<JsonResponse<RestEvaluationOfPolylinerModel>> addPolyliner(
			RestEvaluationOfPolylinerModel qc) {
		logger.info("Method : addPolyliner dao starts");
		System.out.println(qc);
		JsonResponse<RestEvaluationOfPolylinerModel> resp = new JsonResponse<RestEvaluationOfPolylinerModel>();

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
			String value = GeneratePolylinerParam.getEvalOfPolyliner(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.getEvalutionId());

			if (qc.getEvalutionId() != null && qc.getEvalutionId() != "") {

				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
						.setParameter("actionType", "modifyPolyliner").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
						.setParameter("actionType", "addPolyliner").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<RestEvaluationOfPolylinerModel>> response = new ResponseEntity<JsonResponse<RestEvaluationOfPolylinerModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addPolyliner dao ends");
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
	public JsonResponse<Object> getPolylinerView(String orgName, String orgDivision) {
		logger.info("Method : getPolylinerView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "getPolylinerView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getPolylinerView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// Edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPolyliner(String id, String orgName, String orgDivision) {
		logger.info("Method : editPolyliner Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "editPolyliner").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : editPolyliner Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// Delete.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deletePolyliner(String id, String orgName, String orgDivision) {
		logger.info("Method : deletePolyliner Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "deletePolyliner").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : deletePolyliner Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// Approve.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvePolyliner(String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approvePolyliner Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "',@p_approvedBy='" + approvedBy + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "approvePolyliner").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : approvePolyliner Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	// pdf.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> pdfPolyliner(String id, String orgName, String orgDivision) {
		logger.info("Method : pdfPolyliner Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "pdfPolyliner").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : pdfPolyliner Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridPolylinerDatas(String orgName, String orgDivision) {
		logger.info("Method : getAggridPolylinerDatas Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_POLYLINER_ROUTINES)
					.setParameter("actionType", "getAggridPolylinerDatas").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridPolylinerDatas Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

}
