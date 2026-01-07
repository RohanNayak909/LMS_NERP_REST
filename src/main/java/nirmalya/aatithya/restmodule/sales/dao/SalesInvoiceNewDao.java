package nirmalya.aatithya.restmodule.sales.dao;

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

import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateInvPaymentNewParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateInvoicePaymentParameter;
import nirmalya.aatithya.restmodule.common.utils.sales.GenerateSalesInvoiceNewParameter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceMultipleWayBillCh;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoiceNewModel;
import nirmalya.aatithya.restmodule.sales.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;

@Repository
public class SalesInvoiceNewDao {

	Logger logger = LoggerFactory.getLogger(SalesInvoiceNewDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	@Autowired
	EnvironmentVaribles env;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> getSalesOrderAutoSearchNewList(String id) {
		logger.info("Method : getSalesOrderAutoSearchNewList starts");
		List<RestSalesInvoiceNewModel> itemNameList = new ArrayList<RestSalesInvoiceNewModel>();
		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getsalesInvoiceList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				RestSalesInvoiceNewModel dropDownModel = new RestSalesInvoiceNewModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("autosearch" + response);
		logger.info("Method : getCustomerAutoSearchNewList ends");
		return response;
	}

	/*
	 * add
	 */
	/*
	 * public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>
	 * addsaleInvoicenew( List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
	 * logger.info("Method : addsaleInvoicenew starts");
	 * 
	 * JsonResponse<List<RestSalesInvoiceNewModel>> resp = new
	 * JsonResponse<List<RestSalesInvoiceNewModel>>();
	 * List<RestSalesInvoiceNewModel> listData = new
	 * ArrayList<RestSalesInvoiceNewModel>();
	 * 
	 * try { String values =
	 * GenerateSalesInvoiceNewParameter.getAddSalesInvoiceParam(
	 * restSalesInvoiceNewModel);
	 * System.err.println("restSalesInvoiceNewModel---------------->>>>>>>>"+
	 * restSalesInvoiceNewModel);
	 * System.err.println("values---------------->>>>>>>>"+values); if
	 * (restSalesInvoiceNewModel.get(0).getSaleDeliverysales() == null ||
	 * restSalesInvoiceNewModel.get(0).getSaleDeliverysales() == "") {
	 * logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
	 * em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter(
	 * "actionType", "addsaleInvoicenew") .setParameter("actionValue",
	 * values).execute(); } else { logger.info("MODIFY====#" + values);
	 * em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter(
	 * "actionType", "modifysaleInvoicenew") .setParameter("actionValue",
	 * values).execute(); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]);
	 * 
	 * } catch (Exception e1) { e1.printStackTrace(); } } resp.setBody(listData);
	 * ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>( resp,
	 * HttpStatus.CREATED); // logger.info("response data is" + response);
	 * logger.info("Method : addsaleInvoicenew ends"); return response; }
	 */

	/*
	 * view
	 */
//	@SuppressWarnings("unchecked")
//	public JsonResponse<List<RestSalesInvoicePaymentModel>> getAllsalesInvoice(String userId, String organization,
//			String orgDivision, String pageno) {
//		logger.info("Method : getAllsalesInvoice Dao starts");
//
//		List<RestSalesInvoicePaymentModel> invoiceList = new ArrayList<RestSalesInvoicePaymentModel>();
//		JsonResponse<List<RestSalesInvoicePaymentModel>> resp = new JsonResponse<List<RestSalesInvoicePaymentModel>>();
//
//		try {
//			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
//					+ orgDivision + "\",@p_pageno=\"" + pageno + "\";";
//			logger.info("value====" + value);
//			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
//					.setParameter("actionType", "viewsalesInvoice").setParameter("actionValue", value).getResultList();
//
//			for (Object[] m : x) {
//
//				Object invoiceDate = null;
//				if (m[3] != null) {
//					invoiceDate = DateFormatter.returnStringDate(m[3]);
//				}
//				Object dueDate = null;
//				if (m[8] != null) {
//					dueDate = DateFormatter.returnStringDate(m[8]);
//				}
//				RestSalesInvoicePaymentModel viewdemo = new RestSalesInvoicePaymentModel(m[0], m[1], m[2], invoiceDate,
//						m[4], m[5], m[6], m[7], dueDate, m[9], m[10], m[11], m[12], m[13], m[14], m[15]);
//				invoiceList.add(viewdemo);
//			}
//			logger.error("invoiceList====>>>>>>>>>>>>>>"+invoiceList);	
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		resp.setBody(invoiceList);
//		logger.info("Method : getAllsalesInvoice Dao ends");
//
//		return resp;
//
//	}

	/*
	 * view Invoice Search
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestSalesInvoicePaymentModel>> viewsalesInvoiceSearch(String userId, String organization,
			String orgDivision, String searchValue) {
		logger.info("Method : viewsalesInvoiceSearch Dao starts");

		List<RestSalesInvoicePaymentModel> invoiceList = new ArrayList<RestSalesInvoicePaymentModel>();
		JsonResponse<List<RestSalesInvoicePaymentModel>> resp = new JsonResponse<List<RestSalesInvoicePaymentModel>>();

		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + organization + "\", @p_orgDiv=\""
					+ orgDivision + "\",@p_searchValue=\"" + searchValue + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewsalesInvoiceSearch").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {
				Object invoiceDate = null;
				if (m[3] != null) {
					invoiceDate = DateFormatter.returnStringDate(m[3]);
				}
				Object dueDate = null;
				if (m[8] != null) {
					dueDate = DateFormatter.returnStringDate(m[8]);
				}
				Object pstatus = null;
				if (m[12] == null || m[12] == "" || m[13] == "null") {
					pstatus = "Pending";
				} else {
					pstatus = m[12];
				}
				RestSalesInvoicePaymentModel viewdemo = new RestSalesInvoicePaymentModel(m[0], m[1], m[2], invoiceDate,
						m[4], m[5], m[6], m[7], dueDate, m[9], m[10], m[11], pstatus.toString(), m[13], m[14], m[15]);
				invoiceList.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(invoiceList);
		logger.info("Method : viewsalesInvoiceSearch Dao ends");

		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestSalesInvoiceNewModel> viewsalesIvoiceEdit(String id, String organization, String orgDivision) {
		logger.info("Method : viewsalesIvoiceEdit starts");
		// logger.info("RestSalesInvoiceNewModel" + id);
		List<RestSalesInvoiceNewModel> getRequisitionTypeList = new ArrayList<RestSalesInvoiceNewModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_salesInvoice='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println("values>>>>>>>>>" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getSalesInvoiceEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object InvDATE = null;
					if (m[4] != null) {
						InvDATE = DateFormatter.returnStringDate(m[4]);
					}
					Object DueDate = null;
					if (m[6] != null) {
						DueDate = DateFormatter.returnStringDate(m[6]);
					}
					Object dateSupply = null;
					if (m[45] != null) {
						dateSupply = DateFormatter.returnStringDate(m[45]);
					}
					Object ewayDate = null;
					if (m[52] != null) {
						ewayDate = DateFormatter.returnStringDate(m[52]);
					}

					RestSalesInvoiceNewModel dropDownModel = new RestSalesInvoiceNewModel(m[0], m[1], m[2], m[3],
							InvDATE, m[5], DueDate, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29],
							m[30], m[31], m[32], m[33], m[34], m[35], m[36], null, null, null, m[37], null, null, m[38],
							m[39], m[40], m[41], m[42], m[43], m[44], dateSupply, m[46], m[47], m[48], m[49], m[50],
							m[51], ewayDate, m[53], m[54], m[55], m[56], m[57], m[58], m[59], m[60], m[61]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				String subValues = "SET @p_quotationId='" + getRequisitionTypeList.get(0).getSaleInvoice() + "';";
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesOrderNew")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {
					System.out.println(Arrays.toString(m));
					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2]);
					docList.add(dropDownModel);
					getRequisitionTypeList.get(0).setDocumentList(docList);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesIvoiceEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * payment mode
	 */

	@SuppressWarnings("unchecked")
	public List<DropDownModel> GetpaymentModeList() {
		logger.info("Method :paymentModeList dao starts");

		List<DropDownModel> GetpaymentModeList = new ArrayList<DropDownModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "PaymentMode").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				GetpaymentModeList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : paymentModeList dao ends");

		return GetpaymentModeList;
	}

