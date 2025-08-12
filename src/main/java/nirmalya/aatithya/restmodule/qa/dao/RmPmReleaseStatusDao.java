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
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRCFTMParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateRmPmReleaseStatusParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaRCFTMRestModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RmPmReleaseStatusDao {
	Logger logger = LoggerFactory.getLogger(RmPmReleaseStatusDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<RestRmPmReleaseStatusModel>>> addrmpm(List<RestRmPmReleaseStatusModel> qc) {
		logger.info("Method : addrmpm dao starts");
		System.out.println(qc);
		JsonResponse<List<RestRmPmReleaseStatusModel>> resp = new JsonResponse<List<RestRmPmReleaseStatusModel>>();

		String value = GenerateRmPmReleaseStatusParameter.getRmPm(qc);
		System.out.println("value===" + value);
		System.out.println("Modify qc===" + qc.get(0).getRmPmId());
		try {

			if (qc.get(0).getRmPmId() != null && qc.get(0).getRmPmId() != "") {

				System.out.println("modifuuuu===" + qc.get(0).getRmPmId());
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.RMPM_ROUTINES)
				.setParameter("actionType", "modifyRmpm").setParameter("actionValue", value).execute();

				
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				System.out.println("addd===" + qc.get(0).getRmPmId());
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.RMPM_ROUTINES)
				.setParameter("actionType", "addRmpm").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<RestRmPmReleaseStatusModel>>> response = new ResponseEntity<JsonResponse<List<RestRmPmReleaseStatusModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addrmpm dao ends");
		return response;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRmpmData(String orgName, String orgDivision) {
		logger.info("Method : viewRmpmData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RMPM_ROUTINES)
					.setParameter("actionType", "viewRmpmData1").setParameter("actionValue", value)
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
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editRmpmData(String rmPmId,String orgName, String orgDiv) {
		logger.info("Method : editRmpmData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rmPmId='" + rmPmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.RMPM_ROUTINES, "editRmpmData", value, em);
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
		logger.info("Method : editRmpmData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveRmpmdata(String rmPmId,String orgName,String orgDiv) {
		logger.info("Method : approveRmpmdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_rmPmId='" + rmPmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.RMPM_ROUTINES, "approveRmpmdata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approveRmpmdata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deleteRmpmdata(String rmPmId,String orgName, String orgDiv) {
		logger.info("Method : deleteRmpmdata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_rmPmId='" + rmPmId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.RMPM_ROUTINES).setParameter("actionType", "deleteRmpmdata")
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
		logger.info("Method : deleteRmpmdata Dao ends");
		return resp;

	}
//PDF

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> rmpmPdf(String id,String orgName, String orgDivision) {
				logger.info("Method : rmpmPdf Dao startsssss" + id );

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_rmPmId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					logger.info("values******" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.RMPM_ROUTINES)
							.setParameter("actionType", "viewRmPmPdf").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
					e.printStackTrace();
				}
				logger.info("resp******" + resp);
				logger.info("Method : rmpmPdf Dao ends");
				return resp;

			}
}
