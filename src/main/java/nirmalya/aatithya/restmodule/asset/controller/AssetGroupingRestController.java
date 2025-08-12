package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetGroupingRestDao;
import nirmalya.aatithya.restmodule.asset.model.AssetPoilcyRestModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.employee.controller.ScheduleManagementRestController;

@RestController
@RequestMapping(value = { "asset/" })
public class AssetGroupingRestController {

	Logger logger = LoggerFactory.getLogger(ScheduleManagementRestController.class);

	@Autowired
	AssetGroupingRestDao assetGroupingRestDao;



	// viewAssetPolicy
	@RequestMapping(value = "rest-asset-grouping-asset-list", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetInGrouping(@RequestParam String orgName, String orgDivision, String cat, String subcat) {
		logger.info("Method :viewAssetInGrouping start");

		logger.info("Method :viewAssetInGrouping endss");
		return assetGroupingRestDao.viewAssetInGrouping(orgName, orgDivision,cat,subcat);
	}
	
	@PostMapping(value = "rest-asset-grouping-add")
	public ResponseEntity<JsonResponse<List<AssetPoilcyRestModel>>> addAssetGroup(

			@RequestBody List<AssetPoilcyRestModel> assetPolicyModel) {
		logger.info("Method : addAssetGroup starts");
		logger.info("Method : addAssetGroup ends");
		return assetGroupingRestDao.addAssetGroup(assetPolicyModel);
	}
	
	@RequestMapping(value = "rest-asset-grouping-view", method = { RequestMethod.GET })
	public JsonResponse<Object> viewAssetGroup(@RequestParam String orgName, String orgDivision,String userId) {
		logger.info("Method :viewAssetGroup start");

		logger.info("Method :viewAssetGroup endss");
		return assetGroupingRestDao.viewAssetGroup(orgName, orgDivision,userId);
	}
	@RequestMapping(value = "rest-edit-grouping", method = { RequestMethod.GET })
	public JsonResponse<Object> editGrouping(@RequestParam String id, String orgName, String orgDivision) {
		logger.info("Method :editGrouping start");

		logger.info("Method :editGrouping endss");
		return assetGroupingRestDao.editGrouping(id, orgName, orgDivision);
	}
	@RequestMapping(value = "rest-asset-group-approve", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> approveAssetGroup(@RequestParam String id, String org, String orgDiv) {
		logger.info("Method : approveAssetGroup starts");

		logger.info("Method : approveAssetGroup ends");
		return assetGroupingRestDao.approveAssetGroup(id, org, orgDiv);

	}
	@RequestMapping(value = "rest-asset-group-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAssetGroup(@RequestParam String id, String org, String div) {
		logger.info("Method : deleteAssetGroup starts");

		logger.info("Method : deleteAssetGroup ends");
		return assetGroupingRestDao.deleteAssetGroup(id, org, div);

	}
}
