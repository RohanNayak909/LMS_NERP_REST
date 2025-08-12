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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GeneratePlanDetailsParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.productionplan.model.UploadedPlanRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class UploadedPlanDao {
	Logger logger = LoggerFactory.getLogger(UploadedPlanDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	//getitemLists
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getitemLists(String org, String orgDiv) {
		logger.info("Method : getitemLists Dao starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "getitemlists").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemList.add(dropDownModel);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getitemLists Dao ends");
		return itemList;
	}
	//getProductType
		@SuppressWarnings("unchecked")
		public List<DropDownModel> getProductType(String org, String orgDiv) {
			logger.info("Method : getProductType Dao starts");

			List<DropDownModel> itemList = new ArrayList<DropDownModel>();

			try {
				String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
						.setParameter("actionType", "getProductType").setParameter("actionValue", value).getResultList();

				for (Object[] m : x) {
					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
					itemList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : getProductType Dao ends");
			return itemList;
		}
//getweeklist
	@SuppressWarnings("unchecked")
	public List<DropDownModel> getweeklist(String org, String orgDiv) {
		logger.info("Method : getweeklist Dao starts");
		List<DropDownModel> weeklist = new ArrayList<DropDownModel>();

		try {
			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "getweeklist").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1],m[2]);
				weeklist.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getweeklist Dao ends");
		return weeklist;
	}
 
	//addPlan
	
	public ResponseEntity<JsonResponse<List<UploadedPlanRestModel>>> addPlan(
			List<UploadedPlanRestModel> plan) {
		logger.info("Method : addPlan dao starts");
		System.out.println(plan);
		JsonResponse<List<UploadedPlanRestModel>> resp = new JsonResponse<List<UploadedPlanRestModel>>();

		String value = GeneratePlanDetailsParam.getAddPlan(plan);
		try {
			if (plan.get(0).getPlanId() != null && plan.get(0).getPlanId() != "") {
				
				System.out.println("modifyyy    value===" + value);
				
				em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
						.setParameter("actionType", "modifyPlan").setParameter("actionValue", value)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Modified successfully");
			} else {
				
				System.out.println("addd  value===" + value);
				
				em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
						.setParameter("actionType", "addPlan").setParameter("actionValue", value).execute();
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

		ResponseEntity<JsonResponse<List<UploadedPlanRestModel>>> response = new ResponseEntity<JsonResponse<List<UploadedPlanRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addPlan dao ends");
		return response;

	}
//viewPlan
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPlan(String orgName, String orgDivision) {
		logger.info("Method : viewPlan Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "viewPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewPlan Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
//editPlan
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editPlan(String id,String orgName, String orgDivision) {
		logger.info("Method : editPlan Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @P_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "editPlan").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editPlan Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
//deletePlan
	public ResponseEntity<JsonResponse<Object>> deletePlan(String id,String orgName, String orgDivision) {
		logger.info("Method : deletePlan dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			String value = "SET @p_planId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("value=="+value);
			em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines").setParameter("actionType", "deletePlan")
					.setParameter("actionValue", value).execute();
			Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
		} catch (Exception e) {
			e.printStackTrace();
			Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : deletePlan dao ends");
		return response;
	}
	
	//Approve Plan
	

	public JsonResponse<UploadedPlanRestModel> approvePlan(String approveStatus, String planId,String orgName, String orgDiv) {
		logger.info("Method : approvePlan starts");

		UploadedPlanRestModel req = new UploadedPlanRestModel();
		JsonResponse<UploadedPlanRestModel> resp = new JsonResponse<UploadedPlanRestModel>();
		try {
			
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_planId='" + planId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value==="+value);
			em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines").setParameter("actionType", "approvePlan")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Approved successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
		}
		System.out.println("resp==="+resp);
		logger.info("Method : approvePlan ends");
		return resp;
	}
	//Get BoomList
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllBoomList(String itemId,String orgName, String orgDivision) {
		logger.info("Method : getAllBoomList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_itemId='" + itemId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "getAllBoomList").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getAllBoomList Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	//Add boom Data
	
	public ResponseEntity<JsonResponse<UploadedPlanRestModel>> addBomData(
			UploadedPlanRestModel uploadedPlanRestModel) {
		logger.info("Method : addBomData starts");
		JsonResponse<UploadedPlanRestModel> resp = new JsonResponse<UploadedPlanRestModel>();
		UploadedPlanRestModel listData = new UploadedPlanRestModel();

		System.out.println("=====>>>>>" + uploadedPlanRestModel);

		try {
			String values = GeneratePlanDetailsParam.saveAllBomData(uploadedPlanRestModel);

			System.out.println("values=====>>>>>" + values);
			
			 em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
						.setParameter("actionType", "addBomData").setParameter("actionValue", values)
						.execute();
				resp.setCode("success");
				resp.setMessage("Data Saved Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<UploadedPlanRestModel>> response = new ResponseEntity<JsonResponse<UploadedPlanRestModel>>(
				resp, HttpStatus.CREATED);
		System.out.println("response data is" + response);
		logger.info("Method : addBomData ends");
		return response;
	}
	
	//Edit bom data
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editBomData(String planId,String itemId,String orgName, String orgDiv) {
		logger.info("Method : editBomData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_planId='" + planId + "',@p_itemId='" + itemId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "editBomData").setParameter("actionValue", value)
					.getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editBomData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;
	}
	
	//getitemLists Api
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getitemListsApi(String org, String orgDiv) {
		logger.info("Method : getitemListsApi starts");
		
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		List<DropDownModel> getCollectionList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_plan_Uploaded_routines")
					.setParameter("actionType", "getitemlists").setParameter("actionValue", value).getResultList();

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
		logger.info("Method : getitemListsApi ends");
		return response;
	}
	
}
