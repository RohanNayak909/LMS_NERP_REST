package nirmalya.aatithya.restmodule.lms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.util.StringUtil;

@Repository
	public class PromotionMarketingRestDao {
		Logger logger = LoggerFactory.getLogger(PromotionMarketingRestDao.class);

		@Autowired
		EntityManager em;

		@Autowired
		ServerDao serverDao;

		
//View
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewCoupon(String orgName, String orgDivision) {
			logger.info("Method : viewCoupon Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
				logger.info("value=========="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
						.setParameter("actionType", "viewCoupon").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewCoupon Dao ends");
			return resp;

		}
// ADD
		// @SuppressWarnings("unchecked")
		// public JsonResponse<Object> addCoupon(Map<String, Object> couponJsonData) {
		//     logger.info("Method : addCoupon starts");

		//     JsonResponse<Object> resp = new JsonResponse<>();


		//     if (couponJsonData == null || couponJsonData.isEmpty()) {
		//         resp.setCode("failed");
		//         resp.setMessage("coupon data cannot be empty.");
		//         return resp;
		//     }

		//     String orgName = (String) couponJsonData.get("orgName");
		//     String orgDiv = (String) couponJsonData.get("orgDiv");
		//     String couponId = (String) couponJsonData.get("couponId");
		//     String couponNo = (String) couponJsonData.get("couponNo");
		//     String discount = (String) couponJsonData.get("discount");
		//     String createdById = (String) couponJsonData.get("createdById");
		//     String price = (String) couponJsonData.get("price");
		//     String validFrom = (String) couponJsonData.get("validFrom");
		//     String validTo = (String) couponJsonData.get("validTo");
		//     String status = (String) couponJsonData.get("status");
		    
		//     List<Map<String, Object>> rows = (List<Map<String, Object>>) couponJsonData.get("rows");
		    
		//     String rowsJson = "";
		//     ObjectMapper objectMapper = new ObjectMapper();
		//     try {
		//         rowsJson = objectMapper.writeValueAsString(rows);
		//     } catch (Exception e) {
		//         resp.setCode("failed");
		//         resp.setMessage("Failed to process coupon rows.");
		//         return resp;
		//     }
		
	 
		//     String value = "SET @p_orgName='" + orgName + "', " +
		//                    "@p_orgDiv='" + orgDiv + "', " +
		//                    "@p_couponNo='" + couponNo + "', " +
		//                    "@p_discount='" + discount + "', " +
		//                    "@p_couponId='" + couponId + "', " +
		//                    "@p_price='" + price + "', " +
		//                    "@p_createdById='" + createdById + "', " +
		//                    "@p_validFrom='" + validFrom + "', " +
		//                    "@p_validTo='" + validTo + "', " +
		//                    "@p_status='" + status + "', " +
		//                    "@p_rows='" + rowsJson + "';";

	    //      System.out.println("Values For coupon Reocrd=======>>>>"+value);
		//     if (StringUtil.isNull(couponId)) {
		    	
		//         em.createNamedStoredProcedureQuery("coupon_management_Routines")
		//                 .setParameter("actionType", "addCoupon")
		//                 .setParameter("actionValue", value)
		//                 .execute();
		//         resp.setCode("success");
		//         resp.setMessage("Coupon Details added successfully.");
		//     } else {
		        
		//             logger.info("Modifying an existing coupon record...");
		//              em.createNamedStoredProcedureQuery("coupon_management_Routines")
		//                     .setParameter("actionType", "modifyCoupon")
		//                     .setParameter("actionValue", value)
		//                     .execute();
		//             resp.setCode("success");
		//             resp.setMessage("Coupon Details updated successfully.");
		//         } 
		    

		//     logger.info("Method : addCoupon ends");
		//     return resp;
		// }
//


		@SuppressWarnings("unchecked")
		public JsonResponse<Object> savePromotionMarketing(Map<String, Object> requestJsonData) {
		    logger.info("Method : savePromotionMarketing starts");
		    logger.info("Received payload: {}", requestJsonData);

		    JsonResponse<Object> resp = new JsonResponse<>();

		    if (requestJsonData == null || requestJsonData.isEmpty()) {
		        resp.setCode("failed");
		        resp.setMessage("Request data cannot be empty.");
		        return resp;
		    }

		    String type = (String) requestJsonData.get("type");
		    if (type == null || (!type.equals("coupon") && !type.equals("marketing"))) {
		        resp.setCode("failed");
		        resp.setMessage("Invalid or missing type. Must be 'coupon' or 'marketing'.");
		        return resp;
		    }

		    try {
		        String orgName = (String) requestJsonData.get("orgName");
		        String orgDiv = (String) requestJsonData.get("orgDiv");
		        String createdById = (String) requestJsonData.get("createdById");

		        if ("coupon".equals(type)) {
		            // Coupon-specific fields
		            String couponId = (String) requestJsonData.get("couponId");
		            String couponNo = (String) requestJsonData.get("couponNo");
		            String discount = (String) requestJsonData.get("discount");
		            String price = (String) requestJsonData.get("price");
		            String validFrom = (String) requestJsonData.get("validFrom");
		            String validTo = (String) requestJsonData.get("validTo");
		            String status = (String) requestJsonData.get("status");
		            List<Map<String, Object>> rows = (List<Map<String, Object>>) requestJsonData.get("rows");

		            // Convert rows to JSON
		            String rowsJson = "";
		            if (rows != null) {
		                ObjectMapper objectMapper = new ObjectMapper();
		                try {
		                    rowsJson = objectMapper.writeValueAsString(rows);
		                } catch (Exception e) {
		                    resp.setCode("failed");
		                    resp.setMessage("Failed to process coupon rows.");
		                    return resp;
		                }
		            }

		            // Build stored procedure parameters
		            String value = "SET @p_orgName='" + orgName + "', " +
		                          "@p_orgDiv='" + orgDiv + "', " +
		                          "@p_couponNo='" + couponNo + "', " +
		                          "@p_discount='" + discount + "', " +
		                          "@p_couponId='" + couponId + "', " +
		                          "@p_price='" + price + "', " +
		                          "@p_createdById='" + createdById + "', " +
		                          "@p_validFrom='" + validFrom + "', " +
		                          "@p_validTo='" + validTo + "', " +
		                          "@p_status='" + status + "', " +
		                          "@p_rows='" + rowsJson + "';";

		            logger.info("Values for coupon record: {}", value);

		            // Execute stored procedure
		            String actionType = StringUtil.isNull(couponId) ? "addCoupon" : "modifyCoupon";
		            em.createNamedStoredProcedureQuery("coupon_management_Routines")
		                    .setParameter("actionType", actionType)
		                    .setParameter("actionValue", value)
		                    .execute();

		            resp.setCode("success");
		            resp.setMessage(StringUtil.isNull(couponId) ? "Coupon Details added successfully." : "Coupon Details updated successfully.");
		        } else if ("marketing".equals(type)) {
		            // Marketing-specific fields
		            String marketingId = (String) requestJsonData.get("marketingId");
		            String marketName = (String) requestJsonData.get("marketName");
		            String startDate = (String) requestJsonData.get("startDate");
		            String endDate = (String) requestJsonData.get("endDate");
		            String status = (String) requestJsonData.get("status");
		            String documentName = (String) requestJsonData.get("documentName"); // Extract document name if present
                    String description = (String) requestJsonData.get("description");

		            // Build stored procedure parameters
		            StringBuilder valueBuilder = new StringBuilder("SET @p_orgName='" + orgName + "', " +
		                                                          "@p_orgDiv='" + orgDiv + "', " +
		                                                          "@p_marketingId='" + marketingId + "', " +
		                                                          "@p_marketName='" + marketName + "', " +
		                                                          "@p_startDate='" + startDate + "', " +
		                                                          "@p_endDate='" + endDate + "', " +
		                                                          "@p_createdById='" + createdById + "', " +
		                                                          "@p_status='" + status + "'");
		            
		            // Append documentName only if it's not null or empty
		            if (!StringUtil.isNull(documentName)) {
		                valueBuilder.append(", @p_documentName='" + documentName + "'");
		            }

                    if (!StringUtil.isNull(description)) {
        valueBuilder.append(", @p_description='" + description + "'");
    }
		            
		            String value = valueBuilder.toString() + ";";

		            logger.info("Values for marketing record: {}", value);

		            // Execute stored procedure
		            String actionType = StringUtil.isNull(marketingId) ? "addMarketing" : "modifyMarketing";
		            em.createNamedStoredProcedureQuery("coupon_management_Routines")
		                    .setParameter("actionType", actionType)
		                    .setParameter("actionValue", value)
		                    .execute();

		            resp.setCode("success");
		            resp.setMessage(StringUtil.isNull(marketingId) ? "Marketing added successfully." : "Marketing updated successfully.");
		        }
		    } catch (Exception e) {
		        logger.error("Error in savePromotionMarketing: ", e);
		        resp.setCode("failed");
		        resp.setMessage("Failed to save data: " + e.getMessage());
		    }

		    logger.info("Method : savePromotionMarketing ends");
		    return resp;
		}
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> editCoupon(String orgName, String orgDiv,String couponId) {
			logger.info("Method : editCoupon Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_orgName='" + orgName + "',@p_orgDiv='" + orgDiv + "',@p_couponId='"+couponId+"';";
				System.out.println("editCoupon========>" + value);
				logger.info("Alert Data Value" + value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
						.setParameter("actionType", "editCoupon").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : editCoupon Dao ends"+resp);
			return resp;

		}
//
		 @SuppressWarnings("unchecked")
		    public JsonResponse<Object> deletCoupon(String couponId,String orgName, String orgDiv) {
		        logger.info("Method : deletCoupon Dao starts");

		        JsonResponse<Object> resp = new JsonResponse<Object>();

		        try {
		             
		            String value = "SET @p_couponId='" + couponId + "',@p_orgName='" + orgName + "',@p_orgDivision='" + orgDiv + "';";
		            System.out.println("deletCoupon========>" + value);

		            Object x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
		                    .setParameter("actionType", "deletCoupon").setParameter("actionValue", value)
		                    .getSingleResult();
		            System.out.println("value of x ------->>>>> "+x.toString());
		            if(Integer.parseInt(x.toString()) > 0) {
						resp.setCode("success");
			  			resp.setMessage("Coupon Details Deleted successfully");
		  			}

		        } catch (Exception e) {
		            resp.setCode("failed");
		            resp.setMessage(e.getMessage());
		            e.printStackTrace();
		        }

		        logger.info("Method : deletCoupon Dao ends" + resp);
		        return resp;
		    }
// View Course List
		
			@SuppressWarnings("unchecked")
			public JsonResponse<Object> viewCourseList(String orgName, String orgDivision) {
				logger.info("Method : viewCourseList Dao starts");

				JsonResponse<Object> resp = new JsonResponse<Object>();

				try {
					String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
					List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
							.setParameter("actionType", "viewCourseList").setParameter("actionValue", value).getResultList();
					resp.setBody(x.get(0));
					resp.setCode("success");
					resp.setMessage("Data Fetched successfully");
				} catch (Exception e) {
					e.printStackTrace();
				}
				logger.info("Method : viewCourseList Dao ends");
				return resp;

			}
			

			@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllProductDetails() {
			logger.info("Method : getAllProductDetails Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
						.setParameter("actionType", "getAllProductDetails").setParameter("actionValue", "")
						.getResultList();
				resp.setBody(x);

				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllProductDetails Dao ends");

			return resp;

		}



		// ---------------------------------------------NEW------------------------------------------



		@SuppressWarnings("unchecked")
		public JsonResponse<Object> getAllProductDetailsnew() {
			logger.info("Method : getAllProductDetailsnew Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {

				List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
						.setParameter("actionType", "getAllProductDetailsnew").setParameter("actionValue", "")
						.getResultList();
				resp.setBody(x);

				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} catch (Exception e) {
				resp.setCode("failed");
				resp.setMessage(e.getMessage());
				e.printStackTrace();
			}

			logger.info("Method : getAllProductDetailsnew Dao ends");

			return resp;

		}


		@SuppressWarnings("unchecked")
		public ResponseEntity<JsonResponse<Object>> saveCourseCoupon(String quizData, String userId, String org, String orgDiv) {
		    logger.info("method: saveCourseCoupon Starts"+quizData);

		    JsonResponse<Object> resp = new JsonResponse<>();
		    try {
		        // Validate and clean JSON data
		        ObjectMapper mapper = new ObjectMapper();
		        ObjectNode jsonNode = (ObjectNode) mapper.readTree(quizData);
		        
		        // Extract courseId early using Jackson for reliability
		        String couponId = "";
		        if (jsonNode.has("couponId") && !jsonNode.get("couponId").isNull()) {
		        	couponId = jsonNode.get("couponId").asText();
		            logger.info("Extracted couponId from JSON: " + couponId);
		        } else {
		            logger.info("No couponId found in JSON or couponId is null");
		            resp.setCode("Failed");
		            resp.setMessage("couponId ID is required to save.");
		            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		        }

		        // Optional: Clean quizMappings array if any text fields need processing
		        // (e.g., if future extensions add descriptions; for now, minimal validation)
		        if (jsonNode.has("activityMappings")) {
		            ArrayNode mappingsArray = (ArrayNode) jsonNode.get("activityMappings");
		            for (JsonNode mapping : mappingsArray) {
		                if (!mapping.has("courseId") || !mapping.has("couponId") || !mapping.has("status")) {
		                    logger.error("Invalid mapping structure in activityMappings");
		                    resp.setCode("Failed");
		                    resp.setMessage("Invalid  mapping structure.");
		                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		                }
		            }
		        }

		        // Serialize to JSON with proper escaping
		        String safeData = mapper.writeValueAsString(jsonNode);
		        logger.info("Serialized safeData: " + safeData);
		        // Escape single quotes for MySQL (avoid excessive backslash escaping)
		        safeData = safeData.replace("'", "''");

		        String value = "SET @activityData='" + safeData + "', @p_userId='" + userId + "', @p_org='" + org
		                + "', @p_orgDiv='" + orgDiv + "';";
		        logger.info("Constructed actionValue: " + value);

		        // Execute stored procedure for saving/updating quiz mappings
		        // Assumes stored procedure handles insert/update/delete based on provided mappings
		        // (e.g., delete existing mappings for courseId, then insert new ones)
		        logger.info("Saving quiz mappings for courseId: " + couponId);
		        em.createNamedStoredProcedureQuery("coupon_management_Routines")
		                .setParameter("actionType", "saveCourseCoupon")
		                .setParameter("actionValue", value)
		                .execute();
		        resp.setMessage("Coupon Allocated successfully!");
		        resp.setCode("Success");
		         
		    } catch (Exception e) {
		        logger.error("Error: " + e.getMessage());
		        try {
		            String[] err = serverDao.errorProcedureCall(e);
		            resp.setCode("Failed");
		            resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
		        } catch (Exception nestedException) {
		            logger.error("Error while handling exception: " + nestedException.getMessage());
		            resp.setCode("Failed");
		            resp.setMessage("Oops! Something went wrong during error handling");
		        }
		    }

		    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
		    logger.info("method: saveCourseCoupon Ends: " + response);
		    return response;
		}
		
		
		@SuppressWarnings("unchecked")
		public JsonResponse<Object> viewCourse(String orgName, String orgDivision,String id) {
			logger.info("Method : viewCourse Dao starts");

			JsonResponse<Object> resp = new JsonResponse<Object>();

			try {
				String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
				logger.info("value=========="+value);
				List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
						.setParameter("actionType", "viewCouponCourse").setParameter("actionValue", value).getResultList();
				resp.setBody(x.get(0));
				resp.setCode("success");
				resp.setMessage("Data Fetched successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			logger.info("Method : viewCourse Dao ends");
			return resp;

		}
		
}
