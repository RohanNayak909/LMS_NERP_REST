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
	
	
	/*
	 * @SuppressWarnings("unchecked") public JsonResponse<Object>
	 * saveUserDatalms(String orgName, String orgDivision, String userId, String
	 * data) { logger.info("Method : saveUserData Dao starts" + data);
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<Object>();
	 * 
	 * JSONObject jsonObj = new JSONObject(data); try { String encodedPassword="";
	 * String firstName = jsonObj.optString("firstName"); String lastName =
	 * jsonObj.optString("lastName"); String dob = jsonObj.optString("dob"); String
	 * nationality = jsonObj.optString("nationality"); String gender =
	 * jsonObj.optString("gender"); String email = jsonObj.optString("email");
	 * String phone = jsonObj.optString("phone"); String password =
	 * jsonObj.optString("password"); encodedPassword= passEncoder.encode(password);
	 * 
	 * 
	 * String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision +
	 * "',@p_createdBy='" + userId + "', @p_firstName='" + firstName +
	 * "', @p_lastName='" + lastName + "', @p_dob='" + dob + "', @p_nationality='" +
	 * nationality + "', @p_gender='" + gender + "', @p_email='" + email +
	 * "', @p_phone='" + phone + "', @p_password='" + password +
	 * "',@p_encodedPassword='" + encodedPassword + "';";
	 * 
	 * logger.info("value for items for saveUserData===================>" + value);
	 * List<Object[]> x =
	 * em.createNamedStoredProcedureQuery("coupon_management_Routines")
	 * .setParameter("actionType", "saveUserData").setParameter("actionValue",
	 * value).getResultList();
	 * 
	 * resp.setBody(x.get(0)); resp.setCode("success");
	 * resp.setMessage("User Registered Successfully");
	 * 
	 * } catch (Exception e) { resp.setCode("failed");
	 * resp.setMessage(e.getMessage()); e.printStackTrace(); }
	 * logger.info("Method : saveUserData Dao ends"); return resp; }
	 */
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveUserDatalms(String orgName, String orgDivision, String userId, String data) {
	    logger.info("Method : saveUserData Dao starts" + data);

	    JsonResponse<Object> resp = new JsonResponse<Object>();

	    try {
	        JSONObject jsonObj = new JSONObject(data);

	        String encodedPassword = "";
	        String firstName = jsonObj.optString("firstName");
	        String lastName = jsonObj.optString("lastName");
	        String dob = jsonObj.optString("dob");
	        String nationality = jsonObj.optString("nationality");
	        String gender = jsonObj.optString("gender");
	        String email = jsonObj.optString("email");
	        String phone = jsonObj.optString("phone");
	        String password = jsonObj.optString("password");
	        String type = jsonObj.optString("type", "Normal User"); // <-- new type field (can be null or 'public batches')

	        // Encode password
	        encodedPassword = passEncoder.encode(password);

	        // Construct parameter string for stored procedure
	        String value = "SET @p_org='" + orgName + 
	                       "', @p_orgDiv='" + orgDivision + 
	                       "', @p_createdBy='" + userId +
	                       "', @p_firstName='" + firstName +
	                       "', @p_lastName='" + lastName +
	                       "', @p_dob='" + dob +
	                       "', @p_nationality='" + nationality +
	                       "', @p_gender='" + gender +
	                       "', @p_email='" + email +
	                       "', @p_phone='" + phone +
	                       "', @p_password='" + password +
	                       "', @p_encodedPassword='" + encodedPassword + 
	                       "', @p_type=" + (type != "'Normal User'" ? ("'" + type + "'") : "Normal User") + ";"; // <-- safely handle null

	        logger.info("Value for saveUserData===================>" + value);

	        // Execute stored procedure
	        List<Object[]> result = em.createNamedStoredProcedureQuery("coupon_management_Routines")
	                .setParameter("actionType", "saveUserData")
	                .setParameter("actionValue", value)
	                .getResultList();

	        // Prepare response
	        resp.setBody(result.get(0));
	        resp.setCode("success");
	        resp.setMessage("User Registered Successfully");

	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage(e.getMessage());
	        logger.error("Error in saveUserData Dao: ", e);
	    }

	    logger.info("Method : saveUserData Dao ends");
	    return resp;
	}

	
    
    @SuppressWarnings("unchecked")
    public JsonResponse<Object> resetPasswordLms(String data) {
        logger.info("Method : resetPasswordLms Dao starts");

        JsonResponse<Object> resp = new JsonResponse<>();

        try {
            JSONObject jsonObj = new JSONObject(data);

            String email = esc(jsonObj.optString("email")).toLowerCase();
            String newPassword = jsonObj.optString("newPassword");

            if (email == null || email.trim().isEmpty()) {
                resp.setCode("failed");
                resp.setMessage("Email is required");
                return resp;
            }
            if (newPassword == null || newPassword.trim().length() < 6) {
                resp.setCode("failed");
                resp.setMessage("Password must be at least 6 characters");
                return resp;
            }

            String encodedPassword = passEncoder.encode(newPassword);

            String value = "SET @p_userId='', @p_email='" + email + "', @p_encodedPassword='" + esc(encodedPassword) + "';";
            List<Object[]> result = em.createNamedStoredProcedureQuery("coupon_management_Routines")
                    .setParameter("actionType", "updatePasswordLMS")
                    .setParameter("actionValue", value)
                    .getResultList();

            String status = pickStatus(result);

            if ("SUCCESS".equalsIgnoreCase(status)) {
                resp.setCode("success");
                resp.setMessage("Password reset successfully");
                resp.setBody(result.get(0));
            } else if ("USER_NOT_FOUND".equalsIgnoreCase(status)) {
                resp.setCode("failed");
                resp.setMessage("User not found");
                resp.setBody(result.get(0));
            } else {
                resp.setCode("failed");
                resp.setMessage("Reset password failed");
                resp.setBody(result.isEmpty() ? null : result.get(0));
            }

        } catch (Exception e) {
            logger.error("resetPasswordLms error: ", e);
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
        }

        logger.info("Method : resetPasswordLms Dao ends");
        return resp;
    }

    @SuppressWarnings("unchecked")
    public JsonResponse<Object> changePasswordLms(String data) {
        logger.info("Method : changePasswordLms Dao starts");

        JsonResponse<Object> resp = new JsonResponse<>();

        try {
            JSONObject jsonObj = new JSONObject(data);

            String userId = esc(jsonObj.optString("userId"));
            String oldPassword = jsonObj.optString("oldPassword");
            String newPassword = jsonObj.optString("newPassword");

            if (userId == null || userId.trim().isEmpty()) {
                resp.setCode("failed");
                resp.setMessage("UserId is required");
                return resp;
            }
            if (oldPassword == null || oldPassword.trim().isEmpty()) {
                resp.setCode("failed");
                resp.setMessage("Old password is required");
                return resp;
            }
            if (newPassword == null || newPassword.trim().length() < 6) {
                resp.setCode("failed");
                resp.setMessage("New password must be at least 6 characters");
                return resp;
            }

            // 1) get encoded password from userRoutines (same as your login does)
            String valueLogin = "SET @p_userName='" + userId + "';";
            List<Object[]> x = em.createNamedStoredProcedureQuery("userRoutines")
                    .setParameter("actionType", "getByName")
                    .setParameter("actionValue", valueLogin)
                    .getResultList();

            if (x == null || x.isEmpty()) {
                resp.setCode("failed");
                resp.setMessage("User not found");
                return resp;
            }

            String encodedPassword = (x.get(0)[2] != null) ? x.get(0)[2].toString() : "";
            if (!passEncoder.matches(oldPassword, encodedPassword)) {
                resp.setCode("failed");
                resp.setMessage("Old password incorrect");
                return resp;
            }

            // 2) update password
            String encodedNew = passEncoder.encode(newPassword);

            String value = "SET @p_userId='" + userId + "', @p_email='', @p_encodedPassword='" + esc(encodedNew) + "';";
            List<Object[]> result = em.createNamedStoredProcedureQuery("coupon_management_Routines")
                    .setParameter("actionType", "updatePasswordLMS")
                    .setParameter("actionValue", value)
                    .getResultList();

            String status = pickStatus(result);

            if ("SUCCESS".equalsIgnoreCase(status)) {
                resp.setCode("success");
                resp.setMessage("Password changed successfully");
                resp.setBody(result.get(0));
            } else if ("USER_NOT_FOUND".equalsIgnoreCase(status)) {
                resp.setCode("failed");
                resp.setMessage("User not found");
                resp.setBody(result.get(0));
            } else {
                resp.setCode("failed");
                resp.setMessage("Change password failed");
                resp.setBody(result.isEmpty() ? null : result.get(0));
            }

        } catch (Exception e) {
            logger.error("changePasswordLms error: ", e);
            resp.setCode("failed");
            resp.setMessage(e.getMessage());
        }

        logger.info("Method : changePasswordLms Dao ends");
        return resp;
    }

    // @SuppressWarnings("unchecked")
    // public JsonResponse<Object> updateProfileLms(String data) {
    //     logger.info("Method : updateProfileLms Dao starts");

    //     JsonResponse<Object> resp = new JsonResponse<>();

    //     try {
    //         JSONObject jsonObj = new JSONObject(data);

    //         String userId = esc(jsonObj.optString("userId"));
    //         String firstName = esc(jsonObj.optString("firstName"));
    //         String lastName = esc(jsonObj.optString("lastName"));
    //         String dob = esc(jsonObj.optString("dob")); // yyyy-mm-dd or blank
    //         String nationality = esc(jsonObj.optString("nationality"));
    //         String gender = esc(jsonObj.optString("gender"));
    //         String phone = esc(jsonObj.optString("phone"));

    //         if (userId == null || userId.trim().isEmpty()) {
    //             resp.setCode("failed");
    //             resp.setMessage("UserId is required");
    //             return resp;
    //         }

    //         String value = "SET @p_userId='" + userId + "'," +
    //                 " @p_firstName='" + firstName + "'," +
    //                 " @p_lastName='" + lastName + "'," +
    //                 " @p_dob='" + dob + "'," +
    //                 " @p_nationality='" + nationality + "'," +
    //                 " @p_gender='" + gender + "'," +
    //                 " @p_phone='" + phone + "';";

    //         List<Object[]> result = em.createNamedStoredProcedureQuery("coupon_management_Routines")
    //                 .setParameter("actionType", "updateProfileLMS")
    //                 .setParameter("actionValue", value)
    //                 .getResultList();

    //         String status = pickStatus(result);

    //         if ("SUCCESS".equalsIgnoreCase(status)) {
    //             resp.setCode("success");
    //             resp.setMessage("Profile updated successfully");
    //             resp.setBody(result.get(0));
    //         } else if ("USER_NOT_FOUND".equalsIgnoreCase(status)) {
    //             resp.setCode("failed");
    //             resp.setMessage("User not found");
    //             resp.setBody(result.get(0));
    //         } else {
    //             resp.setCode("failed");
    //             resp.setMessage("Profile update failed");
    //             resp.setBody(result.isEmpty() ? null : result.get(0));
    //         }

    //     } catch (Exception e) {
    //         logger.error("updateProfileLms error: ", e);
    //         resp.setCode("failed");
    //         resp.setMessage(e.getMessage());
    //     }

    //     logger.info("Method : updateProfileLms Dao ends");
    //     return resp;
    // }





    private static String pickStatus(List<Object[]> result) {
        if (result == null || result.isEmpty()) return "";
        Object[] row = result.get(0);
        if (row == null || row.length == 0 || row[0] == null) return "";
        return row[0].toString();
    }

    private static String esc(String s) {
        if (s == null) return "";
        return s.replace("'", "''").trim();
    }

	
