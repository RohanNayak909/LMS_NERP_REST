package nirmalya.aatithya.restmodule.maintenance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.maintenance.dao.ServiceListingDao;
import nirmalya.aatithya.restmodule.maintenance.dao.VendorRegistrationDao;
import nirmalya.aatithya.restmodule.maintenance.model.VendorRegistrationRestModal;

@RestController
@RequestMapping(value = { "maintenance" })
public class ServiceListingRestController {

	Logger logger = LoggerFactory.getLogger(ServiceListingRestController.class);
	@Autowired
	ServiceListingDao serviceListingDao;

	
	@RequestMapping(value = "rest-service-listing-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewServiceList(@RequestParam String orgName, String orgDivision, String userRole, String userName, String userId) {
		logger.info("Method :viewServiceList start");

		logger.info("Method :viewServiceList endss");
		return serviceListingDao.viewServiceList(orgName, orgDivision, userRole, userName, userId);
	}
	
	@RequestMapping(value = "rest-service-listing-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addService(@RequestBody VendorRegistrationRestModal vendorRegistrationRestModal) {
		logger.info("Method : addService starts");

		logger.info("Method : addService ends");

		return serviceListingDao.addService(vendorRegistrationRestModal);
	}
	
	@RequestMapping(value = "rest-service-listing-service-show", method = { RequestMethod.GET })
	public JsonResponse<Object> editServiceDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editServiceDetails start");

		logger.info("Method :editServiceDetails endss");
		return serviceListingDao.editServiceDetails(id, orgName, orgDivision);
	}
}
