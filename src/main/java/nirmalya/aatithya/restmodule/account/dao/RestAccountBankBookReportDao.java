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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.model.AccountLedgerReportRestModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "account" })
public class RestAccountBankBookReportDao {
	
	Logger logger = LoggerFactory.getLogger(RestAccountBankBookReportDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> viewLeadger(String orgName, String orgDivision) {
		logger.info("Method : restbankBookReportDetails starts");
		
		List<RestManageLeadgerModel> respList = new ArrayList<RestManageLeadgerModel>();

		try {
			String values = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "bankBookReport").setParameter("actionValue", values).getResultList();
			
			for (Object[] m : x) {

				RestManageLeadgerModel restPayroll = new RestManageLeadgerModel(m[0], m[1], m[2], m[3], m[4],
						m[5],m[6]);
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestManageLeadgerModel>> resp = new JsonResponse<List<RestManageLeadgerModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> response = new ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restbankBookReportDetails ends");

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> bankFilterData(String id,
			String voucherType, String fromDate, String toDate,String orgName,String orgDivision) {
		logger.info("Method : bankFilterData dao starts");
		List<AccountLedgerReportRestModel> respList = new ArrayList<AccountLedgerReportRestModel>();

		String value = "SET @p_ledgerId='" + id + "',@p_voucherType='" + voucherType + "',@p_fromDate='" + fromDate
				+ "',@p_toDate='" + toDate + "',@p_orgName='" + orgName +"',@p_orgDiv='" + orgDivision + "';";
		System.out.println("===>>>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "getbankFilterData").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0], m[1], m[2], m[3],
						m[4].toString(), m[5].toString(), m[6],m[7].toString(),m[8],null,null);
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
		logger.info("Method : bankFilterData dao ends");
		return response;

	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> ledgerStatementPdf(String id,String voucherType,
			String fromDate, String toDate,String orgName,String orgDivision) {
		logger.info("Method : ledgerStatementPdf starts" + id);

		JsonResponse<List<AccountLedgerReportRestModel>> resp = new JsonResponse<List<AccountLedgerReportRestModel>>();
		List<AccountLedgerReportRestModel> rs = new ArrayList<AccountLedgerReportRestModel>();
		String value = "SET @p_ledgerId='" + id+"',@p_voucherType='"+ voucherType + "',@p_fromDate='" + fromDate
				+ "',@p_toDate='" + toDate + "',@p_orgName='" + orgName +  "',@p_orgDiv='" + orgDivision + "';";

		System.out.println("value====" + value);
		
		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_reports_routines")
					.setParameter("actionType", "bankStatementPdf").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				AccountLedgerReportRestModel restPayroll = new AccountLedgerReportRestModel(m[0],
						m[1], m[2], m[3].toString(), m[4], m[5], m[6]);

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

		ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountLedgerReportRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : ledgerStatementPdf ends" + response);
		System.out.println(response);
		return response;
	}
}
