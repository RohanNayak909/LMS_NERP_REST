package nirmalya.aatithya.restmodule.sales.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import nirmalya.aatithya.restmodule.common.utils.DynamicQueryBuilder;
import nirmalya.aatithya.restmodule.common.utils.GenerateSalesInvoiceNewParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateRequisitionParam;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSaleOrderNewParameter;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.master.model.ProductCategoryModel;
import nirmalya.aatithya.restmodule.procurment.model.InventorySkuProductModel;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSaleOrderNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestSaleOrderNewDao {

	Logger logger = LoggerFactory.getLogger(RestSaleOrderNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> GetStoreList() {
		logger.info("Method : demo Dao starts");

		List<DropDownModel> GetStoreList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "GetStoreList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				GetStoreList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : demo Dao ends");

		return GetStoreList;
	}

	/*
	 * cust Autosearch
	 * 
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getCustomerAutoSearchNewList(String id) {
		logger.info("Method : getCustomerAutoSearchNewList starts");

		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getcustomerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1], m[2]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerAutoSearchNewList ends");
		return response;
	}

	/*
	 * item autosearch
	 */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> getItemQuotationAutoSearchNewList(String id) {
		logger.info("Method : getItemQuotationAutoSearchNewList starts");
		List<RestSaleOrderNewModel> itemNameList = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getitemquotationList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1], m[2], m[3]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getItemQuotationAutoSearchNewList ends");
		return response;
	}

	// get Product Category List Modal
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<ProductCategoryModel>>> getProductCategoryDataListModal() {
		logger.info("Method : getProductCategoryDataListModal starts");

		JsonResponse<List<ProductCategoryModel>> resp = new JsonResponse<List<ProductCategoryModel>>();
		List<ProductCategoryModel> yearList = new ArrayList<ProductCategoryModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getProductCategoryList").setParameter("actionValue", "")
					.getResultList();
			for (Object[] m : x) {

				ProductCategoryModel item = new ProductCategoryModel(m[0], m[1], m[2], m[3], m[4], m[5]);
				yearList.add(item);

			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<ProductCategoryModel>>> response = new ResponseEntity<JsonResponse<List<ProductCategoryModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductCategoryDataListModal ends");
		return response;
	}

	// get product by cat

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> getProductsNByCat(String catId) {
		logger.info("Method : getProductsNByCat starts");

		List<InventorySkuProductModel> productList = new ArrayList<InventorySkuProductModel>();
		JsonResponse<List<InventorySkuProductModel>> resp = new JsonResponse<List<InventorySkuProductModel>>();
		try {
			String value = GenerateRequisitionParam.getProduct(catId);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getProductByCat").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				double gst = 0;
				if (m[9] != null) {
					gst = Double.parseDouble(m[9].toString());
				}
				InventorySkuProductModel dropDownModel = new InventorySkuProductModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], gst, m[10], null, null,null);
				productList.add(dropDownModel);
			}
			resp.setBody(productList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<InventorySkuProductModel>>> response = new ResponseEntity<JsonResponse<List<InventorySkuProductModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getProductsNByCat ends");
		return response;
	}

	/*
	 * add
	 */ 
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> addsalenew(
			List<RestSaleOrderNewModel> restSaleOrderNewModel) {
		logger.info("Method : addsalenew starts");
		
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();
		List<RestSaleOrderNewModel> listData = new ArrayList<RestSaleOrderNewModel>();

		try {
			String values = GenerateSaleOrderNewParameter.getAddempParam(restSaleOrderNewModel);
			System.out.println("Value For Adding Sales Data------------>" + values);
			if (restSaleOrderNewModel.get(0).getSalesOrder() == null
					|| restSaleOrderNewModel.get(0).getSalesOrder() == "") {
				em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "addsalenew")
						.setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Sales Order Saved Successfully");
			} else {
				em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "modifysalesnew")
						.setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Sales Order Modified successfully");
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
		 
		resp.setBody(listData);
		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data is" + response);
		logger.info("Method : addsalenew ends");
		return response;
	}

	/*
	 * view
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllsalesOrder(String orgName, String orgDivision, String pageno,String userId,String fDate, String tDate) {
		logger.info("Method : getAllsalesOrder Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
	        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

	        String formattedFDate = "";
	        String formattedTDate = "";

	        if (fDate != null && !fDate.isEmpty()) {
	            Date date1 = inputFormat.parse(fDate);
	            formattedFDate = outputFormat.format(date1);
	        }

	        if (tDate != null && !tDate.isEmpty()) {
	            Date date2 = inputFormat.parse(tDate);
	            formattedTDate = outputFormat.format(date2);
	        }
			
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_pageno='" + pageno + "',@p_userId='" + userId + "', @p_fDate='" + formattedFDate  + "', @p_tDate='" + formattedTDate  + "';";
			
			System.out.println("Value For View Sales Order------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesorder").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllsalesOrder Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesOrderTimelineDao(String orgName, String orgDivision, String id) {
		logger.info("Method : getSalesOrderTimelineDao Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_soRefId='" + id + "';";
			System.out.println("Value For View Sales Order------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "salesOrderTimeline").setParameter("actionValue", value).getResultList();
			
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : getSalesOrderTimelineDao Dao ends");
		return resp;
		
	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSaleOrderNewModel> viewsalesOrdeerEdit(String id,String invoiceId) {
		logger.info("Method : viewsalesOrdeerEdit starts");
		logger.info("RestSaleOrderNewModel" + id);
		List<RestSaleOrderNewModel> getRequisitionTypeList = new ArrayList<RestSaleOrderNewModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_salesId='" + id + "',@p_salesInvoice='" + invoiceId + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSalesOrderEdit").setParameter("actionValue", values)
					.getResultList();
 
			try {
				for (Object[] m : x) {

					Object DATER = null;
					if (m[41] != null) {
						DATER = m[41].toString();
					}

					Object EDATE = null;
					if (m[42] != null) {
						EDATE = m[42].toString();
					} 
					
					Object InvDATE = null;
					if (m[60] != null) {
						InvDATE = DateFormatter.returnStringDate(m[60]);
					}
					Object DueDate = null;
					if (m[59] != null) {
						DueDate = DateFormatter.returnStringDate(m[59]);
					}
					Object dateSupply = null;
					if (m[61] != null) {
						dateSupply = DateFormatter.returnStringDate(m[61]);
					}
					
					RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], m[1], m[2], m[3], m[4], m[5],
							m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18],
							m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31],
							m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], DATER, EDATE, m[43], m[44],
							m[45], m[46],m[47],m[48],m[49],m[50],
							m[51],m[52],m[53],m[54],m[55],m[56],m[57],m[58],DueDate,InvDATE,dateSupply,null,m[62],m[63],m[64],m[65],m[66],m[67],m[68],m[69]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_salesId='" + getRequisitionTypeList.get(0).getSalesOrder() + "';";
				System.out.println("value to get vendor details---------->"+subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesOrderNew")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
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
		logger.info("Method : viewsalesOrdeerEdit ends"+getRequisitionTypeList);
		return getRequisitionTypeList;
	}
	/*
	 * @SuppressWarnings("unchecked") public List<RestSaleOrderNewModel>
	 * viewsalesOrdeerEdit(String id) {
	 * logger.info("Method : viewsalesOrdeerEdit starts");
	 * List<RestSaleOrderNewModel> getRequisitionTypeList = new
	 * ArrayList<RestSaleOrderNewModel>(); List<InventoryVendorDocumentModel>
	 * docList = new ArrayList<InventoryVendorDocumentModel>(); try { String values
	 * = "SET @p_salesId='" + id + "';";
	 * logger.info("viewsalesOrdeerEdit  =============> "+values); List<Object[]> x
	 * = em.createNamedStoredProcedureQuery("salesOrderNew")
	 * .setParameter("actionType", "getSalesOrderEdit").setParameter("actionValue",
	 * values) .getResultList(); try { for (Object[] m : x) {
	 * 
	 * 
	 * Object DATER = null; if (m[41] != null) { DATER = m[41].toString(); }
	 * 
	 * 
	 * 
	 * Object EDATE = null; if (m[42] != null) { EDATE = m[42].toString(); }
	 * 
	 * 
	 * RestSaleOrderNewModel dropDownModel = new
	 * RestSaleOrderNewModel(m[0].toString(), m[1].toString(), m[2].toString(),
	 * m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11],m[12]);
	 * getRequisitionTypeList.add(dropDownModel);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * try { String subValues = "SET @p_quotationId='" +
	 * getRequisitionTypeList.get(0).getQuotationId() + "';"; List<Object[]> x1 =
	 * em.createNamedStoredProcedureQuery("salesOrderNew")
	 * .setParameter("actionType", "getVendorDocs").setParameter("actionValue",
	 * subValues) .getResultList(); for (Object[] m : x1) {
	 * 
	 * InventoryVendorDocumentModel dropDownModel = new
	 * InventoryVendorDocumentModel(m[0], m[1], m[2]); docList.add(dropDownModel); }
	 * } catch (Exception e) {
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * getRequisitionTypeList.get(0).setDocumentList(docList);
	 * logger.info("Method : viewsalesOrdeerEdit ends"); return
	 * getRequisitionTypeList; }
	 */

	/*
	 * viewsalesOrderForPacking
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSaleOrderNewModel> viewsalesOrderForPacking(String id, String poidd) {
		logger.info("Method : viewsalesOrderForPacking starts");
		List<RestSaleOrderNewModel> getRequisitionTypeList = new ArrayList<RestSaleOrderNewModel>();
		try {
			String values = "SET @p_salesId='(\"" + id + "\")',@p_poidd='\"" + poidd + "\"';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesOrderForPacking").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {

					Object DATER = null;
					if (m[21] != null) {
						DATER = m[21].toString();
					}
					Object DATET = null;
					if (m[22] != null) {
						DATET = m[22].toString();
					}
					Object EDATE = null;
					if (m[26] != null) {
						EDATE = m[26].toString();
					}
					RestSaleOrderNewModel dropDownModel = new RestSaleOrderNewModel(m[0], null, m[1], m[2], null, null,
							m[3], m[4], m[5], null, m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
							m[16], m[17], null, m[18], null, m[19], m[20], null, DATER, DATET, null, m[23], m[24],
							m[25], EDATE, m[27], m[28], m[29], null, null, m[30], m[31], m[32], m[33], m[34], m[35],
							m[36], null, null, null, m[37], m[38], m[39], m[40], m[41], m[42].toString(),
							m[43].toString(), m[44], m[45], m[46], m[47], m[48]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewsalesOrderForPacking ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 */

	public ResponseEntity<JsonResponse<Object>> deletesalesOrder(RestSaleOrderNewModel deletesalesOrder) {
		logger.info("Method : deletesalesOrder starts");
		logger.info("restSaleOrderNewModel" + deletesalesOrder);
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateSaleOrderNewParameter.getDeleteParam(deletesalesOrder);
			logger.info(value);
			em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "deletesalesOrder")
					.setParameter("actionValue", value).execute();
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
		logger.info("Method : deletesalesOrder ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSOInsertedId() {
		logger.info("Method : getSOInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSOInsertedId").setParameter("actionValue", "").getResultList();

			Object jobId = x.get(0);
			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSOInsertedId ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesPoListt(String id) {

		logger.info("Method : getSalesPoListt starts");
		List<DropDownModel> salesPOList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSalesPoListt").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesPOList.add(dropDownModel);
			}
			resp.setBody(salesPOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getSalesPoListt ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> viewsalesOrderPoWise(String orgName, String orgDiv,
			String id) {
		logger.info("Method : viewsalesOrderPoWise Dao starts");

		List<RestSaleOrderNewModel> solist = new ArrayList<RestSaleOrderNewModel>();
		JsonResponse<List<RestSaleOrderNewModel>> resp = new JsonResponse<List<RestSaleOrderNewModel>>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + id + "';";
			logger.info("values****************************" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "viewsalesOrderPoWise").setParameter("actionValue", values)
					.getResultList();

			for (Object[] m : x) {

				Object expDate = null;
				if (m[3] != null) {
					expDate = DateFormatter.returnStringDate(m[3]);
				}

				Object ordate = null;
				if (m[9] != null) {
					ordate = DateFormatter.returnStringDate(m[9]);
				}
				RestSaleOrderNewModel viewdemo = new RestSaleOrderNewModel(m[0], m[1], m[2], expDate, m[4], m[5], m[6],
						m[7], m[8], ordate, m[10].toString(), m[11].toString(), m[12], null, null);
				solist.add(viewdemo);
			}
			resp.setBody(solist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSaleOrderNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : viewsalesOrderPoWise Dao ends");
		logger.info("resp****************************" + response);
		return response;

	}

	// Block Order

	public JsonResponse<RestSaleOrderNewModel> blockSaleOrderItem(String blockeOrder, String salesOrder, String sku) {
		logger.info("Method : blockSaleOrderItem starts");

		RestSaleOrderNewModel req = new RestSaleOrderNewModel();
		JsonResponse<RestSaleOrderNewModel> resp = new JsonResponse<RestSaleOrderNewModel>();
		try {

			String value = "SET @p_blockeOrder='" + blockeOrder + "',@p_salesOrder='" + salesOrder + "',@p_sku='" + sku
					+ "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "blockSaleOrderItem")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Blocked successfully");

			// List<DropDownModel> managerByUesr =
			// checkDuplicateDao.getUserByRequisitionId(id,name);
			/*
			 * for(DropDownModel m : managerByUesr) { String
			 * msg=m.getName()+" approved your Leave"; try { String msgId =
			 * pushNotification.pushFCMNotification(m.getKey(),msg); } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : blockSaleOrderItem ends");
		return resp;
	}

	// approve

	public JsonResponse<RestSaleOrderNewModel> approveSaleOrder(String approveStatus, String salesOrder,
			String pendingQut,String userId,String org,String orgDiv) {
		logger.info("Method : approveSaleOrder starts");

		RestSaleOrderNewModel req = new RestSaleOrderNewModel();
		JsonResponse<RestSaleOrderNewModel> resp = new JsonResponse<RestSaleOrderNewModel>();
		try {

			String value = "SET @p_approveStatus='" + approveStatus + "',@p_salesOrder='" + salesOrder
					+ "',@p_pendingQut='" + pendingQut + "',@p_org='" + org + "',@p_orgDiv='" + orgDiv + "',@p_userId='" + userId + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "approveSaleOrder")
					.setParameter("actionValue", value).execute();
			resp.setBody(req);
			resp.setCode("success");
			resp.setMessage("Approved successfully");

			// List<DropDownModel> managerByUesr =
			// checkDuplicateDao.getUserByRequisitionId(id,name);
			/*
			 * for(DropDownModel m : managerByUesr) { String
			 * msg=m.getName()+" approved your Leave"; try { String msgId =
			 * pushNotification.pushFCMNotification(m.getKey(),msg); } catch (Exception e) {
			 * e.printStackTrace(); } }
			 */

		} catch (Exception e) {

			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approveSaleOrder ends");
		return resp;
	}

	// Search

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> soDataViewSearch(String orgName, String orgDivision, String searchValue) {
		logger.info("Method : soDataViewSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_Svalue='" + searchValue
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "soDataViewSearch").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : soDataViewSearch Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPoOnSelectionCustomer(String custId, String orgName, String orgDiv) {
		logger.info("Method : getPoOnSelectionCustomer Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "';";
			System.out.println("getPoOnSelectionCustomer ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getPurchaseOrder").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPoOnSelectionCustomer Dao ends"+resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPoDetails(String poId, String orgName, String orgDiv) {
		logger.info("Method : getPoDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + poId + "';";
			System.out.println("getPoDetails ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getPoDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPoDetails Dao ends" + resp);
		return resp;

	}
	

	// Sales Order PDF
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesOrderPdf(String id, String orgName, String orgDivision, String poId) {
		logger.info("Method : getSalesOrderPdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_sOrderId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_poId='" + poId + "';";
			System.out.println("values***==================" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "getSalesOrderPdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetch successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getSalesOrderPdf Dao ends" + resp);
		return resp;
	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addShippingAddressSO(DropDownModel data) {
		logger.info("Method : addShippingAddressSO starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = DynamicQueryBuilder.buildDynamicQuery(data);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "addShippingAddressSO")
					.setParameter("actionValue", values).getResultList();
			
			if(x.size() > 0) {
				resp.setBody(x.get(0));
			}
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			try {
				String[] err = serverDao.errorProcedureCall(e);
				logger.info(err.toString());
				resp.setCode("failed");
				resp.setMessage(err[1]);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

		logger.info("Method : addShippingAddressSO ends");
		return resp;
	}	
//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> addsaleInvoice(List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
		logger.info("Method : addsaleInvoice starts");
		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();
		List<RestSalesInvoiceNewModel> listData = new ArrayList<RestSalesInvoiceNewModel>();
		try {
			String values = GenerateSalesInvoiceNewParameter.getAddSalesOrderInvoiceParam(restSalesInvoiceNewModel);
			System.err.println("addsaleInvoice---------------->>>>>>>>"+restSalesInvoiceNewModel);
			System.err.println("values---------------->>>>>>>>"+values);
			if (restSalesInvoiceNewModel.get(0).getSaleDeliverysales1() == null || restSalesInvoiceNewModel.get(0).getSaleDeliverysales1() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
				em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "addsaleInvoice")
						.setParameter("actionValue", values).execute();
			} else {
				logger.info("MODIFY====#" + values);
				em.createNamedStoredProcedureQuery("salesOrderNew").setParameter("actionType", "modifysaleInvoice")
						.setParameter("actionValue", values).execute();
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
		ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response data is" + response);
		logger.info("Method : addsaleInvoice ends");
		return response;
	}
//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saleorderInvoicePdf(String id, String orgName, String orgDivision,String poId) {
		logger.info("Method : saleorderInvoicePdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_salesInvoice=\"" + id + "\", @p_org=\"" + orgName + "\", @p_orgDiv=\"" + orgDivision + "\",@p_poId=\"" + poId + "\";";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesOrderNew")
					.setParameter("actionType", "saleorderInvoicePdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetch successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : saleorderInvoicePdf Dao ends" + resp);
		return resp;
	}
}
