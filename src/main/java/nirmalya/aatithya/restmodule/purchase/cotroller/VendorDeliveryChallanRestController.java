package nirmalya.aatithya.restmodule.purchase.cotroller;

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
import nirmalya.aatithya.restmodule.purchase.dao.VendorDeliveryChallanDao;
import nirmalya.aatithya.restmodule.purchase.model.VendorDeliveryChallanModel;

@RestController
@RequestMapping("purchase/")
public class VendorDeliveryChallanRestController {
	Logger logger = LoggerFactory.getLogger(VendorDeliveryChallanRestController.class);

	@Autowired

	VendorDeliveryChallanDao vendorDeliveryChallanDao;

	/*
	 * add
	 */
	@PostMapping(value = "addvendorDeliveryChallan")
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> addvendorDeliveryChallan(
			@RequestBody List<VendorDeliveryChallanModel> vendorDeliveryChallanModel) {
		logger.info("Method :addvendorDeliveryChallan starts");

		logger.info("Method :addvendorDeliveryChallan endss");
		return vendorDeliveryChallanDao.addvendorDeliveryChallan(vendorDeliveryChallanModel);
	}

	@RequestMapping(value = "rest-viewvendordeliveryChallan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<VendorDeliveryChallanModel>>> viewvendordeliveryChallan(
			@RequestParam String org, @RequestParam String orgDiv, @RequestParam String userId) {

		logger.info("Method :viewvendordeliveryChallan endss");
		return vendorDeliveryChallanDao.viewvendordeliveryChallan(org, orgDiv, userId);

	}

	/*
	 * edit
	 */ @GetMapping(value = "viewDeliveryChallanEdit")
	public List<VendorDeliveryChallanModel> viewDeliveryChallanEdit(@RequestParam String id,
			@RequestParam String orgName, @RequestParam String orgDivision) {
		logger.info("Method : viewDeliveryChallanEdit starts");

		logger.info("Method : viewDeliveryChallanEdit endss");
		return vendorDeliveryChallanDao.viewDeliveryChallanEdit(id, orgName, orgDivision);
	}

	/*
	 * delete
	 * 
	 */
	@RequestMapping(value = "deleteDeliveryChallan", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteDeliveryChallan(@RequestParam String id) {
		logger.info("Method : deleteDeliveryChallan starts");

		logger.info("Method : deleteDeliveryChallan ends");
		return vendorDeliveryChallanDao.deleteDeliveryChallan(id);
	}

	@GetMapping(value = "approveDeliverychallan")
	public JsonResponse<DropDownModel> approveDeliverychallan(@RequestParam String approveStatus, String vendorDeliveryChallan,
			String orgName, String orgDivision, String userId) {
		logger.info("Method : approveDeliverychallan starts");

		logger.info("Method : approveDeliverychallan ends");
		return vendorDeliveryChallanDao.approveDeliverychallan(approveStatus, vendorDeliveryChallan, orgName, orgDivision, userId);
	}
}
