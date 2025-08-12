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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
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
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaFatSolAnalysisDao {
	Logger logger = LoggerFactory.getLogger(QaFatSolAnalysisDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// Save
	public ResponseEntity<JsonResponse<Object>> saveFatSolubilityAnalysisRecord(RestFatSolAnalysisModel model) {
		logger.info("Method : saveFatSolubilityAnalysisRecord starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("advance===" + model);
		try {

			String value = GenerateFatSolAnalysisRecordParam.getRecordParam(model);

			if (model.getFatSolAnalysisId() == null || model.getFatSolAnalysisId() == "") {
				em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
						.setParameter("actionType", "saveFatSolubilityAnalysisRecord").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Information save scuccessfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
						.setParameter("actionType", "modifyPCAAnalysisRecord").setParameter("actionValue", value)
						.execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, "Information updated scuccessfully.");

				resp.setCode("success");
				resp.setMessage("Data modified successfully");
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
		logger.info("Method : saveFatSolubilityAnalysisRecord ends");

		return response;
	}

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalFatSolAnalysisView(String orgName, String orgDivision) {
		logger.info("Method : getTotalFatSolAnalysisView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
					.setParameter("actionType", "getTotalFatSolAnalysisView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalFatSolAnalysisView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editFatSolAnalysisRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : editFatSolAnalysisRecord Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
					.setParameter("actionType", "editFatSolAnalysisRecord").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editFatSolAnalysisRecord Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// deleteCrqs
	public ResponseEntity<JsonResponse<Object>> deleteFatSolAnalysisRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteFatSolAnalysisRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
						.setParameter("actionType", "deleteFatSolAnalysisRecord").setParameter("actionValue", value)
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

		logger.info("Method : deleteFatSolAnalysisRecord ends");
		return response;
	}

	// approveCrqs
	public ResponseEntity<JsonResponse<Object>> approveFatSolAnalysisRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : approveFatSolAnalysisRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD12" + value);
				em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
						.setParameter("actionType", "approveFatSolAnalysisRecord").setParameter("actionValue", value).execute();

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

		logger.info("Method : approveFatSolAnalysisRecord ends");
		return response;
	}
//
	//pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> fatSolAnalysisPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : fatSolAnalysisPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_fatSolAnalysisId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_fatsolanalysis_record_routines")
					.setParameter("actionType", "fatSolAnalysisPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : fatSolAnalysisPdf Dao ends");
		return resp;

	}
}