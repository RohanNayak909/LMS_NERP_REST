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
import nirmalya.aatithya.restmodule.qa.model.RestPhMeterCallibrationRecordModel;
import nirmalya.aatithya.restmodule.qa.model.RestRmPmReleaseStatusModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class PhMeterCallibrationRecordDao {
	Logger logger = LoggerFactory.getLogger(PhMeterCallibrationRecordDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	public ResponseEntity<JsonResponse<List<RestPhMeterCallibrationRecordModel>>> addPhDetails(List<RestPhMeterCallibrationRecordModel> qc) {
		logger.info("Method : addPhDetails dao starts");
		System.out.println(qc);
		JsonResponse<List<RestPhMeterCallibrationRecordModel>> resp = new JsonResponse<List<RestPhMeterCallibrationRecordModel>>();

		String value = GenerateRmPmReleaseStatusParameter.getPhMeter(qc);
		try {

			if (qc.get(0).getPhId() != null && qc.get(0).getPhId() != "") {

				em.createNamedStoredProcedureQuery(ProcedureNameConstants.PH_METER_ROUTINES)
				.setParameter("actionType", "modifyPhdetails").setParameter("actionValue", value).execute();

				
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.PH_METER_ROUTINES)
				.setParameter("actionType", "addPhDetails").setParameter("actionValue", value).execute();

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

		ResponseEntity<JsonResponse<List<RestPhMeterCallibrationRecordModel>>> response = new ResponseEntity<JsonResponse<List<RestPhMeterCallibrationRecordModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addPhDetails dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPhData(String orgName, String orgDivision) {
		logger.info("Method : viewPhData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.PH_METER_ROUTINES)
					.setParameter("actionType", "viewPhData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPhData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> editPhData(String phId,String orgName, String orgDiv) {
		logger.info("Method : editPhData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_phId='" + phId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.PH_METER_ROUTINES, "editPhData", value, em);
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
		logger.info("Method : editPhData Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvePhdata(String phId,String orgName,String orgDiv) {
		logger.info("Method : approvePhdata Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_phId='" + phId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = CommonUsed.getResultList(ProcedureNameConstants.PH_METER_ROUTINES, "approvePhdata", value, em);
			resp.setBody(x.get(0));
			resp.setCode("200");
			resp.setMessage("Approved successfully");
			} catch (Exception e) {
				resp.setCode("500");
				resp.setMessage(e.getMessage());
			}
		logger.info("Method : approvePhdata Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse <Object> deletePhReport(String phId,String orgName, String orgDiv) {
		logger.info("Method : deletePhReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_phId='" + phId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value"+value);
			
		 em.createNamedStoredProcedureQuery(ProcedureNameConstants.PH_METER_ROUTINES).setParameter("actionType", "deletePhReport")
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
		logger.info("Method : deletePhReport Dao ends");
		return resp;

	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> phMeterPdf(String id,String orgName, String orgDivision) {
		logger.info("Method : phMeterPdf Dao startsssss" + id );

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_phId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values******" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.PH_METER_ROUTINES)
					.setParameter("actionType", "PhDataPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("resp******" + resp);
		logger.info("Method : phMeterPdf Dao ends");
		return resp;

	}
	
}
