package nirmalya.aatithya.restmodule.lms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.ApplicationTemplateDao;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping(value = { "master" })
public class ApplicationTemplateRestController {

	@Autowired
	ApplicationTemplateDao applicationTemplateDao;

	Logger logger = LoggerFactory.getLogger(ApplicationTemplateRestController.class);

	// Save
	@RequestMapping(value = "rest-save-student-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveStudent(@RequestBody String studentData) {
		logger.info("Method :saveLocation starts");

		logger.info("Method :saveLocation endss");
		return applicationTemplateDao.saveStudentDetail(studentData);
	}

	// view-Student
	@RequestMapping(value = "rest-studentdetails-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStudent(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewEmployee start");

		logger.info("Method :viewEmployee endss");
		return applicationTemplateDao.viewStudent(orgName, orgDivision);
	}

	// Delete -->>>>
	@RequestMapping(value = "rest-studentdetails-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteStudent(@RequestParam String id) {
		logger.info("Method : deleteStudent starts");

		logger.info("Method : deleteStudent ends");
		return applicationTemplateDao.deleteStudent(id);
	}

	// Application-Data Save
	@RequestMapping(value = "rest-save-application-details", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveApplication(@RequestBody String applicationData) {
		logger.info("Method :saveApplication starts");

		logger.info("Method :saveApplication endss");
		return applicationTemplateDao.saveApplicationDetail(applicationData);
	}

	// view-Application
	@RequestMapping(value = "rest-application-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewApplication(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewApplication start");

		logger.info("Method :viewApplication endss");
		return applicationTemplateDao.viewApplication(orgName, orgDivision);
	}

	// edit-Application
	@RequestMapping(value = "rest-application-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editApplication(@RequestParam String id) {
		logger.info("Method : editApplication starts");

		logger.info("Method : editApplication ends");
		return applicationTemplateDao.editApplication(id);
	}

	// Delete Application Data-->>>>
	@RequestMapping(value = "rest-application-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteApplication(@RequestParam String id) {
		logger.info("Method : deleteApplication starts");

		logger.info("Method : deleteApplication ends");
		return applicationTemplateDao.deleteApplication(id);
	}

	// countryList
	@RequestMapping(value = "getUserCountry", method = { RequestMethod.GET })
	public List<DropDownModel> countryList() {

		logger.info("Method : countryList starts");
		logger.info("Method : countryList ends");

		return applicationTemplateDao.countryList();
	}

	// get State
	@RequestMapping(value = "getApplicationStateList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getStateList(@RequestParam String id) {
		logger.info("Method : getStudentStateList starts");
		logger.info("Method : getStudentStateList ends");
		return applicationTemplateDao.getApplicationStateList(id);
	}

	// districtList
	@RequestMapping(value = "districtList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> districtList(@RequestParam String id) {
		logger.info("Method : districtList starts");
		logger.info("Method : districtList ends");
		return applicationTemplateDao.districtList(id);
	}

	// application-city-list
	@RequestMapping(value = "studentCity-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> cityList(@RequestParam String id) {
		logger.info("Method : cityList starts");
		logger.info("Method : cityList ends");
		return applicationTemplateDao.cityList(id);
	}
	
	// get courseList data
	@RequestMapping(value = "courseList", method = { RequestMethod.GET })
	public List<DropDownModel> courseList() {
		logger.info("Method : courseList starts");
		
		logger.info("Method : courseList ends");
		return applicationTemplateDao.courseList();
	}
}
