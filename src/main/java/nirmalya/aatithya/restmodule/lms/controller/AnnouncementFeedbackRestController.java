package nirmalya.aatithya.restmodule.lms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.lms.dao.AnnouncementFeedbackRestDao;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping(value = "his/")
public class AnnouncementFeedbackRestController {

	Logger logger = LoggerFactory.getLogger(AnnouncementFeedbackRestController.class);

	@Autowired
	AnnouncementFeedbackRestDao announcementFeedbackRestDao;

	// rest-academic-course-add

	@PostMapping(value = "rest-academic-announcement-add")
	public ResponseEntity<JsonResponse<Object>> saveAnnouncement(@RequestBody String announceData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveAnnouncement starts");
		logger.info("Method :saveAnnouncement endss");
		return announcementFeedbackRestDao.saveAnnouncement(announceData, userId, org, orgDiv);
	}

	// view
	@RequestMapping(value = "rest-viewAnnouncement", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAnnouncement(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewAnnouncement start");
		logger.info("Method :viewAnnouncement endss");
		return announcementFeedbackRestDao.viewAnnouncement(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editAnnouncement", method = { RequestMethod.GET })
	public JsonResponse<Object> editAnnouncement(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editAnnouncement start");
		logger.info("Method :editAnnouncement endss");
		return announcementFeedbackRestDao.editAnnouncement(Id, organization, orgDivision);
	}

	@RequestMapping(value = "rest-academic-course-student-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewStudent(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewStudent start");
		logger.info("Method :viewStudent endss");
		return announcementFeedbackRestDao.viewStudent(orgName, orgDivision);
	}

	//

	@PostMapping(value = "rest-academic-feedback-add")
	public ResponseEntity<JsonResponse<Object>> saveFeedback(@RequestBody String feedbackData,
			@RequestParam String userId, @RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :saveFeedback starts");
		logger.info("Method :saveFeedback endss");
		return announcementFeedbackRestDao.saveFeedback(feedbackData, userId, org, orgDiv);
	}

	// view
	@RequestMapping(value = "rest-viewFeedback", method = { RequestMethod.GET })
	public JsonResponse<Object> viewFeedback(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewFeedback start");
		logger.info("Method :viewFeedback endss");
		return announcementFeedbackRestDao.viewFeedback(orgName, orgDivision);
	}

	// edit
	@RequestMapping(value = "rest-editFeedback", method = { RequestMethod.GET })
	public JsonResponse<Object> editFeedback(@RequestParam String Id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :editFeedback start");
		logger.info("Method :editFeedback endss");
		return announcementFeedbackRestDao.editFeedback(Id, organization, orgDivision);
	}

	@RequestMapping(value = "rest-get-announce-and-feedback-list", method = { RequestMethod.GET })
	public JsonResponse<Object> getAnnouncementAndFeedback(@RequestParam String orgName,
			@RequestParam String orgDivision, @RequestParam String userId) {
		logger.info("Method :getAnnouncementAndFeedback start");
		logger.info("Method :getAnnouncementAndFeedback endss");
		return announcementFeedbackRestDao.getAnnouncementAndFeedback(orgName, orgDivision, userId);
	}
	
	@PostMapping(value = "rest-save-user-feedback")
	public ResponseEntity<JsonResponse<Object>> saveUserFeedback(@RequestBody String userFeedbackData
			, @RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String userId) {
		logger.info("Method :saveUserFeedback starts");
		logger.info("Method :saveUserFeedback endss");
		return announcementFeedbackRestDao.saveUserFeedback(userFeedbackData,orgName, orgDivision, userId);
	}
	
	@RequestMapping(value = "rest-get-all-users-feedbacks", method = { RequestMethod.GET })
	public JsonResponse<Object> getAllUsersFeedbacks(@RequestParam String orgName, @RequestParam String orgDivision,@RequestParam String feedbackId) {
		logger.info("Method :getAllUsersFeedbacks start");
		logger.info("Method :getAllUsersFeedbacks endss");
		return announcementFeedbackRestDao.getAllUsersFeedbacks(orgName, orgDivision,feedbackId);
	}
}
