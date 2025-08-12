package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetPhysicalVerificationDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetProfileDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetReportDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetPhysicalVerificationRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetPhysicalVerificationDao assetPhysicalVerificationDao;



	@RequestMapping(value = "rest-asset-physical-verfication-view", method = { RequestMethod.GET })
	public JsonResponse<Object> allotedVerificationView(@RequestParam String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method :allotedVerificationView start");

		logger.info("Method :allotedVerificationView endss");
		return assetPhysicalVerificationDao.allotedVerificationView(orgName, orgDivision,userId,userRole);
	}
	
	@RequestMapping(value = "rest-asset-physical-verfication-verify-details", method = { RequestMethod.GET })
	public JsonResponse<Object> addVerifyDetails(@RequestParam String id,String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method :addVerifyDetails start");

		logger.info("Method :addVerifyDetails endss");
		return assetPhysicalVerificationDao.addVerifyDetails(id,orgName, orgDivision,userId,userRole);
	}
	@PostMapping(value = "rest-asset-physical-verfication-submit")
	public JsonResponse<Object> assetVerifySubmit(@RequestBody List<AssetViewMasterRestModel> assetMasterModel) {
		logger.info("Method : assetVerifySubmit starts");
		logger.info("Method : assetVerifySubmit ends");
		return assetPhysicalVerificationDao.assetVerifySubmit(assetMasterModel);
	}
	
	@RequestMapping(value = "rest-asset-physical-verfication-active-details", method = { RequestMethod.GET })
	public JsonResponse<Object> viewVerifyDetails(@RequestParam String id,String orgName, String orgDivision,String userId, String userRole) {
		logger.info("Method :viewVerifyDetails start");

		logger.info("Method :viewVerifyDetails endss");
		return assetPhysicalVerificationDao.viewVerifyDetails(id,orgName, orgDivision,userId,userRole);
	}
}
