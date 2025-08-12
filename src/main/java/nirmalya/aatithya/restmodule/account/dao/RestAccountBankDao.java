
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

import nirmalya.aatithya.restmodule.account.model.AccountBankBranchModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountBankModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountBankParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountBankDao {

	Logger logger = LoggerFactory.getLogger(RestAccountBankDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	public ResponseEntity<JsonResponse<Object>> addBank(RestAccountBankModel restAccountBankModel) {

		logger.info("Method in Dao: addCustomer starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateAccountBankParameter.getAddBankParam(restAccountBankModel);
			logger.info(values);
			if (restAccountBankModel.getBankId() == "" || restAccountBankModel.getBankId() == null) {

				em.createNamedStoredProcedureQuery("account_bank_routines").setParameter("actionType", "addBank")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("account_bank_routines").setParameter("actionType", "modifyBank")
						.setParameter("actionValue", values).execute();
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

		logger.info("Method in Dao: addBank ends");

		return response;
	}

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> restViewBankDetails() {
		logger.info("Method : restViewBankDetails starts");

		logger.info("rest bank DAO-------------------------------------------------------------2222222222");
		List<RestAccountBankModel> respList = new ArrayList<RestAccountBankModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bank_routines")
					.setParameter("actionType", "getBankDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}

				RestAccountBankModel restPayroll = new RestAccountBankModel(m[0], m[1], m[2], m[3].toString(),
						m[4].toString(), m[5].toString());
				respList.add(restPayroll);

			}

			logger.info("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAccountBankModel>> resp = new JsonResponse<List<RestAccountBankModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAccountBankModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBankModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("response" + response);
		logger.info("Method : restViewBankDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		logger.info("VIEWWWWWWWW" + respList);
		return response;

	}

	// deleteBankDetails

	public ResponseEntity<JsonResponse<Object>> deleteBankDetails(String id) {
		logger.info("Method : deleteBankDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		logger.info("ID...." + id);
		if (validity)
			try {

				/* String value = "SET  @p_bankId='(" + id + ")';"; */
				 String value = "SET @p_bankId='" + id + "';";
				

				 logger.info("value------------------" + value);

				em.createNamedStoredProcedureQuery("account_bank_routines").setParameter("actionType", "deleteBank")
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

		logger.info("Method :  deleteBankDetails ends");
		logger.info("DELETE" + response);
		return response;
	}

	// editBankInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountBankModel>>> editBankInfo(String id) {
		logger.info("Method : editBankInfo starts");
		JsonResponse<List<RestAccountBankModel>> resp = new JsonResponse<List<RestAccountBankModel>>();
		List<RestAccountBankModel> rs = new ArrayList<RestAccountBankModel>();
		try {

			String value = "SET @p_bankId='" + id + "';";
			logger.info(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("account_bank_routines")
					.setParameter("actionType", "editBankInfo").setParameter("actionValue", value).getResultList();
			logger.info("asdfasdf" + x);

			for (Object[] m : x) {

				if (m[3] == null) {
					m[3] = "";
				}

				RestAccountBankModel restPayroll = new RestAccountBankModel(m[0], m[1], m[2], m[3].toString(), null,
						null);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountBankModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountBankModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editBankInfo ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println(response);
		return response;
	}

	

}
