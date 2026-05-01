package nirmalya.aatithya.restmodule.lms.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.cloud.Timestamp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

 import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
@Repository
public class AcademicCourseDao {
	Logger logger = LoggerFactory.getLogger(AcademicCourseDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveCourse(String courseData, String userId, String org, String orgDiv) {
	    logger.info("method: saveCourse Starts"+courseData);
 
	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        // Validate and clean JSON data
	        ObjectMapper mapper = new ObjectMapper();
	        ObjectNode jsonNode = (ObjectNode) mapper.readTree(courseData);
	        // Clean courseDesc field
	        if (jsonNode.has("courseDesc")) {
	            String courseDesc = jsonNode.get("courseDesc").asText();
	            logger.info("Raw courseDesc: " + courseDesc);
	            // Decode URL-encoded characters if present
	            try {
	                courseDesc = URLDecoder.decode(courseDesc.replace("% ", "%20"), StandardCharsets.UTF_8.name());
	            } catch (Exception e) {
	                logger.warn("URL decoding failed for courseDesc: " + e.getMessage());
	                // Fallback to raw courseDesc if decoding fails
	            }
	            // Clean excessive backslashes and escape sequences
	            courseDesc = courseDesc.replaceAll("\\\\{2,}", "").replaceAll("\\\\n", "").replaceAll("\\\\t", "");
	            logger.info("Cleaned courseDesc: " + courseDesc);
	            jsonNode.put("courseDesc", courseDesc);
	        }
	        // Extract courseId early using Jackson for reliability
	        String courseId = "";
	        if (jsonNode.has("courseId") && !jsonNode.get("courseId").isNull()) {
	            courseId = jsonNode.get("courseId").asText();
	            logger.info("Extracted courseId from JSON: " + courseId);
	        } else {
	            logger.info("No courseId found in JSON or courseId is null");
	        }
 
	        // Serialize to JSON with proper escaping
	        String safeCourseData = mapper.writeValueAsString(jsonNode);
	        logger.info("Serialized safeCourseData: " + safeCourseData);
	        // Escape single quotes for MySQL (avoid excessive backslash escaping)
	        safeCourseData = safeCourseData.replace("'", "''");
 
	        String value = "SET @courseData='" + safeCourseData + "', @p_userId='" + userId + "', @p_org='" + org
	                + "', @p_orgDiv='" + orgDiv + "';";
	        logger.info("Constructed actionValue: " + value);
            System.out.println("Value For The Course----->"+value);
	        // Execute saveCourse or modifyCourse based on courseId
 
			if (courseId == null || courseId.trim().isEmpty()) {
				logger.info("Creating new course (courseId is null or empty)");
				em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveCourse")
						.setParameter("actionValue", value).execute();
				resp.setMessage("Course created successfully!");
				resp.setCode("Success");
			} else {
				logger.info("Modifying existing course with courseId: " + courseId);
				em.createNamedStoredProcedureQuery("academic_course_routines")
						.setParameter("actionType", "modifyCourse").setParameter("actionValue", value).execute();
				resp.setMessage("Course modified successfully!");
				resp.setCode("Success");
			}
			
	    } catch (Exception e) {
	        logger.error("Error in saveCourse: " + e.getMessage()); // Changed from info to error for severity
	        try {
	            String[] err = serverDao.errorProcedureCall(e);
	            resp.setCode("Failed");
	            resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
	        } catch (Exception nestedException) {
	            logger.error("Error while handling exception: " + nestedException.getMessage()); // Changed from info to error
	            resp.setCode("Failed");
	            resp.setMessage("Oops! Something went wrong during error handling");
	        }
	    }
 
	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: saveCourse Ends: " + response);
	    return response;
	}
	
	
	
