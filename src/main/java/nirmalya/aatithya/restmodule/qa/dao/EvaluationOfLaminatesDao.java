package nirmalya.aatithya.restmodule.qa.dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateLaminateParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestEvaluationOfLaminatesModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class EvaluationOfLaminatesDao {
	Logger logger = LoggerFactory.getLogger(EvaluationOfLaminatesDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@Autowired
	private EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getitemLists(String org, String orgDiv) {
		logger.info("Method : getitemLists Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "getitemlists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getitemLists Dao ends");
		return itemList;
	}
	
	
	// Get Item List Only For laminates.
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getitemListsForLami(String org, String orgDiv) {
		logger.info("Method : getitemListsForLami Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "getitemListsForLami").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getitemListsForLami Dao ends");
		return itemList;
	}

	// add.

	public ResponseEntity<JsonResponse<RestEvaluationOfLaminatesModel>> addLaminates(
			RestEvaluationOfLaminatesModel qc) {
		logger.info("Method : addLaminates dao starts");
		System.out.println(qc);
		JsonResponse<RestEvaluationOfLaminatesModel> resp = new JsonResponse<RestEvaluationOfLaminatesModel>();

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
			String value = GenerateLaminateParam.getEvalOfLamination(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.getEvalutionId());
			if (qc.getEvalutionId() != null && qc.getEvalutionId() != "") {

				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
						.setParameter("actionType", "modifyLaminates").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
						.setParameter("actionType", "addLaminates").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<RestEvaluationOfLaminatesModel>> response = new ResponseEntity<JsonResponse<RestEvaluationOfLaminatesModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addLaminates dao ends");
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
	public JsonResponse<Object> getLaminateView(String orgName, String orgDivision) {
		logger.info("Method : getLaminateView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "laminateView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getLaminateView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// Edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editLaminates(String id, String orgName, String orgDivision) {
		logger.info("Method : editLaminates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "editLaminates").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : editLaminates Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteLaminates(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteLaminates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "deleteLaminates").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : deleteLaminates Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveLaminates(String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveLaminates Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "',@p_approvedBy='" + approvedBy + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "approveLaminates").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : approveLaminates Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLaminatePdf(String id, String orgName, String orgDivision) {
		logger.info("Method : getLaminatePdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_evalId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "getLaminatePdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getLaminatePdf Dao ends" + resp);
		return resp;
	}

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDatas(String orgName, String orgDivision, String sku) {
		logger.info("Method : getAggridDatas Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_sku='" + sku + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_EVALUATION_OF_LAMINATES_ROUTINES)
					.setParameter("actionType", "getAggridDatas").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDatas Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

}
