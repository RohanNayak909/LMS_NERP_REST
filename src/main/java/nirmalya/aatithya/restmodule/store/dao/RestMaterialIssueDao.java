package nirmalya.aatithya.restmodule.store.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.store.GenerateMaterialIssueDetailsParam;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.ProductCategoryDao;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseQuotationModel;
import nirmalya.aatithya.restmodule.store.model.MaterialIssueDetailsRestModel;
import nirmalya.aatithya.restmodule.store.model.StoreMaterialDetailsRestModel;
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
public class RestMaterialIssueDao {

	Logger logger = LoggerFactory.getLogger(RestMaterialIssueDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getIndentNameAutoSearch(String id) {
		logger.info("Method : getIndentNameAutoSearch dao starts");
		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "getIndent").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getIndentNameAutoSearch dao ends");
		logger.info("AUTODATAAA" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> getItemDetailsDao(String id,String projectId) {
		logger.info("Method : getItemDetailsDao starts");
		List<MaterialIssueDetailsRestModel> respList = new ArrayList<MaterialIssueDetailsRestModel>();
		try {
			String value = "SET @p_req='" + id + "',@p_projectId='"+projectId+"';";
			logger.info("valuesssss" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "getItemsDetail").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				MaterialIssueDetailsRestModel cusData = new MaterialIssueDetailsRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8].toString(), m[9], m[10], m[11], m[12]);
				respList.add(cusData);
			}
			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<MaterialIssueDetailsRestModel>> resp = new JsonResponse<List<MaterialIssueDetailsRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : getItemDetailsDao ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("VIEWWWWWWWW" + respList);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> childEdit(String id) {
		logger.info("Method : estimateBudgetViewDao starts");
		List<MaterialIssueDetailsRestModel> respList = new ArrayList<MaterialIssueDetailsRestModel>();
		try {
			String value = "SET @p_req='" + id + "';";
			logger.info(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "getItemsDetailEdit").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				MaterialIssueDetailsRestModel cusData = new MaterialIssueDetailsRestModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12]);
				respList.add(cusData);
			}
			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<MaterialIssueDetailsRestModel>> resp = new JsonResponse<List<MaterialIssueDetailsRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> response = new ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : estimateBudgetViewDao ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	/*
	 * @SuppressWarnings("unchecked") public ResponseEntity<JsonResponse<Object>>
	 * addIssue(MaterialIssueDetailsRestModel budget) {
	 * logger.info("Method in Dao: estimateBudgetAddDao starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * try { // String values =""; String values =
	 * GenerateMaterialIssueDetailsParam.getAddIssuetParam(budget);
	 * logger.info("Data in Daooooo===================>>>>>>>>>" + values);
	 * if (budget.getIssueSlip() == "" || budget.getIssueSlip() == null) {
	 * 
	 * em.createNamedStoredProcedureQuery("store_material_issue_routines")
	 * .setParameter("actionType", "addIssue").setParameter("actionValue",
	 * values).execute(); } } catch (Exception e) { e.printStackTrace(); try {
	 * String[] err = serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED); if
	 * (resp.getMessage() == null) { resp.setMessage("Saved successfully"); }
	 * 
	 * if (resp.getCode() == null) { resp.setCode("Success"); }
	 * 
	 * logger.info("Method in Dao: estimateBudgetAddDao ends");
	 * 
	 * return response; }
	 * 
	 */

