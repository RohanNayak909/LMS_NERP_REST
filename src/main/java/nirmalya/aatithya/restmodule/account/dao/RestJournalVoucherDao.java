
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.AccountJournalVoucherModel;
import nirmalya.aatithya.restmodule.account.model.DataSetAccountTree;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountCreditorLedgerModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.account.model.RestContraVoucherModel;
import nirmalya.aatithya.restmodule.account.model.RestManageLeadgerModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DateFormatter;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountJournalVoucherParameter;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import org.springframework.http.HttpHeaders;

@Repository
public class RestJournalVoucherDao {

	Logger logger = LoggerFactory.getLogger(RestJournalVoucherDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	// addJournalVoucher

	/**
	 * DAO Function to Add Issue Note in inventory
	 */
	public ResponseEntity<JsonResponse<Object>> addJournalVoucher(
			List<AccountJournalVoucherModel> journalVoucherModel) {
		logger.info("Method : saveJournalVoucher starts");
		System.out.println("sdfddsfdf=====>>>>" + journalVoucherModel);
		@SuppressWarnings("unused")
		List<DropDownModel> dropDownModel = new ArrayList<DropDownModel>();
		boolean validation = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		resp.setMessage("");
		resp.setCode("");

		for (AccountJournalVoucherModel l : journalVoucherModel) {
			if (l.getCostCenter() == null || l.getCostCenter() == "") {
				validation = false;
				resp.setCode("Field Validation Error");
				resp.setMessage("Please Select Cost Center.");
				break;
			} else if (l.getDescription() == null || l.getDescription() == "") {
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
					em.createNamedStoredProcedureQuery("journalvoucherRoutines")
							.setParameter("actionType", "addJournalVoucher").setParameter("actionValue", value)
							.execute();
					// }

					resp.setCode("201");
					resp.setMessage("Journal voucher created successfully.");
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
					em.createNamedStoredProcedureQuery("journalvoucherRoutines")
							.setParameter("actionType", "modifyJournalVoucher").setParameter("actionValue", value)
							.execute();
					// }
					
					resp.setCode("200");
					resp.setMessage("Journal voucher modified successfully.");
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
		logger.info("Method : saveJournalVoucher ends");
		return response;
	}

	// JSON view JournalVoucher
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restViewJournalVoucher(String orgName, String orgDivision) {
		logger.info("Method : restViewJournalVoucher Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "viewJournalVoucher").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restViewJournalVoucher Dao ends" + resp);
		return resp;

	}

	// deleteContraDetails

	public ResponseEntity<JsonResponse<Object>> deleteJournalDetails(String id, String orgName, String orgDivision) {
		logger.info("Method : deleteJournalDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();

		if (validity)
			try {
				String value = "SET @p_jrnlId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				System.out.println("ID...." + value);
				em.createNamedStoredProcedureQuery("journalvoucherRoutines").setParameter("actionType", "deleteJournal")
						.setParameter("actionValue", value).execute();

				resp.setCode("200");
				resp.setMessage("Journal voucher deleted successfully.");

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
	// approveJournalDetails

	public ResponseEntity<JsonResponse<Object>> approveJournalDetails(String id, String userId) {
		logger.info("Method : approveJournalDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_journalVId='" + id + "',@p_userId='" + userId + "';";

				System.out.println("value...." + value);

				em.createNamedStoredProcedureQuery("journalvoucherRoutines").setParameter("actionType", "JVToApprove")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Approved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  approveJournalDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// rejectJournalDetails

	public ResponseEntity<JsonResponse<Object>> rejectJournalDetails(String id, String userId) {
		logger.info("Method : rejectJournalDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {
				String value = "SET  @p_journalVId='" + id + "',@p_userId='" + userId + "';";

				em.createNamedStoredProcedureQuery("journalvoucherRoutines")
						.setParameter("actionType", "rejectJournalVoucher").setParameter("actionValue", value)
						.execute();

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
			resp.setMessage("Reject successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  rejectJournalDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// returnJournalDetails

	public ResponseEntity<JsonResponse<Object>> returnJournalDetails(String id) {
		logger.info("Method : returnJournalDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {
				String value = "SET  @p_journalVId='(" + id + ")';";
				em.createNamedStoredProcedureQuery("journalvoucherRoutines").setParameter("actionType", "returnJournal")
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

		if (resp.getMessage() == null) {
			resp.setMessage("Deleted successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method :  returnJournalDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editJournalInfo(String id, String orgName,
			String orgDivision) {
		logger.info("Method : editJournalInfo starts");

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();

		try {

			String value = "SET @p_journalVoucher='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision
					+ "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "editJournalInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[11] == null || m[11] == "") {
					m[11] = "";
				}

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						m[5], m[6], m[7], m[8], m[9], m[10], m[11].toString(), m[12].toString(), m[13], m[14], m[15]);
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

		logger.info("Method : editJournalInfo ends");

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
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getvouchernumber(String orgName, String orgDivision) {
		logger.info("Method : getvouchernumber starts");
		List<DropDownModel> respList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		try {
			String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getVoucherNumber").setParameter("actionValue", values).getResultList();
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
		logger.info("Method : getvouchernumber ends");
		System.out.println("VIEWWWWWWWW" + respList);
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
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getDebitAccSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				RestContraVoucherModel dropDownModel = new RestContraVoucherModel(m[0], m[1], m[2], m[3], null, null,
						null);
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
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getCreditAccSearch").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
//				RestContraVoucherModel dropDownModel = new  RestContraVoucherModel(m[0], m[1],m[2],m[3],null,null,null);
//				itemNameList.add(dropDownModel);

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

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> restViewJournalFilter(String orgName, String orgDivision, String fromDate,
			String toDate) {
		logger.info("Method : restViewJournalFilter Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String values = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +
			// "';";
			String values = "SET @p_org='" + orgName + "',@p_fromDate='" + DateFormatter.getStringDate(fromDate)
					+ "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("Method : values-->" + values);

			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "viewJournalFilter").setParameter("actionValue", values)
					.getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : restViewJournalFilter Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestManageLeadgerModel>>> restGetLedgerDetails() {
		logger.info("Method : restGetLedgerDetails starts");

		System.out.println("rest bank DAO-------------------------------------------------------------2222222222");
		List<RestManageLeadgerModel> respList = new ArrayList<RestManageLeadgerModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getLedgerDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestManageLeadgerModel restPayroll = new RestManageLeadgerModel(m[0], m[1]);
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
		logger.info("Method : restGetLedgerDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DataSetAccountTree>>> getAccountCategory(String orgName,
			String orgDivision) {
		logger.info("Method : getAccountCategoryListModal starts");

		JsonResponse<List<DataSetAccountTree>> resp = new JsonResponse<List<DataSetAccountTree>>();
		List<DataSetAccountTree> yearList = new ArrayList<DataSetAccountTree>();

		String value = "SET @p_orgDiv='" + orgDivision + "',@p_orgName='" + orgName + "';";
		logger.info("value==>" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getParentListName").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				DataSetAccountTree item = new DataSetAccountTree(m[0], m[1], m[2], m[3]);
				yearList.add(item);
			}
			resp.setBody(yearList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<DataSetAccountTree>>> response = new ResponseEntity<JsonResponse<List<DataSetAccountTree>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getAccountCategoryListModal ends");
		System.out.println();
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountCreditorLedgerModel>>> journalVoucherPdf(String fromDate,
			String toDate, String orgDivision, String orgName) {
		logger.info("Method : journalVoucherPdf starts");
		JsonResponse<List<RestAccountCreditorLedgerModel>> resp = new JsonResponse<List<RestAccountCreditorLedgerModel>>();
		List<RestAccountCreditorLedgerModel> rs = new ArrayList<RestAccountCreditorLedgerModel>();

		String value = "SET @p_orgDiv='" + orgDivision + "',@p_orgName='" + orgName + "',@p_fromDate='"
				+ DateFormatter.getStringDate(fromDate) + "',@p_toDate='" + DateFormatter.getStringDate(toDate) + "';";

		try {
			logger.info("values--->" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "journalVoucherPdf").setParameter("actionValue", value).getResultList();

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

		logger.info("Method : journalVoucherPdf ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getNewReferenceData(String ledgerid, String voucherid, String orgName, String orgDiv) {
		logger.info("Method : getNewReferenceData starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			// String value = "SET @p_ledgerId='" + id + "';";
			String value = "SET @p_orgDiv='" + orgDiv + "',@p_orgName='" + orgName + "',@p_ledgerId='" + ledgerid
					+ "',@p_voucherid='" + voucherid + "';";

			logger.info("value-->" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("journalvoucherRoutines")
					.setParameter("actionType", "getReferenceData").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getNewReferenceData Dao ends" + resp);
		return resp;
	}

}
