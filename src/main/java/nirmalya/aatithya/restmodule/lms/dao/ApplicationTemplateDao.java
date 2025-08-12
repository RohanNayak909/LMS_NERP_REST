package nirmalya.aatithya.restmodule.lms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import nirmalya.aatithya.restmodule.common.ServerDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

@Repository
public class ApplicationTemplateDao {

	Logger logger = LoggerFactory.getLogger(ApplicationTemplateDao.class);

	@Autowired
	EntityManager em;

	@Autowired
	ServerDao serverDao;

	// save vital details
	public ResponseEntity<JsonResponse<Object>> saveStudentDetail(String studentData) {
		logger.info("method: saveLocation Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(studentData);

			String studentId = jsonObj.optString("studentId");
			String studentName = jsonObj.optString("studentName");
			String course = jsonObj.optString("course");
			String gender = jsonObj.optString("gender");
			String email = jsonObj.optString("email");
			String mobile = jsonObj.optString("mobile");
			String college = jsonObj.optString("college");
			String location = jsonObj.optString("location");

			String value = "SET @studentId='" + studentId + "', @studentName='" + studentName + "', " + "@course='"
					+ course + "', @gender='" + gender + "', @email='" + email + "', " + "@mobile='" + mobile
					+ "', @college='" + college + "', @location='" + location + "';";

			System.out.println("value:::::::" + value);

			if (studentId != null && studentId != "") {
				System.out.println("calling Modify_StudentDetails");
				em.createNamedStoredProcedureQuery("student_management_routine")
						.setParameter("actionType", "modifyStudentDetails").setParameter("actionValue", value)
						.execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			} else {
				System.out.println("calling Save_StudentDetails");
				em.createNamedStoredProcedureQuery("student_management_routine")
						.setParameter("actionType", "saveStudent").setParameter("actionValue", value).execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in save-student-details: ", e);
			resp.setMessage("Error saving student details!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: savedetails Ends");
		return response;
	}

	// view
	// view nomine-Dao
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewStudent(String orgName, String orgDivision) {
		logger.info("Method : viewStudent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values for Petient view====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("student_management_routine")
					.setParameter("actionType", "viewStudent").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStudent Dao ends" + resp);
		return resp;
	}

	// Delete -->>>>>
	public ResponseEntity<JsonResponse<Object>> deleteStudent(String id) {
		logger.info("Method : deleteStudent starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @studentId='" + id + "';";

			System.out.println("value:::::" + value);

			em.createNamedStoredProcedureQuery("student_management_routine").setParameter("actionType", "deleteStudent")
					.setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted Successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteStudent ends");
		return response;
	}

	// Application Handle Start Here -------->>>>>>>>
	// save Application-Data
	public ResponseEntity<JsonResponse<Object>> saveApplicationDetail(String applicationData) {
		logger.info("method: saveLocation Starts");

		JsonResponse<Object> resp = new JsonResponse<>();

		try {
			JSONObject jsonObj = new JSONObject(applicationData);

			String applicationId = jsonObj.optString("applicationId");
			String programName = jsonObj.optString("programName");
			String specialisation = jsonObj.optString("specialisation");
			String duration = jsonObj.optString("duration");
			String intakeCapacity = jsonObj.optString("intakeCapacity");
			String totalFee = jsonObj.optString("totalFee");
			String applicationFee = jsonObj.optString("applicationFee");
			String programDesc = jsonObj.optString("programDesc");
			String applicationSD = jsonObj.optString("applicationSD");
			String applicationED = jsonObj.optString("applicationED");
			String eligibility = jsonObj.optString("eligibility");
			String requiredDocs = jsonObj.optString("documentDtls");
			String programImage = jsonObj.optString("programImage");
			String country = jsonObj.optString("country");
			String states = jsonObj.optString("states");
			String district = jsonObj.optString("district");
			String cityId = jsonObj.optString("cityId");
			String format = jsonObj.optString("format");
			String applicationSummary = jsonObj.optString("applicationSummary");

			String value = "SET @programName='" + programName + "', " + "@specialisation='" + specialisation + "', "
					+ "@duration='" + duration + "', " + "@intakeCapacity='" + intakeCapacity + "', " + "@totalFee='"
					+ totalFee + "', " + "@applicationFee='" + applicationFee + "', " + "@programDesc='" + programDesc
					+ "', " + "@applicationSD='" + applicationSD + "', " + "@applicationED='" + applicationED + "', "
					+ "@eligibility='" + eligibility + "', " + "@requiredDocs='" + requiredDocs + "', "
					+ "@programImage='" + programImage + "', " + "@country='" + country + "', " + "@states='" + states
					+ "', " + "@district='" + district + "', " + "@cityId='" + cityId + "', " + "@applicationSummary='"
					+ applicationSummary + "', " + "@applicationFormat='" + format + "', " + "@applicationId='"
					+ applicationId + "';";

			System.out.println("value:::::::" + value);

			System.out.println("calling Save_StudentDetails");
			if (applicationId != null && !applicationId.isEmpty()) {
				System.out.println("calling modifyApplication");
				em.createNamedStoredProcedureQuery("lms_application_routine")
						.setParameter("actionType", "modifyApplication").setParameter("actionValue", value).execute();

				resp.setMessage("Data modified successfully!");
				resp.setCode("Success");
			} else {
				System.out.println("calling saveApplicationDetails");
				em.createNamedStoredProcedureQuery("lms_application_routine")
						.setParameter("actionType", "saveApplicationDetails").setParameter("actionValue", value)
						.execute();

				resp.setMessage("Data saved successfully!");
				resp.setCode("Success");
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in save-student-details: ", e);
			resp.setMessage("Error saving student details!");
			resp.setCode("Error");
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<>(resp, HttpStatus.CREATED);

		logger.info("method: savedetails Ends");
		return response;
	}

	// view Application-Dao
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> viewApplication(String orgName, String orgDivision) {
		logger.info("Method : viewStudent Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @p_org='" + orgName + "',@p_orgDiv='" + orgDivision + "';";

			logger.info("values for Application view====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "viewApplication").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : viewStudent Dao ends" + resp);
		return resp;
	}

	// Edit Application -->>>>>>>
	@SuppressWarnings("unchecked")
	public JsonResponse<Object> editApplication(String id) {
		logger.info("Method : editApplication Dao starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {
			String value = "SET @applicationId='" + id + "'";

			logger.info("values for Application edit====================" + value);

			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "editApplication").setParameter("actionValue", value).getResultList();
			resp.setBody(x.get(0));
			resp.setCode("success");
			resp.setMessage("Data Fetched successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Method : editApplication Dao ends" + resp);
		return resp;
	}

	// Delete Application-->>>>>
	public ResponseEntity<JsonResponse<Object>> deleteApplication(String id) {
		logger.info("Method : deleteApplication starts");

		JsonResponse<Object> resp = new JsonResponse<Object>();

		try {

			String value = "SET @applicationId='" + id + "';";

			System.out.println("value:::::" + value);

			em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "deleteApplicationData").setParameter("actionValue", value).execute();

			resp.setCode("success");
			resp.setMessage("Data Deleted Successfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

		ResponseEntity<JsonResponse<Object>> response = new ResponseEntity<JsonResponse<Object>>(resp,
				HttpStatus.CREATED);

		logger.info("Method : deleteApplication ends");
		return response;
	}

	// countryList
	@SuppressWarnings("unchecked")
	public List<DropDownModel> countryList() {

		logger.info("Method :countryList starts");

		List<DropDownModel> countryList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "countryList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				countryList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : countryList ends" + countryList);

		return countryList;
	}

	// getStateList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getApplicationStateList(String id) {

		logger.info("Method : getApplicationStateList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_country='" + id + "';";
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "getStateList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : getApplicationStateList ends");
		return response;
	}

	// districtList
	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> districtList(String id) {

		logger.info("Method : districtList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_state='" + id + "';";
		System.out.println("District ID -->>>>" + value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "district").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : districtList ends");
		return response;
	}

	// cityList

	@SuppressWarnings("unchecked")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(String id) {

		logger.info("Method : cityList starts");
		List<DropDownModel> stateList = new ArrayList<DropDownModel>();

		JsonResponse<List<DropDownModel>> resp = new JsonResponse<List<DropDownModel>>();

		String value = "SET @p_dist='" + id + "';";
		System.out.println(value);
		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "cityList").setParameter("actionValue", value).getResultList();
			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				stateList.add(dropDownModel);
			}

			resp.setBody(stateList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		ResponseEntity<JsonResponse<List<DropDownModel>>> response = new ResponseEntity<JsonResponse<List<DropDownModel>>>(
				resp, HttpStatus.CREATED);

		logger.info("Method : cityList ends");
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<DropDownModel> courseList() {

		logger.info("Method :courseList starts");

		List<DropDownModel> studentCourseList = new ArrayList<DropDownModel>();

		try {
			List<Object[]> x = em.createNamedStoredProcedureQuery("lms_application_routine")
					.setParameter("actionType", "studentCourseList").setParameter("actionValue", "").getResultList();

			for (Object[] m : x) {
				DropDownModel dropDownModel = new DropDownModel(m[0], m[1]);
				studentCourseList.add(dropDownModel);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		logger.info("Method : courseList ends" + studentCourseList);

		return studentCourseList;
	}

}