	public ResponseEntity<JsonResponse<Object>> addIssue(List<MaterialIssueDetailsRestModel> productDetails) {

		logger.info("Method in Dao: addIssue starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateMaterialIssueDetailsParam.getAddIssuetParam(productDetails);
			logger.info("product details====-->>>" + values);
			logger.info("product id=----------" + productDetails.get(0).getIssueSlip());
			if (productDetails.get(0).getIssueSlip() != "" && productDetails.get(0).getIssueSlip() != null) {

				logger.info("MODIFY==================" + productDetails.get(0).getIssueSlip());
				em.createNamedStoredProcedureQuery("store_material_issue_routines")
						.setParameter("actionType", "modifyIssue").setParameter("actionValue", values).execute();
				
				resp.setCode("Material Issue Details Updated Successfully");

			} else {

				logger.info("ADD=================" + productDetails.get(0).getIssueSlip());
				em.createNamedStoredProcedureQuery("store_material_issue_routines")
						.setParameter("actionType", "addIssue").setParameter("actionValue", values).execute();
				
				resp.setCode("Material Issue Details Added Successfully");

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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addIssue ends");

		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewIssue(String orgName,String orgDiv) {
		logger.info("Method : estimateBudgetViewDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "ViewIssue").setParameter("actionValue", values).getResultList();
			
			resp.setBody(x.get(0));
		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("resp>>view>>>---"+resp);
		logger.info("Method : viewRequisitionDetailsForPurchase Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> issueEdit(String id) {
		logger.info("Method : issueEdit starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String value = "SET @p_issue='" + id + "';";

			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "EditIssue").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setMessage("Data Fetched Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Edit=====>>>>" + resp);
		logger.info("Method : issueEdit ends");
		return resp;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>>
	 * issueEdit(String id) { logger.info("Method : estimateBudgetEditDao starts");
	 * 
	 * JsonResponse<List<MaterialIssueDetailsRestModel>> resp = new
	 * JsonResponse<List<MaterialIssueDetailsRestModel>>();
	 * List<MaterialIssueDetailsRestModel> respList = new
	 * ArrayList<MaterialIssueDetailsRestModel>();
	 * 
	 * try {
	 * 
	 * String value = "SET @p_issue='" + id + "';"; logger.info(value);
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("store_material_issue_routines")
	 * .setParameter("actionType", "EditIssue").setParameter("actionValue",
	 * value).getResultList(); // for (Object[] m : x) { //
	 * logger.info("VIEW!@#$%%$#@@#$%^%$@#$%$"); //
	 * MaterialIssueDetailsRestModel cusData = new
	 * MaterialIssueDetailsRestModel(m[0], m[1], m[2], m[3],m[4]); //
	 * rs.add(cusData); // } logger.info("V ::::::::::::" + x); for (Object[]
	 * m : x) { MaterialIssueDetailsRestModel cusData = new
	 * MaterialIssueDetailsRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
	 * m[7]); respList.add(cusData); }
	 * 
	 * logger.info("VIEW" + respList);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } resp.setBody(respList);
	 * HttpHeaders responseHeaders = new HttpHeaders();
	 * responseHeaders.set("MyResponseHeader", "MyValue");
	 * 
	 * ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>> response =
	 * new ResponseEntity<JsonResponse<List<MaterialIssueDetailsRestModel>>>( resp,
	 * responseHeaders, HttpStatus.CREATED);
	 * 
	 * logger.info("Method : estimateBudgetEditDao ends");
	 * 
	 * if (resp.getMessage() == null) { resp.setMessage("View successfully"); }
	 * 
	 * if (resp.getCode() == null) { resp.setCode("Success"); }
	 * 
	 * logger.info(response); return response; }
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> getVendorAutoSearch(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getVendorAutoSearch starts");

		List<RestPurchaseOrderModel> itemNameList = new ArrayList<RestPurchaseOrderModel>();
		JsonResponse<List<RestPurchaseOrderModel>> resp = new JsonResponse<List<RestPurchaseOrderModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("poRoutines")
					.setParameter("actionType", "getVendorListPo").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				logger.info(Arrays.toString(m));
				Boolean boolean1 = false;
				if (m[3].toString() != null) {
					String data = m[3].toString();
					if (data.contentEquals("Same State")) {
						boolean1 = true;
					} else {
						boolean1 = false;
					}
				}
				RestPurchaseOrderModel dropDownModel = new RestPurchaseOrderModel(m[0], m[1], m[2], boolean1, null);

				itemNameList.add(dropDownModel);
			}
			// logger.info("getAllcustomer" +itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>> response = new ResponseEntity<JsonResponse<List<RestPurchaseOrderModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorAutoSearch ends");
		return response;
	}
	
	// Employee List DropDown.
	@SuppressWarnings("unchecked")
	public List<DropDownModel> employeeList(String org, String orgDiv) {
		logger.info("Method : employeeList starts");

		List<DropDownModel> employeeList = new ArrayList<DropDownModel>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("value===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "employeeList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				employeeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("employeeList...---"+employeeList);
		logger.info("Method : employeeList ends");
		return employeeList;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteIssue(String id,String org, String orgDiv) {
		logger.info("Method : deleteIssue starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String value = "SET @p_issue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
  
			 em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "deleteIssue").setParameter("actionValue", value).execute();


			resp.setMessage("Data Deleted Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("deleteIssue=====>>>>" + resp);
		logger.info("Method : deleteIssue ends");
		return resp;
	}
	
	// Approve
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveIssue(String id,String org, String orgDiv,String userId) {
		logger.info("Method : approveIssue starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String value = "SET @p_issue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			System.out.println("value>>>>>>------------"+value);
			 em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "approveIssue").setParameter("actionValue", value).execute();


			resp.setMessage("Data Approved Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("approveIssue=====>>>>" + resp);
		logger.info("Method : approveIssue ends");
		return resp;
	}
	
	// Add Material Return Quantity.
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addReturn(String org, String orgDiv, String slipNo, String returnQuant, String returnRemark, String sku) {
		logger.info("Method : estimateBudgetViewDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_slipNo='" + slipNo + "',@p_returnQuant='" + returnQuant + "',@p_returnRemark='" + returnRemark + "',@p_sku='" + sku + "';";
			System.out.println("values>>>>>-------"+values);
			em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "addReturn").setParameter("actionValue", values).execute();
			
			resp.setMessage("Data Approved Successfully");
			resp.setCode("success");
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("resp>>view>>>---"+resp);
		logger.info("Method : viewRequisitionDetailsForPurchase Dao ends");
		return resp;
	}
	
	
	// Stock Report
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStockQuantity(String org, String orgDiv,String sku) {
		logger.info("Method : estimateBudgetViewDao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String values = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_sku='" + sku + "';";
			System.out.println("values>>>>>-------"+values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "stockQuantity").setParameter("actionValue", values).getResultList();
			
			resp.setBody(x.get(0));
			
		} catch (Exception e) {

			e.printStackTrace();

		}

		System.out.println("resp>>view>>>---"+resp);
		logger.info("Method : viewRequisitionDetailsForPurchase Dao ends");
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getItemQuotationAutoSearchNewListForMI(
			String id,String org, String orgDiv) {
		logger.info("Method : getItemQuotationAutoSearchNewListForMI starts");
		List<InventorySkuProductModel> itemNameList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("fffffffffffffffffff"+value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "getItemQuotationAutoSearchNewListForMI").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], gst,null,null,null,null);
				itemNameList.add(dropDownModel);
			}
		
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemQuotationAutoSearchNewListForMI ends");
		return response;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> downloadExcel(String org, String orgDiv) {
		logger.info("Method : downloadExcel starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		try {

			String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("value>>>>>>"+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("store_material_issue_routines")
					.setParameter("actionType", "downloadExcel").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setMessage("Data Fetched Successfully");
			resp.setCode("success");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Edit=====>>>>" + resp);
		logger.info("Method : downloadExcel ends");
		return resp;
	}


}
