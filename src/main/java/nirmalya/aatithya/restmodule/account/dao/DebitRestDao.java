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

import nirmalya.aatithya.restmodule.account.model.RestDebitLedgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class DebitRestDao {

	Logger logger = LoggerFactory.getLogger(RestAccountCreditNoteDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	@SuppressWarnings("unchecked")
	public List<DropDownModel> getfiscalList() {
		logger.info("Method : getfiscalList starts");

		List<DropDownModel> getfiscalList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "financialYear").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				getfiscalList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getPaymentModeList ends");

		System.out.println("getOrderStatusList=======>" + getfiscalList);
		return getfiscalList;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewDebit(String orgName, String orgDivision) {
		logger.info("Method : viewDebit Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "viewDebit").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
			System.out.print("hhhhhhhhhhhhhhhhh" + x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewDebit Dao ends");
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> debitviewFilter(String orgName, String orgDivision, String financialYear,
			String fromDate, String toDate) {
		logger.info("Method : creditorsLedgerFilter Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_financialYear='"
					+ financialYear + "',@p_fromDate='" + fromDate + "',@p_toDate='" + toDate + "';";
			logger.info("values****************************" + value);

			if (financialYear != "" && fromDate != "" && toDate != "") {
				List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
						.setParameter("actionType", "debitfdatetyear").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			} else if (financialYear == "" && fromDate != "" && toDate != "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
						.setParameter("actionType", "viewByfDatetDate").setParameter("actionValue", value)
						.getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");

			}

			else if (financialYear != "" && fromDate == "" && toDate == "") {

				List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
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
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> getDebitgetVenderList(String id) {
		logger.info("Method : getDebitgetVenderList starts");

		List<RestDebitLedgerModel> itemNameList = new ArrayList<RestDebitLedgerModel>();
		JsonResponse<List<RestDebitLedgerModel>> resp = new JsonResponse<List<RestDebitLedgerModel>>();
		String value = "SET @p_searchValue='" + id + "';";
		System.out.println("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "getDeberList").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestDebitLedgerModel viewdemo = new RestDebitLedgerModel(m[0], m[1]);
				System.out.print("hhhhhhhhhhhhhhhhhhhh" + viewdemo);
				itemNameList.add(viewdemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getDebitgetVenderList ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> debitledgerpdf(String id, String fromDate,
			String toDate) {

		logger.info("Method : debitledgerpdf starts" + id);

		JsonResponse<List<RestDebitLedgerModel>> resp = new JsonResponse<List<RestDebitLedgerModel>>();
		List<RestDebitLedgerModel> rs = new ArrayList<RestDebitLedgerModel>();
		// String value = "SET @p_dealerId='" + id + "';";
		String value = "SET @p_dealerId='" + id + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
				+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

		System.out.println("value====" + value);

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("credit_notes_routines")
					.setParameter("actionType", "debitledgerpdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				RestDebitLedgerModel restPayroll = new RestDebitLedgerModel(m[0].toString(), m[1], m[2],
						m[3].toString(), m[4], m[5], m[6].toString(), m[7].toString(), m[8].toString(), m[9], m[10],
						m[11]);

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

		ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>> response = new ResponseEntity<JsonResponse<List<RestDebitLedgerModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : debitledgerpdf ends" + response);
		System.out.println(response);
		return response;
	}

}