// 	@SuppressWarnings("unchecked")
// 	public JsonResponse<Object> saveEnrollmentData(String orgName, String orgDivision, String userId, String data) {
// 	    logger.info("Method : saveEnrollmentData Dao starts" + userId);
// 	    System.out.println(data);

// 	    JsonResponse<Object> resp = new JsonResponse<Object>();

// 	    try {
// 	        JSONObject jsonObj = new JSONObject(data);
// 	        JSONArray productIds = jsonObj.getJSONArray("productIds");
// 	        String firstName = jsonObj.optString("firstName");
// 	        String lastName = jsonObj.optString("lastName");
// 	        String email = jsonObj.optString("email");
// 	        String address = jsonObj.optString("address");
// 	        String city = jsonObj.optString("city");
// 	        String zip = jsonObj.optString("zip");
// 	        String paymentMethod = jsonObj.optString("paymentMethod");
// 	        String trainingId = jsonObj.optString("trainingId");
	        
// 	        JSONObject cardInfo = jsonObj.optJSONObject("cardInfo");
// 	        String cardNumber = cardInfo != null ? cardInfo.optString("cardNumber") : "";
// 	        String expiryDate = cardInfo != null ? cardInfo.optString("expiryDate") : "";
// 	        String cvv = cardInfo != null ? cardInfo.optString("cvv") : "";
	       
