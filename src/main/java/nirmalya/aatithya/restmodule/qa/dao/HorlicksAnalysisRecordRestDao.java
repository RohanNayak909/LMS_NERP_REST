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
import nirmalya.aatithya.restmodule.common.CommonUsed;
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRmPmReleaseStatusParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.HorlicksAnalysisRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;


	@Repository
	public class HorlicksAnalysisRecordRestDao {
		Logger logger = LoggerFactory.getLogger(HorlicksAnalysisRecordRestDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;

		@Autowired
		CheckDuplicateDao checkDuplicateDao;
		
//VIEW
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> horlicksAnalysisView(String orgName, String orgDivision) {
			logger.info("Method : horlicksAnalysisView Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.Horlicks_Analysis_Routines)
						.setParameter("actionType", "horlicksAnalysisView").setParameter("actionValue", value)
						.getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewRmpmData Dao ends");
			return resp;

		}
//ADD
		public ResponseEntity<JsonResponse<List<HorlicksAnalysisRestModel>>> addhorlicks(List<HorlicksAnalysisRestModel> qc) {
			logger.info("Method : addhorlicks dao starts");
			System.out.println(qc);
			JsonResponse<List<HorlicksAnalysisRestModel>> resp = new JsonResponse<List<HorlicksAnalysisRestModel>>();

			String value = GenerateRmPmReleaseStatusParameter.getHorlicks(qc);
			System.out.println("value===" + value);
			System.out.println("Modify qc===" + qc.get(0).getHorlicksId());
			try {

				if (qc.get(0).getHorlicksId() != null && qc.get(0).getHorlicksId() != "") {

					System.out.println("modifuuuu===" + qc.get(0).getHorlicksId());
					em.createNamedStoredProcedureQuery(ProcedureNameConstants.Horlicks_Analysis_Routines)
					.setParameter("actionType", "modifyHorlics").setParameter("actionValue", value).execute();

					
					resp.setCode("success");
					resp.setMessage("Data Modified successfully");

				} else {
					System.out.println("addd===" + qc.get(0).getHorlicksId());
					em.createNamedStoredProcedureQuery(ProcedureNameConstants.Horlicks_Analysis_Routines)
					.setParameter("actionType", "addHorlics").setParameter("actionValue", value).execute();

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

			ResponseEntity<JsonResponse<List<HorlicksAnalysisRestModel>>> response = new ResponseEntity<JsonResponse<List<HorlicksAnalysisRestModel>>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addhorlicks dao ends");
			return response;

		}
//EDIT
		@SuppressWarnings("unchecked")
		public JsonResponse <Object> editHorlicks(String horlicksId,String orgName, String orgDiv) {
			logger.info("Method : editHorlicks Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_horlicksId='" + horlicksId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.Horlicks_Analysis_Routines, "editHorlicksData", value, em);
				resp.setBody(x.get(0));
				resp.setCode("200");
				resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					/*
					 * resp.setCode("500"); resp.setMessage(e.getMessage());
					 */
					e.printStackTrace();
					CommonUsed.getErrorDetails(resp, e, serverDao);
				}
			logger.info("Method : editHorlicks Dao ends");
			return resp;

		}
//Delete
		@SuppressWarnings("unchecked")
		public JsonResponse <Object> deleteHorlicks(String id,String orgName, String orgDiv) {
			logger.info("Method : deleteHorlicks Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_horlicksId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				System.out.println("value"+value);
				
			 em.createNamedStoredProcedureQuery(ProcedureNameConstants.Horlicks_Analysis_Routines)
			 .setParameter("actionType", "deleteHorlicksRecord")
				.setParameter("actionValue", value).execute();
				
			} catch (Exception e) {
				e.printStackTrace();
				CommonUsed.getErrorDetails(resp, e, serverDao);
			}

			if (resp.getMessage() == null) {
				resp.setMessage("Deleted successfully");
			}

			if (resp.getCode() == null) {
				resp.setCode("200");
			}
			logger.info("Method : deleteHorlicks Dao ends");
			return resp;

		}
//Approve
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> approveHorlicksData(String id,String orgName,String orgDiv) {
			logger.info("Method : approveHorlicksData Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_horlicksId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.Horlicks_Analysis_Routines,
						"approveHorlicksRecord", value, em);
				resp.setBody(x.get(0));
				resp.setCode("200");
				resp.setMessage("Approved successfully");
				} catch (Exception e) {
					resp.setCode("500");
					resp.setMessage(e.getMessage());
				}
			logger.info("Method : approveHorlicksData Dao ends");
			return resp;

		}
//pdf
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> horlicsAnalysisPdf(String id,String orgName, String orgDivision) {
			logger.info("Method : horlicsAnalysisPdf Dao startsssss" + id );

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_horlicksId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("values******" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.Horlicks_Analysis_Routines)
						.setParameter("actionType", "pdfHorlicksData").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}
			logger.info("resp******" + resp);
			logger.info("Method : horlicsAnalysisPdf Dao ends");
			return resp;

		}
}
