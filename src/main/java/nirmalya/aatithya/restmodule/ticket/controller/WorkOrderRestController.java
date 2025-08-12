package nirmalya.aatithya.restmodule.ticket.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.ticket.dao.WorkOrderDao;

@RestController
@RequestMapping(value = "ticket/")
public class WorkOrderRestController {
	Logger logger = LoggerFactory.getLogger(WorkOrderRestController.class);

	@Autowired
	WorkOrderDao workOrderDao;
	
	/*
	 * Get all Work Order
	 */
	
	@GetMapping(value = "rest-get-workorder")
	public JsonResponse<Object> getAllWorkOrder(@RequestParam String userid,@RequestParam String org, @RequestParam String orgDiv,
			 @RequestParam String pageno, @RequestParam String activity,
			@RequestParam String fromDate,@RequestParam String toDate) {
		logger.info("Method :getAllWorkOrder start");

		logger.info("Method :getAllWorkOrder ends");
		return workOrderDao.getAllWorkOrder(org, orgDiv, userid, pageno, activity, fromDate, toDate);

	}
	

	/*
	 * Get all Work Order- Search
	 */
	
	@GetMapping(value = "rest-get-workorder-search")
	public JsonResponse<Object> getAllWorkOrderSearch(@RequestParam String userid,@RequestParam String org, @RequestParam String orgDiv,
			@RequestParam String pageno, @RequestParam String activity,
			@RequestParam String fromDate,@RequestParam String toDate,@RequestParam String search) {
		logger.info("Method :getAllWorkOrderSearch start");
		
		logger.info("Method :getAllWorkOrderSearch ends");
		return workOrderDao.getAllWorkOrderSearch(org, orgDiv, userid, pageno, activity, fromDate, toDate, search);
		
	}

}
