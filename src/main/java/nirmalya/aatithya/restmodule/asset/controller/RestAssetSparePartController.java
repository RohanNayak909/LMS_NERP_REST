package nirmalya.aatithya.restmodule.asset.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.asset.dao.RestAssetSparePartDao;
import nirmalya.aatithya.restmodule.common.utils.DropDownModel;
import nirmalya.aatithya.restmodule.common.utils.JsonResponse;

@RestController
@RequestMapping(value = { "asset/" })
public class RestAssetSparePartController {
	
	Logger logger = LoggerFactory.getLogger(RestAssetSparePartController.class);

	@Autowired
	RestAssetSparePartDao restAssetSparePartDao;

	
	
	@GetMapping(value = "rest-viewSparePartList")
	public JsonResponse<Object> viewSparePartList(@RequestParam String org, @RequestParam String orgDiv) {
		logger.info("Method :viewSparePartList start");
		
		logger.info("Method :viewSparePartList ends");
		return restAssetSparePartDao.viewSparePartList(org, orgDiv);
		
	}
	
	@GetMapping(value = "rest-viewSparePartList-search")
	public JsonResponse<Object> viewSparePartListSearch(@RequestParam String org, @RequestParam String orgDiv ,@RequestParam String searchVal) {
		logger.info("Method :viewSparePartList start");
		
		logger.info("Method :viewSparePartList ends");
		return restAssetSparePartDao.viewSparePartListSearch(org, orgDiv,searchVal);
		
	}
	@GetMapping(value = "getAssetList")
	public List<DropDownModel> getAssetList(@RequestParam String org, @RequestParam String orgDiv,@RequestParam String userId) {
		logger.info("Method : getAssetList starts");

		logger.info("Method : getAssetList ends");
		return restAssetSparePartDao.getAssetList(org, orgDiv,userId);
	}
}
