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

import nirmalya.aatithya.restmodule.asset.dao.AssetAssignDao;
import nirmalya.aatithya.restmodule.asset.dao.AssetViewMasterDao;
import nirmalya.aatithya.restmodule.asset.model.AssetViewMasterRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetAssignRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetAssignDao assetAssignDao;



	// View Assigned Asset
	@RequestMapping(value = "rest-asset-assign-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetAssign(@RequestParam String orgName, String orgDivision, String id, String userId) {
		logger.info("Method :viewAssetAssign start");

		logger.info("Method :viewAssetAssign endss");
		return assetAssignDao.viewAssetAssign(id,orgName, orgDivision,userId);
	}
	// edit Assigned Asset
	@RequestMapping(value = "rest-asset-assign-edit", method = { RequestMethod.GET })
	public JsonResponse<Object> editAssetAssign(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editAssetAssign start");

		logger.info("Method :editAssetAssign endss");
		return assetAssignDao.editAssetAssign(id, orgName, orgDivision);
	}
	
	// assignAsset
	@RequestMapping(value = "rest-asset-assign-update", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> assignAssetUpdate(@RequestParam String id,String assetcat,String assetemp,String assigndate, String org, String orgDiv) {
		logger.info("Method : assignAssetUpdate starts");

		logger.info("Method : assignAssetUpdate ends");
		return assetAssignDao.assignAssetUpdate(id,assetcat,assetemp,assigndate, org, orgDiv);

	}
	
	// approveAssign
	@RequestMapping(value = "rest-asset-assign-active", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAsset(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAsset starts");

		logger.info("Method : approveAsset ends");
		return assetAssignDao.approveAssign(id, org, orgDiv);

	}
	// dissociateAsset
	@RequestMapping(value = "rest-asset-assign-dissociate", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> dissociateAsset(@RequestParam String assignid,String assetid, String org, String div,String dreason) {
		logger.info("Method : dissociateAsset starts");

		logger.info("Method : dissociateAsset ends");
		return assetAssignDao.dissociateAsset(assignid,assetid, org, div,dreason);

	}

	// Search
	@RequestMapping(value = "rest-AssetAssignViewSearch", method = { RequestMethod.GET })
	public JsonResponse<Object> assetAssignViewSearch(@RequestParam String orgName, @RequestParam String orgDivision, String searchValue) {
		logger.info("Method :assetAssignViewSearch start");

		logger.info("Method :assetAssignViewSearch endss");
		return assetAssignDao.assetAssignViewSearch(orgName, orgDivision, searchValue);

	}
}