// logger.info("ddddd"+trainingId);
// 	        // Loop through productIds
// 	        for (int i = 0; i < productIds.length(); i++) {
// 	            String productId = productIds.getString(i);

// 	            String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision +
// 	                    "', @p_createdBy='" + userId +
// 	                    "', @p_firstName='" + firstName +
// 	                    "', @p_lastName='" + lastName +
// 	                    "', @p_email='" + email +
// 	                    "', @p_address='" + address +
// 	                    "', @p_city='" + city +
// 	                    "', @p_zip='" + zip +
// 	                    "', @p_paymentMethod='" + paymentMethod +
// 	                    "', @p_productId='" + productId +
// 	                    "', @p_cardNumber='" + cardNumber +
// 	                    "', @p_expiryDate='" + expiryDate +
// 	                    "', @p_cvv='" + cvv +
// 	                    "', @p_trainingId='" +trainingId+"';";

// 	            logger.info("value for saveEnrollmentData: " + value);

				
// 				  em.createNamedStoredProcedureQuery("coupon_management_Routines")
// 				  .setParameter("actionType", "saveEnrolmentData") .setParameter("actionValue",
// 				  value) .execute();
				 
// 	        }

// 	        resp.setCode("success");
// 	        resp.setMessage("Enrollment completed successfully");

