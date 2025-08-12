package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.AssetMasterDataDao;
import nirmalya.aatithya.restmodule.asset.model.AssetMasterDataRestModel;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
 
 
@RestController
@RequestMapping(value = "asset/")
public class AssetMasterDataRestController {
	Logger logger = LoggerFactory.getLogger(AssetMasterDataRestController.class);
	@Autowired
	AssetMasterDataDao restDropdownMasterDao;
	
	@RequestMapping(value = "/assetCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> assetCategoryList() {
		logger.info("Method : assetCategoryList starts");

		logger.info("Method : assetCategoryList end");
		return restDropdownMasterDao.assetCategoryList();
	}
	
	@RequestMapping(value = "/assetSpCategoryList", method = { RequestMethod.GET })
	public List<DropDownModel> assetSpCategoryList() {
		logger.info("Method : assetSpCategoryList starts");

		logger.info("Method : assetSpCategoryList end");
		return restDropdownMasterDao.assetSpCategoryList();
	}
	
	
	@RequestMapping(value = "rest-manage-addAsset", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<Object>> addAsset(@RequestBody AssetMasterDataRestModel assetMaster) {
		logger.info("Method : addAsset starts");
		 
		logger.info("Method : addAsset  ends");
		return restDropdownMasterDao.addAsset(assetMaster);
	}
	@GetMapping(value = "rest-manage-getAsset")
	public JsonResponse<Object> getAsset(@RequestParam String type) {
		logger.info("Method : getAsset starts");
		logger.info("Method :getAsset endss");
		return restDropdownMasterDao.getAsset(type);
	}
	
	@RequestMapping(value = "manage-asset-data-delete", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAsset(@RequestParam String type,@RequestParam String id) {
		logger.info("Method : deleteAsset starts");

		logger.info("Method :  deleteAsset ends");
		return restDropdownMasterDao.deleteAsset(type,id);
	}
}
