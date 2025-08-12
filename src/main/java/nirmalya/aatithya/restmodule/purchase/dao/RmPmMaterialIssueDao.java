package nirmalya.aatithya.restmodule.purchase.dao;

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
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.productionplan.GenerateParamRmPmRequisition;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRmPmMaterialIssueParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.productionplan.dao.RmPmRequisitionDao;
import nirmalya.aatithya.restmodule.purchase.model.RestRmPmMaterialIssueModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RmPmMaterialIssueDao {
	Logger logger = LoggerFactory.getLogger(RmPmMaterialIssueDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;
	
	// add.

			public ResponseEntity<JsonResponse<RestRmPmMaterialIssueModel>> addRmPmMaterialIssue(
					RestRmPmMaterialIssueModel qc) {
				logger.info("Method : addRmPmMaterialIssue dao starts");
				System.out.println(qc);
				JsonResponse<RestRmPmMaterialIssueModel> resp = new JsonResponse<RestRmPmMaterialIssueModel>();

				

				try {
					String value = GenerateRmPmMaterialIssueParam.getRmPmMaterialIssue(qc);
					System.out.println("value===" + value);
					System.out.println("Modify qc===" + qc.getReqId());
					if (qc.getSlipId() != null && qc.getSlipId() != "") {

						em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
						.setParameter("actionType", "modifyRmPmMaterialIssue").setParameter("actionValue", value).execute();

						resp.setCode("success");
						resp.setMessage("Data Modified successfully"); 

					} else {
						em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
						.setParameter("actionType", "addRmPmMaterialIssue").setParameter("actionValue", value).execute();

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

				ResponseEntity<JsonResponse<RestRmPmMaterialIssueModel>> response = new ResponseEntity<JsonResponse<RestRmPmMaterialIssueModel>>(
						resp, HttpStatus.CREATED);
				System.out.println("response===" + response);
				logger.info("Method : addRmPmMaterialIssue dao ends");
				return response;

			}
			
			

			// view

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewRmPmMaterialIssue(String org, String orgDiv) {
				logger.info("Method : viewRmPmMaterialIssue Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET  @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
					logger.info("valuesss------------" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
							.setParameter("actionType", "viewRmPmMaterialIssue").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewRmPmMaterialIssue Dao ends" + resp);
				System.out.println("resp>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resp);
				return resp;
			}
			
			
			// Edit

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> editRmPmMaterialIssue(String id, String orgName, String orgDivision) {
				logger.info("Method : editRmPmMaterialIssue Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values***" + value);
					List<Object[]> x =em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
							.setParameter("actionType", "editRmPmMaterialIssue").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fatched successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage("Data Fetch Failed");
				}
				logger.info("Method : editRmPmMaterialIssue Dao ends");
				System.out.println("resp*" + resp);
				return resp;
			}
			

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> deleterRmPmmMaterialIssue(String id, String orgName, String orgDivision) {
				logger.info("Method : deleterRmPmmMaterialIssue Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values***" + value);
					em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
					.setParameter("actionType", "deleterRmPmmMaterialIssue").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Deleted successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage("Data Fetch Failed");
				}
				logger.info("Method : deleterRmPmmMaterialIssue Dao ends");
				System.out.println("resp*" + resp);
				return resp;
			}

			@SuppressWarnings("unchecked")
			public JsonResponse<Object> approveRmPmMaterialIssue(String id, String orgName, String orgDivision, String approvedBy) {
				logger.info("Method : approveRmPmMaterialIssue Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
							+ "',@p_approvedBy='" + approvedBy + "';";
					System.out.println("values***" + value);
					em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
					.setParameter("actionType", "approveRmPmMaterialIssue").setParameter("actionValue", value).execute();

					resp.setCode("success");
					resp.setMessage("Data Approved successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage("Data Fetch Failed");
				}
				logger.info("Method : approveRmPmMaterialIssue Dao ends");
				System.out.println("resp*" + resp);
				return resp;
			}
			
			@SuppressWarnings("unchecked")
			public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getRFQList(String id,String type,
					String org, String orgDiv) {
				logger.info("Method : getRFQList starts");
				List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
				JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
				String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
				System.err.println("value===="+value);
				try {
					List<String> x = em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
							.setParameter("actionType", "getRFQList").setParameter("actionValue", value)
							.getResultList();
					for (String m : x) {
						InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m);
						itemNameList.add(dropDownModel);
					}
					resp.setBody(itemNameList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
						resp, HttpStatus.CREATED);
				logger.info("Method : getRFQList ends");
				return response;
			}
			
			
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> getItemDetails(String id, String orgName, String orgDivision) {
				logger.info("Method : getItemDetails Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values***" + value);
					List<Object[]> x =em.createNamedStoredProcedureQuery("inventory_rmpmRMaterialIssue_routines")
							.setParameter("actionType", "getItemDetails").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fatched successfully");
				} catch (Exception e) {
					e.printStackTrace();
					resp.setCode("failed");
					resp.setMessage("Data Fetch Failed");
				}
				logger.info("Method : getItemDetails Dao ends");
				System.out.println("resp*" + resp);
				return resp;
			}
			

}