// 	    } catch (Exception e) {
// 	        resp.setCode("failed");
// 	        resp.setMessage(e.getMessage());
// 	        e.printStackTrace();
// 	    }

// 	    logger.info("Method : saveEnrollmentData Dao ends");
// 	    return resp;
// 	}



@SuppressWarnings("unchecked")
public JsonResponse<Object> saveEnrollmentData(String orgName, String orgDivision, String userId, String data) {
    logger.info("Method : saveEnrollmentData Dao starts" + userId);
    System.out.println(data);

    JsonResponse<Object> resp = new JsonResponse<Object>();

    try {
        JSONObject jsonObj = new JSONObject(data);

        // list of course/product ids coming from UI
        JSONArray productIds = jsonObj.getJSONArray("productIds");

        // common fields
        String firstName = jsonObj.optString("firstName");
        String lastName = jsonObj.optString("lastName");
        String email = jsonObj.optString("email");
        String address = jsonObj.optString("address");
        String city = jsonObj.optString("city");
        String zip = jsonObj.optString("zip");
        String paymentMethod = jsonObj.optString("paymentMethod");
        String trainingIdCsv = jsonObj.optString("trainingId"); // full CSV for all trainings
        JSONObject cardInfo = jsonObj.optJSONObject("cardInfo");
        String cardNumber = cardInfo != null ? cardInfo.optString("cardNumber") : "";
        String expiryDate = cardInfo != null ? cardInfo.optString("expiryDate") : "";
        String cvv = cardInfo != null ? cardInfo.optString("cvv") : "";

        // to avoid calling SP multiple times for same course
        java.util.Set<String> done = new java.util.HashSet<String>();

        // loop as you do
        for (int i = 0; i < productIds.length(); i++) {
            String productId = productIds.getString(i);

            // if already processed this course, skip
            if (done.contains(productId)) {
                logger.info("Skipping duplicate productId (already saved): " + productId);
                continue;
            }
            done.add(productId);

            // collect ALL trainingIds for this course
            StringBuilder trainingForThisCourse = new StringBuilder();
            if (trainingIdCsv != null && !trainingIdCsv.trim().isEmpty()) {
                String[] all = trainingIdCsv.split(",");
                for (int k = 0; k < all.length; k++) {
                    String tr = all[k] != null ? all[k].trim() : "";
                    if (tr.length() == 0) {
                        continue;
                    }
                    // IMPORTANT: one course has multiple training type, so we add ALL that start with this course
                    if (tr.startsWith(productId + "_")) {
                        if (trainingForThisCourse.length() > 0) {
                            trainingForThisCourse.append(",");
                        }
                        trainingForThisCourse.append(tr);
                    }
                }
            }
            String finalTrainingIds = trainingForThisCourse.toString();
            logger.info("trainingIds for course/product " + productId + " = " + finalTrainingIds);

            // build your SET
            String value =
                    "SET @p_org='" + escapeSql(orgName) +
                    "', @p_orgDiv='" + escapeSql(orgDivision) +
                    "', @p_createdBy='" + escapeSql(userId) +
                    "', @p_firstName='" + escapeSql(firstName) +
                    "', @p_lastName='" + escapeSql(lastName) +
                    "', @p_email='" + escapeSql(email) +
                    "', @p_address='" + escapeSql(address) +
                    "', @p_city='" + escapeSql(city) +
                    "', @p_zip='" + escapeSql(zip) +
                    "', @p_paymentMethod='" + escapeSql(paymentMethod) +
                    "', @p_productId='" + escapeSql(productId) +
                    "', @p_cardNumber='" + escapeSql(cardNumber) +
                    "', @p_expiryDate='" + escapeSql(expiryDate) +
                    "', @p_cvv='" + escapeSql(cvv) +
                    "', @p_trainingId='" + escapeSql(finalTrainingIds) + "';";

            logger.info("value for saveEnrollmentData: " + value);

            // call SP ONCE per course
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

private String escapeSql(String s) {
    if (s == null) return "";
    return s.replace("'", "''");
}



@SuppressWarnings("unchecked")
public JsonResponse<Object> profileViewLms(String userId) {
    logger.info("Method : profileViewLms Dao starts, userId=" + userId);

    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        String value = "SET @p_userId='" + escapeSql(userId) + "';";

        // ✅ IMPORTANT: use List<?> (not List<Object[]>)
        List<?> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
                .setParameter("actionType", "viewProfileLMS")
                .setParameter("actionValue", value)
                .getResultList();

        if (x == null || x.isEmpty()) {
            resp.setCode("success");
            resp.setMessage("No profile found");
            resp.setBody(null);
            return resp;
        }

        Object row = x.get(0);

        // ✅ unwrap safely:
        // - if result is Object[] with 1 column, take first element
        // - else if result is String/JSON, return directly
        if (row instanceof Object[]) {
            Object[] arr = (Object[]) row;
            resp.setBody(arr.length > 0 ? arr[0] : null);
        } else {
            resp.setBody(row);
        }

        resp.setCode("success");
        resp.setMessage("Profile fetched successfully");

    } catch (Exception e) {
        resp.setCode("failed");
        resp.setMessage(e.getMessage());
        logger.error("profileViewLms error:", e);
    }

    logger.info("Method : profileViewLms Dao ends");
    return resp;
}




@SuppressWarnings("unchecked")
public JsonResponse<Object> updateProfileLms(String data) {
    logger.info("Method : updateProfileLms Dao starts");

    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        org.json.JSONObject jsonObj = new org.json.JSONObject(data);

        String userId = escapeSql(jsonObj.optString("userId"));
        String firstName = escapeSql(jsonObj.optString("firstName"));
        String lastName = escapeSql(jsonObj.optString("lastName"));
        String dob = escapeSql(jsonObj.optString("dob")); // yyyy-mm-dd or blank
        String nationality = escapeSql(jsonObj.optString("nationality"));
        String gender = escapeSql(jsonObj.optString("gender"));
        String phone = escapeSql(jsonObj.optString("phone"));

        String value =
            "SET @p_userId='" + userId + "'," +
            " @p_firstName='" + firstName + "'," +
            " @p_lastName='" + lastName + "'," +
            " @p_dob='" + dob + "'," +
            " @p_nationality='" + nationality + "'," +
            " @p_gender='" + gender + "'," +
            " @p_phone='" + phone + "';";

        List<?> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
                .setParameter("actionType", "updateProfileLMS")
                .setParameter("actionValue", value)
                .getResultList();

        String status = "";
        if (x != null && !x.isEmpty()) {
            Object row = x.get(0);
            if (row instanceof Object[]) {
                Object[] arr = (Object[]) row;
                status = arr.length > 0 && arr[0] != null ? arr[0].toString() : "";
            } else {
                status = row != null ? row.toString() : "";
            }
        }

        if ("SUCCESS".equalsIgnoreCase(status)) {
            resp.setCode("success");
            resp.setMessage("Profile updated successfully");
            resp.setBody(x.isEmpty() ? null : x.get(0));
        } else if ("USER_NOT_FOUND".equalsIgnoreCase(status)) {
            resp.setCode("failed");
            resp.setMessage("User not found");
            resp.setBody(x.isEmpty() ? null : x.get(0));
        } else {
            resp.setCode("failed");
            resp.setMessage("Profile update failed");
            resp.setBody(x.isEmpty() ? null : x.get(0));
        }

    } catch (Exception e) {
        resp.setCode("failed");
        resp.setMessage(e.getMessage());
        logger.error("updateProfileLms error:", e);
    }

    logger.info("Method : updateProfileLms Dao ends");
    return resp;
}




@SuppressWarnings("unchecked")
public JsonResponse<Object> removeEnrollmentTraining(String orgName, String orgDivision, String enrolledBy, String updatedBy, String data) {
    logger.info("Method : removeEnrollmentTraining Dao starts, enrolledBy={}", enrolledBy);
    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        JSONObject jsonObj = new JSONObject(data);

        // Accept either productId or productIds[]
        java.util.List<String> productList = new java.util.ArrayList<>();
        if (jsonObj.has("productIds")) {
            JSONArray arr = jsonObj.getJSONArray("productIds");
            for (int i = 0; i < arr.length(); i++) {
                String pid = arr.optString(i, "").trim();
                if (!pid.isEmpty()) productList.add(pid);
            }
        } else {
            String productId = jsonObj.optString("productId", "").trim();
            if (!productId.isEmpty()) productList.add(productId);
        }

        // removeTrainingIds can be string CSV OR array
        String removeTrainingCsv = "";
        if (jsonObj.has("removeTrainingIds") && jsonObj.get("removeTrainingIds") instanceof JSONArray) {
            JSONArray rmArr = jsonObj.getJSONArray("removeTrainingIds");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < rmArr.length(); i++) {
                String t = rmArr.optString(i, "").trim();
                if (t.isEmpty()) continue;
                if (sb.length() > 0) sb.append(",");
                sb.append(t);
            }
            removeTrainingCsv = sb.toString();
        } else {
            removeTrainingCsv = jsonObj.optString("removeTrainingIds", "").trim();
        }

        if (productList.isEmpty()) {
            resp.setCode("failed");
            resp.setMessage("productId/productIds missing");
            return resp;
        }
        if (removeTrainingCsv == null || removeTrainingCsv.trim().isEmpty()) {
            resp.setCode("failed");
            resp.setMessage("removeTrainingIds missing");
            return resp;
        }

        // IMPORTANT: enrolledBy is student id; updatedBy is admin/session user (or same if not available)
        String safeUpdatedBy = (updatedBy != null && !updatedBy.trim().isEmpty()) ? updatedBy.trim() : enrolledBy;

        for (String productId : productList) {
            String value =
                "SET @p_org='" + escapeSql(orgName) +
                "', @p_orgDiv='" + escapeSql(orgDivision) +
                "', @p_enrollBy='" + escapeSql(enrolledBy) +
                "', @p_productId='" + escapeSql(productId) +
                "', @p_removeTrainingIds='" + escapeSql(removeTrainingCsv) +
                "', @p_updatedBy='" + escapeSql(safeUpdatedBy) + "';";

            logger.info("value for removeEnrollmentTraining: {}", value);

            em.createNamedStoredProcedureQuery("coupon_management_Routines")
              .setParameter("actionType", "removeEnrolmentTraining")
              .setParameter("actionValue", value)
              .execute();
        }

        resp.setCode("success");
        resp.setMessage("Training removed successfully");

    } catch (Exception e) {
        resp.setCode("failed");
        resp.setMessage(e.getMessage());
        logger.error("removeEnrollmentTraining error", e);
    }

    logger.info("Method : removeEnrollmentTraining Dao ends");
    return resp;
}


}
