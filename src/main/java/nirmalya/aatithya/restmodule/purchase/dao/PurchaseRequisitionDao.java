package nirmalya.aatithya.restmodule.purchase.dao;

import java.util.ArrayList;
import java.util.Arrays;
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
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseIndentParam;
import nirmalya.aatithya.restmodule.common.utils.purchase.GeneratePurchaseQuotationDetails;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRequisitionParam;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseIndentModel;

@Repository
public class PurchaseRequisitionDao {
	Logger logger = LoggerFactory.getLogger(PurchaseRequisitionDao.class);
	@Autowired
	ServerDao serverDao;
	@Autowired
	private EntityManager em;

	/**
	 * DAO Function to view particular getRequisitionType in dropDown for
	 * ItemRequisition
	 *
	 */
	/*
	 * add
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> addRequisitionDetails(
			List<RestPurchaseIndentModel> RestPurchaseIndentModel) {

		logger.info("Method : addRequisitionDetails starts");

		JsonResponse<List<RestPurchaseIndentModel>> resp = new JsonResponse<List<RestPurchaseIndentModel>>();
		List<RestPurchaseIndentModel> listData = new ArrayList<RestPurchaseIndentModel>();

		try {
			String values = GenerateRequisitionParam.getItemRequisitionParam(RestPurchaseIndentModel);

			if (RestPurchaseIndentModel.get(0).getReqId() == null || RestPurchaseIndentModel.get(0).getReqId() == "") {
				logger.info("ADS#" + values);

				em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "addRequisitionDetails").setParameter("actionValue", values)
						.execute();
				resp.setCode("Requisition Saved Successfully");

			} else {

				// logger.info("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "modifyRequisitionDetails").setParameter("actionValue", values)
						.execute();
				
				resp.setCode("Requisition Modified Successfully");
				logger.info("modify print" + listData);

			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addRequisitionDetails ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> viewRequisitionDetails(String orgName,
			String orgDiv) {
		logger.info("Method : viewPurchaseOrder Dao starts");
		List<RestPurchaseIndentModel> getAllemployee = new ArrayList<RestPurchaseIndentModel>();
		JsonResponse<List<RestPurchaseIndentModel>> resp = new JsonResponse<List<RestPurchaseIndentModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "viewRequisitionDetails").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Object createdOn = null;
				if (m[7] != null) {
					createdOn = m[7].toString();
				}

				RestPurchaseIndentModel viewdemo = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3].toString(), m[4],
						m[5], m[6], createdOn, m[8]);
				getAllemployee.add(viewdemo);

			}
			resp.setBody(getAllemployee);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseIndentModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewRequisitionDetails Dao ends");

		return response;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestPurchaseIndentModel> viewPurchaseRequisitionEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : viewPurchaseRequisitionEdit starts");
		// logger.info("RestDeliveryChallanModel" + id);
		List<RestPurchaseIndentModel> getRequisitionTypeList = new ArrayList<RestPurchaseIndentModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_reqId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "viewPurchaseRequisitionEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					RestPurchaseIndentModel dropDownModel = new RestPurchaseIndentModel(m[0], m[1], m[2],
							m[3].toString(), m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14],
							m[15]);
					getRequisitionTypeList.add(dropDownModel);

					// logger.info("print edit" + getRequisitionTypeList);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_reqId='" + getRequisitionTypeList.get(0).getReqId() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "getRequisitionDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewPurchaseRequisitionEdit ends");
		return getRequisitionTypeList;
	}

	// delete

	public ResponseEntity<JsonResponse<Object>> deleteRequisitionDetails(String id) {
		logger.info("Method : deleteRequisitionDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {
				String value = "SET @p_reqId='" + id + "';";
				logger.info("IDD" + value);
				em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "deleteRequisitionDetails").setParameter("actionValue", value)
						.execute();

			} catch (Exception e) {
				try {
					String[] err = serverDao.errorProcedureCall(e);
					resp.setCode(err[0]);
					resp.setMessage(err[1]);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteRequisitionDetails ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveRequisitionDetails(String approveStatus, String reqId, String orgName,
			String orgDivision) {
		logger.info("Method : approveRequisitionDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_reqId='" + reqId + "',@p_org='" + orgName
					+ "',@p_orgDiv='" + orgDivision + "';";

			em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "approveRequisition").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : approveRequisitionDetails ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> ProjectList(String org, String orgDiv) {
		logger.info("Method : ProjectList starts");

		List<DropDownModel> brandList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "ProjectList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				brandList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : ProjectList ends");
		return brandList;
	}
	

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewRequisitionDetailsForPurchase(String orgName,
			String orgDiv) {
		logger.info("Method : viewRequisitionDetailsForPurchase Dao starts");
		//List<RestPurchaseIndentModel> getAllemployee = new ArrayList<RestPurchaseIndentModel>();
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("restViewVendorDtls -----------" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "viewRequisitionDetailsForPurchase").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("resp>>view>>>---"+resp);
		logger.info("Method : viewRequisitionDetailsForPurchase Dao ends");
		return resp;
	}
	
	public ResponseEntity<JsonResponse<Object>> addRequisitionMasterFile(List<RestPurchaseIndentModel> modelData) {
		logger.info("Method : addRequisitionMasterFile dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("======>>>>" + modelData);
		try {
			String values = GenerateRequisitionParam.getAddUloadedRequisitionDataParam(modelData);
			System.out.println("values===" + values);
			if (values != null || values != "") {
				em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
						.setParameter("actionType", "addUploadRequisition").setParameter("actionValue", values)
						.execute();

			}
		} catch

		(Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				logger.error("addUloadedModelData: " + e.getMessage());
				e1.printStackTrace();
			}

		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addRequisitionMasterFile Dao ends");
		return response;
	}
	

	@SuppressWarnings("unchecked")
	public List<RestPurchaseIndentModel> getRequisitionData(String sku, String id, String orgName, String orgDiv) {
		logger.info("Method : getRequisitionData starts");
		List<RestPurchaseIndentModel> getRequisitionTypeList = new ArrayList<RestPurchaseIndentModel>();
		String y = id.trim();
		//String z = sku.trim();
		try {

			String values = "SET @p_sku='(" + sku + ")',@p_rfqId='(" + y + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getRequisitionData").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					System.out.println("DATA"+Arrays.toString(m));
					/*
					 * double qty = 0; if (m[5] != null) { qty =
					 * Double.parseDouble(m[5].toString()); }
					 */
					//double qty=	Double.toString(m[5])
					RestPurchaseIndentModel dropDownModel = new RestPurchaseIndentModel(m[0], m[1], m[2], m[3], m[4],
							null,m[5],m[6], m[7],m[8],null,null,null);
					getRequisitionTypeList.add(dropDownModel);
					logger.info("print edit" + getRequisitionTypeList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("@@@@@@@@edit" + getRequisitionTypeList);
		logger.info("Method : getRequisitionData ends");
		return getRequisitionTypeList;
	}	
	
	// Material Issue
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JsonResponse getMaterialIssueData(String sku, String reqId, String orgName,
			String orgDiv) {
		logger.info("Method : getMaterialIssueData starts");
		JsonResponse resp = new JsonResponse();
		

		try {
			

			String values = "SET @p_sku='(" + sku + ")',@p_org='" + orgName + "',@p_orgDiv='"
					+ orgDiv + "',@p_reqId='" + reqId  + "';";
			System.out.println("values>>>>----" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getMaterialIssueData").setParameter("actionValue", values)
					.getResultList();
			
			resp.setBody(x.get(0));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		logger.info("Method : getMaterialIssueData ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getStoreItemQuotationAutoSearchListForItem(String id,String type,
			String org, String orgDiv) {
		logger.info("Method : getStoreItemQuotationAutoSearchListForItem starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "', @p_type='" + type + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("inventoryRequisitionRoutines")
					.setParameter("actionType", "getStoreItemQuotationAutoSearchListForItem").setParameter("actionValue", value)
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
		logger.info("Method : getStoreItemQuotationAutoSearchListForItem ends");
		return response;
	}

}
