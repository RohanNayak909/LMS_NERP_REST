package nirmalya.aatithya.restmodule.qa.dao;

import java.util.Base64;
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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GanearteWbcrParam;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateOuterCartonsParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.RestQaWbcrModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaWbcrDao {
	
	Logger logger = LoggerFactory.getLogger(QaWbcrDao.class);

	@Autowired
	EntityManager em;
	
	@Autowired
	EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAgGridView(String orgName, String orgDivision) {
		logger.info("Method : getAgGridView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES)
					.setParameter("actionType", "getAgGridView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAgGridView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;
		
	}
	
	
	// add
	
	public ResponseEntity<JsonResponse<RestQaWbcrModel>> addWbcr(
			RestQaWbcrModel qc) {
		logger.info("Method : addWbcr dao starts");
		System.out.println(qc);
		JsonResponse<RestQaWbcrModel> resp = new JsonResponse<RestQaWbcrModel>();

		try {
			String value = GanearteWbcrParam.getWbcrData(qc);
			System.out.println("value===" + value);
			

			if (qc.getWbcrId() != null && qc.getWbcrId() != "") {

				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES).setParameter("actionType", "modifyWbcr")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES).setParameter("actionType", "addWbcr")
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

		ResponseEntity<JsonResponse<RestQaWbcrModel>> response = new ResponseEntity<JsonResponse<RestQaWbcrModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addWbcr dao ends");
		return response;

	}
	
	// View
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getWbcrView(String orgName, String orgDivision) {
		logger.info("Method : getWbcrView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em
					.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES)
					.setParameter("actionType", "getWbcrView").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getWbcrView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;
		
	}
	
	
	// Edit
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editWbcr(String id, String orgName, String orgDivision) {
		logger.info("Method : editWbcr Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_wbcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES)
					.setParameter("actionType", "editWbcr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fatched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : editWbcr Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteWbcr(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteWbcr Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_wbcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES)
					.setParameter("actionType", "deleteWbcr").setParameter("actionValue", value).execute();
			
			resp.setCode("success");
			resp.setMessage("Data Deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : deleteWbcr Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveWbcr(String id, String orgName, String orgDivision, String approvedBy) {
		logger.info("Method : approveWbcr Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_wbcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_approvedBy='" + approvedBy + "';";
			System.out.println("values***" + value);
			em.createNamedStoredProcedureQuery(ProcedureNameConstants.QA_WBCR_ROUTINES)
					.setParameter("actionType", "approveWbcr").setParameter("actionValue", value).execute();
			
			resp.setCode("success");
			resp.setMessage("Data Approved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : approveWbcr Dao ends");
		System.out.println("resp*" + resp);
		return resp;
	}
	
	
	
	//Download wbcr Pdf
	 @SuppressWarnings("unchecked")
		public JsonResponse<Object> downloadWbcrPdf(String id, String orgName, String orgDivision) {
			logger.info("Method : downloadWbcrPdf Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_wbcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("qa_wbcr_routins")
						.setParameter("actionType", "downloadwbcrPdf").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("Success");
				resp.setMessage("Pdf generated successfully");
				
			} catch (Exception e) {
				resp.setCode("Unsuccess");
				resp.setMessage("Something went wrong while generating pdf");
				e.printStackTrace();
			}
			logger.info("Method : downloadWbcrPdf Dao ends");
			return resp;
		}

}
