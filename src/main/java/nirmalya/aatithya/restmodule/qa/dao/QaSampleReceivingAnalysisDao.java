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
public class QaSampleReceivingAnalysisDao {
	Logger logger = LoggerFactory.getLogger(QaSampleReceivingAnalysisDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// getAggridDet
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAggridDataForSample(String orgName, String orgDivision) {
		logger.info("Method : getAggridDataForSample Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
					.setParameter("actionType", "getAggridDataForSample").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAggridDataForSample Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// add
	public ResponseEntity<JsonResponse<List<QaEvaluationBoppTapeModel>>> addSamplereceiving(List<QaEvaluationBoppTapeModel> qc) {
		logger.info("Method : addSamplereceiving dao starts");
		JsonResponse<List<QaEvaluationBoppTapeModel>> resp = new JsonResponse<List<QaEvaluationBoppTapeModel>>();

		String value = GenerateEvaluationParam.addSamplereceiving(qc);
		System.out.println("value===" + value);
		try {

			if (qc.get(0).getSampleId() != null && qc.get(0).getSampleId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getEvalutionId());
				em.createNamedStoredProcedureQuery("qa_sample_receiving_routines").setParameter("actionType", "modifySamplereceiving")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getSampleId());
				em.createNamedStoredProcedureQuery("qa_sample_receiving_routines").setParameter("actionType", "addSamplereceiving")
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
		logger.info("Method : addSamplereceiving dao ends");
		return response;

	}

		// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalSamplereceivingView(String orgName, String orgDivision , String type) {
		logger.info("Method : getTotalSamplereceivingView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_type='" + type + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
					.setParameter("actionType", "getTotalSamplereceivingView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalSamplereceivingView Dao ends");
		return resp;

	}

	 // edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSamplereceivingViewRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : editSamplereceivingViewRecord Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("value"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
					.setParameter("actionType", "editSamplereceivingViewRecord").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editSamplereceivingViewRecord Dao ends");
		return resp;
	}


	// delete
	public ResponseEntity<JsonResponse<Object>> deleteSamplereceivingRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : deleteSamplereceivingRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
						.setParameter("actionType", "deleteSamplereceivingRecord").setParameter("actionValue", value)
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

		logger.info("Method : deleteSamplereceivingRecord ends");
		return response;
	}

	// approve
	public ResponseEntity<JsonResponse<Object>> approveSamplereceivingRecord(String id, String orgName,
			String orgDivision) {
		logger.info("Method : approveSamplereceivingRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD12" + value);
				em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
						.setParameter("actionType", "approveSamplereceivingRecord")
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

		logger.info("Method : approveSamplereceivingRecord ends");
		return response;
	}
//
	//pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> sampleReceivingAnalysisRecord(String id,String orgName, String orgDivision) {
		logger.info("Method : sampleReceivingAnalysisRecord Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_sampleId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_sample_receiving_routines")
					.setParameter("actionType", "pdfSamplereceivingViewRecord").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : sampleReceivingAnalysisRecord Dao ends");
		return resp;

	}
}