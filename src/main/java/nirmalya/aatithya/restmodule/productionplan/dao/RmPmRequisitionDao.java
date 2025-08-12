package nirmalya.aatithya.restmodule.productionplan.dao;

import java.util.ArrayList;
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
import nirmalya.aatithya.restmodule.common.ProcedureNameConstants;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateParamRmPmRequisition;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateLaminateParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.productionplan.model.RmPmRequisitionRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RmPmRequisitionDao {
	
	Logger logger = LoggerFactory.getLogger(RmPmRequisitionDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getRmPmListForRequisition(String id,String type,
			String org, String orgDiv) {
		logger.info("Method : getRmPmListForRequisition starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.err.println("value===="+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
					.setParameter("actionType", "getRmPmListForRequisition").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], gst, m[10], null, null,null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getRmPmListForRequisition ends");
		return response;
	}
	
	

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRmPmRequisition(String org, String orgDiv) {
		logger.info("Method : viewRmPmRequisition Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
					.setParameter("actionType", "viewRmPmRequisition").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRmPmRequisition Dao ends" + resp);
		System.out.println("resp>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resp);
		return resp;
	}
	
	// add.

		public ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> addRmPmRequisition(
				RmPmRequisitionRestModel qc) {
			logger.info("Method : addRmPmRequisition dao starts");
			JsonResponse<RmPmRequisitionRestModel> resp = new JsonResponse<RmPmRequisitionRestModel>();
			try {
				String value = GenerateParamRmPmRequisition.getRmPmRequisition(qc);
				if (qc.getReqId() != null && qc.getReqId() != "") {
					em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
					.setParameter("actionType", "modifyRmPmRequisition").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Requisition Modified Successfully."); 

				} else {
					em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
					.setParameter("actionType", "addRmPmRequisition").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Requisition Saved Successfully.");

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

			ResponseEntity<JsonResponse<RmPmRequisitionRestModel>> response = new ResponseEntity<JsonResponse<RmPmRequisitionRestModel>>(
					resp, HttpStatus.CREATED);
			System.out.println("response===" + response);
			logger.info("Method : addRmPmRequisition dao ends");
			return response;

		}
		
		
		// Edit

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editRmPmRequisition(String id, String orgName, String orgDivision) {
			logger.info("Method : editRmPmRequisition Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values***" + value);
				List<Object[]> x =em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
						.setParameter("actionType", "editRmPmRequisition").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fatched successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Data Fetch Failed");
			}
			logger.info("Method : editRmPmRequisition Dao ends");
			System.out.println("resp*" + resp);
			return resp;
		}
		

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> deleteRmPmRequisition(String id, String orgName, String orgDivision) {
			logger.info("Method : deleteRmPmRequisition Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("values***" + value);
				em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
				.setParameter("actionType", "deleteRmPmRequisition").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Deleted successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Data Fetch Failed");
			}
			logger.info("Method : deleteRmPmRequisition Dao ends");
			System.out.println("resp*" + resp);
			return resp;
		}

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> approveRmPmRequsition(String id, String orgName, String orgDivision, String approvedBy) {
			logger.info("Method : approveRmPmRequsition Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
						+ "',@p_approvedBy='" + approvedBy + "';";
				System.out.println("values***" + value);
				em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
				.setParameter("actionType", "approveRmPmRequsition").setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Approved successfully");
			} catch (Exception e) {
				e.printStackTrace();
				resp.setCode("failed");
				resp.setMessage("Data Fetch Failed");
			}
			logger.info("Method : approveRmPmRequsition Dao ends");
			System.out.println("resp*" + resp);
			return resp;
		}
		
		
		// view RmPm View Requisition For Inventory.

		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewRmPmRequisitionInInventory(String org, String orgDiv) {
			logger.info("Method : viewRmPmRequisitionInInventory Dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			try {
				String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("valuesss------------" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
						.setParameter("actionType", "viewRmPmRequisitionInInventory").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewRmPmRequisitionInInventory Dao ends");
			return resp;
		}
		
		
		// Get Material Issue Data

				@SuppressWarnings("unchecked")
				public JsonResponse<Object> getDataForIssue(String id, String orgName, String orgDivision, String skuId) {
					logger.info("Method : getDataForIssue Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_skuId='(" + skuId + ")';";
						System.out.println("values***" + value);
						List<Object[]> x =em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
								.setParameter("actionType", "getDataForIssue").setParameter("actionValue", value).getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data Fatched successfully");
					} catch (Exception e) {
						e.printStackTrace();
						resp.setCode("failed");
						resp.setMessage("Data Fetch Failed");
					}
					logger.info("Method : getDataForIssue Dao ends");
					System.out.println("resp*" + resp);
					return resp;
				}

				

				//Edit RMPM View.

				@SuppressWarnings("unchecked")
				public JsonResponse<Object> editRmPmRequisitionForInventory(String id, String orgName, String orgDivision) {
					logger.info("Method : editRmPmRequisitionForInventory Dao starts");
					JsonResponse<Object> resp = new JsonResponse<Object>();
					try {
						String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
						System.out.println("values***" + value);
						List<Object[]> x =em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
								.setParameter("actionType", "editRmPmRequisitionForInventory").setParameter("actionValue", value).getResultList();
						resp.setBody(x.get(0));
						resp.setCode("success");
						resp.setMessage("Data Fatched successfully");
					} catch (Exception e) {
						e.printStackTrace();
						resp.setCode("failed");
						resp.setMessage("Data Fetch Failed");
					}
					logger.info("Method : editRmPmRequisitionForInventory Dao ends");
					System.out.println("resp*" + resp);
					return resp;
				}



				// production Plan List
				@SuppressWarnings("unchecked")
				public List<DropDownModel> productionPlanningList(String org, String orgDiv) {
					logger.info("Method : productionPlanningList starts");

					List<DropDownModel> brandList = new ArrayList<DropDownModel>();
					String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					logger.info("value===" + value);
					try {
						List<Object[]> x = em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
								.setParameter("actionType", "productionPlanningList").setParameter("actionValue", value).getResultList();

						for (Object[] m : x) {
							DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
							brandList.add(dropDownModel);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					logger.info("Method : productionPlanningList ends");
					return brandList;
				}



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRawMaterialList(String planId, String org, String orgDiv) {
		logger.info("Method : viewRmPmRequisitionInInventory Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET  @p_planId='" + planId + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("valuesss------------" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("production_planning_rmpmRequisition_routines")
				.setParameter("actionType", "getRawMaterialList").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewRmPmRequisitionInInventory Dao ends" + resp);
		System.out.println("resp>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resp);
		return resp;
	}
}
