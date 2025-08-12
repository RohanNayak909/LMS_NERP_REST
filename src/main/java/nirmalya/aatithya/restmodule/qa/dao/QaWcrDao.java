package nirmalya.aatithya.restmodule.qa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.EnvironmentVaribles;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.common.utils.qa.GenerateWcrParam;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.qa.model.QaWcrRestModel;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class QaWcrDao {

	Logger logger = LoggerFactory.getLogger(QaWcrDao.class);

	@Autowired
	EntityManager em;
	
	@Autowired
	EnvironmentVaribles env;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	// viewAsset
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getShiftSlno(String orgName, String orgDivision) {
		logger.info("Method : getShiftSlno Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_wcr_routines")
					.setParameter("actionType", "getSlno").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getShiftSlno Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}

	// add WCR

	public ResponseEntity<JsonResponse<List<QaWcrRestModel>>> addWcr(List<QaWcrRestModel> qc) {
		logger.info("Method : addWcr dao starts");
		System.out.println(qc);
		JsonResponse<List<QaWcrRestModel>> resp = new JsonResponse<List<QaWcrRestModel>>();

		String value = GenerateWcrParam.getAddwrc(qc);
		System.out.println("value===" + value);
		// System.out.println("Modify qc===" + qc.get(0).getWcrId());
		try {

			if (qc.get(0).getWcrId() != null && qc.get(0).getWcrId() != "") {

				em.createNamedStoredProcedureQuery("qa_wcr_routines").setParameter("actionType", "modifyWcr")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data Modified successfully");

			} else {
				em.createNamedStoredProcedureQuery("qa_wcr_routines").setParameter("actionType", "addWcr")
						.setParameter("actionValue", value).execute();

				resp.setCode("success");
				resp.setMessage("Data saved successfully");

			}

		} catch (Exception e) {

			try {
				String[] err = serverDao.errorProcedureCall(e);
				e.printStackTrace();
				String rcode=err[0];
				System.out.println("rcode"+rcode);
				if(rcode.equals("1062")) {
					resp.setCode("failed");
					resp.setMessage("SHIFT AND PRODUCT IS ALREADY ASSIGNED!");
				}else {
					resp.setCode("failed");
					resp.setMessage("Something went wrong ");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
			}
			e.printStackTrace();

		}

		ResponseEntity<JsonResponse<List<QaWcrRestModel>>> response = new ResponseEntity<JsonResponse<List<QaWcrRestModel>>>(
				resp, HttpStatus.CREATED);
		System.out.println("response===" + response);
		logger.info("Method : addWcr dao ends");
		return response;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> wcrView(String orgName, String orgDivision) {
		logger.info("Method : wcrView Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_wcr_routines")
					.setParameter("actionType", "wcrView").setParameter("actionValue", value).getResultList();
			resp.setBody(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : wcrView Dao ends");
		System.out.println("resp**************rrreessuulltt**************" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editWCR(String id, String orgName, String orgDivision) {
		logger.info("Method : editWCR Dao starts");
		JsonResponse<Object> resp = new JsonResponse<Object>();
		try {
			String value = "SET @p_wcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_wcr_routines")
					.setParameter("actionType", "editWcr").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editWCR Dao ends");
		System.out.println("resp**************EDIT**************" + resp);
		return resp;
	}
	
			public ResponseEntity<JsonResponse<Object>> approveWcr(String id, String userId, String orgName,
					String orgDivision) {
				logger.info("Method : approveWcr dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");
				try {
					String value = "SET @p_wcrId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
							+ "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("value==" + value);
					em.createNamedStoredProcedureQuery("qa_wcr_routines")
							.setParameter("actionType", "approveWcr").setParameter("actionValue", value).execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
					resp.setMessage("Approved");
					resp.setCode("success");
				} catch (Exception e) {
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
				ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
						HttpStatus.CREATED);
				logger.info("Method : approveWcr dao ends");
				return response;
			}
			
			
			public ResponseEntity<JsonResponse<Object>> deleteWcr(String id, String userId, String orgName,
					String orgDivision) {
				logger.info("Method : deleteWcr dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				resp.setMessage("");
				resp.setCode("");
				try {
					String value = "SET @p_wcrId='" + id + "',@p_userId='" + userId + "',@p_org='" + orgName
							+ "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("value==" + value);
					em.createNamedStoredProcedureQuery("qa_wcr_routines")
							.setParameter("actionType", "deleteWcr").setParameter("actionValue", value).execute();
					Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
					resp.setMessage("Deleted");
					resp.setCode("success");
				} catch (Exception e) {
					e.printStackTrace();
					Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
					resp.setCode("failed");
					resp.setMessage(e.getMessage());
				}
				ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
						HttpStatus.CREATED);
				logger.info("Method : deleteWcr dao ends");
				return response;
			}
			
			// Download WCR
			
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> downloadWcr(String id, String orgName, String orgDivision) {
				logger.info("Method : downloadWcr Dao starts");
				JsonResponse<Object> resp = new JsonResponse<Object>();
				try {
					String value = "SET @p_wcrId='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					System.out.println("values****************************" + value);
					List<Object[]> x = em.createNamedStoredProcedureQuery("qa_wcr_routines")
							.setParameter("actionType", "downloadWcr").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : downloadWcr Dao ends");
				System.out.println("resp**************EDIT**************" + resp);
				return resp;
			}
						

}
