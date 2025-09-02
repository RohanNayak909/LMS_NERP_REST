package nirmalya.aatithya.restmodule.lms.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import org.json.JSONArray;
import org.json.JSONObject;

	@Repository
	public class RestStudentEnrollCourseDao {
		Logger logger = LoggerFactory.getLogger(RestStudentEnrollCourseDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;
		@Autowired 
		PasswordEncoder passEncoder;
		
		
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEnrollCourses(String orgName, String orgDivision,String userId) {
		logger.info("Method : viewEnrollCourses Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
					.setParameter("actionType", "viewEnrollCourses").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEnrollCourses Dao ends"+resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveUserData(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : saveUserData Dao starts" + data);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		JSONObject jsonObj = new JSONObject(data);
		try {
			String encodedPassword="";
			String firstName = jsonObj.optString("firstName");
			String lastName = jsonObj.optString("lastName");
			String dob = jsonObj.optString("dob");
			String nationality = jsonObj.optString("nationality");
			String gender = jsonObj.optString("gender");
			String email = jsonObj.optString("email");
			String phone = jsonObj.optString("phone");
			String password = jsonObj.optString("password");
			encodedPassword= passEncoder.encode(password);
			

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_firstName='" + firstName
					+ "', @p_lastName='" + lastName + "', @p_dob='" + dob + "', @p_nationality='" + nationality + "', @p_gender='" + gender + "', @p_email='" + email + "', @p_phone='" + phone + "', @p_password='" + password + "',@p_encodedPassword='" + encodedPassword + "';";

			logger.info("value for items for saveUserData===================>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
					.setParameter("actionType", "saveUserData").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("User Registered Successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : saveUserData Dao ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveUserDatalms(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : saveUserData Dao starts" + data);

		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		JSONObject jsonObj = new JSONObject(data);
		try {
			String encodedPassword="";
			String firstName = jsonObj.optString("firstName");
			String lastName = jsonObj.optString("lastName");
			String dob = jsonObj.optString("dob");
			String nationality = jsonObj.optString("nationality");
			String gender = jsonObj.optString("gender");
			String email = jsonObj.optString("email");
			String phone = jsonObj.optString("phone");
			String password = jsonObj.optString("password");
			encodedPassword= passEncoder.encode(password);
			

			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_firstName='" + firstName
					+ "', @p_lastName='" + lastName + "', @p_dob='" + dob + "', @p_nationality='" + nationality + "', @p_gender='" + gender + "', @p_email='" + email + "', @p_phone='" + phone + "', @p_password='" + password + "',@p_encodedPassword='" + encodedPassword + "';";

			logger.info("value for items for saveUserData===================>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
					.setParameter("actionType", "saveUserData").setParameter("actionValue", value).getResultList();

			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("User Registered Successfully");

		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : saveUserData Dao ends");
		return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveEnrollmentData(String orgName, String orgDivision, String userId, String data) {
	    logger.info("Method : saveEnrollmentData Dao starts" + userId);
	    System.out.println(data);

	    JsonResponse<Object> resp = new JsonResponse<Object>();

	    try {
	        JSONObject jsonObj = new JSONObject(data);
	        JSONArray productIds = jsonObj.getJSONArray("productIds");
	        String firstName = jsonObj.optString("firstName");
	        String lastName = jsonObj.optString("lastName");
	        String email = jsonObj.optString("email");
	        String address = jsonObj.optString("address");
	        String city = jsonObj.optString("city");
	        String zip = jsonObj.optString("zip");
	        String paymentMethod = jsonObj.optString("paymentMethod");

	        JSONObject cardInfo = jsonObj.optJSONObject("cardInfo");
	        String cardNumber = cardInfo != null ? cardInfo.optString("cardNumber") : "";
	        String expiryDate = cardInfo != null ? cardInfo.optString("expiryDate") : "";
	        String cvv = cardInfo != null ? cardInfo.optString("cvv") : "";

	        // Loop through productIds
	        for (int i = 0; i < productIds.length(); i++) {
	            String productId = productIds.getString(i);

	            String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision +
	                    "', @p_createdBy='" + userId +
	                    "', @p_firstName='" + firstName +
	                    "', @p_lastName='" + lastName +
	                    "', @p_email='" + email +
	                    "', @p_address='" + address +
	                    "', @p_city='" + city +
	                    "', @p_zip='" + zip +
	                    "', @p_paymentMethod='" + paymentMethod +
	                    "', @p_productId='" + productId +
	                    "', @p_cardNumber='" + cardNumber +
	                    "', @p_expiryDate='" + expiryDate +
	                    "', @p_cvv='" + cvv + "';";

	            logger.info("value for saveEnrollmentData: " + value);

	            em.createNamedStoredProcedureQuery("coupon_management_Routines")
	                    .setParameter("actionType", "saveEnrolmentData")
	                    .setParameter("actionValue", value)
	                    .execute();
	        }

	        resp.setCode("success");
	        resp.setMessage("Enrollment completed successfully");

	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage(e.getMessage());
	        e.printStackTrace();
	    }

	    logger.info("Method : saveEnrollmentData Dao ends");
	    return resp;
	}

}
