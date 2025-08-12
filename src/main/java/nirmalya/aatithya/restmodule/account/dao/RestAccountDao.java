
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
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateManageAccountParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountDao {

	Logger logger = LoggerFactory.getLogger(RestAccountDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addAccount(RestAccountModel restAccountModel) {

		logger.info("Method in Dao: addAccount starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateManageAccountParameter.getAddAccountParam(restAccountModel);
			logger.info(values);
			if (restAccountModel.getAccountId() == "" || restAccountModel.getAccountId() == null) {

				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "addAccount").setParameter("actionValue", values).execute();
				resp.setCode("201");
				resp.setMessage("Bank Account Created Successfully");

			} else {

				logger.info(values + "modify");
				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "modifyAccount").setParameter("actionValue", values).execute();
				resp.setCode("200");
				resp.setMessage("Bank Account Modified Successfully");
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

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);
		if (resp.getMessage() == null) {
			resp.setMessage("Saved successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("Method in Dao: addAccount ends");

		return response;
	}

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountModel>>> restViewAccountDetails(String orgName, String orgDiv) {
		logger.info("Method : restViewAccountDetails starts");
		List<RestAccountModel> respList = new ArrayList<RestAccountModel>();

		try {
			String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info("value===>" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "getAccountDetails").setParameter("actionValue", value).getResultList();

			for (Object[] m : x) {

				if (m[2] == null) {
					m[2] = "";
				}

				if (m[6] == null) {
					m[6] = "";
				}

				if (m[9] == null) {
					m[9] = "";
				}

				RestAccountModel restPayroll = new RestAccountModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6].toString(),
						m[7].toString(), m[8].toString(), m[9]);
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAccountModel>> resp = new JsonResponse<List<RestAccountModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAccountModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewBranchDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	// deleteAccountDetails

	public ResponseEntity<JsonResponse<Object>> deleteAccountDetails(String id, String orgName, String orgDiv) {
		logger.info("Method : deleteAccountDetails starts");
		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		if (validity)
			try {
				String value = "SET @p_accountId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
				logger.info(value);

				em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
						.setParameter("actionType", "deleteBankAccountRecord").setParameter("actionValue", value)
						.execute();

				resp.setCode("200");
				resp.setMessage("Bank Account Deleted Successfully");

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

		logger.info("Method :  deleteAccountDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountJournalVoucherModel>>> editAccountInfo(String id, String orgName,
			String orgDiv) {
		logger.info("Method : editAccountInfo starts");

		JsonResponse<List<AccountJournalVoucherModel>> resp = new JsonResponse<List<AccountJournalVoucherModel>>();
		List<AccountJournalVoucherModel> rs = new ArrayList<AccountJournalVoucherModel>();

		try {
			String value = "SET @p_accountId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "editAccountInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[6] == null) {
					m[6] = "";
				}

				if (m[7] == null) {
					m[7] = "";
				}
				/*
				 * AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0],
				 * m[1], m[2], m[3], m[4], null, m[5], m[6], null, null, null, m[7], null, null,
				 * null, null, null, null, null); rs.add(restPayroll);
				 */

				AccountJournalVoucherModel restPayroll = new AccountJournalVoucherModel(m[0], m[1], m[2], m[3], m[4],
						null, m[5], m[6], null, null, null, m[7], m[8], null, null, null, null, null, null);
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

		logger.info("Method : editBranchInfo ends");

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
	public ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> getBranchAutoSearch(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getBranchAutoSearch starts");

		List<RestAccountBranchModel> itemNameList = new ArrayList<RestAccountBranchModel>();
		JsonResponse<List<RestAccountBranchModel>> resp = new JsonResponse<List<RestAccountBranchModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
		logger.info("value for search------------" + value);

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "getBranchSearch").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {

				RestAccountBranchModel dropDownModel = new RestAccountBranchModel(m[0], m[1], m[2]);
				itemNameList.add(dropDownModel);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<List<RestAccountBranchModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBranchModel>>>(
				resp, HttpStatus.CREATED);

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}
		logger.info("Method : getBranchAutoSearch ends====" + resp);
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getbranchlist(String id, String orgName,
			String orgDivision) {
		logger.info("Method : getbranchlist Dao startssssssssssssssssssssss");

		List<DropDownModel> branchList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET  @p_bankId='" + id + "',@p_orgName='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "getBranchNameListData").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2]);
				branchList.add(dropDownModel);
			}

			resp.setBody(branchList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getbranchlist Dao ends" + resp);
		return response;

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> getBankNameDetails(String id) {
		logger.info("Method : getBankNameDetails Dao starts");

		List<RestAccountBankModel> itemNameList = new ArrayList<RestAccountBankModel>();
		JsonResponse<List<RestAccountBankModel>> resp = new JsonResponse<List<RestAccountBankModel>>();
		String value = "SET @p_searchValue='" + id + "';";

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bankAccountRoutines")
					.setParameter("actionType", "getBankNameDetails").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				RestAccountBankModel viewDemo = new RestAccountBankModel(m[0], m[1], m[2]);

				itemNameList.add(viewDemo);
			}
			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<RestAccountBankModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBankModel>>>(
				resp, HttpStatus.OK);
		logger.info("Method : getBankNameDetails Dao ends" + resp);
		return response;
	}

}
