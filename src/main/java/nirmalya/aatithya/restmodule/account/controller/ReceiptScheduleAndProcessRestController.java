package nirmalya.aatithya.restmodule.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import nirmalya.aatithya.restmodule.account.dao.ReceiptScheduleAndProcessDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "account")
public class ReceiptScheduleAndProcessRestController {

	Logger logger = LoggerFactory.getLogger(ReceiptScheduleAndProcessRestController.class);
	
	@Autowired
	ReceiptScheduleAndProcessDao receiptScheduleAndProcessDao;
	
	
	@RequestMapping(value = "receipt-schedule-view", method = { RequestMethod.GET })
	public JsonResponse<Object> receiptSecheduleView(@RequestParam String orgName, @RequestParam String orgDivision, String id) {
		logger.info("Method :receiptSecheduleView start");
		
		logger.info("Method :receiptSecheduleView endss");
		return receiptScheduleAndProcessDao.receiptSecheduleView(orgName, orgDivision,id);
		
	}
	
	@RequestMapping(value = "payment-receivable-save", method = { RequestMethod.GET })
	public JsonResponse<Object> receiptScheduleSave(@RequestParam String invId,String scheduleDate, String orgName,String orgDiv, String userId,String type) {
		logger.info("Method :receiptScheduleSave start");

		logger.info("Method :receiptScheduleSave endss");
		return receiptScheduleAndProcessDao.receiptScheduleSave(invId,scheduleDate,orgName, orgDiv,userId,type);
	}
	
	
	@RequestMapping(value = "receivable-process-view", method = { RequestMethod.GET })
	public JsonResponse<Object> receivableProcessView(@RequestParam String orgName, @RequestParam String orgDivision, String id , String fromdate , String todate) {
		logger.info("Method :receivableProcessView start");
		
		logger.info("Method :receivableProcessView endss");
		return receiptScheduleAndProcessDao.receivableProcessView(orgName, orgDivision,id,fromdate,todate);
	}
}
