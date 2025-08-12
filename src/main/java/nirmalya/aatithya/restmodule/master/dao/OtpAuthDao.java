package nirmalya.aatithya.restmodule.master.dao;

import java.math.BigInteger;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@Repository
public class OtpAuthDao {
	
	Logger logger = LoggerFactory.getLogger(OtpAuthDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveGeneratedOtp(String data) {
		logger.info("method: saveGeneratedOtp Dao Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {

	        JSONObject jsonData = new JSONObject(data);

	        String email = jsonData.getString("email");
	        int otp = jsonData.getInt("otp");
	        String otpDate = jsonData.getString("otpDate");
	        String expiryDate = jsonData.getString("expiryDate");

	        String value = "SET @email='" + email + "', @otp='" + otp + "', @otpDate='" + otpDate + "',@expiryDate='" + expiryDate + "';";
	        
	        System.out.println(value);
			 

			em.createNamedStoredProcedureQuery("otp_auth_service")
					.setParameter("actionType", "save-otp").setParameter("actionValue", value)
					.execute();

			/*
			 * resp.setMessage("Candidate Shortlisted Successfully!"); resp.setCode("200");
			 */

		} catch (Exception e) {
			logger.error("Error in otp: ", e);
			resp.setMessage("Error saving otp");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		logger.info("method: saveGeneratedOtp Dao Ends");
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> fetchOtp(String otp, String id) {

	    logger.info("Method : fetchOtp Dao starts");

	    JsonResponse<Object> resp = new JsonResponse<>();

	    try {
	        String value = "SET @otp='" + otp + "',@id='" + id + "';";

	        List<BigInteger> result = em.createNamedStoredProcedureQuery("otp_auth_service")
	                .setParameter("actionType", "fetch-otp")
	                .setParameter("actionValue", value)
	                .getResultList();

	        if (!result.isEmpty() && result.get(0).intValue() == 1) { 
	            resp.setCode("200");
	            resp.setMessage("OTP verified successfully.");
	        } else {
	            resp.setCode("400");
	            resp.setMessage("OTP has expired or is invalid.");
	        }

	        resp.setBody(result);

	    } catch (Exception e) {
	        logger.error("Error in fetchOtp: ", e);
	        resp.setCode("500");
	        resp.setMessage("An error occurred while verifying OTP.");
	    }

	    logger.info("Method : fetchOtp Dao ends");
	    return resp;
	}



}
