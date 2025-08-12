package nirmalya.aatithya.restmodule.productionplan.dao;


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


import nirmalya.aatithya.restmodule.common.utils.productionplan.GeneratePackingProcessParameter;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.PackingDetailsRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;



@Repository

public class PackingDetailsDao {

	Logger logger = LoggerFactory.getLogger(PackingDetailsDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPackingDetailsData(String orgName, String orgDivision) {
		logger.info("Method : viewPackingDetailsData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "viewPackingDetailsData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPackingDetailsData Dao ends");
		
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> machineDtls(String id, String bId, String pId, String orgName, String orgDivision,String shift, String date) {
		logger.info("Method : machineDtls Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(date);
		try {
			String value = "SET @P_mixerId='" + id + "',@p_brandId='" + bId + "',@p_processId='" + pId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + shift + "',@p_date='" + Date + "';";
			System.out.println("value>>>>"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "machineDtls").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : machineDtls Dao ends");
		System.out.println("Body>>>>"+resp);
		return resp;
	}

	// add


	public ResponseEntity<JsonResponse<Object>> addPackingDetails(PackingDetailsRestModel addPackingDetails) {
		logger.info("Method : addPackingDetails starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = GeneratePackingProcessParameter.getAddPackagingDetails(addPackingDetails);
			


			em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines").setParameter("actionType", "addPackingDetails")
					.setParameter("actionValue", value).execute();
			resp.setCode("Success");
			resp.setMessage("Information save scuccessfully");
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

		logger.info("Method : addPackingDetails ends");

		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> processMfgDetailsPdfView(String id, String orgName, String orgDivision) {
		logger.info("Method : processMfgDetailsPdfView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_processId='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "processMfgDetailsPdfView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : processMfgDetailsPdfView Dao ends");
		
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> packingDetailsPdfView(String id, String orgName, String orgDivision) {
		logger.info("Method : packingDetailsPdfView Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_processId='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "packingDetailsPdfView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : packingDetailsPdfView Dao ends");
		
		return resp;

	}
	
	// Approve
	
	public ResponseEntity<JsonResponse<Object>> packingDataApprove(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : packingDataApprove dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_processId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			
			em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "packingDataApprove").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Approved");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : packingDataApprove dao ends");
		return response;
	}
	
	// item-data
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> itemDetailsView(String id, String amt, String planId, String orgName,
			String orgDivision) {
		logger.info("Method : itemDetailsView dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_skuId='" + id + "',@p_amt='" + amt + "',@p_planId='" + planId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
		
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_pkt_dtls_routines")
					.setParameter("actionType", "itemDetailsView").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setMessage("Approved");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : itemDetailsView dao ends");
		return response;
	}

}
