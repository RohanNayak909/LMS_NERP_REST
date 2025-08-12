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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateAshAnalysisRawDataRecordParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateEvaluationParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateFatSolAnalysisRecordParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePCAAnalysisRecordParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRCFTMParam;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAdvanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.model.RestFatSolAnalysisModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaEvaluationBoppTapeModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestAshAnalysisRawDataModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaEvaluationBoppTapeDao {
	Logger logger = LoggerFactory.getLogger(QaEvaluationBoppTapeDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	@Autowired
	private EnvironmentVaribles env;

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDataForevaluation(String orgName, String orgDivision) {
		logger.info("Method : getAggridDataForevaluation Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
					.setParameter("actionType", "getAggridDataForevaluation").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDataForevaluation Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// add
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addEvaluation(List<QaEvaluationBoppTapeModel> qc) {
		logger.info("Method : addEvaluation dao starts");
		JsonResponse<List<QaEvaluationBoppTapeModel>> resp = new JsonResponse<List<QaEvaluationBoppTapeModel>>();
		
		String img = "";
		String delimiters = "\\.";
		System.out.println("qc.getImgUrl()==" + qc.get(0).getImgUrl());
		if (qc.get(0).getImgUrl() != null && qc.get(0).getImgUrl() != "") {
			String[] x = qc.get(0).getImgName().split(delimiters);
			try {
				byte[] bytes = Base64.getDecoder().decode(qc.get(0).getImgUrl());
				img = saveAllMediaDocuments(bytes, x[1].toString(), qc.get(0).getCreatedBy());
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
			qc.get(0).setImgUrl(url);
			qc.get(0).setImgName(img);
		}

		
		try {
			String value = GenerateEvaluationParam.getAddEvaluation(qc);
			System.out.println("value===" + value);
			if (qc.get(0).getEvalutionId() != null && qc.get(0).getEvalutionId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getEvalutionId());
				em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines").setParameter("actionType", "modifyEvaluation")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getEvalutionId());
				em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines").setParameter("actionType", "addEvaluation")
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

		ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> response = new ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : addEvaluation dao ends");
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

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalEvaluationBoppTapeView(String orgName, String orgDivision) {
		logger.info("Method : getTotalEvaluationBoppTapeView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
					.setParameter("actionType", "getTotalEvaluationBoppTapeView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalEvaluationBoppTapeView Dao ends");
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editEvaluationBoppTapeRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : editEvaluationBoppTapeRecord Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
					.setParameter("actionType", "editEvaluationBoppTapeRecord").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editEvaluationBoppTapeRecord Dao ends");
		return resp;
	}


	// deleteCrqs
	public ResponseEntity<JsonResponse<Object>> deleteEvaluationBoppTapeRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : deleteEvaluationBoppTapeRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
						.setParameter("actionType", "deleteEvaluationBoppTapeRecord").setParameter("actionValue", value)
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

		logger.info("Method : deleteEvaluationBoppTapeRecord ends");
		return response;
	}

	// approveCrqs
	public ResponseEntity<JsonResponse<Object>> approveEvaluationBoppTapeRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : approveEvaluationBoppTapeRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD12" + value);
				em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
						.setParameter("actionType", "approveEvaluationBoppTapeRecord")
						.setParameter("actionValue", value).execute();

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

		logger.info("Method : approveEvaluationBoppTapeRecord ends");
		return response;
	}
	

	// pdf.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPdfDetailsBoppTape(String id, String orgName, String orgDivision) {
		logger.info("Method : getPdfDetailsBoppTape Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_evaluation_bopp_tape_routines")
					.setParameter("actionType", "getPdfDetailsBoppTape").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getPdfDetailsBoppTape Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
}