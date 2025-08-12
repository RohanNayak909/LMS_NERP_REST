package nirmalya.aatithya.restmodule.samudyamproduction.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.GeneratePatternMasterParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.samudyamproduction.model.RestPatternMasterModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;
@Repository
public class RestPatternMasterDao {
	Logger logger = LoggerFactory.getLogger(RestPatternMasterDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	EntityManager entityManager;
	
	// addPatternDetails

	public ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> addPatternDetails(RestPatternMasterModel pstternModel) {
		logger.info("Method : addPatternDetails dao starts");
		JsonResponse<List<RestPatternMasterModel>> resp = new JsonResponse<List<RestPatternMasterModel>>();

		String value = GeneratePatternMasterParameter.getPatternMasterParam(pstternModel);
		logger.info("value===" + value);
		try {
			if (pstternModel.getPatternId() != null && pstternModel.getPatternId() != "") {
				entityManager.createNamedStoredProcedureQuery("nerp_production_patternRoutines")
						.setParameter("actionType", "modifyPattern").setParameter("actionValue", value).execute();
			} else {
				entityManager.createNamedStoredProcedureQuery("nerp_production_patternRoutines")
						.setParameter("actionType", "addPattern").setParameter("actionValue", value).execute();
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
		ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestPatternMasterModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response===" + response);
		logger.info("Method : addPatternDetails dao ends");
		return response;
	}
	//viewPatternDetails
		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> viewPatternDetails(String org, String orgDiv) {
			logger.info("Method : viewPatternDetails starts");
			List<RestPatternMasterModel> respList = new ArrayList<RestPatternMasterModel>();
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value===" + value);
			try {
				List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_patternRoutines")
						.setParameter("actionType", "viewPatternDetails").setParameter("actionValue", value)
						.getResultList();
				for (Object[] m : x) {
					Object DATE = null;
					if (m[3] != null) {
						DATE = DateFormatter.returnStringDate(m[3]);
					}
					Object ADATE = null;
					if (m[9] != null) {
						ADATE = DateFormatter.returnStringDate(m[9]);
					}
					
					Object status = null;
					if (m[7].equals("1")) {
						status="Approved";
					}else {
						status="Pending";
					}
					RestPatternMasterModel mdata = new RestPatternMasterModel(m[0], m[1], m[2], DATE, m[4], m[5], m[6],status,m[8],ADATE,m[10]);
					respList.add(mdata);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JsonResponse<List<RestPatternMasterModel>> resp = new JsonResponse<List<RestPatternMasterModel>>();
			resp.setBody(respList);
			ResponseEntity<JsonResponse<List<RestPatternMasterModel>>> response = new ResponseEntity<JsonResponse<List<RestPatternMasterModel>>>(
					resp, HttpStatus.CREATED);
			logger.info("Method : viewPatternDetails ends");
			return response;
		}

	//editPatternDetails
		@SuppressWarnings("unchecked")
		public JsonResponse<RestPatternMasterModel> editPatternDetails(String id, String org, String orgDiv) {
			logger.info("Method : editPatternDetails Dao starts");

			logger.info("======>>>>" + id);
			RestPatternMasterModel mdata = new RestPatternMasterModel();
			List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
			JsonResponse<RestPatternMasterModel> resp = new JsonResponse<RestPatternMasterModel>();

			String value = "SET @p_patternId='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";

			logger.info("ssssssssssssssss" + value);
			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("nerp_production_patternRoutines")
						.setParameter("actionType", "editPatternDetails").setParameter("actionValue", value).getResultList();
				for (Object[] m : x) {
					Object DATE = null;
					if (m[3] != null) {
						DATE = DateFormatter.returnStringDate(m[3]);
					}
				    mdata = new RestPatternMasterModel(m[0], m[1], m[2], DATE, m[4], m[5], m[6], m[7],null,null,m[8]);
				}
				try {
					List<Object[]> y = em.createNamedStoredProcedureQuery("nerp_production_patternRoutines")
							.setParameter("actionType", "editchilddocuments").setParameter("actionValue", value)
							.getResultList();
					for (Object[] m : y) {
						InventoryVendorDocumentModel items = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
						docList.add(items);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				mdata.setDocumentList(docList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.setBody(mdata);
 
			logger.info("=====>>>resp" + resp);
			logger.info("Method : editPatternDetails Dao ends");
			return resp;
		}
		// deletePatternDetails

		public JsonResponse<Object> deletePatternDetails(String patid, String org, String orgDiv) {
			logger.info("Method : deletePatternDetails starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_patid='" + patid + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("value===" + value);
				em.createNamedStoredProcedureQuery("nerp_production_patternRoutines").setParameter("actionType", "deletePatternDetails")
						.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Delete successfully");
			} catch (Exception e) {
				try {
					serverDao.errorProcedureCall(e);
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				} catch (Exception e1) {
					resp.setCode("failed");
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				logger.error("deletePatternDetails: " + e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : deletePatternDetails ends");
			return resp;
		}
		// approvePatternDetails
		public JsonResponse<Object> approvePatternDetails(String patid, String org, String orgDiv,String userId) {
			logger.info("Method : approvePatternDetails starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_patid='" + patid + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_approvedBy='" + userId + "';";
				logger.info("value===" + value);
				em.createNamedStoredProcedureQuery("nerp_production_patternRoutines").setParameter("actionType", "approvePatternDetails")
				.setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data Delete successfully");
			} catch (Exception e) {
				try {
					serverDao.errorProcedureCall(e);
					resp.setCode("failed");
					resp.setMessage("Something went wrong");
				} catch (Exception e1) {
					resp.setCode("failed");
					e1.printStackTrace();
					resp.setMessage("Something went wrong");
				}
				logger.error("approvePatternDetails: " + e.getMessage());
				e.printStackTrace();
			}
			
			logger.info("Method : approvePatternDetails ends");
			return resp;
		}
}
