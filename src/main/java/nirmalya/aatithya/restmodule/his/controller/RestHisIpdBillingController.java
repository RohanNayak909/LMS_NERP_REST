package nirmalya.aatithya.restmodule.his.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.dao.HISOPDDao;
import nirmalya.aatithya.restmodule.his.dao.HisIpdBillingDao;
import nirmalya.aatithya.restmodule.his.dao.HisOpdBillingDao;

@RestController
@RequestMapping(value = "his/")
public class RestHisIpdBillingController {

	
	Logger logger = LoggerFactory.getLogger(HISOPDRestController.class);

	@Autowired
	HisIpdBillingDao hisIpdBillingDao;
	
	// rest-viewOpdDetails
		@RequestMapping(value = "rest-ipd-billing-viewOpdDetails", method = { RequestMethod.GET })
		public JsonResponse<Object> viewIpdDetails(@RequestParam String orgName, @RequestParam String orgDivision,
				@RequestParam String fromdate, @RequestParam String todate) {
			logger.info("Method :viewIpdDetails start");
			logger.info("Method :viewIpdDetails endss");
			return hisIpdBillingDao.viewIpdDetails(orgName, orgDivision, fromdate, todate);
		}
		
		@RequestMapping(value = "rest-ipd-billing-editIpd", method = { RequestMethod.GET })
		public JsonResponse<Object> editIpd(@RequestParam String Id, @RequestParam String organization,
				@RequestParam String orgDivision) {
			logger.info("Method :editIpd start");
			logger.info("Method :editIpd endss");
			return hisIpdBillingDao.editIpd(Id, organization, orgDivision);
		}
}
