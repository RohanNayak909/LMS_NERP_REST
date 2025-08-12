package nirmalya.aatithya.restmodule.asset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.ManagePropertyExecutionDao;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = "asset/")
public class ManagePropertyExecutionRestController {
	
	Logger logger = LoggerFactory.getLogger(ManagePropertyExecutionRestController.class);

	@Autowired
	ManagePropertyExecutionDao managePropertyExecutionDao;

	
	@RequestMapping(value = "rest-manage-property-execution-asset-list", method = { RequestMethod.GET })
	public JsonResponse<Object> showTotalAsset(@RequestParam String type,String cat,String scat, String orgName, String orgDivision) {
		logger.info("Method :showTotalAsset start");

		logger.info("Method :showTotalAsset endss");
		return managePropertyExecutionDao.showTotalAsset(type,cat,scat,orgName, orgDivision);
	}
	
	@RequestMapping(value = "rest-manage-property-execution-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewPropertyApproved(@RequestParam String orgName, String orgDivision,String property,String floor,String space) {
		logger.info("Method :viewPropertyApproved start");

		logger.info("Method :viewPropertyApproved endss");
		return managePropertyExecutionDao.viewPropertyApproved(orgName, orgDivision,property,floor,space);
	}
	
	@RequestMapping(value = "rest-manage-property-execution-asset-assign", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> assignAsset(@RequestParam String id,String locid,String loctype,String date,String planId, String org, String orgDiv, String userId) {
		logger.info("Method : assignAsset starts");

		logger.info("Method : assignAsset ends");
		return managePropertyExecutionDao.assignAssetForExecution(id,locid,loctype, date,planId, org, orgDiv,userId);

	}
	
	@RequestMapping(value = "rest-manage-property-execution-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editPropertyPlan(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editPropertyPlan start");

		logger.info("Method :editPropertyPlan endss");
		return managePropertyExecutionDao.editPropertyPlan(id, orgName, orgDivision);
	}
}
