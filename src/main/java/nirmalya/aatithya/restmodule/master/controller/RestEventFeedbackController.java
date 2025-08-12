package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EventManageDao;
import nirmalya.aatithya.restmodule.master.dao.RestEventFeedbackDao;

@RestController
@RequestMapping(value = "master/")
public class RestEventFeedbackController {
	Logger logger = LoggerFactory.getLogger(RestEventFeedbackController.class);

	@Autowired
	RestEventFeedbackDao restEventFeedbackDao;

	// Event Feedback
	@RequestMapping(value = "rest-getEventFeedback", method = { RequestMethod.GET })
	public JsonResponse<Object> getEventFeedback(@RequestParam String userId, String orgName, String orgDivision) {
		logger.info("Method :getEventFeedback start");

		logger.info("Method :getEventFeedback endss");
		return restEventFeedbackDao.getEventFeedback(userId, orgName, orgDivision);
	}

	@PostMapping(value = "rest-addFeedback")
	public ResponseEntity<JsonResponse<Object>> addFeedback(@RequestBody String itm, @RequestParam String eventId,
			@RequestParam String attendeesId,String userId,String orgName,String orgDivision,String status,String eventType,String rating) {
		logger.info("Method : addFeedback starts");
		logger.info("Method : addFeedback ends");
		return restEventFeedbackDao.addFeedback(itm, eventId, attendeesId,userId,orgName,orgDivision,status,eventType,rating);
	}
}
