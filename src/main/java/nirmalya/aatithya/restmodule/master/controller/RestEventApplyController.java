package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EventApplyDao;
import nirmalya.aatithya.restmodule.master.model.RestEventManagementModel;

@RestController
@RequestMapping(value = "master")
public class RestEventApplyController {
	Logger logger = LoggerFactory.getLogger(RestEventApplyController.class);
	@Autowired
	EventApplyDao eventApplyDao;
	
	@RequestMapping(value = "rest-viewAllEvent", method = { RequestMethod.GET })
	public JsonResponse<List<RestEventManagementModel>> viewAllEventList(@RequestParam String organization, @RequestParam String orgDivision) {
		logger.info("Method : viewAllEventList starts");
		
		logger.info("Method : viewAllEventList ends");
		return eventApplyDao.viewAllEventListDao(organization,orgDivision);
	}
	@RequestMapping(value = "rest-saveEventRequest", method = { RequestMethod.GET })
	public JsonResponse<Object> saveEventRequest(@RequestParam String eventId, @RequestParam String userId) {
		logger.info("Method : saveEventRequest starts");
		
		logger.info("Method : saveEventRequest ends");
		return eventApplyDao.saveEventRequestDao(eventId, userId);
	}
}
