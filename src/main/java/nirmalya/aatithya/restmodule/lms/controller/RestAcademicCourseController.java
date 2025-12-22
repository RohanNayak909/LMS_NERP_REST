package nirmalya.aatithya.restmodule.lms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.controller.HISOPDRestController;
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.his.model.HISBedMasterRestModel;
import nirmalya.aatithya.restmodule.his.model.HISPatientRestModel;
import nirmalya.aatithya.restmodule.lms.dao.AcademicCourseDao;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;

@RestController
@RequestMapping(value = "his/")
@CrossOrigin(origins = "*")
public class RestAcademicCourseController {

	Logger logger = LoggerFactory.getLogger(HISOPDRestController.class);

	@Autowired
	AcademicCourseDao academicCourseDao;

	// rest-academic-course-add

	@PostMapping(value = "rest-academic-course-add")
	public ResponseEntity<JsonResponse<Object>> saveCourse(@RequestBody String courseData, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveCourse starts");
		logger.info("Method :saveCourse endss");
		return academicCourseDao.saveCourse(courseData, userId, org, orgDiv);
	}

	
	@PostMapping(value = "rest-academic-saveTraining")
	public ResponseEntity<JsonResponse<Object>> saveTraining(@RequestBody String payload, @RequestParam String userId,
	@RequestParam String org, @RequestParam String orgDiv) {
	    logger.info("Method :saveTraining starts");
	    logger.info("Payload: {}", payload);
	    logger.info("Method :saveTraining endss");
	    return academicCourseDao.saveTraining(payload, userId, org, orgDiv);
	}
	
