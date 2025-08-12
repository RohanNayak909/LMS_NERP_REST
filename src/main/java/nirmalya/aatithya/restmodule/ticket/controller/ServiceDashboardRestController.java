package nirmalya.aatithya.restmodule.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.ServiceDashboardDao;

@RestController
@RequestMapping("ticket/")
public class ServiceDashboardRestController {
	Logger logger = LoggerFactory.getLogger(ServiceDashboardRestController.class);
	@Autowired 
	ServiceDashboardDao serviceDashboardDao;
	
	@RequestMapping(value = "rest-service-head-data", method = { RequestMethod.GET })
	public JsonResponse<Object> serviceHeadData(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :serviceHeadData start");

		logger.info("Method :serviceHeadData ends");
		return serviceDashboardDao.serviceHeadData(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-service-percentage-call", method = { RequestMethod.GET })
	public JsonResponse<Object> servicePercentageCall(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :servicePercentageCall start");

		logger.info("Method :servicePercentageCall ends");
		return serviceDashboardDao.servicePercentageCall(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-service-monthly-ticket", method = { RequestMethod.GET })
	public JsonResponse<Object> serviceMonthlyTicket(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :serviceMonthlyTicket start");

		logger.info("Method :serviceMonthlyTicket ends");
		return serviceDashboardDao.serviceMonthlyTicket(fromDate,toDate,organization,division,location);
	}
	
	@RequestMapping(value = "rest-service-call-response", method = { RequestMethod.GET })
	public JsonResponse<Object> serviceCallResponse(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :serviceCallResponse start");

		logger.info("Method :serviceCallResponse ends");
		return serviceDashboardDao.serviceCallResponse(fromDate,toDate,organization,division,location);
	}
	@RequestMapping(value = "rest-service-top-performers", method = { RequestMethod.GET })
	public JsonResponse<Object> serviceTopPerformers(@RequestParam String fromDate,@RequestParam String toDate, @RequestParam String organization,
			@RequestParam String division,@RequestParam String location) {
		logger.info("Method :serviceTopPerformers start");

		logger.info("Method :serviceTopPerformers ends");
		return serviceDashboardDao.serviceTopPerformers(fromDate,toDate,organization,division,location);
	}
}
