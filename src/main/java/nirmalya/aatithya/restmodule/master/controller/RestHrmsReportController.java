package nirmalya.aatithya.restmodule.master.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.MasterDao;
import nirmalya.aatithya.restmodule.master.dao.RestHrmsReportDao;



	@RestController
	@RequestMapping(value = { "master" })
	public class RestHrmsReportController {
		
		Logger logger = LoggerFactory.getLogger(RestHrmsReportController.class);

		@Autowired
		RestHrmsReportDao restHrmsReportDao;	
	
	
	@RequestMapping(value = "rest-getData", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getData(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : rest getData starts");
		
		logger.info("Method : rest getData ends");
		return restHrmsReportDao.getData(org, orgDiv);
	} 
	
	@RequestMapping(value = "rest-getAttendanceReport", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> getAttendanceReport(@RequestParam String org, @RequestParam String orgDiv,@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : rest getAttendanceReport starts");
		
		logger.info("Method : rest getAttendanceReport ends");
		return restHrmsReportDao.getAttendanceReport(org, orgDiv,fromDate,toDate);
	} 
	
	@GetMapping(value = "rest-pdf-attendance")
	public JsonResponse<Object> attendancePDF(@RequestParam String orgName,String orgDivision,String fromDate,String toDate) {
		logger.info("Method :attendancePDF starts");
		
		logger.info("Method :attendancePDF ends");
		return restHrmsReportDao.attendancePDF(orgName,orgDivision,fromDate,toDate);
	}
}
