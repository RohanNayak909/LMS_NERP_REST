package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.EventManageDao;
import nirmalya.aatithya.restmodule.master.model.EmpRoleModel;
import nirmalya.aatithya.restmodule.master.model.RestAdvanceManagementModel;
import nirmalya.aatithya.restmodule.master.model.RestEventManagementModel;

@RestController
@RequestMapping(value = "master/")
public class RestEventManagementController {
	Logger logger = LoggerFactory.getLogger(RestEventManagementController.class);

	@Autowired
	EventManageDao eventManageDao;

	// dropdown of event manage page starts here
	@RequestMapping(value = "rest-getOrganiserList", method = { RequestMethod.GET })
	public List<DropDownModel> getOrganiserList() {
		logger.info("Method : getOrganiserList starts");

		logger.info("Method : getOrganiserList ends");
		return eventManageDao.getOrganiserListDao();
	}

	@RequestMapping(value = "rest-getEventTypeList", method = { RequestMethod.GET })
	public List<DropDownModel> getEventTypeList() {
		logger.info("Method : getEventTypeList starts");

		logger.info("Method : getEventTypeList ends");
		return eventManageDao.getEventTypeListDao();
	}

	@RequestMapping(value = "rest-getResponsibleList", method = { RequestMethod.GET })
	public List<DropDownModel> getResponsibleList() {
		logger.info("Method : getResponsibleList starts");

		logger.info("Method : getResponsibleList ends");
		return eventManageDao.getResponsibleListDao();
	}

	@RequestMapping(value = "rest-getVanueList", method = { RequestMethod.GET })
	public List<DropDownModel> getVanueList() {
		logger.info("Method : getVanueList starts");

		logger.info("Method : getVanueList ends");
		return eventManageDao.getVanueListDao();
	}
	// dropdown of event manage page ends here

	@PostMapping(value = "viewEventManagement")
	public ResponseEntity<JsonResponse<List<RestEventManagementModel>>> viewEventManagement(
			@RequestBody EmpRoleModel empModel) {
		logger.info("Method : viewEventManagement starts");

		String userId = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		List<String> roleList = empModel.getUserRole();

		String userRole = "";

		if (roleList.size() > 0) {
			for (String m : roleList) {
				if (empModel.getType().equals("WEB")) {
					userRole = userRole + m + ",";
				} else {
					userRole = userRole + "\"" + m + "\",";
				}
			}
		}

		if (userRole != null && userRole != "") {
			userRole = userRole.substring(0, userRole.length() - 1);
		}

		logger.info("User Id = " + userId + " *** userRole=====" + userRole);
		logger.info("Method : viewEventManagement ends");
		return eventManageDao.viewEventManagement(userId, userRole, organization, orgDivision);
	}

	// method to save data for event management
	@PostMapping(value = "/rest-add-evant")
	public @ResponseBody JsonResponse<Object> addEvant(@RequestBody RestEventManagementModel eventManagementModel) {
		logger.info("Method : addEvant starts");

		logger.info("Method : addEvant ends");
		return eventManageDao.addEvantDao(eventManagementModel);
	}

	// approve details

	@GetMapping(value = "approveEventManagement")
	public JsonResponse<RestEventManagementModel> approveEventManagement(@RequestParam String id, String name,
			String comment, String roleid) {
		logger.info("Method : approveEventManagement starts");

		logger.info("Method : approveEventManagement ends");
		return eventManageDao.approveEventManagement(id, name, comment, roleid);
	}

	// reject

	@GetMapping(value = "rejectEventManagement")
	public JsonResponse<RestEventManagementModel> rejectEventManagement(@RequestParam String id, String name,
			String comment) {
		logger.info("Method : rejectEventManagement starts");

		logger.info("Method : rejectEventManagement ends");
		return eventManageDao.rejectEventManagement(id, name, comment);
	}

	/*
	 * @RequestMapping(value = "editEventManagement", method = { RequestMethod.GET
	 * }) public JsonResponse<RestEventManagementModel>
	 * editEventManagement(@RequestParam String id) {
	 * logger.info("Method : editEventManagement rest starts");
	 * 
	 * logger.info("Method :editEventManagement rest ends"); return
	 * eventManageDao.editEventManagement(id); }
	 */

	@PostMapping(value = "editEventManagement")
	public ResponseEntity<JsonResponse<List<RestEventManagementModel>>> editEventManagement(
			@RequestBody EmpRoleModel empModel) {
		logger.info("Method : editEventManagement starts");

		String id = empModel.getUserId();
		String organization = empModel.getOrganization();
		String orgDivision = empModel.getOrgDivision();
		// List<String> roleList = empModel.getUserRole();

		logger.info("User Id = " + id);
		logger.info("Method : editEventManagement ends");
		return eventManageDao.editEventManagement(id, organization, orgDivision);
	}

