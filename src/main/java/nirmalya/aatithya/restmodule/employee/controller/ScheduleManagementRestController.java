package nirmalya.aatithya.restmodule.employee.controller;

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
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.dao.ScheduleManagementDao;
import nirmalya.aatithya.restmodule.employee.model.ScheduleManagementModel;

@RestController
@RequestMapping(value = { "employee/" })
public class ScheduleManagementRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	ScheduleManagementDao scheduleManagementDao;

	/*
	 * 
	 * Get mapping for department
	 */
	@GetMapping(value = "get-department")
	public List<DropDownModel> getDepartment() {
		logger.info("Method : getDepartment starts");
		logger.info("Method : getDepartment endss");
		return scheduleManagementDao.getDepartmentList();
	}

	/*
	 * 
	 * Get mapping for schedule
	 */
	@GetMapping(value = "get-schedule")
	public List<DropDownModel> getSchedule() {
		logger.info("Method : getSchedule starts");
		logger.info("Method : getSchedule endss");
		return scheduleManagementDao.getScheduleList();
	}

	/*
	 * Get mapping for section
	 */
	@GetMapping(value = "get-section")
	public List<DropDownModel> getSection() {
		logger.info("Method : getSection starts");
		logger.info("Method : getSection endss");
		return scheduleManagementDao.getSectionList();
	}

	/*
	 * Get mapping for shift
	 */
	@GetMapping(value = "get-shift")
	public List<DropDownModel> getShift() {
		logger.info("Method : getShift starts");
		logger.info("Method : getShift endss");
		return scheduleManagementDao.getShiftList();
	}

	/*
	 * Get mapping for employee
	 */
	@GetMapping(value = "get-employee")
	public List<DropDownModel> getEmployee() {
		logger.info("Method : getEmployee starts");
		logger.info("Method : getEmployee endss");
		return scheduleManagementDao.getEmployeeList();
	}

	/*
	 * 
	 * PostMapping for add rest ItemRequisition
	 * 
	 * 
	 */
	@PostMapping(value = "rest-add-schedule")
	public ResponseEntity<JsonResponse<List<ScheduleManagementModel>>> restAddSchedule(
			@RequestBody List<ScheduleManagementModel> scheduleModel) {
		logger.info("Method : restAddSchedule starts");
		logger.info("Method : restAddSchedule ends");
		return scheduleManagementDao.addScheduleManagement(scheduleModel);
	}

	@RequestMapping(value = "schedule-management-employee", method = { RequestMethod.GET })
	ResponseEntity<JsonResponse<List<ScheduleManagementModel>>> viewScheduleRest(@RequestParam String userid,
			@RequestParam String roleid, @RequestParam String organization,@RequestParam String orgDivision ) {
		logger.info("Method : viewScheduleRest start"+orgDivision);

		logger.info("Method : viewScheduleRest ends");
		return scheduleManagementDao.viewSchedule(userid,roleid,organization,orgDivision);
	}

	/*
	 * Get mapping for get schedule data
	 *
	 */
	@GetMapping(value = "get-schedule-edit")
	public List<ScheduleManagementModel> scheduleManagementEdit(@RequestParam String id) {
		logger.info("Method : scheduleManagementEdit starts");
		logger.info("Method : scheduleManagementEdit endss");
		return scheduleManagementDao.getScheduleEdit(id);
	}

	/*
	 * PostMapping for delete ItemRequisition
	 */
	@PostMapping(value = "rest-delete-schedule")
	public ResponseEntity<JsonResponse<Object>> restDeleteSchedule(
			@RequestBody ScheduleManagementModel scheduleModel) {
		logger.info("Method : restDeleteSchedule starts");
		logger.info("Method : restDeleteSchedule ends");
		return scheduleManagementDao.deleteSchedule(scheduleModel);
	}
	
	
	
	// name  list
	/*
	 * @GetMapping(value = "get-empnameList") public
	 * JsonResponse<List<DropDownModel>> getempnameList(@RequestParam String id) {
	 * logger.info("Method : getempnameList starts");
	 * 
	 * logger.info("Method : getempnameList ends"); return
	 * scheduleManagementDao.getempnameList(id); }
	 * 
	 */
			

			
			@GetMapping(value = "get-empnameList")
			public ResponseEntity<JsonResponse<List<DropDownModel>>>getcuststateListNew(@RequestParam String id) {
				logger.info("Method : getstateList starts");
				logger.info("Method : getstateList ends");
				return scheduleManagementDao.getempnameList(id);
			}
				
			
}
