package nirmalya.aatithya.restmodule.lms.dao;

import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;

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
	    logger.info("method: saveCourse Starts");
 
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
			String value = "SET @p_courseId='" + Id + "';";

			logger.info("vvvv" + value);
			List<Object[]> x = em.createNamedStoredProcedureQuery("academic_course_routines")
					.setParameter("actionType", "editCourseTrainingDetails").setParameter("actionValue", value).getResultList();
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
	public ResponseEntity<JsonResponse<Object>> saveCourseDuration(String data, String userId, String org, String orgDiv) {
	    logger.info("method: saveCourseDuration Starts");

	    JsonResponse<Object> resp = new JsonResponse<>();
	    JSONObject jsonObj = new JSONObject(data);

	    try {
	        String courseId = jsonObj.optString("courseId");
	        String fileName = jsonObj.optString("fileName");
	        String fileType = jsonObj.optString("fileType");
	        String duration = jsonObj.optString("duration");

	        // 🔹 Prepare params
	        String value = "SET @data='" + data + "', @p_userId='" + userId + "', @p_org='" + org +
	                       "',@p_courseId='" + courseId + "', @p_orgDiv='" + orgDiv +
	                       "',@p_firstName='" + fileName + "',@p_fileType='" + fileType +
	                       "',@p_duration='" + duration + "';";

	        logger.info("Constructed actionValue: " + value);

	        // 🔹 Insert duration
	        em.createNamedStoredProcedureQuery("academic_course_routines")
	            .setParameter("actionType", "saveCourseDuration")
	            .setParameter("actionValue", value)
	            .execute();

	        // 🔹 Fetch durations for this course
	        List<Object[]> resultList = em.createNamedStoredProcedureQuery("academic_course_routines")
	            .setParameter("actionType", "getCourseDurations")
	            .setParameter("actionValue", "SET @p_courseId='" + courseId + "';")
	            .getResultList();

	        // 🔹 Convert result to List<Map>
	        List<Map<String, Object>> durationList = new ArrayList<>();
	        for (Object[] row : resultList) {
	            Map<String, Object> obj = new HashMap<>();
	            obj.put("durationId", row[0]);
	            obj.put("userId", row[1]);
	            obj.put("courseId", row[2]);
	            obj.put("fileName", row[3]);
	            obj.put("fileType", row[4]);
	            obj.put("duration", row[5]);
	            obj.put("createdOn", row[6]);
	            obj.put("createdBy", row[7]);
	            obj.put("orgName", row[8]);
	            obj.put("orgDivision", row[9]);
	            durationList.add(obj);
	        }

	        // ✅ Return list as body
	        resp.setBody(durationList);
	        resp.setMessage("Data save successfully");
	        resp.setCode("Success");

	    } catch (Exception e) {
	        logger.error("Error in saveCourseDuration: ", e);
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
	    logger.info("method: saveCourseDuration Ends " + response);
	    return response;
	}

	
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
}
