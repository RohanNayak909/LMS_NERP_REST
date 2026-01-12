package nirmalya.aatithya.restmodule.pipeline.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pipeline.dao.RestCrmCustomerDao;
import nirmalya.aatithya.restmodule.pipeline.model.RestCrmCustomerModel;

/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "pipeline")
public class RestCrmCustomerController {
	Logger logger = LoggerFactory.getLogger(RestCrmCustomerController.class);
	@Autowired
	RestCrmCustomerDao restCrmCustomerDao;

	
	//addVendorCRM
	/*
	 * for All  Add vendor
	 */
	@RequestMapping(value="addCustomer" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addCustomer(@RequestBody RestCrmCustomerModel assignSkill) 
	{
		logger.info("Method : addCustomer starts");
		
		logger.info("restCRMCustomerModel---------------------"+assignSkill);
		
		logger.info("Method : addCustomer ends");
		
		return restCrmCustomerDao.addCustomer(assignSkill);
	}
	

	
	
	
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewCustDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>> restViewCustDetails(){
		logger.info("Method: restViewCustDetails View Start");
		
		logger.info("Method: restViewCustDetails ends");
		return restCrmCustomerDao.restViewCustDetails();
	}
	
	
	//editVendorInfo

	
	@GetMapping(value = "editCustomerInfo")
	public ResponseEntity<JsonResponse<List<RestCrmCustomerModel>>> editCustomerInfo(@RequestParam String id) {
		logger.info("Method :editCustomerInfo starts");

		logger.info("Method :editCustomerInfo ends"+id);
		return restCrmCustomerDao.editCustomerInfo(id);

	}
	
	
	//delete-vendor-Details
	
	@RequestMapping(value = "deleteCrmCustomersDetails", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteCrmCustomersDetails(@RequestParam String id) {
		logger.info("Method :  deleteCrmCustomersDetails starts"+id);

		logger.info("Method :  deleteCrmCustomersDetails ends");
		return restCrmCustomerDao.deleteCrmCustomersDetails(id);
	}
	
	
	//getVendorNameAutoSearch
	/*@GetMapping(value = "getVendorNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoSearch starts");

		logger.info("Method :getVendorNameAutoSearch endss");
		return restCrmVendorDao.getVendorNameAutoSearch(id);
	}*/
}
