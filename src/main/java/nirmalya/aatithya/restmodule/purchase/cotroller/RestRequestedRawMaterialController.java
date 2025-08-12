package nirmalya.aatithya.restmodule.purchase.cotroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.purchase.dao.RestRequestedRawMaterialDao;
import nirmalya.aatithya.restmodule.purchase.model.RestPurchaseOrderModel;

@RestController
@RequestMapping("purchase/")
public class RestRequestedRawMaterialController {
	Logger logger = LoggerFactory.getLogger(RestRequestedRawMaterialController.class);

	@Autowired

	RestRequestedRawMaterialDao restRequestedRawMaterialDao;

// view ProductItem Data

	@RequestMapping(value = "viewProductItemData-details", method = { RequestMethod.GET })
	public JsonResponse<Object> viewProductItemData(@RequestParam String orgName, String orgDivision) {
		logger.info("Method :viewProductItemData start");

		logger.info("Method :viewProductItemData endss");
		return restRequestedRawMaterialDao.viewProductItemData(orgName, orgDivision);

	}

	@GetMapping(value = "getPOItemdata")
	public List<RestPurchaseOrderModel> getPOItemdata(@RequestParam String itemId, String sku, String org,
			String orgDiv) {
		logger.info("Method : getPOItemdata starts");
		logger.info("Method : getPOItemdata endss");
		return restRequestedRawMaterialDao.getPOItemdata(itemId, sku, org, orgDiv);
	}

	// editPlan data 
	@RequestMapping(value = "rest-editPlanData", method = { RequestMethod.GET })
	public JsonResponse<Object> editPlanData(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editPlanData start");

		logger.info("Method :editPlanData endss");
		return restRequestedRawMaterialDao.editPlanData(id, orgName, orgDivision);
	}
}
