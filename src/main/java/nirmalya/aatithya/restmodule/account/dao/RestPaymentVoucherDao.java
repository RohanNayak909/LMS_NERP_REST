package nirmalya.aatithya.restmodule.account.dao;

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

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestSalesInvoicePaymentModel;
import nirmalya.aatithya.restmodule.account.model.RestVendorNameListModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateInvoicePaymentParameter;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@Repository
public class RestPaymentVoucherDao {
	Logger logger = LoggerFactory.getLogger(RestPaymentVoucherDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
	 * List<AccountJournalVoucherModel> journalVoucherModel) {
	 * logger.info("Method : addPaymentVoucher starts");
	 * 
	 * @SuppressWarnings("unused") List<DropDownModel> dropDownModel = new
	 * ArrayList<DropDownModel>(); boolean validation = true; JsonResponse<Object>
	 * resp = new JsonResponse<Object>(); resp.setMessage(""); resp.setCode("");
	 * 
	 * for (AccountJournalVoucherModel l : journalVoucherModel) { if
	 * (l.getCostCenter() == null || l.getCostCenter() == "") { validation = false;
	 * resp.setCode("Field Validation Error");
	 * resp.setMessage("Please Select Cost Center."); break; } else if
	 * (l.getDescription() == null || l.getDescription() == "") { validation =
	 * false; resp.setCode("Field Validation Error");
	 * resp.setMessage("Please Enter Description."); break; } }
	 * 
	 * if (validation) {
	 * 
	 * if(journalVoucherModel.get(0).getJournalVoucher() ==null ||
	 * journalVoucherModel.get(0).getJournalVoucher() =="") { try { String value =
	 * GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(
	 * journalVoucherModel); System.out.println("Add=====>>>>"+value);
	 * em.createNamedStoredProcedureQuery("account_payment_routines")
	 * .setParameter("actionType", "addPaymentVoucher").setParameter("actionValue",
	 * value).execute(); // } } catch (Exception e) { try { String[] err =
	 * serverDao.errorProcedureCall(e); resp.setCode(err[0]);
	 * resp.setMessage(err[1]); } catch (Exception e1) { e1.printStackTrace(); }
	 * e.printStackTrace(); } }else { try { String value =
	 * GenerateAccountJournalVoucherParameter.saveJournalVoucherParam(
	 * journalVoucherModel); System.out.println("modify=====>>>>"+value);
	 * em.createNamedStoredProcedureQuery("account_payment_routines")
	 * .setParameter("actionType",
	 * "modifyPaymentVoucher").setParameter("actionValue", value).execute(); // } }
	 * catch (Exception e) { try { String[] err = serverDao.errorProcedureCall(e);
	 * resp.setCode(err[0]); resp.setMessage(err[1]); } catch (Exception e1) {
	 * e1.printStackTrace(); } e.printStackTrace(); } }
	 * 
	 * } ResponseEntity<JsonResponse<Object>> response = new
	 * ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	 * logger.info("Method : addPaymentVoucher ends"); return response; }
	 */

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	@SuppressWarnings("unused")
	public ResponseEntity<JsonResponse<Object>> addPaymentVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : addPaymentVoucher starts");
		System.out.println("sdfddsfdf=====>>>>" + journalVoucherModel);

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
					logger.info("Add=====>>>>" + value);

