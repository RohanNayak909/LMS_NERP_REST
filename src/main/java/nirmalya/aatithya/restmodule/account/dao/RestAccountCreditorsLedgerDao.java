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

import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class RestAccountCreditorsLedgerDao {

	Logger logger = LoggerFactory.getLogger(RestAccountCreditorsLedgerDao.class);

	@Autowired
	private EntityManager em;

	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCreditLedger(String orgName, String orgDivision) {
		logger.info("Method : viewCreditLedger Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
					.setParameter("actionType", "viewCredir").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewCreditLedger Dao ends" + resp);
		return resp;

	}

	// creditorsLedgerFilter

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> creditorsLedgerFilter(String orgName, String orgDivision, String financialYear,
			String fromDate, String toDate) {
		logger.info("Method : creditorsLedgerFilter Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_financialYear='"
					+ financialYear + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);

			if (financialYear != "" && fromDate != "" && toDate != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
						.setParameter("actionType", "yearfDatetDate").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			} else if (financialYear == "" && fromDate != "" && toDate != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
						.setParameter("actionType", "viewByfDatetDate").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			}

			else if (financialYear != "" && fromDate == "" && toDate == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
						.setParameter("actionType", "viewByFinancialYear").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			}
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : creditorsLedgerFilter Dao ends" + resp);
		return resp;

	}

	// getVendorAutoList

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> getVendorAutoList(String id) {
		logger.info("Method : getVendorAutoList starts");

		List<RestAccountCreditorLedgerModel> itemNameList = new ArrayList<RestAccountCreditorLedgerModel>();
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
					.setParameter("actionType", "getVendor").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestAccountCreditorLedgerModel viewDemo = new RestAccountCreditorLedgerModel(m[0], m[1]);

				itemNameList.add(viewDemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getVendorAutoList ends" + resp);
		return response;
	}
	// vendorCreditorLedgerPdf

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> vendorCreditorLedgerPdf(String id,
			String fromDate, String toDate) {
		logger.info("Method : vendorCreditorLedgerPdf starts" + id);
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		List<RestAccountCreditorLedgerModel> rs = new ArrayList<RestAccountCreditorLedgerModel>();

		String value = "SET @p_vendorId='" + id + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
				+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

		// logger.info("set data ========" + fromDate);
		logger.info("set data ========" + value);
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("view_credit_ledger_mstr")
					.setParameter("actionType", "pdfView").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[4] == null) {
					m[4] = " ";
				}
				if (m[5] == null) {
					m[5] = " ";
				}
				if (m[6] == null) {
					m[6] = "N/A";
				}
				if (m[7] == null) {
					m[7] = "N/A";
				}

				if (m[8] == null) {
					m[8] = " ";
				}

				if (m[9] == null) {
					m[9] = "N/A";
				}
				if (m[10] == null) {
					m[10] = "N/A";
				}
				if (m[11] == null) {
					m[11] = "N/A";
				}

				RestAccountCreditorLedgerModel restPayroll = new RestAccountCreditorLedgerModel(m[0].toString(), m[1],
						m[2], m[3].toString(), m[4], m[5], m[6].toString(), m[7].toString(), m[8].toString(), m[9],
						m[10], m[11]);

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

		logger.info("Method : vendorCreditorLedgerPdf ends");
		logger.info("response >>>>>>>>>>>" + response);
		return response;
	}

}
