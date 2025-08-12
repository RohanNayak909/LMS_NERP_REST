package nirmalya.aatithya.restmodule.master.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.his.model.RestHisBookingAmbulanceModel;
import nirmalya.aatithya.restmodule.master.dao.BillingDao;

@RestController
@RequestMapping(value = "master")
public class BillingController {
	
	Logger logger = LoggerFactory.getLogger(UserDistrictController.class);
	
	@Autowired
	BillingDao billingDao;
	
	@RequestMapping(value = "restgetproducttypewise", method = { RequestMethod.GET })
	public JsonResponse<Object> getProductTypeWiseInMasterRest(@RequestParam String orgName, @RequestParam String orgDivision, 
			@RequestParam String userId, @RequestParam String from,@RequestParam String  deptId) {
		logger.info("Method : getProductTypeWiseInMasterRest Rest Controller Starts");

		logger.info("Method : getProductTypeWiseInMasterRest Rest Controller Ends");
		return billingDao.getProductTypeWiseInMasterDao(orgName, orgDivision, userId, from,deptId);
	}
	
	@PostMapping(value = "restuserregsandproductbooking")
	public ResponseEntity<JsonResponse<Object>> userRegistrationWithProductBookingRest(
			@RequestBody RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method : userRegistrationWithProductBookingRest Rest Controller Starts");
		
		logger.info("Method : userRegistrationWithProductBookingRest Rest Controller Ends");
		return billingDao.userRegistrationWithProductBookingDao(addBookingAmbulance);
	}
	
	@PostMapping(value = "restipduserregsandproductbooking")
	public ResponseEntity<JsonResponse<Object>> ipduserRegistrationWithProductBookingRest(
			@RequestBody RestHisBookingAmbulanceModel addBookingAmbulance) {
		logger.info("Method : ipduserRegistrationWithProductBookingRest Rest Controller Starts");
		
		logger.info("Method : ipduserRegistrationWithProductBookingRest Rest Controller Ends");
		return billingDao.ipduserRegistrationWithProductBookingRest(addBookingAmbulance);
	}
	
	@PostMapping(value = "restChangeStatusOfBookedAmmbulance")
	public ResponseEntity<JsonResponse<Object>> restChangeStatusOfBookedAmmbulance(
			@RequestBody DropDownModel addBookingAmbulance) {
		logger.info("Method : restChangeStatusOfBookedAmmbulance Rest Controller Starts");
		
		logger.info("Method : restChangeStatusOfBookedAmmbulance Rest Controller Ends");
		return billingDao.restChangeStatusOfBookedAmmbulanceDao(addBookingAmbulance);
	}
	
	@PostMapping(value = "restdeletechilddata")
	public ResponseEntity<JsonResponse<Object>> restdeletechilddata(
			@RequestBody DropDownModel addBookingAmbulance) {
		logger.info("Method : restdeletechilddata Rest Controller Starts");
		
		logger.info("Method : restdeletechilddata Rest Controller Ends");
		return billingDao.restdeletechilddata(addBookingAmbulance);
	}
	
	@PostMapping(value = "restaddchilddata")
	public ResponseEntity<JsonResponse<Object>> restaddchilddata(
			@RequestBody DropDownModel addBookingAmbulance) {
		logger.info("Method : restaddchilddata Rest Controller Starts");
		
		logger.info("Method : restaddchilddata Rest Controller Ends");
		return billingDao.restaddchilddata(addBookingAmbulance);
	}
}
