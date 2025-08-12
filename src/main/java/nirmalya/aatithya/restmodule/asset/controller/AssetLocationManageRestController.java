package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetLocationManageDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetLocationManageRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetLocationManageDao assetLocationManageDao;



	@RequestMapping(value = "rest-asset-location-manage-view", method = { RequestMethod.GET })
	public JsonResponse<Object> locationManageView(@RequestParam String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method :locationManageView start");

		logger.info("Method :locationManageView endss");
		return assetLocationManageDao.locationManageView(orgName, orgDivision,userId,userRole);
	}
}
