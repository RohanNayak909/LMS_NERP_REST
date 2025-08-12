package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetProfileDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetReportDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetProfileRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetProfileDao assetProfileDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-asset-profile-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetProfile(@RequestParam String orgName, String orgDivision, String userId) {
		logger.info("Method :viewAssetProfile start");

		logger.info("Method :viewAssetProfile endss");
		return assetProfileDao.viewAssetProfile(orgName, orgDivision,userId);
	}
	
	@RequestMapping(value = "rest-asset-profile-asset-details", method = { RequestMethod.GET })
	public JsonResponse<Object> showAssetDetails(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :showAssetDetails start");

		logger.info("Method :showAssetDetails endss");
		return assetProfileDao.showAssetDetails(id, orgName, orgDivision);
	}
}
