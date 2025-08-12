package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountReportModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountTrailBalanceModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountReportsDao {
	Logger logger = LoggerFactory.getLogger(RestAccountReportsDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerVoucherReport(String id,
			String orgName, String orgDivision) {
		logger.info("Method : viewLedgerVoucherReport starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("===>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLedgerList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewLedgerVoucherReport ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewDayBookReport(String fromDate,
			String toDate) {
		logger.info("Method : viewDayBookReport starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "viewDayBookReport").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewDayBookReport ends");
		return response;

	}

	// viewCashFlowReport

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewCashFlowReport() {
		logger.info("Method : viewCashFlowReport starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "cashFlowReport").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[1] == null) {
					m[1] = "0";
				}
				if (m[2] == null) {
					m[2] = "0";
				}
				if (m[3] == null) {
					m[3] = "0";
				}
				if (m[4] == null) {
					m[4] = "0";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1].toString(),
						m[2].toString(), m[3].toString(), m[4].toString());
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewCashFlowReport ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerMonthlySummary(String id,
			String orgName, String orgDivision) {
		logger.info("Method : viewLedgerMonthlySummary starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("value---------------" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "viewLedgerMonthlySummary").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				if (m[0] == null) {
					m[0] = "";
				}

				if (m[1] == null) {
					m[1] = "";
				}

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0].toString(),
						m[1].toString(), m[2].toString());
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewLedgerMonthlySummary ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetails(String month,
			String ledgerId, String orgName, String orgDivision) {
		logger.info("Method : viewMothlyDetails starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_month='" + month + "',@p_ledgerId='" + ledgerId + "',@p_orgName='" + orgName
				+ "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("===>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "viewLedgerMonthlyDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5], m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewMothlyDetails ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> trialBalanceReport(String fromDate,
			String toDate) {
		logger.info("Method : trialBalanceReport starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "trialBalanceReport").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5], m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : trialBalanceReport ends");
		return response;

	}

	// profitLossReport

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> profitLossReport(String fromDate,
			String toDate) {
		logger.info("Method : profitLossReport starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "profitLossReport").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0].toString(),
						m[1].toString(), m[2].toString(), m[3].toString(), m[4].toString(), m[5].toString(),
						m[6].toString(), m[7].toString());
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : profitLossReport ends");
		return response;

	}

//		@SuppressWarnings("unchecked")
//		public List<DropDownModel> getVoucherTypeList() {
//
//			logger.info("Method : getVoucherTypeList starts");
//
//			List<DropDownModel> voucherList = new ArrayList<DropDownModel>();
//
//			try {
//				List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
//						.setParameter("actionType", "getVoucherList").setParameter("actionValue", "").getResultList();
//
//				for (Object[] m : x) {
//					DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
//					voucherList.add(dropDownModel);
//				}
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			logger.info("Method : getVoucherTypeList ends" + voucherList);
//			return voucherList;
//		}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerReportWrtVoucherType(String id,
			String voucherType) {
		logger.info("Method : viewLedgerReportWrtVoucherType starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_voucherType='" + voucherType + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLedgerVoucher").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewLedgerReportWrtVoucherType ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewLedgerReportWrtDate(String id,
			String voucherType, String fromDate, String toDate, String orgName, String orgDivision) {
		logger.info("Method : viewLedgerReportWrtDate starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_voucherType='" + voucherType + "',@p_fromDate='" + fromDate
				+ "',@p_toDate='" + toDate + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLedgerDate").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewLedgerReportWrtDate ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> dayBookReportVoucher(String fromDate,
			String toDate, String voucherType) {
		logger.info("Method : dayBookReportVoucher starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_voucherType='" + voucherType + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate
				+ "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "dayBookVoucher").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : dayBookReportVoucher ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> restViewPaymentPlanning(String orgName,
			String orgDivision) {
		logger.info("Method : restViewPaymentPlanning starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("values===>>>" + values);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "viewPaymentPlan").setParameter("actionValue", values).getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4], m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString(), null,
						null, null);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : restViewPaymentPlanning ends");
		return response;

	}

	// invoice lists by vendor
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> getInvoiceListByLedger(String ledgerId,
			String vendorId) {
		logger.info("Method : getInvoiceListByLedger starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String values = "SET @p_ledgerId='" + ledgerId + "',@p_vendorId='" + vendorId + "';";
		logger.info("values==>" + values);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getInvoiceListVendor").setParameter("actionValue", values)
					.getResultList();
			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1].toString(),
						m[2].toString(), m[3].toString(), m[4], m[5], m[6].toString(), null, null, null);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getInvoiceListByLedger ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> profitLossSheetAct(String orgName, String orgDivision) {
		logger.info("Method : profitLossSheetAct Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "profitLossSheetAct").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : profitLossSheetAct Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getChildList(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getChildList starts");

		JsonResponse<List<DataSetAccountTree>> resp = new JsonResponse<List<DataSetAccountTree>>();
		List<DataSetAccountTree> childList = new ArrayList<DataSetAccountTree>();

		try {
			String value = "SET @p_parentid='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value==>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getChildListName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DataSetAccountTree item = new DataSetAccountTree(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6].toString(), null, null);
				childList.add(item);
			}
			resp.setBody(childList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new ResponseEntity<JsonResponse<List<DataSetAccountTree>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getChildList ends");
		System.out.println();
		return response;
	}

	/*
	 * @SuppressWarnings("unchecked") public
	 * ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getParentAmount() {
	 * logger.info("Method : getParentAmount starts");
	 * 
	 * JsonResponse<List<DataSetAccountTree>> resp = new
	 * JsonResponse<List<DataSetAccountTree>>(); List<DataSetAccountTree> childList
	 * = new ArrayList<DataSetAccountTree>();
	 * 
	 * try {
	 * 
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("account_reports_routines")
	 * .setParameter("actionType", "getParentAmount").setParameter("actionValue",
	 * "").getResultList(); for (Object[] m : x) {
	 * 
	 * DataSetAccountTree item = new
	 * DataSetAccountTree(m[0],m[1],m[2],m[3],m[4].toString(),null);
	 * childList.add(item); } resp.setBody(childList);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new
	 * ResponseEntity<JsonResponse<List<DataSetAccountTree>>>( resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("Method : getParentAmount ends"); System.out.println(); return
	 * response; }
	 */

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getParentAmount(String orgName, String orgDiv) {
		logger.info("Method : getParentAmount Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values==>" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getParentAmount").setParameter("actionValue", values).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getParentAmount Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> profitLosssAccountReport(String orgName, String orgDiv) {
		logger.info("Method : profitLosssAccountReport Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "profitLossAmount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : profitLosssAccountReport Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> trailBalanceChild(String id, String orgName,
			String orgDiv, String fromDate, String toDate) {
		logger.info("Method : trailBalanceChild starts");

		JsonResponse<List<DataSetAccountTree>> resp = new JsonResponse<List<DataSetAccountTree>>();
		List<DataSetAccountTree> childList = new ArrayList<DataSetAccountTree>();

		try {

			String value = "SET @p_parentid='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv
					+ "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			logger.info("Method : trailBalanceChild starts" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "trailBalanceChild").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DataSetAccountTree item = new DataSetAccountTree(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6].toString(), m[7].toString(), m[8].toString(), m[9].toString());
				childList.add(item);
			}
			resp.setBody(childList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new ResponseEntity<JsonResponse<List<DataSetAccountTree>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : trailBalanceChild ends");
		System.out.println();
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getTrailBalAmount() {
		logger.info("Method : getTrailBalAmount Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getTrailBalAmount").setParameter("actionValue", "").getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTrailBalAmount Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getDynamicparentlist(String orgName, String orgDiv) {
		logger.info("Method : getDynamicparentlist Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("values==>" + values);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getBalanceSheetList").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getDynamicparentlist Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProfitLossParentList(String orgName, String orgDiv) {
		logger.info("Method : getProfitLossParentList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getProfitlossParentList").setParameter("actionValue", values)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProfitLossParentList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Map<String, Object>> getTrialBalanceParentList(String orgName, String orgDiv, String fromDate,
			String toDate) {
		logger.info("Method : getTrialBalanceParentList Dao starts");

		// JsonResponse<Object> resp = new JsonResponse<Object>();

		JsonResponse<Map<String, Object>> resp = new JsonResponse<>();
		Map<String, Object> resultMap = new HashMap<>();
		String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_fromDate='" + fromDate
				+ "',@p_toDate='" + toDate + "';";
		logger.info("values-->" + values);

		try {
			/*
			 * List<Object[]> x =
			 * em.createNamedStoredProcedureQuery("account_reports_routines")
			 * .setParameter("actionType", "getTrailBalAmount").setParameter("actionValue",
			 * values) .getResultList(); resp.setBody(x.get(0)); resp.setCode("success");
			 * resp.setMessage("Data fetched successfully");
			 */

			List<Object[]> result1 = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getTrailBalAmount").setParameter("actionValue", values)
					.getResultList();

			logger.info(result1.toString());
			resultMap.put("jsonResult1", result1.get(0));

			// Assuming the stored procedure or call is modified to fetch both results
			// separately

			List<Object[]> result2 = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getTrailBalAmountForParent").setParameter("actionValue", values)
					.getResultList();
			resultMap.put("jsonResult2", result2.get(0));

			resp.setBody(resultMap);
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getTrialBalanceParentList Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getLedgerListBSheet(String groupId, String orgName, String orgDivision) {
		logger.info("Method : getLedgerListBSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_groupId='" + groupId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values****" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLedgerListBSheet").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("Success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getLedgerListBSheet Dao ends");
		System.out.println("resp*" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewMothlyDetailsFilterData(String fromDate,
			String toDate, String ledgerId, String orgName, String orgDivision) {
		logger.info("Method : viewMothlyDetailsFilterData starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "',@p_ledgerId='" + ledgerId
				+ "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		try {
			logger.info("===>>>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "viewLedgerFilterData").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5], m[6]);
				respList.add(restPayroll);
			}
			logger.info("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewMothlyDetailsFilterData ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> dayBookReportFilterData(String inputDate,
			String orgName, String orgDivision) {
		logger.info("Method : dayBookReportFilterData starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_inputDate='" + inputDate + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
				+ "';";
		logger.info("values--->" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "dayBookVoucherFilter").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6]);
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : dayBookReportFilterData ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> dayBookPdfData(String inputDate, String orgName,
			String orgDivision) {
		logger.info("Method : dayBookPdfData starts");
		JsonResponse<List<RestAccountReportModel>> resp = new JsonResponse<List<RestAccountReportModel>>();
		List<RestAccountReportModel> rs = new ArrayList<RestAccountReportModel>();

		String value = "SET @p_inputDate='" + inputDate + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
				+ "';";

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "dayBookPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAccountReportModel restPayroll = new RestAccountReportModel(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6], m[7], m[8], m[9]);

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

		ResponseEntity<JsonResponse<List<RestAccountReportModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : dayBookPdfData ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> ledgerVoucherPdfData(String ledgerId,
			String voucherType, String fromDate, String toDate, String orgName, String orgDivision) {
		logger.info("Method : ledgerVoucherPdfDao starts");
		JsonResponse<List<RestAccountReportModel>> resp = new JsonResponse<List<RestAccountReportModel>>();
		List<RestAccountReportModel> rs = new ArrayList<RestAccountReportModel>();

		String value = "SET @p_ledgerId='" + ledgerId + "',@p_voucherType='" + voucherType + "',@p_fromDate='"
				+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate)
				+ "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		logger.info("values-->" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "ledgerVoucherPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestAccountReportModel restPayroll = new RestAccountReportModel(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6], m[7], m[8], m[9]);

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

		ResponseEntity<JsonResponse<List<RestAccountReportModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : ledgerVoucherPdfDao ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountReportModel>>> accountStatementPdf(String ledgerid,
			String fromDate, String toDate, String month, String orgName, String orgDivision) {
		logger.info("Method : accountStatementPdfDao starts");
		JsonResponse<List<RestAccountReportModel>> resp = new JsonResponse<List<RestAccountReportModel>>();
		List<RestAccountReportModel> rs = new ArrayList<RestAccountReportModel>();

		String value = "SET @p_ledgerId='" + ledgerid + "',@p_fromDate='" + fromDate + "',@p_month='" + month
				+ "',@p_toDate='" + toDate + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		logger.info("value-->" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "accountStatementPdf").setParameter("actionValue", value)
					.getResultList();

			for (Object[] m : x) {

				RestAccountReportModel restPayroll = new RestAccountReportModel(m[0], m[1], m[2], m[3], m[4].toString(),
						m[5].toString(), m[6], m[7], m[8], m[9]);

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

		ResponseEntity<JsonResponse<List<RestAccountReportModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountReportModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : accountStatementPdfDao ends" + response);
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getVoucherDetailsBSheet(String voucherId, String voucherType, String orgName,
			String orgDivision) {
		logger.info("Method : getVoucherDetailsBSheet Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_voucherId='" + voucherId + "',@p_voucherType='" + voucherType + "',@p_orgName='"
					+ orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values--->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getVoucherDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getVoucherDetailsBSheet Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> proposeAmountAdd(String selectedRowData, String vendorId, String orgName,
			String orgDivision) {
		logger.info("Method : proposeAmountAdd Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_selectedRowData='" + selectedRowData + "',@p_vendorId='" + vendorId
					+ "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values--->" + value);
			logger.info("vendorId dao--->" + vendorId);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "proposeAmountInsert").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : proposeAmountAdd Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getProposeAmountDetails(String vendorId, String orgName, String orgDivision) {
		logger.info("Method : getProposeAmountDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_vendorId='" + vendorId + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			logger.info("values--->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "proposeAmountDetails").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getProposeAmountDetails Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getLevelOne(RestAccountTrailBalanceModel tBModel, String orgName,
			String orgDivision) {
		logger.info("Method : getLevelOne starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
		List<String> empty = new ArrayList<String>();

		try {

			String values = "SET @P_START_DATE = '" + tBModel.getStart_date() + "', @P_END_DATE = '"
					+ tBModel.getEnd_date() + "', @P_ORG = '" + orgName + "', @P_ORG_DIV = '" + orgDivision + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLevelOne").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				jsonResponse.setBody(x);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data found");
			} else {
				jsonResponse.setBody(empty);
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Data not found");
			}

		} catch (Exception e) {
			jsonResponse.setBody(empty);
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Something went wrong");
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : getLevelOne ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getTrialBalanceRows(RestAccountTrailBalanceModel tBModel, String orgName,
			String orgDivision) {
		logger.info("Method : getTrialBalanceRows starts");
		
		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
		List<String> empty = new ArrayList<String>();
		
		try {
			
			String values = "SET @P_START_DATE = '" + tBModel.getStart_date() + "', @P_END_DATE = '"
					+ tBModel.getEnd_date() + "', @P_ORG = '" + orgName + "', @P_ORG_DIV = '" + orgDivision + "';";
			
			System.out.println(values);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getTrialBalData").setParameter("actionValue", values).getResultList();
			
			if (x.size() > 0) {
				jsonResponse.setBody(x.get(0));
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data found");
			} else {
				jsonResponse.setBody(empty);
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Data not found");
			}
			
		} catch (Exception e) {
			jsonResponse.setBody(empty);
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Something went wrong");
			e.printStackTrace();
		}
		
		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);
		
		logger.info("Method : getTrialBalanceRows ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> getLevelOthers(RestAccountTrailBalanceModel tBModel, String orgName,
			String orgDivision) {
		logger.info("Method : getLevelOthers starts");

		JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
		List<String> empty = new ArrayList<String>();

		try {

			String values = "SET @P_START_DATE = '" + tBModel.getStart_date() + "', @P_END_DATE = '"
					+ tBModel.getEnd_date() + "', @P_ORG = '" + orgName + "', @P_ORG_DIV = '" + orgDivision
					+ "', @P_GROUP_ID = '" + tBModel.getGroup_id() + "';";

			System.out.println(values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getLevelOthers").setParameter("actionValue", values).getResultList();

			if (x.size() > 0) {
				jsonResponse.setBody(x);
				jsonResponse.setCode("success");
				jsonResponse.setMessage("Data found");
			} else {
				jsonResponse.setBody(empty);
				jsonResponse.setCode("failed");
				jsonResponse.setMessage("Data not found");
			}

		} catch (Exception e) {
			jsonResponse.setBody(empty);
			jsonResponse.setCode("failed");
			jsonResponse.setMessage("Something went wrong");
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(jsonResponse,
				HttpStatus.OK);

		logger.info("Method : getLevelOthers ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> viewTrailBalanceLedger(String id,
			String orgName, String orgDivision, String fromdate, String todate) {
		logger.info("Method : viewTrailBalanceLedger starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision
				+ "',@p_formDate='" + fromdate + "',@p_todate='" + todate + "';";
		System.out.println("===>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getTrailBalanceLedger").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				if (m[0] == null || m[1] == null || m[3] == null || m[4] == null) {
					m[0] = "";
					m[1] = "";
					m[2] = "";
					m[3] = "";
					m[4] = "";
				}
				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2],
						m[3].toString(), m[4].toString(), m[5].toString());
				respList.add(restPayroll);
			}
			System.out.println("VIEW" + respList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : viewTrailBalanceLedger ends");
		return response;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> AccountReportList(String orgName, String orgDivision, String id) {
		logger.info("Method : AccountReportList Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {

			String value = "SET @p_orgName ='" + orgName + "',@p_orgDiv ='" + orgDivision + "';";
			logger.info("Values are: {}", value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getAccountReportsData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : AccountReportList Dao ends");
		return resp;
	}
}
