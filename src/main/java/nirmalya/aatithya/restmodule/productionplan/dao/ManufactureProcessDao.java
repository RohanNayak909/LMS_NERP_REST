package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateManufactureProcessParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.RestManufactureProcessModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class ManufactureProcessDao {

	Logger logger = LoggerFactory.getLogger(ManufactureProcessDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> procrssingPlan(String orgName, String orgDivision, String shift, String date) {
		logger.info("Method : procrssingPlan Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String Date = DateFormatter.getStringDate(date);
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_shift='" + shift + "',@p_date='" + Date + "';";
			System.out.println("value>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "procrssingPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : procrssingPlan Dao ends");
		
		return resp;

	}

	// add

	public ResponseEntity<JsonResponse<List<RestManufactureProcessModel>>> addProcessingPlan(
			List<RestManufactureProcessModel> addProcessingPlan) {
		logger.info("Method : addPlan dao starts");
		
		JsonResponse<List<RestManufactureProcessModel>> resp = new JsonResponse<List<RestManufactureProcessModel>>();

		String value = GenerateManufactureProcessParameter.getAddProcessingPlan(addProcessingPlan);
		
		
		try {
			if (addProcessingPlan.get(0).getProcessing_id() != null
					&& addProcessingPlan.get(0).getProcessing_id() != "") {
				em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
						.setParameter("actionType", "modifyProcessingPlan").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");
			} else {
				em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
						.setParameter("actionType", "addProcessingPlan").setParameter("actionValue", value).execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");
			}
		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				String rcode=err[0];
				
				if(rcode.equals("1062")) {
					resp.setCode("failed");
					resp.setMessage("SHIFT IS ALREADY ASSIGNED!");
				}else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong ");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestManufactureProcessModel>>> response = new ResponseEntity<JsonResponse<List<RestManufactureProcessModel>>>(
				resp, HttpStatus.CREATED);
		
		logger.info("Method : addProcessingPlan dao ends");
		return response;

	}

	// View Processing Data

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewMfgProcessingData(String orgName, String orgDivision) {
		logger.info("Method : viewMfgProcessingData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "viewMfgProcessingData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewMfgProcessingData Dao ends");
		
		return resp;

	}

	// Approve

	public ResponseEntity<JsonResponse<Object>> processingDataApprove(String id, String userId, String orgName,
			String orgDivision) {
		logger.info("Method : processingDataApprove dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_processId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";
			
			em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "processingDataApprove").setParameter("actionValue", value).execute();
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
		logger.info("Method : processingDataApprove dao ends");
		return response;
	}

	// Delete.

	public ResponseEntity<JsonResponse<Object>> processingDataDelete(String id, String orgName, String orgDivision) {
		logger.info("Method : processingDataDelete dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_processId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "processingDataDelete").setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
			resp.setMessage("Data Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : processingDataDelete dao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> procrssingPlanEdit(String id, String orgName, String orgDivision) {
		logger.info("Method : procrssingPlanEdit Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_processId='" + id + "';";
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "procrssingPlanEdit").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : procrssingPlanEdit Dao ends");
		
		return resp;

	}
	
	// Shift List
	
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<List<DropDownModel>>
	 * getShiftListForProduction(String org, String orgDiv, String userId) {
	 * logger.info("Method : getShiftListForProduction starts");
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); List<DropDownModel> getCollectionList =
	 * new ArrayList<DropDownModel>(); String value = "SET @p_org='" + org +
	 * "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';"; try {
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
	 * .setParameter("actionType",
	 * "getShiftListForProduction").setParameter("actionValue", value)
	 * .getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); getCollectionList.add(dropDownModel); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * resp.setBody(getCollectionList); System.out.println("resp>>>"+resp);
	 * logger.info("Method : getShiftListForProduction ends"); return resp; }
	 */
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getShiftListForProduction(String org,String orgDiv,String userId) {
		logger.info("Method : getShiftListForProduction starts");

		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "getShiftListForProduction").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getShiftListForProduction ends");
		return getCollectionList;
	}
	
	

	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getShiftListForProductionApi(String org, String orgDiv,String userId) {
		logger.info("Method : getShiftListForProductionApi starts");
		
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId +"';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_mfg_process_routines")
					.setParameter("actionType", "getShiftListForProduction").setParameter("actionValue",value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getCollectionList.add(dropDownModel);
			
			}
			if (getCollectionList.size() > 0) {
				Util.setJsonResponse(resp, getCollectionList, ResponseStatus.success, ApiResponseMessage.DATA_FETCH_SUCCESS);
			} else {
				Util.setJsonResponse(resp, getCollectionList, ResponseStatus.success, ApiResponseMessage.NO_DATA_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getShiftListForProductionApi ends");
		return response;
	}

}
