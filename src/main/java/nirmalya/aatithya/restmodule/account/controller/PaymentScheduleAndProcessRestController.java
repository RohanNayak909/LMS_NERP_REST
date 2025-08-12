package nirmalya.aatithya.restmodule.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.account.dao.PaymentScheduleAndProcessDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class PaymentScheduleAndProcessRestController {
	Logger logger = LoggerFactory.getLogger(PaymentScheduleAndProcessRestController.class);
	@Autowired
	PaymentScheduleAndProcessDao paymentScheduleAndProcessDao;
	
	@RequestMapping(value = "payment-schedule-view", method = { RequestMethod.GET })
	public JsonResponse<Object> paymentScheduleView(@RequestParam String orgName, @RequestParam String orgDivision, String id, String type) {
		logger.info("Method :paymentScheduleView start");
		
		logger.info("Method :paymentScheduleView endss");
		return paymentScheduleAndProcessDao.paymentScheduleView(orgName, orgDivision,id,type);
		
	}

	@RequestMapping(value = "payment-schedule-save", method = { RequestMethod.GET })
	public JsonResponse<Object> paymentScheduleSave(@RequestParam String invId,String scheduleDate, String orgName,String orgDiv, String userId,String type) {
		logger.info("Method :paymentScheduleSave start");

		logger.info("Method :paymentScheduleSave endss");
		return paymentScheduleAndProcessDao.paymentScheduleSave(invId,scheduleDate,orgName, orgDiv,userId,type);
	}
	
	
	@RequestMapping(value = "payment-process-view", method = { RequestMethod.GET })
	public JsonResponse<Object> paymentProcessView(@RequestParam String orgName, @RequestParam String orgDivision , String fromdate , String todate,String type) {
		logger.info("Method :paymentProcessView start");
		
		logger.info("Method :paymentProcessView endss");
		return paymentScheduleAndProcessDao.paymentProcessView(orgName, orgDivision,fromdate,todate,type);
	}
 
}
