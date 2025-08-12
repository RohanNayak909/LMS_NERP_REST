package nirmalya.aatithya.restmodule.master.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nirmalya.aatithya.restmodule.common.utils.JsonResponse;
import nirmalya.aatithya.restmodule.master.dao.RestAssetDao;

import nirmalya.aatithya.restmodule.master.model.RestAssetModel;


@RestController
@RequestMapping(value = "master/")
public class RestAssetClassificationController {
	Logger logger = LoggerFactory.getLogger(RestAssetClassificationController.class);

	@Autowired
	RestAssetDao restAssetDao;

	@RequestMapping(value = "saveAssetClassification", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestAssetModel>> saveAssetClassification(
			@RequestBody RestAssetModel classification) {
		logger.info("Method : saveAssetClassification starts");

		logger.info("Method : saveAssetClassification ends");
		return restAssetDao.saveAssetClassification(classification);
	}

	@RequestMapping(value = "getAllAssetList", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<List<RestAssetModel>>> getAllAssetList() {
		logger.info("Method : getAllAssetList starts");

		logger.info("Method : getAllAssetList ends");
		return restAssetDao.getAllAssetList();
	}

	@RequestMapping(value = "saveAssetSubCategory", method = { RequestMethod.POST })
	public ResponseEntity<JsonResponse<RestAssetModel>> saveAssetSubCategory(@RequestBody RestAssetModel category) {
		logger.info("Method : saveAssetSubCategory starts");

		logger.info("Method : saveAssetSubCategory ends");
		return restAssetDao.saveAssetSubCategory(category);
	}

	@RequestMapping(value = "getAssetById", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<RestAssetModel>> getAssetById(@RequestParam String id) {
		logger.info("Method : getAssetById starts");

		logger.info("Method : getAssetById ends");
		return restAssetDao.getAssetById(id);
	}

	@RequestMapping(value = "deleteAsset", method = { RequestMethod.GET })
	public ResponseEntity<JsonResponse<Object>> deleteAsset(@RequestParam String id, @RequestParam String createdBy) {
		logger.info("Method : deleteAsset starts");

		logger.info("Method : deleteAsset ends");
		return restAssetDao.deleteAsset(id, createdBy);
	}
}
