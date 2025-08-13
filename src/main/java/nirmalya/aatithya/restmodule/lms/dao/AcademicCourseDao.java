package nirmalya.aatithya.restmodule.lms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
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
	public ResponseEntity<JsonResponse<Object>> saveCourse(String courseData, String userId, String org,
			String orgDiv) {
		logger.info("method: saveCourse Starts");

		JsonResponse<Object> resp = new JsonResponse<>();
		try {
			String value = "SET @courseData='" + courseData + "', @p_userId='" + userId + "', @p_org='" + org
					+ "', @p_orgDiv='" + orgDiv + "';";

			String courseId = "";
			logger.info("Constructed actionValue: " + value);
			try {
				Gson gson = new Gson();
				JsonObject jsonObject = gson.fromJson(courseData, JsonObject.class);
				if (jsonObject.has("courseId")) {
					courseId = jsonObject.get("courseId").getAsString();
				}
			} catch (Exception parseException) {
				logger.error("Error parsing courseData with Gson: ", parseException);
			}

			if (courseId == null || courseId.isEmpty()) {
				em.createNamedStoredProcedureQuery("academic_course_routines").setParameter("actionType", "saveCourse")
						.setParameter("actionValue", value).execute();

				resp.setMessage("Course created successfully!");
				resp.setCode("Success");
			} else {
				em.createNamedStoredProcedureQuery("academic_course_routines")
						.setParameter("actionType", "modifyCourse").setParameter("actionValue", value).execute();

				resp.setMessage("Course modified successfully!");
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

		logger.info("method: saveCourse Ends" + response);
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
	public JsonResponse<Object> viewStudent(String orgName, String orgDivision) {
		logger.info("Method : viewStudent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";
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

}
