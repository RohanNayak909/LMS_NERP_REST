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
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateCrqsParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GeneratePCAAnalysisRecordParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRCFTMParam;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateAdvanceManagementParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.qa.model.PACAnalysisRecordRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaCrqsRestModel;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaPcaAnalysisDao {
	Logger logger = LoggerFactory.getLogger(QaPcaAnalysisDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// Save
	public ResponseEntity<JsonResponse<Object>> savePCAAnalysisRecord(PACAnalysisRecordRestModel model) {
		logger.info("Method : savePCAAnalysisRecord starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("advance===" + model);
		try {

			String value = GeneratePCAAnalysisRecordParam.getRecordParam(model);

			if (model.getPcaAnalysisId() == null || model.getPcaAnalysisId() == "") {
				em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
						.setParameter("actionType", "savePCAAnalysisRecord").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Information save scuccessfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
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
		logger.info("Method : savePCAAnalysisRecord ends");

		return response;
	}

	// getTotalCrqsView
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTotalPcaAnalysisView(String orgName, String orgDivision) {
		logger.info("Method : getTotalPcaAnalysisView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
					.setParameter("actionType", "getTotalPcaAnalysisView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getTotalPcaAnalysisView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// edit
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editAnalysisRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : editAnalysisRecord Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
					.setParameter("actionType", "editAnalysisRecord").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editAnalysisRecord Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}

	// deleteCrqs
	public ResponseEntity<JsonResponse<Object>> deleteAnalysisRecord(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteAnalysisRecord starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
						.setParameter("actionType", "deleteAnalysisRecord").setParameter("actionValue", value)
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

		logger.info("Method : deleteAnalysisRecord ends");
		return response;
	}

	// approveCrqs
	public ResponseEntity<JsonResponse<Object>> approvepcaanalysis(String id, String orgName, String orgDivision) {
		logger.info("Method : approvepcaanalysis starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("IDD" + value);
				em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
						.setParameter("actionType", "approvepcaanalysis").setParameter("actionValue", value).execute();

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

		logger.info("Method : approvepcaanalysis ends");
		return response;
	}
//
	//pdf
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> pcaAnalysisRecord(String id,String orgName, String orgDivision) {
				logger.info("Method : pcaAnalysisRecord Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_pcaAnalysisId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_pcaanalysis_record_routines")
							.setParameter("actionType", "pcaAnalysisRecordPdf").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : pcaAnalysisRecord Dao ends");
				return resp;

			}
		
}