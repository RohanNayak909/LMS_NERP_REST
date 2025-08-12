package nirmalya.aatithya.restmodule.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.KpiDashboardDao;

@RestController
@RequestMapping("ticket/")
public class KpiDashboardRestController {
	Logger logger = LoggerFactory.getLogger(KpiDashboardRestController.class);
	@Autowired
	KpiDashboardDao kpiDashboardDao;
	
	@RequestMapping(value = "rest-kpi-first-response-time", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiResponseTimeData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiResponseTimeData start");

		logger.info("Method :kpiResponseTimeData ends");
		return kpiDashboardDao.kpiResponseTimeData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-full-resolution-time", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiResolutionTimeData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiResolutionTimeData start");

		logger.info("Method :kpiResolutionTimeData ends");
		return kpiDashboardDao.kpiResolutionTimeData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-average-answer-time", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiAverageAnswerTime(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiAverageAnswerTime start");

		logger.info("Method :kpiAverageAnswerTime ends");
		return kpiDashboardDao.kpiAverageAnswerTime(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-ticket-by-type", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiTicketByType(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiTicketByType start");

		logger.info("Method :kpiTicketByType ends");
		return kpiDashboardDao.kpiTicketByType(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-ticket-by-category", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiTicketByCategory(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiTicketByCategory start");

		logger.info("Method :kpiTicketByCategory ends");
		return kpiDashboardDao.kpiTicketByCategory(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-call-answer-time", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiCallAnswerTime(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiCallAnswerTime start");

		logger.info("Method :kpiCallAnswerTime ends");
		return kpiDashboardDao.kpiCallAnswerTime(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-net-promoter-score", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiNetPromoterScore(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiNetPromoterScore start");

		logger.info("Method :kpiNetPromoterScore ends");
		return kpiDashboardDao.kpiNetPromoterScore(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-kpi-customer-retention", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiCustomerRetention(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiCustomerRetention start");

		logger.info("Method :kpiCustomerRetention ends");
		return kpiDashboardDao.kpiCustomerRetention(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "customer-effort-score", method = { RequestMethod.GET })
	public JsonResponse<Object> kpiCustomerEffortScore(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :kpiCustomerEffortScore start");

		logger.info("Method :kpiCustomerEffortScore ends");
		return kpiDashboardDao.kpiCustomerEffortScore(fromDate,toDate,organization,division,location);
	}
}
