
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

import nirmalya.aatithya.restmodule.account.model.RestAccountHeadModel;
import nirmalya.aatithya.restmodule.account.model.RestAccountModel;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.account.GenerateAccountHeadParameter;

import org.springframework.http.HttpHeaders;

@Repository
public class RestAccountHeadDao {

	Logger logger = LoggerFactory.getLogger(RestAccountHeadDao.class);
	@Autowired
	EntityManager em;
	@Autowired
	ServerDao serverDao;

	/*
	 * for add new assignSkill
	 */
	public ResponseEntity<JsonResponse<Object>> addAccountHead(RestAccountHeadModel restAccountHeadModel) {

		logger.info("Method in Dao: addAccount starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();
		// resp.setMessage("");
		// resp.setCode("");
		try {
			// String values ="";//
			String values = GenerateAccountHeadParameter.getAddAccountHeadParam(restAccountHeadModel);
			System.out.println(values);
			if (restAccountHeadModel.getAccountHeadId() == "" || restAccountHeadModel.getAccountHeadId() == null) {

				em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "addAccHead")
						.setParameter("actionValue", values).execute();

			} else {
				em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "modifyAccHead")
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

		logger.info("Method in Dao: addAccount ends");

		return response;
	}

	// restViewBankDetails

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> restViewAccountHeadDetails() {
		logger.info("Method : restViewAccountHeadDetails starts");

		System.out.println("rest bank Account-------------2222222222");
		List<RestAccountHeadModel> respList = new ArrayList<RestAccountHeadModel>();

		try {

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountHead")
					.setParameter("actionType", "getAccHeadDetails").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {

				RestAccountHeadModel restPayroll = new RestAccountHeadModel(m[0], m[1], m[2], m[3].toString(),
						m[4].toString(), m[5].toString());
				respList.add(restPayroll);

			}

			System.out.println("VIEW" + respList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JsonResponse<List<RestAccountHeadModel>> resp = new JsonResponse<List<RestAccountHeadModel>>();
		resp.setBody(respList);
		ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountHeadModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response" + response);
		logger.info("Method : restViewAccountHeadDetails ends");

		if (resp.getMessage() == null) {
			resp.setMessage("View successfully");
		}

		if (resp.getCode() == null) {
			resp.setCode("Success");
		}

		System.out.println("VIEWWWWWWWW" + respList);
		return response;

	}

	// deleteAccountDetails

	public ResponseEntity<JsonResponse<Object>> deleteAccountHeadDetails(String id) {
		logger.info("Method : deleteAccountHeadDetails starts");

		Boolean validity = true;
		JsonResponse<Object> resp = new JsonResponse<Object>();
		System.out.println("ID...." + id);
		if (validity)
			try {

				String value = "SET  @p_acctHeadId='(" + id + ")';";

				System.out.println("value------------------" + value);

				em.createNamedStoredProcedureQuery("accountHead").setParameter("actionType", "deleteAccHead")
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

		logger.info("Method :  deleteAccountHeadDetails ends");
		System.out.println("DELETE" + response);
		return response;
	}

	// editAccountInfo

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> editAccountHeadInfo(String id) {
		logger.info("Method : editAccountHeadInfo starts");

		JsonResponse<List<RestAccountHeadModel>> resp = new JsonResponse<List<RestAccountHeadModel>>();
		List<RestAccountHeadModel> rs = new ArrayList<RestAccountHeadModel>();

		try {

			String value = "SET @p_acctHeadId='" + id + "';";
			System.out.println(value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("accountHead")
					.setParameter("actionType", "editAccHeadInfo").setParameter("actionValue", value).getResultList();
			System.out.println("asdfasdf" + x);

			for (Object[] m : x) {

				RestAccountHeadModel restPayroll = new RestAccountHeadModel(m[0], m[1], m[2], m[3].toString(), null, null);
				rs.add(restPayroll);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setBody(rs);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");

		ResponseEntity<JsonResponse<List<RestAccountHeadModel>>> response = new ResponseEntity<JsonResponse<List<RestAccountHeadModel>>>(
				resp, responseHeaders, HttpStatus.CREATED);

		logger.info("Method : editAccountHeadInfo ends");

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