	@RequestMapping(value = "deleteEventManagement", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteEventManagement(@RequestParam String id) {
		logger.info("Method : deleteEventManagement starts");

		logger.info("Method : deleteEventManagement ends");
		return eventManageDao.deleteEventManagement(id);
	}

	@GetMapping("rest-event-getempname")
	public JsonResponse<Object> getEventEmpName(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getEventEmpName start");

		logger.info("Method :getEventEmpName ends");
		return eventManageDao.getEventEmpName(id, organization, orgDivision);
	}

	@PostMapping(value = "rest-add-newEvent")
	public ResponseEntity<JsonResponse<Object>> addEventDtls(@RequestBody String itm, @RequestParam String eventId,
			@RequestParam String eventType) {
		logger.info("Method : addEventDtls starts");
		logger.info("Method : addEventDtls ends");
		return eventManageDao.addEventDtls(itm, eventId, eventType);
	}

	@GetMapping("rest-event-viewDtls")
	public JsonResponse<Object> getEventviewDtls(@RequestParam String id, @RequestParam String organization,
			@RequestParam String orgDivision) {
		logger.info("Method :getEventviewDtls start");

		logger.info("Method :getEventviewDtls ends");
		return eventManageDao.getEventviewDtls(id, organization, orgDivision);
	}

	// Edit Event List
	@RequestMapping(value = "rest-edit-eventList", method = { RequestMethod.GET })
	public JsonResponse<Object> editeventList(@RequestParam String id, String orgName, String orgDivision,String userId) {
		logger.info("Method :editeventList start");

		logger.info("Method :editeventList endss");
		return eventManageDao.editeventList(id, orgName, orgDivision,userId);
	}

	@PostMapping(value = "rest-addExecution")
	public ResponseEntity<JsonResponse<Object>> addExecution(@RequestBody String itm, @RequestParam String eventId) {
		logger.info("Method : addExecution starts");
		logger.info("Method : addExecution ends");
		return eventManageDao.addExecution(itm, eventId);
	}

	// view Training
	@RequestMapping(value = "rest-viewTrainging", method = { RequestMethod.GET })
	public JsonResponse<Object> viewTrainging(@RequestParam String orgName, String orgDivision, String userId,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method :viewTrainging start");

		logger.info("Method :viewBibMachine endss");
		return eventManageDao.viewTrainging(orgName, orgDivision, userId, fromDate, toDate);
	}

	// Training PDF
	@RequestMapping(value = "rest-eventTrainingPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> eventTrainingPdf(@RequestParam String eventId, String trainingId, String orgName,
			String orgDivision, String userId) {
		logger.info("Method :eventTrainingPdf start");

		logger.info("Method :eventTrainingPdf endss");
		return eventManageDao.eventTrainingPdf(eventId, trainingId, orgName, orgDivision, userId);

	}

	@RequestMapping(value = "rest-getEmployeeListEvent", method = { RequestMethod.GET })
	public List<DropDownModel> getEmployeeLists(@RequestParam String orgName, String orgDivision, String managerId,
			String userId) {
		logger.info("Method : getEmployeeLists starts");

		logger.info("Method : getEmployeeLists ends");
		return eventManageDao.getEmployeeLists(orgName, orgDivision, managerId, userId);
	}
	@RequestMapping(value = "rest-getTrainingList", method = { RequestMethod.GET })
	public List<DropDownModel> getTrainingList(@RequestParam String orgName, String orgDivision) {
		logger.info("Method : getTrainingList starts");
		
		logger.info("Method : getTrainingList ends");
		return eventManageDao.getTrainingList(orgName, orgDivision);
	}

	// previousMeetingList
	@RequestMapping(value = "rest-getPrevMeetingList", method = { RequestMethod.GET })
	public JsonResponse<Object> getPrevMeetingList(@RequestParam String meetingDate, String type, String userId,
			String orgName, String orgDivision, String fromDate, String toDate) {
		logger.info("Method :getPrevMeetingList start");

		logger.info("Method :getPrevMeetingList endss");
		return eventManageDao.getPrevMeetingList(meetingDate, type, userId, orgName, orgDivision, fromDate, toDate);
	}

	// Meeting PDF
	@RequestMapping(value = "rest-eventMeetingPdf", method = { RequestMethod.GET })
	public JsonResponse<Object> eventMeetingPdf(@RequestParam String eventId, String orgName,
			String orgDivision, String userId,String startDate) {
		logger.info("Method :eventMeetingPdf start");

		logger.info("Method :eventMeetingPdf endss");
		return eventManageDao.eventMeetingPdf(eventId, orgName, orgDivision, userId,startDate);

	}


	@RequestMapping(value = "rest-approveEvent", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveEvent(@RequestParam String id,String userId
			 ,String organization,String orgDivision) {
		logger.info("Method : approveEvent starts");

		logger.info("Method : approveEvent ends");
		return eventManageDao.approveEvent(id,userId,organization,orgDivision);
	}
	
	
	@RequestMapping(value = "getEvenetId", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getEvenetId(@RequestParam String orgName,
			@RequestParam String orgDivision) {
		logger.info("Method: getEvenetId View Start");

		logger.info("Method: getEvenetId ends");
		return eventManageDao.getEvenetId(orgName, orgDivision);
	}
}
