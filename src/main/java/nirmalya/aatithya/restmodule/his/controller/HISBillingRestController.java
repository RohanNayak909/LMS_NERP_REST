package nirmalya.aatithya.restmodule.his.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetPolicyDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;
import nirmalya.aatithya.restmodule.his.dao.HISBillingRestDao;
import nirmalya.aatithya.restmodule.ticket.dao.DigitalLogBookDao;
import nirmalya.aatithya.restmodule.ticket.model.DigitalLogBookRestModel;

@RestController
@RequestMapping(value = { "his/" })
public class HISBillingRestController {

	Logger logger = LoggerFactory.getLogger(HISBillingRestController.class);

	@Autowired
	HISBillingRestDao hISBillingRestDao;

	

	// view
	@RequestMapping(value = "rest-billing-view", method = { RequestMethod.GET })
	public JsonResponse<Object> billingView(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :billingView start");

		logger.info("Method :billingView endss");
		return hISBillingRestDao.billingView(orgName, orgDivision);
	}
	//PDF
		@RequestMapping(value = "rest-billingPdf", method = { RequestMethod.GET })
		public JsonResponse<Object> billingPdf(@RequestParam String id,String orgName, String orgDivision) {
			logger.info("Method :billingPdf start");

			logger.info("Method :billingPdf endss");
			return hISBillingRestDao.billingPdf(id,orgName,orgDivision);

		}
}