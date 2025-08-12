package nirmalya.aatithya.restmodule.property.stakeholder.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.property.stakeholder.dao.RestStakeholderManagePropertyPerformanceDao;
import nirmalya.aatithya.restmodule.property.stakeholder.model.RestManagePropertyPerformanceModel;


@RestController
@RequestMapping("property/")
public class RestStakeholderManagePropertyPerformanceController {

	Logger logger = LoggerFactory.getLogger(RestStakeholderManagePropertyPerformanceController.class);
	@Autowired
	RestStakeholderManagePropertyPerformanceDao restManagePropertyPerformanceDao;

////add
	@RequestMapping(value = "property-performance-add-Performancedetails", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> savePropertyPerformance(
			@RequestBody RestManagePropertyPerformanceModel performance) {
		logger.info("$$$$" + performance);
		logger.info("Method : savePropertyPerformance starts");
		logger.info("restPayroll");
		logger.info("Method : savePropertyPerformance ends");
		return restManagePropertyPerformanceDao.savePropertyPerformance(performance);
	}

////view
	@RequestMapping(value = "property-performance-view", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> ViewPropertyPerformance(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {
		logger.info("Method : ViewPropertyPerformance starts");

		logger.info("Method : ViewPropertyPerformance ends");
		return restManagePropertyPerformanceDao.ViewPropertyPerformance(userid, fromDate, toDate);
	}

	/// edit
	@GetMapping(value = "editPropertyPerformance")
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> editPropertyPerformance(
			@RequestParam String id) {
		logger.info("Method : editPropertyPerformance starts");

		logger.info("Method :editPropertyPerformance ends" + id);
		return restManagePropertyPerformanceDao.editPropertyPerformance(id);

	}

////delete
	@RequestMapping(value = "property-performance-delete-PropertyPerformance", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deletePropertyPerformance(@RequestParam String id) {
		logger.info("Method :  deletePropertyPerformance starts" + id);

		logger.info("Method :  deletePropertyPerformance ends");
		return restManagePropertyPerformanceDao.deletePropertyPerformance(id);
	}

	@RequestMapping(value = "Rest-manage-property-performance", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestManagePropertyPerformanceModel>>> viewPropertyPerformance(@RequestParam String userid,
			@RequestParam String fromDate, @RequestParam String toDate) {

		logger.info("Method : viewperformancedetails starts");

		logger.info("Method : viewperformancedetails ends" + userid + fromDate + toDate);
		return restManagePropertyPerformanceDao.viewPropertyPerformance(userid, fromDate, toDate);
	}
	
	@GetMapping(value = "getProperty-type-autocomplete")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getPropertyAutocomplete(
			@RequestParam String id) {
		logger.info("Method : getPropertyAutocomplete starts");

		logger.info("Method :getPropertyAutocomplete ends");
		return restManagePropertyPerformanceDao.getPropertyAutocomplete(id);
	}

}
