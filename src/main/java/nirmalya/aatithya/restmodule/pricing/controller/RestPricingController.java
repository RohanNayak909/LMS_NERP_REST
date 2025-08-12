package nirmalya.aatithya.restmodule.pricing.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.pricing.dao.DaoPricing;

@RestController
@RequestMapping(value = { "master" })
public class RestPricingController {
	Logger logger = LoggerFactory.getLogger(RestPricingController.class);

	@Autowired
	DaoPricing daoPricing;
	
	//get Activity List
	@GetMapping(value = "getActivityList")
	public List<DropDownModel> getActivityList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method : getActivityList starts");
 
		logger.info("Method : getActivityList ends");
		return daoPricing.getActivityList(org,orgDiv);
	}
	
	//Save PackageConfiguration Data 
	@PostMapping(value = "rest-save-packageconfig-details")
	public ResponseEntity<JsonResponse<Object>> savePackageConfig(@RequestBody String packageData ,@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :rest-save-packageconfig-details starts");

		logger.info("Method :rest-save-packageconfig-details ends");
		return daoPricing.savePackageConfig(packageData,org,orgDiv);
	}
	
	//View Packaging Data ------------------>>>>>>>>>>>>>>>>>
	@RequestMapping(value = "rest-packageData-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPackageData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewPackageData start");

		logger.info("Method :viewPackageData endss");
		return daoPricing.viewPackageData(orgName, orgDivision);
	}
	
	//Delete PackageData --->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	@RequestMapping(value = "rest-packageData-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteApplication(@RequestParam String id) {
		logger.info("Method : deleteApplication starts");

		logger.info("Method : deleteApplication ends");
		return daoPricing.deletePackageData(id);
	}

}