	/*
	 * payment add
	 */

	public ResponseEntity<JsonResponse<Object>> addinvPaymentnew(RestSalesInvoiceNewModel salesInvoiceNewModel) {

		logger.info("Method : addsaleInvPaymentnewdao starts");

		// logger.info("RestSalesInvoiceNewModel" + salesInvoiceNewModel);
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = GenerateInvPaymentNewParameter.getAddpayParam(salesInvoiceNewModel);
			// logger.info("value#" + values);

			if (salesInvoiceNewModel.getSaleInvoice() == null || salesInvoiceNewModel.getSaleInvoice() == "") {
				// logger.info("ADD#" + values);
				em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "addsaleInvpaymentnew")
						.setParameter("actionValue", values).execute();

			} else {
				// logger.info("@modify"+values);
				em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "modifypaymentnew")
						.setParameter("actionValue", values).execute();

			}

		} catch (Exception e) {

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
		// logger.info("response data is" + response);
		logger.info("Method : addinvPaymentnewdao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesorderList(String id, String type) {

		logger.info("Method : getSalesorderList starts");
		List<DropDownModel> salesOrderList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_customerId='" + id + "',@p_type='" + type + "';";
		logger.info("++++++++++++++++++++++++++" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getSalesorderList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				salesOrderList.add(dropDownModel);
				// logger.info("stateeeeeeeeeee"+dropDownModel);
			}

			resp.setBody(salesOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("stateeeeeeeeeee"+response);
		logger.info("Method : getSalesorderList ends");
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoiceInsertedId() {
	 * logger.info("Method : getInvoiceInsertedId starts");
	 * 
	 * List<DropDownModel> itemList = new ArrayList<DropDownModel>();
	 * JsonResponse<List<DropDownModel>> resp = new
	 * JsonResponse<List<DropDownModel>>(); try {
	 * 
	 * List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
	 * .setParameter("actionType",
	 * "getInvoiceInsertedId").setParameter("actionValue", "").getResultList();
	 * 
	 * Object jobId = x.get(0); logger.info("job id--------" + jobId);
	 * 
	 * DropDownModel dropDownModel = new DropDownModel(jobId, null);
	 * 
	 * itemList.add(dropDownModel); resp.setBody(itemList); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * // logger.info("response for getting job card id -------" + response);
	 * logger.info("Method : getInvoiceInsertedId ends"); return response; }
	 */

	/************************ Invoice PDF View **********************/

	@SuppressWarnings("unchecked")
	public List<RestSalesInvoiceNewModel> viewsalesInvoiceViewPdf(String id, String organization, String orgDivision) {
		logger.info("Method : viewsalesInvoiceViewPdf starts");
		List<RestSalesInvoiceNewModel> getRequisitionTypeList = new ArrayList<RestSalesInvoiceNewModel>();
		List<RestSalesInvoiceMultipleWayBillCh> cbList = new ArrayList<RestSalesInvoiceMultipleWayBillCh>();
		try {
			String values = "SET @p_salesInvoice='" + id + "',@p_org='" + organization + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewsalesInvoiceViewPdf").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object InvDATE = null;
					if (m[1] != null) {
						InvDATE = DateFormatter.returnStringDate(m[1]);
					}
					Object poDate = null;
					if (m[4] != null) {
						poDate = DateFormatter.returnStringDate(m[4]);
					}

					String orgImg = null;
					if (m[47] != null && m[47] != "" && m[47] != " " && !m[47].toString().equals(" ")
							&& !m[47].toString().equals(null) && !m[47].toString().equals("")) {
						orgImg = env.getMobileView() + "document/document/" + m[47].toString();
					} else {
						orgImg = "";
					}
					/*
					 * Object fcRate = 0; if (m[30] == null) { fcRate =""; }
					 */
					/*
					 * Object fcRate = null; if (m[30] != null) { fcRate = m[30].toString(); }
					 */
					logger.info(Arrays.toString(m));
					RestSalesInvoiceNewModel dropDownModel = new RestSalesInvoiceNewModel(m[0], InvDATE, m[2], m[3],
							poDate, m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16],
							m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29],
							m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42],
							m[43], null, m[44], m[45], m[46], orgImg, m[48], m[49], m[50], null, m[51], m[52], m[53],
							m[54], m[55], m[56], m[57], m[58], m[59], m[60], m[61], m[62]);
					getRequisitionTypeList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("salesInvoiceNew")
						.setParameter("actionType", "getChallanBillList").setParameter("actionValue", values)
						.getResultList();
				for (Object[] m : x1) {

					RestSalesInvoiceMultipleWayBillCh dropDownModel = new RestSalesInvoiceMultipleWayBillCh(m[0], m[1],
							m[2], m[3], m[4], m[5], m[6], m[7], m[8]);
					cbList.add(dropDownModel);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setChallanBillList(cbList);
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : viewsalesOrdeerEdit ends");
		return getRequisitionTypeList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getInvoicepodata() {
		logger.info("Method : getInvoicepodata starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getInvoicepodata").setParameter("actionValue", "").getResultList();
			Object jobId = x.get(0);
			// Object poId = x.get(1);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : getInvoiceInsertedId ends");
		return response;
	}

	/************************ Invoice PDF View **********************/

	/* project autosearch */

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> geProjectListByAutoSearch(String id) {
		logger.info("Method : geProjectListByAutoSearch starts");

		List<RestSalesInvoiceNewModel> itemNameList = new ArrayList<RestSalesInvoiceNewModel>();
		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		logger.info("valueprojext===" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getprojectList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestSalesInvoiceNewModel dropDownModel = new RestSalesInvoiceNewModel(m[0], m[1], m[2], m[3]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : geProjectListByAutoSearch ends" + response);
		return response;
	}

	/*
	 * view item
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<List<RestSalesInvoiceNewModel>> getAllsalesInvoiceitem(String prId, String crId) {
		logger.info("Method : getAllsalesInvoiceitem Dao starts");

		List<RestSalesInvoiceNewModel> invoiceList = new ArrayList<RestSalesInvoiceNewModel>();
		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();

		try {
			String value = "SET @p_prId=\"" + prId + "\", @p_crId=\"" + crId + "\";";
			logger.info("value====" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "getAllsalesInvoiceitem").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestSalesInvoiceNewModel viewdemo = new RestSalesInvoiceNewModel(m[0], m[1], m[2]);
				invoiceList.add(viewdemo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(invoiceList);
		logger.info("resp=====" + resp);
		logger.info("Method : getAllsalesInvoiceitem Dao ends");

		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> viewSalesPdfNew(String id) {
		logger.info("Method : viewSalesPdfNew starts" + id);

		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();
		List<RestSalesInvoiceNewModel> rs = new ArrayList<RestSalesInvoiceNewModel>();

		try {

			// String value = "SET @p_id='" + id + "';";
			String value = "SET @p_salesInvoice='" + id + "';";

			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewInvoicePdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestSalesInvoiceNewModel dropDownModel = new RestSalesInvoiceNewModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9].toString(), m[10], m[11], m[12], m[13].toString(), m[14], m[15],
						m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24]);

				rs.add(dropDownModel);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> response = new ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : purchaseInvoicePdfAll ends" + response);
		System.out.println(response);
		return response;
	}

	public JsonResponse<Object> rejectInvoice(String invId, String comment, String orgName, String orgDiv,
			String userId) {
		logger.info("Method : rejectInvoice Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			// String value = "SET @p_invId='" + invId + "',@p_comment='" + comment +
			// "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			String value = "SET @p_invId='" + invId + "',@p_comment='" + comment + "',@p_userId='" + userId
					+ "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "rejectInvoice")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Request To Stacking Successfully");
			// resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : rejectInvoice Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	// For add Uloaded invoice Data

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> addInvoiceUploadData(List<RestSalesInvoiceNewModel> pOrder) {
		logger.info("Method : addInvoiceUploadData dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String valuesGST = GenerateSalesInvoiceNewParameter.checkGSTExistsParam(pOrder);
			System.out.println("valuesGST===" + valuesGST);
			if (valuesGST != null || valuesGST != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
						.setParameter("actionType", "checkGstExists").setParameter("actionValue", valuesGST)
						.getResultList();
				System.out.println(x);
				if (x.size() == 1 && x.get(0) == null) {
					try {
						String values = GenerateSalesInvoiceNewParameter.addInvoiceUploadDataParam(pOrder);

						System.out.println("values===" + values);
						if (values != null || values != "") {
							em.createNamedStoredProcedureQuery("salesInvoiceNew")
									.setParameter("actionType", "addInvoiceUploadData")
									.setParameter("actionValue", values).execute();

						}
					} catch

					(Exception e) {
						try {
							String[] err = serverDao.errorProcedureCall(e);
							resp.setCode(err[0]);
							resp.setMessage(err[1]);

						} catch (Exception e1) {
							logger.error("addInvoiceUploadData: " + e.getMessage());
							e1.printStackTrace();
						}

					}
				} else {
					resp.setMessage("Information Doesn't exists for GSTs: " + x);
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : addInvoiceUploadData Dao ends");
		return response;
	}

	// add payment
	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(
			RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {

		logger.info("Method in Dao: addPaymentInvoice starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateInvoicePaymentParameter.addPaymentParam(restSalesInvoicePaymentModel);

			System.out.println("==============" + values);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "addPayment")
					.setParameter("actionValue", values).execute();
			resp.setCode("success");
			resp.setMessage("Data saved successfully");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
				resp.setCode("failed");
				resp.setMessage("Something is wrong");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method in Dao: addPaymentInvoice ends");

		return response;
	}

	// payment approval
	public JsonResponse<RestSalesInvoicePaymentModel> paymentApproval(String invoiceId, String userId) {
		logger.info("Method : paymentApproval starts");

		JsonResponse<RestSalesInvoicePaymentModel> resp = new JsonResponse<RestSalesInvoicePaymentModel>();
		try {
			String value = "SET @p_commonPayId='" + invoiceId + "',@p_userId='" + userId + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "paymentApprove")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Payment approved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : paymentApproval ends");
		return resp;
	}

	// payment reject
	public JsonResponse<RestSalesInvoicePaymentModel> paymentReject(String invoiceId, String userId) {
		logger.info("Method : paymentReject starts");

		JsonResponse<RestSalesInvoicePaymentModel> resp = new JsonResponse<RestSalesInvoicePaymentModel>();
		try {
			String value = "SET @p_invoiceId='" + invoiceId + "',@p_userId='" + userId + "';";
			System.out.println("value===" + value);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "paymentReject")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Payment approved successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("resp===" + resp);
		logger.info("Method : paymentReject ends");
		return resp;
	}

	public JsonResponse<Object> approveInvoice(String invId, String comment, String orgName, String orgDiv,
			String userId) {
		logger.info("Method : approveInvoice Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_invId='" + invId + "',@p_comment='" + comment + "',@p_userId='" + userId
					+ "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			System.out.println("values****************************" + value);
			em.createNamedStoredProcedureQuery("salesInvoiceNew").setParameter("actionType", "approveInvoice")
					.setParameter("actionValue", value).execute();
			resp.setCode("success");
			resp.setMessage("Request To Approve Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : approveInvoice Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}

	// getFiscalYearList

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getFiscalYearList() {

		logger.info("Method : getFiscalYearList starts");

		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_contra_routines")
					.setParameter("actionType", "getfiscalYear").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getFiscalYearList ends" + voucherList);

		return voucherList;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saleInvoiceFilterdata(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : saleInvoiceFilterdata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values----->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceNew")
					.setParameter("actionType", "viewSalesInvoiceFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : saleInvoiceFilterdata Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPoOnSaleInvoiceList(String custId, String orgName, String orgDiv) {
		logger.info("Method : getPoOnSaleInvoiceList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_custId='" + custId + "';";
			System.out.println("getPoOnSaleInvoiceList ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "getPoOnSaleInvoiceList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getPoOnSaleInvoiceList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getChallanOByPoList(String poId, String orgName, String orgDiv) {
		logger.info("Method : getChallanOByPoList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_poId='" + poId + "';";
			System.out.println("getChallanOByPoList ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "getChallanOByPoList").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getChallanOByPoList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getItemDetailsOnChallan(String selectedValuesStr, String orgName, String orgDiv) {
		logger.info("Method : getItemDetailsOnChallan Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_selectedValue='"
					+ selectedValuesStr + "';";
			System.out.println("getItemDetailsOnChallan ========>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "getItemDetailsOnChallan").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getItemDetailsOnChallan Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getItemDetailsOnOrder(String selectedValuesStr, String orgName, String orgDiv) {
		logger.info("Method : getItemDetailsOnOrder Dao starts");
		
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_selectedValue='"
					+ selectedValuesStr + "';";
			System.out.println("value==="+value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "getItemDetailsOnOrder").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("Method : getItemDetailsOnOrder Dao ends" + resp);
		return resp;
		
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllsalesInvoice(String userId, String orgName, String orgDivision, String type, String fromDate,String toDate) {
		logger.info("Method : getAllsalesInvoice Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_empId=\"" + userId + "\", @p_org=\"" + orgName + "\", @p_orgDiv=\"" + orgDivision
					+ "\",@p_type=\"" + type + "\", @p_fromDate=\"" + fromDate + "\", @p_toDate=\"" + toDate + "\";";
			System.out.println("value to get the delivery challan view--------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "viewsalesInvoice").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : getAllsalesInvoice Dao ends");
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getSalesInvoiceInsertedId(String type) {
		logger.info("Method : getSalesInvoiceInsertedId starts----" + type);

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_type=\"" + type + "\";";
		System.out.println("value=================" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "getSalesInvoiceInsertedId").setParameter("actionValue", value)
					.getResultList();

			Object jobId = x.get(0);
			logger.info("job id--------" + jobId);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);

			itemList.add(dropDownModel);
			resp.setBody(itemList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		// logger.info("response for getting job card id -------" + response);
		logger.info("Method : getSalesInvoiceInsertedId ends");
		return response;
	}

	public ResponseEntity<JsonResponse<List<RestSalesInvoiceNewModel>>> addsaleInvoicenew(
			List<RestSalesInvoiceNewModel> restSalesInvoiceNewModel) {
		logger.info("Method : addsaleInvoicenew starts");
		JsonResponse<List<RestSalesInvoiceNewModel>> resp = new JsonResponse<List<RestSalesInvoiceNewModel>>();
		List<RestSalesInvoiceNewModel> listData = new ArrayList<RestSalesInvoiceNewModel>();
		try {
			String values = GenerateSalesInvoiceNewParameter.getAddSalesInvoiceParam(restSalesInvoiceNewModel);
			System.err.println("restSalesInvoiceNewModel---------------->>>>>>>>" + restSalesInvoiceNewModel);
			System.err.println("values---------------->>>>>>>>" + values);
			if (restSalesInvoiceNewModel.get(0).getSaleDeliverysales() == null
					|| restSalesInvoiceNewModel.get(0).getSaleDeliverysales() == "") {
				logger.info("ADDDDDDDDDDDDDDDDDDS#" + values);
				em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
						.setParameter("actionType", "addsaleInvoicenew").setParameter("actionValue", values).execute();
			} else {
				logger.info("MODIFY====#" + values);
				em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
						.setParameter("actionType", "modifysaleInvoicenew").setParameter("actionValue", values)
						.execute();
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
		logger.info("Method : addsaleInvoicenew ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editSalesInvoice(String id, String orgName, String orgDivision) {
		logger.info("Method : editSalesInvoice Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_salesInvoice=\"" + id + "\", @p_org=\"" + orgName + "\", @p_orgDiv=\"" + orgDivision
					+ "\";";
			System.out.println("value to get the delivery challan view--------->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "editSalesInvoice").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : editSalesInvoice Dao ends");
		return resp;
	}

	/* delete */
	/*
	 * public ResponseEntity<JsonResponse<Object>>
	 * deletesalesInvoice(RestSalesInvoiceNewModel deletesalesInvoice) {
	 * logger.info("Method : deletesalesInvoice starts"); //
	 * logger.info("restSalesInvoiceNewModel" + deletesalesInvoice);
	 * JsonResponse<Object> resp = new JsonResponse<Object>(); resp.setMessage("");
	 * resp.setCode(""); try { String value =
	 * GenerateSalesInvoiceNewParameter.getDeleteParamnew(deletesalesInvoice);
	 * logger.error("restSalesInvoiceNewModel" + value);
	 * em.createNamedStoredProcedureQuery("salesInvoiceProcedure").setParameter(
	 * "actionType", "deletesalesInvoice") .setParameter("actionValue",
	 * value).execute(); } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); } ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : deletesalesInvoice ends"); return response; }
	 */
//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> deletesalesInvoice(String id, String orgName, String orgDiv) {
		logger.info("Method : deletesalesInvoice starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		if (validity)
			try {

				String value = "SET @p_Id='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info("DELETEID" + value);
				em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
						.setParameter("actionType", "deletesalesInvoice").setParameter("actionValue", value).execute();
				resp.setCode("success");
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

		logger.info("Method : deletesalesInvoice ends");
		logger.info("DELETEE" + response);
		return response;
	}

	// pdf
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getSalesInvoicePdf(String id, String orgName, String orgDivision,String type) {
		logger.info("Method : getSalesInvoicePdf Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_salesInvoice=\"" + id + "\", @p_org=\"" + orgName + "\", @p_orgDiv=\"" + orgDivision + "\",@p_type=\"" + type + "\";";
			System.out.println("values***" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("salesInvoiceProcedure")
					.setParameter("actionType", "salesInvoicePdf").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetch successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("failed");
			resp.setMessage("Data Fetch Failed");
		}
		logger.info("Method : getSalesInvoicePdf Dao ends" + resp);
		return resp;
	}

}
