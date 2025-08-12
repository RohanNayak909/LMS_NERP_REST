
package nirmalya.aatithya.restmodule.account.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.http.HttpStatus;

import nirmalya.aatithya.restmodule.account.model.AccountCusRestModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.GenerateCrmCustomerDetails;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountCustParameter;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;
import nirmalya.aatithya.restmodule.util.CheckDuplicate;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountCustDao {

	Logger logger = LoggerFactory.getLogger(RestAccountCustDao.class);
	
	@Autowired
	EntityManager em;
	
	@Autowired
	ServerDao serverDao;
	
	@Autowired
	CheckDuplicate checkDuplicate = new CheckDuplicate();

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addAccountCustomer(AccountCusRestModel accountCusRestModel) {
		logger.info("Method in Dao: addAccountCustomer starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			
			List<DropDownModel> dataList = new ArrayList<>();
	    	dataList.add(new DropDownModel("NAME", accountCusRestModel.getCustomerName()));
	    	dataList.add(new DropDownModel("PINCODE", accountCusRestModel.getZipCode()));
			
			Integer code = checkDuplicate.ifDataIsDuplicate("CUSTOMER", dataList.toString(), accountCusRestModel.getCustomerId());
			if(code != 0) {
				resp.setCode("DUPLICATE_CUSTOMER");
				resp.setMessage("Customer With Pincode Already Exists : " + accountCusRestModel.getCustomerName());
				return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CONFLICT);
			}

			String pan = accountCusRestModel.getPan();
			String panCheckQuery = "SELECT TACM_Cust_Name FROM tbl_account_cust_mstr "
					+ "WHERE UPPER(TRIM(TACM_Cust_Pan)) = UPPER(TRIM(:pan)) " + "AND TACM_Cust_DeletedFlag = 0";
			Query query = em.createNativeQuery(panCheckQuery);
			String panUpper = (pan != null ? pan.toUpperCase() : "");
			query.setParameter("pan", panUpper);

			@SuppressWarnings("unchecked")
			List<Object> resultList = query.getResultList();

			if (resultList != null && !resultList.isEmpty()) {
				String existingCustName = (String) resultList.get(0);
				System.out.println("Duplicate PAN found for customer: " + existingCustName);

				resp.setCode("DUPLICATE_PAN");
				resp.setMessage("PAN already exists for customer: " + existingCustName);
				return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CONFLICT);
			} else {
				System.out.println("No duplicate PAN found.");
			}

//			String values = GenerateAccountCustParameter.getAddCustParam(accountCusRestModel);
//			if (accountCusRestModel.getCustomerId() == null || accountCusRestModel.getCustomerId().isEmpty()) {
//				em.createNamedStoredProcedureQuery("account_cust_routines").setParameter("actionType", "addCustomer")
//						.setParameter("actionValue", values).execute();
//			} else {
//				em.createNamedStoredProcedureQuery("account_cust_routines").setParameter("actionType", "modifyCustomer")
//						.setParameter("actionValue", values).execute();
//			}

			// Set default success response
			resp.setMessage("Saved successfully");
			resp.setCode("Success");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode(err[0]);
				resp.setMessage(err[1]);
			} catch (Exception e1) {
				e1.printStackTrace();
				resp.setCode("ERROR");
				resp.setMessage("Unexpected error occurred while saving customer.");
			}
		}

		logger.info("Method in Dao: addAccountCustomer ends");
		return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
	}

	// restViewCustDtls

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountCusRestModel>>> restViewCustDtls() {
		logger.info("Method : restViewCustDtls starts");

		System.out.println("rest bank DAO-------------------------------------------------------------2222222222");
		List<AccountCusRestModel> respList = new ArrayList<AccountCusRestModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_cust_routines")
					.setParameter("actionType", "getCustDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				AccountCusRestModel restPayroll = new AccountCusRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7].toString());
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<AccountCusRestModel>> resp = new JsonResponse<List<AccountCusRestModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<AccountCusRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCusRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewCustDtls ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// deleteBankDetails

	public ResponseEntity<JsonResponse<Object>> deleteCusAccDetails(String id) {
		logger.info("Method : deleteCusAccDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_customerId='(" + id + ")';";

				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("account_cust_routines").setParameter("actionType", "deleteCustomer")
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

		logger.info("Method :  deleteCusAccDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editAccCusInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<AccountCusRestModel>>> editAccCusInfo(String id) {
		logger.info("Method : editAccCusInfo starts");

		JsonResponse<List<AccountCusRestModel>> resp = new JsonResponse<List<AccountCusRestModel>>();
		List<AccountCusRestModel> rs = new ArrayList<AccountCusRestModel>();

		try {

			String value = "SET @p_customerId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_cust_routines")
					.setParameter("actionType", "editCustomerInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {
				AccountCusRestModel restPayroll = new AccountCusRestModel(m[0], m[1], m[2], m[3], m[4], m[5], m[6],
						m[7], m[8], m[9], m[10], m[11], m[12], m[13], m[14], m[15], m[16], m[17], m[18], m[19], m[20],
						m[21], m[22], m[23], m[24], m[25], m[26], m[27], m[28], m[29], m[30], m[31], m[32], m[33],
						m[34], m[35], m[36], m[37], m[38], m[39], m[40], m[41], m[42]);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<AccountCusRestModel>>> response = new ResponseEntity<JsonResponse<List<AccountCusRestModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editAccCusInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	// getStateLists1

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateLists1(String id) {

		logger.info("Method : getStateLists1 starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("account_cust_routines")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getStateLists1 ends");
		return response;
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getDistrictLists(String id) {

		logger.info("Method : getDistrictLists starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_state='" + id + "';";

		System.out.println("===>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("shoukeen_ecom_routines")
					.setParameter("actionType", "getDistrictLists").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println(response);
		logger.info("Method : getDistrictLists ends");
		return response;
	}

}
