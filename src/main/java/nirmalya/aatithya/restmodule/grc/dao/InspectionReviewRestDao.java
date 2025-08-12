package nirmalya.aatithya.restmodule.grc.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.grc.GenerateAuditMasterParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.grc.model.ScheduledAuditPlanRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class InspectionReviewRestDao {

	Logger logger = LoggerFactory.getLogger(InspectionReviewRestDao.class);

	@Autowired	
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewInstnaceInspection(String scheduledId, String orgName, String orgDivision) {
		logger.info("Method : viewInstnaceInspection Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "', @p_scheduledId='"
					+ scheduledId + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
					.setParameter("actionType", "viewInstnaceInspection").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewInstnaceInspection Dao ends");
		return resp;

	}

	public ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> addReviewForInspection(
			List<ScheduledAuditPlanRestModel> sap) {
		logger.info("Method : addReviewForInspection dao starts");
		JsonResponse<List<ScheduledAuditPlanRestModel>> resp = new JsonResponse<List<ScheduledAuditPlanRestModel>>();

		String value = GenerateAuditMasterParam.getScheduleReviewed(sap);
		System.out.println("VALUE :::: " + value);
		try {

			if (sap.get(0).getScheduledId() != null && sap.get(0).getScheduledId() != "") {

				em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "addReviewForInspection").setParameter("actionValue", value)
						.execute();

				resp.setCode("success");
				resp.setMessage("Details Reviewed successfully");

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

		ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>> response = new ResponseEntity<JsonResponse<List<ScheduledAuditPlanRestModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : addReviewForInspection dao ends");
		return response;

	}

	/*
	 * Get all report data
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReportAllData(String planId, String scheduledId, String category, String instanceId,
			String orgName, String orgDivision) {
		logger.info("Method : getReportAllData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		String value = "SET @p_planId='" + planId + "', @p_scheduledId='" + scheduledId + "', @p_category='" + category
				+ "', @p_instanceId='" + instanceId + "', @p_orgDiv='" + orgDivision + "', @p_org='" + orgName + "';";

		System.out.println("value>>>>>>>" + value);

		if (category.equals("CAT0010")) {

			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getAmbulanceReport").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}
		} else if (category.equals("CAT0011")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getBusChecklistPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} else if (category.equals("CAT0023")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getInspectionPlant").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} else if (category.equals("CAT0027") || category.equals("CAT0032")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getFirstAidList").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} else if (category.equals("CAT0024")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getFireFightingEqui").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} else if (category.equals("CAT0016")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getCarChecklistPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} else if (category.equals("CAT0014")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getLadderInspectionCheckList").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0017")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getPumpHouseChecklistPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0012")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getCageHoistChecklistPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0013") || (category.equals("CAT0030"))) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getChecklistForSaftyPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0015") || (category.equals("CAT0018")) || (category.equals("CAT0021")) || (category.equals("CAT0022"))) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getMachineGuardPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0031")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getDoorInterlockChecklistPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}else if (category.equals("CAT0033")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getStfAuditReportPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}
		
		else if (category.equals("CAT0034")) {
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("inspection_master_routines")
						.setParameter("actionType", "getSwagatEnggPdf").setParameter("actionValue", value)
						.getResultList();

				Util.setJsonResponse(resp, x.get(0), ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);

			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		}

		logger.info("Method : getReportAllData Dao ends");

		System.out.println("@@" + resp);
		return resp;

	}

}
