package nirmalya.aatithya.restmodule.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.hotel.dao.HotelBillingDao;

	
	@RestController
	@RequestMapping(value = { "hotel" })
	public class BillingRestController {
		Logger logger = LoggerFactory.getLogger(BillingRestController.class);
		
		@Autowired
		HotelBillingDao hotelBillingDao;
		
		
		/*rest-get-all-cust-details*/
		 @GetMapping(value = "rest-get-all-cust-details")
			public JsonResponse<Object> getAllCustDetails(@RequestParam String org, @RequestParam String orgDiv,
					@RequestParam String userid, @RequestParam String id) {
				logger.info("Method :getAllCustDetails start");

				logger.info("Method :getAllCustDetails ends");
				return hotelBillingDao.getAllCustDetails(org, orgDiv, userid, id);

			}
		 
		 
			/*rest-hotel-billing-get-balancesheet*/
		 @RequestMapping(value = "rest-hotel-billing-get-balancesheet", method = { RequestMethod.GET })
			public JsonResponse<Object> getAllBalanceSheet(@RequestParam String id, @RequestParam String organization,
					@RequestParam String orgDivision) {
				logger.info("Method :getAllBalanceSheet start");
				logger.info("Method :getAllBalanceSheet endss");
				return hotelBillingDao.getAllBalanceSheet(id, organization, orgDivision);
			}


}
