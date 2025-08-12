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
import nirmalya.aatithya.restmodule.maintenance.dao.VendorRegistrationDao;
import nirmalya.aatithya.restmodule.maintenance.model.VendorRegistrationRestModal;

/**
 * @author NirmalyaLabs
 *
 */
@RestController
@RequestMapping(value = { "maintenance" })
public class VendorRegistrationRestController {

	Logger logger = LoggerFactory.getLogger(VendorRegistrationRestController.class);
	@Autowired
	VendorRegistrationDao vendorRegistrationDao;


	@RequestMapping(value = "rest-vendor-registration-add", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addVendor(@RequestBody VendorRegistrationRestModal vendorRegistrationRestModal) {
		logger.info("Method : addVendor starts");

		logger.info("Method : addVendor ends");

		return vendorRegistrationDao.addVendorRegistration(vendorRegistrationRestModal);
	}
	
	@RequestMapping(value = "rest-vendor-registration-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewRegistrationOfVendor(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewRegistrationOfVendor start");

		logger.info("Method :viewRegistrationOfVendor endss");
		return vendorRegistrationDao.viewRegistrationOfVendor(orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-vendor-registration-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editVendorDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editVendorDetails start");

		logger.info("Method :editVendorDetails endss");
		return vendorRegistrationDao.editVendorDetails(id, orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-vendor-registration-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteVendorDetails(@RequestParam String id) {
		logger.info("Method :  deleteVendorDetails starts"+id);

		logger.info("Method :  deleteVendorDetails ends");
		return vendorRegistrationDao.deleteVendorDetails(id);
	}
	
	@RequestMapping(value = "rest-vendor-registration-active", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> activeVendorDetails(@RequestParam String id,String operation,String org,String orgDiv) {
		logger.info("Method :  activeVendorDetails starts"+id);

		logger.info("Method :  activeVendorDetails ends");
		return vendorRegistrationDao.activeVendorDetails(id,operation,org,orgDiv);
	}
}
