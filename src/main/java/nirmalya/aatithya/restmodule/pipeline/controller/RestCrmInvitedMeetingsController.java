package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmInvitedMeetingsDao;


@RestController
@RequestMapping(value = "pipeline")
public class RestCrmInvitedMeetingsController {

	Logger logger = LoggerFactory.getLogger(RestCrmInvitedMeetingsController.class);
	@Autowired
	RestCrmInvitedMeetingsDao restCrmInvitedMeetingsDao;
	
	
	//view-rest-LeadMeetingInfo
	
	@GetMapping(value = "invitedMeetingDtls")
	public JsonResponse<Object> invitedMeetingDtls(@RequestParam String id) {
		logger.info("Method :invitedMeetingDtls starts");

		logger.info("Method :invitedMeetingDtls ends"+id);
		return restCrmInvitedMeetingsDao.invitedMeetingDtls(id);
	}
}
