package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.TimeSheetDao;
import nirmalya.aatithya.restmodule.master.model.TimeSheetAllProjectDetailsModel;
import nirmalya.aatithya.restmodule.master.model.TimeSheetModel;
import nirmalya.aatithya.restmodule.master.model.TimeSheetProjectDetailsModel;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = "master")
public class TimeSheetRestController {
	Logger logger = LoggerFactory.getLogger(TimeSheetRestController.class);

	@Autowired
	TimeSheetDao timeSheetDao;

	
	@RequestMapping(value = "getWeekDays", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getWeekDays(@RequestParam List<String> id) {
		logger.info("Method : getWeekDays starts");
		
		logger.info("Method : getWeekDays ends");
		return timeSheetDao.getWeekDays(id);
	}
	

	@RequestMapping(value = "getProjectDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<TimeSheetProjectDetailsModel>>> getProjectDetails(@RequestParam List<String> id) {
		logger.info("Method : getProjectDetails starts");
		
		logger.info("Method : getProjectDetails ends");
		return timeSheetDao.getProjectDetails(id);
	}
	
	@RequestMapping(value = "saveTimeSheet", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> saveTimeSheet(
			@RequestBody List<TimeSheetModel> timeSheetModel) {
		logger.info("Method : saveTimeSheet for rest controller starts");

		logger.info("Method : saveTimeSheet for rest controller ends");
		return timeSheetDao.saveTimeSheet(timeSheetModel);
	}
	
	@RequestMapping(value = "get-time-sheet-total-list", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> getProjectTotalHourDetails(@RequestParam String id,@RequestParam String year) {
		logger.info("Method : getProjectDetails starts");
		
		logger.info("Method : getProjectDetails ends");
		return timeSheetDao.getProjectTotalHourDetails(id,year);
	}
	
	@RequestMapping(value = "view-employee-details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<TimeSheetAllProjectDetailsModel>>> getEmpDetails() {
		logger.info("Method : getEmpDetails starts");
		
		logger.info("Method : getEmpDetails ends");
		return timeSheetDao.getEmpDetails();
	}
	
	@RequestMapping(value = "deleteTimeSheetEmp", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTimeSheetEmp(@RequestParam String id,
			@RequestParam String createdBy) {
		logger.info("Method : deleteTimeSheetEmp starts");

		logger.info("Method : deleteTimeSheetEmp ends");
		return timeSheetDao.deleteTimeSheetEmp(id, createdBy);
	}
	

	@RequestMapping(value = "deleteTimeSheetProDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteTimeSheetProDetails(@RequestParam String empId,@RequestParam String year,@RequestParam String monthdata,
			@RequestParam String week,@RequestParam String createdBy) {
		logger.info("Method : deleteTimeSheetProDetails starts");

		logger.info("Method : deleteTimeSheetProDetails ends");
		return timeSheetDao.deleteTimeSheetProDetails(empId,year,monthdata,week, createdBy);
	}
}