	@SuppressWarnings({ "unchecked", "unused" })
	public ResponseEntity<JsonResponse<Object>> saveTraining(String payload, String userId, String org, String orgDiv) {
	    logger.info("method: saveTraining Starts " + payload);

	    JsonResponse<Object> resp = new JsonResponse<>();
	    String courseId = "";

	    try {
	        // ✅ Gson with HTML escaping disabled
	        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	        JsonObject jsonObject = gson.fromJson(payload, JsonObject.class);

	        // ✅ Get courseId
	        if (jsonObject.has("courseId")) {
	            courseId = jsonObject.get("courseId").getAsString();
	        }

	        // ✅ Convert categoryData to JSON array and clean content
	        if (jsonObject.has("categoryData")) {
	            String categoryDataStr = jsonObject.get("categoryData").getAsString();
	            JsonArray categoryArray = gson.fromJson(categoryDataStr, JsonArray.class);

	            for (int i = 0; i < categoryArray.size(); i++) {
	                JsonObject obj = categoryArray.get(i).getAsJsonObject();
	                if (obj.has("content")) {
	                    String content = obj.get("content").getAsString();
	                    // Clean control characters and replace non-breaking space
	                    content = content.replace("\n", "")
	                                     .replace("\r", "")
	                                     .replace("\t", " ")
	                                     .replace("\u00A0", " ");
	                    // Do NOT escape \ or ' here - let JSON handle it, and escape ' for SQL later on the full payload
	                    obj.addProperty("content", content);
	                }
	                // Optionally, ensure no documentFile remnants in JSON (already removed upstream)
	                if (obj.has("documents")) {
	                    JsonArray docsArray = obj.getAsJsonArray("documents");
	                    for (int j = 0; j < docsArray.size(); j++) {
	                        JsonObject docObj = docsArray.get(j).getAsJsonObject();
	                        if (docObj.has("documentFile")) {
	                            docObj.remove("documentFile");
	                        }
	                    }
	                }
	            }

	            // Replace categoryData with cleaned array
	            jsonObject.add("categoryData", categoryArray);
	        }

	        // ✅ Convert full JSON object to string
	        String safePayload = gson.toJson(jsonObject);

	        // ✅ Escape backslashes for MySQL string literal (double them to preserve JSON escapes)
	        safePayload = safePayload.replace("\\", "\\\\");

	        // ✅ Escape single quotes for SQL string literal
	        safePayload = safePayload.replace("'", "''");

	        // ✅ Escape parameters for SQL
	        String escapedUserId = userId.replace("'", "''");
	        String escapedOrg = org.replace("'", "''");
	        String escapedOrgDiv = orgDiv.replace("'", "''");

	        // ✅ Construct SET @data for MySQL
	        String actionValue = "SET @data='" + safePayload + "', " +
	                             "@p_userId='" + escapedUserId + "', " +
	                             "@p_org='" + escapedOrg + "', " +
	                             "@p_orgDiv='" + escapedOrgDiv + "';";

	        logger.info("Constructed actionValue for MySQL: " + actionValue);

	        // ✅ Determine actionType
	        String actionType = (courseId != null && !courseId.isEmpty()) ? "saveTraining" : "modifyTraining";

	        // ✅ Execute stored procedure
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	          .setParameter("actionType", actionType)
	          .setParameter("actionValue", actionValue)
	          .execute();

	        resp.setMessage((actionType.equals("saveTraining") ? "Added" : "Modified") + " Training Successfully!");
	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in saveTraining: ", e);
	        resp.setCode("Failed");
	        resp.setMessage(e.getMessage());
	    }

	    ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);
	    logger.info("method: saveTraining Ends " + response);
	    return response;
	}

	// view
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCourse(String orgName, String orgDivision) {
		logger.info("Method : viewCourse Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewCourse").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewCourse Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteTraining(String orgName, String orgDivision, String trainingId) {

	    logger.info("Method : deleteTraining Dao starts");

	    JsonResponse<Object> resp = new JsonResponse<>();

	    try {
	        String value = "SET @p_org='" + orgName + 
	                       "',@p_orgDiv='" + orgDivision + 
	                       "',@p_trainingId='" + trainingId + "';";
	        
	        logger.info("SP PARAM VALUE: " + value);

	        Object result = em.createNamedStoredProcedureQuery("academic_course_routines")
	                .setParameter("actionType", "delete-training")
	                .setParameter("actionValue", value)
	                .getSingleResult();

	        logger.info("SP RESULT (ROW COUNT) : " + result);

	        int rowCount = 0;

	        try {
	            rowCount = Integer.parseInt(String.valueOf(result));
	        } catch (Exception ex) {
	            rowCount = 0;
	        }

	        if (rowCount > 0) {
	            resp.setCode("success");
	            resp.setMessage("Training Deleted Successfully!");
	        } else {
	            resp.setCode("failed");
	            resp.setMessage("No record deleted. Training not found.");
	        }

	        resp.setBody(trainingId);

	    } catch (Exception e) {
	        logger.error("Exception in deleteTraining DAO:", e);

	        resp.setCode("failed");
	        resp.setMessage("Something went wrong!");
	    }

	    logger.info("Method : deleteTraining Dao ends");
	    return resp;
	}

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> coursequiz(String orgName, String orgDivision) {
		logger.info("Method : coursequiz Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info("valuej"+value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewcoursequiz").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("quizz" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : coursequiz Dao ends");
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewtraining(String orgName, String orgDivision,String id) {
		logger.info("Method : viewCourse Dao starts"+id);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewTraining").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("tttttttttttttttttttttt" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewCourse Dao ends");
		return resp;

	}

	// edit

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCourse(String Id, String organization, String orgDivision) {
		logger.info("Method : editCourse Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_courseId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "editCourse").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editCourse Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewEmpolyee(String orgName, String orgDivision) {
		logger.info("Method : viewEmpolyee Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewEmpolyee").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewEmpolyee Dao ends");
		return resp;

	}

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveAssign(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveAssign Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @data='" + data + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";

			String assignId = "";
			logger.info("Constructed actionValue: " + value);
			System.out.println("Constructed actionValue: " + value);
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
				if (jsonObject.has("assignId")) {
					assignId = jsonObject.get("assignId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing courseData with Gson: ", parseException);
			}

			if (assignId == null || assignId.isEmpty()) {
				em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveAssign")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Instructor Assigned Successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("academic_course_routines")
						.setParameter("actionType", "modifyAssign").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			}
		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveAssign Ends" + response);
		return response;
	}

	// view list
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewList(String orgName, String orgDivision) {
		logger.info("Method : viewList Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewList").setParameter("actionValue", value).getResultList();
			resp.setBody(list);
			logger.info("hhhhhhhhhhhhhhhhh" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewList Dao ends");
		return resp;

	}

//
	//
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCourseAutoSearchList(String id, String orgName,
			String orgDiv) {
		logger.info("Method : getCourseAutoSearchList starts");

		List<DropDownModel> itemNameList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_searchValue='" + id + "',@p_org='" + orgName + "',@p_orgDiv='" + orgDiv + "';";
		System.out.println("hhhhhhhhhhhhhhhhh" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
					.setParameter("actionType", "getCourseAutoSearchList").setParameter("actionValue", value)
					.getResultList();
			for (Object[] m : x) {

				DropDownModel dropDownModel = new DropDownModel(m[0], m[1], m[2], m[3], m[4], m[5]);

				itemNameList.add(dropDownModel);
			}

			resp.setBody(itemNameList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);
		logger.info("Method : getCourseAutoSearchList ends" + response);
		return response;
	}

	//
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCourses(String orgName, String orgDivision, String courseId) {
		logger.info("Method : viewCourses Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_courseId='" + courseId
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("coupon_management_Routines")
					.setParameter("actionType", "viewCourses").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewCourses Dao ends" + resp);
		return resp;

	}

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewCatlog(String orgName, String orgDivision, String catId, String level) {
		logger.info("Method : viewCatlog Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "', @p_orgDiv='" + orgDivision + "', @p_catId='" + catId
					+ "', @p_level='" + level + "';";
			logger.info("Stored Procedure Input: {}", value);

			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewCatlog").setParameter("actionValue", value).getResultList();

			resp.setBody(list);
			logger.info("Stored Procedure Result: {}", list);
		} catch (Exception e) {
			logger.error("Exception in viewCatlog:", e);
		}

		logger.info("Method : viewCatlog Dao ends");
		return resp;
	}

	// viewStudent
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStudent(String orgName, String orgDivision,String id) {
		logger.info("Method : viewStudent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='"+id+"';";
			System.out.println("aaaaaaaaaaaaaaaaaaa: " + value);

			List<Object[]> result = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewStudent").setParameter("actionValue", value).getResultList();

			if (!result.isEmpty()) {
				resp.setBody(result.get(0)); // Assuming JSON_OBJECT result
				resp.setCode("success");
				resp.setMessage("Data fetched successfully");
			} else {
				resp.setMessage("No data found");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.setCode("error");
			resp.setMessage("Exception while fetching data");
		}

		logger.info("Method : viewStudent Dao ends : " + resp);
		return resp;
	}
	public JsonResponse<Object> enableCourse(String id, String status) {
		logger.info("Method : enableCourse starts");
		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			String value = "SET @p_studentId='" + id + "', @p_status='" + status + "';";
			System.out.println("Executing: " + value);

			em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "enableCourse")
					.setParameter("actionValue", value).execute();

			resp.setCode("200");
			resp.setMessage("Success");
		} catch (Exception e) {
			logger.error("Error in enableCourse: ", e);
			resp.setCode("500");
			resp.setMessage("Error: " + e.getMessage());
			Map<String, String> errorMap = new HashMap<>();
			errorMap.put("error", e.getMessage());
			resp.setBody(errorMap);
		}

		logger.info("Method : enableCourse ends");
		return resp;
	}

	// save
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveCourseContent(String data, String userId, String org, String orgDiv,
			String courseId) {
		logger.info("method: saveCourseContent Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @data='" + data + "', @p_userId='" + userId + "', @p_org='" + org + "',@p_courseId='" + courseId + "', @p_orgDiv='"
					+ orgDiv + "';";

			logger.info("Constructed actionValue: " + value);

			em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveCourseContent")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Data save successfully");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveCourseContent Ends" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCourseDetails(String orgName, String orgDivision, String courseId) {
		logger.info("Method : getCourseDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_courseId='" + courseId
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getCourseDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCourseDetails Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveCorseModule(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveCorseModule Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @data='" + data + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";

			logger.info("Constructed actionValue: " + value);

			em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveCorseModule")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Module save successfully");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveCorseModule Ends" + response);
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveCourseLession(String data, String userId, String org, String orgDiv) {
		logger.info("method: saveCourseLession Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @data='" + data + "', @p_userId='" + userId + "', @p_org='" + org + "', @p_orgDiv='"
					+ orgDiv + "';";

			logger.info("Constructed actionValue: " + value);

			em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveCourseLession")
					.setParameter("actionValue", value).execute();

			resp.setMessage("Lession save successfully");
			resp.setCode("Success");

		} catch (Exception e) {
			logger.error("Error in saveCourse: ", e);
			try {
				String[] err = serverDao.errorProcedureCall(e);
				resp.setCode("Failed");
				resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong");
			} catch (Exception nestedException) {
				logger.error("Error while handling exception: ", nestedException);
				resp.setCode("Failed");
				resp.setMessage("Oops! Something went wrong during error handling");
			}
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: saveCourseLession Ends" + response);
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getCourseLessions(String orgName, String orgDivision, String moduleId) {
		logger.info("Method : getCourseLessions Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_moduleId='" + moduleId
					+ "';";
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getCourseLessions").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : getCourseLessions Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllHeadCount(String orgName, String orgDivision, String userId) {
		logger.info("Method : getAllHeadCount Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getAllHeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllHeadCount Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllOperationalRecord(String orgName, String orgDivision, String userId,String id) {
		logger.info("Method : getAllOperationalRecord Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ,@p_id='" + id + "';";
			
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getAllOperationalRecord").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllOperationalRecord Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllUserTraining(String orgName, String orgDivision, String userId,String id) {
		logger.info("Method : getAllUserTraining Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "' ,@p_id='" + id + "';";
			
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getAllUserTraining").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getAllUserTraining Dao ends" + resp);
		return resp;

	}
	
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCourseDetails(String Id, String organization, String orgDivision) {
		logger.info("Method : editCourseDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_courseId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "editCourseDetails").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editCourseDetails Dao ends" + resp);
		return resp;

	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editCourseTrainingDetails(String Id, String organization, String orgDivision) {
		logger.info("Method : editCourseTrainingDetails Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_userId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getAllUserTraining").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
			resp.setMessage("Something Went Wrong !");
		}
		logger.info("Method : editCourseTrainingDetails Dao ends" + resp);
		return resp;

	}
	
	
	// save duration
	/*
	 * @SuppressWarnings("unchecked") public ResponseEntity<JsonResponse<Object>>
	 * saveCourseDuration(String data, String userId, String org, String orgDiv) {
	 * logger.info("method: saveCourseDuration Starts");
	 * 
	 * JsonResponse<Object> resp = new JsonResponse<>(); JSONObject jsonObj = new
	 * JSONObject(data); try { String courseId = jsonObj.optString("courseId");
	 * String fileName = jsonObj.optString("fileName"); String fileType =
	 * jsonObj.optString("fileType"); String duration =
	 * jsonObj.optString("duration");
	 * 
	 * 
	 * 
	 * 
	 * String value = "SET @data='" + data + "', @p_userId='" + userId +
	 * "', @p_org='" + org + "',@p_courseId='" + courseId + "', @p_orgDiv='" +
	 * orgDiv + "',@p_firstName='" + fileName + "',@p_fileType='" + fileType +
	 * "',@p_duration='" + duration + "';";
	 * 
	 * logger.info("Constructed actionValue: " + value);
	 * 
	 * em.createNamedStoredProcedureQuery("academic_course_routines").setParameter(
	 * "actionType", "saveCourseDuration") .setParameter("actionValue",
	 * value).execute();
	 * 
	 * resp.setMessage("Data save successfully"); resp.setCode("Success");
	 * 
	 * } catch (Exception e) { logger.error("Error in saveCourse: ", e); try {
	 * String[] err = serverDao.errorProcedureCall(e); resp.setCode("Failed");
	 * resp.setMessage(err.length > 1 ? err[1] : "Oops! Something went wrong"); }
	 * catch (Exception nestedException) {
	 * logger.error("Error while handling exception: ", nestedException);
	 * resp.setCode("Failed");
	 * resp.setMessage("Oops! Something went wrong during error handling"); } }
	 * 
	 * ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp,
	 * HttpStatus.CREATED);
	 * 
	 * logger.info("method: saveCourseDuration Ends" + response); return response; }
	 */

	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getadminAllHeadCount(String orgName, String orgDivision, String userId) {
		logger.info("Method : getadminAllHeadCount Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getadminAllHeadCount").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getadminAllHeadCount Dao ends" + resp);
		return resp;

	}
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveCouponDetails(Map<String, Object> payload) {
	    logger.info("Method : saveCouponDetails DAO starts");

	    JsonResponse<Object> resp = new JsonResponse<Object>();

	    // 🔹 Log incoming payload values for debugging
	    for (Map.Entry<String, Object> entry : payload.entrySet()) {
	        logger.info("{} = {}", entry.getKey(), entry.getValue());
	    }

	    try {
	        // ✅ Extract parameters safely from payload
	        String orgName = (String) payload.get("orgName");
	        String orgDivision = (String) payload.get("orgDivision");
	        String loginUserId = (String) payload.get("loginUserId");
	        String userId = (String) payload.get("userId");
	        String couponCode = (String) payload.get("couponCode");
	        String productId = (String) payload.get("productId");
	        String trainingId = (String) payload.get("trainingId");
	        String enrollId = (String) payload.get("enrollId");

	        // ✅ Build SQL parameter string for stored procedure
	        String value = String.format(
	            "SET @p_org='%s', @p_orgDiv='%s', @p_loginUserId='%s', @p_userId='%s', " +
	            "@p_enrollId='%s', @p_productId='%s', @p_trainingId='%s', @p_couponCode='%s';",
	            orgName, orgDivision, loginUserId, userId, enrollId, productId, trainingId, couponCode
	        );

	        logger.info("Executing stored procedure with params: {}", value);

	        // ✅ Execute stored procedure (no need to fetch result)
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	            .setParameter("actionType", "addCouponDetails")
	            .setParameter("actionValue", value)
	            .execute();

	        // ✅ If execution succeeds, set a success response
	        resp.setCode("success");
	        resp.setMessage("Coupon details saved successfully.");
	        resp.setBody(null);

	    } catch (Exception e) {
	        logger.error("Error in saveCouponDetails DAO:", e);
	        resp.setCode("failed");
	        resp.setMessage("Database operation failed: " + e.getMessage());
	        resp.setBody(null);
	    }

	    logger.info("Method : saveCouponDetails DAO ends with response: {}", resp);
	    return resp;
	} 
 
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deleteCoupon(Map<String, Object> payload) {
	    logger.info("Method : deleteCoupon DAO starts");
	    JsonResponse<Object> resp = new JsonResponse<Object>();

	    try {
	        // ✅ Extract params safely
	        String orgName = (String) payload.get("orgName");
	        String orgDivision = (String) payload.get("orgDivision");
	        String loginUserId = (String) payload.get("loginUserId");
	        String userId = (String) payload.get("userId");
	        String productId = (String) payload.get("productId");
	        String trainingId = (String) payload.get("trainingId");
	        String enrollId = (String) payload.get("enrollId");
	        String couponCode = (String) payload.get("couponCode");

	        // ✅ Build SQL parameter string
	        String value = String.format(
	            "SET @p_org='%s', @p_orgDiv='%s', @p_loginUserId='%s', " +
	            "@p_userId='%s', @p_enrollId='%s', @p_productId='%s', " +
	            "@p_trainingId='%s', @p_couponCode='%s';",
	            orgName, orgDivision, loginUserId, userId, enrollId, productId, trainingId, couponCode
	        );

	        logger.info("Executing stored procedure for deleteCouponDetails with params: {}", value);

	        // ✅ Execute procedure
	        Object result = em.createNamedStoredProcedureQuery("academic_course_routines")
	                .setParameter("actionType", "deleteCouponDetails")
	                .setParameter("actionValue", value)
	                .getSingleResult();

	        // ✅ Convert result safely
	        int rowsAffected = 0;
	        if (result != null) {
	            try {
	                rowsAffected = ((Number) result).intValue();
	            } catch (Exception ex) {
	                logger.warn("Unexpected ROW_COUNT() result type: {} → {}", result.getClass(), result);
	            }
	        }

 	        if (rowsAffected > 0) {
	            resp.setCode("success");
	            resp.setMessage("Coupon deleted successfully.");
	        } else {
	            resp.setCode("failed");
	            resp.setMessage("No matching coupon found to delete.");
	        }

	    } catch (Exception e) {
	        logger.error("Error in deleteCoupon DAO:", e);
	        resp.setCode("failed");
	        resp.setMessage("Failed to delete coupon: " + e.getMessage());
	    }

	    logger.info("Method : deleteCoupon DAO ends with response: {}", resp);
	    return resp;
	}



	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getRecentPurchaseCourses(String orgName, String orgDivision, String userId) {
		logger.info("Method : getRecentPurchaseCourses Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_userId='" + userId + "';";
			
			logger.info(value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "get-recent-purchase").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getRecentPurchaseCourses Dao ends" + resp);
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getExcelData(String orgName, String orgDivision, String id) {
		logger.info("Method : getExcelData Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			
			logger.info("Value For The excel data------>"+value);
			
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "get-excel-data").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}

		logger.info("Method : getExcelData Dao ends" + resp);
		return resp;

	}
	
	// DAO Method (e.g., in AcademicCourseDao.java)
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<Object>> saveQuizMappings(String quizData, String userId, String org, String orgDiv) {
	    logger.info("method: saveQuizMappings Starts"+quizData);

	    JsonResponse<Object> resp = new JsonResponse<>();
	    try {
	        // Validate and clean JSON data
	        ObjectMapper mapper = new ObjectMapper();
	        ObjectNode jsonNode = (ObjectNode) mapper.readTree(quizData);
	        
	        // Extract courseId early using Jackson for reliability
	        String courseId = "";
	        if (jsonNode.has("courseId") && !jsonNode.get("courseId").isNull()) {
	            courseId = jsonNode.get("courseId").asText();
	            logger.info("Extracted courseId from JSON: " + courseId);
	        } else {
	            logger.info("No courseId found in JSON or courseId is null");
	            resp.setCode("Failed");
	            resp.setMessage("Course ID is required to save quiz mappings.");
	            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	        }

	        // Optional: Clean quizMappings array if any text fields need processing
	        // (e.g., if future extensions add descriptions; for now, minimal validation)
	        if (jsonNode.has("quizMappings")) {
	            ArrayNode mappingsArray = (ArrayNode) jsonNode.get("quizMappings");
	            for (JsonNode mapping : mappingsArray) {
	                // Validate structure (courseId, quizCode, status)
	                if (!mapping.has("courseId") || !mapping.has("quizCode") || !mapping.has("status")) {
	                    logger.error("Invalid mapping structure in quizMappings");
	                    resp.setCode("Failed");
	                    resp.setMessage("Invalid quiz mapping structure.");
	                    return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
	                }
	                // Example cleaning for hypothetical text field
	                // if (mapping.has("quizDesc")) { ... similar to courseDesc in saveCourse }
	            }
	        }

	        // Serialize to JSON with proper escaping
	        String safeQuizData = mapper.writeValueAsString(jsonNode);
	        logger.info("Serialized safeQuizData: " + safeQuizData);
	        // Escape single quotes for MySQL (avoid excessive backslash escaping)
	        safeQuizData = safeQuizData.replace("'", "''");

	        String value = "SET @quizData='" + safeQuizData + "', @p_userId='" + userId + "', @p_org='" + org
	                + "', @p_orgDiv='" + orgDiv + "';";
	        logger.info("Constructed actionValue: " + value);

	        // Execute stored procedure for saving/updating quiz mappings
	        // Assumes stored procedure handles insert/update/delete based on provided mappings
	        // (e.g., delete existing mappings for courseId, then insert new ones)
	        logger.info("Saving quiz mappings for courseId: " + courseId);
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	                .setParameter("actionType", "saveCourseQuizMappings")
	                .setParameter("actionValue", value)
	                .execute();
	        resp.setMessage("Quiz mappings saved successfully!");
	        resp.setCode("Success");
	         
	    } catch (Exception e) {
	        logger.error("Error in saveQuizMappings: " + e.getMessage());
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
	    logger.info("method: saveQuizMappings Ends: " + response);
	    return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewPublicBatches(String orgName, String orgDivision,String id) {
		logger.info("Method : viewPublicBatches Dao starts"+id);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewPublicBatches").setParameter("actionValue", value).getResultList();
			/*
			 * resp.setBody(list); logger.info("viewPublicBatches" + list); } catch
			 * (Exception e) { e.printStackTrace(); }
			 */
		resp.setBody(list);
		resp.setCode("success");
		resp.setMessage("Data fetched successfully");
	} catch (Exception e) {
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}
		
		logger.info("Method : viewPublicBatches Dao ends");
		return resp;

	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> deletePublicBatches(Map<String, Object> payload) {
	    logger.info("Method : deletePublicBatches Dao starts");

	    JsonResponse<Object> resp = new JsonResponse<>();

	    try {
	        // ➤ Extract fields from payload
	        List<Map<String, Object>> list =
	                (List<Map<String, Object>>) payload.get("deleteList");

	        String orgName = payload.get("orgName").toString();
	        String orgDivision = payload.get("orgDivision").toString();

	        // ➤ Build comma-separated ids & names
	        List<String> ids = new ArrayList<>();
	        List<String> names = new ArrayList<>();

	        for (Map<String, Object> item : list) {
	            ids.add(item.get("trainingId").toString());
	            names.add(item.get("name").toString());
	        }

	        String idString = String.join(",", ids);
	        String nameString = String.join(",", names);

	        // ➤ Stored procedure params
	        String value =
	                "SET @p_ids='" + idString +
	                "',@p_org='" + orgName +
	                "',@p_orgDiv='" + orgDivision +
	                "',@p_name='" + nameString + "';";

	        logger.info("deletePublicBatches Params : " + value);

	        // ➤ Execute SP
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	                .setParameter("actionType", "delete-public-bacthes")
	                .setParameter("actionValue", value)
	                .execute();

	        resp.setCode("success");
	        resp.setMessage("Public batches deleted successfully");

	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage(e.getMessage());
	        e.printStackTrace();
	    }

	    logger.info("Method : deletePublicBatches Dao ends");
	    return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> coursedelete(Map<String, Object> payload) {
	    logger.info("Method : coursedelete Dao starts");

	    JsonResponse<Object> resp = new JsonResponse<>();

	    try {
	        // ➤ Extract fields from payload
	        List<Map<String, Object>> list =
	                (List<Map<String, Object>>) payload.get("deleteList");

	        String orgName = payload.get("orgName").toString();
	        String orgDivision = payload.get("orgDivision").toString();

	        // ➤ Build comma-separated ids & names
	        List<String> ids = new ArrayList<>();

	        for (Map<String, Object> item : list) {
	            ids.add(item.get("courseId").toString());
	        }

	        String idString = String.join(",", ids);

	        // ➤ Stored procedure params
	        String value =
	                "SET @p_ids='" + idString +
	                "',@p_org='" + orgName +
	                "',@p_orgDiv='" + orgDivision + "';";

	        logger.info("deletePublicBatches Params : " + value);

	        // ➤ Execute SP
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	                .setParameter("actionType", "deletecourse")
	                .setParameter("actionValue", value)
	                .execute();

	        resp.setCode("success");
	        resp.setMessage("Course deleted successfully");

	    } catch (Exception e) {
	        resp.setCode("failed");
	        resp.setMessage(e.getMessage());
	        e.printStackTrace();
	    }

	    logger.info("Method : coursedelete Dao ends");
	    return resp;
	}
	
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> addContentData(Map<String, Object> payload) {
		logger.info("Method : addContentData DAO starts");
	
		JsonResponse<Object> resp = new JsonResponse<>();
	
		try {
			String contentId        = asText(payload.get("contentId"));
			String contentType      = asText(payload.get("contentType"));
			String category         = asText(payload.get("category"));
			String title            = asText(payload.get("title"));
			String shortDesc        = asText(payload.get("shortDescription"));
			String fullDesc         = asText(payload.get("fullDescription"));
			String author           = asText(payload.get("author"));
	
			// ✅ IMPORTANT: normalize active/inactive → a/i (because DB column is varchar(1))
			String status           = normalizeStatus(asText(payload.get("status")));
	
			String publishDate      = asText(payload.get("publishDate"));
	
			String slug             = asText(payload.get("slug"));
			String metaDesc         = asText(payload.get("metaDescription"));
			String metaKeywords     = asText(payload.get("metaKeywords"));
			String canonicalUrl     = asText(payload.get("canonicalUrl"));
	
			String organizationName = asText(payload.get("todOrgName"));
			String orgDivision      = asText(payload.get("todOrgDivision"));
			String site             = asText(payload.get("site"));
			String orgName          = asText(payload.get("orgName"));
			String division         = asText(payload.get("division"));
	
			String loginUserId      = asText(payload.get("loginUserId"));
			String uploadedFile     = asText(payload.get("uploadedFile"));
	
			StringBuilder sb = new StringBuilder(2048);
			sb.append("SET ");
	
			if (hasText(contentId)) {
				sb.append("@p_contentId=").append(sql(contentId)).append(",");
			}
	
			sb.append("@p_contentType=").append(sql(contentType)).append(",")
			  .append("@p_category=").append(sql(category)).append(",")
			  .append("@p_title=").append(sql(title)).append(",")
			  .append("@p_shortDesc=").append(sql(shortDesc)).append(",")
			  .append("@p_fullDesc=").append(sql(fullDesc)).append(",")
			  .append("@p_author=").append(sql(author)).append(",")
			  .append("@p_status=").append(sql(status)).append(",")
			  .append("@p_publishDate=").append(sql(publishDate)).append(",")
	
			  .append("@p_slug=").append(sql(slug)).append(",")
			  .append("@p_metaDesc=").append(sql(metaDesc)).append(",")
			  .append("@p_metaKeywords=").append(sql(metaKeywords)).append(",")
			  .append("@p_canonicalUrl=").append(sql(canonicalUrl)).append(",")
	
			  .append("@p_organizationName=").append(sql(organizationName)).append(",")
			  .append("@p_orgDivision=").append(sql(orgDivision)).append(",")
			  .append("@p_site=").append(sql(site)).append(",")
			  .append("@p_orgName=").append(sql(orgName)).append(",")
			  .append("@p_division=").append(sql(division)).append(",")
	
			  .append("@p_userId=").append(sql(loginUserId)).append(",")
			  .append("@p_uploadedFile=").append(sql(uploadedFile));
			  // ✅ NO trailing semicolon
	
			String actionValue = sb.toString();
			logger.info("📌 CMS SP PARAMS: {}", actionValue);
	
			String actionType = (!hasText(contentId)) ? "add-cms-content" : "modify-cms-content";
			logger.info("📌 CMS actionType: {}", actionType);
	
			callAcademicCourseRoutinesJdbc(actionType, actionValue);
	
			resp.setCode("success");
			resp.setMessage("CMS content processed successfully");
	
		} catch (Exception e) {
			// ✅ IMPORTANT: return ROOT cause, not generic "error executing work"
			Throwable root = e;
			while (root.getCause() != null && root.getCause() != root) {
				root = root.getCause();
			}
			resp.setCode("failed");
			resp.setMessage(root.getMessage());
			logger.error("❌ DAO Error (root): {}", root.getMessage(), e);
		}
	
		logger.info("Method : addContentData DAO ends");
		return resp;
	}
	
	/** JDBC call that safely drains all results/update counts to avoid getMoreResults issues */
	private void callAcademicCourseRoutinesJdbc(String actionType, String actionValue) {
		Session session = em.unwrap(Session.class);
	
		session.doWork((Connection con) -> {
			try (CallableStatement cs = con.prepareCall("{call academic_course_routines(?, ?)}")) {
	
				cs.setString(1, actionType);
				cs.setString(2, actionValue);
	
				boolean hasResultSet = cs.execute();
	
				// Drain all result sets + update counts
				while (true) {
					if (hasResultSet) {
						try (ResultSet rs = cs.getResultSet()) {
							// ignore
						}
					} else {
						int updateCount = cs.getUpdateCount();
						if (updateCount == -1) break;
					}
					hasResultSet = cs.getMoreResults();
				}
	
			} catch (SQLException ex) {
				// ✅ This message will reach API response now
				String msg = "SQLState=" + ex.getSQLState()
						   + ", ErrCode=" + ex.getErrorCode()
						   + ", Msg=" + ex.getMessage();
				throw new RuntimeException(msg, ex);
			}
		});
	}
	
	/* ---------------- helpers ---------------- */
	
	private static String normalizeStatus(String s) {
		if (!hasText(s)) return null;
		String v = s.trim();
		if ("active".equalsIgnoreCase(v)) return "a";
		if ("inactive".equalsIgnoreCase(v)) return "i";
		if ("a".equalsIgnoreCase(v) || "i".equalsIgnoreCase(v)) return v.toLowerCase();
		return v;
	}
	
	private static boolean hasText(String s) {
		return s != null && !s.trim().isEmpty() && !"null".equalsIgnoreCase(s.trim());
	}
	
	private static String asText(Object v) {
		if (v == null) return null;
		String s = String.valueOf(v);
		if (!hasText(s)) return null;
		return s.trim();
	}
	
	/** returns SQL literal (quoted+escaped) or NULL */
	private static String sql(String v) {
		if (!hasText(v)) return "NULL";
		String escaped = v.replace("\\", "\\\\").replace("'", "''");
		return "'" + escaped + "'";
	}
	
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> getAllBlogs(String orgName, String orgDivision) {
		logger.info("Method : getAllBlogs Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "view-cms-data").setParameter("actionValue", value).getResultList();
			/*
			 * resp.setBody(list); logger.info("viewPublicBatches" + list); } catch
			 * (Exception e) { e.printStackTrace(); }
			 */
		resp.setBody(list);
		resp.setCode("success");
		resp.setMessage("Data fetched successfully");
	} catch (Exception e) {
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}
		
		logger.info("Method : getAllBlogs Dao ends");
		return resp;

	}

// course list in drop-down

@SuppressWarnings("unchecked")
	public List<DropDownModel> getCourseList(String org, String orgDiv) {
		logger.info("Method : getCourseList starts");
 
		List<DropDownModel> modeList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
		String value = "SET @p_org='" + org + "',@p_orgDiv='" + orgDiv + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "getCourseList").setParameter("actionValue", value)
					.getResultList();
 
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				modeList.add(dropDownModel);
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

			
 
		} catch (Exception e) {
			e.printStackTrace();
		}
 
		logger.info("Method : getCourseList ends");
		return modeList;
	}


	@SuppressWarnings("unchecked")
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();
		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();
 

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("Employee")
					.setParameter("actionType", "getCountryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
				
				if (dropDownModel.equals("")) {
					resp.setCode("success");
					resp.setMessage("Data not found");
				} else {
					resp.setCode("success");
					resp.setMessage("Data fetched successfully");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : getCountryList ends");

		return countryList;
	}




	@SuppressWarnings("unchecked")
	public JsonResponse<Object> saveContactData(String orgName, String orgDivision, String userId, String data) {
		logger.info("Method : saveContactData Dao starts" + data);
 
		JsonResponse<Object> resp = new JsonResponse<Object>();
		
		JSONObject jsonObj = new JSONObject(data);
		try {
			String name = jsonObj.optString("name");
		    String email = jsonObj.optString("email");
			String course = jsonObj.optString("course");
			String organization = jsonObj.optString("organization");
			String country = jsonObj.optString("country");
			String phone = jsonObj.optString("phone");
			String message = jsonObj.optString("message");
	
			
 
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_createdBy='" + userId
					+ "', @p_name='" + name + "', @p_email='" + email
					+ "', @p_course='" + course 
					+ "', @p_organization='" + organization + "', @p_country='" + country 
					+ "', @p_phone='" + phone + "', @p_message='" + message + "';";
 
			logger.info("value for items for saveContactData===================>" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "saveContactData").setParameter("actionValue", value).getResultList();
 
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data stored Successfully");
 
		} catch (Exception e) {
			resp.setCode("failed");
			resp.setMessage(e.getMessage());
			e.printStackTrace();
		}
		logger.info("Method : saveContactData Dao ends");
		return resp;
	}



//View Contact us

	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewContactUs(String orgName, String orgDivision,String id) {
		logger.info("Method : viewContactUs Dao starts"+id);

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "',@p_id='" + id + "';";
			logger.info(value);
			List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "viewContactUs").setParameter("actionValue", value).getResultList();
			/*
			 * resp.setBody(list); logger.info("viewPublicBatches" + list); } catch
			 * (Exception e) { e.printStackTrace(); }
			 */
		resp.setBody(list);
		resp.setCode("success");
		resp.setMessage("Data fetched successfully");
	} catch (Exception e) {
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		e.printStackTrace();
	}
		
		logger.info("Method : viewContactUs Dao ends");
		return resp;

	}







	@org.springframework.beans.factory.annotation.Autowired(required = false)

    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+(\\.[0-9]+)?$");




	@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<Object>> saveCourseDuration(
        String data, String userId, String org, String orgDiv) {

    logger.info("method: saveCourseDuration Starts");

    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        if (isBlank(userId)) return bad(resp, "Missing userId");
        if (isBlank(data))   return bad(resp, "Missing body");

        // org/orgDiv now optional
        org = trunc(org, 45);
        orgDiv = trunc(orgDiv, 45);

        JSONObject jsonObj = new JSONObject(data);

        String courseId = trunc(jsonObj.optString("courseId"), 60);
        String fileName = trunc(jsonObj.optString("fileName"), 512);
        String fileType = trunc(jsonObj.optString("fileType"), 50);
        String duration = trunc(jsonObj.optString("duration"), 30);

        String sessionUid    = trunc(jsonObj.optString("sessionUid"), 120);
        String deltaSeconds  = jsonObj.optString("deltaSeconds");

        // NEW: cross-device playback position fields (sent by frontend)
        String currentSeconds = jsonObj.optString("currentSeconds");
        String totalSeconds   = jsonObj.optString("totalSeconds");

        String location     = trunc(jsonObj.optString("location"), 255);
        String status       = trunc(jsonObj.optString("status"), 50);
        String scoreRaw     = trunc(jsonObj.optString("scoreRaw"), 30);
        String scoreScaled  = trunc(jsonObj.optString("scoreScaled"), 30);
        String eventType    = trunc(jsonObj.optString("eventType"), 50);
        String scormKey     = trunc(jsonObj.optString("scormKey"), 255);
        String scormValue   = trunc(jsonObj.optString("scormValue"), 8000);
        String suspendData  = trunc(jsonObj.optString("suspendData"), 60000);

        JSONObject meta = jsonObj.optJSONObject("meta");
        String metaSource = trunc(meta != null ? meta.optString("source") : "", 50);
        String metaReason = trunc(meta != null ? meta.optString("reason") : "", 100);
        String metaKey    = trunc(meta != null ? meta.optString("key") : "", 255);
        String metaValue  = trunc(meta != null ? meta.optString("value") : "", 2000);

        if (isBlank(courseId)) return bad(resp, "Missing courseId");
        if (isBlank(fileName)) return bad(resp, "Missing fileName");
        if (isBlank(fileType)) return bad(resp, "Missing fileType");
        if (isBlank(duration)) return bad(resp, "Missing duration");

        // sessionUid fallback (legacy deterministic)
        if (isBlank(sessionUid)) {
            String safeFile = fileName.replaceAll("[^a-zA-Z0-9]+", "_");
            sessionUid = "LEGACY_" + userId + "_" + courseId + "_" + safeFile;
        }
        sessionUid = trunc(sessionUid, 120);

        Long deltaSec = parseLongSafe(deltaSeconds, 0L);
        if (deltaSec < 0) deltaSec = 0L;
        if (deltaSec > 3600L) deltaSec = 3600L;

        Long curSec = parseLongSafe(currentSeconds, 0L);
        if (curSec < 0) curSec = 0L;
        if (curSec > 604800L) curSec = 604800L;

        Long totSec = parseLongSafe(totalSeconds, 0L);
        if (totSec < 0) totSec = 0L;
        if (totSec > 604800L) totSec = 604800L;

        String actionValue =
                "SET " +
                " @p_userId='" + esc(userId) + "'," +
                " @p_org='" + esc(nullIfBlank(org)) + "'," +
                " @p_orgDiv='" + esc(nullIfBlank(orgDiv)) + "'," +
                " @p_courseId='" + esc(courseId) + "'," +
                " @p_fileName='" + esc(fileName) + "'," +
                " @p_fileType='" + esc(fileType) + "'," +
                " @p_duration='" + esc(duration) + "'," +

                " @p_sessionUid='" + esc(sessionUid) + "'," +
                " @p_deltaSeconds=" + deltaSec + "," +

                // NEW:
                " @p_currentSeconds=" + curSec + "," +
                " @p_totalSeconds=" + totSec + "," +

                " @p_location='" + esc(nullIfBlank(location)) + "'," +
                " @p_status='" + esc(nullIfBlank(status)) + "'," +
                " @p_scoreRaw='" + esc(nullIfBlank(scoreRaw)) + "'," +
                " @p_scoreScaled='" + esc(nullIfBlank(scoreScaled)) + "'," +
                " @p_eventType='" + esc(nullIfBlank(eventType)) + "'," +
                " @p_scormKey='" + esc(nullIfBlank(scormKey)) + "'," +
                " @p_scormValue='" + esc(nullIfBlank(scormValue)) + "'," +
                " @p_suspendData='" + esc(nullIfBlank(suspendData)) + "'," +

                " @p_metaSource='" + esc(nullIfBlank(metaSource)) + "'," +
                " @p_metaReason='" + esc(nullIfBlank(metaReason)) + "'," +
                " @p_metaKey='" + esc(nullIfBlank(metaKey)) + "'," +
                " @p_metaValue='" + esc(nullIfBlank(metaValue)) + "';";

        em.createNamedStoredProcedureQuery("academic_course_routines")
                .setParameter("actionType", "saveCourseDuration")
                .setParameter("actionValue", actionValue)
                .execute();

        // return only this file’s latest progress (fast resume)
        List<Object[]> rows = em.createNamedStoredProcedureQuery("academic_course_routines")
                .setParameter("actionType", "getCourseDurations")
                .setParameter("actionValue", buildGetSet(userId, courseId, fileName, fileType))
                .getResultList();

        resp.setBody(mapCourseDurations(rows));
        resp.setCode("Success");
        resp.setMessage("Progress updated successfully");
        return new ResponseEntity<>(resp, HttpStatus.OK);

    } catch (Exception e) {
        logger.error("Error in saveCourseDuration: ", e);
        resp.setCode("Failed");
        resp.setMessage(resolveErrorMsg(e));
        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<Object>> getCourseDurations(
        String userId, String courseId, String fileName, String fileType) {

    logger.info("method: getCourseDurations Starts");

    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        if (isBlank(userId))   return bad(resp, "Missing userId");
        if (isBlank(courseId)) return bad(resp, "Missing courseId");

        fileName = trunc(fileName, 512);
        fileType = trunc(fileType, 50);

        List<Object[]> rows = em.createNamedStoredProcedureQuery("academic_course_routines")
                .setParameter("actionType", "getCourseDurations")
                .setParameter("actionValue", buildGetSet(userId, courseId, fileName, fileType))
                .getResultList();

        resp.setBody(mapCourseDurations(rows));
        resp.setCode("Success");
        resp.setMessage("Fetched durations");
        return new ResponseEntity<>(resp, HttpStatus.OK);

    } catch (Exception e) {
        logger.error("Error in getCourseDurations: ", e);
        resp.setCode("Failed");
        resp.setMessage("Failed to fetch durations");
        return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

/* =========================
   UPDATED mapper (matches new SELECT order)
========================= */
private Object mapCourseDurations(List<Object[]> rows) {
    List<Map<String, Object>> list = new ArrayList<>();

    for (Object[] r : rows) {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("durationId",         toLong(r, 0));
        m.put("userId",             toStr(r, 1));
        m.put("courseId",           toStr(r, 2));
        m.put("fileName",           toStr(r, 3));
        m.put("fileType",           toStr(r, 4));
        m.put("duration",           toBig(r, 5));

        m.put("totalSeconds",       toLong(r, 6));  // accumulated
        m.put("lastPositionSeconds",toLong(r, 7));  // NEW: resume position
        m.put("fileTotalSeconds",   toLong(r, 8));  // NEW: media duration

        m.put("lastLocation",       toStr(r, 9));
        m.put("status",             toStr(r,10));
        m.put("scoreRaw",           toBig(r,11));
        m.put("scoreScaled",        toBig(r,12));
        m.put("suspendData",        toStr(r,13));
        m.put("sessionUid",         toStr(r,14));
        m.put("updatedOn",          toTs(r,15));
        list.add(m);
    }

    Map<String, Object> out = new HashMap<>();
    out.put("durations", list);
    return out;
}

    /* =========================
       Helpers
    ========================= */

    private String buildGetSet(String userId, String courseId, String fileName, String fileType) {
        StringBuilder sb = new StringBuilder();
        sb.append("SET @p_userId='").append(esc(userId)).append("', ");
        sb.append("@p_courseId='").append(esc(courseId)).append("'");

        if (!isBlank(fileName)) sb.append(", @p_fileName='").append(esc(fileName)).append("'");
        if (!isBlank(fileType)) sb.append(", @p_fileType='").append(esc(fileType)).append("'");

        sb.append(";");
        return sb.toString();
    }


    private String resolveErrorMsg(Exception e) {
        try {
            if (serverDao != null) {
                String[] err = serverDao.errorProcedureCall(e);
                if (err != null && err.length > 1 && !isBlank(err[1])) return err[1];
            }
        } catch (Exception ignore) {}
        return "Oops! Something went wrong";
    }

    private ResponseEntity<JsonResponse<Object>> bad(JsonResponse<Object> resp, String msg) {
        resp.setCode("Failed");
        resp.setMessage(msg);
        resp.setBody(null);
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    private static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private static String nullIfBlank(String s) {
        return isBlank(s) ? "" : s.trim();
    }

    private static String trunc(String s, int max) {
        if (s == null) return "";
        String t = s.trim();
        return (t.length() <= max) ? t : t.substring(0, max);
    }

    private static String esc(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("'", "''");
    }

    private static Long parseLongSafe(String s, Long def) {
        try {
            if (isBlank(s)) return def;
            String t = s.trim();
            if (!t.matches("^-?\\d+$")) return def;
            return Long.parseLong(t);
        } catch (Exception e) {
            return def;
        }
    }

    private static String toStr(Object[] r, int idx) {
        Object v = (r != null && idx < r.length) ? r[idx] : null;
        return v == null ? "" : String.valueOf(v);
    }

    private static Long toLong(Object[] r, int idx) {
        Object v = (r != null && idx < r.length) ? r[idx] : null;
        if (v == null) return 0L;
        if (v instanceof Number) return ((Number) v).longValue();
        try { return Long.parseLong(String.valueOf(v)); } catch (Exception e) { return 0L; }
    }

    private static BigDecimal toBig(Object[] r, int idx) {
        Object v = (r != null && idx < r.length) ? r[idx] : null;
        if (v == null) return null;
        if (v instanceof BigDecimal) return (BigDecimal) v;
        if (v instanceof Number) return new BigDecimal(((Number) v).toString());
        try { return new BigDecimal(String.valueOf(v)); } catch (Exception e) { return null; }
    }

    private static String toTs(Object[] r, int idx) {
        Object v = (r != null && idx < r.length) ? r[idx] : null;
        if (v == null) return "";
        if (v instanceof Timestamp) return v.toString();
        return String.valueOf(v);
    }




	@SuppressWarnings("unchecked")
public JsonResponse<Object> getAllCourseDetailsWithTrainingsNoDocs(
        String orgName,
        String orgDivision,
        String categoryId,
        String subCategoryId,
        String search
) {
    logger.info("Method : getAllCourseDetailsWithTrainingsNoDocs Dao starts");

    JsonResponse<Object> resp = new JsonResponse<>();

    try {
        // Build actionValue like: SET @p_categoryId='..', @p_subCategoryId='..', @p_search='..';
        StringBuilder sb = new StringBuilder();
        boolean hasAny = false;

        sb.append("SET ");

        if (categoryId != null && !categoryId.trim().isEmpty()) {
            sb.append("@p_categoryId='").append(esc(categoryId)).append("',");
            hasAny = true;
        }
        if (subCategoryId != null && !subCategoryId.trim().isEmpty()) {
            sb.append("@p_subCategoryId='").append(esc(subCategoryId)).append("',");
            hasAny = true;
        }
        if (search != null && !search.trim().isEmpty()) {
            sb.append("@p_search='").append(esc(search)).append("',");
            hasAny = true;
        }

        // If nothing passed, send empty string so SP skips PREPARE block
        String value = "";
        if (hasAny) {
            value = sb.substring(0, sb.length() - 1) + ";"; // remove last comma
        }

        logger.info("SP actionValue: {}", value);

        List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
                .setParameter("actionType", "getAllCourseDetailsWithTrainingsNoDocs")
                .setParameter("actionValue", value)
                .getResultList();

        // Your SP returns 1 row / 1 column JSON_OBJECT → JPA gives Object[] with [0]=jsonString
        if (x != null && !x.isEmpty()) {
            resp.setBody(x.get(0)); // keep SAME pattern as your other methods
        } else {
            resp.setBody(new Object[] { "{\"productDetails\":[]}" });
        }

        resp.setCode("success");
        resp.setMessage("Data fetched successfully");

    } catch (Exception e) {
        logger.error("Error in getAllCourseDetailsWithTrainingsNoDocs DAO:", e);
        resp.setCode("failed");
        resp.setMessage(e.getMessage());
    }

    logger.info("Method : getAllCourseDetailsWithTrainingsNoDocs Dao ends");
    return resp;
}


@SuppressWarnings("unchecked")
public JsonResponse<Object> getTrainingPriceCountryList(String orgName, String orgDivision) {
	logger.info("Method : getTrainingPriceCountryList Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String value = "SET @p_org='" + orgName.replace("'", "''") + "',"
				+ "@p_orgDiv='" + orgDivision.replace("'", "''") + "';";

		logger.info("Action Value: {}", value);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "viewTrainingPriceCountryList")
				.setParameter("actionValue", value)
				.getResultList();

		resp.setBody(list);

	} catch (Exception e) {
		logger.error("Exception in getTrainingPriceCountryList Dao", e);
	}

	logger.info("Method : getTrainingPriceCountryList Dao ends");
	return resp;
}
@SuppressWarnings("unchecked")
public JsonResponse<Object> getTrainingPriceTrainingList(String orgName, String orgDivision, String courseId) {
	logger.info("Method : getTrainingPriceTrainingList Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String value = "SET @p_org='" + orgName.replace("'", "''") + "',"
				+ "@p_orgDiv='" + orgDivision.replace("'", "''") + "',"
				+ "@p_courseId='" + courseId.replace("'", "''") + "';";

		logger.info("Action Value: {}", value);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "viewTrainingPriceTrainingList")
				.setParameter("actionValue", value)
				.getResultList();

		logger.info("Training list raw DB result: {}", list);

		if (list != null && !list.isEmpty()) {
			resp.setBody(list);
		} else {
			resp.setBody(java.util.Collections.emptyList());
		}

	} catch (Exception e) {
		logger.error("Exception in getTrainingPriceTrainingList Dao", e);
		resp.setBody(java.util.Collections.emptyList());
	}

	logger.info("Method : getTrainingPriceTrainingList Dao ends");
	return resp;
}
@SuppressWarnings("unchecked")
public JsonResponse<Object> viewTrainingPricing(String orgName, String orgDivision, String courseId,
		String trainingId) {
	logger.info("Method : viewTrainingPricing Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String value = "SET @p_org='" + orgName.replace("'", "''") + "',"
				+ "@p_orgDiv='" + orgDivision.replace("'", "''") + "',"
				+ "@p_courseId='" + courseId.replace("'", "''") + "',"
				+ "@p_trainingId='" + trainingId.replace("'", "''") + "';";

		logger.info("Action Value: {}", value);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "viewTrainingPricing")
				.setParameter("actionValue", value)
				.getResultList();

		resp.setBody(list);

	} catch (Exception e) {
		logger.error("Exception in viewTrainingPricing Dao", e);
	}

	logger.info("Method : viewTrainingPricing Dao ends");
	return resp;
}



@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<Object>> saveTrainingPricing(String payload, String userId, String org,
		String orgDiv) {
	logger.info("Method: saveTrainingPricing Dao Starts {}", payload);

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		JsonObject jsonObject = gson.fromJson(payload, JsonObject.class);

		String courseId = jsonObject.has("courseId") && !jsonObject.get("courseId").isJsonNull()
				? jsonObject.get("courseId").getAsString()
				: "";
		String trainingId = jsonObject.has("trainingId") && !jsonObject.get("trainingId").isJsonNull()
				? jsonObject.get("trainingId").getAsString()
				: "";

		if (courseId == null || courseId.trim().isEmpty()) {
			resp.setCode("Failed");
			resp.setMessage("Course Id is required");
			return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (trainingId == null || trainingId.trim().isEmpty()) {
			resp.setCode("Failed");
			resp.setMessage("Training Id is required");
			return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		if (jsonObject.has("pricingRows") && jsonObject.get("pricingRows").isJsonArray()) {
			JsonArray pricingRows = jsonObject.getAsJsonArray("pricingRows");

			for (int i = 0; i < pricingRows.size(); i++) {
				JsonObject row = pricingRows.get(i).getAsJsonObject();

				String priceScope = row.has("priceScope") && !row.get("priceScope").isJsonNull()
						? row.get("priceScope").getAsString()
						: "";

				String countryId = row.has("countryId") && !row.get("countryId").isJsonNull()
						? row.get("countryId").getAsString()
						: "";

				if ("COUNTRY".equalsIgnoreCase(priceScope) && (countryId == null || countryId.trim().isEmpty())) {
					resp.setCode("Failed");
					resp.setMessage("Country is mandatory for COUNTRY scope rows");
					return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
				}

				if ("GLOBAL".equalsIgnoreCase(priceScope)) {
					row.addProperty("countryId", "GLOBAL");
					row.addProperty("countryCode", "GLOBAL");
					row.addProperty("countryName", "Global");
				}

				BigDecimal basePrice = getBigDecimal(row, "basePrice");
				BigDecimal taxPercent = getBigDecimal(row, "taxPercent");
				BigDecimal finalPrice = getBigDecimal(row, "finalPrice");

				if (basePrice.compareTo(BigDecimal.ZERO) < 0) {
					resp.setCode("Failed");
					resp.setMessage("Base price cannot be negative");
					return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
				}

				if (taxPercent.compareTo(BigDecimal.ZERO) < 0) {
					resp.setCode("Failed");
					resp.setMessage("Tax percent cannot be negative");
					return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
				}

				if (finalPrice.compareTo(BigDecimal.ZERO) < 0) {
					resp.setCode("Failed");
					resp.setMessage("Final price cannot be negative");
					return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
				}
			}
		}

		String safePayload = gson.toJson(jsonObject);
		safePayload = safePayload.replace("\\", "\\\\");
		safePayload = safePayload.replace("'", "''");

		String escapedUserId = userId.replace("'", "''");
		String escapedOrg = org.replace("'", "''");
		String escapedOrgDiv = orgDiv.replace("'", "''");

		String actionValue = "SET @data='" + safePayload + "', "
				+ "@p_userId='" + escapedUserId + "', "
				+ "@p_org='" + escapedOrg + "', "
				+ "@p_orgDiv='" + escapedOrgDiv + "';";

		logger.info("Constructed actionValue for saveTrainingPricing: {}", actionValue);

		em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "saveTrainingPricing")
				.setParameter("actionValue", actionValue)
				.execute();

		resp.setCode("Success");
		resp.setMessage("Training Pricing Saved Successfully!");

	} catch (Exception e) {
		logger.error("Exception in saveTrainingPricing Dao", e);
		resp.setCode("Failed");
		resp.setMessage(e.getMessage());
	}

	logger.info("Method: saveTrainingPricing Dao Ends");
	return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
}
@SuppressWarnings("unchecked")
public ResponseEntity<JsonResponse<Object>> deleteTrainingPricing(String payload, String userId, String org,
		String orgDiv) {
	logger.info("Method: deleteTrainingPricing Dao Starts {}", payload);

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		JsonObject jsonObject = gson.fromJson(payload, JsonObject.class);

		String priceId = jsonObject.has("priceId") && !jsonObject.get("priceId").isJsonNull()
				? jsonObject.get("priceId").getAsString()
				: "";

		if (priceId == null || priceId.trim().isEmpty()) {
			resp.setCode("Failed");
			resp.setMessage("Price Id is required");
			return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.BAD_REQUEST);
		}

		String escapedUserId = userId.replace("'", "''");
		String escapedOrg = org.replace("'", "''");
		String escapedOrgDiv = orgDiv.replace("'", "''");
		String escapedPriceId = priceId.replace("'", "''");

		String actionValue = "SET @p_userId='" + escapedUserId + "', "
				+ "@p_org='" + escapedOrg + "', "
				+ "@p_orgDiv='" + escapedOrgDiv + "', "
				+ "@p_priceId='" + escapedPriceId + "';";

		logger.info("Constructed actionValue for deleteTrainingPricing: {}", actionValue);

		em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "deleteTrainingPricing")
				.setParameter("actionValue", actionValue)
				.execute();

		resp.setCode("Success");
		resp.setMessage("Training Pricing Deleted Successfully!");

	} catch (Exception e) {
		logger.error("Exception in deleteTrainingPricing Dao", e);
		resp.setCode("Failed");
		resp.setMessage(e.getMessage());
	}

	logger.info("Method: deleteTrainingPricing Dao Ends");
	return new ResponseEntity<JsonResponse<Object>>(resp, HttpStatus.CREATED);
}


private BigDecimal getBigDecimal(JsonObject jsonObject, String key) {
	try {
		if (jsonObject.has(key) && !jsonObject.get(key).isJsonNull()) {
			String val = jsonObject.get(key).getAsString();
			if (val != null && !val.trim().isEmpty()) {
				return new BigDecimal(val.trim());
			}
		}
	} catch (Exception e) {
		logger.warn("Unable to parse decimal for key {}. Defaulting to 0", key);
	}
	return BigDecimal.ZERO;
}

@SuppressWarnings("unchecked")
public JsonResponse<Object> getCourseTrainingPricingMatrix(String courseId) {
	logger.info("Method : getCourseTrainingPricingMatrix Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String safeCourseId = courseId == null ? "" : courseId.replace("'", "''").trim();

		if (safeCourseId.isEmpty()) {
			resp.setCode("failed");
			resp.setMessage("Course Id is required");
			resp.setBody(null);
			return resp;
		}

		String value = "{\"courseId\":\"" + safeCourseId + "\"}";
		logger.info("Action Value: {}", value);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "getCourseTrainingPricingMatrix")
				.setParameter("actionValue", value)
				.getResultList();

		if (list != null && !list.isEmpty()) {
			resp.setBody(list.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} else {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage("No data found");
		}

	} catch (Exception e) {
		logger.error("Exception in getCourseTrainingPricingMatrix Dao", e);
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		resp.setBody(null);
	}

	logger.info("Method : getCourseTrainingPricingMatrix Dao ends");
	return resp;
}

@SuppressWarnings("unchecked")
public JsonResponse<Object> getAllProductDetailsWithPricingSummary(String countryCode) {
	logger.info("Method : getAllProductDetailsWithPricingSummary Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		String safeCountryCode = countryCode == null ? "" : countryCode.replace("'", "''").trim().toUpperCase();

		String value = "{\"countryCode\":\"" + safeCountryCode + "\"}";
		logger.info("Action Value: {}", value);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "getAllProductDetailsWithPricingSummary")
				.setParameter("actionValue", value)
				.getResultList();

		if (list != null && !list.isEmpty()) {
			resp.setBody(list.get(0));
			resp.setCode("success");
			resp.setMessage("Data fetched successfully");
		} else {
			resp.setBody(null);
			resp.setCode("failed");
			resp.setMessage("No data found");
		}

	} catch (Exception e) {
		logger.error("Exception in getAllProductDetailsWithPricingSummary Dao", e);
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		resp.setBody(null);
	}

	logger.info("Method : getAllProductDetailsWithPricingSummary Dao ends");
	return resp;
}

@SuppressWarnings("unchecked")
public JsonResponse<Object> publicVisitorInit(Map<String, Object> payload) {
	logger.info("Method : publicVisitorInit Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String safePayload = gson.toJson(payload);

		// keep JSON safe for MySQL string variable
		safePayload = safePayload.replace("\\", "\\\\");
		safePayload = safePayload.replace("'", "''");

		String actionValue = "SET @data='" + safePayload + "';";
		logger.info("publicVisitorInit actionValue: {}", actionValue);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "publicVisitorInit")
				.setParameter("actionValue", actionValue)
				.getResultList();

		if (list != null && !list.isEmpty()) {
			resp.setBody(list.get(0));
			resp.setCode("success");
			resp.setMessage("Visitor init stored successfully");
		} else {
			resp.setBody(null);
			resp.setCode("success");
			resp.setMessage("Visitor init executed successfully");
		}

	} catch (Exception e) {
		logger.error("Exception in publicVisitorInit Dao", e);
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		resp.setBody(null);
	}

	logger.info("Method : publicVisitorInit Dao ends");
	return resp;
}

@SuppressWarnings("unchecked")
public JsonResponse<Object> publicVisitorEvent(Map<String, Object> payload) {
	logger.info("Method : publicVisitorEvent Dao starts");

	JsonResponse<Object> resp = new JsonResponse<Object>();

	try {
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String safePayload = gson.toJson(payload);

		// keep JSON safe for MySQL string variable
		safePayload = safePayload.replace("\\", "\\\\");
		safePayload = safePayload.replace("'", "''");

		String actionValue = "SET @data='" + safePayload + "';";
		logger.info("publicVisitorEvent actionValue: {}", actionValue);

		List<Object[]> list = em.createNamedStoredProcedureQuery("academic_course_routines")
				.setParameter("actionType", "publicVisitorEvent")
				.setParameter("actionValue", actionValue)
				.getResultList();

		if (list != null && !list.isEmpty()) {
			resp.setBody(list.get(0));
			resp.setCode("success");
			resp.setMessage("Visitor event stored successfully");
		} else {
			resp.setBody(null);
			resp.setCode("success");
			resp.setMessage("Visitor event executed successfully");
		}

	} catch (Exception e) {
		logger.error("Exception in publicVisitorEvent Dao", e);
		resp.setCode("failed");
		resp.setMessage(e.getMessage());
		resp.setBody(null);
	}

	logger.info("Method : publicVisitorEvent Dao ends");
	return resp;
}
}