					if ("".equals(journalVoucherModel.get(0).getTaxType())) {

						em.createNamedStoredProcedureQuery("account_payment_routines")
								.setParameter("actionType", "multiPaymentVchr").setParameter("actionValue", value)
								.execute();
					} // addPaymentVoucher
					else {

						em.createNamedStoredProcedureQuery("account_payment_routines")
								.setParameter("actionType", "tdsPaymentVoucher").setParameter("actionValue", value)
								.execute();
					}
					// }
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
					logger.info("modify=====>>>>" + value);
					em.createNamedStoredProcedureQuery("account_payment_routines")
							.setParameter("actionType", "modifyPaymentVoucher").setParameter("actionValue", value)
							.execute();
					// }
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
		logger.info("Method : addPaymentVoucher ends");
		return response;
	}

	// restViewJournalVoucher

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restViewPaymentDetails(String orgName, String orgDivision) {
		logger.info("Method : restViewPaymentDetails Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println(values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getPaymentDetails").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restViewPaymentDetails Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editPaymentInfo(String id, String orgName,
			String orgDivision) {
		logger.info("Method : editPaymentInfo starts");
		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();
		try {

			String value = "SET @p_journalVoucher='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "editPaymentInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[11] == null || m[11] == "") {
					m[11] = "";
				}

//				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
//						m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString());
//				rs.add(restPayroll);
				
				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString(),m[13],null,null,null,null);
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

		logger.info("Method : editPaymentInfo ends");

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
			logger.info("values-->" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getvoucherNumber").setParameter("actionValue", values).getResultList();
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
		String value = "SET @p_searchValue='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getDebitAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[2] == null || m[2] == "") {
					m[2] = "0";
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getCreditAccSearch").setParameter("actionValue", value)
					.getResultList();
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
				String value = "SET @p_payId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("account_payment_routines")
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
	public JsonResponse<Object> restViewPaymentFilter(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : restViewPaymentFilter Dao startss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +
			// "';";
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("Method : VALUES-->" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getPaymentFilter").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restViewPaymentFilter Dao ends" + resp);
		return resp;

	}

	/* Get Vendor Name DropDown list */

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorName() {
	 * logger.info("Method : getVendorName starts"); List<DropDownModel> vendorList
	 * = new ArrayList<DropDownModel>(); JsonResponse<List<DropDownModel>> resp =
	 * new JsonResponse<List<DropDownModel>>(); try { List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_payment_routines")
	 * .setParameter("actionType", "vendornameList").setParameter("actionValue",
	 * "").getResultList();
	 * 
	 * for (Object[] m : x) { DropDownModel dropDownModel = new DropDownModel(m[0],
	 * m[1]); vendorList.add(dropDownModel); } resp.setBody(vendorList); } catch
	 * (Exception e) { e.printStackTrace(); }
	 * ResponseEntity<JsonResponse<List<DropDownModel>>> response = new
	 * ResponseEntity<JsonResponse<List<DropDownModel>>>( resp, HttpStatus.CREATED);
	 * System.out.println("response" + response);
	 * logger.info("Method : getVendorName ends"); return response;
	 * 
	 * }
	 */

	/* Get All Invoice List */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> invoiceList(String orgName, String orgDivision, String id) {
		logger.info("Method : invoiceList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_vendorid='" + id + "';";
			System.out.println("value--" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "invoiceList").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : invoiceList Dao ends");
		return resp;

	}

	/* Auto Search */
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> getVendorNameList(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getVendorNameList starts");

		List<RestVendorNameListModel> itemNameList = new ArrayList<RestVendorNameListModel>();
		JsonResponse<List<RestVendorNameListModel>> resp = new JsonResponse<List<RestVendorNameListModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		logger.info("values-->" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getVendorName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestVendorNameListModel dropDownModel = new RestVendorNameListModel(m[0], m[1], m[2].toString());

				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestVendorNameListModel>>> response = new ResponseEntity<JsonResponse<List<RestVendorNameListModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorNameList ends");
		return response;
	}

	public ResponseEntity<JsonResponse<Object>> addDebitNoteMethodAdj(
			RestSalesInvoicePaymentModel restSalesInvoicePaymentModel) {
		logger.info("Method : addDebitNoteMethodAdj starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");
		if (validity)
			try {
				String values = GenerateInvoicePaymentParameter.addSendPaymentParamMethod(restSalesInvoicePaymentModel);
				logger.info("value---" + values);

				em.createNamedStoredProcedureQuery("account_payment_routines").setParameter("actionType", "")
						.setParameter("actionValue", values).execute();
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

		logger.info("Method :  addDebitNoteMethodAdj ends" + response);
		// System.out.println("addDebitNoteMethodAdj" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restGetDebitNoteListPayment(String orgName, String orgDivision, String vendorId) {
		logger.info("Method : restGetDebitNoteListPayment Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +
			// "';";
			String values = "SET @p_vendorId='" + vendorId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getDebitNoteList").setParameter("actionValue", values).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restGetDebitNoteListPayment Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getBankAccountPaymentList(String orgName, String orgDivision) {

		logger.info("Method : getBankAccountPaymentList starts");

		List<DropDownModel> voucherList = new ArrayList<DropDownModel>();
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getBankAccount").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2].toString());
				voucherList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getBankAccountPaymentList ends");
		return voucherList;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> paymentVoucherPdf(String fromDate,
			String toDate, String orgDivision, String orgName) {
		logger.info("Method : paymentVoucherPdf starts");
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		List<RestAccountCreditorLedgerModel> rs = new ArrayList<RestAccountCreditorLedgerModel>();

		String value = "SET @p_orgDiv='" + orgDivision + "',@p_orgName='" + orgName + "',@p_fromDate='"
				+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";
		logger.info("value" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "paymentVoucherPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAccountCreditorLedgerModel restPayroll = new RestAccountCreditorLedgerModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6], m[7]);

				rs.add(restPayroll);
			}

			resp.setCode("Success");
			resp.setMessage("Data Fetched Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("Failed");
			resp.setMessage(e.getMessage());
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);
		logger.info("Method : paymentVoucherPdf ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTdsVoucherList(String id, String orgName, String orgDiv) {
		logger.info("Method : getTdsVoucherList starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String value = "SET @p_ledgerId='" + id + "';";
			String value = "SET @p_orgDiv='" + orgDiv + "',@p_orgName='" + orgName + "',@p_ledgerId='" + id + "';";

			logger.info("values-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "getTdsList").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTdsVoucherList Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getPayInvoiceInfo(String ledgerid, String voucherid, String orgName, String orgDiv) {
		logger.info("Method : getPayInvoiceInfo starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String value = "SET @p_ledgerId='" + id + "';";
			String value = "SET @p_orgDiv='" + orgDiv + "',@p_orgName='" + orgName + "',@p_ledgerId='" + ledgerid
					+ "',@p_voucherid='" + voucherid + "';";

			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "invoiceListInfo").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getPayInvoiceInfo Dao ends" + resp);
		return resp;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> PaymentVoucherDetailsPdf(String id, String organization, String orgDivision) {
		logger.info("Method : PaymentVoucherDetailsPdf Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + organization + "', @p_orgDiv='" + orgDivision + "', @id='" + id + "';";
			System.out.println(value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
					.setParameter("actionType", "PaymentVoucherDetailsPdf").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
			resp.setCode("failed");
		}
		logger.info("Method : PaymentVoucherDetailsPdf Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> approvePayVoucherDao(String orgName, String orgDiv, String userId, String data) {
		logger.info("Method : approvePayVoucherDao Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "', @p_userId='" + userId
					+ "', @p_data='" + data + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_payment_routines")
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

		logger.info("Method : approvePayVoucherDao Dao ends");
		return resp;

	}

}
