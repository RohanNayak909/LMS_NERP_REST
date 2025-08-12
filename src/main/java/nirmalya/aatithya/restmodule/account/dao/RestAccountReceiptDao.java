package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.account.model.AccountCusRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountCustomerOrderRestModel;
import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.account.model.RestVendorNameListModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateInvoicePaymentParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountReceiptDao {
	Logger logger = LoggerFactory.getLogger(RestAccountReceiptDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> addReceiptVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addReceiptVoucher starts");
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AccountJournalVoucherModel l : journalVoucherModel) {
			/*
			 * if (l.getCostCenter() == null || l.getCostCenter() == "") { validation =
			 * false; resp.setCode("Field Validation Error");
			 * resp.setMessage("Please Select Cost Center."); break; } else
			 */ if (l.getDescription() == null || l.getDescription() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Enter Description.");
				break;
			}
		}

		if (validation) {

			if (journalVoucherModel.get(0).getJournalVoucher() == null
					|| journalVoucherModel.get(0).getJournalVoucher() == "") {
				try {

					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("Add=====>>>>" + value);
					if ("".equals(journalVoucherModel.get(0).getTaxType())) {
						em.createNamedStoredProcedureQuery("account_receipt_routines")
								.setParameter("actionType", "multipleReciveVoucher").setParameter("actionValue", value)
								.execute();
					} // addReceiptVoucher
					else {
						em.createNamedStoredProcedureQuery("account_receipt_routines")
								.setParameter("actionType", "tdsReceiveVoucher").setParameter("actionValue", value)
								.execute();
					}

					resp.setCode("201");
					resp.setMessage("Receipt voucher created successfully.");
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
			} else {
				try {
					String value = GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(journalVoucherModel);
					System.out.println("modify=====>>>>" + value);
					em.createNamedStoredProcedureQuery("account_receipt_routines")
							.setParameter("actionType", "modifyReceiptVoucher").setParameter("actionValue", value)
							.execute();
					// }
					resp.setCode("200");
					resp.setMessage("Receipt voucher modified successfully.");
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
			}

		}
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		logger.info("Method : addReceiptVoucher ends");
		return response;
	}

	// JSON view receipt
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewReceiptVoucher(String orgName, String orgDivision) {
		logger.info("Method : viewReceiptVoucher Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values==" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "viewReceiptVoucher").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewReceiptVoucher Dao ends" + resp);
		return resp;

	}

	// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editReceiptInfo(String id, String orgName,
			String orgDivision) {
		logger.info("Method : editReceiptInfo starts");

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();

		try {

			String value = "SET @p_journalVoucher='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "editReceiptInfo").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[11] == null || m[11] == "") {
					m[11] = "";
				}
				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString(), m[13], m[14]);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> response = new ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editReceiptInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> voucherNumber(String orgName, String orgDivision) {
		logger.info("Method : voucherNumber starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getvoucherNumber").setParameter("actionValue", "").getResultList();
			Object jobId = x.get(0);

			DropDownModel dropDownModel = new DropDownModel(jobId, null);
			respList.add(dropDownModel);
			resp.setBody(respList);
			resp.setMessage("Success");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Unsuccess");
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : voucherNumber ends");
		return response;

	}

	/*
	 * getDebitAccountSearch
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getDebitAccountSearch(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getDebitAccountSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getDebitAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				if (m[2] == null || m[2] == "") {
					m[2] = "0";
				}
				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1], m[2].toString(), m[3],
						m[4], null, null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getDebitAccountSearch ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> getCreditAccountSearch(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getCreditAccountSearch starts");

		List<RestContraVoucherModel> itemNameList = new ArrayList<RestContraVoucherModel>();
		JsonResponse<List<RestContraVoucherModel>> resp = new JsonResponse<List<RestContraVoucherModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getCreditAccSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				if (m[2] == "" || m[2] == null) {
					m[2] = "";
				}

				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1], m[2].toString(), m[3],
						m[4], m[5], null, null);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestContraVoucherModel>>> response = new ResponseEntity<JsonResponse<List<RestContraVoucherModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getCreditAccountSearch ends");
		return response;
	}

	// deleteContraDetails

	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteJournalDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String value = "SET @p_receiptId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
						+ "';";
				em.createNamedStoredProcedureQuery("account_receipt_routines")
						.setParameter("actionType", "deleteJournal").setParameter("actionValue", value).execute();

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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  deleteJournalDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewReceiptFilter(String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method : viewReceiptFilter Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +
			// "';";
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("Method : Values-->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "viewReceiptFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewReceiptFilter Dao ends" + resp);
		return resp;

	}

	/* Auto Search for dealer */
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>
	 * getDealerList(String id, String orgName, String orgDiv) {
	 * logger.info("Method : getDealerList starts");
	 * 
	 * List<RestVendorNameListModel> itemNameList = new
	 * ArrayList<RestVendorNameListModel>();
	 * JsonResponse<List<RestVendorNameListModel>> resp = new
	 * JsonResponse<List<RestVendorNameListModel>>(); String value =
	 * "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" +
	 * orgDiv + "';";
	 * 
	 * System.out.println("values ---- " + value);
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_receipt_routines")
	 * .setParameter("actionType", "getDealerName").setParameter("actionValue",
	 * value).getResultList(); for (Object[] m : x) {
	 * 
	 * RestVendorNameListModel dropDownModel = new RestVendorNameListModel(m[0],
	 * m[1], m[2].toString());
	 * 
	 * itemNameList.add(dropDownModel); } // System.out.println("getAllcustomer"
	 * +itemNameList); resp.setBody(itemNameList); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>( resp,
	 * HttpStatus.CREATED); logger.info("Method : getDealerList ends"); return
	 * response; }
	 */

	/* Auto Search for getDistributorList */
	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>
	 * getDistributorList(String id, String orgName, String orgDiv) {
	 * logger.info("Method : getDistributorList starts");
	 * 
	 * List<RestVendorNameListModel> itemNameList = new
	 * ArrayList<RestVendorNameListModel>();
	 * JsonResponse<List<RestVendorNameListModel>> resp = new
	 * JsonResponse<List<RestVendorNameListModel>>(); String value =
	 * "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" +
	 * orgDiv + "';";
	 * 
	 * System.out.println("values ---- " + value);
	 * 
	 * try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_receipt_routines")
	 * .setParameter("actionType", "getDistributorList").setParameter("actionValue",
	 * value) .getResultList(); for (Object[] m : x) {
	 * 
	 * RestVendorNameListModel dropDownModel = new RestVendorNameListModel(m[0],
	 * m[1], m[2].toString());
	 * 
	 * itemNameList.add(dropDownModel); } // System.out.println("getAllcustomer"
	 * +itemNameList); resp.setBody(itemNameList); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> response = new
	 * ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>( resp,
	 * HttpStatus.CREATED); logger.info("Method : getDistributorList ends"); return
	 * response; }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * public
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>
	 * getDelaerOrder(String orgName, String orgDivision, String id) {
	 * logger.info("Method : getDelaerOrder starts");
	 * 
	 * List<RestShoukeenCustomerOrderPaginationModel> getAllemployee = new
	 * ArrayList<RestShoukeenCustomerOrderPaginationModel>();
	 * JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>> resp = new
	 * JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>();
	 * 
	 * String value = "SET @p_orgName='" + orgName + "',@p_orgDivision='" +
	 * orgDivision + "',@p_id='" + id + "';";
	 * 
	 * System.out.println("useriddd========" + value); try {
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_receipt_routines")
	 * .setParameter("actionType", "getDelaerOrder").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * RestShoukeenCustomerOrderPaginationModel viewdemo = new
	 * RestShoukeenCustomerOrderPaginationModel(m[0], m[1].toString(), m[2], m[3],
	 * m[4], m[5], m[6], m[7], m[8]);
	 * 
	 * getAllemployee.add(viewdemo); }
	 * 
	 * resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
	 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
	 * resp.setMessage(e.getMessage()); }
	 * 
	 * resp.setBody(getAllemployee);
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>
	 * response = new
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>(
	 * resp, HttpStatus.CREATED); logger.info("Method : getDelaerOrder ends");
	 * System.out.println("response data is" + response); return response; }
	 * 
	 * @SuppressWarnings("unchecked")
	 * 
	 * public
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>
	 * getDistributorOrder( String orgName, String orgDivision, String id) {
	 * logger.info("Method : getDistributorOrder starts");
	 * 
	 * List<RestShoukeenCustomerOrderPaginationModel> getAllemployee = new
	 * ArrayList<RestShoukeenCustomerOrderPaginationModel>();
	 * JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>> resp = new
	 * JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>();
	 * 
	 * String value = "SET @p_orgName='" + orgName + "',@p_orgDivision='" +
	 * orgDivision + "',@p_id='" + id + "';";
	 * 
	 * System.out.println("useriddd========" + value); try {
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_receipt_routines")
	 * .setParameter("actionType",
	 * "getDistributorOrder").setParameter("actionValue", value) .getResultList();
	 * 
	 * for (Object[] m : x) {
	 * 
	 * RestShoukeenCustomerOrderPaginationModel viewdemo = new
	 * RestShoukeenCustomerOrderPaginationModel(m[0], m[1].toString(), m[2], m[3],
	 * m[4], m[5], m[6], m[7], m[8]);
	 * 
	 * getAllemployee.add(viewdemo); }
	 * 
	 * resp.setCode("Success"); resp.setMessage("Data Fetched Successfully"); }
	 * catch (Exception e) { e.printStackTrace(); resp.setCode("Failed");
	 * resp.setMessage(e.getMessage()); }
	 * 
	 * resp.setBody(getAllemployee);
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>
	 * response = new
	 * ResponseEntity<JsonResponse<List<RestShoukeenCustomerOrderPaginationModel>>>(
	 * resp, HttpStatus.CREATED); logger.info("Method : getDistributorOrder ends");
	 * System.out.println("response data is" + response); return response; }
	 */

	public ResponseEntity<JsonResponse<Object>> addPaymentInvoice(
			RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {

		logger.info("Method in Dao: addPaymentInvoice starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		resp.setMessage("");
		resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateInvoicePaymentParameter.addPaymentParam(restSalesInvoicePaymentModel);
			System.out.println("****value******" + values);
			em.createNamedStoredProcedureQuery("account_receipt_routines").setParameter("actionType", "addPayment")
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
	// addPaymentForUser

	public ResponseEntity<JsonResponse<Object>> addPaymentForUser(
			RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addPaymentForUser starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateInvoicePaymentParameter.addPaymentParamMethod(restSalesInvoicePaymentModel);
				logger.info("value---" + values);

				em.createNamedStoredProcedureQuery("account_receipt_routines")
						.setParameter("actionType", "addPaymentForUser").setParameter("actionValue", values).execute();
				resp.setCode("success");
				resp.setMessage("Data saved successfully");

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

		logger.info("Method :  addPaymentForUser ends" + response);
		// System.out.println("addDebitNoteMethodAdj" + response);
		return response;
	}

//	public JsonResponse<DropDownModel> addPaymentForUser(String userTypeId, String userType,String payingAmount, String adjustment,
//			String userId,String orgName,String orgDivision) {
//		logger.info("Method : addPaymentForUser starts");
//
//		JsonResponse<DropDownModel> resp = new JsonResponse<DropDownModel>();
//		try {
//			String value = "SET @p_userTypeId='" + userTypeId + "',@p_userType='" + userType + "',@p_payingAmount='" + payingAmount + "',@p_adjustment='" + adjustment + "',@p_userId='" + userId + "', @p_org='"
//					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
//			em.createNamedStoredProcedureQuery("account_receipt_routines").setParameter("actionType", "addPaymentForUser")
//					.setParameter("actionValue", value).execute();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		logger.info("Method : addPaymentForUser ends" + resp);
//		return resp;
//	}
	/*
	 * restGetCreditNoteListPayment
	 */
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restGetCreditNoteListPayment(String orgName, String orgDivision, String vendorId) {
		logger.info("Method : restGetCreditNoteListPayment Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_vendorId='" + vendorId
					+ "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getCreditNoteListPayment").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : restGetCreditNoteListPayment Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getCustomerListRest(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getCustomerListRest starts");

		List<RestVendorNameListModel> itemNameList = new ArrayList<RestVendorNameListModel>();
		JsonResponse<List<RestVendorNameListModel>> resp = new JsonResponse<List<RestVendorNameListModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		System.out.println("values ---- " + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getCustomerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestVendorNameListModel dropDownModel = new RestVendorNameListModel(m[0], m[1], m[2].toString());

				itemNameList.add(dropDownModel);
			}
			// System.out.println("getAllcustomer" +itemNameList);
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> response = new ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerListRest ends");
		return response;
	}

	@SuppressWarnings("unchecked")

	public ResponseEntity<JsonResponse<List<AccountCustomerOrderRestModel>>> getCustomerOrderList(String orgName,
			String orgDivision, String id) {
		logger.info("Method : getCustomerOrderList starts");

		List<AccountCustomerOrderRestModel> getAllemployee = new ArrayList<AccountCustomerOrderRestModel>();
		JsonResponse<List<AccountCustomerOrderRestModel>> resp = new JsonResponse<List<AccountCustomerOrderRestModel>>();

		String value = "SET @p_orgName='" + orgName + "',@p_orgDivision='" + orgDivision + "',@p_id='" + id + "';";

		logger.info("useriddd========" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "getCustomerOrder").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AccountCustomerOrderRestModel viewdemo = new AccountCustomerOrderRestModel(m[0], m[1].toString(), m[2],
						m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[11], m[12],m[13]);

				getAllemployee.add(viewdemo);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}

		resp.setBody(getAllemployee);
		ResponseEntity<JsonResponse<List<AccountCustomerOrderRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCustomerOrderRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCustomerOrderList ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> receiptVoucherPdf(String fromDate,
			String toDate, String orgDivision, String orgName) {
		logger.info("Method : receiptVoucherPdf starts");
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		List<RestAccountCreditorLedgerModel> rv = new ArrayList<RestAccountCreditorLedgerModel>();

		String value = "SET @p_orgDiv='" + orgDivision + "',@p_orgName='" + orgName + "',@p_fromDate='"
				+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "receiptVoucherPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAccountCreditorLedgerModel restPayroll = new RestAccountCreditorLedgerModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6], m[7]);

				rv.add(restPayroll);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(rv);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : receiptVoucherPdf ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTdsVoucherListRCV(String id, String orgName, String orgDiv) {
		logger.info("Method : getTdsVoucherListRCV starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String value = "SET @p_ledgerId='" + id + "';";
			String value = "SET @p_orgDiv='" + orgDiv + "',@p_orgName='" + orgName + "',@p_ledgerId='" + id + "';";
			logger.info("values-->" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "TdsList").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTdsVoucherListRCV Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getReceiveInvoiceInfo(String ledgerid, String voucherid, String orgName,
			String orgDiv) {
		logger.info("Method : getReceiveInvoiceInfo starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String value = "SET @p_ledgerId='" + id + "';";
			String value = "SET @p_orgDiv='" + orgDiv + "',@p_orgName='" + orgName + "',@p_ledgerId='" + ledgerid
					+ "',@p_voucherid='" + voucherid + "';";

			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "invoiceListInforReceive").setParameter("actionValue", value)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getReceiveInvoiceInfo Dao ends" + resp);
		return resp;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approveRcptVoucherDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : approveRcptVoucherDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "approvePVoucher").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setBody(null);
				resp.setCode("failed");
				resp.setMessage("Something went wrong");
			}

		} catch (Exception e) {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : approveRcptVoucherDao Dao ends");
		return resp;

	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> receiptVoucherDetailsPdf(String id, String organization, String orgDivision) {
		logger.info("Method : receiptVoucherDetailsPdf Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_orgDiv='" + orgDivision + "', @id='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_receipt_routines")
					.setParameter("actionType", "receiptVoucherDetailsPdf").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
			resp.setCode("failed");
		}
		logger.info("Method : receiptVoucherDetailsPdf Dao ends" + resp);
		return resp;

	}
}
