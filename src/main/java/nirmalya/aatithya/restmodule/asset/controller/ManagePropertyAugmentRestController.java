package nirmalya.aatithya.restmodule.asset.controller;

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

import nirmalya.aatithya.restmodule.asset.dao.ManagePropertyAugmentDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class ManagePropertyAugmentRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	ManagePropertyAugmentDao managePropertyAugmentDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-manage-property-augment-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyAugment(@RequestParam String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method :viewPropertyAugment start");

		logger.info("Method :viewPropertyAugment endss");
		return managePropertyAugmentDao.viewPropertyAugment(orgName, orgDivision,property,floor,space);
	}
	
	@RequestMapping(value = "getPropertyListForAugment", method = { RequestMethod.GET })
	public List<DropDownModel> getPropertyList(@RequestParam String org,String orgDiv,String userId) {
		logger.info("Method : getPropertyList starts");

		logger.info("Method : getPropertyList ends");
		return managePropertyAugmentDao.getPropertyList(org,orgDiv,userId);
	}
	
	@RequestMapping(value = "rest-manage-property-augment-getfloor", method = { RequestMethod.GET })
	public JsonResponse<Object> getFloorFromProperty(@RequestParam String orgName, String orgDivision,String property) {
		logger.info("Method :getFloorFromProperty start");

		logger.info("Method :getFloorFromProperty endss");
		return managePropertyAugmentDao.getFloorFromProperty(orgName, orgDivision,property);
	}
	@PostMapping(value = "rest-manage-property-augment-asset-add")
	public JsonResponse<Object> addAsset(

			@RequestBody List<AssetViewMasterRestModel> assetMasterModel) {
		logger.info("Method : addAsset starts");
		logger.info("Method : addAsset ends");
		return managePropertyAugmentDao.addAsset(assetMasterModel);
	}
	
}
