package nirmalya.aatithya.restmodule.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.QualityDashboardDao;

@RestController
@RequestMapping("ticket/")
public class QualityDashboardRestController {
	Logger logger = LoggerFactory.getLogger(QualityDashboardRestController.class);
	
	@Autowired
	QualityDashboardDao qualityDashBoardDao;
	
	@RequestMapping(value = "rest-quality-gauge-data", method = { RequestMethod.GET })
	public JsonResponse<Object> qualityGaugeData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :qualityGaugeData start");

		logger.info("Method :qualityGaugeData ends");
		return qualityDashBoardDao.qualityGaugeData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-quality-gauge-sub-data", method = { RequestMethod.GET })
	public JsonResponse<Object> qualityGaugeSubData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :qualityGaugeSubData start");

		logger.info("Method :qualityGaugeSubData ends");
		return qualityDashBoardDao.qualityGaugeSubData(fromDate,toDate,organization,division,location);
	}
	
	 
	
	@RequestMapping(value = "rest-quality-average-resolution-data", method = { RequestMethod.GET })
	public JsonResponse<Object> qualityAverageResolutionData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :qualityAverageResolutionData start");

		logger.info("Method :qualityAverageResolutionData ends");
		return qualityDashBoardDao.qualityAverageResolutionData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-quality-help-desk-data", method = { RequestMethod.GET })
	public JsonResponse<Object> qualityHelpDeskData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :qualityHelpDeskData start");

		logger.info("Method :qualityHelpDeskData ends");
		return qualityDashBoardDao.qualityHelpDeskData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-quality-abandon-data", method = { RequestMethod.GET })
	public JsonResponse<Object> qualityAbandonData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :qualityAbandonData start");

		logger.info("Method :qualityAbandonData ends");
		return qualityDashBoardDao.qualityAbandonData(fromDate,toDate,organization,division,location);
	}
}
