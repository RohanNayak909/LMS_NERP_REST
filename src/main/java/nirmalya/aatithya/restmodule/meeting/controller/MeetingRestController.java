package nirmalya.aatithya.restmodule.meeting.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.meeting.dao.MeetingDao;

@RestController
@RequestMapping("meeting/")
public class MeetingRestController {
	Logger logger = LoggerFactory.getLogger(MeetingRestController.class);
	@Autowired
	MeetingDao meetingDao;
	
	
	@RequestMapping(value = "rest-getEmployeeList", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeLists(@RequestParam String orgName, String orgDivision, String managerId,
			String userId) {
		logger.info("Method : getEmployeeLists starts");

		logger.info("Method : getEmployeeLists ends");
		return meetingDao.getEmployeeLists(orgName, orgDivision, managerId, userId);
	}

	// ADD MEETING
	@PostMapping("rest-add-meeting")
	public JsonResponse<Object> addMeetingInCalendar(@RequestBody Map<String, Object> meetingJsonData) {
		logger.info("Method : addMeetingInCalendar starts");

		logger.info("Method : addMeetingInCalendar ends");
		return meetingDao.addMeetingInCalendar(meetingJsonData);
	}

	// VIEW MEETING
	@GetMapping("rest-view-meeting-calendar")
	public JsonResponse<Object> viewMeetingCalendar(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String meetingStatus) {
		logger.info("Method :viewMeetingCalendar start");

		logger.info("Method :viewMeetingCalendar ends");
		return meetingDao.viewMeetingCalendar(orgName, orgDiv, userId, meetingStatus);
	}
	
	@GetMapping("rest-get-all-meeting")
	public JsonResponse<Object> getAllMeeting(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId) {
		logger.info("Method :getAllMeeting start");

		logger.info("Method :getAllMeeting ends");
		return meetingDao.getAllMeeting(orgName, orgDiv, userId);
	}

	// EDIT MEETING
	@GetMapping("rest-edit-meeting-calendar")
	public JsonResponse<Object> editMeetingCalendar(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String meetingId) {
		logger.info("Method :editMeetingCalendar start");

		logger.info("Method :editMeetingCalendar ends");
		return meetingDao.editMeetingCalendar(orgName, orgDiv, userId, meetingId);
	}

	// DELETE MEETING
	@GetMapping("rest-delete-meeting-calendar")
	public JsonResponse<Object> deleteMeetingCalendar(@RequestParam String meetingId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :deleteMeetingCalendar start");

		logger.info("Method :deleteMeetingCalendar ends");
		return meetingDao.deleteMeetingCalendar(meetingId, orgName, orgDiv);
	}

	@GetMapping("rest-vital-meeting-calendar")
	public JsonResponse<Object> getvitalMeeting(@RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId, @RequestParam String currentDate, @RequestParam String currentTime) {
		logger.info("Method :getvitalMeeting start");

		logger.info("Method :getvitalMeeting ends");
		return meetingDao.getvitalMeeting(orgName, orgDiv, userId, currentDate, currentTime);
	}

	@GetMapping("rest-issue-raised-employeeList")
	public JsonResponse<Object> issueRaisedEmployeeList(@RequestParam String meetingId, @RequestParam String orgName,
			@RequestParam String orgDiv) {
		logger.info("Method :issueRaisedEmployeeList start");

		logger.info("Method :issueRaisedEmployeeList ends");
		return meetingDao.issueRaisedEmployeeList(meetingId, orgName, orgDiv);
	}

	@PostMapping("rest-save-mom-details")
	public JsonResponse<Object> saveMomDetails(@RequestBody Map<String, Object> momJsonData) {
		logger.info("Method : saveMomDetails starts");

		logger.info("Method : saveMomDetails ends");
		return meetingDao.saveMomDetails(momJsonData);
	}

	@GetMapping("rest-get-momsList")
	public JsonResponse<Object> getMomsList(@RequestParam String meetingId, @RequestParam String orgName,
			@RequestParam String orgDiv, @RequestParam String userId, @RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :getMomsList start");

		logger.info("Method :getMomsList ends");
		return meetingDao.getMomsList(meetingId, orgName, orgDiv, userId, fromDate, toDate);
	}

	@GetMapping("rest-get-momsDeatils")
	public JsonResponse<Object> getMomsDetails(@RequestParam String meetingId, @RequestParam String momDate,
			@RequestParam String orgName, @RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method :getMomsDetails start");

		logger.info("Method :getMomsDetails ends");
		return meetingDao.getMomsDetails(meetingId, momDate, orgName, orgDiv, userId);
	}

	@GetMapping("rest-get-open-issues")
	public JsonResponse<Object> getOpenIssues(@RequestParam String meetingId, @RequestParam String orgName,
			@RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method :getOpenIssues start");

		logger.info("Method :getOpenIssues ends");
		return meetingDao.getOpenIssues(meetingId, orgName, orgDiv, userId);
	}

	@GetMapping("rest-get-all-meetings-list")
	public JsonResponse<Object> getAllMeetingsForCalenders(@RequestParam String startDate,
			@RequestParam String endtDate, @RequestParam String orgName, @RequestParam String orgDiv,
			@RequestParam String userId) {
		logger.info("Method :getAllMeetingsForCalenders start");

		logger.info("Method :getAllMeetingsForCalenders ends");
		return meetingDao.getAllMeetingsForCalenders(startDate, endtDate, orgName, orgDiv, userId);
	}

	@GetMapping("rest-get-remove-open-issues")
	public JsonResponse<Object> reoveOpenIssues(@RequestParam String issueId, @RequestParam String orgName,
			@RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method :reoveOpenIssues start");

		logger.info("Method :reoveOpenIssues ends");
		return meetingDao.reoveOpenIssues(issueId, orgName, orgDiv, userId);
	}

	@GetMapping("rest-get-calendar-meeting-details")
	public JsonResponse<Object> getCalendarMeetingDetails(@RequestParam String id, @RequestParam String orgName,
			@RequestParam String orgDiv, @RequestParam String userId) {
		logger.info("Method :getCalendarMeetingDetails start");

		logger.info("Method :getCalendarMeetingDetails ends");
		return meetingDao.getCalendarMeetingDetails(id, orgName, orgDiv, userId);
	}
	
	@PostMapping("rest-save-meeting-changes")
	public JsonResponse<Object> saveMeetingChanges(@RequestBody Map<String, Object> meetingJsonData) {
		logger.info("Method : saveMeetingChanges starts");

		logger.info("Method : saveMeetingChanges ends");
		return meetingDao.saveMeetingChanges(meetingJsonData);
	}
}