	// view
	@RequestMapping(value = "rest-viewCourse", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCourse(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewCourse start");
		logger.info("Method :viewCourse endss");
		return academicCourseDao.viewCourse(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-delete-training", method = { RequestMethod.GET })
	public JsonResponse<Object> deleteTraining(@RequestParam String org, @RequestParam String orgDiv,@RequestParam String trainingId) {
		logger.info("Method :viewCourse start");
		logger.info("Method :viewCourse endss");
		return academicCourseDao.deleteTraining(org, orgDiv,trainingId);
	}
	
	@RequestMapping(value = "rest-coursequiz", method = { RequestMethod.GET })
	public JsonResponse<Object> coursequiz(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :coursequiz start");
		logger.info("Method :coursequiz endss");
		return academicCourseDao.coursequiz(orgName, orgDivision);
	}

	
	@RequestMapping(value = "rest-viewtraining", method = { RequestMethod.GET })
	public JsonResponse<Object> viewtraining(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :viewtraining start");
		logger.info("Method :viewtraining endss");
		return academicCourseDao.viewtraining(orgName, orgDivision,id);
	}
	
	// edit
	@RequestMapping(value = "rest-editCourse", method = { RequestMethod.GET })
	public JsonResponse<Object> editCourse(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editCourse start");
		logger.info("Method :editCourse endss");
		return academicCourseDao.editCourse(Id, organization, orgDivision);
	}

	@RequestMapping(value = "rest-academic-course-employee-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewEmpolyee(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewEmpolyee start");
		logger.info("Method :viewEmpolyee endss");
		return academicCourseDao.viewEmpolyee(orgName, orgDivision);
	}

	@PostMapping(value = "rest-academic-course-employee-add")
	public ResponseEntity<JsonResponse<Object>> saveAssign(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveAssign starts");
		logger.info("Method :saveAssign endss");
		return academicCourseDao.saveAssign(data, userId, org, orgDiv);
	}

	// viewList

	@RequestMapping(value = "rest-get-all-instructor-list", method = { RequestMethod.GET })
	public JsonResponse<Object> viewList(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewList start");
		logger.info("Method :viewList endss");
		return academicCourseDao.viewList(orgName, orgDivision);
	}

	//
	@GetMapping(value = "getCourseAutoSearchList")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getCourseAutoSearchList(@RequestParam String id,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :getCourseAutoSearchList starts");

		logger.info("Method :getCourseAutoSearchList endss");
		return academicCourseDao.getCourseAutoSearchList(id, org, orgDiv);
	}

	//
	@RequestMapping(value = "rest-viewCourses", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCourses(@RequestParam String orgName, String orgDivision, String courseId) {
		logger.info("Method :viewCourses start");

		logger.info("Method :viewCourses endss");
		return academicCourseDao.viewCourses(orgName, orgDivision, courseId);
	}

	//
	@RequestMapping(value = "rest-get-catlog-courses", method = { RequestMethod.GET })
	public JsonResponse<Object> viewCatlog(@RequestParam String orgName, String orgDivision, String catId,
			String level) {
		logger.info("Method :viewCatlog start");

		logger.info("Method :viewCatlog endss");
		return academicCourseDao.viewCatlog(orgName, orgDivision, catId, level);
	}

	// viewStudent
	@RequestMapping(value = "rest-subscription-student-view", method = RequestMethod.GET)
	public JsonResponse<Object> viewStudent(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method : viewStudent Controller start");
		JsonResponse<Object> response = academicCourseDao.viewStudent(orgName, orgDivision,id);
		logger.info("Method : viewStudent Controller end");
		return response;
	}
	// enable
	@GetMapping("rest-subscription-student-course-enable")
	public JsonResponse<Object> enableCourse(@RequestParam String id, @RequestParam String status) {
		logger.info("Method : enableCourse starts");
		JsonResponse<Object> response = academicCourseDao.enableCourse(id, status);
		logger.info("Method : enableCourse ends");
		return response;
	}

	@PostMapping(value = "rest-academic-course-content-add")
	public ResponseEntity<JsonResponse<Object>> saveCourseContent(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv, @RequestParam String courseId) {
		logger.info("Method :saveCourseContent starts");
		logger.info("Method :saveCourseContent endss");
		return academicCourseDao.saveCourseContent(data, userId, org, orgDiv, courseId);
	}
	
	@RequestMapping(value = "rest-get-course-details", method = { RequestMethod.GET })
	public JsonResponse<Object> getCourseDetails(@RequestParam String orgName, String orgDivision, String courseId) {
		logger.info("Method :getCourseDetails start");

		logger.info("Method :getCourseDetails endss");
		return academicCourseDao.getCourseDetails(orgName, orgDivision,courseId);
	}
	
	@PostMapping(value = "rest-academic-course-module-add")
	public ResponseEntity<JsonResponse<Object>> saveCorseModule(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveCorseModule starts");
		logger.info("Method :saveCorseModule endss");
		return academicCourseDao.saveCorseModule(data, userId, org, orgDiv);
	}
	
	@PostMapping(value = "rest-academic-course-lession-add")
	public ResponseEntity<JsonResponse<Object>> saveCourseLession(@RequestBody String data, @RequestParam String userId,
			@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveCourseLession starts");
		logger.info("Method :saveCourseLession endss");
		return academicCourseDao.saveCourseLession(data, userId, org, orgDiv);
	}
	
	@RequestMapping(value = "rest-get-course-lessions", method = { RequestMethod.GET })
	public JsonResponse<Object> getCourseLessions(@RequestParam String orgName, String orgDivision, String moduleId) {
		logger.info("Method :getCourseLessions start");

		logger.info("Method :getCourseLessions endss");
		return academicCourseDao.getCourseLessions(orgName, orgDivision,moduleId);
	}
	
	@RequestMapping(value = "rest-getAllHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllHeadCount(@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String userId) {
		logger.info("Method :getAllHeadCount start");

		logger.info("Method :getAllHeadCount endss");
		return academicCourseDao.getAllHeadCount(orgName,orgDivision,userId);

	}
	
	@RequestMapping(value = "rest-getAllOperationalRecord", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllOperationalRecord(@RequestParam String orgName ,@RequestParam String orgDivision
			,@RequestParam String userId,@RequestParam String id) {
		logger.info("Method :getAllOperationalRecord start");

		logger.info("Method :getAllOperationalRecord endss");
		return academicCourseDao.getAllOperationalRecord(orgName,orgDivision,userId,id);

	}
	
	@RequestMapping(value = "rest-getAllUserTraining", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllUserTraining(@RequestParam String orgName ,@RequestParam String orgDivision
			,@RequestParam String userId,@RequestParam String id) {
		logger.info("Method :getAllUserTraining start");

		logger.info("Method :getAllUserTraining endss");
		return academicCourseDao.getAllUserTraining(orgName,orgDivision,userId,id);

	}
	
	@RequestMapping(value = "rest-editCourseDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> editCourseDetails(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editCourseDetails start");
		logger.info("Method :editCourseDetails endss");
		return academicCourseDao.editCourseDetails(Id, organization, orgDivision);
	}
	
	
	@RequestMapping(value = "rest-editCourseTrainingDetails", method = { RequestMethod.GET })
	public JsonResponse<Object> editCourseTrainingDetails(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editCourseTrainingDetails start");
		logger.info("Method :editCourseTrainingDetails endss");
		return academicCourseDao.editCourseTrainingDetails(Id, organization, orgDivision);
	}
	
	
// ✅ Keep SAME endpoint (your Next.js already calls this)
    @PostMapping(value = "rest-academic-course-duration-add")
    public ResponseEntity<JsonResponse<Object>> saveCourseDuration(
            @RequestBody String data,
            @RequestParam String userId,
            @RequestParam String org,
            @RequestParam String orgDiv,
            HttpServletRequest request) {

        logger.info("Method : saveCourseDuration starts");
        ResponseEntity<JsonResponse<Object>> resp = academicCourseDao.saveCourseDuration(data, userId, org, orgDiv);
        logger.info("Method : saveCourseDuration ends");
        return resp;
    }

    // ✅ Optional helper (useful for testing)
    @GetMapping(value = "rest-academic-course-duration-get")
    public ResponseEntity<JsonResponse<Object>> getCourseDurations(
            @RequestParam String userId,
            @RequestParam String courseId) {

        logger.info("Method : getCourseDurations starts");
        ResponseEntity<JsonResponse<Object>> resp = academicCourseDao.getCourseDurations(userId, courseId);
        logger.info("Method : getCourseDurations ends");
        return resp;
    }
	

	@RequestMapping(value = "rest-getadminAllHeadCount", method = { RequestMethod.GET })
	public JsonResponse<Object> getadminAllHeadCount(@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String userId) {
		logger.info("Method :getadminAllHeadCount start");

		logger.info("Method :getadminAllHeadCount endss");
		return academicCourseDao.getadminAllHeadCount(orgName,orgDivision,userId);

	}
	@PostMapping(value = "rest-add-coupon")
	public JsonResponse<Object> saveCouponDetails(@RequestBody Map<String,Object>payload) {
		logger.info("Method :saveCouponDetails start");

		logger.info("Method :saveCouponDetails endss");
		return academicCourseDao.saveCouponDetails(payload);

	}
	@PostMapping(value = "rest-delete-coupon")
	public JsonResponse<Object> deleteCoupon(@RequestBody Map<String,Object>payload) {
		logger.info("Method :deleteCoupon start");

		logger.info("Method :deleteCoupon endss");
		return academicCourseDao.deleteCoupon(payload);

	}
	@RequestMapping(value = "rest-get-reccent-courses", method = { RequestMethod.GET })
	public JsonResponse<Object> getRecentPurchaseCourses(@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String userId) {
		logger.info("Method :getRecentPurchaseCourses start");

		logger.info("Method :getRecentPurchaseCourses endss");
		return academicCourseDao.getRecentPurchaseCourses(orgName,orgDivision,userId);

	}
	@RequestMapping(value = "rest-get-excel-data", method = { RequestMethod.GET })
	public JsonResponse<Object> getExcelData(@RequestParam String orgName ,@RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :getExcelData start");

		logger.info("Method :getExcelData endss");
		return academicCourseDao.getExcelData(orgName,orgDivision,id);

	}
	@PostMapping(value = "rest-academic-course-quiz-save")
    public ResponseEntity<JsonResponse<Object>> saveQuizMappings(@RequestBody String quizData, @RequestParam String userId,
            @RequestParam String org, @RequestParam String orgDiv) {
        logger.info("Method :saveQuizMappings starts"+quizData);
        logger.info("Method :saveQuizMappings endss");
        return academicCourseDao.saveQuizMappings(quizData, userId, org, orgDiv);
    }
	

	
	@RequestMapping(value = "rest-viewPublicBatches", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPublicBatches(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :viewPublicBatches start");
		logger.info("Method :viewPublicBatches endss");
		return academicCourseDao.viewPublicBatches(orgName, orgDivision,id);
	}
	
	@PostMapping(value = "rest-delete-public-batches")
	public JsonResponse<Object> deletePublicBatches(@RequestBody Map<String, Object> payload) {
	    logger.info("Method :deletePublicBatches starts");

	    return academicCourseDao.deletePublicBatches(payload);
	}
	
	@PostMapping(value = "rest-add-content-data")
	public JsonResponse<Object> addContentData(@RequestBody Map<String, Object> payload) {
	    logger.info("Method :addContentData starts");
	    logger.info("Method :addContentData Ends");
	    return academicCourseDao.addContentData(payload);
	}
	
	@RequestMapping(value = "rest-view-all-blogs", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllBlogs(@RequestParam String orgName ,@RequestParam String orgDivision) {
		logger.info("Method :getAllBlogs start");

		logger.info("Method :getAllBlogs endss");
		return academicCourseDao.getAllBlogs(orgName,orgDivision);

	}
// Course List
	@GetMapping(value = "getCourseList")
	public List<DropDownModel> getCourseList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getCourseList starts");
 
		logger.info("Method : getCourseList ends");
		return academicCourseDao.getCourseList(org,orgDiv);
	}

@GetMapping(value = "lms-getCountryList")
	public List<DropDownModel> getCountryList() {

		logger.info("Method : getCountryList starts");
		logger.info("Method : getCountryList ends");

		return academicCourseDao.getCountryList();
	}

	
  @PostMapping(value = "lms-contactList")
	public JsonResponse<Object> saveContactData(@RequestParam String orgName, String orgDivision, String userId,
			@RequestBody String data) {
		logger.info("Method :saveUserData start");
 
		logger.info("Method :saveUserData endss");
		return academicCourseDao.saveContactData(orgName, orgDivision, userId, data);
	}
	@RequestMapping(value = "rest-viewContactUs", method = { RequestMethod.GET })
	public JsonResponse<Object> viewContactUs(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String id) {
		logger.info("Method :viewContactUs start");
		logger.info("Method :viewContactUs endss");
		return academicCourseDao.viewContactUs(orgName, orgDivision,id);
	}





}
