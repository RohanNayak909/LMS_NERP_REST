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

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.purchase.GenerateManageInvoiceParameter;
import nirmalya.aatithya.restmodule.procurment.model.InventoryVendorDocumentModel;
import nirmalya.aatithya.restmodule.purchase.model.RestManageInvoiceModel;

@Repository
public class PurchaseInvoiceDao {
	Logger logger = LoggerFactory.getLogger(PurchaseInvoiceDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPurchaseInvoiceInsertedId(String requestType) {
		logger.info("Method : getPurchaseInvoiceInsertedId starts");

		List<DropDownModel> itemList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String value = "SET @p_requestType='" + requestType + "';";
			System.out.println("value>>>>>>>---" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "getPurchaseInvoiceInsertedId").setParameter("actionValue", value)
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
		logger.info("Method : getPurchaseInvoiceInsertedId ends");
		return response;
	}

	/*
	 * add
	 */
	public ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> addPurchaseInvoice(
			List<RestManageInvoiceModel> restManageInvoiceModel) {

		logger.info("Method : addPurchaseInvoice starts");

		// logger.info("RestManageInvoiceModel" + restManageInvoiceModel);
		JsonResponse<List<RestManageInvoiceModel>> resp = new JsonResponse<List<RestManageInvoiceModel>>();
		List<RestManageInvoiceModel> listData = new ArrayList<RestManageInvoiceModel>();

		try {
			String values = GenerateManageInvoiceParameter.getAddPurchaseInvoice(restManageInvoiceModel);

			if (restManageInvoiceModel.get(0).getInvoiceId() == null
					|| restManageInvoiceModel.get(0).getInvoiceId() == "") {

				em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
						.setParameter("actionType", "addPurchaseInvoice").setParameter("actionValue", values).execute();
				
				resp.setCode("Purchase Invoice Added Successfully.");

			} else {
				System.out.println("@modifyyyyyyyyyyyyyy" + values);

				em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
						.setParameter("actionType", "modifyInvoice").setParameter("actionValue", values).execute();
				
				resp.setCode("Purchase Invoice Modified Successfully.");

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
		ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>> response = new ResponseEntity<JsonResponse<List<RestManageInvoiceModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response data issssssssssssssssssssss" + response);
		logger.info("Method : addPurchaseInvoice ends");
		return response;
	}

	// view

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewInvoiceDetails(String orgName, String orgDivision, String invType,String type,String userId) {
		logger.info("Method : viewInvoiceDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_requestType='" + invType+ "',@p_type='" + type+ "',@p_userId='" + userId+ "';";
			System.out.println("value>>>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "viewInvoiceDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewInvoiceDetails Dao ends");
		return resp;

	}

	/*
	 * edit
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<RestManageInvoiceModel> purchaseInvoiceEdit(String id, String orgName, String orgDiv) {
		logger.info("Method : purchaseInvoiceEdit starts");
		List<RestManageInvoiceModel> getRequisitionTypeList = new ArrayList<RestManageInvoiceModel>();
		List<InventoryVendorDocumentModel> docList = new ArrayList<InventoryVendorDocumentModel>();
		try {
			String values = "SET @p_invoiceId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "purchaseInvoiceEdit").setParameter("actionValue", values)
					.getResultList();
			try {
				for (Object[] m : x) {
					Object createdOn1 = null;
					if (m[4] != null) {
						createdOn1 = m[4].toString();
					}
					Object createdOn2 = null;
					if (m[6] != null) {
						createdOn2 = m[6].toString();
					}
					double rcv = 0.00;
					if (m[38] != null) {
						rcv = Double.parseDouble(m[38].toString());
					}

					RestManageInvoiceModel dropDownModel = new RestManageInvoiceModel(m[0], m[1], m[2], m[3],
							createdOn1, m[5], createdOn2, m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15],
							m[16], m[17], m[18], m[19], m[20], m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28],
							m[29], m[30], m[31], m[32], m[33], m[34], m[35], m[36], m[37], rcv, m[39], m[40], m[41],
							m[42], m[43], m[44], m[45], m[46], m[47], m[48], m[49], m[50], m[51], m[52], m[53], m[54],
							m[55], m[56], m[57], m[58], m[59], m[60], m[61], m[62], m[63], m[64], m[65]);
					getRequisitionTypeList.add(dropDownModel);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				String subValues = "SET @p_invoiceId='" + getRequisitionTypeList.get(0).getInvoiceId() + "';";
				logger.info("DOCUMRNt" + subValues);
				List<Object[]> x1 = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
						.setParameter("actionType", "getVendorDocs").setParameter("actionValue", subValues)
						.getResultList();
				for (Object[] m : x1) {

					InventoryVendorDocumentModel dropDownModel = new InventoryVendorDocumentModel(m[0], m[1], m[2], m[3]);
					docList.add(dropDownModel);
				}
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		getRequisitionTypeList.get(0).setDocumentList(docList);
		logger.info("========================edit" + getRequisitionTypeList);
		logger.info("Method : purchaseInvoiceEdit ends");
		return getRequisitionTypeList;
	}

	/*
	 * delete
	 * 
	 */
	public ResponseEntity<JsonResponse<Object>> deleteInvoiceDetils(RestManageInvoiceModel deleteInvoice) {
		logger.info("Method : deleteInvoiceDetils starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		try {
			String value = GenerateManageInvoiceParameter.getDeleteInvoice(deleteInvoice);
			
			System.out.println("value>>>>>" + value);
			em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "deleteInvoiceDetils").setParameter("actionValue", value).execute();

			// logger.info("print block" + deletesalesInvoice);
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
		// logger.info("@@@@@@@@@@@@@@@@" + deletesalesInvoice);
		logger.info("Method : deleteInvoiceDetils ends");
		return response;
	}

	// approve

	public JsonResponse<DropDownModel> approveInvoiceDetails(String approveStatus, String invoiceId, String orgName,
			String orgDivision, String approvedBy) {
		logger.info("Method : approveInvoiceDetails starts");

		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
		try {
			String value = "SET @p_approveStatus='" + approveStatus + "',@p_invoiceId='" + invoiceId + "',@p_org='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "',@p_approvedBy='" + approvedBy + "';";
			logger.info("value===" + value);
			em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "approveInvoiceDetails").setParameter("actionValue", value).execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("resp===" + resp);
		logger.info("Method : approveInvoiceDetails ends");
		return resp;
	}

	// Search.

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewInvoiceDetailsSearch(String orgName, String orgDivision, String invType,
			String search) {
		logger.info("Method : viewInvoiceDetailsSearch Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_requestType='" + invType
					+ "',@p_search='" + search + "';";
			System.out.println("value>>>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "viewInvoiceDetailsSearch").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewInvoiceDetailsSearch Dao ends");
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
	public JsonResponse<Object> purchaseInvoiceFilterdata(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : purchaseInvoiceFilterdata Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values----->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("purchase_invoice_Routines")
					.setParameter("actionType", "viewPurchaseInvoiceFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : purchaseInvoiceFilterdata Dao ends" + resp);
		return resp;

	}
}
