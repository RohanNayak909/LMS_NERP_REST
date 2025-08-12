package nirmalya.aatithya.restmodule.qa.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import nirmalya.aatithya.restmodule.api.dao.CheckDuplicateDao;
import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.enums.ResponseStatus;
import nirmalya.aatithya.restmodule.util.ApiResponseMessage;
import nirmalya.aatithya.restmodule.util.Util;

@Repository
public class RestSampleRequestDao {
	
	
	Logger logger = LoggerFactory.getLogger(RestSampleRequestDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	@Autowired
	CheckDuplicateDao checkDuplicateDao;

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewSampleRequestData(String orgName, String orgDivision) {
		logger.info("Method : viewSampleRequestData Dao startssssssssssssssssssssss");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			System.out.println("values****************************" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("qa_requested_routines")
					.setParameter("actionType", "viewSampleRequestData").setParameter("actionValue", value)
					.getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : viewSampleRequestData Dao ends");
		System.out.println("resp****************************" + resp);
		return resp;

	}
	
	
	// Add Sample Amount.
		public ResponseEntity<JsonResponse<Object>> sampleAmt(String id,String sampleAmt, String reqId, String QrCode, String orgName, String orgDivision) {
			logger.info("Method : sampleAmt dao starts");
			JsonResponse<Object> resp = new JsonResponse<Object>();
			resp.setMessage("");
			resp.setCode("");
			try {
				String value = "SET @p_id='" + id + "',@p_sampleAmt='" + sampleAmt + "',@p_qrCode='" + QrCode + "',@p_reqId='" + reqId + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				em.createNamedStoredProcedureQuery("qa_requested_routines").setParameter("actionType", "addSampleAmt")
						.setParameter("actionValue", value).execute();
				Util.setJsonResponse(resp, null, ResponseStatus.success, ApiResponseMessage.DELETE_DATA);
//				resp.setMessage("Success");
//				resp.setCode("");
			} catch (Exception e) {
				e.printStackTrace();
				Util.setJsonResponse(resp, null, ResponseStatus.failed, ApiResponseMessage.UNKNOWN_EXCEPTION);
//				resp.setCode(e.getMessage());
//				resp.setMessage("failed");
			}
			
			ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
					HttpStatus.CREATED);
			logger.info("Method : sampleAmt dao ends");
			return response;
		}
	
	
}
