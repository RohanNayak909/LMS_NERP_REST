package nirmalya.aatithya.restmodule.inventory.controller;

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

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.inventory.dao.RestShoukeenDealerDao;
import nirmalya.aatithya.restmodule.inventory.model.RestShoukeenDealerModel;


/**
 * @author Nirmalya Labs
 *
 */
@RestController
@RequestMapping(value = "inventory")
public class RestShoukeenDealerController {
	Logger logger = LoggerFactory.getLogger(RestShoukeenDealerController.class);
	@Autowired
	RestShoukeenDealerDao restShoukeenDealerDao;
	
	//getCountry
	
	/**
	 * returns Country for drop down model
	 *
	 */
	@RequestMapping(value = "/getShoukeenCountry", method = { RequestMethod.GET })
	public List<DropDownModel> getShoukeenCountryList() {
		logger.info("Method : getShoukeenCountryList starts");
		
		logger.info("Method : getShoukeenCountryList end");
		return restShoukeenDealerDao.getShoukeenCountryList();
	}
	
	//getShoukeenState
	
	/**
	 * returns getShoukeenState for drop down model
	 *
	 */
	@RequestMapping(value = "/getShoukeenState", method = { RequestMethod.GET })
	public List<DropDownModel> getShoukeenState() {
		logger.info("Method : getShoukeenState starts");
		
		logger.info("rest dao for shoukeen State-------------1111111111111111111111");
		
		
		
		logger.info("Method : getShoukeenState end");
		return restShoukeenDealerDao.getShoukeenState();
	}

	
	//addVendorCRM
	/*
	 * for All  Add vendor
	 */
	@RequestMapping(value="addDealer" , method={RequestMethod.POST})
	public ResponseEntity<JsonResponse<Object>> addDealer(@RequestBody RestShoukeenDealerModel restShoukeenDealerModel) 
	{
		logger.info("Method : addDealer starts");
		
		logger.info("Method : addDealer ends");
		
		return restShoukeenDealerDao.addDealer(restShoukeenDealerModel);
	}
	
	//restViewVendorDetails
	
	/*
	 * for view
	 */
	@RequestMapping(value="restViewDealerDetails" , method = {RequestMethod.GET})
	public ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> restViewDealerDetails(){
		logger.info("Method: restViewDealerDetails View Start");
		logger.info("RestShoukeenDealerModel------restViewDealerDetails");
		logger.info("Method: restViewDealerDetails ends");
		return restShoukeenDealerDao.restViewDealerDetails();
	}
	
	
	//editDealerInfo

	
	@GetMapping(value = "editDealerInfo")
	public ResponseEntity<JsonResponse<List<RestShoukeenDealerModel>>> editDealerInfo(@RequestParam String id) {
		logger.info("Method :editDealerInfo starts");

		logger.info("Method :editDealerInfo ends"+id);
		return restShoukeenDealerDao.editDealerInfo(id);

	}
	
	
	//delete-vendor-Details
	
	@RequestMapping(value = "delete-dealer-Details", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDealerDetails(@RequestParam String id) {
		logger.info("Method :  deleteDealerDetails starts"+id);

		logger.info("Method :  deleteDealerDetails ends");
		return restShoukeenDealerDao.deleteDealerDetails(id);
	}
	
	
	//getVendorNameAutoSearch
/*	@GetMapping(value = "getVendorNameAutoSearch")
	public ResponseEntity<JsonResponse<List<DropDownModel>>> getVendorNameAutoSearch(
			@RequestParam String id) {
		logger.info("Method : getVendorNameAutoSearch starts");

		logger.info("Method :getVendorNameAutoSearch endss");
		return restCrmVendorDao.getVendorNameAutoSearch(id);
	}*/
}
