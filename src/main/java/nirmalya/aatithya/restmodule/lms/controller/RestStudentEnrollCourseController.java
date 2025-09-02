package nirmalya.aatithya.restmodule.lms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.RestStudentEnrollCourseDao;

	@RestController
	@RequestMapping(value = { "master" })
	public class RestStudentEnrollCourseController {

		Logger logger = LoggerFactory.getLogger(RestStudentEnrollCourseController.class);

		@Autowired
		RestStudentEnrollCourseDao restStudentEnrollCourseDao;
	
	@RequestMapping(value = "rest-viewEnrollCourses", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEnrollCourses(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewEnrollCourses start");

		logger.info("Method :viewEnrollCourses endss");
		return restStudentEnrollCourseDao.viewEnrollCourses(orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-save-user-details", method = { RequestMethod.POST })
	public JsonResponse<Object> saveUserData(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :saveUserData start");

		logger.info("Method :saveUserData endss");
		return restStudentEnrollCourseDao.saveUserData(orgName, orgDivision, userId, data);
	}
	
	
	@RequestMapping(value = "rest-save-user-details-lms", method = { RequestMethod.POST })
	public JsonResponse<Object> saveUserDatalms(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :saveUserDatalms start");

		logger.info("Method :saveUserDatalms endss");
		return restStudentEnrollCourseDao.saveUserDatalms(orgName, orgDivision, userId, data);
	}
	
	@RequestMapping(value = "rest-save-enrollment-data", method = { RequestMethod.POST })
	public JsonResponse<Object> saveEnrollmentData(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :saveEnrollmentData start");

		logger.info("Method :saveEnrollmentData endss");
		return restStudentEnrollCourseDao.saveEnrollmentData(orgName, orgDivision, userId, data);
	}
	
	
}
