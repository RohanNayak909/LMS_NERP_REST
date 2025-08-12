package nirmalya.aatithya.restmodule.qa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
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
public class QaMediaPreparationDao {
	Logger logger = LoggerFactory.getLogger(QaMediaPreparationDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDataForMedia(String orgName, String orgDivision) {
		logger.info("Method : getAggridDataForMedia Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
					.setParameter("actionType", "getAggridDataForMedia").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDataForMedia Dao ends");
		return resp;

	}

	// add
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addMediaPreparation(List<QaEvaluationBoppTapeModel> qc) {
		logger.info("Method : addMediaPreparation dao starts");
		JsonResponse<List<QaEvaluationBoppTapeModel>> resp = new JsonResponse<List<QaEvaluationBoppTapeModel>>();

		String value = GenerateEvaluationParam.addMedia(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getMediaId() != null && qc.get(0).getMediaId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getEvalutionId());
				em.createNamedStoredProcedureQuery("qa_media_preparation_routines").setParameter("actionType", "modifyMediaPreparation")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getSampleId());
				em.createNamedStoredProcedureQuery("qa_media_preparation_routines").setParameter("actionType", "addMediaPreparation")
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
		logger.info("Method : addMediaPreparation dao ends");
		return response;

	}

		// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalMediaPreparationView(String orgName, String orgDivision) {
		logger.info("Method : getTotalMediaPreparationView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
					.setParameter("actionType", "getTotalMediaPreparationView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalMediaPreparationView Dao ends");
		return resp;

	}

	 // edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editMediaPreparationViewRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : editMediaPreparationViewRecord Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
					.setParameter("actionType", "editMediaPreparationViewRecord").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editMediaPreparationViewRecord Dao ends");
		return resp;
	}


	// delete
	public ResponseEntity<JsonResponse<Object>> deleteMediaPreparationRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : deleteMediaPreparationRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
						.setParameter("actionType", "deleteMediaPreparationRecord").setParameter("actionValue", value)
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

		logger.info("Method : deleteMediaPreparationRecord ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveMediaPreparationRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : approveMediaPreparationRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD12" + value);
				em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
						.setParameter("actionType", "approveMediaPreparationRecord")
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

		logger.info("Method : approveMediaPreparationRecord ends");
		return response;
	}
//
	/*@SuppressWarnings("unchecked")
	public JsonResponse<Object> mediaPrepPdfDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : mediaPrepPdfDetails Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id ='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
					.setParameter("actionType", "pdfMediaPreparationViewRecord").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : mediaPrepPdfDetails Dao ends");
		System.out.println("resp******************" + resp);
		return resp;
	}*/
	
	
	//pdf
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> mediaPrepPdfDetails(String id,String orgName,String orgDivision) {
				logger.info("Method : mediaPrepPdfDetails Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_media_preparation_routines")
							.setParameter("actionType", "pdfMediaPreparationViewRecord").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : mediaPrepPdfDetails Dao ends");
				return resp;

			}
}