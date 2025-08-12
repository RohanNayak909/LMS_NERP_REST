package nirmalya.aatithya.restmodule.purchase.cotroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestGateReceivedDao;

@RestController
@RequestMapping(value = "purchase/")
public class RestGateReceivedController {
	
	Logger logger = LoggerFactory.getLogger(RestGateReceivedController.class);

	@Autowired
	RestGateReceivedDao restGateReceivedDao;

	@RequestMapping(value = "rest-gateReceivedDataView", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDataView(@RequestParam String orgName, @RequestParam String orgDivision, String id, String pageno) {
		logger.info("Method :gateReceivedDataView start");

		logger.info("Method :gateReceivedDataView endss");
		return restGateReceivedDao.gateReceivedDataView(orgName, orgDivision, id, pageno);

	}
	
	@RequestMapping(value = "rest-gateReceivedDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDtls(@RequestParam String id,@RequestParam String po, String orgName, String orgDivision) {
		logger.info("Method :gateReceivedDtls start");

		logger.info("Method :gateReceivedDtls endss");
		return restGateReceivedDao.gateReceivedDtls(id, po, orgName, orgDivision);

	}
	// Search
	@RequestMapping(value = "rest-gateReceivedDataViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDataViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String id, String searchValue) {
		logger.info("Method :gateReceivedDataViewSearch start");

		logger.info("Method :gateReceivedDataViewSearch endss");
		return restGateReceivedDao.gateReceivedDataViewSearch(orgName, orgDivision, id, searchValue);

	}
	
	
	/*
	 * -----------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * ------------------------------------------------------------
	 * ----------------------------------------------------ORI - FOOD GATE RECEIVED
	 * -----------------------------------------------------------------------------
	 * --------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * -----------------------------------------------------------------------------
	 * ------------------------------------------------------------
	 */

	// Qa Request For OriFood.
	
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "rest-qaRequestForOf")
	public JsonResponse qaRequestForOf(@RequestParam String sku, String gatePass, String org,
			String orgDiv, String challanNo, String challanDt ) {
		logger.info("Method : qaRequestForOf starts");
		
		logger.info("Method : qaRequestForOf endss");
		return restGateReceivedDao.qaRequestForOf(sku, gatePass, org, orgDiv, challanNo, challanDt );
	}
	
	// child View
	
	@RequestMapping(value = "rest-Of-gateReceivedDtls", method = { RequestMethod.GET })
	public JsonResponse<Object> gateReceivedDtlsOf(@RequestParam String id,@RequestParam String po, String orgName, String orgDivision) {
		logger.info("Method :gateReceivedDtlsOf start");

		logger.info("Method :gateReceivedDtlsOf endss");
		return restGateReceivedDao.gateReceivedDtlsOf(id, po, orgName, orgDivision);

	}
	
	// Filtered Data view
	
	@RequestMapping(value = "rest-gateReceived-Filtered-DataView", method = { RequestMethod.GET })
	public JsonResponse<Object> gateFilteredReceivedDataView(@RequestParam String orgName, @RequestParam String orgDivision, String id, 
			String fromDate,String toDate, String searchData) {
		logger.info("Method :gateFilteredReceivedDataView start");

		logger.info("Method :gateFilteredReceivedDataView endss");
		return restGateReceivedDao.gateFilteredReceivedDataView(orgName, orgDivision, id, fromDate,toDate,searchData);

	}

}
