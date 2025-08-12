package nirmalya.aatithya.restmodule.purchase.cotroller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.PurchaseReportDao;

@RestController
@RequestMapping(value = "master/")
public class RestPurchaseReportController {

	Logger logger = LoggerFactory.getLogger(RestPurchaseReportController.class);

	@Autowired
	PurchaseReportDao purchaseReportDao;

	@RequestMapping(value = "rest-viewPurchaseMtrlArrvReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseMtrlArrvReportData(@RequestParam String orgName, @RequestParam String orgDivision, String type) {
		logger.info("Method :viewPurchaseMtrlArrvReportData start");

		logger.info("Method :viewPurchaseMtrlArrvReportData endss");
		return purchaseReportDao.viewPurchaseMtrlArrvReportData(orgName, orgDivision,type);

	}
	
	@RequestMapping(value = "rest-viewPurchaseReportFilterData", method = { RequestMethod.GET })

	public JsonResponse<Object> viewPurchaseReportFilterData(@RequestParam String orgName, @RequestParam String orgDivision, String fdate,String tdate,String type) {
		logger.info("Method :viewPurchaseReportFilterData start");

		logger.info("Method :viewPurchaseReportFilterData endss");
		return purchaseReportDao.viewPurchaseReportFilterData(orgName,orgDivision,fdate,tdate, type);
	}
	
	@RequestMapping(value = "rest-viewPurchaseRMPMMtrlArrvReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseRMPMMtrlArrvReportData(@RequestParam String orgName, @RequestParam String orgDivision, String type) {
		logger.info("Method :viewPurchaseRMPMMtrlArrvReportData start");

		logger.info("Method :viewPurchaseRMPMMtrlArrvReportData endss");
		return purchaseReportDao.viewPurchaseRMPMMtrlArrvReportData(orgName, orgDivision,type);

	}
	@RequestMapping(value = "rest-viewPurchaseFGMtrlArrvReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseFGMtrlArrvReportData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewPurchaseFGMtrlArrvReportData start");

		logger.info("Method :viewPurchaseFGMtrlArrvReportData endss");
		return purchaseReportDao.viewPurchaseFGMtrlArrvReportData(orgName, orgDivision);

	}
	@RequestMapping(value = "rest-viewPurchaseSFGMtrlArrvReportData", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPurchaseSFGMtrlArrvReportData(@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method :viewPurchaseSFGMtrlArrvReportData start");

		logger.info("Method :viewPurchaseSFGMtrlArrvReportData endss");
		return purchaseReportDao.viewPurchaseSFGMtrlArrvReportData(orgName, orgDivision);

	}
}
